
public class Bispo extends Peça{
	public Bispo (boolean branca) {
		 super(branca);
	}
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		
		//proibe de mover a peça para um lugar que tenha uma peça de mesma cor
		if(fim.getPeça().isBranca() == this.isBranca()) {
			return false;
		}
		
		if(fim.getX() == inicio.getX() || fim.getY() == inicio.getY()) {
			return false;
		}
		
		
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
			int x = Math.abs(fim.getX() - inicio.getX());
			
			for(int i=1; i<x ; i++) {
					if(tabuleiro.campo[inicio.getX()+i][inicio.getY()+i].getPeça() !=null) {
						return false;
					}
			}
			
		}
		//Processo de verificação de peças no caminho do movimento desejado
		if(direção.equals("sudoeste")) {
			int x = Math.abs(fim.getX() - inicio.getX());
			
			for(int i=1; i<x ; i++) {
					if(tabuleiro.campo[inicio.getX()-i][inicio.getY()+i].getPeça() !=null) {
						return false;
					}
			}
			
		}
		
		if(direção.equals("nordeste")) {
			int x = Math.abs(fim.getX() - inicio.getX());
			
			for(int i=1; i<x ; i++) {
					if(tabuleiro.campo[inicio.getX()+i][inicio.getY()-i].getPeça() !=null) {
						return false;
					}
			}
			
		}
		
		if(direção.equals("noroeste")) {
			int x = Math.abs(fim.getX() - inicio.getX());
			
			for(int i=1; i<x ; i++) {
					if(tabuleiro.campo[inicio.getX()-i][inicio.getY()-i].getPeça() !=null) {
						return false;
					}
			}
			
		}

		return true;
	}

}
