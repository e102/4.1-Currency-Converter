import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.beans.PropertyChangeEvent;

public class ConverterWindow extends JFrame {
	private Currency selectedCurrency;
	private double amount;
	
	private double result;
	
	
	private JTextField txtHowMuchDo;
	private final Action action = new SwingAction();

	/**
	 * Create the frame.
	 */
	public ConverterWindow(Currency[] z) {
		setBounds(100, 100, 470, 303);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox(z);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedCurrency = (Currency) comboBox.getSelectedItem();
			}
		});

		comboBox.setBounds(10, 93, 239, 74);
		getContentPane().add(comboBox);
		
		txtHowMuchDo = new JTextField();
		txtHowMuchDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount = Double.parseDouble(txtHowMuchDo.getText());
			}
		});
		txtHowMuchDo.setBounds(310, 93, 129, 74);
		txtHowMuchDo.setHorizontalAlignment(SwingConstants.CENTER);
		txtHowMuchDo.setBackground(Color.WHITE);
		getContentPane().add(txtHowMuchDo);
		txtHowMuchDo.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setAction(action);
		btnCalculate.setBounds(10, 192, 429, 58);
		getContentPane().add(btnCalculate);
		
		JLabel lblHowMuchDo = new JLabel("How much do you have?");
		lblHowMuchDo.setBounds(310, 50, 144, 20);
		getContentPane().add(lblHowMuchDo);
		
		JLabel lblConvertsASelect = new JLabel("Converts a select currency into USD");
		lblConvertsASelect.setBounds(138, 11, 173, 14);
		getContentPane().add(lblConvertsASelect);
		
		JLabel lblWhichCurrencyDo = new JLabel("Which Currency do you want to convert?");
		lblWhichCurrencyDo.setBounds(10, 76, 239, 14);
		getContentPane().add(lblWhichCurrencyDo);
		
		JLabel lblPressEnterWhen = new JLabel("Press enter when done");
		lblPressEnterWhen.setBounds(310, 76, 154, 14);
		getContentPane().add(lblPressEnterWhen);

	}
	

	
	private class SwingAction extends AbstractAction {		
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			result = amount * selectedCurrency.getRate();
			System.out.println(result);
			
			try{
				File dest = new File("CurrencyResults.tex");
				if(!dest.exists()){
					throw new FileNotFoundException();
				}
				PrintWriter output = new PrintWriter(new FileWriter("CurrencyResults.txt", true));
				output.println(amount + " " + selectedCurrency.getName() + " is equal to " + result + "USD");
				output.close();
				}
				catch(FileNotFoundException z){
					System.out.println("Error!!! No file found.");
					System.exit(0);
				}
				catch(IOException z){
					System.out.println("Error!!! IO error");
					System.exit(0);
				}
			
		}
	}

}
