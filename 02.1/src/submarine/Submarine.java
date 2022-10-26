package submarine;

/**
 * Class to keep track of submarine.
 * @author Laura Luijben
 *
 */
public class Submarine {
	// Pos, depth and aim start at default value 0
	private int pos;
	private int depth;
	
	public int getPos() {
		return pos;
	}
	
	public void goForward(int unit) {
		pos += unit;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void goDown(int unit) {
		depth += unit;
	}
	
	public void goUp(int unit) {
		depth -= unit;
	}
}
