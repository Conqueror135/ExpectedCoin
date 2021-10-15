/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import common.HandlerFile;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import system.Config;

/**
 *
 * @author Admin
 */
public class GenesisBlock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       HandlerFile hf = new HandlerFile();
//       if(hf.WriteFileConfig(new Config("D:\\EPC\\Blocks.bin","ThangThanThanh","123",true))){
//           System.out.println("ok");
//       }

//        hf.ReadFileConfig();
//        System.out.println(hf.getConfig().isIsBlockchainReady());

//        Block b[]= {new Block("0","",java.time.LocalDateTime.now().toString(),"gdgsjdgs","10","gsgds",null,1,"thang",null)};
//    
//       if(hf.WriteFileBlockchain(b,"D:\\EPC\\Blocks.bin" )){
//           System.out.println("ok");
//       } 
         
        if(hf.ReadFileBlockChain("D:\\EPC\\Blocks.bin")){
            Block[] b= hf.getBlocks();
            System.out.println(b[0].getHeight());
        }


//       if(hf.createNewFolder("d:/blockchain1"))
//            if(hf.createNewFile("d:/blockchain1/mydata.bin")){
//                Block b[]= {new Block("0","",java.time.LocalDateTime.now().toString(),"gdgsjdgs","10","gsgds",null,1,"thang",null)};
//                hf.WriteFileBlockchain(b,"d:/blockchain1/mydata.bin" );
//            }
       
//  try {
//    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
//    FileInputStream fis = new FileInputStream("d:/blockchain1/mydata.bin");
//    ObjectInputStream ois = new ObjectInputStream(fis);
//    //Bước 2: Đọc dữ liệu
//    Block[] b = (Block[]) ois.readObject();
////    for(int i=0;i<b.length;i++){
////        for(int j=0;j<sArr[i].trans.length;j++){
////            System.out.println(sArr[i].trans[j].toString());
////        }
//        System.out.println(b[0].getMiner());
////    }
////    for(Block s : sArr){
////      System.out.println(s.trans);
////    }
//    //Bước 3: Đóng luồng
//    fis.close();
//    ois.close();
//  } catch (Exception ex) {
//    System.out.println("Loi doc file: "+ex);
// }       
//       
//       
       
       
       
       
       
       
    //System.out.println(java.time.LocalDateTime.now()); 
    }
// String //Height, String PreviousHeaderHash, String Timestamp, String MerkleRootHash, String Nonce, String HeaderHash, Transaction[] Trans, int Confirmations, String Miner, Core core   
}
