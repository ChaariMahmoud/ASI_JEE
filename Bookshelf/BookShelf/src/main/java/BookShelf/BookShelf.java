package BookShelf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookShelf {

    private List<String> books = new ArrayList<>();

    public boolean isEmpty() {
        return books.isEmpty();
    }

    public int numberOfBooks() {
        return books.size();
    }

    public void addBooks(String... bookTitles) {
        Collections.addAll(books, bookTitles);
    }

    public List<String> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public void arrangeByTitle() {
        Collections.sort(books);
    }

    public List<String> getInsertionOrder() {
        return new ArrayList<>(books);
    }
}
