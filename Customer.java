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
    
    /*--- The chargeForRental(Rental each) method is extracted from statement() method.
    The Rental object is passed as a parameter and the chargeForRental method is called in each iteration
    the rest switch statement code is kept same, other than introducing a new temporary variable named 
    'amount', in which the individual rent charge is calculated and stored and then returned to the 
    statement() method.
    ---*/
    private double chargeForRental(Rental each) {
    	double amount = 0;
    	
    	switch (each.getMovie().getPriceCode()) {
	        case Movie.REGULAR:
	        	amount += 2;
	            if (each.getDaysRented() > 2)
	            	amount += (each.getDaysRented() - 2) * 1.5;
	            break;
	        case Movie.NEW_RELEASE:
	        	amount += each.getDaysRented() * 3;
	            break;
	        case Movie.CHILDRENS:
	        	amount += 1.5;
	            if (each.getDaysRented() > 3)
	            	amount += (each.getDaysRented() - 3) * 1.5;
	            break;
	    }
    	
    	return amount;
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