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
public class Transaction implements Serializable{
    private String Sender;// Dia chi vi cua nguoi gui
    private String Receiver;// Dia chi vi cua nguoi nhan
    private double Coin;// So luong coin gui di
    private double Fee; // Phi giao dich

    public Transaction(String Sender, String Receiver, double Coin, double Fee) {
        this.Sender = Sender;
        this.Receiver = Receiver;
        this.Coin = Coin;
        this.Fee = Fee;
    }

    public String getSender() {
        return Sender;
    }

    public String getReceiver() {
        return Receiver;
    }

    public double getCoin() {
        return Coin;
    }

    public double getFee() {
        return Fee;
    }
}
