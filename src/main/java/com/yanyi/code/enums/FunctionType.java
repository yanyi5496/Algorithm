package com.yanyi.code.enums;

/**
 * @author chenqiang
 * @date 2020-09-28
 */
public enum FunctionType {
    AP_LOGIN("http://mywifi.han-networks.com:8080/echo.fcgi");
    String url;
    private FunctionType(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    public static void main(String[] args) {
        String url = FunctionType.AP_LOGIN.getUrl();
        System.out.println("url = " + url);
    }
}