
public class Cavalo extends Pe�a{
	public int identidade;
	public Cavalo (boolean branca, int identidade) {
		 super(branca,identidade);
		
	}
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		
		//proibe de mover a pe�a para um lugar que tenha uma pe�a de mesma cor
		if(fim.getPe�a().isBranca() == this.isBranca()) {
			return false;
		}
		
		int x = Math.abs(fim.getX() - inicio.getX());
		int y = Math.abs(fim.getY() - inicio.getY() );
		
		    //Proibi��o de qualquer movimento al�m do exclusivo para cavalos
			if(x * y != 2) {
				return false;
			}
			
		return true;
	}

}
