package com.example.common.dto;

public class CommonResponse<T> {
    private boolean success;
    private T data;

    public CommonResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    // Getter, Setter 생략 (Lombok 사용 가능)
}
