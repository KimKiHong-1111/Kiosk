package com.example.lv3;

public class MenuException extends RuntimeException {
    public MenuException() {
        super("입력 오류입니다. 메뉴 번호를 다시 입력해주세요");
    }
}
