import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by daniele on 12/05/15.
 */
public class KataPotterTest {

    @Test
    public void basket_without_books__should_cost_zero() {
        assertEquals(0.0, basketCost(new String[]{}));
    }

    @Test
    public void basket_with_a_books__cost_eight() {
        assertEquals(8.0, basketCost(new String[]{ "Philosophers Stone" }));
        assertEquals(8.0, basketCost(new String[]{ "Chamber of Secrets" }));
        assertEquals(8.0, basketCost(new String[]{ "Prisoner of Azkaban" }));
    }

    private double basketCost(String[] titles) {
        if(titles.length > 0)
            return 8;

        return 0;
    }
}
