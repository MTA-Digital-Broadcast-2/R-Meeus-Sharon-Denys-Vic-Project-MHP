import java.lang.*;
/** 
* De klasse EersteProg is een Java applicatie
*
* @author Sharon Meeus
* @version 1.5 
*/


public class Oef7
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
		int[] a = {12, 34, 56, 78, 123, 234, 99, 88};
		int b[] = new int[8];
		int huidiggetal;
		int indexgetal = 0;
		int grootstegetal = 0;
		for(int y= 0; y < 8; y++)
		{
			for(int x = 0; x < 8; x++)
			{
				huidiggetal = a[x];
				if(huidiggetal > grootstegetal)
				{
					grootstegetal = huidiggetal;
					indexgetal = x;
				}
			}
			b[y] = grootstegetal;
			a[indexgetal] = 0;

			indexgetal = 0;
			grootstegetal = 0;
	
		}
		
		
		for(int c = 0; c < 8; c++)
		{
			System.out.println(b[c]);
		}
	}
}