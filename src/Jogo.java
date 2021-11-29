import java.awt.EventQueue;
import java.util.List;

public class Jogo{
	public Tabuleiro tabuleiro;
	public static Jogador[] jogadores = new Jogador[2];
	public Jogador turno;
	public List<String> Jogadas;
	public String codigo[];
	public Telainicial tela;
	
	
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
                	if(tabuleiro.campo[i][j].getPe�a() != null && !tabuleiro.campo[i][j].getPe�a().isBranca())
                	{
                		for(int p = 0; p < 8; p++)
                		{
                			for(int q = 0; q < 8; q++)
                			{
                				if(tabuleiro.campo[i][j].getPe�a().canMove(tabuleiro, tabuleiro.campo[i][j], tabuleiro.campo[p][q]));
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
                	if(tabuleiro.campo[i][j].getPe�a() != null && tabuleiro.campo[i][j].getPe�a().isBranca())
                	{
                		for(int p = 0; p < 8; p++)
                		{
                			for(int q = 0; q < 8; q++)
                			{
                				if(tabuleiro.campo[i][j].getPe�a().canMove(tabuleiro, tabuleiro.campo[i][j], tabuleiro.campo[p][q]));
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
    			if(tabuleiro.campo[0][4].getPe�a() == null) {
    				return false;
    			}
    			if(tabuleiro.campo[0][0].getPe�a() == null) {
        			return false;
    			}
    			if(tabuleiro.campo[0][4].getPe�a().getIdentidade() != 5) {
        			return false;
    			}
    			if(tabuleiro.campo[0][0].getPe�a().getIdentidade() != 2) {
        			return false;
    			}
    			if(tabuleiro.campo[0][4].getPe�a().isPrimeiroMovimento() == false) {
    				return false;
    			}
    			if(tabuleiro.campo[0][0].getPe�a().isPrimeiroMovimento() == false) {
    				return false;
    			}
    			
    			if(tabuleiro.campo[0][0].getPe�a().canMove(tabuleiro, tabuleiro.campo[0][0], tabuleiro.campo[0][3]) == false) {
    				return false;
    			}
    		
    		}
    		else {
    			if(tabuleiro.campo[0][4].getPe�a() == null) {
    				return false;
    			}
    			if(tabuleiro.campo[0][7].getPe�a() == null) {
        			return false;
    			}
    			if(tabuleiro.campo[0][4].getPe�a().getIdentidade() != 5) {
        			return false;
    			}
    			if(tabuleiro.campo[0][7].getPe�a().getIdentidade() != 2) {
        			return false;
    			}
    			if(tabuleiro.campo[0][4].getPe�a().isPrimeiroMovimento() == false) {
    				return false;
    			}
    			if(tabuleiro.campo[0][7].getPe�a().isPrimeiroMovimento() == false) {
    				return false;
    			}
    			
    			if(tabuleiro.campo[0][7].getPe�a().canMove(tabuleiro, tabuleiro.campo[0][7], tabuleiro.campo[0][5]) == false) {
    				return false;
    			}   			
    		}
    	}
    	else {
    		if(direita) {
    			if(tabuleiro.campo[7][4].getPe�a() == null) {
    				return false;
    			}
    			if(tabuleiro.campo[7][0].getPe�a() == null) {
        			return false;
    			}
    			if(tabuleiro.campo[7][4].getPe�a().getIdentidade() != 5) {
        			return false;
    			}
    			if(tabuleiro.campo[7][0].getPe�a().getIdentidade() != 2) {
        			return false;
    			}
    			if(tabuleiro.campo[7][4].getPe�a().isPrimeiroMovimento() == false) {
    				return false;
    			}
    			if(tabuleiro.campo[7][0].getPe�a().isPrimeiroMovimento() == false) {
    				return false;
    			}
    			
    			if(tabuleiro.campo[7][0].getPe�a().canMove(tabuleiro, tabuleiro.campo[7][0], tabuleiro.campo[7][3]) == false) {
    				return false;
    			}
    		}
    		else {
    			if(tabuleiro.campo[7][4].getPe�a() == null) {
    				return false;
    			}
    			if(tabuleiro.campo[7][7].getPe�a() == null) {
        			return false;
    			}
    			if(tabuleiro.campo[7][4].getPe�a().getIdentidade() != 5) {
        			return false;
    			}
    			if(tabuleiro.campo[7][7].getPe�a().getIdentidade() != 2) {
        			return false;
    			}
    			if(tabuleiro.campo[7][4].getPe�a().isPrimeiroMovimento() == false) {
    				return false;
    			}
    			if(tabuleiro.campo[7][7].getPe�a().isPrimeiroMovimento() == false) {
    				return false;
    			}
    			
    			if(tabuleiro.campo[7][7].getPe�a().canMove(tabuleiro, tabuleiro.campo[7][7], tabuleiro.campo[7][5]) == false) {
    				return false;
    			}	
    		}	
    	}
    	return true;
    }
	public boolean construtorJogada(Jogador j1, int Xinicial, int Yinicial, int Xfinal, int Yfinal) throws Exception
	{
		Quadrado iniPos = tabuleiro.validade(Xinicial, Yinicial);
		Quadrado fimPos = tabuleiro.validade(Xfinal, Yfinal);
		Mov move = new Mov(j1,iniPos,fimPos);
		return this.Jogada(move,j1);
	}
	
	public boolean Jogada(Mov move, Jogador j)
	{
		Pe�a escolhida = move.getIni().getPe�a();
		if (escolhida == null)
		{
			return false;
		}
		
		/*if(j != turno)
		{
			return false;
		}
		*/
		if(escolhida.isBranca() != j.isLadobranco())
		{
			return false;
		}
		
		if (!escolhida.canMove(tabuleiro, move.getIni(), move.getFim())) {
			return false;
		}
		
		Pe�a destino = move.getIni().getPe�a();
		if(destino != null)
		{
			destino.setViva(false);
			
		}
		
		move.getFim().setPe�a(move.getIni().getPe�a());
		move.getIni().setPe�a(null);
		
		if (xequedetect(tabuleiro, j.isLadobranco()))
        {
            move.getIni().setPe�a(move.getFim().getPe�a());
            move.getFim().setPe�a(null);
            return false;
        }
		
		/*
		if(xeque.xequedetect(tabuleiro, j.isLadobranco() && j.isLadobranco()))
        {
			System.out.println("Jogador do lado branco em xeque!");
        }
		
        if(xeque.xequedetect(tabuleiro, j.isLadobranco()) && !j.isLadobranco())
        {
            System.out.println("Jogador do lado preto em xeque!");
        }

        if(xeque.xequematedetect(tabuleiro, j.isLadobranco()) && j.isLadobranco())
        {
            System.out.println("Jogador do lado preto ganhou!");
        }
        if(xeque.xequematedetect(tabuleiro, j.isLadobranco()) && !j.isLadobranco())
        {
            System.out.println("Jogador do lado branco ganhou!");
        }
        
        */
		
		if(this.turno == jogadores[0])
		{
			this.turno = jogadores[1];
		}
		else {
			this.turno = jogadores[0];
		}
		
		return true;

		
	}

}