
public class Rainha extends Pe�a {
	public Rainha (boolean branca) {
		 super(branca);
	}
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		
		//proibe de mover a pe�a para um lugar que tenha uma pe�a de mesma cor
		if(fim.getPe�a().isBranca() == this.isBranca()) {
			return false;
		}
		return true;
	}

}
