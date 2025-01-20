package com.example.lv6;

public class Main {
    public static void main(String[] args) throws MenuException {

        Menu burgerMenu = new Menu("Burgers");
        burgerMenu.addMenuItemList(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItemList(new MenuItem("SmokeShack",  8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItemList(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addMenuItemList(new MenuItem("Hamburger", 5.9, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu drinksMenu = new Menu("Drinks");
        drinksMenu.addMenuItemList(new MenuItem("코카콜라", 2.0, "코카콜라"));
        drinksMenu.addMenuItemList(new MenuItem("펩시콜라", 1.9, "펩시콜라"));
        drinksMenu.addMenuItemList(new MenuItem("펩시제로라임", 2.5, "펩시제로 라임맛"));
        drinksMenu.addMenuItemList(new MenuItem("코카콜라제로", 2.2, "코카콜라 제로"));


        Menu dessertMenu = new Menu("Desserts");
        dessertMenu.addMenuItemList(new MenuItem("아이스크림 콘", 0.5, "맛있는 아이스크림 콘"));
        dessertMenu.addMenuItemList(new MenuItem("초코 콘", 1.0, "맛있는 아이스크림 콘에 초코 코팅"));
        dessertMenu.addMenuItemList(new MenuItem("핫 아메리카노", 1.0, "핫아메"));
        dessertMenu.addMenuItemList(new MenuItem("라떼", 1.5, "달다구리한 라떼"));


        Kiosk kiosk = new Kiosk();
        kiosk.add(burgerMenu);
        kiosk.add(drinksMenu);
        kiosk.add(dessertMenu);


        kiosk.start();

    }
}


