
public class Peão extends Peça{
	public boolean primeiroMovimento;
	public int identidade;
	public Peão (boolean branca, int identidade) {
		 super(branca,identidade);
		 primeiroMovimento = true;

	}
	public Quadrado fPeão;
	
	public void setPrimeiroMovimento(boolean primeiroMovimento) {
		this.primeiroMovimento = primeiroMovimento;
	}
	
	public boolean getPrimeiroMovimento() {
		return primeiroMovimento;
	}
	
	public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim) {
		
		int x = Math.abs(fim.getX() - inicio.getX());
		
		//proibe de mover a peça mais do que 2 caso não seja o primeiro movimento
		if( getPrimeiroMovimento() == true) {
			if(x >2)
				return false;
		}
		
		if(getPrimeiroMovimento() == false && x>1) {
			return false;
		}
				
		//proibe de mover a peça na diagonal caso não haja nenhuma peça do oponente
		if(tabuleiro.campo[inicio.getX() + 1][inicio.getY() + 1].getPeça() == null) {
			return false;
		}
				
		//proibe de mover a peça para um lugar que tenha uma peça de mesma cor
		if(fim.getPeça().isBranca() == this.isBranca()) {
			return false;
		}
		//proibe de mover a peça na horizontal
		if(fim.getX() != inicio.getX() && fim.getY() == inicio.getY()) {
			return false;
		}
		
		String direção = "";
		if(fim.getY() > inicio.getY()) {
			direção = "sul";
		}
		
		if(fim.getY() < inicio.getY()) {
			direção = "norte";
		}
		
		//processos de verificação de peças no caminho desejado
		if(direção.equals("sul")) {
				if(tabuleiro.campo[inicio.getX()][inicio.getY()+1].getPeça()!=null) {
					return false;					
			}
		}
		
		if(direção.equals("norte")) {
				if(tabuleiro.campo[inicio.getX()][inicio.getY()-1].getPeça()!=null) {
					return false;
				}				
			}
		fPeão = tabuleiro.campo[fim.getX()][fim.getY()];
		Tabuleiro tfPeão = new Tabuleiro();
		tfPeão = tabuleiro;
		tfPeão.campo[fim.getX()][fim.getY()] = fPeão;
		
		Xeque xeqBispo = new Xeque();
		if(xeqBispo.xequedetect(tfPeão, this.isBranca())){
			return false;
		}
		setPrimeiroMovimento(false);
		return true;
	}

}
