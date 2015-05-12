import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

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

    @Test
    public void two_different_titles__has_five_percent_discount() {
        assertBasketCost( ((8*2) * 0.95),
            "Philosophers Stone",
            "Chamber of Secrets"
        );

        assertBasketCost( ((8*2) * 0.95),
            "Prisoner of Azkaban",
            "Order of the Phoenix"
        );
    }

    @Test
    public void three_different_titles__has_ten_percent_discount() {
        assertBasketCost(((8*3) * 0.90),
            "Philosophers Stone",
            "Prisoner of Azkaban",
            "Order of the Phoenix"
        );
    }

    @Test
    @Ignore
    public void final_acceptance_test() {
        assertBasketCost(51.20,
            "Philosophers Stone", "Philosophers Stone",
            "Chamber of Secrets", "Chamber of Secrets",
            "Prisoner of Azkaban", "Prisoner of Azkaban",
            "The Goblet of Fire",
            "Order of the Phoenix"
        );
    }

    private double basketCost(String[] titles) {

        int titlesVariety = new HashSet<>(Arrays.asList(titles)).size();
        if(titlesVariety > 1 && titlesVariety == titles.length) {
            double discountQuote = (0.05 * (titlesVariety - 1));
            return (8 * titles.length * (1 - discountQuote));
        }

        return titles.length * 8;

    }
}
