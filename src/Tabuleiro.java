
public class Tabuleiro {
	Quadrado[][] campo;
	
	public Tabuleiro()
	{
		this.resetTabuleiro();
	}
	
	public Quadrado validade (int x, int y)
	{
		///if(x < 0 || x > 7 || y < 0 || y > 7)
			/// Interface de jogada invalida, jogada fora do limite
		return campo[x][y];
	}
	public void resetTabuleiro()
	{
		/// Peças brancas
		campo[0][0] = new Quadrado(0, 0, new Torre(true));
		campo[0][1] = new Quadrado(0, 1, new Cavalo(true));
		campo[0][2] = new Quadrado(0, 2, new Bispo(true));
		campo[0][3] = new Quadrado(0, 3, new Rainha(true));
		campo[0][4] = new Quadrado(0, 4, new Rei(true));
		campo[0][5] = new Quadrado(0, 5, new Bispo(true));
		campo[0][6] = new Quadrado(0, 6, new Cavalo(true));
		campo[0][7] = new Quadrado(0, 7, new Torre(true));
		campo[1][0] = new Quadrado(1, 0, new Peão(true));
		campo[1][1] = new Quadrado(1, 1, new Peão(true));
		campo[1][2] = new Quadrado(1, 2, new Peão(true));
		campo[1][3] = new Quadrado(1, 3, new Peão(true));
		campo[1][4] = new Quadrado(1, 4, new Peão(true));
		campo[1][5] = new Quadrado(1, 5, new Peão(true));
		campo[1][6] = new Quadrado(1, 6, new Peão(true));
		campo[1][7] = new Quadrado(1, 7, new Peão(true));
		
		/// Peças Pretas
		campo[7][0] = new Quadrado(7, 0, new Torre(false));
		campo[7][1] = new Quadrado(7, 1, new Cavalo(false));
		campo[7][2] = new Quadrado(7, 2, new Bispo(false));
		campo[7][3] = new Quadrado(7, 3, new Rainha(false));
		campo[7][4] = new Quadrado(7, 4, new Rei(false));
		campo[7][5] = new Quadrado(7, 5, new Bispo(false));
		campo[7][6] = new Quadrado(7, 6, new Cavalo(false));
		campo[7][7] = new Quadrado(7, 7, new Torre(false));
		campo[6][0] = new Quadrado(6, 0, new Peão(false));
		campo[6][1] = new Quadrado(6, 1, new Peão(false));
		campo[6][2] = new Quadrado(6, 2, new Peão(false));
		campo[6][3] = new Quadrado(6, 3, new Peão(false));
		campo[6][4] = new Quadrado(6, 4, new Peão(false));
		campo[6][5] = new Quadrado(6, 5, new Peão(false));
		campo[6][6] = new Quadrado(6, 6, new Peão(false));
		campo[6][7] = new Quadrado(6, 7, new Peão(false));
		
		for (int i = 2; i < 6; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				campo[i][j] = new Quadrado(i, j, null);
			}
		}

	}
}
