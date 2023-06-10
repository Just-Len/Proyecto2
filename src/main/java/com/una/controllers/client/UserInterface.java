package com.una.controllers.client;

public interface UserInterface {
    public String add(String[] data);
    public String remove(String id);
    public String update(String[] data);
    public String[] getById(String id)throws Exception;
}
