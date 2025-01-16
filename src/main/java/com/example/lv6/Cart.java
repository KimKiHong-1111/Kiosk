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

    //장바구니 목록 반환
    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }
    //장바구니 비우기
    public void clear() {
        menuItemList.clear();
    }
    public void addItem(MenuItem item) {
        if (item != null) {
            menuItemList.add(item);
        }
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    //장바구니 안에 물건 가격 총합
    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < menuItemList.size(); i++) {
            totalPrice += menuItemList.get(i).getPrice();
        }
        return totalPrice;
    }

    public void showcart() {
        System.out.println();
    }
}
