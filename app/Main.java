package app;

public class Main {

	private String customerName;
	private Double balance;
	
    public Main(String customerName, Double balance) {
		
		this.customerName = customerName;
		this.balance = balance;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Main [customerName=" + customerName + ", balance=" + balance + "]";
	}
	
	public void debit(double amount) {//számla terhelés
		balance-=amount;
	}
	
	public void credit(double amount) {
		balance-=amount;
	}
}