import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// creating a block chain
		BlockChain chain = new BlockChain();
//creating blocks
		Block a = new Block("v1", new Date(), "this is block 1");
		Block b = new Block("v2", new Date(), "this is block 1");
//adding blocks to the chain
		chain.addBLock(a);
		chain.addBLock(b);
//printing blocks in the chain
		chain.printChain();
	}

}
