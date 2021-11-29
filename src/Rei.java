
public class Rei extends Peça {
	public int identidade;
	public boolean primeiroMovimento;
	public Rei (boolean branca,int identidade) {
		 super(branca,identidade);
		 primeiroMovimento = true;

	}
	
	public void setPrimeiroMovimento(boolean primeiroMovimento) {
		this.primeiroMovimento = primeiroMovimento;
	}
	
	public boolean getPrimeiroMovimento() {
		return primeiroMovimento;
	}
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		int x= Math.abs(fim.getX() - inicio.getX());
		int y= Math.abs(fim.getY() - inicio.getY());
		
		/*if(isRoque()) {
		xequedetec;
		setPrimeiroMovimento(false);
		return true;
	}
	*/
		//proibe de mover a peça para um lugar que tenha uma peça de mesma cor
		if(fim.getPeça() != null && fim.getPeça().isBranca() == this.isBranca()) {
			return false;
		}
				
		if(x > 1 || y > 1) {
			return false;
		}
	
		
		setPrimeiroMovimento(false);
		return true;
	}
	
	public boolean isRoque(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		
			//Rei só faz Roque com Torre
			if(tabuleiro.campo[fim.getX()][fim.getY()].getPeça().getIdentidade() != 2) {
				return false;
			}
			//Rei perde o direito do castling caso não seja o seu primeiro movimento
			if(this.getPrimeiroMovimento() == false) {
				return false;
			}
			//Rei perde o direito do Roque caso não seja  primeiro movimento da torre destino
			
			//Rei perde o direito temporario do Roque se houver alguma peça entre o rei e a torre com a qual o roque será efetuado.
			
			//Rei perde o direito temporario do Roque se a casa que o rei ocupa, ou a casa pela qual deve passar, ou ainda a casa a que
			//passará a ocupar, estiver atacada por uma ou mais peças do oponente, ou
			
		
		return true;
	}
}
