package at.campus02.bsd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StringQueueTest {
    private StringQueue queue1;
    private StringQueue queue2;
    /**
     * setup which creates Stringqueue instance
     */
    @BeforeEach
    public void setup() {
        queue1 = new StringQueue(3);
    }

    @Test
    void offer() {
        assertTrue(queue1.offer("one"));
        assertTrue(queue1.offer("two"));
        assertTrue(queue1.offer("three"));
//        assertTrue(queue1.offer("four"));
//        assertTrue(queue1.offer("five"));
        assertFalse(queue1.offer("too much"));
    }

    /**
     * Adding and removing element
     */
    @Test
    void poll() {
        queue1.offer("element");
        Assertions.assertEquals("element", queue1.poll());
        assertNull(queue1.poll());
    }

    /**
     * Adding and removing element
     */
    @Test
    public void remove() {
        queue1.offer("element");
        Assertions.assertEquals("element", queue1.remove());
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            queue1.remove();
        });
        String expectedMessage = "there's no element any more";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void peek() {
        queue1.offer("element1");
        queue1.offer("element2");
        queue1.offer("element3");
        Assertions.assertEquals("element1", queue1.peek());
    }

    /**
     * Getting element from an empty queue
     */
    @Test
    void element() {
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            queue1.element();
        });
        String expectedMessage = "there's no element any more";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

        queue1.offer("element");
        Assertions.assertEquals("element", queue1.element());
    }
}