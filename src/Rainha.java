
public class Rainha extends Peça {
	public int identidade;
	public Rainha (boolean branca, int identidade,boolean primeiroM) {
		 super(branca,identidade,primeiroM);
	}
	public Quadrado fRainha;
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim,boolean pm) {
		
		//proibe de mover a peça para um lugar que tenha uma peça de mesma cor
		if(fim.getPeça() != null && fim.getPeça().isBranca() == this.isBranca()) {
			return false;
		}
		
		int x = Math.abs(fim.getX() - inicio.getX());
		int y = Math.abs(fim.getY() - inicio.getY() );
		
		//proibição do movimento exclusivo do cavalo
			if(x * y == 2) {
				return false;
			}
			
			String mov = "";
			if(fim.getX() == inicio.getX() || fim.getY() == inicio.getY()) {
				mov = "torre";
			}
			
			if(x == y) {
				mov = "bispo";
			}
			
			//Movimentos estilo Bispo
			
			String direção = "";
			int key=0;
			
			if(mov.equals("bispo")) {
				key=1;
			
				//SE
				if(fim.getY() > inicio.getY() && fim.getX() > inicio.getX()) {
					direção = "sudeste";
				}
				
					
				//NE
				if(fim.getY() > inicio.getY() && fim.getX() < inicio.getX()) {
					direção = "nordeste";
				}
					
				//NO
				if(fim.getY() < inicio.getY() && fim.getX() > inicio.getX()) {
					direção = "noroeste";
				}
					
				//SO
				if(fim.getY() < inicio.getY() && fim.getX() < inicio.getX()) {
					direção = "sudoeste";
				}
				
				//Processo de verificação de peças no caminho do movimento desejado
				
				if(direção.equals("sudeste")) {				
					for(int i=1; i<x ; i++) {
							if(tabuleiro.campo[inicio.getX()+i][inicio.getY()+i].getPeça() !=null) {
								return false;
							}
					}
				}
					
				if(direção.equals("nordeste")) {				
					for(int i=1; i<x ; i++) {
							if(tabuleiro.campo[inicio.getX()-i][inicio.getY()+i].getPeça() !=null) {
								return false;
							}
					}
				}
				if(direção.equals("noroeste")) {				
					for(int i=1; i<x ; i++) {
							if(tabuleiro.campo[inicio.getX()+i][inicio.getY()-i].getPeça() !=null) {
								return false;
							}
					}
				}
				if(direção.equals("sudoeste")) {				
					for(int i=1; i<x ; i++) {
							if(tabuleiro.campo[inicio.getX()-i][inicio.getY()-i].getPeça() !=null) {
								return false;
							}
					}
				}
		}
			
			//Movimentos estilo Torre
			
			
			if(mov.equals("torre")) {
				key=1;
			
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
		}
			if(key == 0) {
				return false;
			}
			
		return true;
	}

}

