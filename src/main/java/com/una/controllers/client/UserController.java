package com.una.controllers.client;

import com.una.models.user.User;
import com.una.models.user.UserContainer;

import java.util.ArrayList;

public class UserController implements UserInterface {
    public UserContainer userContainer;
    public UserController() throws Exception {
        userContainer = new UserContainer();
    }

    @Override
    public String add(String[] data) {
        try {
            User user = new User(data);
            if(userContainer.addUser(user)){
               userContainer.write((ArrayList<User>) userContainer.allUsers());
            return "Se ha agregado exitosamente";

            }else{
                return "No se ha agregado";
            }
        }catch(Exception e){
            return "Error agregando al usuario: " + e.getMessage();
        }
    }
    @Override
    public String[] getById(String nickName) throws Exception {
        if(UserContainer.exists(nickName)){
            User user=UserContainer.findUser(nickName);
            String[] data={user.getUsername(),user.getPassword(),
                    user.getName(),user.getEmail(), user.getPhone(), user.getId()};
            return data;
        }
        return null;
    }

    @Override
    public String remove(String nickName) {
        if(UserContainer.exists(nickName)){
            UserContainer.removeUser(nickName);
        }
        return null;
    }
    @Override
    public String update(String[] data) {
        return null;
    }
}
