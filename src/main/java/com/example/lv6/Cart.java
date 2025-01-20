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

    public void showCart() {
        if (menuItemList.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        } else {
            System.out.println("아래와 같이 주문 하시겠습니까?");
            System.out.println("[ 장바구니 ]");
            for (int i = 0; i < menuItemList.size(); i++) {
                MenuItem item = menuItemList.get(i);
                System.out.println((i + 1) + ". " + item.getName() + " | W " + item.getPrice() + " | " + item.getExplain());
            }
            System.out.println("총 가격: W " + getTotalPrice());
            System.out.println("1. 주문      2. 메뉴판");
        }
    }



    //장바구니 안에 물건 가격 총합
    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < menuItemList.size(); i++) {
            totalPrice += menuItemList.get(i).getPrice();
        }
        return totalPrice;
    }

}
