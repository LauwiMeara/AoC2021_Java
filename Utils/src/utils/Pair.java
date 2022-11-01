package utils;

public class Pair {
	private final int X;
	private final int Y;
	private final int ID;
	
	public Pair(int x, int y) {
		this.X = x;
		this.Y = y;
		this.ID = Integer.parseInt(x + "000" + y);
	}
	
	public int getX() {
		return X;
	}
	
	public int getY() {
		return Y;
	}
	
	@Override
    public boolean equals(Object o) {
 
        // If the object is compared with itself then return true 
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Pair or not
          "null instanceof Pair" also returns false */
        if (!(o instanceof Pair)) {
            return false;
        }
         
        // Typecast o to Complex so that we can compare data members
        Pair p = (Pair) o;
         
        // Compare the data members and return accordingly
        return Double.compare(X, p.X) == 0
                && Double.compare(Y, p.Y) == 0;
    }
	
	@Override
    public int hashCode()
    {
        return this.ID;
    }
}
