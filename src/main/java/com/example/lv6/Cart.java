package com.example.lv6;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<MenuItem> menuItemList = new ArrayList<>();

    public Cart() {

    }

    public Cart(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }
}
