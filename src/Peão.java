
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
			if(fim.getY() != inicio.getY()) {
				return false;
			}
		}
		
		if(getPrimeiroMovimento() == false && x>1) {
			return false;
		}
		
		if(fim.getPeça() != null && fim.getPeça().isBranca() == this.isBranca()) {
			return false;
		}
		
	
		if(this.isBranca() && fim.getX() < inicio.getX()){
			return false;
		}
				
			//Arrumar Peão -> separar entre brancos e pretos e fazer as verificações
		
		if((inicio.getY() +1 < 7 && inicio.getY() -1 > 0 ) && (fim.getX() > inicio.getX()) && this.isBranca()) {
			
			if(tabuleiro.campo[inicio.getX() + 1][inicio.getY() + 1].getPeça() != null ){
				return false;
			}
			if(inicio.getY()+1 > 0) {
				if(tabuleiro.campo[inicio.getX() + 1][inicio.getY() + -1].getPeça() != null){
					return false;
				}
			}
		}
		
		
		
		if((inicio.getY() +1 < 7 || inicio.getY() -1 > 0 ) && (fim.getX() < inicio.getX()) && !this.isBranca()) {
			
			if(tabuleiro.campo[inicio.getX() - 1][inicio.getY() + 1].getPeça() == null){
				return false;
			}
			if(inicio.getY()+1 > 0) {
				if(tabuleiro.campo[inicio.getX() - 1][inicio.getY() + -1].getPeça() == null){
					return false;
				}
			}
		}
		
		//proibe de mover a peça na diagonal caso não haja nenhuma peça do oponente - Bordas
		
		if(inicio.getY() +1 > 7 && (fim.getX() > inicio.getX()) && this.isBranca()){
			
			if(tabuleiro.campo[inicio.getX() + 1][inicio.getY()-1].getPeça() != null && tabuleiro.campo[inicio.getX() + 1][inicio.getY() + 1].getPeça().isBranca() != this.isBranca()){
				return false;
			}
		}
		if(inicio.getY() +1 > 7 && (fim.getX() < inicio.getX()) && !this.isBranca()){
			
			if(tabuleiro.campo[inicio.getX() - 1][inicio.getY() -1].getPeça() != null && tabuleiro.campo[inicio.getX() + 1][inicio.getY() + 1].getPeça().isBranca() != this.isBranca()){
				return false;
			}
		}
		
		
		
			
		
				
		//proibe de mover a peça para um lugar que tenha uma peça de mesma cor
		if(fim.getPeça() != null && fim.getPeça().isBranca() == this.isBranca()) {
			return false;
		}
		//proibe de mover a peça na horizontal
		if(fim.getX() == inicio.getX() && fim.getY() != inicio.getY()) {
			return false;
		}
		
		String direção = "";
		if(fim.getX() > inicio.getX()) {
			direção = "sul";
		}
		
		if(fim.getX() < inicio.getX()) {
			direção = "norte";
		}
		
		//processos de verificação de peças no caminho desejado
		if(direção.equals("sul")) {
				if(tabuleiro.campo[inicio.getX()+1][inicio.getY()].getPeça()!=null) {
					return false;					
			}
		}
		
		if(direção.equals("norte")) {
				if(tabuleiro.campo[inicio.getX()-1][inicio.getY()].getPeça()!=null) {
					return false;
				}				
			}
		

		setPrimeiroMovimento(false);
		return true;
	}

}
