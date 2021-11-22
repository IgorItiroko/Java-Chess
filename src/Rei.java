
public class Rei extends Pe�a {
	public int identidade;
	public Rei (boolean branca,int identidade) {
		 super(branca,identidade);

	}
	public Quadrado Rei;
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		int x= Math.abs(fim.getX() - inicio.getX());
		int y= Math.abs(fim.getY() - inicio.getY());
								
		if(x*y != 1) {
			return false;
		}
		//proibe de mover a pe�a para um lugar que tenha uma pe�a de mesma cor
		if(fim.getPe�a().isBranca() == this.isBranca()) {
			return false;
		}
		//Processo de verifica��o para uma pe�a
		Rei= tabuleiro.campo[fim.getX()][fim.getY()];
		final Tabuleiro tabuleiroF;
		tabuleiroF = tabuleiro;
		tabuleiroF.campo[fim.getX()][fim.getY()]=Rei;
	
		
		for(int p=0; p<7 ;p++) {
			for(int q=0; q<7 ; q++) {
				if(tabuleiroF.campo[p][q] != null) {
					if(tabuleiroF.campo[p][q].getPe�a().canMove(tabuleiroF, tabuleiroF.campo[p][q], Rei)) {
						return false;
					}
				}		
			}
		}		
		return true;
	}
}
