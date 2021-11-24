public class Xeque {
    public boolean xeque;
    public boolean branco;
    public Quadrado reibranco;
    public Quadrado reipreto;
    
    public boolean xequedetect(Tabuleiro tabuleiro, boolean branco)
    {
        if(branco == true)
        {
            for(int i = 0; i < 7; i++)
            {
                for(int j = 0; j < 7; j++)
                {
                    if(tabuleiro.campo[i][j].getPeça() != null && (tabuleiro.campo[i][j].getPeça().getIdentidade() == 5 && tabuleiro.campo[i][j].getPeça().isBranca() == true ) )
                    {
                        reibranco = tabuleiro.campo[i][j];
                        for(int p = 0; p < 7; p++)
                        {
                            for(int q = 0; q < 7; q++)
                            {
                                if(tabuleiro.campo[p][q].getPeça()!=null && tabuleiro.campo[p][q].getPeça().canMove(tabuleiro, tabuleiro.campo[p][q], reibranco) == true)
                                {
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
            for(int i = 0; i < 7; i++)
            {
                for(int j = 0; j < 7; j++)
                {
                    if(tabuleiro.campo[i][j].getPeça() != null &&(tabuleiro.campo[i][j].getPeça().getIdentidade() == 5 && tabuleiro.campo[i][j].getPeça().isBranca() == false))
                    {
                        reipreto = tabuleiro.campo[i][j];
                        for(int p = 0; p < 7; p++)
                        {
                            for(int q = 0; q < 7; q++)
                            {
                                if(tabuleiro.campo[p][q].getPeça()!=null && tabuleiro.campo[p][q].getPeça().canMove(tabuleiro, tabuleiro.campo[p][q], reipreto) == true)
                                {
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
	    	for(int i = 0; i < 7; i++)
	    	{
	    		for(int j = 0; j < 7; j++)
	    		{
	    			for(int p = 0; p < 7; p++)
	    			{
	    				for(int q = 0; q < 7; q++)
	    				{
	    					if(tabuleiro.campo[i][j].getPeça().isBranca())
	    						if(tabuleiro.campo[i][j].getPeça().canMove(tabuleiro, tabuleiro.campo[i][j], tabuleiro.campo[p][q]))
	    							return false;
	    				}	
	    			}
	    		}
	    	}
    	}
    	else
    	{
	    	for(int i = 0; i < 7; i++)
	    	{
	    		for(int j = 0; j < 7; j++)
	    		{
	    			for(int p = 0; p < 7; p++)
	    			{
	    				for(int q = 0; q < 7; q++)
	    				{
	    					if(tabuleiro.campo[i][j].getPeça() != null && !tabuleiro.campo[i][j].getPeça().isBranca())
	    						if(tabuleiro.campo[i][j].getPeça().canMove(tabuleiro, tabuleiro.campo[i][j], tabuleiro.campo[p][q]))
	    							return false;
	    				}	
	    			}
	    		}
	    	}
    	}	
    	return true;
    }
    
}