import java.util.*;

public class Customer {
	
    private String name;
    private List rentals = new ArrayList();

    public Customer(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void addRental(Rental arg) {
        rentals.add(arg);
    }
    
    /*
     * The frequentRenterPoints() method has been extracted locally first
     */
    public int frequentRenterPoints(int frequentRenterPoints, Rental rental) {
    	frequentRenterPoints++;
    	
    	// add bonus for a two day new release rental
        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
        		rental.getDaysRented() > 1) frequentRenterPoints++;
        
    	return frequentRenterPoints;
    }
    
    public String statement() {
        double totalCharge = 0;
        int frequentRenterPoints = 0;
        Iterator rentalIterator = rentals.iterator();
        String result = "Rentals: " + getName() + "\n";
        while (rentalIterator.hasNext()) {
            double charge = 0;
            Rental rental = (Rental) rentalIterator.next();

            //determine rental charge for each movie by calling the charge() method from Rental
            charge = rental.charge();  
            
            //determine the frequent renter points
            frequentRenterPoints = frequentRenterPoints(frequentRenterPoints, rental);

            //show figures for this rental
            result += rental.getDaysRented() +
                " days of '" + rental.getMovie().getTitle() +
                "' $" + String.valueOf(charge) + "\n";
            totalCharge += charge;
        }
        //add footer lines
        result += "Total = $" + totalCharge + "\n";
        result += "Frequent renter points = " + frequentRenterPoints + "\n";
        return result + "---\n";
    }

}