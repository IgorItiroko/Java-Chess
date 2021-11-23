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
                    if(tabuleiro.campo[i][j].getPe�a().getIdentidade() == 5 && tabuleiro.campo[i][j].getPe�a().isBranca() == true)
                    {
                        reibranco = tabuleiro.campo[i][j];
                        for(int p = 0; p < 7; p++)
                        {
                            for(int q = 0; q < 7; q++)
                            {
                                if(tabuleiro.campo[p][q].getPe�a().canMove(tabuleiro, tabuleiro.campo[p][q], reibranco) == true)
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
                    if(tabuleiro.campo[i][j].getPe�a().getIdentidade() == 5 && tabuleiro.campo[i][j].getPe�a().isBranca() == false)
                    {
                        reipreto = tabuleiro.campo[i][j];
                        for(int p = 0; p < 7; p++)
                        {
                            for(int q = 0; q < 7; q++)
                            {
                                if(tabuleiro.campo[p][q].getPe�a().canMove(tabuleiro, tabuleiro.campo[p][q], reipreto) == true)
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
    
}