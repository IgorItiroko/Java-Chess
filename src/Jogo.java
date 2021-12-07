
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Jogo{
	@SuppressWarnings("rawtypes")
	public JComboBox opções;
	public Tabuleiro tabuleiro;
	public static Jogador[] jogadores = new Jogador[2];
	public Jogador turno;
	public List<String> Jogadas;
	public String codigo[];
	public Telainicial tela;
	public Mov ultimoMovimento;
	public int escolhaP = 0;
	public int movimentoj2 = 0;
	public int movimentoj1 = 0;
	
	/// Inicializa um jogo, com o tabuleiro, e os jogadores.
	void iniciar(Jogador j1, Jogador j2)
	{
		jogadores[0] = j1;
		jogadores[1] = j2;
		tabuleiro = new Tabuleiro();
		if(j1.isLadobranco()) {
			this.turno = j1;
		}
		else {
			this.turno = j2;
		}
	}
	
	/// Efetua uma jogada sem nenhuma confirmação, usada para polpar tempo de execução do código.
	public void pulaCanMove(int inix, int iniy, int fimx, int fimy)
    {
        Quadrado iniPos = tabuleiro.validade(inix,iniy);
        Quadrado fimPos = tabuleiro.validade(fimx, fimy);
        Mov move = new Mov(iniPos,fimPos);
        move.getFim().setPeça(move.getIni().getPeça());
        move.getIni().setPeça(null);
    }

	/// Função que promove o peão uma vez que este chega na ultima peça do tabuleiro.
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void promovePeao(boolean branco) {
			if(branco) {
				for(int i = 0;i<8; i++) {
					if(Tabuleiro.campo[7][i].getPeça() != null) {
						if(Tabuleiro.campo[7][i].getPeça().getIdentidade() == 1 && Tabuleiro.campo[7][i].getPeça().isBranca() ) {
							do {
								Object[] optionsGC = {"<Selecione a Opção Desejada>", "Torre","Cavalo","Bispo","Rainha"};						/// As opções de promoção são dadas por um JOption																	;
							     opções = new JComboBox(optionsGC);
							     JOptionPane.showMessageDialog(null, opções, "Selecione a peça na qual o peão se tornará.",
							          JOptionPane.INFORMATION_MESSAGE);
							     	escolhaP = opções.getSelectedIndex();
							     	
							     	switch(escolhaP){
							     		case 1:
							     			Tabuleiro.campo[7][i] = null;
							     			Tabuleiro.campo[7][i] = new Quadrado(7, i, new Torre(true,2,true));break;
							     		case 2:
							     			Tabuleiro.campo[7][i] = null;
							     			Tabuleiro.campo[7][i] = new Quadrado(7, i, new Cavalo(true,3,true));break;
							     		case 3:
							     			Tabuleiro.campo[7][i] = null;
							     			Tabuleiro.campo[7][i] = new Quadrado(7, i, new Bispo(true,4,true));break;
							     		case 4:
							     			Tabuleiro.campo[7][i] = null;
							     			Tabuleiro.campo[7][i] = new Quadrado(7, i, new Rainha(true,6,true));break;
							     		default: break;
							     	}
							}while(escolhaP == 0);
								 
								     	
							}
							
						}
						
					}
					
				}
			
			if(!branco) {
				for(int i = 0;i<8; i++) {
					if(Tabuleiro.campo[0][i].getPeça() != null) {
						if(Tabuleiro.campo[0][i].getPeça().getIdentidade() == 1 && !Tabuleiro.campo[0][i].getPeça().isBranca()) {
							do {
								Object[] optionsGC = {"<Selecione a Opção Desejada>", "Torre","Cavalo","Bispo","Rainha"}																						;
							     opções = new JComboBox(optionsGC);
							     JOptionPane.showMessageDialog(null, opções, "Selecione a peça na qual o peão se tornará.",
							          JOptionPane.INFORMATION_MESSAGE);
							     	escolhaP = opções.getSelectedIndex();
							     	
							     	switch(escolhaP){
							     		case 1:
							     			Tabuleiro.campo[0][i] = null;
							     			Tabuleiro.campo[0][i] = new Quadrado(0, i, new Torre(false,2,true));break;
							     		case 2:
							     			Tabuleiro.campo[0][i] = null;
							     			Tabuleiro.campo[0][i] = new Quadrado(0, i, new Cavalo(false,3,true));break;
							     		case 3:
							     			Tabuleiro.campo[0][i] = null;
							     			Tabuleiro.campo[0][i] = new Quadrado(0, i, new Bispo(false,4,true));break;
							     		case 4:
							     			Tabuleiro.campo[0][i] = null;
							     			Tabuleiro.campo[0][i] = new Quadrado(0, i, new Rainha(false,6,true));break;
							     		default: break;
							     	}
							}while(escolhaP == 0);
							
						}
						
					}
					
				}
			}
			
		
		
	}
	
	/// Condicional do empate 2
	  public boolean faltaPeças(Tabuleiro tabuleiro)
	    {
	        for(int i = 0; i < 8; i++)
	        {
	            for(int j = 0; j < 8; j++)
	            {
	                if(Tabuleiro.campo[i][j].getPeça() != null && Tabuleiro.campo[i][j].getPeça().getIdentidade() != 5)
	                    return false;
	            }
	        }
	        return true;
	    }
	
	  /// Detector de xeque
    public boolean xequedetect(Tabuleiro tabuleiro, boolean branco)
    {
        if(branco == true)
        {
            for(int i = 0; i < 8; i++)
            {
                for(int j = 0; j < 8; j++)
                {
                    if(Tabuleiro.campo[i][j].getPeça() != null && (Tabuleiro.campo[i][j].getPeça().getIdentidade() == 5 && Tabuleiro.campo[i][j].getPeça().isBranca() == true ) )
                    {
                        for(int p = 0; p < 8; p++)
                        {
                            for(int q = 0; q < 8; q++)
                            {
                            	if(Tabuleiro.campo[p][q].getPeça() != null)
                                    if(!Tabuleiro.campo[p][q].getPeça().isBranca())
                                    {	
                                        if(Tabuleiro.campo[p][q].getPeça().canMove(tabuleiro, Tabuleiro.campo[p][q], Tabuleiro.campo[i][j],true))
                                            return true;
                                    }
                            }
                        }
                    }
                }
            }
        }
        
        else
        {
            for(int i = 0; i < 8; i++)
            {
                for(int j = 0; j < 8; j++)
                {
                    if(Tabuleiro.campo[i][j].getPeça() != null && (Tabuleiro.campo[i][j].getPeça().getIdentidade() == 5 && !Tabuleiro.campo[i][j].getPeça().isBranca() == true ) )
                    {
                        for(int p = 0; p < 8; p++)
                        {
                            for(int q = 0; q < 8; q++)
                            {
                            	if(Tabuleiro.campo[p][q].getPeça() != null)
                                    if(Tabuleiro.campo[p][q].getPeça().isBranca())
                                    {	
                                        if(Tabuleiro.campo[p][q].getPeça().canMove(tabuleiro, Tabuleiro.campo[p][q], Tabuleiro.campo[i][j],true))
                                            return true;
                                    }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public boolean xequematedetect(Tabuleiro tabuleiro, boolean branco)
    {
        if(branco)
        {
            for(int i = 0; i < 8; i++)
            {
                for(int j = 0; j < 8; j++)
                {
                    if(Tabuleiro.campo[i][j].getPeça() != null && Tabuleiro.campo[i][j].getPeça().isBranca())
                    {
                        for(int p = 0; p < 8; p++)
                        {
                            for(int q = 0; q < 8; q++)
                            {
                                this.construtorJogada(this.turno, i, j ,p ,q, true);
                                if(xequedetect(this.tabuleiro,this.turno.isLadobranco()))
                                {
                                    desfazerJogada(this.ultimoMovimento);
                                }
                                else
                                {
                                    desfazerJogada(this.ultimoMovimento);
                                    return false;
                                }
                            }
                        }
                    }
                    
                }
            }
        }
        else
        {
            for(int i = 0; i < 8; i++)
            {
                for(int j = 0; j < 8; j++)
                {
                    if(Tabuleiro.campo[i][j].getPeça() != null && !Tabuleiro.campo[i][j].getPeça().isBranca())
                    {
                        for(int p = 0; p < 8; p++)
                        {
                            for(int q = 0; q < 8; q++)
                            {
                                this.construtorJogada(this.turno, i, j ,p ,q, true);
                                if(xequedetect(this.tabuleiro,this.turno.isLadobranco()))
                                {
                                    desfazerJogada(this.ultimoMovimento);
                                }
                                else
                                {
                                    desfazerJogada(this.ultimoMovimento);
                                    return false;
                                }
                            }
                        }
                    }
                    
                }
            }
        }    
        return true;
    }
    
    /// Efetua o Roque
    public boolean isRoque(Tabuleiro tabuleiro, boolean branco, boolean direita) {
    	if(branco) {
    		if(direita) {
    			if(Tabuleiro.campo[0][4].getPeça() == null) {
    				return false;
    			}
    			if(Tabuleiro.campo[0][7].getPeça() == null) {
        			return false;
    			}
    			if(Tabuleiro.campo[0][4].getPeça().getIdentidade() != 5) {
        			return false;
    			}
    			if(Tabuleiro.campo[0][7].getPeça().getIdentidade() != 2) {
        			return false;
    			}
    			if(!Tabuleiro.campo[0][4].getPeça().primeiroM) {
    				return false;
    			}
    			if(!Tabuleiro.campo[0][7].getPeça().primeiroM) {
    				return false;
    			}
    			
    			if(!Tabuleiro.campo[0][7].getPeça().canMove(tabuleiro, Tabuleiro.campo[0][7], Tabuleiro.campo[0][5],true)) {
    				return false;
    			}
    			if(xequedetect(tabuleiro,true)) {
    				return false;
    			}
    			pulaCanMove(0,4,0,5);
    			if(xequedetect(tabuleiro,true)) {
    				pulaCanMove(0,5,0,4);
    				return false;
    			}
    			
    			pulaCanMove(0,5,0,6);
    			if(xequedetect(tabuleiro,true)) {
    				pulaCanMove(0,6,0,4);
    				return false;
    			}
    			
    			pulaCanMove(0,7,0,5);
    			Tabuleiro.campo[0][5].getPeça().primeiroM = false;
    			Tabuleiro.campo[0][6].getPeça().primeiroM = false;
    		}
    		else {
    			if(Tabuleiro.campo[0][4].getPeça() == null) {
    				return false;
    			}
    			if(Tabuleiro.campo[0][0].getPeça() == null) {
        			return false;
    			}
    			if(Tabuleiro.campo[0][4].getPeça().getIdentidade() != 5) {
        			return false;
    			}
    			if(Tabuleiro.campo[0][0].getPeça().getIdentidade() != 2) {
        			return false;
    			}
    			if(!Tabuleiro.campo[0][4].getPeça().primeiroM) {
    				return false;
    			}
    			if(!Tabuleiro.campo[0][0].getPeça().primeiroM) {
    				return false;
    			}
    			
    			if(!Tabuleiro.campo[0][0].getPeça().canMove(tabuleiro, Tabuleiro.campo[0][0], Tabuleiro.campo[0][3],true)) {
    				return false;
    			}
    			
    			if(xequedetect(tabuleiro,true)) {
    				return false;
    			}
    			
    			pulaCanMove(0,4,0,3);
    			if(xequedetect(tabuleiro,true)) {
    				pulaCanMove(0,3,0,4);
    				return false;
    			}
    			
    			pulaCanMove(0,3,0,2);
    			if(xequedetect(tabuleiro,true)) {
    				pulaCanMove(0,2,0,4);
    				return false;
    			}
    			
    			pulaCanMove(0,0,0,3);
    			Tabuleiro.campo[0][3].getPeça().setPrimeiroMovimento(false);
    			Tabuleiro.campo[0][2].getPeça().setPrimeiroMovimento(false);
    		}
    	}
    	else {
    		if(direita) {
    			if(Tabuleiro.campo[7][4].getPeça() == null) {
    				return false;
    			}
    			if(Tabuleiro.campo[7][7].getPeça() == null) {
        			return false;
    			}
    			if(Tabuleiro.campo[7][4].getPeça().getIdentidade() != 5) {
        			return false;
    			}
    			if(Tabuleiro.campo[7][7].getPeça().getIdentidade() != 2) {
        			return false;
    			}
    			if(!Tabuleiro.campo[7][4].getPeça().primeiroM) {
    				return false;
    			}
    			if(!Tabuleiro.campo[7][7].getPeça().primeiroM) {
    				return false;
    			}
    			
    			if(!Tabuleiro.campo[7][7].getPeça().canMove(tabuleiro, Tabuleiro.campo[7][7], Tabuleiro.campo[7][5],true)) {
    				return false;
    			}
    			
    			if(xequedetect(tabuleiro,false)) {
    				return false;
    			}
    			
    			pulaCanMove(7,4,7,5);
    			if(xequedetect(tabuleiro,false)) {
    				pulaCanMove(7,5,7,4);
    				return false;
    			}
    			
    			pulaCanMove(7,5,7,6);
    			if(xequedetect(tabuleiro,false)) {
    				pulaCanMove(7,6,7,4);
    				return false;
    			}
    			
    			pulaCanMove(7,7,7,5);
    			Tabuleiro.campo[7][5].getPeça().primeiroM = false;
    			Tabuleiro.campo[7][6].getPeça().primeiroM = false;
    		}
    		else {
    			if(Tabuleiro.campo[7][4].getPeça() == null) {
    				return false;
    			}
    			if(Tabuleiro.campo[7][0].getPeça() == null) {
        			return false;
    			}
    			if(Tabuleiro.campo[7][4].getPeça().getIdentidade() != 5) {
        			return false;
    			}
    			if(Tabuleiro.campo[7][0].getPeça().getIdentidade() != 2) {
        			return false;
    			}
    			if(!Tabuleiro.campo[7][4].getPeça().primeiroM) {
    				return false;
    			}
    			if(!Tabuleiro.campo[7][0].getPeça().primeiroM) {
    				return false;
    			}
    			
    			if(!Tabuleiro.campo[7][0].getPeça().canMove(tabuleiro, Tabuleiro.campo[7][0], Tabuleiro.campo[7][3],true)) {
    				return false;
    			}
    			if(xequedetect(tabuleiro,false)) {
    				return false;
    			}
    			pulaCanMove(7,4,7,3);
    			if(xequedetect(tabuleiro,false)) {
    				pulaCanMove(7,3,7,4);
    				return false;
    			}
    			
    			pulaCanMove(7,3,7,2);
    			if(xequedetect(tabuleiro,false)) {
    				pulaCanMove(7,2,7,4);
    				return false;
    			}
    			
    			pulaCanMove(7,0,7,3);
    			Tabuleiro.campo[7][3].getPeça().primeiroM = false;
    			Tabuleiro.campo[7][2].getPeça().primeiroM = false;

    		}	
    	}
    	return true;
    }
    
    /// Mecanismo que realiza a jogada
    public boolean construtorJogada(Jogador j1, int Xinicial, int Yinicial, int Xfinal, int Yfinal,boolean verific)
    {
        Quadrado iniPos = tabuleiro.validade(Xinicial, Yinicial);
        Quadrado fimPos = tabuleiro.validade(Xfinal, Yfinal);
        Mov move = new Mov(iniPos,fimPos);
        this.ultimoMovimento = move;
        ultimoMovimento.setPmov(ultimoMovimento.getIni().getPeça());
        ultimoMovimento.setPmorta(ultimoMovimento.getFim().getPeça());
       
        return this.Jogada(move,j1,verific);
    }
	
	
	/// Função que desfaz uma jogada
    public void desfazerJogada(Mov move)
    {

        Tabuleiro.campo[move.getIni().getX()][move.getIni().getY()].setPeça(move.getPmov());
        Tabuleiro.campo[move.getFim().getX()][move.getFim().getY()].setPeça(move.getPmorta());
    }
    
	public Mov getUltimoMovimento() {
        return ultimoMovimento;
    }
    
    /// Função para mudar o turno
    public void mudaTurno() {
    	if(this.turno == jogadores[0])
        {
            this.turno = jogadores[1];
        }
        else {
            this.turno = jogadores[0];
        }
    }
    
    /// Verificador de jogada, esse envolve mais do que só a peça, envolve o tabuleiro e a condição do jogo.
    public boolean Jogada(Mov move, Jogador j, boolean verific)
    {
        Peça escolhida = move.getIni().getPeça();
        if (escolhida == null)
        {
            return false;
        }
        
        if(!verific)
        {
            if(j != turno)
            {
                return false;
            }
        }
	
        
        if(escolhida.isBranca() != j.isLadobranco())
        {
            return false;
        }
        
        if (!escolhida.canMove(tabuleiro, move.getIni(), move.getFim(),false)) {
            return false;
        }
        
        Peça destino = move.getFim().getPeça();
        if(destino != null)
        {
            destino.setViva(false);
            move.setPmorta(destino);
        }
        else
            move.setPmorta(null);
        
        
        move.getFim().setPeça(move.getIni().getPeça());
        move.getIni().setPeça(null);
        
        if (xequedetect(tabuleiro, j.isLadobranco()))
        {
            desfazerJogada(this.ultimoMovimento);
            return false;
        }
        
        if(!verific)
        {
            if(this.turno == jogadores[0])
            {
                this.turno = jogadores[1];
            }
            else {
                this.turno = jogadores[0];
            }
        }
		
        promovePeao(!this.turno.isLadobranco());
        
        
        if(!verific) {
            if(this.turno == jogadores [0]) {
                    movimentoj1 ++;
                    if(this.tabuleiro.campo[move.getIni().getX()][move.getIni().getY()].getPeça() != null) {
                        if(this.tabuleiro.campo[move.getIni().getX()][move.getIni().getY()].getPeça().getIdentidade() == 1) {
                            movimentoj1 =0;
                        }
                        if(this.tabuleiro.campo[move.getFim().getX()][move.getFim().getY()].getPeça() != null) {
                            movimentoj1 = 0;
                        }
                    
                    }
                    
                }
            else {
                movimentoj2 ++;
                if(this.tabuleiro.campo[move.getIni().getX()][move.getIni().getY()].getPeça() != null) {
                    if(this.tabuleiro.campo[move.getIni().getX()][move.getIni().getY()].getPeça().getIdentidade() == 1) {
                        movimentoj2 =0;
                        }
                        if(this.tabuleiro.campo[move.getFim().getX()][move.getFim().getY()].getPeça() != null) {
                            movimentoj2 = 0;
                        }
                    
                    }
                    
                }
                
            }
        
        return true;

        
    }

    /// Quando uma jogada é realizada ela deve ser codificada para que possa ser reproduzida futuramente na simulação.
    String codificaJogada(int xi, int yi, int xf, int yf)
    {
    	String codigo = new String();
    	codigo = "";
    	
    	switch(xi)
    	{
    	case 0: {codigo = codigo + "a"; break;}
    	case 1: {codigo = codigo + "b"; break;}
    	case 2: {codigo = codigo + "c"; break;}
    	case 3: {codigo = codigo + "d"; break;}
    	case 4: {codigo = codigo + "e"; break;}
    	case 5: {codigo = codigo + "f"; break;}
    	case 6: {codigo = codigo + "g"; break;}
    	case 7: {codigo = codigo + "h"; break;}
    	}
    	codigo = codigo + yi;
    	codigo = codigo + " ";
    	switch(xf)
    	{
    	case 0: {codigo = codigo + "a"; break;}
    	case 1: {codigo = codigo + "b"; break;}
    	case 2: {codigo = codigo + "c"; break;}
    	case 3: {codigo = codigo + "d"; break;}
    	case 4: {codigo = codigo + "e"; break;}
    	case 5: {codigo = codigo + "f"; break;}
    	case 6: {codigo = codigo + "g"; break;}
    	case 7: {codigo = codigo + "h"; break;}
    	}
    	codigo = codigo + yf; 
    	return codigo;
    }
}