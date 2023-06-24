package GUI;

import Model.Polinom;
import Operations.Operatie;

import javax.swing.*;
import java.awt.*;

public class Interfata {
    private JPanel panel = new JPanel();
    String p1;//string pt polinomul din TextFieldul1
    String p2;//string pt polinomul din TextFieldul2
    Polinom pol1 = new Polinom();
    Polinom pol2 = new Polinom();
    Polinom rez = new Polinom();
    private JFrame f = new JFrame();

    private JLabel titlu = new JLabel("Polynomial Calculator");
    private JLabel l1 = new JLabel("Polynomial 1");
    private JLabel l2 = new JLabel("Polynomial 2");
    private JLabel l3 = new JLabel("Result");

    private JButton adunare = new JButton("Add");
    private JButton scadere = new JButton("Subtraction");
    private JButton inmultire = new JButton("Multiply");
    private JButton impartire = new JButton("Division");
    private JButton derivare = new JButton("Derivative");
    private JButton integrare = new JButton("Integral");

    private JTextField t1 = new JTextField(50);
    private JTextField t2 = new JTextField(50);
    private JTextField t3 = new JTextField(50);

    public Interfata(){
        //setez fiecare label
        titlu.setFont(new Font("Verdana", Font.PLAIN, 32));
        titlu.setForeground(new Color(192,192,192));
        titlu.setHorizontalAlignment(SwingConstants.CENTER);
        titlu.setBounds(70,0,350,100);
        panel.add(titlu);

        l1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l1.setForeground(Color.WHITE);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setBounds(0,100,100,70);
        panel.add(l1);

        l2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l2.setForeground(Color.WHITE);
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        l2.setBounds(0,150,100,70);
        panel.add(l2);

        l3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l3.setForeground(Color.WHITE);
        l3.setHorizontalAlignment(SwingConstants.CENTER);
        l3.setBounds(0,200,100,70);
        panel.add(l3);

        //setez fiecare textField
        t1.setColumns(10);
        t1.setBounds(100, 127, 330, 25);
        panel.add(t1);

        t2.setColumns(10);
        t2.setBounds(100, 175, 330, 25);
        panel.add(t2);

        t3.setColumns(10);
        t3.setBounds(100, 225, 330, 25);
        t3.setText("Please enter at least one polynomial");
        panel.add(t3);

        //Setez butoanele si leg butoanele de operatii
        //adunare
        adunare.setBounds(5,280,150, 50);
        adunare.setBackground(Color.BLACK);
        adunare.setForeground(Color.WHITE);
        adunare.setFocusable(false);
        adunare.addActionListener(e->{
                p1 = t1.getText();
                p2 = t2.getText();
                pol1 = Operatie.convert(p1);
                pol2 = Operatie.convert(p2);
                rez = Operatie.add(pol1,pol2);
                t3.setText(rez.toString());
                });
        panel.add(adunare);

        //scadere
        scadere.setBounds(165,280, 150, 50);
        scadere.setBackground(Color.BLACK);
        scadere.setForeground(Color.WHITE);
        scadere.setFocusable(false);
        scadere.addActionListener(e->{
            p1 = t1.getText();
            p2 = t2.getText();
            pol1 = Operatie.convert(p1);
            pol2 = Operatie.convert(p2);
            rez = Operatie.sub(pol1, pol2);
            t3.setText(rez.toString());
        });
        panel.add(scadere);

        //inmultire
        inmultire.setBounds(325,280, 150, 50);
        inmultire.setBackground(Color.BLACK);
        inmultire.setForeground(Color.WHITE);
        inmultire.setFocusable(false);
        inmultire.addActionListener(e->{
            p1 = t1.getText();
            p2 = t2.getText();
            pol1 = Operatie.convert(p1);
            pol2 = Operatie.convert(p2);
            rez = Operatie.mul(pol1, pol2);
            t3.setText(rez.toString());
        });
        panel.add(inmultire);

        //impartire
        impartire.setBounds(5,350, 150, 50);
        impartire.setBackground(Color.BLACK);
        impartire.setForeground(Color.WHITE);
        impartire.setFocusable(false);
        impartire.addActionListener(e->{
            t3.setText("Nu este implementata impartirea! Incearca alta operatie!");
        });
        panel.add(impartire);

        //derivare
        derivare.setBounds(165, 350, 150, 50);
        derivare.setBackground(Color.BLACK);
        derivare.setForeground(Color.WHITE);
        derivare.setFocusable(false);
        derivare.addActionListener(e->{
            p1 = t1.getText();
            pol1 = Operatie.convert(p1);
            rez = Operatie.derivate(pol1);
            t3.setText(rez.toString());
        });
        panel.add(derivare);

        //integrare
        integrare.setBounds(325,350, 150, 50);
        integrare.setBackground(Color.BLACK);
        integrare.setForeground(Color.WHITE);
        integrare.setFocusable(false);
        integrare.addActionListener(e->{
            p1 = t1.getText();
            pol1 = Operatie.convert(p1);
            rez = Operatie.integrate(pol1);
            t3.setText(rez.toString() + " + C"); //adaug si constanta de la integrare
        });
        panel.add(integrare);

        //Setez frameul
        f.setTitle("Polynomial Calculator");
        f.setSize(600,300);
        f.setBounds(300,300,500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Facultate\\Anul 2\\SEM2\\TP\\PT2023_30223_Boar_Daniel_Assignment_1\\calc.png"); //adaug o imagine frameului
        f.setIconImage(icon);

        //Setez panelul
        Color c = new Color(22 ,135, 245);
        panel.setBackground(c);
        f.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        f.setVisible(true);
    }
}
