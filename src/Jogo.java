import java.awt.EventQueue;
import java.util.List;

public class Jogo{
	public Tabuleiro tabuleiro;
	public static Jogador[] jogadores = new Jogador[2];
	public Jogador turno;
	public List<String> Jogadas;
	public String codigo[];
	public Telainicial tela;
	public Mov ultimoMovimento;
	
	
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
	public void pulaCanMove(int inix, int iniy, int fimx, int fimy)
    {
        Quadrado iniPos = tabuleiro.validade(inix,iniy);
        Quadrado fimPos = tabuleiro.validade(fimx, fimy);
        Mov move = new Mov(iniPos,fimPos);
        move.getFim().setPeça(move.getIni().getPeça());
        move.getIni().setPeça(null);
    }


	
	  public boolean faltaPeças(Tabuleiro tabuleiro)
	    {
	        for(int i = 0; i < 8; i++)
	        {
	            for(int j = 0; j < 8; j++)
	            {
	                if(tabuleiro.campo[i][j].getPeça() != null && tabuleiro.campo[i][j].getPeça().getIdentidade() != 5)
	                    return false;
	            }
	        }
	        return true;
	    }
	
    public static boolean xequedetect(Tabuleiro tabuleiro, boolean branco)
    {
        if(branco == true)
        {
            for(int i = 0; i < 8; i++)
            {
                for(int j = 0; j < 8; j++)
                {
                    if(tabuleiro.campo[i][j].getPeça() != null && (tabuleiro.campo[i][j].getPeça().getIdentidade() == 5 && tabuleiro.campo[i][j].getPeça().isBranca() == true ) )
                    {
                        for(int p = 0; p < 8; p++)
                        {
                            for(int q = 0; q < 8; q++)
                            {
                            	if(tabuleiro.campo[p][q].getPeça() != null)
                                    if(!tabuleiro.campo[p][q].getPeça().isBranca())
                                    {	
                                        if(tabuleiro.campo[p][q].getPeça().canMove(tabuleiro, tabuleiro.campo[p][q], tabuleiro.campo[i][j],true))
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
                    if(tabuleiro.campo[i][j].getPeça() != null && (tabuleiro.campo[i][j].getPeça().getIdentidade() == 5 && !tabuleiro.campo[i][j].getPeça().isBranca() == true ) )
                    {
                        for(int p = 0; p < 8; p++)
                        {
                            for(int q = 0; q < 8; q++)
                            {
                            	if(tabuleiro.campo[p][q].getPeça() != null)
                                    if(tabuleiro.campo[p][q].getPeça().isBranca())
                                    {	
                                        if(tabuleiro.campo[p][q].getPeça().canMove(tabuleiro, tabuleiro.campo[p][q], tabuleiro.campo[i][j],true))
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
                    if(tabuleiro.campo[i][j].getPeça() != null && tabuleiro.campo[i][j].getPeça().isBranca())
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
                    if(tabuleiro.campo[i][j].getPeça() != null && !tabuleiro.campo[i][j].getPeça().isBranca())
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

    public boolean isRoque(Tabuleiro tabuleiro, boolean branco, boolean direita) {
    	if(branco) {
    		if(direita) {
    			if(tabuleiro.campo[0][4].getPeça() == null) {
    				return false;
    			}
    			if(tabuleiro.campo[0][7].getPeça() == null) {
        			return false;
    			}
    			if(tabuleiro.campo[0][4].getPeça().getIdentidade() != 5) {
        			return false;
    			}
    			if(tabuleiro.campo[0][7].getPeça().getIdentidade() != 2) {
        			return false;
    			}
    			if(!tabuleiro.campo[0][4].getPeça().primeiroM) {
    				return false;
    			}
    			if(!tabuleiro.campo[0][7].getPeça().primeiroM) {
    				return false;
    			}
    			
    			if(!tabuleiro.campo[0][7].getPeça().canMove(tabuleiro, tabuleiro.campo[0][7], tabuleiro.campo[0][5],true)) {
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
    			tabuleiro.campo[0][5].getPeça().primeiroM = false;
    			tabuleiro.campo[0][6].getPeça().primeiroM = false;
    		}
    		else {
    			if(tabuleiro.campo[0][4].getPeça() == null) {
    				return false;
    			}
    			if(tabuleiro.campo[0][0].getPeça() == null) {
        			return false;
    			}
    			if(tabuleiro.campo[0][4].getPeça().getIdentidade() != 5) {
        			return false;
    			}
    			if(tabuleiro.campo[0][0].getPeça().getIdentidade() != 2) {
        			return false;
    			}
    			if(!tabuleiro.campo[0][4].getPeça().primeiroM) {
    				return false;
    			}
    			if(!tabuleiro.campo[0][0].getPeça().primeiroM) {
    				return false;
    			}
    			
    			if(!tabuleiro.campo[0][0].getPeça().canMove(tabuleiro, tabuleiro.campo[0][0], tabuleiro.campo[0][3],true)) {
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
    			tabuleiro.campo[0][3].getPeça().setPrimeiroMovimento(false);
    			tabuleiro.campo[0][2].getPeça().setPrimeiroMovimento(false);
    		}
    	}
    	else {
    		if(direita) {
    			if(tabuleiro.campo[7][4].getPeça() == null) {
    				return false;
    			}
    			if(tabuleiro.campo[7][7].getPeça() == null) {
        			return false;
    			}
    			if(tabuleiro.campo[7][4].getPeça().getIdentidade() != 5) {
        			return false;
    			}
    			if(tabuleiro.campo[7][7].getPeça().getIdentidade() != 2) {
        			return false;
    			}
    			if(!tabuleiro.campo[7][4].getPeça().primeiroM) {
    				return false;
    			}
    			if(!tabuleiro.campo[7][7].getPeça().primeiroM) {
    				return false;
    			}
    			
    			if(!tabuleiro.campo[7][7].getPeça().canMove(tabuleiro, tabuleiro.campo[7][7], tabuleiro.campo[7][5],true)) {
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
    			tabuleiro.campo[7][5].getPeça().primeiroM = false;
    			tabuleiro.campo[7][6].getPeça().primeiroM = false;
    		}
    		else {
    			if(tabuleiro.campo[7][4].getPeça() == null) {
    				return false;
    			}
    			if(tabuleiro.campo[7][0].getPeça() == null) {
        			return false;
    			}
    			if(tabuleiro.campo[7][4].getPeça().getIdentidade() != 5) {
        			return false;
    			}
    			if(tabuleiro.campo[7][0].getPeça().getIdentidade() != 2) {
        			return false;
    			}
    			if(!tabuleiro.campo[7][4].getPeça().primeiroM) {
    				return false;
    			}
    			if(!tabuleiro.campo[7][0].getPeça().primeiroM) {
    				return false;
    			}
    			
    			if(!tabuleiro.campo[7][0].getPeça().canMove(tabuleiro, tabuleiro.campo[7][0], tabuleiro.campo[7][3],true)) {
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
    			tabuleiro.campo[7][3].getPeça().primeiroM = false;
    			tabuleiro.campo[7][2].getPeça().primeiroM = false;

    		}	
    	}
    	return true;
    }
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
	
	public Mov getUltimoMovimento() {
        return ultimoMovimento;
    }

    public void desfazerJogada(Mov move)
    {

        this.tabuleiro.campo[move.getIni().getX()][move.getIni().getY()].setPeça(move.getPmov());
        this.tabuleiro.campo[move.getFim().getX()][move.getFim().getY()].setPeça(move.getPmorta());
    }
    
    public void mudaTurno() {
    	if(this.turno == jogadores[0])
        {
            this.turno = jogadores[1];
        }
        else {
            this.turno = jogadores[0];
        }
    }
    
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
            move.getIni().setPeça(move.getFim().getPeça());
            move.getFim().setPeça(null);
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
		
        
        return true;

        
    }

}