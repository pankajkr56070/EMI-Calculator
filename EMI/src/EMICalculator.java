import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EMICalculator {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public double pow(double x,int y){
		double res=1;
		while( y > 0){
			
			if((y % 2) == 1)
				res=res*x;
			y=y/2;
			x=x*x;
		}
		
		return res;
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EMICalculator window = new EMICalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EMICalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 585, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(342, 44, 140, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel AmtLabel = new JLabel("Amount");
		AmtLabel.setBounds(104, 50, 122, 14);
		frame.getContentPane().add(AmtLabel);
		
		JLabel RateLabel = new JLabel("Rate ( in % p.a.)");
		RateLabel.setBounds(104, 96, 97, 20);
		frame.getContentPane().add(RateLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(342, 96, 140, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel MonthLabel = new JLabel("No of Month");
		MonthLabel.setBounds(104, 147, 97, 25);
		frame.getContentPane().add(MonthLabel);
		
		JLabel label = new JLabel("\u20B9");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(324, 50, 17, 14);
		frame.getContentPane().add(label);
		
		textField_2 = new JTextField();
		textField_2.setBounds(342, 149, 140, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel ansLabel = new JLabel("");
		ansLabel.setEnabled(false);
		ansLabel.setBounds(284, 276, 140, 24);
		frame.getContentPane().add(ansLabel);
		
		JButton EMIButton = new JButton("CALCULATE EMI");
		EMIButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double amount,rate,ans,power=0;
				int month;
				try{
					amount = Long.parseLong(textField.getText());
		            rate = Long.parseLong(textField_1.getText());
		            rate/=1200;
		            month = Integer.parseInt(textField_2.getText());
		            power= pow(1+rate,month);
		            ans=(amount*rate*power)/(power-1);
		            ansLabel.setText(Double.toString(ans));
		            
				}
				catch(Exception e){
				JOptionPane.showMessageDialog(null,"Please enter valid number");	
				}
				
			}
		});
		EMIButton.setBackground(Color.RED);
		EMIButton.setBounds(205, 209, 143, 23);
		frame.getContentPane().add(EMIButton);
		
		JLabel lblNewLabel = new JLabel("YOUR EMI IS :");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(104, 276, 132, 30);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("\u20B9");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(263, 283, 17, 14);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
