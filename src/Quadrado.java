
public class Quadrado {
	private Peça peça;
	private int x;
	private int y;
	
	/// Construtor
	public Quadrado(int x, int y, Peça peça)
	{
		this.setX(x);
		this.setY(y);
		this.setPeça(peça);
	}
	
	/// getters and setters
	public void setPeça(Peça p)
	{
		this.peça = p;
	}
	
	public Peça getPeça()
	{
		return this.peça;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getY()
	{
		return this.y;
	}
	
}
