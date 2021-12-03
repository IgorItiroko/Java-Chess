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
    private JLabel lblNewLabel_1;
    private JTextField campo1;
    private JTextField campo2;
    private static Jogador[] jogadores = new Jogador[2];
    ImageIcon menuImagem = new ImageIcon(getClass().getResource("/images/testeMenu.png"));
    JLabel menuInicial = new JLabel(menuImagem);

    

    public Telainicial(Jogador j1, Jogador j2) {
        iniJframe(j1,j2);
    }

    private void iniJframe(Jogador j1, Jogador j2) {
        frame = new JFrame();
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(100, 100, 600, 645);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon(this.getClass().getResource("/images/InserirNomes.png"));
        frame.getContentPane().setLayout(null);
        
        JButton confirmar = new JButton("Confirmar");
        confirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(campo1.getText() != null && campo2.getText() != null)
                {
                    j1.setNome(campo1.getText());
                    j2.setNome(campo2.getText());
                    Gui gui = new Gui(j1,j2);
                    gui.add(menuInicial);
                    gui.setLayout(null);
                    gui.setSize(735,560);
                    gui.setLocationRelativeTo(null);
                    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    gui.setVisible(true);
                    gui.setResizable(false);
                    frame.dispose();
                }    
            }
        });
        confirmar.setBounds(198, 481, 178, 52);
        frame.getContentPane().add(confirmar);
        confirmar.setBackground(new Color(239, 228, 176));
        
        
        campo2 = new JTextField();
        campo2.setColumns(10);
        campo2.setBounds(338, 403, 217, 36);
        frame.getContentPane().add(campo2);
        
        JLabel inserirNome2 = new JLabel("Insira o nome do jogador 2");
        inserirNome2.setForeground(new Color(88, 88, 88));
        inserirNome2.setFont(new Font("SansSerif", Font.PLAIN, 20));
        inserirNome2.setBackground(new Color(239, 228, 176));
        inserirNome2.setBounds(322, 355, 252, 36);
        frame.getContentPane().add(inserirNome2);
        
        campo1 = new JTextField();
        campo1.setBounds(47, 403, 217, 36);
        frame.getContentPane().add(campo1);
        campo1.setColumns(10);
        
        JLabel inserirNome1 = new JLabel("Insira o nome do jogador 1");
        inserirNome1.setFont(new Font("SansSerif", Font.PLAIN, 20));
        inserirNome1.setBounds(37, 355, 252, 36);
        frame.getContentPane().add(inserirNome1);
        inserirNome1.setBackground(Color.decode("#efe4b0"));
        inserirNome1.setForeground(Color.decode("#585858"));
        
        JLabel label = new JLabel("");
        label.setToolTipText("Insira o nome do jogador  2");
        label.setBounds(0, 0, 632, 619);
        label.setIcon(img);
        frame.getContentPane().add(label);
        
        
    }
}