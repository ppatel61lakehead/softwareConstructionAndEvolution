public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
    
    /*
     *  The method chargeForRental has been moved from Customer.java class to here and is renamed to charge().
     *  Also, the references to the functions are changed as all the functions are of Rental.java class.
     */
    public double charge() {
    	double charge = 0;
    	
    	switch (getMovie().getPriceCode()) {
	        case Movie.REGULAR:
	        	charge += 2;
	            if (getDaysRented() > 2)
	            	charge += (getDaysRented() - 2) * 1.5;
	            break;
	        case Movie.NEW_RELEASE:
	        	charge += getDaysRented() * 3;
	            break;
	        case Movie.CHILDRENS:
	        	charge += 1.5;
	            if (getDaysRented() > 3)
	            	charge += (getDaysRented() - 3) * 1.5;
	            break;
	    }
    	
    	return charge;
    }
}