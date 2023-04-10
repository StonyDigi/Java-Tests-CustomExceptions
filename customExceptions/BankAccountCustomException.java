package customExceptions;

@SuppressWarnings("serial")
public class BankAccountCustomException extends RuntimeException {  //1. Az oszt�lyunkat lesz�rmaztatjuk az �s Exception(kiv�telkezel�) oszt�llyal ezzel
	//megkapva minden tulajdons�g�t.
	
	//2. errorMessaget kap meg param�terk�nt
	public BankAccountCustomException(String errorMessage) {// Amikor lep�ld�nyos�tjuk a BankAccountCustomException-t akkor
		super(errorMessage); //3.�s ezt az errorMessage-t adjuk az �snek mint param�tert, RuntimeException �s konstruktor�ra utal!!
		//�s megkap egy errorMessaget ami a BankAccountCustomException oszt�ly konstruktor�nak a  bemen� param�tere.
		//4. a super kulcssz� utal a RuntimeException �s-re
	}
}