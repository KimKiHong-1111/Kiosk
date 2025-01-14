package com.example.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);;
        List<MenuItem>list = new ArrayList<>();
        int n = 1;
        while (n != 0) {
            System.out.println("추가할 메뉴의 이름, 가격, 설명을 입력하세요.");
            MenuItem menuItem = new MenuItem(sc.next(), sc.nextInt(), sc.next());
            list.add(menuItem);
            System.out.println("메뉴가 추가되었습니다.");
            System.out.println("등록을 계속 하시겠습니까?");
            System.out.println("1. 예");
            System.out.println("0. 아니오");
            n = sc.nextInt();
        }
        System.out.println("등록을 중단합니다.");
        System.out.println("메뉴를 확인하시겠습니까?");
        System.out.println("0. 예");
        System.out.println("1. 아니오");
        n = sc.nextInt();
        if (n == 1) {
            System.out.println("프로그램을 종료합니다");
        }else{
            list.stream().forEach(f -> System.out.println("이름 : " + f.getName() + " 가격 : " + f.getPrice() + " 설명" + f.getExplain()));
        }
    }
}
