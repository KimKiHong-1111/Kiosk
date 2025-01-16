package com.example.lv6;


import java.util.Scanner;


public class Kiosk {
    private Scanner sc = new Scanner(System.in);
    private MenuItem menuItem = new MenuItem();
    private BurgerMenu burgerMenu = new BurgerMenu();
    private MainMenu mainMenu = new MainMenu();
    private OrderMenu orderMenu = new OrderMenu();
    private Cart cart = new Cart();

    public void start() {
        if (cart.menuItemList.isEmpty()) {
            while (true) {
                displayMainMenu();
                String input = sc.next();
                int mainChoice;
                try {
                    mainChoice = Integer.parseInt(input);
                } catch (MenuException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                switch (mainChoice) {
                    case 1:
                        displayBurgerMenu();
                        break;
                    case 2:
                        System.out.println("죄송합니다. Drinks 메뉴는 아직 미구현입니다.");
                        break;
                    case 3:
                        System.out.println("죄송합니다. Desserts 메뉴는 아직 미구현입니다.");
                        break;
                    case 0:
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 확인해주세요.");
                }


                String b = sc.next();
                int choice;
                try {
                    choice = Integer.parseInt(b);
                    if (choice == 0) return;
                    MenuItem selectedItem = burgerMenu.getMenuItems().get(choice - 1);
                    System.out.println("선택한 메뉴: " + selectedItem.getName() + "| " + "W ." + selectedItem.getPrice() + "| " + selectedItem.getExplain());
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");
                    String answer = sc.next();
                    if (answer.equals("1")) {
                        cart.menuItemList.add(selectedItem);
                        System.out.println(selectedItem.getName() + "이 장바구니에 추가되었습니다.");
                    }
                } catch (MenuException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            while (true) {
                System.out.println("아래 메뉴판을 보시고 메늏를 골라 입력해주세요.");
                displayMainMenu();
                displayOrderMenu();

                String input = sc.next();
                int mainChoice;
                try {
                    mainChoice = Integer.parseInt(input);
                } catch (MenuException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                switch (mainChoice) {
                    case 1:
                        displayBurgerMenu();
                        break;
                    case 2:
                        System.out.println("죄송합니다. Drinks 메뉴는 아직 미구현입니다.");
                        break;
                    case 3:
                        System.out.println("죄송합니다. Desserts 메뉴는 아직 미구현입니다.");
                        break;
                    case 4:
                        System.out.println("아래와 같이 주문 하시겠습니까?");
                        System.out.println("[ Orders ]");
                        System.out.println(cart.menuItemList.get(0).getName() + " | W " + cart.getMenuItemList().get(0).getPrice() + " | " + cart.menuItemList.get(0).getExplain());
                        System.out.println("[ Total ]");
                        System.out.println("W " + cart.getMenuItemList().get(0).getPrice());
                        System.out.println("1. 주문      2. 메뉴판");
                        String order = sc.next();
                        if (order.equals("1")) {
                            System.out.println("주문이 완료되었습니다. 금액은  W " + cart.getMenuItemList().get(0).getPrice() + " 입니다.");
                        } else {
                            throw new MenuException();
                        }
                    case 0:
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 확인해주세요.");
                }


                String b = sc.next();
                int choice;
                try {
                    choice = Integer.parseInt(b);
                    if (choice == 0) return;
                    MenuItem selectedItem = burgerMenu.getMenuItems().get(choice - 1);
                    System.out.println("선택한 메뉴: " + selectedItem.getName() + "| " + "W ." + selectedItem.getPrice() + "| " + selectedItem.getExplain());
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");
                    String answer = sc.next();
                    if (answer.equals("1")) {
                        cart.menuItemList.add(selectedItem);
                        System.out.println(selectedItem.getName() + "이 장바구니에 추가되었습니다.");
                    }
                } catch (MenuException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < mainMenu.getMenuItems().size(); i++) {
            System.out.println((i + 1) + ". " + mainMenu.getMenuItems().get(i).getName());
        }
        System.out.println("0. 종료");

    }

    private void displayOrderMenu() {
        System.out.println("[ ORDER MENU ]");
        for (int i = 0; i < orderMenu.getMenuItems().size(); i++) {
            System.out.println((i + 4) + ". " + orderMenu.getMenuItems().get(i).getName());
        }
    }

    private void displayBurgerMenu () {
        System.out.println("[SHAKESHACK MENU]");
        System.out.println("어떤 메뉴를 선택하시겠습니까?");
        for (int i = 0; i < burgerMenu.getMenuItems().size(); i++) {
            System.out.println((i + 1) + ". " + burgerMenu.getMenuItems().get(i).getName() + "| " + "W ." + burgerMenu.getMenuItems().get(i).getPrice() + "| " + burgerMenu.getMenuItems().get(i).getExplain());
        }
        System.out.println("0. 뒤로가기");
    }
}