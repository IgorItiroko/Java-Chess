
public class Pe�o extends Pe�a{
	public boolean primeiroMovimento;
	
	public Pe�o (boolean branca) {
		 super(branca);
		 primeiroMovimento = true;
	}
	
	public void setPrimeiroMovimento(boolean primeiroMovimento) {
		this.primeiroMovimento = primeiroMovimento;
	}
	
	public boolean getPrimeiroMovimento() {
		return primeiroMovimento;
	}
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		
		int x = Math.abs(fim.getX() - inicio.getX());
		
		//proibe de mover a pe�a mais do que 2 caso n�o seja o primeiro movimento
		if( getPrimeiroMovimento() == true) {
			if(x >2)
				return false;
		}
		
		if(getPrimeiroMovimento() == false && x>1) {
			return false;
		}
				
		//proibe de mover a pe�a na diagonal caso n�o haja nenhuma pe�a do oponente
		if(tabuleiro.campo[inicio.getX() + 1][inicio.getY() + 1].getPe�a() == null) {
			return false;
		}
				
		//proibe de mover a pe�a para um lugar que tenha uma pe�a de mesma cor
		if(fim.getPe�a().isBranca() == this.isBranca()) {
			return false;
		}
		//proibe de mover a pe�a na horizontal
		if(fim.getX() != inicio.getX() && fim.getY() == inicio.getY()) {
			return false;
		}
		
		String dire��o = "";
		if(fim.getY() > inicio.getY()) {
			dire��o = "sul";
		}
		
		if(fim.getY() < inicio.getY()) {
			dire��o = "norte";
		}
		
		//processos de verifica��o de pe�as no caminho desejado
		if(dire��o.equals("sul")) {
				if(tabuleiro.campo[inicio.getX()][inicio.getY()+1].getPe�a()!=null) {
					return false;					
			}
		}
		
		if(dire��o.equals("norte")) {
				if(tabuleiro.campo[inicio.getX()][inicio.getY()-1].getPe�a()!=null) {
					return false;
				}				
			}
		
		setPrimeiroMovimento(false);
		return true;
	}

}
