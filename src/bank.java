import javax.swing.JOptionPane;
/**@author Chandler Hiatt
 * @version last updated 2-19-17
 * @class Bank - Holds data for the program.
 */
public class bank {
	private view frame;
	private double money;
	private double choiceCost;
	private double extra;
	private double total;
	
	public bank(view frame){
		this.frame = frame;
		this.money = 0.0;
		this.total = 0.0;
	}
	public double getMoneyTotal(){
		return this.money;
	}
	public void addMoney(double money){
		this.money = this.money + money;
		this.total += money;
	}
	public void drinkCost(double cost){
		this.choiceCost = cost;
	}
	public void calculate(){
		System.out.println(this.money);
		System.out.println(this.choiceCost);
		if(this.money < this.choiceCost){
			JOptionPane.showMessageDialog(frame, "You did not enter sufficient funds.");
		}
		if(this.money > this.choiceCost){
			extra = this.money % choiceCost;
			JOptionPane.showMessageDialog(frame, "Output: " + frame.getDrink() + "and $" + extra);
		}
		if(this.money == this.choiceCost){
			JOptionPane.showMessageDialog(frame, "Output: " + frame.getDrink());
		}
	}
	public void setMoneySub(int money){
		this.money = money;
		
	}
	public void setChoiceCost(int money){
		this.choiceCost = money;
	}
	public double getTotal(){
		return this.total;
	}
}
