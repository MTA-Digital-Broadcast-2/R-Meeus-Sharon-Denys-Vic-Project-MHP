import java.lang.*;

/**
* De klasse EersteProg is een Java applicatie
*
* @autthor Vic Denys
*
* @version 1.5
*/

public class Oef4 {

	/**
	* Dit is een main-functie. hier start het programma
	* @param args Dit is een array van string waarmee parameters kunnen meegegeven worden.
	*/

	public static void main(String args[])
	{
		drukAf();
	}
	
	/**
	* Negatief van 4302
	*/

	private static void drukAf()
	{
		int a = 4302;
		int uitkomst = ~a + 1;
		System.out.println(uitkomst);
	}
}	