
public class Quadrado {
	private Pe�a pe�a;
	private int x;
	private int y;
	
	/// Construtor
	public Quadrado(int x, int y, Pe�a pe�a)
	{
		this.setX(x);
		this.setY(y);
		this.setPe�a(pe�a);
	}
	
	/// getters and setters
	public void setPe�a(Pe�a p)
	{
		this.pe�a = p;
	}
	
	public Pe�a getPe�a()
	{
		return this.pe�a;
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
