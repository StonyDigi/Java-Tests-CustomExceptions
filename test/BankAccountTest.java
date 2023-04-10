package test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import app.BankAccount;

public class BankAccountTest {
	//akkor sikeresek a tesztek, ha a megadott felt�telre azt a hib�t dobja ami az elv�rt, ha hib�t dobnak ezek a tesztek!!! �s tov�bb fut a program
	//nem �ll le, hanem csak t�j�koztat!!!! nagyon fontos
	
	@Test
	public void testDebit() {//debit met�dust teszteli, mindig a test sz� ut�n �rjuk a val�di met�dusnevet, //itt emeli le a sz�ml�r�l
		BankAccount baObj = new BankAccount("Teszt Elek", 200.0);
		baObj.debit(20.0); // 20-al terhelj�k meg a sz�ml�t, 200.0 - 20.0 = 180.0 az elv�rt
		Double actual = baObj.getBalance();
		Double expected = 180.0;
		Assert.assertEquals(expected, actual);//assert import org.junit
	    // itt vizsg�lja meg az aktual �s az elv�rt k�z�tti k�l�nbs�get
	}
	
	@Test
	public void testCredit() {//itt �rja j�v� a sz�ml�t
		BankAccount baObj = new BankAccount("Teszt Elek", 100.0);
		baObj.credit(10.0);
		Double actual = baObj.getBalance();
		Double expected = 110.0;
		Assert.assertEquals(expected, actual);		
	}
	
	@Test
	public void testDebitAmountOverBalanceCreateException() {
		BankAccount baObj = new BankAccount("Jane Doe", 100.0);
		Exception exception = assertThrows(RuntimeException.class, ()->baObj.debit(250.0));//hib�t kell dobnia, mert a 100-as �rt�kre 250-et h�vunk meg
		String expectedMessage = "Az egyenleg�n�l nagyobb �sszeget adott meg!!!"; //itt kapjuk el az �gat
		String actualMessage = exception.getMessage();//ez a BankAccounton bel�li hiba�zenet lek�rdez�se
		assertTrue(actualMessage.contains(expectedMessage));//itt hasonl�tja �ssze, hogy tartalmazza-e az actual-ban az elv�rt hiba�zenetet
	}
	
	@Test
	public void testDebitAmountOverflowCreateException() { //azt v�rjuk, hogy j� nagy �sszeget adunk meg a double-n�l �s hib�t dob!
		BankAccount baObj = new BankAccount("Jane Doe", 100.0);
		Exception exception = assertThrows(
				RuntimeException.class, ()->baObj.debit(Double.MAX_VALUE*110));
		String expectedMessage = "T�l nagy �sszeget adott meg!!!"; //ha a hiba�zenet nem egyezik meg a POJO-n bel�livel akkor nem j� a teszt
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));	
	}
	
	@Test
	public void testDebitAmountIsNegativeCreateException() { //debit negat�v tesztel�s 
		BankAccount baObj = new BankAccount("Jane Doe", 100.0);
		Exception exception = assertThrows(RuntimeException.class, ()->baObj.debit(-10));
		String expectedMessage = "Negat�v �rt�kkel nem lehet terhelni!!!";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testCreditAmountIsNegativeCreateException() { //credit negat�v tesztel�s
		BankAccount baObj = new BankAccount("Jane Doe", 100.0);
		Exception exception = assertThrows(RuntimeException.class, ()->baObj.credit(-10.0));
		String expectedMessage = "Negat�v �rt�kkel nem lehet terhelni!!!";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));	
	}
	
	@Test
	public void testCreditAmountOverflowCreateException() { //azt v�rjuk, hogy j� nagy �sszeget adunk meg a double-n�l �s hib�t dob!
		BankAccount baObj = new BankAccount("Jane Doe", 100.0);
		Exception exception = assertThrows(
				RuntimeException.class, ()->baObj.credit(Double.MAX_VALUE*110));
		String expectedMessage = "T�l nagy �sszeget adott meg!!!"; //ha a hiba�zenet nem egyezik meg a POJO-n bel�livel akkor nem j� a teszt
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));	
	}
	//Feladat tesztel�s:
	//Debit negt�v sz�mmal
	//Credit-re is tesztel�s
}