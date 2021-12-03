
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
                if(campo[i][j].getPe�a() == null)
                {
                    System.out.print("| 0 |");
                }
                else
                    System.out.print("| " + campo[i][j].getPe�a().getIdentidade() + " |");
            }
        }
    }
	
	public void resetTabuleiro()
	{
		/// Pe�as Brancas
		campo[0][0] = new Quadrado(0, 0, new Torre(true,2,true));
		campo[0][1] = new Quadrado(0, 1, new Cavalo(true,3,true));
		campo[0][2] = new Quadrado(0, 2, new Bispo(true,4,true));
		campo[0][3] = new Quadrado(0, 3, new Rainha(true,6,true));
		campo[0][4] = new Quadrado(0, 4, new Rei(true,5,true));
		campo[0][5] = new Quadrado(0, 5, new Bispo(true,4,true));
		campo[0][6] = new Quadrado(0, 6, new Cavalo(true,3,true));
		campo[0][7] = new Quadrado(0, 7, new Torre(true,2,true));
		campo[1][0] = new Quadrado(1, 0, new Pe�o(true,1,true));
		campo[1][1] = new Quadrado(1, 1, new Pe�o(true,1,true));
		campo[1][2] = new Quadrado(1, 2, new Pe�o(true,1,true));
		campo[1][3] = new Quadrado(1, 3, new Pe�o(true,1,true));
		campo[1][4] = new Quadrado(1, 4, new Pe�o(true,1,true));
		campo[1][5] = new Quadrado(1, 5, new Pe�o(true,1,true));
		campo[1][6] = new Quadrado(1, 6, new Pe�o(true,1,true));
		campo[1][7] = new Quadrado(1, 7, new Pe�o(true,1,true));
		
		/// Pe�as Pretas
		campo[7][0] = new Quadrado(7, 0, new Torre(false,2,true));
		campo[7][1] = new Quadrado(7, 1, new Cavalo(false,3,true));
		campo[7][2] = new Quadrado(7, 2, new Bispo(false,4,true));
		campo[7][3] = new Quadrado(7, 3, new Rainha(false,6,true));
		campo[7][4] = new Quadrado(7, 4, new Rei(false,5,true));
		campo[7][5] = new Quadrado(7, 5, new Bispo(false,4,true));
		campo[7][6] = new Quadrado(7, 6, new Cavalo(false,3,true));
		campo[7][7] = new Quadrado(7, 7, new Torre(false,2,true));
		campo[6][0] = new Quadrado(6, 0, new Pe�o(false,1,true));
		campo[6][1] = new Quadrado(6, 1, new Pe�o(false,1,true));
		campo[6][2] = new Quadrado(6, 2, new Pe�o(false,1,true));
		campo[6][3] = new Quadrado(6, 3, new Pe�o(false,1,true));
		campo[6][4] = new Quadrado(6, 4, new Pe�o(false,1,true));
		campo[6][5] = new Quadrado(6, 5, new Pe�o(false,1,true));
		campo[6][6] = new Quadrado(6, 6, new Pe�o(false,1,true));
		campo[6][7] = new Quadrado(6, 7, new Pe�o(false,1,true));
		for (int i = 2; i < 6; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				campo[i][j] = new Quadrado(i, j, null);
			}
		}

	}
}
	
	 
	



	   
