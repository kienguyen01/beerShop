package nl.inholland.demo.model;

import java.util.UUID;

public class Beer {
    private UUID uuid;
    private String brand;
    private Integer volume;
    private Double price;

    public Beer(String brand, Integer volume, Double price) {
        this.uuid = UUID.randomUUID();
        this.brand = brand;
        this.volume = volume;
        this.price = price;
    }


    public UUID getUuid() {
        return uuid;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "uuid=" + uuid +
                ", brand='" + brand + '\'' +
                ", volume=" + volume +
                ", price=" + price +
                '}';
    }



}
