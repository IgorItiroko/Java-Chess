import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.Scrollbar;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class telaSimulação {


    private JFrame telaSimula;
    public static Scanner readFile;
    ImageIcon simulaImagem = new ImageIcon(getClass().getResource("/images/simulaçãoMenu.png"));
    JLabel simularMenu = new JLabel(simulaImagem);
    private JTextPane jogadasSim;
    public static void main(String[] args) {
                try {
                    telaSimulação window = new telaSimulação();
                    window.telaSimula.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }

    public telaSimulação() {
        initialize();
    }

    private void initialize() {
        int n = 1;
        telaSimula = new JFrame();
        telaSimula.setBounds(0, 0, 735, 564);
        telaSimula.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaSimula.getContentPane().setLayout(null);
        

        jogadasSim = new JTextPane();
        jogadasSim.setBounds(538, 94, 160, 304);
        jogadasSim.setForeground(new Color(88, 88, 88));
        jogadasSim.setBackground(new Color(239, 228, 176));
        telaSimula.getContentPane().add(jogadasSim);
        try {
            readFile = new Scanner(new File("ultimoJogo.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(readFile.hasNext())
        {
            jogadasSim.setText((jogadasSim.getText() + n + ". " + readFile.next() + " " + readFile.next() + "\n"));        
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
        telaSimula.getContentPane().add(simularMenu);
    }
}