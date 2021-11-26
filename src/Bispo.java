
public class Bispo extends Peça{
	public int identidade;
	public Bispo (boolean branca,int identidade) {
		 super(branca,identidade);

	}
	
	public Quadrado fBispo;
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		//proibe de mover a peça para um lugar que tenha uma peça de mesma cor
		if(fim.getPeça() != null && fim.getPeça().isBranca() == this.isBranca()) {
			return false;
		}
		
		if(fim.getX() == inicio.getX()) {
			return false;
		}
		
		if(fim.getY() == inicio.getY()) {
			return false;
		}
		
		int z = Math.abs(fim.getX() - inicio.getX()),n=Math.abs(fim.getY() - inicio.getY());
		
		if(z != n) {
			return false;
		}
	
		
		String direção = "";
		
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
		
		int x = Math.abs(fim.getX() - inicio.getX());
		
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
			
		
		/*
		fBispo = tabuleiro.campo[fim.getX()][fim.getY()];
		Tabuleiro tfBispo = new Tabuleiro();
		tfBispo = tabuleiro;
		tfBispo.campo[fim.getX()][fim.getY()] = fBispo;
		
		Xeque xeqBispo = new Xeque();
		if(xeqBispo.xequedetect(tfBispo, this.isBranca())){
			return false;
		}
		 */
		return true;
	}

}
