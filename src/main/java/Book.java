import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String ISBN;
    private int pages;
    private String author;
    private List<Integer> bookMarks;
    private List<String> famousLines;

    public Book(String title, int pages, String author) {
        this.title = title;
        this.pages = pages;
        this.author = author;

        if(pages <= 0){
            throw new IllegalArgumentException();
        }
    }

    public void addBookMark(int page) {
        bookMarks.add(page);
    }

    public void removeBookMark(int page) {
        bookMarks.remove(page);
    }

    public String checkFamousLine(String famousLine) {
        famousLines.add(famousLine);
        return famousLine;
    }
}
