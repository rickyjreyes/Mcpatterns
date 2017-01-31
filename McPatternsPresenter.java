import java.io.*;
import java.util.*;

class McPatternsPresenter {
	//This is the class that will handle the model <-> UI communication.
	private ArrayList<MenuModel> model= new ArrayList();
	private McPatternsGUI view;
	private String File;
	
	public McPatternsPresenter(String f){
		this.File = f;
	}

	public String getFile(){
		return File;
	}

	void loadMenuItems() {
		// TODO: Add code to read a file and load the menu items.
		File file = new File(this.getFile());

		try {

			Scanner sc = new Scanner(file);

			while (sc.hasNextLine()) {
				String s= sc.nextLine();
				String[] parts;
				parts= s.split("[|]");
				double number = Double.parseDouble(parts[1]);
				model.add(new MenuModel(parts[0],number));
			}
			sc.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	} 

	void attachView(McPatternsGUI view) {
		this.view = view;
	}

	// Add functions to return the menu items.
	//public MenuModel setItem(String n, Double c){
		//model(n,c);
		//model.calculateTotal();
		//model.addItem();
	//}
	public ArrayList<MenuModel> getModel(){
		return model;
	}	 
}
