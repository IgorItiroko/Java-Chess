
public class Rainha extends Pe�a {
	public int identidade;
	public Rainha (boolean branca, int identidade,boolean primeiroM) {
		 super(branca,identidade,primeiroM);
	}
	public Quadrado fRainha;
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim,boolean pm) {
		
		//proibe de mover a pe�a para um lugar que tenha uma pe�a de mesma cor
		if(fim.getPe�a() != null && fim.getPe�a().isBranca() == this.isBranca()) {
			return false;
		}
		
		int x = Math.abs(fim.getX() - inicio.getX());
		int y = Math.abs(fim.getY() - inicio.getY() );
		
		//proibi��o do movimento exclusivo do cavalo
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
			
			String dire��o = "";
			int key=0;
			
			if(mov.equals("bispo")) {
				key=1;
			
				//SE
				if(fim.getY() > inicio.getY() && fim.getX() > inicio.getX()) {
					dire��o = "sudeste";
				}
				
					
				//NE
				if(fim.getY() > inicio.getY() && fim.getX() < inicio.getX()) {
					dire��o = "nordeste";
				}
					
				//NO
				if(fim.getY() < inicio.getY() && fim.getX() > inicio.getX()) {
					dire��o = "noroeste";
				}
					
				//SO
				if(fim.getY() < inicio.getY() && fim.getX() < inicio.getX()) {
					dire��o = "sudoeste";
				}
				
				//Processo de verifica��o de pe�as no caminho do movimento desejado
				
				if(dire��o.equals("sudeste")) {				
					for(int i=1; i<x ; i++) {
							if(tabuleiro.campo[inicio.getX()+i][inicio.getY()+i].getPe�a() !=null) {
								return false;
							}
					}
				}
					
				if(dire��o.equals("nordeste")) {				
					for(int i=1; i<x ; i++) {
							if(tabuleiro.campo[inicio.getX()-i][inicio.getY()+i].getPe�a() !=null) {
								return false;
							}
					}
				}
				if(dire��o.equals("noroeste")) {				
					for(int i=1; i<x ; i++) {
							if(tabuleiro.campo[inicio.getX()+i][inicio.getY()-i].getPe�a() !=null) {
								return false;
							}
					}
				}
				if(dire��o.equals("sudoeste")) {				
					for(int i=1; i<x ; i++) {
							if(tabuleiro.campo[inicio.getX()-i][inicio.getY()-i].getPe�a() !=null) {
								return false;
							}
					}
				}
		}
			
			//Movimentos estilo Torre
			
			
			if(mov.equals("torre")) {
				key=1;
			
			if(fim.getY() > inicio.getY()) {
				dire��o = "leste";
			}
			
			if(fim.getY() < inicio.getY()) {
				dire��o = "oeste";
			}
			
			if(fim.getX() > inicio.getX()) {
				dire��o ="sul";
			}
			
			if(fim.getX() < inicio.getX()) {
				dire��o = "norte";
			}

			if(dire��o.equals("sul")) {
				int movimento = Math.abs(fim.getX() - inicio.getX());
				for(int i=1; i<movimento ;i++) {
					if(tabuleiro.campo[inicio.getX()+i][inicio.getY()].getPe�a()!=null) {
						return false;
					}				
				}
			}
			
			if(dire��o.equals("norte")) {
				int movimento = Math.abs(fim.getX() - inicio.getX());
				for(int i=1; i<movimento ;i++) {
					if(tabuleiro.campo[inicio.getX()-i][inicio.getY()].getPe�a()!=null) {
						return false;
					}				
				}
			}
			
			if(dire��o.equals("leste")) {
				int movimento = Math.abs(fim.getY() - inicio.getY());
				for(int i=1; i<movimento ;i++) {
					if(tabuleiro.campo[inicio.getX()][inicio.getY()+i].getPe�a()!=null) {
						return false;
					}				
				}
			}
			
			if(dire��o.equals("oeste")) {
				int movimento = Math.abs(fim.getY() - inicio.getY());
				for(int i=1; i<movimento ;i++) {
					if(tabuleiro.campo[inicio.getX()][inicio.getY()-i].getPe�a()!=null) {
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

