import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LibraryTest {

    @Test
    public void addBookTest() {
        Library library = mock(Library.class);

        library.addBook(new Book("The Hobbit", 304, "J.R.R. Tolkien"));
        verify(library).addBook(new Book("The Hobbit", 304, "J.R.R. Tolkien"));
    }

    @Test
    public void verifyFindByTitle() {
        Library library = mock(Library.class);

        when(library.findByTitle("The Hobbit")).thenReturn(new Book("The Hobbit", 304, "J.R.R. Tolkien"));
        assertThat(library.findByTitle("The Hobbit"), is(new Book("The Hobbit", 304, "J.R.R. Tolkien")));
        verify(library).findByTitle(anyString());
    }

    @Test
    public void verifyFindByISBN() {    // ISBN으로 찾기 test
        Library library = mock(Library.class);

        when(library.findByISBN("9791162202913")).thenReturn(new Book("모든 순간이 너였다", 279, "하태완"));
        assertThat(library.findByISBN("9791162202913"), is(new Book("모든 순간이 너였다", 279, "하태완")));
        verify(library).findByISBN(anyString());
    }

    @Test
    public void checkLibrarySizeTwice() {
        Library library = new Library(new LinkedList<>());
        Library librarySpy = spy(library);

        librarySpy.addBook(new Book("Book1", 402, "John"));
        librarySpy.addBook(new Book("Book2", 505, "Doe"));

        int librarySizeTwice = librarySpy.size() + librarySpy.size();

        assertThat(librarySizeTwice, is(4));
        verify(librarySpy, times(2)).size();
    }
}