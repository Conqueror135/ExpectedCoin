/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeerToPeer.server;

import PeerToPeer.client.ImpClient;
import PeerToPeer.client.IClient;
import common.CreateConnect;
import common.HandlerFile;
import entity.Block;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import system.Config;

/**
 *
 * @author Admin
 */
public class ImpServer extends UnicastRemoteObject implements IServer{

    ArrayList<ImpClient> peers;
    ArrayList<String> otherPeers;
    Block[] blocks;
    boolean isReadyToDownloadBlocks;
    boolean isHandlingGetBlocks;
    
    public ImpServer(ArrayList<ImpClient> peers, ArrayList<String> otherPeers) throws RemoteException{
        isReadyToDownloadBlocks= false;
        this.peers = peers;
        this.otherPeers = otherPeers;
    }
    @Override
    public void broadCastMessage(String msg) throws RemoteException {
        System.out.println(msg);
    }
    @Override
    public void addConnectedAble(IClient client, String IpClient) throws RemoteException {
        CreateConnect createConect = new CreateConnect(peers, otherPeers, IpClient);
        createConect.start();   
    }  
    
    // Handle Blockchain
    @Override
    public Block getBlock(int index) throws RemoteException {
        return blocks[index];
    }

    @Override
    public ArrayList<Block> getBlocks(int begin, int end) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int GetStatusDataBlockchain() throws RemoteException {
        HandlerFile hf = new HandlerFile();
        if(hf.ReadFileConfig()){
            Config config = hf.getConfig();
            if(config.isIsBlockchainReady() == false){
                return -2;
            }
        }else{
            return -2;
        }
        if(isReadyToDownloadBlocks == false){
            if(isHandlingGetBlocks == false){
                return -1;
            }else{
                return 0;
            }
        }else{
            return 1;
        }
    }
    @Override
    public boolean getBlockFromFile(){
        System.out.println("client call");
        HandlerFile hf = new HandlerFile();
        if(hf.ReadFileConfig()){
            System.out.println("file config ok");
            Config config = hf.getConfig();
            System.out.println(config.getLocationSaveBlockchain());
            if(hf.ReadFileBlockChain(config.getLocationSaveBlockchain())){
                System.out.println("file block ok");
                blocks = hf.getBlocks();
                return true;
            }
        }
        System.out.println("file ko ok");
        return false;
    }

    @Override
    public void setIsReadyToDownloadBlocks() throws RemoteException {
        System.out.println("client set isReady");
        isReadyToDownloadBlocks = true;
    }

    @Override
    public void setIsHandlingGetBlocks() throws RemoteException {
        System.out.println("client set isHanlding ok");
        isHandlingGetBlocks = true;
    }

    @Override
    public int getNumberOfBlocks() throws RemoteException {
        System.out.println("client get num");
        return blocks.length;
    }
}