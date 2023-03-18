package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Apis.ApiMoneda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
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
		
		JLabel tituloPrincipal = new JLabel("Conversores");
		tituloPrincipal.setBounds(171, 11, 84, 14);
		panel.add(tituloPrincipal);
		
		JButton btnDinero = new JButton("Dinero");
		btnDinero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirVentanaDinero();
			}
		});
		btnDinero.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\conversorDinero.jpg"));
		btnDinero.setBounds(40, 50, 152, 70);
		panel.add(btnDinero);
		
		JButton btnTemperatura = new JButton("Temperatura");
		btnTemperatura.setBounds(229, 50, 152, 70);
		panel.add(btnTemperatura);
		
		JButton btnOtro1 = new JButton("Otro1");
		btnOtro1.setBounds(40, 145, 152, 70);
		panel.add(btnOtro1);
		
		JButton btnOtro2 = new JButton("Otro2");
		btnOtro2.setBounds(229, 145, 152, 70);
		panel.add(btnOtro2);
	}

	public void AbrirVentanaDinero() {
		try {
			ApiMoneda apiMoneda = new ApiMoneda();
			Double valores[] = new Double[5];
			valores = apiMoneda.getCambio();

			Dinero ventanaDinero = new Dinero(valores);
			ventanaDinero.setVisible(true);

			this.dispose();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al abrir, intentelo de nuevo");
			e.printStackTrace();
			System.out.println("Error de la obtencion de datos de la API ");
		}
	}
}
