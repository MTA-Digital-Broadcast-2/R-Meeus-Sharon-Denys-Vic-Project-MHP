import java.lang.*;
/** 
* De klasse EersteProg is een Java applicatie
*
* @author Sharon Meeus
* @version 1.5 
*/


public class Oef3
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
		int noemer=1;
		double som = 0;
		for(int x=0; x <5000; x++)
		{
			som+=(1.0/noemer);
			noemer+=4;		
		}
		noemer = 3;
		for(int a=0; a<5000; a++)
		{
			som-=(1.0/noemer);
			noemer+=4;	
		}
		som*=4;
		System.out.println("PI = " + som);
		
	}
}