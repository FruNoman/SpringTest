package com.github.frunoman.spring_boot_tests.utils;

public enum Categories {
    SMARTPHONES_AND_TV("Смартфони, ТВ і електроніка"),
    PRODUCTS_FOR_HOME("Ноутбуки та комп’ютери");

    private final String category;
    Categories(String category){
        this.category=category;
    }

    @Override
    public String toString() {
        return this.category;
    }
}
