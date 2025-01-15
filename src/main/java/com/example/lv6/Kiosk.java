package com.example.lv6;


import java.util.Scanner;


public class Kiosk {
    private Scanner sc = new Scanner(System.in);
    private BurgerMenu burgerMenu = new BurgerMenu();
    private MainMenu mainMenu = new MainMenu();
    private OrderMenu orderMenu = new OrderMenu();

    public void start() {
        while (true) {
            try {
                System.out.println("[ MAIN MENU ]");
                for (int i = 0; i < mainMenu.getMenuItems().size(); i++) {
                    System.out.println((i + 1) + ". " + mainMenu.getMenuItems().get(i).getName());
                }
                System.out.println("0. 종료");
                System.out.println(" ");
                System.out.println("[ ORDER MENU ]");
                for (int i = 0; i < orderMenu.getMenuItems().size(); i++) {
                    System.out.println((i + 4) + ". " + burgerMenu.getMenuItems().get(i).getName() + "| " + "W ." + burgerMenu.getMenuItems().get(i).getPrice() + "| " + burgerMenu.getMenuItems().get(i).getExplain());
                }
                String b = sc.next();
                if (b.equals("1")) {
                    System.out.println("[SHAKESHACK MENU]");
                    System.out.println("어떤 메뉴를 선택하시겠습니까?");
                    for (int i = 0; i < burgerMenu.getMenuItems().size(); i++) {
                        System.out.println((i + 1) + ". " + burgerMenu.getMenuItems().get(i).getName() + "| " + "W ." + burgerMenu.getMenuItems().get(i).getPrice() + "| " + burgerMenu.getMenuItems().get(i).getExplain());
                    }
                    System.out.println("0. 뒤로가기");

                    String a = sc.next();
                    if (a.equals("0")) {
                        continue;
                    } else if (a.equals("1")) {
                        System.out.println("선택한 메뉴: " + burgerMenu.getMenuItems().get(0).getName() + "| " + "W ." + burgerMenu.getMenuItems().get(0).getPrice() + "| " + burgerMenu.getMenuItems().get(0).getExplain());
                        System.out.println(" ");
                    } else if (a.equals("2")) {
                        System.out.println("선택한 메뉴: " + burgerMenu.getMenuItems().get(1).getName() + "| " + "W ." + burgerMenu.getMenuItems().get(1).getPrice() + "| " + burgerMenu.getMenuItems().get(1).getExplain());
                        System.out.println(" ");
                    } else if (a.equals("3")) {
                        System.out.println("선택한 메뉴: " + burgerMenu.getMenuItems().get(2).getName() + "| " + "W ." + burgerMenu.getMenuItems().get(2).getPrice() + "| " + burgerMenu.getMenuItems().get(2).getExplain());
                        System.out.println(" ");
                    } else if (a.equals("4")) {
                        System.out.println("선택한 메뉴: " + burgerMenu.getMenuItems().get(3).getName() + "| " + "W ." + burgerMenu.getMenuItems().get(3).getPrice() + "| " + burgerMenu.getMenuItems().get(3).getExplain());
                        System.out.println(" ");
                    } else throw new MenuException();

                } else if (b.equals("2")) {
                    System.out.println("죄송합니다. Drinks 메뉴는 아직 미구현입니다.");
                } else if (b.equals("3")) {
                    System.out.println("죄송합니다. Desserts 메뉴는 아직 미구현입니다.");
                } else if (b.equals("0")) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (b.equals("4")) {
                    System.out.println("[ Orders ]");
                    System.out.println();
                    System.out.println(" ");
                    System.out.println("[ Total ]");
                    System.out.println("W " + burgerMenu.getMenuItems().get(1).getPrice());
                    System.out.println("1. 주문      2. 메뉴판");
                    String c = sc.next();
                    if (c.equals("1")) {
                        System.out.println("주문이 완료되었습니다. 금액은 W " + burgerMenu.getMenuItems().get(1).getPrice() + " 입니다.");
                    }
                } else if (b.equals("5")) {
                    continue;
                } else throw new MenuException();
            } catch (MenuException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
