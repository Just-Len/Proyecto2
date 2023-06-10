package com.una.models.client;

import java.io.*;
import java.util.ArrayList;

public class ClientDao {
    public ClientDao() {

    }
    protected void write(ArrayList<Client> list)throws Exception{
        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(new FileOutputStream("Clientes.bin"));
            for(int i = 0; i < list.size(); i++){
                oos.writeObject(list.get(i));
            }
        }catch(IOException e){
            throw new Exception("Error writing  " );
        }finally{
            oos.close();
        }
    }
    protected ArrayList<Client> read() throws Exception{
        ObjectInputStream ois;
        ArrayList<Client> list = new ArrayList<>();
        try{
            ois = new ObjectInputStream(new FileInputStream("Clientes.bin"));
            if(ois!=null){
                Client client =(Client)ois.readObject();
                while(client!=null){
                    list.add(client);
                    client = (Client)ois.readObject();
                }
            }
            ois.close();
        }catch(IOException |ClassNotFoundException e){
            if(!(e instanceof EOFException)){
                throw new Exception(e.getMessage());
            }
        }
        return list;
    }
}
