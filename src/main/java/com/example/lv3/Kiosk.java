package com.example.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private List<MenuItem> menuItems = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    MenuItem menuItem = new MenuItem();

    public Kiosk() {
        menuItems.add(new MenuItem("ShackBurger   ",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack    ",8.9 ,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger  ",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger     ",5.4 ,"비프패티를 기반으로 야채가 들어간 기본버거"));
    }
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        while (true) {
            try {

                System.out.println("쉐이크쉑 메뉴");
                System.out.println("어떤 메뉴를 선택하시겠습니까?");
                for (int i = 0; i < menuItems.size(); i++) {
                    System.out.println((i + 1) + ". " + menuItems.get(i).getName() + "| " + "W ." + menuItems.get(i).getPrice() + "| " + menuItems.get(i).getExplain());
                }
                System.out.println("0. 종료      | 종료");
                String a = sc.next();
                if (a.equals("0")) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (a.equals("1")) {
                    System.out.println("1. " + menuItems.get(0).getName() + "| " + "W ." + menuItems.get(0).getPrice() + "| " + menuItems.get(0).getExplain());
                } else if (a.equals("2")) {
                    System.out.println("2. " + menuItems.get(1).getName() + "| " + "W ." + menuItems.get(1).getPrice() + "| " + menuItems.get(1).getExplain());
                } else if (a.equals("3")) {
                    System.out.println("3. " + menuItems.get(2).getName() + "| " + "W ." + menuItems.get(2).getPrice() + "| " + menuItems.get(2).getExplain());
                } else if (a.equals("4")) {
                    System.out.println("4. " + menuItems.get(3).getName() + "| " + "W ." + menuItems.get(3).getPrice() + "| " + menuItems.get(3).getExplain());
                } else throw new MenuException();

            } catch (MenuException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<MenuItem> getMenuItems () {
        return menuItems;
    }

    public void setMenuItems (List < MenuItem > menuItems) {
        this.menuItems = menuItems;
    }
}
