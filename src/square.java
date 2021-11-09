
public class square {
	private Piece piece;
	private int x;
	private int y;
	
	public square(int x, int y, Piece piece)
	{
		this.setPiece(piece);
		this.setX(x);
		this.setY(y);
	}
	
	public void setPiece(Piece p)
	{
		this.piece = p;
	}
	
	public void getPiece()
	{
		return this.piece;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void getX()
	{
		return this.x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void getY(int y)
	{
		return this.y;
	}
	
}
