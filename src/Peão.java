public class Peão extends Peça{
<<<<<<< Updated upstream
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
		
		//Proibe de mover a peça para uma posição onde há uma peça de mesma cor no destino
		if(fim.getPeça() != null && fim.getPeça().isBranca() == this.isBranca()) {
			return false;
		}
		
		
		//proibe de mover a peça mais do que 2 
		if( getPrimeiroMovimento() == true) {
			if(x >2)
				return false;
		}
		
		//proibe de mover a peça mais do que 1 caso não seja o primeiro movimento
		if(getPrimeiroMovimento() == false && x>1) {
			return false;
		}
		
		//proibe de mover a peça na diagonal
		if((fim.getY() != inicio.getY()) && (tabuleiro.campo[fim.getX()][fim.getY()].getPeça() == null)) {
				return false;
			}
		
				
			//Proibe peças brancas de andarem para o norte
			if(this.isBranca() && inicio.getX() > fim.getX()) {
				return false;
			}
			
			//Proibe as peças brancas de andarem para frente caso haja uma peça no local destino
			if(fim.getPeça() != null && this.isBranca() && fim.getX() > inicio.getX() && inicio.getX() +1 == fim.getX()) {
				return false;
			}
			
			
			//Proibe peças pretas de andarem para o sul
			if(!this.isBranca() && inicio.getX() < fim.getX()) {
				return false;
			}
			
			//Proibe as peças pretas de andarem para frente caso haja uma peça no local destino
			if(fim.getPeça() != null && !this.isBranca() && fim.getX() < inicio.getX() && fim.getX() +1 == inicio.getX()) {
				return false;
			} 
										
		
		//proibe de mover a peça na horizontal
		if(fim.getX() == inicio.getX() && fim.getY() != inicio.getY()) {
			return false;
		}
		

		

		setPrimeiroMovimento(false);
		return true;
	}
=======
    public int identidade;
    public Peão (boolean branca, int identidade,boolean primeiroM) {
         super(branca,identidade,primeiroM);
    }
    public boolean canMove(Tabuleiro tabuleiro,Quadrado inicio,Quadrado fim,boolean pm) {
        
        int x = Math.abs(fim.getX() - inicio.getX());
        
        //Proibe de mover a peça para uma posição onde há uma peça de mesma cor no destino
        if(fim.getPeça() != null && fim.getPeça().isBranca() == this.isBranca()) {
            return false;
        }
        
        if(Math.abs(inicio.getY() - fim.getY()) > 1) {
            return false;
        }
        
        //proibe de mover a peça mais do que 2 
        if( this.primeiroM) {
            if(x >2) {
            return false;
            }
            if(this.isBranca()) {
                if(tabuleiro.campo[inicio.getX()+1][inicio.getY()].getPeça()!= null) {
                    return false;
                }
            }
            if(!this.isBranca()) {
                if(tabuleiro.campo[inicio.getX()-1][inicio.getY()].getPeça()!= null) {
                    return false;
                }
            }
        }
        
        //proibe de mover a peça mais do que 1 caso não seja o primeiro movimento
        if(!this.primeiroM && x>1) {
            return false;
        }
        
        //proibe de mover a peça na diagonal
        if((fim.getY() != inicio.getY()) && (tabuleiro.campo[fim.getX()][fim.getY()].getPeça() == null)) {
                return false;
            }
        
                
            //Proibe peças brancas de andarem para o norte
            if(this.isBranca() && inicio.getX() > fim.getX()) {
                return false;
            }
            
            //Proibe peças pretas de andarem para o sul
            if(!this.isBranca() && inicio.getX() < fim.getX()) {
                return false;
            }
            
            if( this.isBranca() && tabuleiro.campo[inicio.getX()+1][inicio.getY()].getPeça() != null && fim.getY() == inicio.getY()) {
                return false;
            }
            
            if( !this.isBranca() && tabuleiro.campo[inicio.getX()-1][inicio.getY()].getPeça() != null && fim.getY() == inicio.getY()) {
                return false;
            }
        
        //proibe de mover a peça na horizontal
        if(fim.getX() == inicio.getX() && fim.getY() != inicio.getY()) {
            return false;
        }
        this.primeiroM = false;
        return true;
    }
>>>>>>> Stashed changes

}