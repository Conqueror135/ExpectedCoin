/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Core {
    private String SystemAddress; // Địa chỉ ví của hệ thống
    private double TotalCoin; // so luong coin co trong he thong con co the thuong cho tho dao// tong so luonng coin co trong he thong la  
    private int Difficult;// so luong so 0 yeu cau cua ma bam
    private double Reward; // phan thuong quy dinh thuong khi mot block dc tao ra
    private double FloorFeeReward; // phi giao dich toi thieu
    private int halving; // so nam de giam reward di 1/2

    public Core(double TotalCoin, int Difficult, double Reward, int halving) {
        this.TotalCoin = TotalCoin;
        this.Difficult = Difficult;
        this.Reward = Reward;
        this.halving = halving;
    }  
}
