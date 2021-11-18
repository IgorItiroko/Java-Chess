
public class Peão extends Peça{
	public Peão (boolean branca) {
		 super(branca);
	}
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		
		//proibe de mover a peça para um lugar que tenha uma peça de mesma cor
		if(fim.getPeça().isBranca() == this.isBranca()) {
			return false;
		}
		return true;
	}

}
