import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by daniele on 12/05/15.
 */
public class KataPotterTest {

    @Test
    public void basket_without_books__should_cost_zero() {
        assertBasketCost(0.0);
    }

    @Test
    public void basket_with_a_books__cost_eight() {
        assertBasketCost(8.0, "Philosophers Stone");
        assertBasketCost(8.0, "Chamber of Secrets");
        assertBasketCost(8.0, "Prisoner of Azkaban");
    }

    private void assertBasketCost(double expectedCost, String ... titles) {
        assertEquals(expectedCost, basketCost(titles));
    }

    @Test
    public void multiple_copies_of_same_title__has_no_discount() {
        assertBasketCost(8 * 2,
            "Philosophers Stone",
            "Philosophers Stone"
        );

        assertBasketCost(8 * 3,
            "Chamber of Secrets",
            "Chamber of Secrets",
            "Chamber of Secrets"
        );

        assertBasketCost(8 * 2,
            "Prisoner of Azkaban",
            "Prisoner of Azkaban"
        );
    }



    private double basketCost(String[] titles) {
        if(titles.length > 0)
            return (8 * titles.length);

        return 0;
    }
}
