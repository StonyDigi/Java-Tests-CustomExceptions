package customExceptions;

@SuppressWarnings("serial")
public class BankAccountCustomException extends RuntimeException {  //1. Az osztályunkat leszármaztatjuk az õs Exception(kivételkezelõ) osztállyal ezzel
	//megkapva minden tulajdonságát.
	
	//2. errorMessaget kap meg paraméterként
	public BankAccountCustomException(String errorMessage) {// Amikor lepéldányosítjuk a BankAccountCustomException-t akkor
		super(errorMessage); //3.És ezt az errorMessage-t adjuk az õsnek mint paramétert, RuntimeException õs konstruktorára utal!!
		//és megkap egy errorMessaget ami a BankAccountCustomException osztály konstruktorának a  bemenõ paramétere.
		//4. a super kulcsszó utal a RuntimeException õs-re
	}
}