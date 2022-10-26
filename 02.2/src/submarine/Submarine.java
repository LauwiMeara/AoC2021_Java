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
	private int aim;
	
	public int getPos() {
		return pos;
	}
	
	public void goForward(int unit) {
		pos += unit;
		depth += (aim * unit);
	}
	
	public int getDepth() {
		return depth;
	}
	
	public int getAim() {
		return aim;
	}
	
	public void aimDown(int unit) {
		aim += unit;
	}
	
	public void aimUp(int unit) {
		aim -= unit;
	}
}
