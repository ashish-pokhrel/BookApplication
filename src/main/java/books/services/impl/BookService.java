package books.services.impl;

import books.models.Book;
import books.repos.IBookRepo;
import books.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepo bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    @Override
    public Book deleteBook(String isbn) {
        return bookRepository.deleteBook(isbn);
    }

    @Override
    public Book getBook(String isbn) {
        return bookRepository.getBook(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        Map<String, Book> books = bookRepository.getAllBooks();
        List<Book> bookList = new ArrayList<>();

        for (Map.Entry<String, Book> entries : books.entrySet()) {
            bookList.add(entries.getValue());
        }
        return bookList;
    }
}