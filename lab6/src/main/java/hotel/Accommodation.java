package hotel;

import annotations.Column;
import annotations.Entity;

@Entity
public class Accommodation {

    @Column
    private int numberOfBed;
    @Column
    private int price;
    @Column
    private String comfortable;

    public Accommodation(int numberOfBed, int price, String comfortable){
        this.numberOfBed = numberOfBed;
        this.price = price;
        this.comfortable = comfortable;
    }

    public int getNumberOfBed() {
        return numberOfBed;
    }

    public void setNumberOfBed(int numberOfBed) {
        this.numberOfBed = numberOfBed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getComfortable() {
        return comfortable;
    }

    public void setComfortable(String comfortable) {
        this.comfortable = comfortable;
    }
}
