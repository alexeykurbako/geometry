package com.epam.geometry.generator;

public class IdGenerator {
    private Integer id;

    public IdGenerator() {
        id = 0;
    }

    public Integer generateId() {
        return ++id;
    }
}
