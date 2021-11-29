
public class Testebásico {
	private static Jogo jogo;
	private static Jogador[] jogadores = new Jogador[2];
	public static void main(String[] args)
	
	{
		jogadores[0] = new Jogador(true);
		jogadores[1] = new Jogador(false);
		jogo = new Jogo();
		jogo.iniciar(jogadores[0],jogadores[1]);
		System.out.println("Xeque: " + Jogo.xequedetect(jogo.tabuleiro, jogo.turno.isLadobranco()));
		System.out.println("Xequemate:" + jogo.xequematedetect(jogo.tabuleiro, jogo.turno.ladobranco));
		print();

		

	}
	
	public static void print() {
		for(int i = 0; i < 8; i++)
		{
			System.out.println();
			for(int j = 0; j < 8; j++)
			{
				if(jogo.tabuleiro.campo[i][j].getPeça() == null)
				{
					System.out.print("| 0 |");
				}
				else
					System.out.print("| " + jogo.tabuleiro.campo[i][j].getPeça().getIdentidade() + " |");
			}
		}
	}
}
