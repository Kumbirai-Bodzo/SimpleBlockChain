import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlockChain {
	private List<Block> chain;

	public BlockChain() {
		chain = new ArrayList<Block>();
		// initializeBlock();
	}

	private void initializeBlock() {
		Block g = new Block("v1", new Date(), "this is block 1");
		g.setPrevHash(null);
		chain.add(g);
	}

	public void addBLock(Block block) {

		if (chain.size() == 0) {
			block.setPrevHash(null);
		} else {
			block.setPrevHash(chain.get(chain.size() - 1).getHash());
		}
		chain.add(block);
	}

	public void printChain() {
		for (Block b : chain) {
			System.out.println("version:" + b.getVersion());
			System.out.println("timestamp: " + b.getTimestamp());
			System.out.println("PrevHash: " + b.getPrevHash());
			System.out.println("hash: " + b.getHash());

			System.out.println();
		}
	}

}
