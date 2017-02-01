public class Main{	
	
	static String[] horseNames = new String[]{"Kábó", "Kese", "Húskloffo-ló", "Void", "Emmavaccon", 
							"Hason-ló", "Poro-ló", "Larakroft"};
	static Horse[] racers;	
	
	public static void main(String[] args){

		int simulationCount = Integer.parseInt(args[0]);

		racers = new Horse[8];
		for(int i = 0; i < racers.length; i++){
			racers[i] = new Horse(i, horseNames[i]);
			System.out.println(racers[i].getId() + " - " + racers[i].getName());
		}
		Simulation sim = generateSimulation(simulationCount);

	}	
	
	public static Simulation generateSimulation(int rounds){
		Simulation sim = new Simulation(racers, rounds);
		sim.simulateRace();
		return sim;
	}

}
