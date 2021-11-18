
public class Bispo extends Pe�a{
	public Bispo (boolean branca) {
		 super(branca);
	}
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		
		//proibe de mover a pe�a para um lugar que tenha uma pe�a de mesma cor
		if(fim.getPe�a().isBranca() == this.isBranca()) {
			return false;
		}
		
		if(fim.getX() == inicio.getX() || fim.getY() == inicio.getY()) {
			return false;
		}
		
		
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
			int x = Math.abs(fim.getX() - inicio.getX());
			
			for(int i=1; i<x ; i++) {
					if(tabuleiro.campo[inicio.getX()+i][inicio.getY()+i].getPe�a() !=null) {
						return false;
					}
			}
			
		}
		//Processo de verifica��o de pe�as no caminho do movimento desejado
		if(dire��o.equals("sudoeste")) {
			int x = Math.abs(fim.getX() - inicio.getX());
			
			for(int i=1; i<x ; i++) {
					if(tabuleiro.campo[inicio.getX()-i][inicio.getY()+i].getPe�a() !=null) {
						return false;
					}
			}
			
		}
		
		if(dire��o.equals("nordeste")) {
			int x = Math.abs(fim.getX() - inicio.getX());
			
			for(int i=1; i<x ; i++) {
					if(tabuleiro.campo[inicio.getX()+i][inicio.getY()-i].getPe�a() !=null) {
						return false;
					}
			}
			
		}
		
		if(dire��o.equals("noroeste")) {
			int x = Math.abs(fim.getX() - inicio.getX());
			
			for(int i=1; i<x ; i++) {
					if(tabuleiro.campo[inicio.getX()-i][inicio.getY()-i].getPe�a() !=null) {
						return false;
					}
			}
			
		}

		return true;
	}

}
