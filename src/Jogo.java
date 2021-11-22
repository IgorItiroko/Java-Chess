import java.util.List;

public class Jogo {
	private Tabuleiro tabuleiro;
	private Jogador[] jogadores;
	private Jogador turno;
	private List<String> Jogadas;
	private String codigo[];
	
	private void iniciar(Jogador j1, Jogador j2)
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
		Jogadas.clear();
	}
	
	
<<<<<<< Updated upstream
	
	
	
	
	
	
	
	
	
	
	



	
	public String codigo (int x, int y)
=======
	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public boolean Jogada(Mov move, Jogador j)
>>>>>>> Stashed changes
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