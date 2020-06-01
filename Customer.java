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
    
    private double chargeForRental(Rental rental) {
    	double charge = 0;
    	
    	switch (rental.getMovie().getPriceCode()) {
	        case Movie.REGULAR:
	        	charge += 2;
	            if (rental.getDaysRented() > 2)
	            	charge += (rental.getDaysRented() - 2) * 1.5;
	            break;
	        case Movie.NEW_RELEASE:
	        	charge += rental.getDaysRented() * 3;
	            break;
	        case Movie.CHILDRENS:
	        	charge += 1.5;
	            if (rental.getDaysRented() > 3)
	            	charge += (rental.getDaysRented() - 3) * 1.5;
	            break;
	    }
    	
    	return charge;
    }
    
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator rentalIterator = rentals.iterator();
        String result = "Rentals: " + getName() + "\n";
        while (rentalIterator.hasNext()) {
            double thisAmount = 0;
            Rental each = (Rental) rentalIterator.next();

            //determine rental charge for each movie by calling the chargeForRental() method
            thisAmount = chargeForRental(each);

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                each.getDaysRented() > 1) frequentRenterPoints++;

            //show figures for this rental
            result += each.getDaysRented() +
                " days of '" + each.getMovie().getTitle() +
                "' $" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Total = $" + totalAmount + "\n";
        result += "Frequent renter points = " + frequentRenterPoints + "\n";
        return result + "---\n";
    }

}