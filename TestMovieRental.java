import junit.framework.*;

public class TestMovieRental extends TestCase {
	
    private Rental rentMatrix, rentMatrix2;
    private Customer customer;

    public void setUp() {
        rentMatrix = new Rental(new Movie("Matrix", Movie.REGULAR), 4);
        rentMatrix2 = new Rental(new Movie("Matrix2", Movie.NEW_RELEASE), 5);
        customer = new Customer("John Hood");
    }
    
    public void testInitialCustomer() {
        assertEquals("Rentals: John Hood\n"
        		+ "Total = $0.0\n"
        		+ "Frequent renter points = 0\n"
        		+ "---\n",
        		customer.statement());
        
        System.out.println(customer.statement());
    }
    
    public void testRentingCustomer() {
        customer.addRental(rentMatrix);
        customer.addRental(rentMatrix2);
        assertEquals("Rentals: John Hood\n"
        		+ "4 days of 'Matrix' $5.0\n"
        		+ "5 days of 'Matrix2' $15.0\n"
        		+ "Total = $20.0\n"
        		+ "Frequent renter points = 3\n"
        		+ "---\n",
        		customer.statement());
        
        System.out.println(customer.statement());
    }
    
    public void testHtmlCustomer() {
    	customer.addRental(rentMatrix);
    	customer.addRental(rentMatrix2);
    	assertEquals("<html><head><title>Rentals: John Hood</title></head><body>\n"
    			+ "<h1>Rentals: John Hood</h1>\n"
    			+ "<table border=1><tr><th>Days</th><th>Title</th><th>Charge</th></tr>\n"
    			+ "<tr><td align=right>4</td><td>Matrix<td align=right>$5.0</td></tr>\n"
    			+ "<tr><td align=right>5</td><td>Matrix2<td align=right>$15.0</td></tr>\n"
    			+ "<tr><td></td><td><i>total</i><td align=right>$20.0</td></tr>\n"
    			+ "</table><p>Frequent renter points = 3</p>\n"
    			+ "</body></html>\n",
    		     customer.htmlStatement());
    	
    	System.out.println(customer.htmlStatement());
    }
}