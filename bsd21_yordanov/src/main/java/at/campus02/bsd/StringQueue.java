package at.campus02.bsd;
/**
 * DrinkQueue class
 * @author Tihomir Yordanov
 */
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// there's some Bugs included, try to debug the code and fix the Bugs
// there are different Bugs, wrong implementation, typos, ...
// write Test-Cases (read Queue Interface for understanding methods) and use Debugging possibilies of your IDE

/**
 * Public class String Queue
 */
public class StringQueue implements IQueue {

  private List<String> elements = new ArrayList<String>();
  private int maxSize = 5;

  /**
   * constructor for StringQueue
   * @param maxsize int
   */
  public StringQueue(int maxsize) {
    this.maxSize = maxsize;
  }

  /**
   * add object
   * @param obj
   * @return returns true if success
   */
  @Override
  public boolean offer(String obj) {
    if (elements.size() != maxSize)
      elements.add(obj);
    else
      return false;

    return true;
  }

  /**
   * @return and delete first element
   */
  @Override
  public String poll() {
    String element = peek();

    if (elements.size() > 0) {
      elements.remove(0);
    }

    return element;
  }

  /**
   * @return and del first element
   * @throws NoSuchElementException if no element
   */
  @Override
  public String remove() {
    String element = poll();
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

  /**
   * get the first element
   * if list is empty: return null
   * @return Object
   */
  @Override
  public String peek() {
    String element;
    if (elements.size() > 0)
      element = elements.get(0);
    else
      element = null;

    return element;
  }

  /**
   * get the first element
   * @return obj
   * @throws NoSuchElementException if no element
   */
  @Override
  public String element() {
    String element = peek();
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

}