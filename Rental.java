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
     *  The method charge has been extracted from Rental.java class to Movie.java.
     */
    public double charge() {
    	return movie.charge(daysRented);
    }
}