package com.una.models.user;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UserContainer extends UserAdapter implements Serializable {
    public static ConcurrentMap<String, User> users = new ConcurrentHashMap<>();

    public UserContainer() throws Exception {
        super();
        File userFile = new File("Users.bin");

        if (userFile.exists()) {
            loadFile();
        } else {
            User user = new User("admin", "admin");
            users.put(user.getUsername(), user);
            this.write(new ArrayList<>(users.values()));
        }
    }


    public boolean addUser(User user) throws Exception {
        if (!users.containsKey(user.getId())) {
            users.put(user.getId(), user);
            return true;
        }
        return false;
    }

    public boolean updateUser(String nickName, User user) {
        if (users.containsKey(nickName)) {
            users.put(nickName, user);
            return true;
        }
        return false;
    }

    public static boolean exists(String nickName) {
        return users.containsKey(nickName);
    }

    public static boolean removeUser(String nickName) {
        if (users.containsKey(nickName)) {
            users.remove(nickName);
            return true;
        }
        return false;
    }

    public void loadFile() throws Exception {
        ArrayList<User> data = this.read();
        for (User user : data) {
            users.put(user.getUsername(), user);
        }
    }

    public static User findUser(String userName) throws Exception {
        return users.get(userName);
    }

    public List<User> allUsers() throws Exception {
        return new ArrayList<>(users.values());
    }
    public boolean login(String username, String password) throws Exception {
        File userFile = new File("Users.bin");

        if (!userFile.exists()) {
            User adminUser = new User("admin", "admin");
            users.put(adminUser.getUsername(), adminUser);
            write(new ArrayList<>(users.values()));
        }

        loadFile();
        User user = findUser(username);

        return user != null && user.getPassword().equals(password);
    }
}