
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
                    if(tabuleiro.campo[i][j].getPe�a() != null && (tabuleiro.campo[i][j].getPe�a().getIdentidade() == 5 && tabuleiro.campo[i][j].getPe�a().isBranca() == true ) )
                    {
                        for(int p = 0; p < 8; p++)
                        {
                            for(int q = 0; q < 8; q++)
                            {
                            	if(tabuleiro.campo[p][q].getPe�a() != null)
                                    if(!tabuleiro.campo[p][q].getPe�a().isBranca())
                                    {	
                                        if(tabuleiro.campo[p][q].getPe�a().canMove(tabuleiro, tabuleiro.campo[p][q], tabuleiro.campo[i][j]))
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
                    if(tabuleiro.campo[i][j].getPe�a() != null && (tabuleiro.campo[i][j].getPe�a().getIdentidade() == 5 && !tabuleiro.campo[i][j].getPe�a().isBranca() == true ) )
                    {
                        for(int p = 0; p < 8; p++)
                        {
                            for(int q = 0; q < 8; q++)
                            {
                            	if(tabuleiro.campo[p][q].getPe�a() != null)
                                    if(tabuleiro.campo[p][q].getPe�a().isBranca())
                                    {	
                                        if(tabuleiro.campo[p][q].getPe�a().canMove(tabuleiro, tabuleiro.campo[p][q], tabuleiro.campo[i][j]))
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
                	if(tabuleiro.campo[i][j].getPe�a() != null && tabuleiro.campo[i][j].getPe�a().isBranca())
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
                    if(Tabuleiro.campo[i][j].getPe�a() != null && tabuleiro.campo[i][j].getPe�a().isBranca())
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
                	if(tabuleiro.campo[i][j].getPe�a() != null && !tabuleiro.campo[i][j].getPe�a().isBranca())
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
                    if(tabuleiro.campo[i][j].getPe�a() != null && !tabuleiro.campo[i][j].getPe�a().isBranca())
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
	
    /// Condi��o de empate -  caso s� exista a pe�a rei no tabuleiro, � imposs�vel terminar o jogo.
    public boolean faltaPe�as(Tabuleiro tabuleiro)
    {
    	for(int i = 0; i < 8; i++)
    	{
    		for(int j = 0; j < 8; j++)
    		{
    			if(tabuleiro.campo[i][j].getPe�a() != null && tabuleiro.campo[i][j].getPe�a().getIdentidade() != 5)
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
	    			if(tabuleiro.campo[i][j].getPe�a() != null && tabuleiro.campo[i][j].getPe�a().isBranca())
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
	    			if(tabuleiro.campo[i][j].getPe�a() != null && !tabuleiro.campo[i][j].getPe�a().isBranca())
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
		ultimoMovimento.setPmov(ultimoMovimento.getIni().getPe�a());
		ultimoMovimento.setPmorta(ultimoMovimento.getFim().getPe�a());
		return this.Jogada(move,j1,verific);
	}
	
	
	public Mov getUltimoMovimento() {
		return ultimoMovimento;
	}

	public void desfazerJogada(Mov move)
	{

		this.tabuleiro.campo[move.getIni().getX()][move.getIni().getY()].setPe�a(move.getPmov());
		this.tabuleiro.campo[move.getFim().getX()][move.getFim().getY()].setPe�a(move.getPmorta());
	}
	
	public boolean Jogada(Mov move, Jogador j, boolean verific)
	{
		Pe�a escolhida = move.getIni().getPe�a();
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
		
		Pe�a destino = move.getFim().getPe�a();
		if(destino != null)
		{
			destino.setViva(false);
			move.setPmorta(destino);
		}
		else
			move.setPmorta(null);
		
		
		move.getFim().setPe�a(move.getIni().getPe�a());
		move.getIni().setPe�a(null);
		
		if (xequedetect(tabuleiro, j.isLadobranco()))
        {
            move.getIni().setPe�a(move.getFim().getPe�a());
            move.getFim().setPe�a(null);
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