import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu {
	
	public static menuPrincipal menu;
	public static JFrame mm;
	public static void main(String[] args) {
		 menu = new menuPrincipal ();
	}
	
	
	static class menuPrincipal{
		ImageIcon menuImagem = new ImageIcon(getClass().getResource("/images/testeMenu.png"));
		JLabel menuInicial = new JLabel(menuImagem);
		
		public menuPrincipal() {
			//Tela
			mm = new JFrame();
			mm.add(menuInicial);
			mm.setLayout(new FlowLayout());
		    mm.setVisible(false);
		    mm.setSize(600,600);
		    mm.setLocationRelativeTo(null);
		    mm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    mm.setVisible(true);
		    mm.addMouseListener(new MouseAdapter(){
		    	
		    	public void mousePressed(MouseEvent a) {
		    		
		    		Point z = a.getPoint();
		    		System.out.println(z.x + "," + z.y);
		    		
		    		if((z.getX() > 146 && z.getX() < 455) && (z.getY() > 149 && z.getY() < 235)) {
		    				
		    				Gui gui = new Gui();
		    				gui.add(menuInicial);
		    				gui.setLayout(new FlowLayout());
		    			    gui.setVisible(false);
		    			    gui.setSize(735,564);
		    			    gui.setLocationRelativeTo(null);
		    			    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    			    gui.setVisible(true);
		    				mm.dispose();
		    				
		    				
		    		}
		    		if((z.getX() > 154 && z.getX() < 457) && (z.getY() > 282 && z.getY() < 378)) {
		    				Instruções inst = new Instruções();
		    				
		    		}
		    		if((z.getX() > 155 && z.getX() < 457) && (z.getY() > 432 && z.getY() < 518)) {
		    			java.lang.System.exit(0);
		    		}
		    		
		    	}
		    	
		    	
		    });
		}
				
		
	}

}
