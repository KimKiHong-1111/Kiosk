package com.example.lv6;

import java.util.ArrayList;
import java.util.List;

public class OrderMenu {
    private List<MenuItem> menuItems = new ArrayList<>();
    MenuItem menuItem = new MenuItem();

    public OrderMenu() {
        menuItems.add(new MenuItem("Orders       | 장바구니를 확인 후 주문합니다."));
        menuItems.add(new MenuItem("Cancel       | 진행중인 주문을 취소합니다."));

    }

    public OrderMenu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<MenuItem> getMenuItems () {
        return menuItems;
    }

    public void setMenuItems (List <MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
