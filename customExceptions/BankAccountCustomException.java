package customExceptions;

@SuppressWarnings("serial")
public class BankAccountCustomException extends RuntimeException {  //1. Az osztályunkat leszármaztatjuk az ős Exception(kivételkezelő) osztállyal ezzel
	//megkapva minden tulajdonságát.
	
	//2. errorMessaget kap meg paraméterként
	public BankAccountCustomException(String errorMessage) {// Amikor lepéldányosítjuk a BankAccountCustomException-t akkor
		super(errorMessage); //3.És ezt az errorMessage-t adjuk az ősnek mint paramétert, RuntimeException ős konstruktorára utal!!
		//és megkap egy errorMessaget ami a BankAccountCustomException osztály konstruktorának a  bemenő paramétere.
		//4. a super kulcsszó utal a RuntimeException ős-re
	}
}