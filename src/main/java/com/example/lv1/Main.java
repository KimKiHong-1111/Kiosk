package com.example.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int n = 0;
        list.add("ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        list.add("SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        list.add("Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        list.add("Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i));
        }
        System.out.println(n + ". 종료      | 종료");
        System.out.print("먹고 싶은 메뉴 번호를 고르세요 : ");
        n = sc.nextInt();
        if (n == 0) {
            System.out.println("프로그램을 종료합니다");
        } else {
            System.out.println((n) + ". " + list.get(n-1));
        }
    }
}
