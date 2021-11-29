
public class Rei extends Peça {
	public int identidade;
	public Rei (boolean branca,int identidade,boolean primeiroM) {
		 super(branca,identidade,primeiroM);

	}
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim,boolean pm) {
		int x= Math.abs(fim.getX() - inicio.getX());
		int y= Math.abs(fim.getY() - inicio.getY());
		

		//proibe de mover a peça para um lugar que tenha uma peça de mesma cor
		if(fim.getPeça() != null && fim.getPeça().isBranca() == this.isBranca()) {
			return false;
		}
				
		//String direção ="";
		if( x > 1 || y > 1) {
			return false;
		}
		
			if(!pm) {
				this.primeiroM = false;
			}		
		return true;
	}
	
	
}
