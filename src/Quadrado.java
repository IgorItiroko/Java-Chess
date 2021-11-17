
public class quadrado {
	private Peça peça;
	private int x;
	private int y;
	
	public quadrado(int x, int y, Peça peça)
	{
		this.setX(x);
		this.setY(y);
		this.setPeça(peça);
	}
	
	public void setPeça(Peça p)
	{
		this.peça = p;
	}
	
	public void getPeça()
	{
		return this.peça;
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
