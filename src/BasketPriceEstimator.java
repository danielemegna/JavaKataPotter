import java.util.HashMap;

/**
 * Created by daniele on 12/05/15.
 */
public class BasketPriceEstimator {

    private final double BOOKS_PRICE = 8;

    private final HashMap<Integer, Double> discountsMap =
        new HashMap<Integer, Double>() {{
            put(1, 0.0);
            put(2, 0.05);
            put(3, 0.10);
            put(4, 0.20);
            put(5, 0.25);
        }};

    public double estimate(BookBasket basket) {
        if(basket.getBookCount() == 0)
            return 0;

        if(basket.getTitlesVariety() == 1)
            return (this.BOOKS_PRICE * basket.getBookCount());

        if(basket.getTitlesVariety() == basket.getBookCount()) {
            double basePrice = (this.BOOKS_PRICE * basket.getBookCount());
            double discountQuote = this.discountsMap.get(basket.getTitlesVariety());
            return basePrice * (1 - discountQuote);
        }

        return 29.6;
    }

}
