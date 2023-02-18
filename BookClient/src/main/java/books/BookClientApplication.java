package books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

public class BookClientApplication implements CommandLineRunner {
    @Autowired
    private RestOperations restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(BookClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String serverURL = "http://localhost:8080/books";

        restTemplate.postForLocation(serverURL, new Book("CS404", "Ashish Pokhrel", "Software Architecture", 202));

        restTemplate.postForLocation(serverURL, new Book("C545", "Rene De Young", "Advance Software Design", 480.23));

        String url =serverURL + "/getBook/{isbn}";
        Book book = restTemplate.getForObject(serverURL + "/getBook/{isbn}", Book.class, "CS404");
        System.out.println("-------------------Get SA COURSE---------------------");
        System.out.println(book.getIsbn() + " " + book.getTitle());
        System.out.println();

        Books books = restTemplate.getForObject(serverURL, Books.class);
        System.out.println("-------------------Get ALL ---------------------");
        System.out.println(books);
        System.out.println();

        restTemplate.delete(serverURL + "/delete/{isbn}", "CS404");
        System.out.println("Software architecture successfully deleted");
        System.out.println();

        book.setTitle("Enterprise architecture");
        restTemplate.put(serverURL + "/", book, book.getIsbn());
        System.out.println("Software architecture to Enterprise architecture updated successfully");
        System.out.println();

        books = restTemplate.getForObject(serverURL + "/", Books.class);
        System.out.println("-------------------Get ALL---------------------");
        System.out.println(books);
    }

    @Bean
    RestOperations restTemplate() {
        return new RestTemplate();
    }
}

