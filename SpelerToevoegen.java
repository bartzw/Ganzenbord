package huiswerk;

public class SpelerToevoegen {
	public int spelerNr;
    public String spelerNaam;
    public int spelerPositie; 
    public boolean spelerOverslaan;
    public boolean spelerPut;
    public boolean spelerGevangenis;
    public int spelerGevangenisNummer;
	    public SpelerToevoegen(int spelerNr, String spelerNaam, int spelerPositie, boolean spelerOverslaan, boolean spelerPut, boolean spelerGevangenis, int spelerGevangenisNummer) {
		// TODO Auto-generated constructor stub
	    	this.spelerNr=spelerNr;
	    	this.spelerNaam = spelerNaam;
	    	this.spelerPositie = spelerPositie;
	    	this.spelerOverslaan = spelerOverslaan;
	    	this.spelerPut = spelerPut;
	    	this.spelerGevangenis = spelerGevangenis;
	    	this.spelerGevangenisNummer = spelerGevangenisNummer;
	    	
	    System.out.println("Welkom Speler " + spelerNr + ", " + spelerNaam + ". je pion staat op vakje: " + spelerPositie);
	    // Add constructor, get, set, as needed.
}
	    public String getNaam() {
	        return spelerNaam;
	    }

	    public void setNaam(String spelerNaam) {
	        this.spelerNaam = spelerNaam;
	    }

	    public int getNummer() {
	        return spelerNr;
	    }

	    public void setNummer(int spelerNr) {
	        this.spelerNr = spelerNr;
	    }
	    public int getPositie() {
	        return spelerPositie;
	    }
	    public int updatePositie() {
	    	int dobbelSteen = dobbelsteen();
	    	System.out.println("Je hebt " +dobbelSteen+ " gegooid.");
	    	spelerPositie = spelerPositie+dobbelSteen;
	    	if (spelerPositie == 6) { 
	    	spelerPositie = 12;	
	    	System.out.println("Je bent op de brug beland, je gaat door naar vakje 12! :)");
	    	}
	    	if (spelerPositie == 19) { 
	    	System.out.println("Je bent op de herberg beland, sla een beurt over! :(");
	    	setOverslaan();
	    	}
	    	//if (spelerPositie == 31) { 
	    	//System.out.println("Ganzenbord is net als het echte leven, je zit in de put. :(");
	    	//setPut();
	     	//}
	    	if (spelerPositie == 42) { 
		    	spelerPositie = 39;	
	    	System.out.println("Je bent in het doolhof beland, ga drie vakjes achteruit. :(");
	    	}
	    	if (spelerPositie == 52) { 
	    	System.out.println("Je bent in de gevangenis beland, sla drie beurten over. :(");
	    	setGevangenis();
	    	setGevangenisNummer();
	    	}
	    	if (spelerPositie == 58) { 
		    	spelerPositie = 0;	
	    	System.out.println("Je bent euhm... DOOD! je begint weer vanaf start. :(");
	    	}
	    	if (spelerPositie > 63) { 
	    	int sumSpelerpositie = spelerPositie - 63;
	    	spelerPositie = 63 - sumSpelerpositie;
	    	System.out.println("Potjandorie, je hebt teveel gegooid, je gaat een paar vakjes terug..");
	    	}
	        return spelerPositie;
	    }
	    public void setPositie(int spelerPositie) {
	        this.spelerPositie = spelerPositie;
	    }
	    public boolean getOverslaan() {
	        return spelerOverslaan;
	    }
	    public boolean exitOverslaan() {
	    	spelerOverslaan = false;
	        return spelerOverslaan;
	    }
	    public boolean setOverslaan() {
	    	spelerOverslaan = true;
	        return spelerOverslaan;
	    }
	    public boolean getPut() {
	        return spelerPut;
	    }
	    public boolean exitPut() {
	    	spelerPut = false;
	        return spelerPut;
	    }
	    public boolean setPut() {
	    	spelerPut = true;
	        return spelerPut;
	    }
	    public boolean getGevangenis() {
	        return spelerGevangenis;
	    }
	    public boolean exitGevangenis() {
	    	spelerGevangenis = false;
	        return spelerGevangenis;
	    }
	    public boolean setGevangenis() {
	    	spelerGevangenis = true;
	        return spelerGevangenis;
	    }
   	    public int getGevangenisNummer() {
        return spelerGevangenisNummer;
        }
        public int setGevangenisNummer() {
    	spelerGevangenisNummer = spelerGevangenisNummer+2;
        return spelerGevangenisNummer;
        }
        public int minGevangenisNummer() {
    	spelerGevangenisNummer = spelerGevangenisNummer-1;
        return spelerGevangenisNummer;
    }
		public int dobbelsteen(){
			int dobbelSteen=(int)(Math.random()*6+1);
			return dobbelSteen;
			}
	}

	    