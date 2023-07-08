package com.poly.lab5.service;

public interface SessionService {

    <T> T get(String name);

    void set(String name, Object vaue);

    void remove(String name);

}
