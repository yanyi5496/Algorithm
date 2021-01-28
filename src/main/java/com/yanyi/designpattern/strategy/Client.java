package com.yanyi.designpattern.strategy;

/**
 * @author chenqiang
 * @since 2021-01-28 14:40
 */
public class Client {
    public static void main(String[] args) {
        Price price = new Price();
        double quote = price.quote(200, 3);
        System.out.println("quote = " + quote);
    }
}
