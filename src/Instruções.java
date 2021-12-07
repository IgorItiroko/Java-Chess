import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class Instruções{
	public static JFrame In;
	public static JFrame In2;
	 ImageIcon pag1 = new ImageIcon(getClass().getResource("images/RegrasXadrezpt1.png"));
	 ImageIcon pag2 = new ImageIcon(getClass().getResource("images/RegrasXadrezpt2.png"));
	 JLabel p1 = new JLabel(pag1);
	 JLabel p2 = new JLabel(pag2);
	
	public Instruções() {
		In = new JFrame();
		In.setVisible(true);
		In.setSize(800,830);
		In.setResizable(false);
		In.setLocationRelativeTo(null);
		In.add(p1);
		In.addMouseListener(new MouseAdapter () {
			public void mousePressed(MouseEvent i) {
				Point g = i.getPoint();
				
					if((g.x > 284 && g.y > 715) && (g.x < 496 && g.y <780)) {
						In.dispose();
						In2 = new JFrame();
						In2.setVisible(true);
						In2.setSize(800,830);
						In2.setResizable(false);
						In2.setLocationRelativeTo(null);
						In2.add(p2);
						
					}
				
			}
		});

	}
}
	

