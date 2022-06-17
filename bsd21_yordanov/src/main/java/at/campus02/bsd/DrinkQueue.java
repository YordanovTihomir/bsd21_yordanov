package at.campus02.bsd;

/**
 * DrinkQueue class
 * @author Tihomir Yordanov
 */
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Public class Drink Queue
 */
public class DrinkQueue implements DrinkQueueInterface{


    private List<Object> elements = new ArrayList<Object>();
    private int maxSize = 5;

    /**
     * constructor for DrinkQueue
     * @param maxsize int
     */
    public DrinkQueue(int maxsize) {
        this.maxSize = maxsize;
    }

    /**
     * add object
     * @param drink
     * @return returns true if success
     */
    @Override
    public boolean offer(Object drink) {
        if (elements.size() != maxSize)
            elements.add(drink);
        else
            return false;
        return true;
    }


    /**
     * @return and delete first element
     */
    @Override
    public Object poll() {
        Object element = peek();
        if (elements.size() != 0) {
            elements.remove(element);
        }
        return element;
    }

    /**
     * @return and del first element
     * @throws NoSuchElementException if no element
     */
    @Override
    public Object remove() {
        Object element = poll();
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
    public Object peek() {
        Object element;
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
    public Object element() {
        Object element = peek();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }
}
