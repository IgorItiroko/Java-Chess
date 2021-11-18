
public abstract class Pe�a {
	private boolean viva = true;
	private boolean branca = false;
	
	public Pe�a(boolean branca)
	{
		this.setBranca(branca);
	}
	
	public boolean isBranca()
	{
		return this.branca;
	}
	
	public void setBranca(boolean branca)
	{
		this.branca = branca;
	}
	
	public boolean isViva()
	{
		return this.viva;
	}
	
	public void setViva(boolean viva)
	{
		this.viva = viva;
	}
	
	public abstract boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim);
}
