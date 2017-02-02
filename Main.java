public class Main{	
	
	static String[] horseNames = new String[]{"Kábó", "Kese", "Húskloffo-ló", "Void", "Emmavaccon", 
							"Hason-ló", "Poro-ló", "Larakroft"};
	static Horse[] racers;	
	
	public static void main(String[] args){

		Logger logger = new Logger();
		int simulationCount;

		if(args.length > 0)
			simulationCount = Integer.parseInt(args[0]);
		else{
			logger.log("<System>: ", "No arguments given, running with default 50 rounds.\n");
			simulationCount = 50;
		}

		racers = new Horse[8];
		for(int i = 0; i < racers.length; i++){
			racers[i] = new Horse(i, horseNames[i]);
		}

		Simulation sim = generateSimulation(simulationCount);
		Simulator simltr = new Simulator(sim, logger);
		simltr.run();
		

	}	
	
	public static Simulation generateSimulation(int rounds){
		Simulation sim = new Simulation(racers, rounds);
		sim.simulateRace();
		return sim;
	}

}
