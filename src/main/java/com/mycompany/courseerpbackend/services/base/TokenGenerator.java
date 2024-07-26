package com.mycompany.courseerpbackend.services.base;

public interface TokenGenerator <T> {

    String generate(T obj);

}
