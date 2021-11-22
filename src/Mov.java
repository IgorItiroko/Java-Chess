
public class Mov {
	private Jogador j;
	private Quadrado ini;
	private Quadrado fim;
	private Peça pmov;
	private Peça pmorta;
	private boolean roque = false;
	
	
	public Quadrado getIni() {
		return ini;
	}

	public void setIni(Quadrado ini) {
		this.ini = ini;
	}

	public Quadrado getFim() {
		return fim;
	}

	public void setFim(Quadrado fim) {
		this.fim = fim;
	}

	public Mov(Jogador j, Quadrado ini, Quadrado fim)
	{
		this.j = j;
		this.ini = ini;
		this.fim = fim;
		this.pmov = ini.getPeça();
	}

	public boolean isRoque() {
		return roque;
	}

	public void setRoque(boolean roque) {
		this.roque = roque;
	}
	
	
}
