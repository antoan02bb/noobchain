package Blockchain;

import java.util.Date;

public class Block {
    public String hash; //will hold our digital signature
    public String previousHash; //will hold the previous block's hash
    private String data; //our data will be a single message
    private long timeStamp; //as number of milliseconds since 1/1/1970
    private int nonce;

    //Block constructor
    public Block(String data, String previousHash) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); //Making sure we do this after wew set the other values
    }

    public String calculateHash() {
        String calculateHash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data
        );
        return calculateHash;
    }

    public void mineBlock(int difficulty) {
        //create a string with difficulty * "0" - the number of 0's the miners need to solve
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}
