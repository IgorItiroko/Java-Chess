
public class Torre extends Pe�a{
	public Torre (boolean branca) {
		 super(branca);
	}
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		
		//proibe de mover a pe�a para um lugar que tenha uma pe�a de mesma cor
		if(fim.getPe�a().isBranca() == this.isBranca()) {
			return false;
		}
		//proibe de mover a torre na diagonal
		if(inicio.getX() != fim.getX() && inicio.getY() != fim.getY()  ) {
			return false;
		}
		
		String dire��o ="";
		
		if(fim.getY() > inicio.getY()) {
			dire��o = "sul";
		}
		
		if(fim.getY() < inicio.getY()) {
			dire��o = "norte";
		}
		
		if(fim.getX() > inicio.getX()) {
			dire��o ="leste";
		}
		
		if(fim.getX() < inicio.getX()) {
			dire��o = "oeste";
		}

		if(dire��o.equals("sul")) {
			int movimento = Math.abs(fim.getY() - inicio.getY());
			for(int i=1; i<movimento ;i++) {
				if(tabuleiro.campo[inicio.getX()][inicio.getY()+i].getPe�a()!=null) {
					return false;
				}				
			}
		}
		
		if(dire��o.equals("norte")) {
			int movimento = Math.abs(fim.getY() - inicio.getY());
			for(int i=1; i<movimento ;i++) {
				if(tabuleiro.campo[inicio.getX()][inicio.getY()-i].getPe�a()!=null) {
					return false;
				}				
			}
		}
		
		if(dire��o.equals("leste")) {
			int movimento = Math.abs(fim.getX() - inicio.getX());
			for(int i=1; i<movimento ;i++) {
				if(tabuleiro.campo[inicio.getX()+i][inicio.getY()].getPe�a()!=null) {
					return false;
				}				
			}
		}
		if(dire��o.equals("oeste")) {
			int movimento = Math.abs(fim.getX() - inicio.getX());
			for(int i=1; i<movimento ;i++) {
				if(tabuleiro.campo[inicio.getX()-i][inicio.getY()].getPe�a()!=null) {
					return false;
				}				
			}
		}
		
		return true;
	}
}
