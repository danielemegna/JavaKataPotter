import java.util.HashMap;

/**
 * Created by daniele on 12/05/15.
 */
public class BookBasket {

    private HashMap<String, Integer> booksMap = new HashMap<>();

    public BookBasket(String ... titles) {
        for(String title : titles)
            this.addBook(title);
    }

    public int getBookCount() {
        int count = 0;
        for(int n : this.booksMap.values())
            count += n;

        return count;
    }

    public int getTitlesVariety() {
        return this.booksMap.size();
    }


    private void addBook(String title) {
        int newValue = this.booksMap.containsKey(title) ?
            (this.booksMap.get(title) + 1) : 1;

        this.booksMap.put(title, newValue);
    }

    public boolean isEmpty() {
        return this.getBookCount() == 0;
    }

    public boolean hasOnlyOneTitleVariety() {
        return this.getTitlesVariety() == 1;
    }

    public boolean hasNoMultipleCopies() {
        return this.getTitlesVariety() == this.getBookCount();
    }
}
