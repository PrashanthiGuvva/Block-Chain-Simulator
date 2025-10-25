import model.*;
import com.google.gson.GsonBuilder;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(" Blockchain Simulation Started");

        Blockchain.addBlock(new Block(Arrays.asList(
                new Transaction("Alice", "Bob", 10),
                new Transaction("Bob", "Charlie", 5)
        ), "0"));

        Blockchain.addBlock(new Block(Arrays.asList(
                new Transaction("Charlie", "Dave", 2)
        ), Blockchain.chain.get(Blockchain.chain.size() - 1).hash));

        System.out.println("\n Blockchain Valid: " + Blockchain.isChainValid());

        System.out.println("\n Full Blockchain Data:");
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(Blockchain.chain);
        System.out.println(blockchainJson);
    }
}
