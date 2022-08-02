
public class Category extends Item{
	
	private String catName;

	public Category(String name, String description, String catName) {
		super(name, description);
		this.catName = catName;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}


}
