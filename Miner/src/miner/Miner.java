/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miner;

import PeerToPeer.Peer;
import PeerToPeer.client.ImpClient;
import PeerToPeer.server.ImpServer;
import common.HandlerFile;
import entity.Block;
import entity.Transaction;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import miner.GUI.Index;
import miner.GUI.InitialSetting;
import system.Config;

/**
 *
 * @author Admin
 */
public class Miner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Peer myself = new Peer(); // khoi tao va ket noi vao mang peer to peer
        ArrayList<ImpClient> OtherPeers = myself.getPeers(); // lay ket noi voi cac peer khac trong mang
        ImpServer impServer = myself.getServer();
        HandlerFile hf = new HandlerFile(); // khoi tao class xu ly file ( doc, ghi file và tao folder)
        Index indexGui = new Index(OtherPeers);
        
        if(hf.ReadFileConfig()==false){ // kiem tra xem may tinh da khoi tao cai dat ban dau chua, neu chua thi hien form de khoi tao cai dat
            InitialSetting init = new InitialSetting(myself, OtherPeers);
            init.setVisible(true);             
        }else{
//            hf.ReadFileConfig();
            Config config = hf.getConfig();
            System.out.println(config.getLocationSaveBlockchain()+" "+config.getLocationSaveBlockchain());            
            indexGui.setVisible(true);
//            while(true){
//                if()
//            }
        //    PoW pow = new PoW(OtherPeers);
        }
        
        if(hf.getConfig().isIsBlockchainReady()){
            System.out.println("pow");
            while(true){
            //    System.out.println("ll");
                if(!indexGui.getIsStopMining()&& !impServer.getIsCreatingBlock()){
                    
                    Transaction[] trans = impServer.getWaitingTransaction().toArray(new Transaction[impServer.getWaitingTransaction().size()]);
                    impServer.setIsCreatingBlock(true);
                    Block TopBlock = impServer.getTopBlock();
                //    System.out.println(TopBlock.getNonce());
                    Block newBlock = new Block();
                    newBlock.setMiner("1Bf9sZvBHPFGVPX71WX2njhd1NXKv5y7v5");
                    newBlock.setTrans(trans);
                    PoW pow = new PoW(OtherPeers, impServer, TopBlock, newBlock ); 
                    try {
                        pow.started();
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(Miner.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Miner.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        //    System.out.println("kkk");
            
        }
    }  
}
