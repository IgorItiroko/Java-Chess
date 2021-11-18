import java.awt.EventQueue;
import java.util.List;

public class Jogo{
	private Tabuleiro tabuleiro;
	private static Jogador[] jogadores = new Jogador[2];
	private Jogador turno;
	private List<String> Jogadas;
	private String codigo[];
	public Telainicial tela;
	
	
	public static void main(String[] args) {
		jogadores[0] = new Jogador(true);
		jogadores[1] = new Jogador(false);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telainicial window = new Telainicial(jogadores[0],jogadores[1]);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

		
	}
	
	private void iniciar(Jogador j1, Jogador j2)
	{
		tabuleiro = new Tabuleiro();
		if(j1.isLadobranco()) {
			this.turno = j1;
		}
		else {
			this.turno = j2;
		}
		Jogadas.clear();
	}
	
	
	public String codigo (int x, int y)
	{
		switch(x)
		{
		case 0: codigo[0] = "a";
		case 1: codigo[0] = "b";
		case 2: codigo[0] = "c";
		case 3: codigo[0] = "d";
		case 4: codigo[0] = "e";
		case 5: codigo[0] = "f";
		case 6: codigo[0] = "g";
		case 7: codigo[0] = "h";
		}
		codigo[1] = Integer.toString(y + 1);
		String concatena = codigo[0] + codigo[1];
		return concatena;
	}

}