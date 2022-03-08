package com.luxstech.dto;

public class ResponseDto {

    private String message;
    private int code;
    private boolean status;
    private Object data;

    public ResponseDto(int code, boolean status, String message, Object data) {
        this.code = code;
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public ResponseDto(int code, boolean status, String message) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public ResponseDto(){

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
