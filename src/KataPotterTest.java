import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by daniele on 12/05/15.
 */
public class KataPotterTest {

    private BasketPriceEstimator basketPriceEstimator;

    @Before
    public void setup()
    {
        this.basketPriceEstimator = new BasketPriceEstimator();
    }

    private void assertBasketCost(double expectedCost, String ... titles) {
        BookBasket basket = new BookBasket(titles);
        double estimate = this.basketPriceEstimator.estimate(basket);
        assertEquals(expectedCost, estimate);
    }

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
    public void four_different_titles__has_twenty_percent_discount() {
        assertBasketCost(((8*4) * 0.80),
            "Philosophers Stone",
            "Prisoner of Azkaban",
            "Chamber of Secrets",
            "Order of the Phoenix"
        );
    }

    @Test
    public void five_different_titles__has_twentyfive_percent_discount() {
        assertBasketCost(((8*5) * 0.75),
            "Philosophers Stone",
            "Prisoner of Azkaban",
            "Chamber of Secrets",
            "Order of the Phoenix",
            "The Goblet of Fire"
        );
    }

    @Test
    public void basket_with_onetitle_duplicated__testcase() {
        assertBasketCost((((8*3) * 0.90) + 8),
            "Prisoner of Azkaban", "Prisoner of Azkaban",
            "The Goblet of Fire",
            "Order of the Phoenix"
        );

        assertBasketCost((((8*3) * 0.90) + (8*2)),
            "Prisoner of Azkaban", "Prisoner of Azkaban", "Prisoner of Azkaban",
            "The Goblet of Fire",
            "Order of the Phoenix"
        );
    }

    @Test
    @Ignore
    public void basket_with_sometitle_duplicated__testcase() {

        assertBasketCost((((8*2)*0.95) + ((8*2)*0.95)),
            "Philosophers Stone", "Philosophers Stone",
            "Chamber of Secrets", "Chamber of Secrets"
        );

        assertBasketCost((((8*3)*0.90) + ((8*2)*0.95)),
            "Philosophers Stone",
            "Prisoner of Azkaban", "Prisoner of Azkaban",
            "The Goblet of Fire", "The Goblet of Fire"
        );

        assertBasketCost((((8*3)*0.90) + ((8*2)*0.95) + 8),
            "Philosophers Stone",
            "Prisoner of Azkaban", "Prisoner of Azkaban",
            "The Goblet of Fire", "The Goblet of Fire", "The Goblet of Fire"
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

}
