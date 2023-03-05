package domain;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class Student {
    @Id

    private int student_id;
    private String name;
    private long phonenumber;
    private String email;

    @ManyToOne (cascade = CascadeType.ALL )
    private Address address;

    public Student() {
    }

    public Student(int student_id, String name, long phonenumber, String email) {
        this.student_id = student_id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", phonenumber=" + phonenumber +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
