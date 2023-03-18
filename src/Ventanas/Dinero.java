 package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.ConversorMoneda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import java.awt.Scrollbar;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;

public class Dinero extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JComboBox comboBoxMonedas1, comboBoxMonedas2;
	JLabel jlabelSolesText=new JLabel("Soles Peruanos");
	private String[] monedas = {"Soles Peruanos", "Dolares","Euros","Libras Esterlinas","Yen Japones","Won SurCoreano"};
	private Double[] valoresMonedas=new Double[5];
	

	/**
	 * Create the frame.
	 */
	public Dinero(Double[] valoresMonedas) {
		this.valoresMonedas=valoresMonedas;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor de dinero");
		lblNewLabel.setBounds(143, 11, 129, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(51, 117, 100, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("De");
		lblNewLabel_1.setBounds(20, 88, 21, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("a");
		lblNewLabel_1_1.setBounds(203, 88, 21, 14);
		panel.add(lblNewLabel_1_1);
		
		jlabelSolesText.setBounds(163, 120, 109, 14);
		panel.add(jlabelSolesText);

		comboBoxMonedas1 = new JComboBox();
		comboBoxMonedas1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBoxMonedas1.getItemCount()!=0){
					cambiartexto();
				}
			}
		});
		comboBoxMonedas1.setBounds(51, 84, 142, 22);
		comboBoxMonedas1.addItem(monedas[0]);
		comboBoxMonedas1.setSelectedIndex(0);
		panel.add(comboBoxMonedas1);
		
		

		comboBoxMonedas2 = new JComboBox();
		comboBoxMonedas2.setBounds(224, 84, 142, 22);
		for(int i=1;i<monedas.length;i++) {
			comboBoxMonedas2.addItem(monedas[i]);
		}
		comboBoxMonedas2.setSelectedIndex(0);
		panel.add(comboBoxMonedas2);
		

		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertir();
				estadocontinuar();
			}
		});
		btnConvertir.setBounds(224, 160, 89, 23);
		panel.add(btnConvertir);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(51, 160, 89, 23);
		panel.add(btnLimpiar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVentanaMenu();
				dispose();
			}
		});
		btnAtras.setBounds(315, 205, 89, 23);
		panel.add(btnAtras);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				cambiarOpciones();
				jlabelSolesText.setText(comboBoxMonedas1.getSelectedItem().toString());
			}
		});
		btnCambiar.setBounds(163, 54, 89, 23);
		panel.add(btnCambiar);
	}

	public void abrirVentanaMenu() {
		Menu menu = new Menu();
		menu.setVisible(true);
		this.dispose();
	}
	public void cambiarOpciones(){
		if(comboBoxMonedas1.getItemCount()==1){
			int index=comboBoxMonedas2.getSelectedIndex();
			comboBoxMonedas2.removeAllItems();
			comboBoxMonedas2.addItem(monedas[0]);
			comboBoxMonedas1.removeAllItems();
			for(int i=1;i<monedas.length;i++) {
				comboBoxMonedas1.addItem(monedas[i]);
			}
			comboBoxMonedas1.setSelectedIndex(index);
			
		}
		else{
			int index=comboBoxMonedas1.getSelectedIndex();
			comboBoxMonedas1.removeAllItems();
			comboBoxMonedas1.addItem(monedas[0]);
			comboBoxMonedas2.removeAllItems();
			for(int i=1;i<monedas.length;i++) {
				comboBoxMonedas2.addItem(monedas[i]);
			}
			comboBoxMonedas2.setSelectedIndex(index);
		}
	}
	public void cambiartexto(){
		jlabelSolesText.setText(comboBoxMonedas1.getSelectedItem().toString());
	}
	public void limpiar(){
		textField.setText("");
	}

	public boolean verificarDatosIngresados(){
		if(this.textField.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Ingrese un valor");
			textField.requestFocus();
			return false;
		}
		else{
			try{
				Double.parseDouble(this.textField.getText());
				return true;
			}
			catch(Exception e){
				limpiar();
				JOptionPane.showMessageDialog(null, "Ingrese un valor numerico");
				textField.requestFocus();
				return false;
			}
		}
	}

	public void convertir(){
		if(verificarDatosIngresados()){
			double valor=Double.parseDouble(this.textField.getText());
			ConversorMoneda conMon=new ConversorMoneda(valor, comboBoxMonedas1.getSelectedItem().toString(), comboBoxMonedas2.getSelectedItem().toString());
			int modo;
			if(comboBoxMonedas1.getItemCount()==1){
				modo=1;
				conMon.convertir(valoresMonedas[comboBoxMonedas2.getSelectedIndex()],modo);
			}
			else{
				modo=2;
				conMon.convertir(valoresMonedas[comboBoxMonedas1.getSelectedIndex()],modo);
			}
			JOptionPane.showMessageDialog(null, "El valor es: "+conMon.getResultado()+" "+conMon.getNombreDestino());
		}
	}
	public void estadocontinuar(){
		int opcion=JOptionPane.showConfirmDialog(null, "Desea continuar?");
		if(opcion==JOptionPane.YES_OPTION){
			abrirVentanaMenu();
			dispose();
		}
		else{
			JOptionPane.showMessageDialog(null, "Programa finalizado");
			dispose();
		}
	}
}
