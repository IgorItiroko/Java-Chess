
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
		campo[0][0] = new Quadrado(0, 0, new Torre(true,2));
		campo[1][0] = new Quadrado(1, 0, new Cavalo(true,3));
		campo[2][0] = new Quadrado(2, 0, new Bispo(true,4));
		campo[3][0] = new Quadrado(3, 0, new Rainha(true,6));
		campo[4][0] = new Quadrado(4, 0, new Rei(true,5));
		campo[5][0] = new Quadrado(5, 0, new Bispo(true,4));
		campo[6][0] = new Quadrado(6, 0, new Cavalo(true,3));
		campo[7][0] = new Quadrado(7, 0, new Torre(true,2));
		campo[0][1] = new Quadrado(0, 1, new Peão(true,1));
		campo[1][1] = new Quadrado(1, 1, new Peão(true,1));
		campo[2][1] = new Quadrado(2, 1, new Peão(true,1));
		campo[3][1] = new Quadrado(3, 1, new Peão(true,1));
		campo[4][1] = new Quadrado(4, 1, new Peão(true,1));
		campo[5][1] = new Quadrado(5, 1, new Peão(true,1));
		campo[6][1] = new Quadrado(6, 1, new Peão(true,1));
		campo[7][1] = new Quadrado(7, 1, new Peão(true,1));
		
		/// Peças Pretas
		campo[0][7] = new Quadrado(0, 7, new Torre(false,2));
		campo[1][7] = new Quadrado(1, 7, new Cavalo(false,3));
		campo[2][7] = new Quadrado(2, 7, new Bispo(false,4));
		campo[3][7] = new Quadrado(3, 7, new Rainha(false,6));
		campo[4][7] = new Quadrado(4, 7, new Rei(false,5));
		campo[5][7] = new Quadrado(5, 7, new Bispo(false,4));
		campo[6][7] = new Quadrado(6, 7, new Cavalo(false,3));
		campo[7][7] = new Quadrado(7, 7, new Torre(false,2));
		campo[0][6] = new Quadrado(0, 6, new Peão(false,1));
		campo[1][6] = new Quadrado(1, 6, new Peão(false,1));
		campo[2][6] = new Quadrado(2, 6, new Peão(false,1));
		campo[3][6] = new Quadrado(3, 6, new Peão(false,1));
		campo[4][6] = new Quadrado(4, 6, new Peão(false,1));
		campo[5][6] = new Quadrado(5, 6, new Peão(false,1));
		campo[6][6] = new Quadrado(6, 6, new Peão(false,1));
		campo[7][6] = new Quadrado(7, 6, new Peão(false,1));
		
		for (int i = 2; i < 6; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				campo[i][j] = new Quadrado(i, j, null);
			}
		}

	}
}
