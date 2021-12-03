import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;


public class Gui extends JFrame{
<<<<<<< Updated upstream
	
	boolean scan = true;
	public int Xi;
	public int Yi;
	public int Xf;
	public int Yf;
	private static Jogador[] jogadores = new Jogador[2];
	private static Jogo jogo;
	public static JFrame tabuleiroF;
	public Tabuleiro tabuleiro;
	ImageIcon board = new ImageIcon(getClass().getResource("images/tabuleiroMenu.png"));
	JLabel imgBoard = new JLabel(board);
	public JLabel Peças[];
	
		public Gui() {
			
			jogadores[0] = new Jogador(true);
			jogadores[1] = new Jogador(false);
			jogo = new Jogo();
			jogo.iniciar(jogadores[0],jogadores[1]);
			setSize(735,564);
			getContentPane().setLayout(null);
			
			jogadores[0].setNome("Carlos");
			jogadores[1].setNome("Denis");
			
			
			JTextArea txtrBlaBlaBla = new JTextArea();
			txtrBlaBlaBla.setBackground(Color.WHITE);
			txtrBlaBlaBla.setText("Turno do " + jogo.turno.nome);
			txtrBlaBlaBla.setBounds(531, 21, 178, 32);
			getContentPane().add(txtrBlaBlaBla);
			
			imgBoard.setBounds(0, 0, 719, 525);
			getContentPane().add(imgBoard);
			
		    addMouseListener(new MouseAdapter(){
		    	public void mousePressed(MouseEvent e) {
		    		Point cord = e.getPoint();
		    		if(scan)
		    		{
		    			System.out.println(cord.x+","+cord.y);
			    		Xi = (int) (cord.x - 15 ) / 64;
			    		Yi = (int) (cord.y - 50) / 64;
			    		System.out.println("X,Y Inicial:" +Xi+","+Yi);
			    		scan = false;
		    		}
		    		else{
		    			System.out.println(cord.x+","+cord.y);
			    		Xf = (int) (cord.x - 15 ) / 64;
			    		Yf = (int) (cord.y - 50) / 64;
			    		System.out.println("X,Y Final:"+Xf+","+Yf);
		    			jogo.construtorJogada(jogo.turno, Yi, Xi, Yf, Xf, false);
		    			scan = true;
		    			jogo.tabuleiro.printTabuleiro();
		    		}
		    		
		    		
		    	}
		    	
		    });
		}
	}

=======
    
	boolean op = true;
    boolean scan = true;
    public int lado;
    public int exit;
    public int Xi;
    public int Yi;
    public int Xf;
    public int Yf;
    private static Jogo jogo;
    public static JFrame tabuleiroF;
    public Tabuleiro tabuleiro;
    public static Telainicial tI;
    ImageIcon board = new ImageIcon(getClass().getResource("images/tabuleiroMenu.png"));
    JLabel imgBoard = new JLabel(board);
    
    //Peças
    
    //Brancas
    ImageIcon pG = new ImageIcon(getClass().getResource("images/gatoChess.png"));
    ImageIcon tG = new ImageIcon(getClass().getResource("images/gatoTorre.png"));
    ImageIcon cG = new ImageIcon(getClass().getResource("images/gatoCavalo.png"));
    ImageIcon bG = new ImageIcon(getClass().getResource("images/gatoBispo.png"));
    ImageIcon reiG = new ImageIcon(getClass().getResource("images/gatoRei.png"));
    ImageIcon rainhaG = new ImageIcon(getClass().getResource("images/gatoRainha.png"));
    //Pretas
    ImageIcon pC = new ImageIcon(getClass().getResource("images/cachorroPeao.png"));
    ImageIcon tC = new ImageIcon(getClass().getResource("images/cachorroTorre.png"));
    ImageIcon cC = new ImageIcon(getClass().getResource("images/cachorroCavalo.png"));
    ImageIcon bC = new ImageIcon(getClass().getResource("images/cachorroBispo.png"));
    ImageIcon reiC = new ImageIcon(getClass().getResource("images/cachorroRei.png"));
    ImageIcon rainhaC = new ImageIcon(getClass().getResource("images/cachorroRainha.png"));
    public JLabel Peças[] = new JLabel[32];
    public JLayeredPane layer = new JLayeredPane();
    
    
        public Gui(Jogador j1, Jogador j2) {

            jogo = new Jogo();
            jogo.iniciar(j1,j2);
            //setSize(735,564);
            
            layer.setBounds(0,0,735,564);
            layer.add(imgBoard,JLayeredPane.DEFAULT_LAYER);
            
            
            JTextArea mudancaTurno = new JTextArea();
            mudancaTurno.setFont(new Font("SansSerif", Font.PLAIN, 20));
            mudancaTurno.setBackground(Color.decode("#efe4b0"));
            mudancaTurno.setText("Turno do \n" + jogo.turno.nome);
            mudancaTurno.setForeground(Color.decode("#585858"));
            mudancaTurno.setBounds(549, 21, 149, 56);
            mudancaTurno.setEditable(false);
            getContentPane().add(mudancaTurno);
           // getContentPane().setLayout(null);
            imgBoard.setBounds(0, 0, 719, 523);
            getContentPane().add(layer);
            
            iniciarTabuleiro(true);
            
            
            addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent e) {
                    Point cord = e.getPoint();
                    
                    if(scan)
                    {
                    	Xi = (int) (cord.x - 15) / 64;
                        Yi = (int) (cord.y - 33) / 64;
                        System.out.println(cord.x+","+cord.y);
                        System.out.println("X,Y Inicial:" +Xi+","+Yi);
                        scan = false;
                    }
                    else{
                        System.out.println(cord.x+","+cord.y);
                        Xf = (int) (cord.x - 15 ) / 64;
                        Yf = (int) (cord.y - 33) / 64;
                        System.out.println("X,Y Final:"+Xf+","+Yf);
                        if((Xi < 8 && Yi < 8) && (Xf < 8 && Yf < 8)) {
                        	jogo.construtorJogada(jogo.turno, Yi, Xi, Yf, Xf, false);
                        	mudancaTurno.setText("Turno do \n" + jogo.turno.nome);
                            jogo.tabuleiro.printTabuleiro();
                           iniciarTabuleiro(false);
                           System.out.println(jogo.xequematedetect(jogo.tabuleiro,jogo.turno.isLadobranco()));
                           if(jogo.xequematedetect(jogo.tabuleiro,jogo.turno.isLadobranco()))
                       	{
                       		String lado;
                       		if(jogo.turno.isLadobranco())
                       		{
                       			lado = "preto";
                       		}
                       		else
                       			lado = "branco";
	                    		JOptionPane.showMessageDialog(null, "Xequemate! O Jogador do lado " + lado + " ganhou!","Fim de jogo!",JOptionPane.PLAIN_MESSAGE);
	                    		System.exit(0);
                       	}

                        }
                        scan = true;
                           
                    }
                    
                    //Prop. Empate
                    if((cord.x > 556 && cord.x < 707) && (cord.y > 416 && cord.y < 464))
                    {
                    	System.out.println("Propor empate");
                    	if(jogo.turno.isLadobranco()) {
                    		lado = 1;
                    	}
                    	else
                    		lado = 2;
                    	int input = JOptionPane.showConfirmDialog(null,"O Jogador "+lado+" propos empate! Deseja aceitar ?","Proposta de empate",JOptionPane.YES_NO_OPTION);
                    	if(input == 0) {
                    		JOptionPane.showMessageDialog(null,"Jogo terminou em empate!","Empate",JOptionPane.INFORMATION_MESSAGE);
                    		System.exit(0);
                    	}
                    	else {
                    		JOptionPane.showMessageDialog(null,"O pedido de empate foi recusado","Proposta de empate",JOptionPane.WARNING_MESSAGE);
                    	}
                    }
                    
                    //Desistencia
	                    if((cord.x > 556 && cord.x < 707) && (cord.y > 342 && cord.y < 389))
	                    {
	                    	if(jogo.turno.isLadobranco())
	                    	{
	                    		JOptionPane.showMessageDialog(null, "O Jogador do lado preto ganhou!","Fim de jogo!",JOptionPane.PLAIN_MESSAGE);
	                    		System.exit(0);
	                    		
	                    	}
	                    	else
	                    	{
	                    		System.out.println("O jogador do lado branco ganhou!");
	                    	JOptionPane.showMessageDialog(null, "O Jogador do lado branco ganhou!","Fim de jogo!",JOptionPane.PLAIN_MESSAGE);
                    		System.exit(0);
	                    	}
	                    }
	                
	                    	//Roque
		                    if((cord.x > 556 && cord.x < 707) && (cord.y > 152 && cord.y < 202))
		                    {
		                    	System.out.println();
		                    	if(jogo.isRoque(jogo.tabuleiro,jogo.turno.isLadobranco() ,true)) {
		                    		jogo.mudaTurno();
		                    		iniciarTabuleiro(false);
		                    		mudancaTurno.setText("Turno do \n" + jogo.turno.nome);
		                    	}
		                    	jogo.tabuleiro.printTabuleiro();
		                    }
>>>>>>> Stashed changes

