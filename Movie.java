public class Movie {
	
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }
    
    public int getPriceCode() {
        return priceCode;
    }
    
    public void setPriceCode(int arg) {
        priceCode = arg;
    }
    
    public String getTitle() {
        return title;
    }
    
    /*
     * The method charge() has been extracted from Rental.java
     */
    public double charge(int daysRented ) {
		double charge = 0;
		    	
    	switch (getPriceCode()) {
	        case Movie.REGULAR:
	        	charge += 2;
	            if (daysRented > 2)
	            	charge += (daysRented - 2) * 1.5;
	            break;
	        case Movie.NEW_RELEASE:
	        	charge += daysRented * 3;
	            break;
	        case Movie.CHILDRENS:
	        	charge += 1.5;
	            if (daysRented > 3)
	            	charge += (daysRented - 3) * 1.5;
	            break;
	    }
    	
    	return charge;
    }
}