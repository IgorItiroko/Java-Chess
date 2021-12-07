
public class Torre extends Peça{
	public int identidade;
	/// Construtor
	public Torre (boolean branca, int identidade,boolean primeiroM) {
		 super(branca,identidade,primeiroM);
	}
	
	/// valida movimento
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim,boolean pm) {
		
		//proibe de mover a peça para um lugar que tenha uma peça de mesma cor
		if(fim.getPeça() != null && fim.getPeça().isBranca() == this.isBranca()) {
			return false;
		}
		
		//proibe de mover a torre na diagonal
		if(inicio.getX() != fim.getX() && inicio.getY() != fim.getY()  ) {
			return false;
		}
	
		String direção ="";
		
		if(fim.getY() > inicio.getY()) {
			direção = "leste";
		}
		
		if(fim.getY() < inicio.getY()) {
			direção = "oeste";
		}
		
		if(fim.getX() > inicio.getX()) {
			direção ="sul";
		}
		
		if(fim.getX() < inicio.getX()) {
			direção = "norte";
		}

		if(direção.equals("sul")) {
			int movimento = Math.abs(fim.getX() - inicio.getX());
			for(int i=1; i<movimento ;i++) {
				if(Tabuleiro.campo[inicio.getX()+i][inicio.getY()].getPeça()!=null) {
					return false;
				}				
			}
		}
		
		if(direção.equals("norte")) {
			int movimento = Math.abs(fim.getX() - inicio.getX());
			for(int i=1; i<movimento ;i++) {
				if(Tabuleiro.campo[inicio.getX()-i][inicio.getY()].getPeça()!=null) {
					return false;
				}				
			}
		}
		
		if(direção.equals("leste")) {
			int movimento = Math.abs(fim.getY() - inicio.getY());
			for(int i=1; i<movimento ;i++) {
				if(Tabuleiro.campo[inicio.getX()][inicio.getY()+i].getPeça()!=null) {
					return false;
				}				
			}
		}
		
		if(direção.equals("oeste")) {
			int movimento = Math.abs(fim.getY() - inicio.getY());
			for(int i=1; i<movimento ;i++) {
				if(Tabuleiro.campo[inicio.getX()][inicio.getY()-i].getPeça()!=null) {
					return false;
				}				
			}
		}
		
		if(!pm) {
			this.primeiroM = false;
		}
		
		return true;
	}
}
