import java.awt.EventQueue;
import java.util.List;

public class Jogo{
	public Tabuleiro tabuleiro;
	public static Jogador[] jogadores = new Jogador[2];
	public Jogador turno;
	public List<String> Jogadas;
	public String codigo[];
	public Telainicial tela;
	
	
	void iniciar(Jogador j1, Jogador j2)
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
	}
	
	public boolean construtorJogada(Jogador j1, int Xinicial, int Yinicial, int Xfinal, int Yfinal, Xeque xeque) throws Exception
	{
		Quadrado iniPos = tabuleiro.validade(Xinicial, Yinicial);
		Quadrado fimPos = tabuleiro.validade(Xfinal, Yfinal);
		Mov move = new Mov(j1,iniPos,fimPos);
		return this.Jogada(move,j1,xeque);
	}
	
	public boolean Jogada(Mov move, Jogador j, Xeque xeque)
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
		
		if(xeque.xequedetect(tabuleiro, j.isLadobranco()))
        {
            move.getIni().setPeça(move.getIni().getPeça());
            move.getFim().setPeça(null);
            return false;
        }
		
		if(xeque.xequedetect(tabuleiro, j.isLadobranco() && j.isLadobranco()))
        {
			System.out.println("Jogador do lado branco em xeque!");
        }
		
        if(xeque.xequedetect(tabuleiro, j.isLadobranco()) && !j.isLadobranco())
        {
            System.out.println("Jogador do lado preto em xeque!");
        }

        if(xeque.xequematedetect(tabuleiro, j.isLadobranco()) && j.isLadobranco())
        {
            System.out.println("Jogador do lado preto ganhou!");
        }
        if(xeque.xequematedetect(tabuleiro, j.isLadobranco()) && !j.isLadobranco())
        {
            System.out.println("Jogador do lado branco ganhou!");
        }
        
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