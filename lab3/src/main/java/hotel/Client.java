package hotel;

public class Client {

    private String firstName;
    private String lastName;
    private String document;
    private String phone;

    public Client(){

    }

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
