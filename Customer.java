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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator rentalIterator = rentals.iterator();
        String result = "Rentals: " + getName() + "\n";
        while (rentalIterator.hasNext()) {
            double thisAmount = 0;
            Rental each = (Rental) rentalIterator.next();

            //determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }

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