/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mncoin;

import common.Calculator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

/**
 *
 * @author Admin
 */
public class TransactionOutput {
	public String id;
	public String recipient; //also known as the new owner of these coins.
	public float value; //the amount of coins they own
	public String parentTransactionId; //the id of the transaction this output was created in
	
	//Constructor
	public TransactionOutput(String recipient, float value, String parentTransactionId) throws NoSuchAlgorithmException {
		this.recipient = recipient;
		this.value = value;
		this.parentTransactionId = parentTransactionId;
		this.id = Calculator.stringHash(recipient+Float.toString(value)+parentTransactionId);
	}
	
	//Check if coin belongs to you
	public boolean isMine(String publicKey) {
		return (publicKey == recipient);
	}    
        @Override
        public String toString(){
            return id+"_"+recipient+"_"+value+"_"+parentTransactionId;
        }
}
