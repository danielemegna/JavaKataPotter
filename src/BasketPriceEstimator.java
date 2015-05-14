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
        if(basket.isEmpty())
            return 0;

        if(basket.hasOnlyOneTitleVariety())
            return (this.BOOKS_PRICE * basket.getBookCount());

        if(basket.hasNoMultipleCopies()) {
            return estimateSerieBlock(basket.getTitlesVariety());
        }

        double result = estimateSerieBlock(basket.getTitlesVariety());
        return result + this.BOOKS_PRICE * (basket.getBookCount() - basket.getTitlesVariety());
    }

    private double estimateSerieBlock(int numberOfBooks) {
        double basePrice = (this.BOOKS_PRICE * numberOfBooks);
        double discountQuote = this.discountsMap.get(numberOfBooks);
        return basePrice * (1 - discountQuote);
    }

}
