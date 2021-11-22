import java.awt.EventQueue;
import java.util.List;

public class Jogo{
	private Tabuleiro tabuleiro;
	private static Jogador[] jogadores = new Jogador[2];
	private Jogador turno;
	private List<String> Jogadas;
	private String codigo[];
	public Telainicial tela;
	
	
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
	
	public boolean construtorJogada(Jogador j1, int Xinicial, int Yinicial, int Xfinal, int Yfinal) throws Exception
	{
		Quadrado iniPos = tabuleiro.validade(Xinicial, Yinicial);
		Quadrado fimPos = tabuleiro.validade(Xfinal, Yfinal);
		Mov move = new Mov(j1,iniPos,fimPos);
		return this.Jogada(move,j1);
	}
	
	public boolean Jogada(Mov move, Jogador j)
	{
		Peça escolhida = move.getIni().getPeça();
		if (escolhida == null)
		{
			return false;
		}
		
		if(j != turno)
		{
			return false;
		}
		
		if(escolhida.isBranca() != j.isLadobranco())
		{
			return false;
		}
		
		if (!escolhida.canMove(tabuleiro, move.getIni(), move.getFim())) {
			return false;
		}
		
		Peça destino = move.getIni().getPeça();
		if(destino != null)
		{
			destino.setViva(false);
			
		}
		
		move.getFim().setPeça(move.getIni().getPeça());
		move.getIni().setPeça(null);
		
		if(this.turno == jogadores[0])
		{
			this.turno = jogadores[1];
		}
		else {
			this.turno = jogadores[0];
		}
		return true;

		
	}

}