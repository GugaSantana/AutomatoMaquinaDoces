package br.usjt.tcalform.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import br.usjt.tcalform.controller.AutomatoController;

public class AutomatoGUI extends JFrame implements ActionListener {
	private JButton bAdd1R, bAdd2R, bAdd5R, bDoceA, bDoceB, bDoceC, bDevolver;
	private JPanel pEsquerda, pCentro2, pDireita;
	private JTextArea taMonitor;
	private JScrollPane spMonitor;

	AutomatoController automatoCtrl = new AutomatoController();

	public AutomatoGUI() {
		super("Máquina de Doces");

		setLayout(new BorderLayout(10, 10));

		pEsquerda = new JPanel(new BorderLayout(10, 10));
		pEsquerda.setBorder(new EmptyBorder(10, 10, 10, 10));

		pCentro2 = new JPanel(new GridLayout(3, 3, 5, 5));

		bAdd1R = new JButton("1 Real");
		bAdd1R.addActionListener(this);
		bAdd2R = new JButton("2 Reais");
		bAdd2R.addActionListener(this);
		bAdd5R = new JButton("5 Reais");
		bAdd5R.addActionListener(this);

		bDoceA = new JButton("Doce A (R$6)");
		bDoceA.addActionListener(this);
		bDoceA.setEnabled(false);
		bDoceB = new JButton("Doce B (R$7)");
		bDoceB.addActionListener(this);
		bDoceB.setEnabled(false);
		bDoceC = new JButton("Doce C (R$8)");
		bDoceC.addActionListener(this);
		bDoceC.setEnabled(false);

		bDevolver = new JButton("Cancelar");
		bDevolver.addActionListener(this);
		bDevolver.setEnabled(false);

		pCentro2.add(bAdd1R);
		pCentro2.add(bDoceA);
		pCentro2.add(bAdd2R);
		pCentro2.add(bDoceB);
		pCentro2.add(bAdd5R);
		pCentro2.add(bDoceC);

		taMonitor = new JTextArea();
		spMonitor = new JScrollPane(taMonitor);
		spMonitor.setBorder(new EmptyBorder(10, 0, 10, 10));

		pEsquerda.add(pCentro2, BorderLayout.CENTER);
		pEsquerda.add(bDevolver, BorderLayout.SOUTH);

		add(pEsquerda, BorderLayout.WEST);
		add(spMonitor, BorderLayout.CENTER);

		setVisible(true);
		setSize(450, 300);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == bAdd1R) {
			automatoCtrl.adcValorController(1);
			taMonitor.setText("Valor inserido: R$ " + automatoCtrl.getValPilha() + ",00");
			controleBotoes();
		} else if (e.getSource() == bAdd2R) {
			automatoCtrl.adcValorController(2);
			taMonitor.setText("Valor inserido: R$ " + automatoCtrl.getValPilha() + ",00");
			controleBotoes();
		} else if (e.getSource() == bAdd5R) {
			automatoCtrl.adcValorController(5);
			taMonitor.setText("Valor inserido: R$ " + automatoCtrl.getValPilha() + ",00");
			controleBotoes();
		} else if (e.getSource() == bDoceA) {
			comprar("A");
			novaCompra();
		} else if (e.getSource() == bDoceB) {
			comprar("B");
			novaCompra();
		} else if (e.getSource() == bDoceC) {
			comprar("C");
			novaCompra();
		} else if (e.getSource() == bDevolver){
			taMonitor.append("\n\n");
			taMonitor.append("Devolução de R$ " + automatoCtrl.devValorController() + ",00");
			novaCompra();
		}
			
	}

	public void controleBotoes() {
		int opcao = automatoCtrl.ctrlValPilha();

		switch (opcao) {
			case 1 :
				bDevolver.setEnabled(true);
				break;
			case 2 :
				bDevolver.setEnabled(true);
				bDoceA.setEnabled(true);
				break;
			case 3 :
				bDevolver.setEnabled(true);
				bDoceA.setEnabled(true);
				bDoceB.setEnabled(true);
				break;
			case 4 :
				bDevolver.setEnabled(true);
				bDoceA.setEnabled(true);
				bDoceB.setEnabled(true);
				bDoceC.setEnabled(true);
				break;

			default :
				break;
		}
	}

	public void comprar(String doce)
	{		
		int troco = automatoCtrl.rlzCompraController(doce);
		
		taMonitor.append("\n\n");
		taMonitor.append("Doce " + doce + " adquirido.");
		taMonitor.append("\n\n");
		if(troco == 0)
			taMonitor.append("Sem Troco.");
		else
			taMonitor.append("Troco: R$ " + troco + ",00");
	}
	
	public void novaCompra()
	{
		automatoCtrl.devValorController();
		bDevolver.setEnabled(false);
		bDoceA.setEnabled(false);
		bDoceB.setEnabled(false);
		bDoceC.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new AutomatoGUI();
	}

}
