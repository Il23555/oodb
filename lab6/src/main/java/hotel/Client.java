package hotel;

import annotations.Column;
import annotations.Entity;

@Entity
public class Client {

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String document;
    @Column
    private String phone;

    public Client(String firstName, String lastName, String document, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String toString(){
        return this.getLastName() + " " + this.getFirstName() + " "  + this.document+ " "  + this.phone;
    }
}
