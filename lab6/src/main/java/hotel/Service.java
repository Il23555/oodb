package hotel;

import annotations.Column;
import annotations.Entity;

@Entity
public class Service {
    @Column
    private String name;
    @Column
    private int price;

    public Service(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
