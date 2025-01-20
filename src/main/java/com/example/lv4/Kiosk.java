package com.example.lv4;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Kiosk {
    private Scanner sc = new Scanner(System.in);
    List<Menu> mainMenu = new ArrayList<>();

    public void add(Menu menu) {
        mainMenu.add(menu);
    }

    public void start() {
        while (true) {
            try {
                System.out.println("[MAIN MENU]");
                for (int i = 0; i < mainMenu.size(); i++) {
                    System.out.println((i + 1) + ". " + mainMenu.get(i).getMainMenu());
                }
                System.out.println("0. 종료");
                int input = Integer.parseInt(sc.nextLine());
                if (input < 0|| input > mainMenu.size() -1) {
                    throw new MenuException();
                }

                List<MenuItem> subMenu = mainMenu.get(input-1).getMenuItemList();
                System.out.println("[ " + mainMenu.get(input-1).getMainMenu().toUpperCase()+" MENU ]");

                for (MenuItem menuItem : subMenu) {
                    System.out.println(subMenu.indexOf(menuItem) + 1 + ". "
                            + menuItem.getName() + " |"
                            + menuItem.getPrice() + " |"
                            + menuItem.getExplain());

                }
                System.out.println("프로그램을 종료합니다.");
                break;
            } catch (MenuException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
