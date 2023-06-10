package com.una.models.client;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class ClientContainer {
    private static ConcurrentMap<String, Client> clients;

    public ClientContainer() throws Exception {
        super();
        clients = new ConcurrentHashMap<>();
    }


}
