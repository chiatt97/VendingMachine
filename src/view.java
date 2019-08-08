import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
/**@author Chandler Hiatt
 * @version last updated 2-19-17
 * @class view - create JFrame and houses most of onclick events.
 */
public class view extends JFrame {

	private JPanel contentPane;
	private JTextField txtPassword;
	private JLabel lblChangeDue;
	private JLabel lblChangeSubmitted;
	private double moneySubmitted, totalMoney;
	private double moneyDue;
	private JLabel lblCoke, lblPepsi, lblDietCoke, lblDietPepsi, lblMonster, lblMoney;
	private String drink;
	private int cokeCount, pepsiCount, dCokeCount, dPepsiCount, monsterCount;
	private JTextField txtAmount;
	private JButton btnWithdraw;

	/**
	 * Create the frame.
	 */
	public view() {
		bank bank = new bank(this);
		
		moneySubmitted = 0;
		moneyDue = 0;
		cokeCount = 10;
		pepsiCount = 10;
		dCokeCount = 10;
		dPepsiCount = 10;
		monsterCount = 10;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton btnCoke = new JButton("Coke");
		btnCoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChangeDue.setText("Change Due: $1.00");
				moneyDue = 1.0;
				drink = "Coke";
				bank.drinkCost(1.0);
			}
		});
		panel.add(btnCoke);
		
		JButton btnPepsi = new JButton("Pepsi");
		btnPepsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChangeDue.setText("Change Due: $1.10");
				moneyDue = 1.1;
				drink = "Pepsi";
				bank.drinkCost(1.1);
			}
		});
		panel.add(btnPepsi);
		
		JButton btnDietCoke = new JButton("Diet Coke");
		btnDietCoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChangeDue.setText("Change Due: $1.20");
				moneyDue = 1.2;
				drink = "Diet Coke";
				bank.drinkCost(1.2);
			}
		});
		panel.add(btnDietCoke);
		
		JButton btnDietPepsi = new JButton("Diet Pepsi");
		btnDietPepsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChangeDue.setText("Change Due: $1.30");
				moneyDue = 1.3;
				drink = "Diet Pepsi";
				bank.drinkCost(1.3);
			}
		});
		panel.add(btnDietPepsi);
		
		JButton btnMonster = new JButton("Monster");
		btnMonster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChangeDue.setText("Change Due: $2.00");
				moneyDue = 2;
				drink = "Monster";
				bank.drinkCost(2.0);
			}
		});
		panel.add(btnMonster);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_7 = new JPanel();
		panel_7.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_1.add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		JButton button = new JButton("1¢");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bank.addMoney(0.01);
				moneySubmitted += 0.01;
				totalMoney += 0.01;
				lblChangeSubmitted.setText("Change Submitted: $" + (moneySubmitted));
			}
		});
		panel_6.add(button);
		
		JButton btnNewButton = new JButton("5¢");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bank.addMoney(0.05);
				moneySubmitted += 0.05;
				totalMoney += 0.05;
				lblChangeSubmitted.setText("Change Submitted: $" + (moneySubmitted));
			}
		});
		panel_6.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("10¢");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bank.addMoney(0.1);
				moneySubmitted += 0.1;
				totalMoney += 0.1;
				lblChangeSubmitted.setText("Change Submitted: $" + (moneySubmitted));
			}
		});
		panel_6.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("25¢");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bank.addMoney(0.25);
				totalMoney += 0.25;
				moneySubmitted += 0.25;
				lblChangeSubmitted.setText("Change Submitted: $" + (moneySubmitted));
			}
		});
		panel_6.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Submit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bank.calculate();
				bank.setChoiceCost(0);
				bank.setMoneySub(0);
				lblChangeSubmitted.setText("Change Submitted: $" + 0.00);
				lblChangeDue.setText("Change Submitted: $" + 0.00);
				moneySubmitted = 0;
				updateBank();
			}
		});
		panel_6.add(btnNewButton_3);
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);
		
		lblChangeDue = new JLabel("Change Due: $0.00");
		panel_8.add(lblChangeDue);
		
		lblChangeSubmitted = new JLabel("Change Submitted: $0.00");
		panel_8.add(lblChangeSubmitted);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("    ");
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_10 = new JPanel();
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		
		panel_3.add(panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.Y_AXIS));
		
		JButton btnRefillCoke = new JButton("Refill Coke");
		btnRefillCoke.setVisible(false);
		btnRefillCoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cokeCount += 1;
				lblCoke.setText("Coke: " + cokeCount);
				lblCoke.repaint();
			}
		});
		panel_10.add(btnRefillCoke);
		
		JButton btnNewButton_4 = new JButton("Refill Pepsi");
		btnNewButton_4.setVisible(false);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pepsiCount += 1;
				lblPepsi.setText("Pepsi: " + pepsiCount);
				lblPepsi.repaint();
			}
		});
		panel_10.add(btnNewButton_4);
		
		JButton btnRefillDietCoke = new JButton("Refill Diet Coke");
		btnRefillDietCoke.setVisible(false);
		btnRefillDietCoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dCokeCount += 1;
				lblDietCoke.setText("Diet Coke: " + dCokeCount);
				lblDietCoke.repaint();
			}
		});
		panel_3.add(btnRefillDietCoke);
		
		JButton btnRefillDietPepsi = new JButton("Refill Diet Pepsi");
		btnRefillDietPepsi.setVisible(false);
		btnRefillDietPepsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dPepsiCount += 1;
				lblDietPepsi.setText("Diet Pepsi: " + dPepsiCount);
				lblDietPepsi.repaint();
			}
		});
		panel_3.add(btnRefillDietPepsi);
		
		JButton btnRefillMonster = new JButton("Refill Monster");
		btnRefillMonster.setVisible(false);
		btnRefillMonster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monsterCount += 1;
				lblMonster.setText("Monster: " + monsterCount);
				lblMonster.repaint();
			}
		});
		panel_3.add(btnRefillMonster);
		
		
		JButton btnOperator = new JButton("Operator");
		btnOperator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtPassword.getText().equals("password")){
					lblPepsi.setVisible(true);
					lblDietPepsi.setVisible(true);
					lblCoke.setVisible(true);
					lblDietCoke.setVisible(true);
					lblMonster.setVisible(true);
					lblMoney.setVisible(true);
					btnWithdraw.setVisible(true);
					txtAmount.setVisible(true);
					
					btnRefillCoke.setVisible(true);
					btnNewButton_4.setVisible(true);
					btnNewButton_4.setVisible(true);
					btnRefillDietPepsi.setVisible(true);
					btnRefillDietCoke.setVisible(true);
					btnRefillMonster.setVisible(true);
					
					
					System.out.println(txtPassword.getText());
					
				}
			}
		});
		panel_4.add(btnOperator);
		
		JLabel lblNewLabel = new JLabel("");
		panel_4.add(lblNewLabel);
		
		
		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9);
		
		txtPassword = new JTextField();
		panel_9.add(txtPassword);
		txtPassword.setText("Password...");
		txtPassword.setColumns(8);
		
		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalMoney -= Double.parseDouble(txtAmount.getText());
				lblMoney.setText("Money: " + totalMoney);
			}
		});
		btnWithdraw.setVisible(false);
		panel_9.add(btnWithdraw);
		
		txtAmount = new JTextField();
		txtAmount.setText("Amount");
		txtAmount.setVisible(false);
		panel_9.add(txtAmount);
		txtAmount.setColumns(10);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_2.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		lblCoke = new JLabel("Coke: " + cokeCount);
		lblCoke.setVisible(false);
		panel_5.add(lblCoke);
		
		lblPepsi = new JLabel("Pepsi: " + pepsiCount);
		lblPepsi.setVisible(false);
		panel_5.add(lblPepsi);
		
		lblDietCoke = new JLabel("Diet Coke: " + dCokeCount);
		lblDietCoke.setVisible(false);
		panel_5.add(lblDietCoke);
		
		lblDietPepsi = new JLabel("Diet Pepsi: " + dPepsiCount);
		lblDietPepsi.setVisible(false);
		panel_5.add(lblDietPepsi);
		
		lblMonster = new JLabel("Monster: " + monsterCount);
		lblMonster.setVisible(false);
		panel_5.add(lblMonster);
		
		lblMoney = new JLabel("Money: " + bank.getMoneyTotal());
		lblMoney.setVisible(false);
		panel_5.add(lblMoney);
	}
	
	public void updateBank(){
		if(moneyDue == 1){
			cokeCount -= 1;
			lblCoke.setText("Coke: " + cokeCount);
			lblCoke.repaint();
		}
		if(moneyDue == 1.1){
			pepsiCount -= 1;
			lblPepsi.setText("Pepsi: " + pepsiCount);
			lblPepsi.repaint();
		}
		if(moneyDue == 1.3){
			dPepsiCount -= 1;
			lblDietPepsi.setText("Diet Pepsi: " + dPepsiCount);
			lblDietPepsi.repaint();
		}
		if(moneyDue == 1.2){
			dCokeCount -= 1;
			lblDietCoke.setText("Diet Coke: " + dCokeCount);
			lblDietCoke.repaint();
		}
		if(moneyDue == 2){
			monsterCount -= 1;
			lblMonster.setText("Monster: " + monsterCount);
			lblMonster.repaint();
		}
		lblMoney.setText("Money: " + totalMoney);
		lblMoney.repaint();
	}
	
	public void addMoney(double money){
		this.moneySubmitted = this.moneySubmitted + money;
	}

	public String getDrink(){
		return this.drink;
	}
}
