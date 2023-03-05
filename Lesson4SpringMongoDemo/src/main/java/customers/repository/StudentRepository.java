package customers.repository;

import customers.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {

    Student findByphonenumber(long phonenumber);

    Student findByName(String name);
    // List<Student> findByNameOrPhone(String name, String phone);

    @Query("{email : ?0}")
    Student findStudentWithEmail(String email);

    @Query("{'address.city' : ?0}")
    List<Student> findStudentWithCity(String city);
}
