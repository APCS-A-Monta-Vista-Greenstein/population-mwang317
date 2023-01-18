import java.util.List;
/**
 *	Population - <description goes here>
 *
 *	Requires FileUtils and Prompt classes.
 *
 *	@author	Megan Wang
 *	@since	January 9, 2022
 */
 
import java.util.Scanner;
import java.util.ArrayList;
public class Population {
	
	// List of cities
	private List<City> cities;
	
	// US data file
	private final String DATA_FILE = "usPopData2017.txt";
	
	public Population(){
		cities = new ArrayList<City>();
	}
	
	public static void main(String[] args){
		Population pop = new Population();
		pop.run();
	}
	
	public void run(){
		readFile();
		printIntroduction();
		
		int choice = 0;
		while(choice != 9){
			choice = getInput();
			if(choice == 1){
				ascendingPop();
			}
			else if(choice == 2){
				descendingPop();
			}
			else if(choice == 3){
				ascendingName();
			}
			else if(choice == 4){
				descendingName();
			}
			else if(choice == 5){
				stateCities();
			}
			else if(choice == 6){
				findCity();
			}
		}
		
		System.out.println("\nThanks for using Population!");
	}
	
	public void findCity(){
		List<City> match = new ArrayList<City>();
		
		String input = Prompt.getString("\nEnter city name");
		
		for(int i = 0; i < cities.size(); i++){
			City check = cities.get(i);
			if(check.getCityName().equals(input)){
				match.add(check);
			}
		}
		
		
		if(match.size() == 0){
			System.out.println("\nNo matching cities found");
		}
		else{
			SortMethods sort = new SortMethods();
			sort.mergeSort(match);
			
			System.out.println("\nCity " + input + " by population");
			System.out.printf("%4s %-25s%-25s%-15s%10s%n", "", "State", "City", "Type", "Population");
		
			for(int i = 0; i < match.size(); i++){
				City num =  match.get(match.size()-(i+1));
				System.out.printf("%3d: %-25s%-25s%-15s%,10d%n", i+1, num.getState(), 
				num.getCityName(), num.getType(), num.getPopulation());
			}
		}
		System.out.println();
	}
	
	private void stateCities(){
		String[] states = new String[]{"Alabama", "Alaska", "Arizona", "Arkansas",
			"California", "Colorado", "Connecticut", "Delaware", "Florida",
			"Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
			"Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
			"Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
			"New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina",
			"North Dakota", "Ohio"};
			
		List<String> stateList = new ArrayList<String>();
		
		for(int i = 0; i < states.length; i++){
			stateList.add(states[i]);
		}
		
		String input = "";
		do{
			input = Prompt.getString("Enter state name (ie. Alabama)");
			
			if(!stateList.contains(input)){
				System.out.println("ERROR: " + input + " is not valid");
			}
		}while(!stateList.contains(input));
		
		List<City> cityList = new ArrayList<City>();
		
		for(int i = 0; i < cities.size(); i++){
			City check = cities.get(i);
			if(check.getState().equals(input)){
				cityList.add(check);
			}
		}
		
		SortMethods sort = new SortMethods();
		sort.mergeSort(cityList);
			
		System.out.println("\nCity " + input + " by population");
		System.out.printf("%4s %-25s%-25s%-15s%10s%n", "", "State", "City", "Type", "Population");
		
		for(int i = 0; i < 50; i++){
			City num = cityList.get(cityList.size()-(i+1));
			System.out.printf("%3d: %-25s%-25s%-15s%,10d%n", i+1, num.getState(), 
			num.getCityName(), num.getType(), num.getPopulation());
		}
		
		System.out.println();
	}
	
	public void descendingName(){
		SortMethods sm = new SortMethods();
		long startMillisec = System.currentTimeMillis();
		sm.mergeSortName(cities);
		long endMillisec = System.currentTimeMillis();
		
		System.out.println("\nFifty cities sorted by name descending");
		System.out.printf("%4s %-25s%-25s%-15s%10s%n", "", "State", "City", "Type", "Population");
		
		for(int i = 0; i < 50; i++){
			City num = cities.get(cities.size()-(i+1));
			System.out.printf("%3d: %-25s%-25s%-15s%,10d%n", i+1, num.getState(), 
				num.getCityName(), num.getType(), num.getPopulation());
		}
		
		System.out.println("\nElasped time " + (endMillisec-startMillisec) 
			+ " milliseconds\n");
	}
	
	public void ascendingName(){
		SortMethods sm = new SortMethods();
		long startMillisec = System.currentTimeMillis();
		sm.insertionSortName(cities);
		long endMillisec = System.currentTimeMillis();
		
		System.out.println("\nFifty cities sorted by name");
		System.out.printf("%4s %-25s%-25s%-15s%10s%n", "", "State", "City", "Type", "Population");
		
		for(int i = 0; i < 50; i++){
			City num = cities.get(i);
			System.out.printf("%3d: %-25s%-25s%-15s%,10d%n", i+1, num.getState(), 
				num.getCityName(), num.getType(), num.getPopulation());
		}
		
		System.out.println("\nElasped time " + (endMillisec-startMillisec) 
			+ " milliseconds\n");
	}
	
	public void descendingPop(){
		SortMethods sm = new SortMethods();
		long startMillisec = System.currentTimeMillis();
		sm.mergeSort(cities);
		long endMillisec = System.currentTimeMillis();
		
		System.out.println("\nFifty most populous cities");
		System.out.printf("%4s %-25s%-25s%-15s%10s%n", "", "State", "City", "Type", "Population");
		
		for(int i = 0; i < 50; i++){
			City num = cities.get(cities.size()-(i+1));
			System.out.printf("%3d: %-25s%-25s%-15s%,10d%n", i+1, num.getState(), 
				num.getCityName(), num.getType(), num.getPopulation());
		}
		
		System.out.println("\nElasped time " + (endMillisec-startMillisec) 
			+ " milliseconds\n");
	}
	
	public void ascendingPop(){
		SortMethods sm = new SortMethods();
		long startMillisec = System.currentTimeMillis();
		sm.selectionSort(cities);
		long endMillisec = System.currentTimeMillis();
		
		System.out.println("\nFifty least populous cities");
		System.out.printf("%4s %-25s%-25s%-15s%10s%n", "", "State", "City", "Type", "Population");
		
		for(int i = 0; i < 50; i++){
			City num = cities.get(i);
			System.out.printf("%3d: %-25s%-25s%-15s%,10d%n", i+1, num.getState(), 
				num.getCityName(), num.getType(), num.getPopulation());
		}
		
		System.out.println("\nElasped time " + (endMillisec-startMillisec) 
			+ " milliseconds\n");
	}
	
	public int getInput(){
		printMenu();
		int choice = 0;
		do{
			choice = Prompt.getInt("Enter selection", 1, 9);
			
		}while(choice != 9 && (choice > 6 || choice < 1));
		return choice;
	}
	
	public void readFile(){
		Scanner data = FileUtils.openToRead("usPopData2017.txt");
		data.useDelimiter("[\t\n]");
		
		while(data.hasNext()){
			String state = data.next();
			String city = data.next();
			String type = data.next();
			int population = data.nextInt();
			
			City point = new City(city, state, type, population);
			cities.add(point);
		}
	}
	
	/**	Prints the introduction to Population */
	public void printIntroduction() {
		System.out.println("   ___                  _       _   _");
		System.out.println("  / _ \\___  _ __  _   _| | __ _| |_(_) ___  _ __ ");
		System.out.println(" / /_)/ _ \\| '_ \\| | | | |/ _` | __| |/ _ \\| '_ \\ ");
		System.out.println("/ ___/ (_) | |_) | |_| | | (_| | |_| | (_) | | | |");
		System.out.println("\\/    \\___/| .__/ \\__,_|_|\\__,_|\\__|_|\\___/|_| |_|");
		System.out.println("           |_|");
		System.out.println();
	}
	
	/**	Print out the choices for population sorting */
	public void printMenu() {
		System.out.println("1. Fifty least populous cities in USA (Selection Sort)");
		System.out.println("2. Fifty most populous cities in USA (Merge Sort)");
		System.out.println("3. First fifty cities sorted by name (Insertion Sort)");
		System.out.println("4. Last fifty cities sorted by name descending (Merge Sort)");
		System.out.println("5. Fifty most populous cities in named state");
		System.out.println("6. All cities matching a name sorted by population");
		System.out.println("9. Quit");
	}
	
}
