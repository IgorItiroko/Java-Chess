import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Menu {
    private static Jogador[] jogadores = new Jogador[2];
    public static menuPrincipal menu;
    public static JFrame mm;
    private static Jogo jogo;
    public static void main(String[] args) throws FileNotFoundException {

        menu = new menuPrincipal ();
    }
    
    
    static class menuPrincipal{
        ImageIcon menuImagem = new ImageIcon(getClass().getResource("/images/testeMenu.png"));
        JLabel menuInicial = new JLabel(menuImagem);
        
        public menuPrincipal() {
            //Tela
        	jogadores[0] = new Jogador(true);
            jogadores[1] = new Jogador(false);
            mm = new JFrame();
            mm.add(menuInicial);
            mm.setLayout(new FlowLayout());
            //mm.setVisible(false);
            mm.setSize(600,645);
            mm.setLocationRelativeTo(null);
            mm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mm.setVisible(true);
            mm.addMouseListener(new MouseAdapter(){
                
                public void mousePressed(MouseEvent a) {
                    
                    Point z = a.getPoint();
                    System.out.println(z.x + "," + z.y);
                    
                    if((z.getX() > 146 && z.getX() < 455) && (z.getY() > 149 && z.getY() < 235)) {
                    	mm.dispose();
                    	Telainicial iT = new Telainicial(jogadores[0],jogadores[1]);
                    	
                            
                    }
                    if((z.getX() > 154 && z.getX() < 457) && (z.getY() > 282 && z.getY() < 378)) {
                            Instruções inst = new Instruções();
                            
                    }
                    if((z.getX() > 155 && z.getX() < 457) && (z.getY() > 432 && z.getY() < 518)) {
                    	System.exit(0);
                    }
                    
                }
                
                
            });
        }
                
        
    }

}