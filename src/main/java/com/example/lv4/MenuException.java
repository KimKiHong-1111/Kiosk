package com.example.lv4;

public class MenuException extends RuntimeException {
    public MenuException() {
        super("입력 오류입니다. 정확한 숫자를 다시 입력해주세요");
    }
}
