import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.Scanner;

public class NewMarket {
	private static Map<String, Double> menu = new TreeMap<>();
	private static List<String> itemName = new ArrayList<>();
	private static List<Double> itemPrice = new ArrayList<>();

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	try {
	boolean end = true;
	do {
	menuMap();
	printMenu();
		 System.out.println("Welcome, Please select your items: ");
		 String item = sc.nextLine();
		 double price = menu.get(item);
		// System.out.println(item + " added, Price: $" + price);
		 if (!menu.containsKey(item)) {
			 System.out.println("Incorrect selection, Please try again");
				printMenu();
		 }else if (menu.containsKey(item)) {
			 System.out.println(item + " added, Price: $" + price);
		 }
		 cart(item, price);
		 System.out.println("Continue Shopping? (y/n)");
		 String ans = sc.nextLine();
		 if (ans.equalsIgnoreCase("n")) {
			 end = false;
		 }
		 
		 
	}while (end == true);
	total(itemPrice);
		 
	}catch (NullPointerException e) {
		System.out.println("Incorrect selection, Please try again");
		printMenu();
		System.out.println("Select your Item");
		String item = sc.nextLine();
	}
	}	
	
	private static void printMenu() {
		System.out.println("Item\tPrice");
		System.out.println("===================");
		for (Map.Entry<String, Double> entry : menu.entrySet()) {
			System.out.println(entry.getKey() + "    " + entry.getValue());
			}
		
		}
	
	private static void menuMap() {
		menu.put("apple     ", 1.99);
		menu.put("orange    ", 2.25);
		menu.put("grapes    ", 3.52);
		menu.put("lemon     ", 2.75);
		menu.put("watermelon", 5.99);
		menu.put("cantaloupe", 4.15);
		menu.put("pineapple ", 7.15);
		menu.put("pear      ", 1.02);
	}
	private static void cart(String item, Double price) {
		
		itemName.add(item);
		itemPrice.add(price);
	}
	private static void total(List<Double> price) {
		Double average = 0.00;
		double sum = 0.00;
		for (int i = 0; i < price.size(); i++) {
			sum = sum + price.get(i);
		}
		average = sum / price.size();
		System.out.println("Average price of your items was: $" + average);
	}
}
