package com.mycompany.courseerpbackend.utils;

import com.mycompany.courseerpbackend.exception.BaseException;
import org.junit.jupiter.api.Test;

import static com.mycompany.courseerpbackend.utils.CommonUtils.Checker;
import static com.mycompany.courseerpbackend.utils.CommonUtils.throwIf;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommonUtilsTest {

    @Test
    public void testThrowIfConditionSucceeds() {

        Checker checker = () -> false;

        throwIf(checker, BaseException.unexpected());
    }

    @Test
    public void testThrowIfConditionFails() {

        Checker checker = () -> true;

        assertThrows(BaseException.class, () -> throwIf(checker, BaseException.unexpected()));
    }

}
