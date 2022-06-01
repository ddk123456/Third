package cn.edu.guet.util;

import java.util.UUID;

public class UUIDDemo {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }
}
