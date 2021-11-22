
public abstract class Peça {
	private boolean viva = true;
	private boolean branca = false;
	public int identidade;
	
	
	public Peça(boolean branca,int identidade)
	{
		this.setBranca(branca);
		this.identidade = identidade;
	}
	public int getIdentidade() {
		return identidade;
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
