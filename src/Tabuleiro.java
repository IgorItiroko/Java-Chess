
public class Tabuleiro {
	Quadrado[][] campo;
	
	public Tabuleiro()
	{
		this.resetTabuleiro();
	}
	
	public Quadrado validade (int x, int y) throws Exception
	{
		if(x < 0 || x > 7 || y < 0 || y > 7)
		 throw new Exception("Index out of bound"); // Alterar para exibição de erro.
		return campo[x][y];
	}
	public void resetTabuleiro()
	{
		/// Peças brancas
		campo[0][0] = new Quadrado(0, 0, new Torre(true));
		campo[1][0] = new Quadrado(1, 0, new Cavalo(true));
		campo[2][0] = new Quadrado(2, 0, new Bispo(true));
		campo[3][0] = new Quadrado(3, 0, new Rainha(true));
		campo[4][0] = new Quadrado(4, 0, new Rei(true));
		campo[5][0] = new Quadrado(5, 0, new Bispo(true));
		campo[6][0] = new Quadrado(6, 0, new Cavalo(true));
		campo[7][0] = new Quadrado(7, 0, new Torre(true));
		campo[0][1] = new Quadrado(0, 1, new Peão(true));
		campo[1][1] = new Quadrado(1, 1, new Peão(true));
		campo[2][1] = new Quadrado(2, 1, new Peão(true));
		campo[3][1] = new Quadrado(3, 1, new Peão(true));
		campo[4][1] = new Quadrado(4, 1, new Peão(true));
		campo[5][1] = new Quadrado(5, 1, new Peão(true));
		campo[6][1] = new Quadrado(6, 1, new Peão(true));
		campo[7][1] = new Quadrado(7, 1, new Peão(true));
		
		/// Peças Pretas
		campo[0][7] = new Quadrado(0, 7, new Torre(false));
		campo[1][7] = new Quadrado(1, 7, new Cavalo(false));
		campo[2][7] = new Quadrado(2, 7, new Bispo(false));
		campo[3][7] = new Quadrado(3, 7, new Rainha(false));
		campo[4][7] = new Quadrado(4, 7, new Rei(false));
		campo[5][7] = new Quadrado(5, 7, new Bispo(false));
		campo[6][7] = new Quadrado(6, 7, new Cavalo(false));
		campo[7][7] = new Quadrado(7, 7, new Torre(false));
		campo[0][6] = new Quadrado(0, 6, new Peão(false));
		campo[1][6] = new Quadrado(1, 6, new Peão(false));
		campo[2][6] = new Quadrado(2, 6, new Peão(false));
		campo[3][6] = new Quadrado(3, 6, new Peão(false));
		campo[4][6] = new Quadrado(4, 6, new Peão(false));
		campo[5][6] = new Quadrado(5, 6, new Peão(false));
		campo[6][6] = new Quadrado(6, 6, new Peão(false));
		campo[7][6] = new Quadrado(7, 6, new Peão(false));
		
		for (int i = 2; i < 6; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				campo[i][j] = new Quadrado(i, j, null);
			}
		}

	}
}
