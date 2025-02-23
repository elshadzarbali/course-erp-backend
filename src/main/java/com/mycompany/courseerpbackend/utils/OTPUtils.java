package com.mycompany.courseerpbackend.utils;

import java.util.Random;

public class OTPUtils {

    public static String generate() {
        Random rand = new Random();
        return String.format("%04d", rand.nextInt(10000));
    }

}
