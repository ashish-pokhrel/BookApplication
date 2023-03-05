package customers.domain;

import org.springframework.data.mongodb.core.mapping.Document;

public class Address {

    private String zip;
    private String street;
    private String city;

    public Address(String zip, String street, String city) {
        this.zip = zip;
        this.street = street;
        this.city = city;
    }



    @Override
    public String toString() {
        return "Address{" +
                "zip='" + zip + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}
