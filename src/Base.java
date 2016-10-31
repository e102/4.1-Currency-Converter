public class Base {

	public static void main(String[] args) {

		//Setting up the converter back-end
		Currency yen = new Currency("Yen", 0.15);
		Currency pound = new Currency("Pound", 1.22);
		Currency renminbi = new Currency("Renminbi", 0.0095);
		
		Currency[] currList = new Currency[3];
		currList[0] = yen;
		currList[1] = pound;
		currList[2] = renminbi;
		
		
		
		//Setting up the GUI
		ConverterWindow frame = new ConverterWindow(currList);
		frame.setVisible(true);
	}

}
