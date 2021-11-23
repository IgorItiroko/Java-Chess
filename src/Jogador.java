
public class Jogador{
	public boolean ladobranco;
	public String nome;
	
	public boolean isLadobranco()
	{
		return this.ladobranco;
	}
	
	public void setNome(String nomeJ1)
	{
		this.nome = nomeJ1;
	}
	
	public String getNome() {
		return nome;
	}

	public Jogador(boolean Lado)
	{
		this.ladobranco = Lado;
	}
}
