import java.lang.*;
/** 
* De klasse EersteProg is een Java applicatie
*
* @author Sharon Meeus
* @version 1.5 
*/


public class EersteProg
{
	/**
	* Dit is een main-functie, hier start het programme
	* @param args Dit is een array van strings waarmee parameters
	kunnen meegegeven worden vanaf de commandline.
	*/
	public static void main(String args[])
	{
		drukaf();
	}
	/**
	* Deze methode is een conversie van een for- naar een while-lus
	* for (int i=55; i>34; i--)
	*{
	*	System.out.println(i);
	*}
	*/
	private static void drukaf()
	{
		int i=55;
		while(i>34)
		{
			System.out.println(i);
			i--;
		}
	}
}