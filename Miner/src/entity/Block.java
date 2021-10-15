/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Block implements Serializable{
    //--Header
    private String Height;
    private String PreviousHeaderHash;
    private String Timestamp;
    private String MerkleRootHash;
    private String Nonce;
    //- end
    private String HeaderHash;
    private Transaction[] Trans;
    private int Confirmations;
    private String Miner;
    private Core core;

    public Block(String Height, String PreviousHeaderHash, String Timestamp, String MerkleRootHash, String Nonce, String HeaderHash, Transaction[] Trans, int Confirmations, String Miner, Core core) {
        this.Height = Height;
        this.PreviousHeaderHash = PreviousHeaderHash;
        this.Timestamp = Timestamp;
        this.MerkleRootHash = MerkleRootHash;
        this.Nonce = Nonce;
        this.HeaderHash = HeaderHash;
        this.Trans = Trans;
        this.Confirmations = Confirmations;
        this.Miner = Miner;
        this.core = core;
    }
    // Getter
    public String getHeight() {
        return Height;
    }

    public String getPreviousHeaderHash() {
        return PreviousHeaderHash;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public String getMerkleRootHash() {
        return MerkleRootHash;
    }

    public String getNonce() {
        return Nonce;
    }

    public String getHeaderHash() {
        return HeaderHash;
    }

    public Transaction[] getTrans() {
        return Trans;
    }

    public int getConfirmations() {
        return Confirmations;
    }

    public String getMiner() {
        return Miner;
    }

    public Core getCore() {
        return core;
    }
}