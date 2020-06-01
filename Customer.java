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
    
    private String rentalLine(int daysRented, String movie, double charge) {
    	String rentalLine;
    	
    	rentalLine = daysRented + " days of '" + movie + "' $" + charge + "\n";
    			
    	return rentalLine;
    }
    
    public String statement() {
        double totalCharge = 0;
        int frequentRenterPoints = 0;
        Iterator rentalIterator = rentals.iterator();
        String result = "Rentals: " + getName() + "\n";
        
    	//while loop is changed to for loop
        for (; rentalIterator.hasNext();) {
            double charge = 0;
            Rental rental = (Rental) rentalIterator.next();

            //determine rental charge for each movie by calling the charge() method from Rental
            charge = rental.charge();  
            
            //determine the frequent renter points
            frequentRenterPoints = rental.frequentRenterPoints(frequentRenterPoints);

            //show figures for this rental
            //rentalLine() method is extracted above
            result += rentalLine(rental.getDaysRented(), rental.getMovie().getTitle(),charge);
            
            totalCharge += charge;
        }
        
        //add footer lines
        result += "Total = $" + totalCharge + "\n";
        result += "Frequent renter points = " + frequentRenterPoints + "\n";
        return result + "---\n";
    }

}