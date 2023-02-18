package books.repos;

import books.models.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class IBookRepo {
        private Map<String, Book> books = new HashMap<>();

        public IBookRepo() {
            books.put("100", new Book("200", "Ram pok", "Past Glimpse", 30));
            books.put("101", new Book("201", "Hari Tok", "Top of the Future", 400));
            books.put("102", new Book("302", "Shyam mok", "Structure algo", 440));
            books.put("103", new Book("203", "Rita dok", "Debugging Interview", 500));
            books.put("104", new Book("404", "Gitta gok", "Purano Ghar", 560));
        }

        public void addBook(Book book) {
            books.put(book.getIsbn(), book);
        }

        public void updateBook(Book book) {
            books.put(book.getIsbn(), book);
        }

        public Book deleteBook(String isbn) {
            Book book = books.get(isbn);
            if (book != null)
                books.remove(isbn);
            return book;
        }

        public Book getBook(String isbn) {
            return books.get(isbn);
        }

        public Map<String, Book> getAllBooks() {
            return books;
        }

}
