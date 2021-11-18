
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Font;

public class Telainicial{

	JFrame frame;
	private JTextField nomeJ1;
	private JLabel lblNewLabel_1;
	private JTextField nomeJ2;

	

	public Telainicial(Jogador j1, Jogador j2) {
		iniJframe(j1,j2);
	}

	private void iniJframe(Jogador j1, Jogador j2) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 640, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/chess.jpg"));
		
		JLabel lblNewLabel = new JLabel("Nome do primeiro jogador: ");
		lblNewLabel.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 86, 235, 51);
		frame.getContentPane().add(lblNewLabel);
		
		nomeJ1 = new JTextField();
		nomeJ1.setBounds(10, 132, 198, 26);
		frame.getContentPane().add(nomeJ1);
		nomeJ1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do segundo jogador: ");
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(382, 86, 255, 51);
		frame.getContentPane().add(lblNewLabel_1);
		
		nomeJ2 = new JTextField();
		nomeJ2.setColumns(10);
		nomeJ2.setBounds(382, 132, 198, 26);
		frame.getContentPane().add(nomeJ2);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j1.setNome(nomeJ1.getText());
				j2.setNome(nomeJ2.getText());
				return;
			}
		});
		btnNewButton.setBounds(211, 227, 160, 37);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(img);
		label.setBounds(0, 0, 624, 387);
		frame.getContentPane().add(label);
		
		
	}
}

