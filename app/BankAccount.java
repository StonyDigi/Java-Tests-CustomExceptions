package app;

import customExceptions.BankAccountCustomException;

public class BankAccount {
	
	private String customerName;
    private Double balance;
	
	public BankAccount(String customerName, Double balance) {
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
		return "BankAccount [customerName=" + customerName + ", balance=" + balance + "]";
	}
	
	public void debit(double amount) { //sz�mla terhel�s
		//sz�ls��rt�k vizsg�lata
		//t�l nagy �rt�k vizsg�latakor infinity-vel t�r vissza
		if (amount>Double.MAX_VALUE) {
			//ha saj�t hiba�zeneteket adunk , meg az az�rt, j� mert a v�g�n egy JSON f�jlba kulcs�rt�k p�rokkal ki tudjuk nyerni az elkapott hib�kat
			//pl: m�sik oszt�lyt l�trehozunk(json: 1- t�l nagy az �rt�khat�r miatt, 2 - t�l kicsi, 3 -  t�l nagy a balance miatt , sz�mok alapj�n hardcodeoljuk
			throw new BankAccountCustomException("T�l nagy �sszeget adott meg!!!");
		}
		
		
		if (amount<0) { //ez azt jelenti, hogy negat�v-al akarjuk megterhelni a sz�ml�t
			throw new BankAccountCustomException("Negat�v �rt�kkel nem lehet terhelni!!!");
		}
		
		if (amount>this.balance) {
			throw new BankAccountCustomException("Az egyenleg�n�l nagyobb �sszeget adott meg!!!");
		}
		balance -= amount;
	}
	
	public void credit(double amount) { //sz�mla j�v��r�s
		if (amount>Double.MAX_VALUE) {
			//ha saj�t hiba�zeneteket adunk , meg az az�rt, j� mert a v�g�n egy JSON f�jlba kulcs�rt�k p�rokkal ki tudjuk nyerni az elkapott hib�kat
			//pl: m�sik oszt�lyt l�trehozunk(json: 1- t�l nagy az �rt�khat�r miatt, 2 - t�l kicsi, 3 -  t�l nagy a balance miatt , sz�mok alapj�n hardcodeoljuk
			throw new BankAccountCustomException("T�l nagy �sszeget adott meg!!!");
		}
		
		if (amount<0) { //ez azt jelenti, hogy negat�v-al akarjuk megterhelni a sz�ml�t
			throw new BankAccountCustomException("Negat�v �rt�kkel nem lehet terhelni!!!");
		}
		
		balance += amount;
	}
}