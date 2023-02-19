package books.controllers;

import books.models.Book;
import books.models.CustomError;
import books.services.IBookService;
import books.integration.JmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private JmsSender js;

    @GetMapping()
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getBook/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn) {
        Book book = bookService.getBook(isbn);
        if (book == null) {
            return new ResponseEntity<>(new CustomError("Book with isbn= "
                    + isbn + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        js.sendMessage(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        js.sendMessage(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn) {
        Book book = bookService.deleteBook(isbn);
        js.sendMessage(book);
        if (book == null) {
            return new ResponseEntity<>(new CustomError("Book with isbn = " + isbn + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
