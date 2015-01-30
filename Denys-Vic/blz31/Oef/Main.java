import java.lang.*;

public class Main{

	public static void main(String args[])
	{
	
		// OEF 1
		
		Werknemer dirk = new Werknemer("Dirk","Dik",1,1000);
		Werknemer jan = new Werknemer("Jan","Dikker",2,4000);
		Werknemer wim = new Werknemer("Wim","Rijk",3,10000);
		Werknemer boris = new Werknemer("Boris","Dik",4,20000);
		
		//0EF 2

		dirk.salarisVerhogen(10);
		jan.salarisVerhogen(10);
		
		//System.out.println(dirk.voornaam + " verdient " + dirk.getSalaris() + "€." );
		//System.out.println(jan.voornaam + " verdient " + jan.getSalaris() + "€." );
		//System.out.println(wim.voornaam + " verdient " + wim.getSalaris() + "€." );
		//System.out.println(boris.voornaam + " verdient " + boris.getSalaris() + "€." );
		
		//0EF 3
		
		PartTimeWerknemer kim = new PartTimeWerknemer("kim","Jong",3, 20,1);
		PartTimeWerknemer mao = new PartTimeWerknemer("Mao","Tong",3, 100,4);
		
		//OEF 4
		
		//kim.salarisVerhogen(10);
		//System.out.println(kim.voornaam + " verdient " + kim.getSalaris() + "€." );
		
		//OEF 6
		
		dirk.setRSZ(0.35F);
		
		//System.out.println(dirk.voornaam + " betaalt " + dirk.getRSZ() + "% RSZ.");
		//System.out.println(kim.voornaam + " betaalt " + kim.getRSZ() + "% RSZ.");
		
		//OEF 7
		
		StudentWerknemer lee = new StudentWerknemer("Lee","To", 4, 600, 8);
		
		//System.out.println(lee.voornaam + " betaalt " + lee.getRSZ() + "% RSZ.");
		
		//OEF 9
		
		//dirk.betaal();
		//kim.betaal();
		//lee.betaal();
		
		
		//OEF 10
		
		Faktuur fak = new Faktuur(1, 1000);
		fak.betaal();
		
	}

}









