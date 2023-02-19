package books.integration;

import books.models.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsSender {
    @Autowired(required = true)
    JmsTemplate jmsTemplate;

    public void sendMessage(Book book)  {
        try {
            //convert to JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            String contactString = objectMapper.writeValueAsString(book);
            System.out.println("JMS message:" + contactString);
            jmsTemplate.convertAndSend("testQueue", contactString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
