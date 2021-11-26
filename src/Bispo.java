
public class Bispo extends Pe�a{
	public int identidade;
	public Bispo (boolean branca,int identidade) {
		 super(branca,identidade);

	}
	
	public Quadrado fBispo;
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		//proibe de mover a pe�a para um lugar que tenha uma pe�a de mesma cor
		if(fim.getPe�a() != null && fim.getPe�a().isBranca() == this.isBranca()) {
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
	
		
		String dire��o = "";
		
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
		
		int x = Math.abs(fim.getX() - inicio.getX());
		
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
