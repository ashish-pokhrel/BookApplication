package app;

import domain.Address;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import repositories.StudentRepository;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class StudentApplication implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // create student
        Student student = new Student(3001, "Siya Ram", 6412121212L, "siya@yahoo.com");
        Address address = new Address("51355", " new street", "Texas");

        student.setAddress(address);
        studentRepository.save(student);

        Student student1 = new Student(3002, "jiya ram", 6412121223L, "jiya@gmail.com");
        Address address1 = new Address("51511", "pld place", "CA");
        student1.setAddress(address1);
        studentRepository.save(student1);

        Student student2 = new Student(3003, "ham ti", 6412121224L, "ham@gmail.com");
        Address address2 = new Address("54554", "4th st", "NYC");
        student2.setAddress(address2);

        studentRepository.save(student2);

        Student student3 = new Student(3004, "toy mon", 6412121225L, "toy@outlook.com");
        Address address3 = new Address("53553", "new 5th st", "LA");
        student2.setAddress(address3);
        studentRepository.save(student3);

        // Get all students
        System.out.println("-----Get all students ------");
        System.out.println(studentRepository.findAll());

        System.out.println("------Find by name ------");
        System.out.println(studentRepository.findByname("jiya Ram"));

        System.out.println("----Find by phone ------");
        System.out.println(studentRepository.findByphonenumber(9818567980L));


        System.out.println("-------Find students with a city name -------");
        List<Student> customers = studentRepository.findStudentWithCity("NYC");
        for (Student stud : customers) {
            System.out.println(stud);
        }

        System.out.println("-----------Get customer by Id ----------------");
        System.out.println(studentRepository.findById(3001).get());
        System.out.println(studentRepository.findById(3002).get());

        // update
        Student updateStudent = studentRepository.findById(3001).get();
        updateStudent.setEmail("myNewNAme@miu.com");
        studentRepository.save(updateStudent);

        System.out.println("-------Find by email -----");
        System.out.println(studentRepository.findStudentWithEmail("tom_kruise@gmail.com"));
    }

}
