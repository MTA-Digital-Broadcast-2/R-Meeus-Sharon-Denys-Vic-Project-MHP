import java.lang.*;
/** 
* De klasse EersteProg is een Java applicatie
*
* @author Sharon Meeus
* @version 1.5 
*/


public class Oef1
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
	* Deze methode toont de negen tafels van vermenigvuldiging
	*/
	private static void drukaf()
	{
		int a;
		int oplossing;
		for(a=1; a<10; a++)
		{
			int b;
			for(b=1; b<10; b++)
			{
				oplossing = a*b;
				System.out.println(a + " x " + b + " = " + oplossing);
			}	
		}
	}
}