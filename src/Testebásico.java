
public class Testebásico {
	private static Jogo jogo;
	private static Jogador[] jogadores = new Jogador[2];
	public static void main(String[] args)
	
	{
		jogadores[0] = new Jogador(true);
		jogadores[1] = new Jogador(false);
		jogo = new Jogo();
		jogo.iniciar(jogadores[0],jogadores[1]);
		
		print();
		
		try {
			System.out.println("\nMovimento: "+jogo.construtorJogada(jogo.turno, 0,0, 1,0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("\nMovimento: "+jogo.construtorJogada(jogo.turno, 7,1, 6,2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("\nMovimento: "+jogo.construtorJogada(jogo.turno, 1,0, 2,0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("\nMovimento: "+jogo.construtorJogada(jogo.turno, 6,2, 7,1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
					System.out.print("0 ");
				}
				else
					System.out.print(jogo.tabuleiro.campo[i][j].getPeça().getIdentidade() + " ");
			}
		}
	}
}
