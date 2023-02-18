package books.services;
import books.models.Book;
import java.util.List;

public interface IBookService {

    void addBook(Book book);
    void updateBook(Book book);
    Book deleteBook(String isbn);
    Book getBook(String isbn);
    List<Book> getAllBooks();
}
