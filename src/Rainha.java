
public class Rainha extends Peça {
	public int identidade;
	public Rainha (boolean branca, int identidade) {
		 super(branca,identidade);
	}
	public Quadrado fRainha;
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		
		//proibe de mover a peça para um lugar que tenha uma peça de mesma cor
		if(fim.getPeça().isBranca() == this.isBranca()) {
			return false;
		}
		int x = Math.abs(fim.getX() - inicio.getX());
		int y = Math.abs(fim.getY() - inicio.getY() );
		
		//proibição do movimento exclusivo do cavalo
			if(x * y == 2) {
				return false;
			}
		
			//Movimentos estilo Bispo
			
			String direção = "";
			//SE
			if(fim.getY() > inicio.getY() && fim.getX() > inicio.getX()) {
				direção = "sudeste";
			}
			
				
			//SO
			if(fim.getY() > inicio.getY() && fim.getX() < inicio.getX()) {
				direção = "sudoeste";
			}
				
			//NE
			if(fim.getY() < inicio.getY() && fim.getX() > inicio.getX()) {
				direção = "nordeste";
			}
				
			//NO
			if(fim.getY() < inicio.getY() && fim.getX() < inicio.getX()) {
				direção = "noroeste";
			}
			
			if(direção.equals("sudeste")) {
				//int x = Math.abs(fim.getX() - inicio.getX());
				
				for(int i=1; i<x ; i++) {
						if(tabuleiro.campo[inicio.getX()+i][inicio.getY()+i].getPeça() !=null) {
							return false;
						}
				}
				
			}
			//Processo de verificação de peças no caminho do movimento desejado
			if(direção.equals("sudoeste")) {
				//int x = Math.abs(fim.getX() - inicio.getX());
				
				for(int i=1; i<x ; i++) {
						if(tabuleiro.campo[inicio.getX()-i][inicio.getY()+i].getPeça() !=null) {
							return false;
						}
				}
				
			}
			
			if(direção.equals("nordeste")) {
				//int x = Math.abs(fim.getX() - inicio.getX());
				
				for(int i=1; i<x ; i++) {
						if(tabuleiro.campo[inicio.getX()+i][inicio.getY()-i].getPeça() !=null) {
							return false;
						}
				}
				
			}
			
			if(direção.equals("noroeste")) {
				//int x = Math.abs(fim.getX() - inicio.getX());
				
				for(int i=1; i<x ; i++) {
						if(tabuleiro.campo[inicio.getX()-i][inicio.getY()-i].getPeça() !=null) {
							return false;
						}
				}
				
			}
			
			//Movimentos estilo Torre
			
			
			if(fim.getY() > inicio.getY()) {
				direção = "leste";
			}
			
			if(fim.getY() < inicio.getY()) {
				direção = "oeste";
			}
			
			if(fim.getX() > inicio.getX()) {
				direção ="norte";
			}
			
			if(fim.getX() < inicio.getX()) {
				direção = "sul";
			}

			if(direção.equals("sul")) {
				int movimento = Math.abs(fim.getY() - inicio.getY());
				for(int i=1; i<movimento ;i++) {
					if(tabuleiro.campo[inicio.getX()+i][inicio.getY()].getPeça()!=null) {
						return false;
					}				
				}
			}
			
			if(direção.equals("norte")) {
				int movimento = Math.abs(fim.getY() - inicio.getY());
				for(int i=1; i<movimento ;i++) {
					if(tabuleiro.campo[inicio.getX()-i][inicio.getY()].getPeça()!=null) {
						return false;
					}				
				}
			}
			
			if(direção.equals("leste")) {
				int movimento = Math.abs(fim.getX() - inicio.getX());
				for(int i=1; i<movimento ;i++) {
					if(tabuleiro.campo[inicio.getX()][inicio.getY()+i].getPeça()!=null) {
						return false;
					}				
				}
			}
			if(direção.equals("oeste")) {
				int movimento = Math.abs(fim.getX() - inicio.getX());
				for(int i=1; i<movimento ;i++) {
					if(tabuleiro.campo[inicio.getX()][inicio.getY()-i].getPeça()!=null) {
						return false;
					}				
				}
			}
			/*
			fRainha = tabuleiro.campo[fim.getX()][fim.getY()];
			Tabuleiro tfRainha = new Tabuleiro();
			tfRainha = tabuleiro;
			tfRainha.campo[fim.getX()][fim.getY()] = fRainha;
			
			Xeque xeqBispo = new Xeque();
			if(xeqBispo.xequedetect(tfRainha, this.isBranca())){
				return false;
			}
			*/
		return true;
	}

}
