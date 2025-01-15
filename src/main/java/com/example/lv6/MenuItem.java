package com.example.lv6;

public class MenuItem {
    private String name;
    private double price;
    private String explain;

    public MenuItem() {
    }

    public MenuItem(String name) {
        this.name = name;
    }
    public MenuItem(String name, double price, String explain) {
        this.name = name;
        this.price = price;
        this.explain = explain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

}
