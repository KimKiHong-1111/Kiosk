package com.example.lv6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Kiosk {


    private List<MenuItem> burgerMenu = new ArrayList<>();
    private List<MenuItem> drinksMenu = new ArrayList<>();
    private List<MenuItem> dessertMenu = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private Cart cart = new Cart();

    private List<List>MenuList = new ArrayList<>();

    public Kiosk() {
        initializeMenus();
    }

    public void MenuList() {
        MenuList.add(burgerMenu);
        MenuList.add(drinksMenu);
        MenuList.add(dessertMenu);
    }


    private void initializeMenus() {
        burgerMenu.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        drinksMenu.add(new MenuItem("코카콜라", 2.0, "코카콜라"));
        drinksMenu.add(new MenuItem("펩시콜라", 1.9, "펩시콜라"));
        drinksMenu.add(new MenuItem("펩시제로라임", 2.5, "펩시제로 라임맛"));
        drinksMenu.add(new MenuItem("코카콜라제로", 2.2, "코카콜라 제로"));

        dessertMenu.add(new MenuItem("아이스크림 콘", 0.5, "맛있는 아이스크림 콘"));
        dessertMenu.add(new MenuItem("초코 콘", 1.0, "맛있는 아이스크림 콘에 초코 코팅"));
        dessertMenu.add(new MenuItem("핫 아메리카노", 1.0, "핫아메"));
        dessertMenu.add(new MenuItem("라떼", 1.5, "달다구리한 라떼"));
    }

    // 메인 실행 메서드
    public void start() {
        while (true) {
            try {
                displayMainMenu();
                int mainChoice = getUserInput();
                if (mainChoice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
                switch (mainChoice) {
                    case 1 -> handleMenuSelection(burgerMenu, "버거 메뉴");
                    case 2 -> handleMenuSelection(drinksMenu, "음료 메뉴");
                    case 3 -> handleMenuSelection(dessertMenu, "디저트 메뉴");
                    case 4 -> {
                        if (!cart.menuItemList.isEmpty()) {
                            cart.showCart();
                            System.out.println("1. 주문      2. 메뉴판");
                            orderCheck();
                    } else throw new MenuException();
                        }
                    case 5 -> cart.clear();
                    default -> System.out.println("올바른 번호를 입력해주세요.");
                }

            } catch (Exception e) {
                System.out.println("오류가 발생했습니다: " + e.getMessage());
            }
        }
    }

    // 메인 메뉴 출력
    private void displayMainMenu() {
        System.out.println("[ MAIN MENU ]");
        System.out.println("1. Burgers");
        System.out.println("2. Drinks");
        System.out.println("3. Desserts");
        System.out.println("0. 종료");
        if (!cart.menuItemList.isEmpty()) {
            System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        }
    }

    // 메뉴 선택 처리
    private void handleMenuSelection(List<MenuItem> menu, String menuName) {

            while (true) {
                displaySubMenu(menu, menuName);
                int choice = getUserInput();
                if (choice == 0) break;

                if (choice > 0 && choice <= menu.size()) {
                    MenuItem selectedItem = menu.get(choice - 1);
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

    // 서브 메뉴 출력
    private void displaySubMenu(List<MenuItem> menu, String menuName) {
        System.out.println("[ " + menuName + " ]");
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " | W " + item.getPrice() + " | " + item.getExplain());
        }
        System.out.println("0. 뒤로가기");
    }


    //최종주문확인
    private void orderCheck() {
        int orderCheck = getUserInput();
        if (orderCheck == 1) {
            System.out.println("주문이 완료되었습니다. 금액은 W . " + cart.getTotalPrice()+"입니다.");
        } else if (orderCheck == 2) {
            return;
        } else throw new MenuException();

    }


    // 사용자 입력 받기
    private int getUserInput() {
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