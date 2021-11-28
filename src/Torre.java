
public class Torre extends Peça{
	public int identidade;
	public boolean primeiroMovimento;
	public Torre (boolean branca, int identidade) {
		 super(branca,identidade);
		 primeiroMovimento = true;
	}
	
	public void setPrimeiroMovimento(boolean primeiroMovimento) {
		this.primeiroMovimento = primeiroMovimento;
	}
	
	public boolean getPrimeiroMovimento() {
		return primeiroMovimento;
	}
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		
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
				if(tabuleiro.campo[inicio.getX()+i][inicio.getY()].getPeça()!=null) {
					return false;
				}				
			}
		}
		
		if(direção.equals("norte")) {
			int movimento = Math.abs(fim.getX() - inicio.getX());
			for(int i=1; i<movimento ;i++) {
				if(tabuleiro.campo[inicio.getX()-i][inicio.getY()].getPeça()!=null) {
					return false;
				}				
			}
		}
		
		if(direção.equals("leste")) {
			int movimento = Math.abs(fim.getY() - inicio.getY());
			for(int i=1; i<movimento ;i++) {
				if(tabuleiro.campo[inicio.getX()][inicio.getY()+i].getPeça()!=null) {
					return false;
				}				
			}
		}
		
		if(direção.equals("oeste")) {
			int movimento = Math.abs(fim.getY() - inicio.getY());
			for(int i=1; i<movimento ;i++) {
				if(tabuleiro.campo[inicio.getX()][inicio.getY()-i].getPeça()!=null) {
					return false;
				}				
			}
		}
		
		/*
		fTorre = tabuleiro.campo[fim.getX()][fim.getY()];
		Tabuleiro tfTorre = new Tabuleiro();
		tfTorre = tabuleiro;
		tfTorre.campo[fim.getX()][fim.getY()] = fTorre;
		
		Xeque xeqBispo = new Xeque();
		if(xeqBispo.xequedetect(tfTorre, this.isBranca())){
			return false;
		}
		*/
		setPrimeiroMovimento(false);
		return true;
	}
}
