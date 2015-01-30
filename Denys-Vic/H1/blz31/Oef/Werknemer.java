public class Werknemer implements Betaalbaar { 
	public String voornaam; 
	public String achternaam;
	public int werknemerNummer; 
	protected float salaris ;
	protected float RSZpercentage;

	public Werknemer(String voornaam, String achternaam, int wNummer, float salaris ){
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		werknemerNummer = wNummer;
		this.salaris = salaris ;
		RSZpercentage = 0.33F;
	}

	public void salarisVerhogen(int percentage){
		float verhogingsfactor=(float)percentage/100;
		salaris += salaris* verhogingsfactor ; 
	}
	
	public void setRSZ(float rsz){
		RSZpercentage = rsz;
	}
	
	public float getRSZ(){
		return RSZpercentage;
	}
	
	public float getSalaris ( ) {
		return salaris ; 
	}
	
	public void betaal(){
		System.out.println("Betaal " + this.getSalaris ( ) + " aan de werknemer " + this.voornaam + " " + this.achternaam + ".");
	}

}