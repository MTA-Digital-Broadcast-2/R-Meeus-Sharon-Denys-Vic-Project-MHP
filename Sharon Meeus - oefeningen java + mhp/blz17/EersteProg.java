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
	* Deze code inverteert de bitcode van het ingevoerde cijfer (not)
	* Dit geeft dan -11.
	* Om -10 te krijgen moet je er nog een bij optellen
	* zo werkt het 2's complement
	*/
	private static void drukaf()
	{
		System.out.println(~10);
	}
}