
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.awt.*;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.util.Scanner;


@SuppressWarnings("serial")
public class Gui extends JFrame{
    
	/// Inicialização de variáveis
	boolean op = true;
    boolean scan = true;
    public String p;
    public int lado;
    public int exit;
    public int Xi;
    public int Yi;
    public int Xf;
    public int Yf;
    
    /// variáveis de simulação
    public static int sXi;
    public static int sYi;
    public static int sXf;
    public static int sYf;
    public static Scanner leFile;
    
    /// variáveis de jogo
    private static Jogador[] jogadores = new Jogador[4];
    private static Jogo jogo;
    public static JFrame tabuleiroF;
    public Tabuleiro tabuleiro;
    public ArrayList<String> codigos = new ArrayList<>();
    ImageIcon board = new ImageIcon(getClass().getResource("images/tabuleiroMenu.png"));
    JLabel imgBoard = new JLabel(board);
    
    
    //Instanciamento de imagens
    
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
    
    ///Contornos para possiveis jogadas
    ImageIcon select = new ImageIcon(getClass().getResource("images/fundoSelecao.png"));
    ImageIcon pselect = new ImageIcon(getClass().getResource("images/fundoPossibilidade.png"));
    
    public JLabel Peças[] = new JLabel[40];
    public JLabel possivelSelecao[] = new JLabel[32];
    public JLabel selection = new JLabel ();
    public JLayeredPane layer = new JLayeredPane();
    
    //Simulação
    private JFrame telaSimula;
    public static Scanner readFile;
    ImageIcon simulaImagem = new ImageIcon(getClass().getResource("/images/simulacaoMenu.png"));
    JLabel simularMenu = new JLabel(simulaImagem);
    private JTextPane jogadasSim;
    public JFrame simulação;
    public JLayeredPane simulaLayer = new JLayeredPane();
    Jogo sjogo = new Jogo();
    public String roquedir = "0-0";
    public String roqueesq = "0-0-0";
    
    //Telas de Vitoria
    ImageIcon cw = new ImageIcon(getClass().getResource("images/catWins.png"));
    ImageIcon dw = new ImageIcon(getClass().getResource("images/dogWins.png"));
    JFrame dogWins;
    JFrame catWins;
    JLabel dog = new JLabel(dw);
    JLabel cat = new JLabel(cw);
    
    //Tela de empate
    ImageIcon ep = new ImageIcon(getClass().getResource("images/empate.png"));
    JFrame empate;
    JLabel emp = new JLabel(ep);
    
    public Gui(Jogador j1, Jogador j2) {
    	
        jogo = new Jogo();
        jogo.iniciar(j1,j2);
        setSize(735,564);
        layer.setBounds(0,0,735,564);
        
        JTextArea xequeDetector = new JTextArea();
        xequeDetector.setText("Xeque? " + jogo.xequedetect(tabuleiro,jogo.turno.isLadobranco()));
        xequeDetector.setForeground(new Color(88, 88, 88));
        xequeDetector.setFont(new Font("SansSerif", Font.PLAIN, 20));
        xequeDetector.setBackground(new Color(239, 228, 176));
        xequeDetector.setBounds(549, 239, 149, 31);
        getContentPane().add(xequeDetector);
        
        JTextArea mudancaTurno = new JTextArea();
        mudancaTurno.setFont(new Font("SansSerif", Font.PLAIN, 20));
        mudancaTurno.setBackground(Color.decode("#efe4b0"));
        mudancaTurno.setText("Turno do \n" + jogo.turno.nome);
        mudancaTurno.setForeground(Color.decode("#585858"));
        mudancaTurno.setBounds(549, 21, 149, 56);
        mudancaTurno.setEditable(false);
        getContentPane().add(mudancaTurno);
        getContentPane().add(layer);
        
        
        layer.add(imgBoard,JLayeredPane.DEFAULT_LAYER);
        imgBoard.setBounds(0, 0, 719, 523);
        
        iniciarTabuleiro(true);
            
            addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent e) {
                    Point cord = e.getPoint();
                    if(scan)
                    {
                    	Xi = (int) (cord.x - 15) / 64;
                        Yi = (int) (cord.y - 33) / 64;
                        
                        //Imagem do Seletor
                        if(Xi < 8 && Yi < 8)
                        {
                        	 selection.setIcon(select);
                             selection.setBounds(Xi*65,Yi*65,64,64);
                             layer.add(selection,JLayeredPane.PALETTE_LAYER);
                             
                            if(Tabuleiro.campo[Yi][Xi].getPeça() != null)
                            {
                                jogadasPossiveis(Yi, Xi);
                            }
                        }

                        scan = false;
                    }
                    else{
                        Xf = (int) (cord.x - 15 ) / 64;
                        Yf = (int) (cord.y - 33) / 64;
                        if((Xi < 8 && Yi < 8) && (Xf < 8 && Yf < 8)) {
                        	
                        	if(jogo.construtorJogada(jogo.turno, Yi, Xi, Yf, Xf, false))
                            codigos.add(jogo.codificaJogada(Xi,Yi,Xf,Yf));
                        	mudancaTurno.setText("Turno do \n" + jogo.turno.nome);
                        	xequeDetector.setText("Xeque? " + jogo.xequedetect(tabuleiro,jogo.turno.isLadobranco()));
                            iniciarTabuleiro(false);
                            
                            /// Cond 3 de empate, 50 movimentos de cada lado sem comer uma única peça e sem mover um peão.
                            if(jogo.movimentoj1 == 50 && jogo.movimentoj2 == 50 ) {
                            	int empt = JOptionPane.showConfirmDialog(null,"Foram realizados 50 movimentos onde nenhum dos jogadores realizaram a captura de uma peça ou o movimento de um peão"
                            			+ " deseja propor empate ?","Regra dos movimentos consecutivos",JOptionPane.YES_NO_OPTION);
                            	if(empt == 0) {
	                            	if(jogo.turno.isLadobranco()) {
	                            		lado = 1;
		                            	}
		                            	else
		                            		lado = 2;
	                            	
		                            	int input = JOptionPane.showConfirmDialog(null,"O Jogador "+lado+" propos empate! Deseja aceitar ?","Proposta de empate",JOptionPane.YES_NO_OPTION);
		                            	
		                               	if(input == 0) {
		                               		empate = new JFrame();
		    	                    		empate.setSize(800,800);
		    	                    		empate.getContentPane().add(emp);
		    	                    		empate.setLocationRelativeTo(null);
		    	                    		empate.setVisible(true);
		    	                    		empate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		                            		try {
		        								escreverFile();
		        							} catch (IOException e1) {
		        								e1.printStackTrace();
		        							}
		                            	}
		                            	else {
		                            		JOptionPane.showMessageDialog(null,"O pedido de empate foi recusado","Proposta de empate",JOptionPane.WARNING_MESSAGE);
		                            	}
                            	}
                            }
                            
                            /// Cond 2 de empate, quantidade de peças insuficiente para setar o xeque-mate.
                            if(jogo.faltaPeças(jogo.tabuleiro)) {
                            	empate = new JFrame();
	                    		empate.setSize(800,800);
	                    		empate.getContentPane().add(emp);
	                    		empate.setLocationRelativeTo(null);
	                    		empate.setVisible(true);
	                    		empate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            }
                            
                            /// Verifica se o jogo terminou, se é um Xeque-mate.
                           if(jogo.xequematedetect(tabuleiro, jogo.turno.isLadobranco()))
                       		{
                       		
                       		jogo.mudaTurno();
                       		if(!jogo.turno.isLadobranco()) {
	                    		dogWins = new JFrame();
	                    		dogWins.setSize(800,800);
	                    		dogWins.getContentPane().add(dog);
	                    		dogWins.setLocationRelativeTo(null);
	                    		dogWins.setVisible(true);
	                    		dogWins.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                       		}
                       		else
                       		{
                       			catWins = new JFrame();
	                    		catWins.setSize(800,800);
	                    		catWins.getContentPane().add(cat);
	                    		catWins.setLocationRelativeTo(null);
	                    		catWins.setVisible(true);
	                    		catWins.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                       		}
                       		/// caso o jogo tenha acabado, ele manda todas as jogadas realizadas para um arquivo txt.
                       		try {
								escreverFile();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
                       		}
                        }
                        scan = true;
                           
                    }
                    
                    //Prop. Empate
                    if((cord.x > 556 && cord.x < 707) && (cord.y > 389 && cord.y < 439))
                    {
                    	if(jogo.turno.isLadobranco()) {
                    		lado = 1;
                    	}
                    	else
                    		lado = 2;
                    	int input = JOptionPane.showConfirmDialog(null,"O Jogador "+lado+" propos empate! Deseja aceitar ?","Proposta de empate",JOptionPane.YES_NO_OPTION);
                    	if(input == 0) {
                    		empate = new JFrame();
                    		empate.setSize(800,800);
                    		empate.getContentPane().add(emp);
                    		empate.setLocationRelativeTo(null);
                    		empate.setVisible(true);
                    		empate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    		try {
								escreverFile();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
                    	}
                    	else {
                    		JOptionPane.showMessageDialog(null,"O pedido de empate foi recusado","Proposta de empate",JOptionPane.WARNING_MESSAGE);
                    	}
                    }
                    
                    //Desistencia
	                    if((cord.x > 556 && cord.x < 707) && (cord.y > 318 && cord.y < 364))
	                    {
	                    	if(jogo.turno.isLadobranco())
	                    	{
	                    		dogWins = new JFrame();
	                    		dogWins.setSize(800,800);
	                    		dogWins.getContentPane().add(dog);
	                    		dogWins.setLocationRelativeTo(null);
	                    		dogWins.setVisible(true);
	                    		dogWins.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                    		try {
									escreverFile();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
	                    		
	                    	}
	                    	else
	                    	{
	                    		catWins = new JFrame();
	                    		catWins.setSize(800,800);
	                    		catWins.getContentPane().add(cat);
	                    		catWins.setLocationRelativeTo(null);
	                    		catWins.setVisible(true);
	                    		catWins.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                    	try {
								escreverFile();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
	                    	}
	                    }
	                
	                    	//Roque
		                    if((cord.x > 556 && cord.x < 707) && (cord.y > 129 && cord.y < 177))
		                    {
		                    	if(jogo.isRoque(jogo.tabuleiro,jogo.turno.isLadobranco() ,true)) {
		                    		jogo.mudaTurno();
		                    		codigos.add("0-0");
		                    		iniciarTabuleiro(false);
		                    		mudancaTurno.setText("Turno do \n" + jogo.turno.nome);
		                    	}
		                    }

		                    if((cord.x > 555 && cord.x < 706) && (cord.y > 200 && cord.y < 247))
		                    		{
		                    			if(jogo.isRoque(jogo.tabuleiro, jogo.turno.isLadobranco(), false)) {
		                    				jogo.mudaTurno();
		                    				codigos.add("0-0-0");
		                    				iniciarTabuleiro(false);
		                    				mudancaTurno.setText("Turno do \n" + jogo.turno.nome);
		                    			}
		                    		}
		                    
		                    // Simular ultimo jogo
		                    if((cord.x > 555 && cord.x < 706) && (cord.y > 472 && cord.y < 520))
		                    {
		                    	initialize();
		                    }

                }
                     
            });
            
        }
  /// função que devolve quais são as jogadas possiveis, infelizmente não conseguimos excluir as jogadas que deixariam o rei em xeque, entretando elas também não podem ser executadas em jogo.
    public void jogadasPossiveis(int x, int y) {
    	int indx = 0;    	
    	for(int i =0 ; i<32; i++) {
    		possivelSelecao[i]= new JLabel();
    	}
    	if(Tabuleiro.campo[x][y].getPeça() != null)
    	{
        	for(int i = 0; i < 8; i++)
        	{
        		for(int j = 0; j < 8; j++)
        		{
        			if(Tabuleiro.campo[x][y].getPeça().canMove(tabuleiro, Tabuleiro.campo[x][y], Tabuleiro.campo[i][j], true))
        			{
        				
        					if(jogo.turno.isLadobranco() == Tabuleiro.campo[x][y].getPeça().isBranca()) {
        						
        						//Imagem das possíveis jogadas
            					possivelSelecao[indx].setIcon(pselect);
            					possivelSelecao[indx].setBounds(j*65,i*65,64,64);
            					layer.add(possivelSelecao[indx],JLayeredPane.PALETTE_LAYER);
            					indx++;
        						
        					}
        					
        				}
        			}
        		}
        	}
    	}
    
    /// Escreve no arquivo ultimoJogo.txt 
    public void escreverFile() throws IOException
    {
    	File codigo = new File("ultimoJogo.txt");
    	FileWriter fw = new FileWriter(codigo);
    	PrintWriter pw = new PrintWriter(fw);
    	for(String codigo1 : codigos)
    	{
    		pw.write(codigo1 + "\n");
    	}
    	pw.close();
    }
    
    /// função que gera as imagens das peças em uma layer diferente do tabuleiro.
    /// Como true, ela inicializa o tabuleiro, como false ela atualiza ele conforme os movimentos na classe tabuleiro.
        public void iniciarTabuleiro(boolean op) {
        	int indx = 0;
        	
        	for(int i =0 ; i<32; i++) {
        		Peças[i]= new JLabel();
        	}
        	if(op) {
        	   for(int i = 0; i<8; i++) {
           		for(int j=0; j<8 ; j++) {
           			if(Tabuleiro.campo[i][j].getPeça()!= null) {
           				{
           					 if(Tabuleiro.campo[i][j].getPeça().isBranca()) {
           						 
           						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 1) {
           		        				
           		        				Peças[indx].setIcon(pG);
           		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
           		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
           		        				indx ++;
           							 
           						 }
           						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 2) {
           							
        		        				Peças[indx].setIcon(tG);
        		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
        		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
        		        				indx ++;
           						 }
           						 
           						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 3) {
           							
        		        				Peças[indx].setIcon(cG);
        		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
        		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
        		        				indx ++;
           							 
           						 }
           						 
           						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 4) {
           							
        		        				Peças[indx].setIcon(bG);
        		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
        		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
        		        				indx ++;
           							 
           						 }
           						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 5) {
           							 
        		        				Peças[indx].setIcon(reiG);
        		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
        		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
        		        				indx ++;
           							 
           						 }
           						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 6) {
           							 
        		        				Peças[indx].setIcon(rainhaG);
        		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
        		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
        		        				indx ++;
           							 
           						 }
           					 }
           					 else {
           						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 1) {
        		        				
        		        				Peças[indx].setIcon(pC);
        		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
        		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
        		        				indx ++;
        							 
        						 }
        						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 2) {
        							
     		        				Peças[indx].setIcon(tC);
     		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
     		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
     		        				indx ++;
        						 }
        						 
        						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 3) {
        							
     		        				Peças[indx].setIcon(cC);
     		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
     		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
     		        				indx ++;
        							 
        						 }
        						 
        						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 4) {
        							 
     		        				Peças[indx].setIcon(bC);
     		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
     		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
     		        				indx ++;
        							 
        						 }
        						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 5) {
        							
     		        				Peças[indx].setIcon(reiC);
     		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
     		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
     		        				indx ++;
        							 
        						 }
        						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 6) {
        							
     		        				Peças[indx].setIcon(rainhaC);
     		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
     		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
     		        				indx ++;
        							 
        						 }
           						 
           					 }
           				}
           			}
           		}
           	}
        }
        	else {
        		layer.removeAll();
        		layer.add(imgBoard,JLayeredPane.DEFAULT_LAYER);
        	  	   for(int i = 0; i<8; i++) {
                  		for(int j=0; j<8 ; j++) {
                  			if(Tabuleiro.campo[i][j].getPeça()!= null) {
                  				{
                  					 if(Tabuleiro.campo[i][j].getPeça().isBranca()) {
                  						 
                  						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 1) {
                  		        				
                  		        				Peças[indx].setIcon(pG);
                  		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
                  		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
                  		        				indx ++;
                  							 
                  						 }
                  						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 2) {
                  							
               		        				Peças[indx].setIcon(tG);
               		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
               		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
               		        				indx ++;
                  						 }
                  						 
                  						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 3) {
                  							
               		        				Peças[indx].setIcon(cG);
               		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
               		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
               		        				indx ++;
                  							 
                  						 }
                  						 
                  						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 4) {
                  							
               		        				Peças[indx].setIcon(bG);
               		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
               		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
               		        				indx ++;
                  							 
                  						 }
                  						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 5) {
                  							 
               		        				Peças[indx].setIcon(reiG);
               		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
               		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
               		        				indx ++;
                  							 
                  						 }
                  						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 6) {
                  							 
               		        				Peças[indx].setIcon(rainhaG);
               		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
               		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
               		        				indx ++;
                  							 
                  						 }
                  					 }
                  					 else {
                  						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 1) {
               		        				
               		        				Peças[indx].setIcon(pC);
               		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
               		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
               		        				indx ++;
               							 
               						 }
               						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 2) {
               							
            		        				Peças[indx].setIcon(tC);
            		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
            		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
            		        				indx ++;
               						 }
               						 
               						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 3) {
               							
            		        				Peças[indx].setIcon(cC);
            		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
            		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
            		        				indx ++;
               							 
               						 }
               						 
               						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 4) {
               							 
            		        				Peças[indx].setIcon(bC);
            		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
            		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
            		        				indx ++;
               							 
               						 }
               						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 5) {
               							
            		        				Peças[indx].setIcon(reiC);
            		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
            		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
            		        				indx ++;
               							 
               						 }
               						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 6) {
               							
            		        				Peças[indx].setIcon(rainhaC);
            		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
            		        				layer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
            		        				indx ++;
               							 
               						 }
                  						 
                  					 }
                  				}
                  			}
                  		}
                  	}
        		
        	}
        	   
        }
        
      /// Função que inicializa a tela de simulação
        private void initialize() {
            int n = 1;
            telaSimula = new JFrame();
            simulaLayer.setBounds(0,0,735,564);
            simulaLayer.add(simularMenu,JLayeredPane.DEFAULT_LAYER);
            getContentPane().add(simulaLayer);
            
            telaSimula.setBounds(0, 0, 735, 564);
            telaSimula.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            telaSimula.getContentPane().setLayout(null);
            telaSimula.setVisible(true);
            

            jogadasSim = new JTextPane();
            jogadasSim.setBounds(538, 94, 160, 304);
            jogadasSim.setForeground(new Color(88, 88, 88));
            jogadasSim.setBackground(new Color(239, 228, 176));
            telaSimula.getContentPane().add(jogadasSim);
            telaSimula.setLocationRelativeTo(null);
            
            
            try {
                readFile = new Scanner(new File("ultimoJogo.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while(readFile.hasNext())
            {
            	String ver = readFile.next();
            	
                jogadasSim.setText((jogadasSim.getText() + n + ". " + ver + " " + readFile.next() + "\n"));        
                n++;
            }
            jogadasSim.setEditable(false);
            JPanel container = new JPanel();
            container.add(jogadasSim);
            JScrollPane scrollBar = new JScrollPane(container,
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollBar.getViewport().getView().setBackground(new Color(239, 228, 176));
            scrollBar.getViewport().getView().setFont(new Font("SansSerif", Font.PLAIN, 30));
            scrollBar.getViewport().getView().setForeground(new Color(88,88,88));
            scrollBar.setBounds(540, 94, 150, 300);
            telaSimula.getContentPane().add(scrollBar);
            simularMenu.setBounds(0, 0, 719, 525);
            telaSimula.getContentPane().add(simulaLayer);
            
            jogadores[2] = new Jogador(true);
            jogadores[3] = new Jogador(false);
            
            sjogo.iniciar(jogadores[2],jogadores[3] );
            simulaInicia(true);
            
            try {
                leFile = new Scanner(new File("ultimoJogo.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            telaSimula.addMouseListener(new MouseAdapter (){
            	public void mousePressed(MouseEvent h) {
            		Point p = h.getPoint();
            		 if((p.x > 550 && p.y > 450)&&(p.x < 700 && p.y <508)) {
            			 if(leFile.hasNext()) {
            			 
            			 String qinicial = leFile.next();
            			 
            			 if(Objects.equals(qinicial, roquedir))
                         {
            					sjogo.isRoque(tabuleiro, sjogo.turno.isLadobranco(), true);
            					sjogo.mudaTurno();
                         }
                         else 
                         {
                             if(Objects.equals(qinicial,roqueesq))
                             {
                                 sjogo.isRoque(tabuleiro, sjogo.turno.isLadobranco(), false);
                                 sjogo.mudaTurno();
                             }
                             else
                             {
                            	 switch(qinicial.charAt(0))
                                 {
                                     case 'a': {sXi = 0; break;} 
                                     case 'b': {sXi = 1; break;}
                                     case 'c': {sXi = 2; break;}
                                     case 'd': {sXi = 3; break;}
                                     case 'e': {sXi = 4; break;}
                                     case 'f': {sXi = 5; break;}
                                     case 'g': {sXi = 6; break;}
                                     case 'h': {sXi = 7; break;}
                                 }
                                 sYi = Character.getNumericValue(qinicial.charAt(1));

                                 String qfinal = leFile.next();
                                 switch(qfinal.charAt(0))
                                 {
	                                 case 'a': {sXf = 0; break;} 
	                                 case 'b': {sXf = 1; break;}
	                                 case 'c': {sXf = 2; break;}
	                                 case 'd': {sXf = 3; break;}
	                                 case 'e': {sXf = 4; break;}
	                                 case 'f': {sXf = 5; break;}
	                                 case 'g': {sXf = 6; break;}
	                                 case 'h': {sXf = 7; break;}
                                 }
                                 sYf = Character.getNumericValue(qfinal.charAt(1));
                                 sjogo.pulaCanMove(sYi, sXi, sYf, sXf);
                                 sjogo.mudaTurno();
                             }
                         }
                         

                         

                         simulaInicia(false);
                         telaSimula.getContentPane().validate();
                         telaSimula.getContentPane().repaint();
            			 
            		 }
            	}
            	}
            	
            });
        }
        
        /// Inicializa a simulação (contato do txt com o tabuleiro)
        public void simulaInicia(boolean op) {
        	int indx=0;
        	for(int i =0 ; i<32; i++) {
        		Peças[i]= new JLabel();
        	}
        	
        	if(op) {
        	   for(int i = 0; i<8; i++) {
           		for(int j=0; j<8 ; j++) {
           			if(Tabuleiro.campo[i][j].getPeça()!= null) {
           				{
           					 if(Tabuleiro.campo[i][j].getPeça().isBranca()) {
           						 
           						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 1) {
           		        				
           		        				Peças[indx].setIcon(pG);
           		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
           		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
           		        				indx ++;
           							 
           						 }
           						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 2) {
           							
        		        				Peças[indx].setIcon(tG);
        		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
        		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
        		        				indx ++;
           						 }
           						 
           						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 3) {
           							
        		        				Peças[indx].setIcon(cG);
        		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
        		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
        		        				indx ++;
           							 
           						 }
           						 
           						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 4) {
           							
        		        				Peças[indx].setIcon(bG);
        		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
        		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
        		        				indx ++;
           							 
           						 }
           						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 5) {
           							 
        		        				Peças[indx].setIcon(reiG);
        		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
        		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
        		        				indx ++;
           							 
           						 }
           						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 6) {
           							 
        		        				Peças[indx].setIcon(rainhaG);
        		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
        		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
        		        				indx ++;
           							 
           						 }
           					 }
           					 else {
           						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 1) {
        		        				
        		        				Peças[indx].setIcon(pC);
        		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
        		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
        		        				indx ++;
        							 
        						 }
        						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 2) {
        							
     		        				Peças[indx].setIcon(tC);
     		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
     		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
     		        				indx ++;
        						 }
        						 
        						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 3) {
        							
     		        				Peças[indx].setIcon(cC);
     		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
     		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
     		        				indx ++;
        							 
        						 }
        						 
        						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 4) {
        							 
     		        				Peças[indx].setIcon(bC);
     		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
     		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
     		        				indx ++;
        							 
        						 }
        						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 5) {
        							
     		        				Peças[indx].setIcon(reiC);
     		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
     		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
     		        				indx ++;
        							 
        						 }
        						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 6) {
        							
     		        				Peças[indx].setIcon(rainhaC);
     		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
     		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
     		        				indx ++;
        							 
        						 }
           						 
           					 }
           				}
           			}
           		}
           	}
        }
        	else {
        		simulaLayer.removeAll();       		
            	simulaLayer.add(simularMenu,JLayeredPane.DEFAULT_LAYER);
            	
        	  	   for(int i = 0; i<8; i++) {
                  		for(int j=0; j<8 ; j++) {
                  			if(Tabuleiro.campo[i][j].getPeça()!= null) {
                  				{
                  					 if(Tabuleiro.campo[i][j].getPeça().isBranca()) {
                  						 
                  						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 1) {
                  		        				
                  		        				Peças[indx].setIcon(pG);
                  		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
                  		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
                  		        				indx ++;
                  							 
                  						 }
                  						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 2) {
                  							
               		        				Peças[indx].setIcon(tG);
               		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
               		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
               		        				indx ++;
                  						 }
                  						 
                  						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 3) {
                  							
               		        				Peças[indx].setIcon(cG);
               		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
               		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
               		        				indx ++;
                  							 
                  						 }
                  						 
                  						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 4) {
                  							
               		        				Peças[indx].setIcon(bG);
               		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
               		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
               		        				indx ++;
                  							 
                  						 }
                  						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 5) {
                  							 
               		        				Peças[indx].setIcon(reiG);
               		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
               		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
               		        				indx ++;
                  							 
                  						 }
                  						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 6) {
                  							 
               		        				Peças[indx].setIcon(rainhaG);
               		        				Peças[indx].setBounds(j*64,i*67, 64, 64);
               		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
               		        				indx ++;
                  							 
                  						 }
                  					 }
                  					 else {
                  						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 1) {
               		        				
               		        				Peças[indx].setIcon(pC);
               		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
               		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
               		        				indx ++;
               							 
               						 }
               						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 2) {
               							
            		        				Peças[indx].setIcon(tC);
            		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
            		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
            		        				indx ++;
               						 }
               						 
               						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 3) {
               							
            		        				Peças[indx].setIcon(cC);
            		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
            		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
            		        				indx ++;
               							 
               						 }
               						 
               						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 4) {
               							 
            		        				Peças[indx].setIcon(bC);
            		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
            		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
            		        				indx ++;
               							 
               						 }
               						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 5) {
               							
            		        				Peças[indx].setIcon(reiC);
            		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
            		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
            		        				indx ++;
               							 
               						 }
               						 if(Tabuleiro.campo[i][j].getPeça().getIdentidade() == 6) {
               							
            		        				Peças[indx].setIcon(rainhaC);
            		        				Peças[indx].setBounds(j*64,i*66, 64, 64);
            		        				simulaLayer.add(Peças[indx],JLayeredPane.MODAL_LAYER);
            		        				indx ++;
               							 
               						 }
                  						 
                  					 }
                  				}
                  			}
                  		}
                  	}
        	  	 telaSimula.getContentPane().add(simulaLayer);       	       	  	
        	}
    	  
        }
    }