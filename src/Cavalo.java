
public class Cavalo extends Peça{
	public int identidade;
	public Cavalo (boolean branca, int identidade) {
		 super(branca,identidade);
		
	}
	public Quadrado fCavalo;
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		
		//proibe de mover a peça para um lugar que tenha uma peça de mesma cor
		if(fim.getPeça() != null && fim.getPeça().isBranca() == this.isBranca()) {
			return false;
		}
		
		int x = Math.abs(fim.getX() - inicio.getX());
		int y = Math.abs(fim.getY() - inicio.getY() );
		
		    //Proibição de qualquer movimento além do exclusivo para cavalos
			if(x * y != 2) {
				return false;
			}
			/*
			fCavalo = tabuleiro.campo[fim.getX()][fim.getY()];
			Tabuleiro tfCavalo = new Tabuleiro();
			tfCavalo = tabuleiro;
			tfCavalo.campo[fim.getX()][fim.getY()] = fCavalo;
			
			Xeque xeqBispo = new Xeque();
			if(xeqBispo.xequedetect(tfCavalo, this.isBranca())){
				return false;
			}
			*/
		return true;
	}

}
