public interface Report {
	public String headerLine(String name);
	public String rentalLine(int daysRented, String title, double charge);
	public String footerLine(double totalCharge, int frequentRenterPoints);
}