
public class Mov {
	private Quadrado ini;
	private Quadrado fim;
	private Pe�a pmov;
	private Pe�a pmorta;
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

	public void setPmorta(Pe�a p){
		this.pmorta = p;
	}
	
	public Pe�a getPmorta() {
		return this.pmorta;
	}
	
	
	public Pe�a getPmov() {
		return pmov;
	}

	public void setPmov(Pe�a pmov) {
		this.pmov = pmov;
	}
	
	
	public Mov(Quadrado ini, Quadrado fim)
	{
		this.ini = ini;
		this.fim = fim;
		this.pmov = ini.getPe�a();
	}

	public boolean isRoque() {
		return roque;
	}

	public void setRoque(boolean roque) {
		this.roque = roque;
	}
	
	
}
