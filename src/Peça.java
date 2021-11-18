
public class peça {
	private boolean viva = true;
	private boolean branca = false;
	
	public Piece(boolean branca)
	{
		this.setBranca(branca);
	}
	
	public boolean getBranca()
	{
		return this.isBranca;
	}
	
	public void setBranca(boolean branca)
	{
		this.branca = branca;
	}
	
	public boolean getViva()
	{
		return this.viva;
	}
	
	public void setViva(boolean viva)
	{
		this.viva = viva;
	}
	
	public abstract boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim);
}
