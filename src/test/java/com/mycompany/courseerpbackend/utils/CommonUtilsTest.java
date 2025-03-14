package com.mycompany.courseerpbackend.utils;

import com.mycompany.courseerpbackend.exception.BaseException;
import com.mycompany.courseerpbackend.exception.ExceptionBuilder;
import org.junit.jupiter.api.Test;

import static com.mycompany.courseerpbackend.utils.CommonUtils.Checker;
import static com.mycompany.courseerpbackend.utils.CommonUtils.throwIf;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommonUtilsTest {

    @Test
    public void testThrowIfConditionSucceeds() {

        Checker checker = () -> false;

        throwIf(checker, ExceptionBuilder.unexpected());
    }

    @Test
    public void testThrowIfConditionFails() {

        Checker checker = () -> true;

        assertThrows(BaseException.class, () -> throwIf(checker, ExceptionBuilder.unexpected()));
    }

}
