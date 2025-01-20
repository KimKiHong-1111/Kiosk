package com.example.lv6;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Kiosk {

    private Scanner sc = new Scanner(System.in);
    private Cart cart = new Cart();

    List<Menu> mainMenu = new ArrayList<>();

    public void add(Menu menu) {
        mainMenu.add(menu);
    }

    // 메인 실행 메서드
    public void start() {
        while (true) {
            try {
                printMainMenu(); // 메인 메뉴 출력
                int input = getUserInput();

                if (input == 0) { // 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (input == 4 && !cart.menuItemList.isEmpty()) {
                    cart.showCart();

                    orderCheck();
                    continue;
                } else if (input == 5 && !cart.menuItemList.isEmpty()) {
                    cart.clear();
                    System.out.println("장바구니가 초기화되었습니다.");
                    continue;
                }

                if (input < 1 || input > mainMenu.size()) throw new MenuException();

                List<MenuItem> subMenu = mainMenu.get(input - 1).getMenuItemList();
                printSubMenu(mainMenu.get(input - 1), subMenu);
                handleMenuSelection(subMenu);
            } catch (MenuException e) {
                System.out.println(e.getMessage());
            }
        }
    }



    //최종주문확인
    private void orderCheck () {
        int orderCheck = getUserInput();
        if (orderCheck == 1) {
            System.out.println("주문이 완료되었습니다. 금액은 W . " + cart.getTotalPrice() + "입니다.");
        } else if (orderCheck == 2) {
            return;
        } else throw new MenuException();
    }

    // 메뉴 선택 처리
    private void handleMenuSelection(List<MenuItem> subMenu) {
        while (true) {
            int choice = getUserInput();
            if (choice == 0) break;

            if (choice > 0 && choice <= subMenu.size()) {
                MenuItem selectedItem = subMenu.get(choice - 1);
                System.out.println("선택한 메뉴: " + selectedItem.getName() + " | W " + selectedItem.getPrice() + " | " + selectedItem.getExplain());
                System.out.println("이 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인    2. 취소");

                int confirmation = getUserInput();
                if (confirmation == 1) {
                    cart.addItem(selectedItem);
                    System.out.println(selectedItem.getName() + "이(가) 장바구니에 추가되었습니다.");
                    return;
                } else {
                    System.out.println("메뉴 추가를 취소했습니다.");
                }
            } else {
                System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }

    //메인메뉴출력
    private void printMainMenu() {
        System.out.println("[MAIN MENU]");
        for (int i = 0; i < mainMenu.size(); i++) {
            System.out.println((i + 1) + ". " + mainMenu.get(i).getMainMenu());
        }
        System.out.println("0. 종료");
        if (!cart.menuItemList.isEmpty()) {
            System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        }
    }

    //서브메뉴출력
    private void printSubMenu(Menu menu, List<MenuItem> subMenu) {
    System.out.println("[ " + menu.getMainMenu().toUpperCase() + " MENU ]");
    for (int i = 0; i < subMenu.size(); i++) {
        MenuItem item = subMenu.get(i);
        System.out.println((i + 1) + ". " + item.getName() + " | W " + item.getPrice() + " | " + item.getExplain());
    }
    System.out.println("0. 이전 메뉴로 돌아가기");
}


    // 사용자 입력 받기
    private int getUserInput () {
        while (true) {
            try {
                System.out.print("번호를 입력해주세요: ");
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }
}