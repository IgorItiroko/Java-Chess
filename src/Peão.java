
public class Pe�o extends Pe�a{
	public int identidade;
	public Pe�o (boolean branca, int identidade,boolean primeiroM) {
		 super(branca,identidade,primeiroM);
	}
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim,boolean pm) {
		
		int x = Math.abs(fim.getX() - inicio.getX());
		
		//Proibe de mover a pe�a para uma posi��o onde h� uma pe�a de mesma cor no destino
		if(fim.getPe�a() != null && fim.getPe�a().isBranca() == this.isBranca()) {
			return false;
		}
		
		
		//proibe de mover a pe�a mais do que 2 
		if( this.primeiroM) {
			if(x >2) {
			return false;
			}
			if(this.isBranca()) {
				if(tabuleiro.campo[inicio.getX()+1][inicio.getY()].getPe�a()!= null) {
					return false;
				}
			}
			if(!this.isBranca()) {
				if(tabuleiro.campo[inicio.getX()-1][inicio.getY()].getPe�a()!= null) {
					return false;
				}
			}
		}
		
		//proibe de mover a pe�a mais do que 1 caso n�o seja o primeiro movimento
		if(!this.primeiroM && x>1) {
			return false;
		}
		
		//proibe de mover a pe�a na diagonal
		if((fim.getY() != inicio.getY()) && (tabuleiro.campo[fim.getX()][fim.getY()].getPe�a() == null)) {
				return false;
			}
		
				
			//Proibe pe�as brancas de andarem para o norte
			if(this.isBranca() && inicio.getX() > fim.getX()) {
				return false;
			}
			
			//Proibe pe�as pretas de andarem para o sul
			if(!this.isBranca() && inicio.getX() < fim.getX()) {
				return false;
			}
			
			if( this.isBranca() && tabuleiro.campo[inicio.getX()+1][inicio.getY()].getPe�a() != null && fim.getY() == inicio.getY()) {
				return false;
			}
			
			if( !this.isBranca() && tabuleiro.campo[inicio.getX()-1][inicio.getY()].getPe�a() != null && fim.getY() == inicio.getY()) {
				return false;
			}
		
		//proibe de mover a pe�a na horizontal
		if(fim.getX() == inicio.getX() && fim.getY() != inicio.getY()) {
			return false;
		}
		if(Math.abs(inicio.getY() - fim.getY()) > 1) {
			return false;
		}
		this.primeiroM = false;
		return true;
	}

}
