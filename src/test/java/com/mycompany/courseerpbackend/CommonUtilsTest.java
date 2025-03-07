package com.mycompany.courseerpbackend;

import com.mycompany.courseerpbackend.exception.BaseException;
import org.junit.jupiter.api.Test;

import static com.mycompany.courseerpbackend.utils.CommonUtils.Checker;
import static com.mycompany.courseerpbackend.utils.CommonUtils.throwIf;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommonUtilsTest {

    @Test
    public void testThrowIfConditionFails() {

        Checker checker = () -> false;

        assertThrows(BaseException.class, () -> throwIf(checker, BaseException.unexpected()));
    }

    @Test
    public void testThrowIfConditionSucceeds() {

        Checker checker = () -> true;

        throwIf(checker, BaseException.unexpected());
    }

}
