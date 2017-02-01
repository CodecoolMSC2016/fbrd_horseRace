public class Main{	
	
	static String[] horseNames = new String[]{"Kábó", "Kese", "Feka", "Void", "Emmavaccon", 								"Arthas", "Tyrion", "Larakroft"};
	public static void main(String[] args){

		int simulationCount = Integer.parseInt(args[0]);
		
		Horse[] racers = new Horse[8];

		for(int i = 0; i < racers.length; i++){
			racers[i] = new Horse(i, horseNames[i]);
			System.out.println(racers[i].getId() + " - " + racers[i].getName());
		}

		System.out.println(simulationCount + 15);

	}	

	

}
