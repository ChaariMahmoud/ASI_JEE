package BookShelf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookShelfTest {

    private BookShelf bookShelf;

    @BeforeEach
    public void setUp() {
        bookShelf = new BookShelf();
    }

    @Test
    public void emptyBookShelfWhenNoBookAdded() {
        assertTrue(bookShelf.isEmpty());
    }

    @Test
    public void bookshelfContainsTwoBooksWhenTwoBooksAdded() {
        bookShelf.addBooks("Book 1", "Book 2");
        assertEquals(2, bookShelf.numberOfBooks());
    }

    @Test
    public void emptyBookShelfWhenAddIsCalledWithoutBooks() {
        bookShelf.addBooks();
        assertTrue(bookShelf.isEmpty());
    }

    @Test
    public void booksReturnedFromBookShelfIsImmutableForClient() {
        bookShelf.addBooks("Book 1", "Book 2");
        List<String> books = bookShelf.getBooks();
        try {
            books.add("Book 3"); // Try to modify the returned list
            fail("Expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            // Expected exception
        }
    }

    @Test
    public void bookshelfArrangedByBookTitle() {
        bookShelf.addBooks("C Book", "A Book", "B Book");
        List<String> expected = Arrays.asList("A Book", "B Book", "C Book");
        bookShelf.arrangeByTitle();
        assertEquals(expected, bookShelf.getBooks());
    }

    @Test
    public void booksInBookShelfAreInInsertionOrderAfterCallingArrange() {
        bookShelf.addBooks("C Book", "A Book", "B Book");
        List<String> insertionOrder = Arrays.asList("C Book", "A Book", "B Book");
        bookShelf.arrangeByTitle();
        assertEquals(insertionOrder, bookShelf.getInsertionOrder());
    }
}

