
public class Tabuleiro{

	public static  Quadrado[][] campo = new Quadrado[8][8];
	public Tabuleiro()
	{
		this.resetTabuleiro();
	}
	
	public Quadrado validade (int x, int y) 
	{
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			System.out.println("Erro");
		}
		return campo[x][y];
	}
	
	public static void printTabuleiro() {
        for(int i = 0; i < 8; i++)
        {
            System.out.println();
            for(int j = 0; j < 8; j++)
            {
                if(campo[i][j].getPeça() == null)
                {
                    System.out.print("| 0 |");
                }
                else
                    System.out.print("| " + campo[i][j].getPeça().getIdentidade() + " |");
            }
        }
    }
	
	public void resetTabuleiro()
	{
		/// Peças brancas
		campo[0][0] = new Quadrado(0, 0, null);
		campo[0][1] = new Quadrado(0, 1, null);
		campo[0][2] = new Quadrado(0, 2, null);
		campo[0][3] = new Quadrado(0, 3, null);
		campo[0][4] = new Quadrado(0, 4, new Rei(true,5,true));
		campo[0][5] = new Quadrado(0, 5, null);
		campo[0][6] = new Quadrado(0, 6, null);
		campo[0][7] = new Quadrado(0, 7, null);
		campo[1][0] = new Quadrado(1, 0, null);
		campo[1][1] = new Quadrado(1, 1, null);
		campo[1][2] = new Quadrado(1, 2, null);
		campo[1][3] = new Quadrado(1, 3, null);
		campo[1][4] = new Quadrado(1, 4, null);
		campo[1][5] = new Quadrado(1, 5,  new Peão(true,1,false));
		campo[1][6] = new Quadrado(1, 6, null);
		campo[1][7] = new Quadrado(1, 7, null);
		
		/// Peças Pretas
		campo[7][0] = new Quadrado(7, 0, null);
		campo[7][1] = new Quadrado(7, 1, null);
		campo[7][2] = new Quadrado(7, 2, null);
		campo[7][3] = new Quadrado(7, 3, null);
		campo[7][4] = new Quadrado(7, 4, new Rei(false,5,true));
		campo[7][5] = new Quadrado(7, 5, null);
		campo[7][6] = new Quadrado(7, 6, null);
		campo[7][7] = new Quadrado(7, 7, null);
		campo[6][0] = new Quadrado(6, 0, null);
		campo[6][1] = new Quadrado(6, 1, null);
		campo[6][2] = new Quadrado(6, 2, null);
		campo[6][3] = new Quadrado(6, 3, null);
		campo[6][4] = new Quadrado(6, 4, null);
		campo[6][5] = new Quadrado(6, 5, null);
		campo[6][6] = new Quadrado(6, 6, null);
		campo[6][7] = new Quadrado(6, 7, null);
		for (int i = 2; i < 6; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				campo[i][j] = new Quadrado(i, j, null);
			}
		}

	}
}
	
	 
	



	   
