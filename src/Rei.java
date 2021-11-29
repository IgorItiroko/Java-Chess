
public class Rei extends Pe�a {
	public int identidade;
	public Rei (boolean branca,int identidade,boolean primeiroM) {
		 super(branca,identidade,primeiroM);

	}
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim,boolean pm) {
		int x= Math.abs(fim.getX() - inicio.getX());
		int y= Math.abs(fim.getY() - inicio.getY());
		

		//proibe de mover a pe�a para um lugar que tenha uma pe�a de mesma cor
		if(fim.getPe�a() != null && fim.getPe�a().isBranca() == this.isBranca()) {
			return false;
		}
				
		//String dire��o ="";
		if( x > 1 || y > 1) {
			return false;
		}
		
			if(!pm) {
				this.primeiroM = false;
			}		
		return true;
	}
	
	
}
