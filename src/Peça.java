
public abstract class Peça {
	private boolean viva = true;
	private boolean branca = false;
	public boolean primeiroM = true;
	public int identidade;
	
	
	public Peça(boolean branca,int identidade,boolean primeiroM)
	{
		this.setBranca(branca);
		this.identidade = identidade;
		this.primeiroM= true;
	}
	public int getIdentidade() {
		return identidade;
	}
	public boolean isBranca()
	{
		return this.branca;
	}
	
	public boolean isPrimeiroMovimento() {
		return primeiroM;
	}
	public void setPrimeiroMovimento(boolean primeiroMovimento) {
		this.primeiroM = primeiroMovimento;
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
	
	public abstract boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim,boolean pm);
	
	
}
