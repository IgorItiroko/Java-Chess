
public class Torre extends Peça{
	public Torre (boolean branca) {
		 super(branca);
	}
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		
		//proibe de mover a peça para um lugar que tenha uma peça de mesma cor
		if(fim.getPeça().isBranca() == this.isBranca()) {
			return false;
		}
		//proibe de mover a torre na diagonal
		if(inicio.getX() != fim.getX() && inicio.getY() != fim.getY()  ) {
			return false;
		}
		
		String direção ="";
		
		if(fim.getY() > inicio.getY()) {
			direção = "sul";
		}
		
		if(fim.getY() < inicio.getY()) {
			direção = "norte";
		}
		
		if(fim.getX() > inicio.getX()) {
			direção ="leste";
		}
		
		if(fim.getX() < inicio.getX()) {
			direção = "oeste";
		}

		if(direção.equals("sul")) {
			int movimento = Math.abs(fim.getY() - inicio.getY());
			for(int i=1; i<movimento ;i++) {
				if(tabuleiro.campo[inicio.getX()][inicio.getY()+i].getPeça()!=null) {
					return false;
				}				
			}
		}
		
		if(direção.equals("norte")) {
			int movimento = Math.abs(fim.getY() - inicio.getY());
			for(int i=1; i<movimento ;i++) {
				if(tabuleiro.campo[inicio.getX()][inicio.getY()-i].getPeça()!=null) {
					return false;
				}				
			}
		}
		
		if(direção.equals("leste")) {
			int movimento = Math.abs(fim.getX() - inicio.getX());
			for(int i=1; i<movimento ;i++) {
				if(tabuleiro.campo[inicio.getX()+i][inicio.getY()].getPeça()!=null) {
					return false;
				}				
			}
		}
		if(direção.equals("oeste")) {
			int movimento = Math.abs(fim.getX() - inicio.getX());
			for(int i=1; i<movimento ;i++) {
				if(tabuleiro.campo[inicio.getX()-i][inicio.getY()].getPeça()!=null) {
					return false;
				}				
			}
		}
		
		return true;
	}
}
