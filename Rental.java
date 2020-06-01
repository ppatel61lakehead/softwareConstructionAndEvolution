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
    
    public double charge() {
    	return movie.charge(daysRented);
    }
    
    public int frequentRenterPoints(int frequentRenterPoints) {
    	frequentRenterPoints++;
    	
    	// add bonus for a two day new release rental
        if ((movie.isNewRelease() == true) && daysRented > 1)
        	frequentRenterPoints++;
        
    	return frequentRenterPoints;
    }
    
    public String rentalLine() {
    	String rentalLine;
    	
    	rentalLine = daysRented + " days of '" + movie.getTitle() + "' $" + charge() + "\n";
    			
    	return rentalLine;
    }
}