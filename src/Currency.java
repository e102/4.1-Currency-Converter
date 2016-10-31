
public class Currency {
	
	private String name;
	private double exchangeRate;	//Dollars per unit of currency. 5 = 1 unit will buy 5 dollars
	
	public Currency(String n, double d){
		this.name = n;
		this.exchangeRate = d;
	}
	
	public void setName(String s){
		this.name = s;
	}
	
	public void setRate(float r){
		this.exchangeRate = r;
	}
	
	public String getName(String s){
		return(this.name);
	}
	
	public double getRate(){
		return(this.exchangeRate);
	}
	
	public String toString(){
		return this.name;
	}

}
