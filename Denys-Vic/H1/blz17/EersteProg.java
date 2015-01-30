import java.lang.*;

/**
* De klasse EersteProg is een Java applicatie
*
* @autthor Vic Denys
*
* @version 1.5
*/

public class EersteProg {

	/**
	* Dit is een main-functie. hier start het programma
	* @param args Dit is een array van string waarmee parameters kunnen meegegeven worden.
	*/

	public static void main(String args[])
	{
		drukAf();
	}
	
	/**
	* Dit is de drukAf-functie.
	* met ~ wordt het getal (in 2's complement notatie) bitgewijs geinverteerd. 
	*/

	private static void drukAf()
	{
		System.out.println(~20);
	}
}	