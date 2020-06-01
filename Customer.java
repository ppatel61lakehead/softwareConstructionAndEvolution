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
    
    public String statement() {
        double totalCharge = 0;
        int frequentRenterPoints = 0;
        Iterator rentalIterator = rentals.iterator();
        
        Report report = new Report();
        String result = report.headerLine(getName());
        
    	//while loop is changed to for loop
        for (; rentalIterator.hasNext();) {
            double charge = 0;
            Rental rental = (Rental) rentalIterator.next();

            //determine rental charge for each movie by calling the charge() method from Rental
            charge = rental.charge();  
            
            //determine the frequent renter points
            frequentRenterPoints = rental.frequentRenterPoints(frequentRenterPoints);

            //show figures for this rental
            result += rental.rentalLine(report);
            
            totalCharge += charge;
        }
        
        //add footer lines
        return result + report.footerLine(totalCharge, frequentRenterPoints);
    }

}