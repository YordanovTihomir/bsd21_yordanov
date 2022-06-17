package at.campus02.bsd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DrinkQueueTest {

    private DrinkQueue queue;
    private Liquid liquidNonAlc, liquidAlc;
    private SimpleDrink simpleDrinkNonAlc, simpleDrinkAlc;

    /**
     * Creates a setup, which is needed for the tests.
     * Create test-data
     */
    @BeforeEach
    public void setup() {
        queue = new DrinkQueue();
        liquidNonAlc = new Liquid("Cola", 500, 0);
        liquidAlc = new Liquid("Vodka", 50, 40);
        simpleDrinkNonAlc = new SimpleDrink("CocaCola", liquidNonAlc);
        simpleDrinkAlc = new SimpleDrink("Vodka", liquidAlc);
    }

    /**
     * checks liquids
     */
    @Test
    void testLiquid() {
        Assertions.assertEquals(50, liquidAlc.getVolume());
        Assertions.assertEquals("Cola", liquidNonAlc.getName());
        Assertions.assertEquals(0, liquidNonAlc.getAlcoholPercent());
        liquidNonAlc.setName("Soda");
        Assertions.assertEquals("Soda", liquidNonAlc.getName());
        liquidAlc.setVolume(60);
        Assertions.assertEquals(60, liquidAlc.getVolume());
        liquidAlc.setAlcoholPercent(30);
        Assertions.assertEquals(30, liquidAlc.getAlcoholPercent());
        Assertions.assertTrue(simpleDrinkAlc.isAlcoholic());
        Assertions.assertEquals(0, simpleDrinkNonAlc.getAlcoholPercent());
        Assertions.assertFalse(simpleDrinkNonAlc.isAlcoholic());
    }

    @Test
    void offer() {
        assertTrue(queue.offer(liquidAlc));
        assertTrue(queue.offer(liquidNonAlc));
        assertTrue(queue.offer(liquidAlc));
        assertTrue(queue.offer(liquidNonAlc));
        assertTrue(queue.offer(liquidNonAlc));
        assertFalse(queue.offer("too much"));
    }

    /**
     * Adding and removing element
     */
    @Test
    void poll() {
        queue.offer(liquidNonAlc);
        assertEquals(liquidNonAlc, queue.poll());
        assertNull(queue.poll());
    }

    /**
     * Adding and removing element
     */
    @Test
    public void remove() {
        queue.offer(liquidNonAlc);
        assertEquals(liquidNonAlc, queue.remove());
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            queue.remove();
        });
        String expectedMessage = "there's no element any more";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void peek() {
        queue.offer(liquidNonAlc);
        queue.offer(liquidAlc);
        queue.offer(liquidAlc);
        assertEquals(liquidNonAlc, queue.peek());
    }

    /**
     * Getting element from an empty queue
     */
    @Test
    void element() {
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            queue.element();
        });
        String expectedMessage = "there's no element any more";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

        queue.offer(liquidNonAlc);
        assertEquals(liquidNonAlc, queue.element());
    }
}