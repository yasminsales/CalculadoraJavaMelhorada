package com.mycompany.calculadoraversao2;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.Label;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;

public class ViewCalculadora extends Frame implements ActionListener {

    DomainCalculadora domainCalculadora;
    Label digitelbl, digitelbl2, resultadolbl;
    TextField resultadotxt, num1txt, num2txt;
    Button somabtn, subtracaobtn, divisaobtn, multiplicacaobtn, limparbtn, sairbtn;

    public static void iniciar() {
        ViewCalculadora Janela = new ViewCalculadora();
        // Janela.addWindowListener(new fechajanela());
        Janela.show();
    }

    ViewCalculadora() {
        domainCalculadora = new DomainCalculadora();
        setTitle(".:Calculadora 2.0:.");

        setSize(350, 350);
        setLocation(800, 150);

        setBackground(new Color(150, 150, 150));
        setLayout(new GridLayout(11, 2)); //mudar número de linhas e colunas para ficar mais bonito 

        digitelbl = new Label("Número 1: ");
        digitelbl.setForeground(Color.white);

        digitelbl2 = new Label("Número 2: ");
        digitelbl2.setForeground(Color.white);
        resultadolbl = new Label("Resultado: ");
        resultadolbl.setForeground(Color.white);

        digitelbl.setFont(new Font("", Font.BOLD, 14));
        digitelbl2.setFont(new Font("", Font.BOLD, 14));
        resultadolbl.setFont(new Font("", Font.BOLD, 14));
        somabtn = new Button("+");
        somabtn.addActionListener(this);
        somabtn.setBackground(Color.decode("#DCDCDC"));
        subtracaobtn = new Button("-");
        subtracaobtn.addActionListener(this);
        subtracaobtn.setBackground(Color.decode("#DCDCDC"));
        multiplicacaobtn = new Button("x");
        multiplicacaobtn.addActionListener(this);
        multiplicacaobtn.setBackground(Color.decode("#DCDCDC"));
        divisaobtn = new Button("/");
        divisaobtn.addActionListener(this);
        divisaobtn.setBackground(Color.decode("#DCDCDC"));
        limparbtn = new Button("Limpar");
        limparbtn.addActionListener(this);
        limparbtn.setBackground(Color.blue);
        limparbtn.setForeground(Color.white);
        sairbtn = new Button("Sair");
        sairbtn.setBackground(Color.red);

        resultadotxt = new TextField();
        resultadotxt.setBackground(Color.decode("#DCDCDC"));
        num1txt = new TextField();
        num1txt.setBackground(Color.decode("#DCDCDC"));
        num2txt = new TextField();
        num2txt.setBackground(Color.decode("#DCDCDC"));
        resultadotxt.setEditable(false);

        add(digitelbl);
        add(num1txt);
        add(digitelbl2);
        add(num2txt);
        add(resultadolbl);
        add(resultadotxt);
        add(somabtn);
        add(subtracaobtn);
        add(divisaobtn);
        add(multiplicacaobtn);
        add(limparbtn);
        add(sairbtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == limparbtn) {
            num1txt.setText("");
            num2txt.setText("");
            resultadotxt.setText("");
            return;
        }
        if (e.getSource() == sairbtn) {
            num1txt.setText("");
            num2txt.setText("");
            resultadotxt.setText("");
            System.exit(0);
            return;

        }

        if (e.getSource() == somabtn) {
            int num1int = Integer.parseInt(num1txt.getText());
            int num2int = Integer.parseInt(num2txt.getText());
            int resultadoprint = domainCalculadora.soma(num1int, num2int);
            resultadotxt.setText(String.format("%d", resultadoprint));
        }

    }
}
