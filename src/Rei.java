
public class Rei extends Peça {
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
		//proibe de mover a peça para um lugar que tenha uma peça de mesma cor
		if(fim.getPeça().isBranca() == this.isBranca()) {
			return false;
		}
		//Processo de verificação para uma peça
		Rei= tabuleiro.campo[fim.getX()][fim.getY()];
		final Tabuleiro tabuleiroF;
		tabuleiroF = tabuleiro;
		tabuleiroF.campo[fim.getX()][fim.getY()]=Rei;
	
		
		for(int p=0; p<7 ;p++) {
			for(int q=0; q<7 ; q++) {
				if(tabuleiroF.campo[p][q] != null) {
					if(tabuleiroF.campo[p][q].getPeça().canMove(tabuleiroF, tabuleiroF.campo[p][q], Rei)) {
						return false;
					}
				}		
			}
		}		
		return true;
	}
}
