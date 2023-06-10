package com.una.models.user;

import java.io.*;
import java.util.ArrayList;

import static com.una.models.user.UserContainer.users;

public class UserAdapter {
    public UserAdapter() {
    }
    public void write(ArrayList<User> users)throws Exception{
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Users.bin"));
            for(int i=0; i< users.size(); i++){
                oos.writeObject(users.get(i));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected ArrayList<User> read() throws Exception {
        ObjectInputStream ois;
        ArrayList<User> users = new ArrayList<User>();

        try {
            ois = new ObjectInputStream(new FileInputStream("Users.bin"));
            while (true) {
                try {
                    User user = (User) ois.readObject();
                    users.add(user);
                } catch (EOFException e) {
                    break; // Salir del bucle cuando se alcance el final del archivo
                }
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return users;
    }


}
