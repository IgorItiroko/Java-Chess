
public class Testeb�sico {
	private static Jogo jogo;
	private static Jogador[] jogadores = new Jogador[2];
	public static void main(String[] args)
	
	{
		jogadores[0] = new Jogador(true);
		jogadores[1] = new Jogador(false);
		jogo = new Jogo();
		jogo.iniciar(jogadores[0],jogadores[1]);
		print();
		jogo.construtorJogada(jogo.turno, 0, 0, 0, 1, false);
		print();
		System.out.println("classe:"+jogo.tabuleiro.campo[0][1].getPe�a().getClass());
		System.out.println("movimento: "+jogo.construtorJogada(jogo.turno, 0, 1, 0, 0, false));
		print();
		System.out.println("Roque:"+jogo.isRoque(jogo.tabuleiro, true, false));
		print();
	}
	
	
	public static void print() {
		System.out.println("\n");
		for(int i = 0; i < 8; i++)
		{
			System.out.println();
			for(int j = 0; j < 8; j++)
			{
				if(jogo.tabuleiro.campo[i][j].getPe�a() == null)
				{
					System.out.print("0 ");
				}
				else
					System.out.print(jogo.tabuleiro.campo[i][j].getPe�a().getIdentidade() + " ");
			}
		}
	}
}
