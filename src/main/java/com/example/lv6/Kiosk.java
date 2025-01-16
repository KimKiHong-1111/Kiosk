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
        while (true) {
            try {
                if (cart.menuItemList.isEmpty()) {
                    //장바구니에 물건이 없는 경우
                    displayMainMenu();
                    //Main 메뉴판이 나오게 함
                    String input = sc.next();
                    int mainChoice;
                    mainChoice = Integer.parseInt(input);
                    switch (mainChoice) {
                        case 1:
                            displayBurgerMenu();
                            break;
                        case 2:
                            System.out.println("죄송합니다. Drinks 메뉴는 아직 미구현입니다.");
                            continue;
                        case 3:
                            System.out.println("죄송합니다. Desserts 메뉴는 아직 미구현입니다.");
                            continue;
                        case 0:
                            System.out.println("프로그램을 종료합니다.");
                            break;
                        default:
                            throw new MenuException();
                    }
                    String b = sc.next();
                    int choice;
                    choice = Integer.parseInt(b);
                    if (choice == 0) continue;
                    MenuItem selectedItem = burgerMenu.getMenuItems().get(choice - 1);
                    System.out.println("선택한 메뉴: " + selectedItem.getName() + "| " + "W ." + selectedItem.getPrice() + "| " + selectedItem.getExplain());
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");
                    String answer = sc.next();
                    if (answer.equals("1")) {
                        cart.menuItemList.add(selectedItem);
                        System.out.println(selectedItem.getName() + "이 장바구니에 추가되었습니다.");
                        //장바구니 클래스에 있는 리스트에 저장.
                    } else if (answer.equals("2")) {
                        continue;
                    } else throw new MenuException();
                } else {
                    //장바구니에 메뉴가 담겨있을 경우 뜨는 메뉴판
                    while (true) {
                        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
                        displayMainMenu();
                        //메인메뉴
                        displayOrderMenu();
                        //오더메뉴 4,5번
                        String input = sc.next();
                        int mainChoice;
                        try {
                            mainChoice = Integer.parseInt(input);
                            switch (mainChoice) {
                                case 1:
                                    displayBurgerMenu();
                                    break;
                                case 2:
                                    System.out.println("죄송합니다. Drinks 메뉴는 아직 미구현입니다.");
                                    continue;
                                case 3:
                                    System.out.println("죄송합니다. Desserts 메뉴는 아직 미구현입니다.");
                                    continue;
                                case 4:
                                    System.out.println("아래와 같이 주문 하시겠습니까?");
                                    System.out.println("[ Orders ]");
                                    for (int i = 0; i < cart.menuItemList.size(); i++) {
                                        System.out.println(cart.menuItemList.get(i).getName() + " | W " + cart.getMenuItemList().get(i).getPrice() + " | " + cart.menuItemList.get(i).getExplain());
                                    }
                                    //메뉴 여러개 시킬경우 어떻게 구현할지
                                    System.out.println("[ Total ]");
                                    System.out.println("W " + cart.getTotalPrice());
                                    System.out.println("1. 주문      2. 메뉴판");
                                    String order = sc.next();
                                    if (order.equals("1")) {
                                        System.out.println("주문이 완료되었습니다. 금액은  W " + cart.getTotalPrice() + " 입니다.");
                                        break;
                                    } else if (order.equals("2")) {
                                        //어떻게하면 다시 메뉴판으로 돌아가게 할까??
                                        continue;
                                    } else throw new MenuException();
                                case 5:
                                    cart.clear();
                                    //주문취소
                                    continue;
                                case 0:
                                    System.out.println("프로그램을 종료합니다.");
                                    return;
                                default:
                                    throw new MenuException();
                            }
                            String b = sc.next();
                            int choice;
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
                            continue;
                        }
                    }
                }
            } catch (MenuException e) {
                System.out.println(e.getMessage());
                continue;
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