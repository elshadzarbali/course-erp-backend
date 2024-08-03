package com.mycompany.courseerpbackend.services.base;

public interface TokenReader <T> {

    T read(String token);

}
