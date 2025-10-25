package model;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    public static List<Block> chain = new ArrayList<>();
    public static int difficulty = 4;

    public static void addBlock(Block newBlock) {
        newBlock.mineBlock(difficulty);
        chain.add(newBlock);
    }

    public static boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) return false;
            if (!currentBlock.previousHash.equals(previousBlock.hash)) return false;
        }
        return true;
    }
}
