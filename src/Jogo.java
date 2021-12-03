
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
                                        if(tabuleiro.campo[p][q].getPeça().canMove(tabuleiro, tabuleiro.campo[p][q], tabuleiro.campo[i][j]))
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
                                        if(tabuleiro.campo[p][q].getPeça().canMove(tabuleiro, tabuleiro.campo[p][q], tabuleiro.campo[i][j]))
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
<<<<<<< Updated upstream
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
=======
                    if(Tabuleiro.campo[i][j].getPeça() != null && tabuleiro.campo[i][j].getPeça().isBranca())
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
>>>>>>> Stashed changes
                    
                }
            }
        }
        else
        {
            for(int i = 0; i < 8; i++)
            {
                for(int j = 0; j < 8; j++)
                {
<<<<<<< Updated upstream
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
=======
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
                                    System.out.println(i + " " + j + " " + p + " " + q);
                                    return false;
                                }
                            }
                        }
                    }
>>>>>>> Stashed changes
                    
                }
            }
        }    
        return true;
    }   
	
    /// Condição de empate -  caso só exista a peça rei no tabuleiro, é impossível terminar o jogo.
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
    
    /*public boolean afogamento(Tabuleiro tabuleiro, boolean branco)
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
	    						if(this.construtorJogada(turno, i, j ,p ,q, true));
	    							{if(xequedetect(tabuleiro,turno.isLadobranco()))
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
	    						if(this.construtorJogada(turno, i, j ,p ,q, true));
	    							{if(xequedetect(tabuleiro,turno.isLadobranco()))
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
    	}
    	return true;
    }
    */
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
		
		if (!escolhida.canMove(tabuleiro, move.getIni(), move.getFim())) {
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