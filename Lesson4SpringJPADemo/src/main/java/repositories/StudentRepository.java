package repositories;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByname(String name);


    Student findByphonenumber(long phone);


    @Query("select c from Student c where c.email= :email")
    Student findStudentWithEmail(String email);


    @Query("select c from Student c where c.address.city= :city")
    List<Student> findStudentWithCity(String city);
}
