package model;

import java.util.Date;
import java.util.List;
import util.StringUtil;
import com.google.gson.GsonBuilder;

public class Block {
    public String hash;
    public String previousHash;
    private long timeStamp;
    private int nonce;
    private List<Transaction> transactions;

    public Block(List<Transaction> transactions, String previousHash) {
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        return StringUtil.applySha256(
                previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + transactions.toString());
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println(" Block mined: " + hash);
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
