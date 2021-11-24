
public class Rainha extends Pe�a {
	public int identidade;
	public Rainha (boolean branca, int identidade) {
		 super(branca,identidade);
	}
	public Quadrado fRainha;
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		
		//proibe de mover a pe�a para um lugar que tenha uma pe�a de mesma cor
		if(fim.getPe�a().isBranca() == this.isBranca()) {
			return false;
		}
		int x = Math.abs(fim.getX() - inicio.getX());
		int y = Math.abs(fim.getY() - inicio.getY() );
		
		//proibi��o do movimento exclusivo do cavalo
			if(x * y == 2) {
				return false;
			}
		
			//Movimentos estilo Bispo
			
			String dire��o = "";
			//SE
			if(fim.getY() > inicio.getY() && fim.getX() > inicio.getX()) {
				dire��o = "sudeste";
			}
			
				
			//SO
			if(fim.getY() > inicio.getY() && fim.getX() < inicio.getX()) {
				dire��o = "sudoeste";
			}
				
			//NE
			if(fim.getY() < inicio.getY() && fim.getX() > inicio.getX()) {
				dire��o = "nordeste";
			}
				
			//NO
			if(fim.getY() < inicio.getY() && fim.getX() < inicio.getX()) {
				dire��o = "noroeste";
			}
			
			if(dire��o.equals("sudeste")) {
				//int x = Math.abs(fim.getX() - inicio.getX());
				
				for(int i=1; i<x ; i++) {
						if(tabuleiro.campo[inicio.getX()+i][inicio.getY()+i].getPe�a() !=null) {
							return false;
						}
				}
				
			}
			//Processo de verifica��o de pe�as no caminho do movimento desejado
			if(dire��o.equals("sudoeste")) {
				//int x = Math.abs(fim.getX() - inicio.getX());
				
				for(int i=1; i<x ; i++) {
						if(tabuleiro.campo[inicio.getX()-i][inicio.getY()+i].getPe�a() !=null) {
							return false;
						}
				}
				
			}
			
			if(dire��o.equals("nordeste")) {
				//int x = Math.abs(fim.getX() - inicio.getX());
				
				for(int i=1; i<x ; i++) {
						if(tabuleiro.campo[inicio.getX()+i][inicio.getY()-i].getPe�a() !=null) {
							return false;
						}
				}
				
			}
			
			if(dire��o.equals("noroeste")) {
				//int x = Math.abs(fim.getX() - inicio.getX());
				
				for(int i=1; i<x ; i++) {
						if(tabuleiro.campo[inicio.getX()-i][inicio.getY()-i].getPe�a() !=null) {
							return false;
						}
				}
				
			}
			
			//Movimentos estilo Torre
			
			
			if(fim.getY() > inicio.getY()) {
				dire��o = "leste";
			}
			
			if(fim.getY() < inicio.getY()) {
				dire��o = "oeste";
			}
			
			if(fim.getX() > inicio.getX()) {
				dire��o ="norte";
			}
			
			if(fim.getX() < inicio.getX()) {
				dire��o = "sul";
			}

			if(dire��o.equals("sul")) {
				int movimento = Math.abs(fim.getY() - inicio.getY());
				for(int i=1; i<movimento ;i++) {
					if(tabuleiro.campo[inicio.getX()+i][inicio.getY()].getPe�a()!=null) {
						return false;
					}				
				}
			}
			
			if(dire��o.equals("norte")) {
				int movimento = Math.abs(fim.getY() - inicio.getY());
				for(int i=1; i<movimento ;i++) {
					if(tabuleiro.campo[inicio.getX()-i][inicio.getY()].getPe�a()!=null) {
						return false;
					}				
				}
			}
			
			if(dire��o.equals("leste")) {
				int movimento = Math.abs(fim.getX() - inicio.getX());
				for(int i=1; i<movimento ;i++) {
					if(tabuleiro.campo[inicio.getX()][inicio.getY()+i].getPe�a()!=null) {
						return false;
					}				
				}
			}
			if(dire��o.equals("oeste")) {
				int movimento = Math.abs(fim.getX() - inicio.getX());
				for(int i=1; i<movimento ;i++) {
					if(tabuleiro.campo[inicio.getX()][inicio.getY()-i].getPe�a()!=null) {
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
