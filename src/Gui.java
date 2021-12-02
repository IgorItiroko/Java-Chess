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
                    if((cord.x > 556 && cord.x < 707) && (cord.y > 416 && cord.y < 464))
                    {
                    	System.out.println("Propor empate");
                    	/// Propor empate para o outro jogador.
                    }
                    else
                    {
	                    if((cord.x > 556 && cord.x < 707) && (cord.y > 342 && cord.y < 389))
	                    {
	                    	if(jogo.turno.isLadobranco())
	                    	{
	                    		System.out.println("O jogador do lado preto ganhou!");
	                    	}
	                    	else
	                    		System.out.println("O jogador do lado branco ganhou!");
	                    }
	                    else
	                    {
		                    if((cord.x > 556 && cord.x < 707) && (cord.y > 152 && cord.y < 202))
		                    {
		                    	jogo.isRoque(jogo.tabuleiro,jogo.turno.isLadobranco() ,true);
		                    	jogo.tabuleiro.printTabuleiro();
		                    }
		                    else
		                    {
		                    	if((cord.x > 555 && cord.x < 706) && (cord.y > 224 && cord.y < 272))
		                    			{
		                    				jogo.isRoque(jogo.tabuleiro, jogo.turno.isLadobranco(), false);
		                    				jogo.tabuleiro.printTabuleiro();
		                    			}
		                    	else
		                    	{
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
		    	                        ///jogo.construtorJogada(jogo.turno, Yi, Xi, Yf, Xf, false);
		    	                        scan = true;
		    	                        jogo.tabuleiro.printTabuleiro();   
		    	                    }
		                    	}
		
		                    }
	                    }
	                    
	                }
                }
                
            });
        }
    }