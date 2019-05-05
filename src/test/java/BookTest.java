import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BookTest {

    @Test(expected = IllegalArgumentException.class)
    public void 페이지제로Test() {
        Book book = new Book("Zero",0,"김제로");

        assertThat(book.getPages(),is(0));
    }

    @Test
    public void 북마크_추가삭제_호출Test() {
        Book book = mock(Book.class);

        book.addBookMark(300);
        verify(book).addBookMark(300);

        book.removeBookMark(300);
        verify(book).removeBookMark(300);
    }

   @Test
    public void 명대사체크Test() {
        Book book = mock(Book.class);
        when(book.checkFamousLine("길도")).thenReturn("길도는 귀여운 고양이");
        assertThat(book.checkFamousLine("길도"),is("길도는 귀여운 고양이"));
    }


}