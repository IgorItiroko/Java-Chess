
public class Cavalo extends Peça{
	public int identidade;
	public Cavalo (boolean branca, int identidade, boolean primeiroM) {
		 super(branca,identidade,primeiroM);
		
	}
	public Quadrado fCavalo;
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim,boolean pm) {
		
		//proibe de mover a peça para um lugar que tenha uma peça de mesma cor
		if(fim.getPeça() != null && fim.getPeça().isBranca() == this.isBranca()) {
			return false;
		}
		
		int x = Math.abs(fim.getX() - inicio.getX());
		int y = Math.abs(fim.getY() - inicio.getY() );
		
		    //Proibição de qualquer movimento além do exclusivo para cavalos
			if(x * y != 2) {
				return false;
			}

		return true;
	}

}
