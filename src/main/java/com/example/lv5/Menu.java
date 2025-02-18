package com.example.lv5;


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

    // setter 생성
    public void setMainMenu(String mainMenu) {
        this.mainMenu = mainMenu;
    }

    // List에 들어있는 MenuItem을 순차적으로 보여주는 함수
    // List를 리턴하는 함수
    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    // 서브 메뉴 정보 리스트 저장
    public void addMenuItemList(MenuItem subMenu){
        menuItemList.add(subMenu);
    }
}
