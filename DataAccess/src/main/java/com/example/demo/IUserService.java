package com.example.demo;

public interface IUserService {
    void create(String name, String  pwd);
    void deleteByName(String name);
    Integer getUserCount();
    void deleteAll();
}
