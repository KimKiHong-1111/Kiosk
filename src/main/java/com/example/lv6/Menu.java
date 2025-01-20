package com.example.lv6;


import java.util.ArrayList;
import java.util.List;

public class Menu {

    private final List<MenuItem> menuItemList = new ArrayList<>();
    private String mainMenu;

    Menu(String mainMenu){
        this.mainMenu = mainMenu;
    }

    public String getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(String mainMenu) {
        this.mainMenu = mainMenu;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    // 서브 메뉴 정보 리스트 저장
    public void addMenuItemList(MenuItem subMenu){
        menuItemList.add(subMenu);
    }
}
