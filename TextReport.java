public class TextReport implements Report {    
    public String headerLine(String name) {
    	String customerName;
    	
    	customerName = "Rentals: " + name + "\n";;
    	
    	return customerName;
    }
    
    public String footerLine(double totalCharge, int frequentRenterPoints) {
    	String footer;
    	
    	footer = "Total = $" + totalCharge + "\n" + "Frequent renter points = " + frequentRenterPoints + "\n" + "---\n";
    	
    	return footer;
    }
    
    public String rentalLine(int daysRented, String title, double charge) {
    	return daysRented + " days of '" + title +"' $" + charge + "\n";
	}
}