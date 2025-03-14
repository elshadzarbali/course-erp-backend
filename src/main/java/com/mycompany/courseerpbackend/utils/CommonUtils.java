package com.mycompany.courseerpbackend.utils;

import com.mycompany.courseerpbackend.exception.BaseException;

public class CommonUtils {

    @FunctionalInterface
    public interface Checker {

        boolean check();

    }

    // It throws an exception when the condition is true
    public static void throwIf(Checker checker, BaseException ex) {
        if (checker.check()) {
            throw ex;
        }
    }

}
