
public class quadrado {
	private Pe�a pe�a;
	private int x;
	private int y;
	
	public quadrado(int x, int y, Pe�a pe�a)
	{
		this.setX(x);
		this.setY(y);
		this.setPe�a(pe�a);
	}
	
	public void setPe�a(Pe�a p)
	{
		this.pe�a = p;
	}
	
	public void getPe�a()
	{
		return this.pe�a;
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
