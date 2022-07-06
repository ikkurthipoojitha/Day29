package org.example.AddressBook;

import com.opencsv.bean.CsvBindByName;

public class CSVUser {

    @CsvBindByName
    private String Firstname;

    @CsvBindByName
    private String email;

    @CsvBindByName
    private String phone;

    @CsvBindByName
    private String lastName;

    @CsvBindByName
    private String state;

    @CsvBindByName
    private String city;

    @CsvBindByName
    private String zipcode;

    public CSVUser() {
    }

    public CSVUser(String firstname, String lastName, String state, String city, String email, String phone, String zipcode) {
        Firstname = firstname;
        this.email = email;
        this.phone = phone;
        this.lastName = lastName;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        this.Firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "CSVUser{" +
                "Firstname='" + Firstname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", lastName='" + lastName + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }


}
