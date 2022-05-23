package ru.netology.domain;

public class Smartphone extends Product {
    protected String manufacturer;

    //конструкторы
    public Smartphone() {
    }

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    //getter and setter
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
