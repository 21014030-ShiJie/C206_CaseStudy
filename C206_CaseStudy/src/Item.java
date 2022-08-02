
public class Item {

	private String name;
	private String description;
	private double mininum_bid_price;
	private boolean isAvailable;
	private String auctionstartdate;
	private String end_date;
	private double bid_increment;

	public Item(String name, String description) {
		this.name = name;
		this.description = description;
		this.mininum_bid_price = mininum_bid_price;
		this.isAvailable = isAvailable;
		this.auctionstartdate = auctionstartdate;
		this.end_date = end_date;
		this.bid_increment = bid_increment
	}

	public String toString() {
		String itemInfo = String.format("%-10s %-30s %-10s %-10s %-10s %-10s,", name, description,
				showAvailability(isAvailable), auctionstartdate, end_date, bid_increment);

		return itemInfo;
	}

	private Object showAvailability(boolean isAvailable2) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;

	}

	public String getName() {
		return name;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getAuctionstartdate() {
		return auctionstartdate;
	}

	public void setAuctionstartdate(String auctionstartdate) {
		this.auctionstartdate = auctionstartdate;
	}

	public String getDescription() {
		return description;
	}

	public double getMininum_bid_price() {
		return mininum_bid_price;
	}

	public String getEnd_date() {
		return end_date;
	}
	
	public double getBid_increment() {
		return bid_increment;
	}
}
