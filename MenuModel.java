class MenuModel {
    // Add your implementation for Menu Items here.
    // Determine what data you want to store for each item.
	private String name;
	private double cost;
	private static double total;
	private int quantity;

	public MenuModel(String n, Double c){
		this.name = n;
		this.cost = c;
		this.quantity = 1;
	}
	public String getName(){
		return name;
	}	
	public void calculateTotal(){
		total+=cost*quantity;
	}

	public static double getTotal(){
		return total;
	}

	public int addItem(){ 
		return quantity++;
	}
}
