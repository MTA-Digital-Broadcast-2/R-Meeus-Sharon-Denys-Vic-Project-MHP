public class Faktuur implements Betaalbaar{
	
	private int faktuurNr;
	private int faktuurBedrag;
	
	public Faktuur(int nr, int bedrag){
		faktuurNr = nr;
		faktuurBedrag = bedrag;
	}
	
	public void betaal(){
		System.out.println("Betaal het faktuur " + this.faktuurNr + " voor een bedrag van " + this.faktuurBedrag + ".");
	}
	
}