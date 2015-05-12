import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by daniele on 12/05/15.
 */
public class KataPotterTest {

    @Test
    public void basket_without_books__should_cost_zero() {
        assertEquals(0.0, basketCost(new String[]{}));
    }

    private double basketCost(String[] titles) {
        return 0;
    }
}
