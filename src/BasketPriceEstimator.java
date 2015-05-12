import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by daniele on 12/05/15.
 */
public class BasketPriceEstimator {

    private final HashMap<Integer, Double> discountsMap = new HashMap<Integer, Double>() {{
        put(1,0.0);
        put(2,0.05);
        put(3,0.10);
        put(4,0.20);
        put(5,0.25);
    }};

    public double estimate(String[] titles) {
        if(titles.length == 0)
            return 0;

        double basePrice = (8 * titles.length);
        int titlesVariety = new HashSet<>(Arrays.asList(titles)).size();

        if(titlesVariety != titles.length)
            return basePrice;

        double discountQuote = this.discountsMap.get(titlesVariety);
        return basePrice * (1 - discountQuote);
    }

}
