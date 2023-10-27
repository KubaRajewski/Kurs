package testy.test3.zadanie2.test.classes;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Car implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int year;
    private String brand;
    private String model;
    private final double price;
    private final LocalDate date;
    private final boolean aBoolean;

    public Car(int year, String brand, String model, double price, LocalDate date, boolean aBoolean) {
        this.year = year;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.date = date;
        this.aBoolean = aBoolean;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "year=" + year +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", aBoolean=" + aBoolean +
                '}';
    }
}
