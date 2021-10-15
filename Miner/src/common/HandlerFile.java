/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import entity.Block;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import system.Config;

/**
 *
 * @author Admin
 */
public class HandlerFile {

    private Config config;
    private Block[] blocks;
    public HandlerFile() {
    }
    
    public boolean createNewFolder(String path){
        File dir = new File(path);
        if (dir.mkdirs()) {
            return true;
        }else{
            return false;
        }     
    }
    public boolean createNewFile(String path){
        try {
 
            File file = new File(path);
 
            if (file.createNewFile()) {
                System.out.println("File is created!");
                return true;
            } else {
                System.out.println("File already exists.");
                return false;
            }
 
        } catch (IOException e) {
            return false;
        }
    }
    
    public boolean  ReadFileConfig(){
        try {
          //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
          FileInputStream fis = new FileInputStream("D:\\ExpectedCoinMiner\\config.bin");
          ObjectInputStream ois = new ObjectInputStream(fis);
          //Bước 2: Đọc dữ liệu
          config = (Config) ois.readObject();
          fis.close();
          ois.close();
          return true;
        } catch (Exception ex) {
          return false;
       } 
    }
    public boolean WriteFileConfig(Config config){
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileOutputStream fos = new FileOutputStream("D:\\ExpectedCoinMiner\\config.bin");
            //out = Files.newOutputStream(path, CREATE, APPEND);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Ghi dối tượng config vào file
            oos.writeObject(config);
            // Đóng luồng
            fos.close();
            oos.close();
            return true;
        } catch (IOException ex) {
            return false;
        }        
    }
    public Config getConfig() {
        return config;
    }
    public boolean WriteFileBlockchain(Block[] blocks, String place){
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileOutputStream fos = new FileOutputStream(place);
            //out = Files.newOutputStream(path, CREATE, APPEND);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(blocks);
            //Bước 3: Đóng luồng
            fos.close();
            oos.close();
            return true;
       } catch (IOException ex) {
         return false;
       }        
    }
    public boolean WriteBlockToFileBlockchain(Block block, String place){
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileOutputStream fos = new FileOutputStream(place,true);
            //out = Files.newOutputStream(path, CREATE, APPEND);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(block);
            //Bước 3: Đóng luồng
            fos.close();
            oos.close();
            return true;
       } catch (IOException ex) {
         return false;
       }        
    }    
    public boolean ReadFileBlockChain(String place){
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileInputStream fis = new FileInputStream(place);
            ObjectInputStream ois = new ObjectInputStream(fis);

            blocks = (Block[]) ois.readObject();
            fis.close();
            ois.close();
            return true;
        } catch (Exception ex) {
            return false;
        }               
    }
    public Block[] getBlocks() {
        return blocks;
    }
    
}
