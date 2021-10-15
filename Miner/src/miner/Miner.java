/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miner;

import PeerToPeer.Peer;
import PeerToPeer.client.ImpClient;
import common.HandlerFile;
import java.util.ArrayList;
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
        HandlerFile hf = new HandlerFile(); // khoi tao class xu ly file ( doc, ghi file và tao folder)
        
        if(hf.ReadFileConfig()==false){ // kiem tra xem may tinh da khoi tao cai dat ban dau chua, neu chua thi hien form de khoi tao cai dat
            InitialSetting init = new InitialSetting(myself, OtherPeers);
            init.setVisible(true);             
        }else{
            hf.ReadFileConfig();
            Config config = hf.getConfig();
            System.out.println(config.getLocationSaveBlockchain()+" "+config.getRewardAddressWallet());            
            Index indexGui = new Index();
            indexGui.setVisible(true);
        }
    }  
}
