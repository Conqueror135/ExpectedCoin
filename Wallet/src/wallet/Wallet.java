/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wallet;

import PeerToPeer.Peer;
import PeerToPeer.client.ImpClient;
import PeerToPeer.server.ImpServer;
import common.HandlerFile;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mncoin.TransactionOutput;
import wallet.GUI.Index;

/**
 *
 * @author Admin
 */
public class Wallet {

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
        indexGui.setVisible(true);
        for(ImpClient otherPeer : OtherPeers){
            try {
                ArrayList<TransactionOutput> myOutput = otherPeer.getBalance("MFYwEAYHKoZIzj0CAQYFK4EEAAoDQgAEFopTPD5fYYcggdsjDgj8e1F7jC5hkjwW/DsRRztPjfjosuIykyYdxaLzxYFZdv11dvhF8s0orZFBOJ2kDW78zQ==");
                for(int i =0; i< myOutput.size();i++)
                    System.out.println(myOutput.get(i).toString());
            } catch (RemoteException ex) {
                Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
