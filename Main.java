import java.util.Scanner;

public class Main{	
	
	static String[] horseNames = new String[]{"Kábó", "Kese", "Húskloffo-ló", "Void", "Emmavaccon", 
							"Hason-ló", "Poro-ló", "Larakroft"};
	static Horse[] racers;	
	static int simulationCount;	
		
	public static void main(String[] args){

		Logger logger = new Logger();
		boolean shouldDump = false;
		Result result;
		Result fileResult;
		Scanner sc = new Scanner(System.in);
		String input;

		if(args.length > 0){
			if(args[0].equalsIgnoreCase("-d")){
				shouldDump = true;
				logger.log("<System>: ", "No arguments given, running with default 50 rounds.\n");
				logger.log("<System>: ", "DEBUG MODE ENABLED!\n");
				simulationCount = 50;
			}
			else{
				simulationCount = Integer.parseInt(args[0]);
			}
		}
		else{
			logger.log("<System>: ", "No arguments given, running with default 50 rounds.\n");
			simulationCount = 50;
		}

		if(args.length == 2){
			if(args[1].equalsIgnoreCase("-d")){
				shouldDump = true;
			}
			else{
				simulationCount = Integer.parseInt(args[1]);
			}
		
		}

		racers = new Horse[8];
		for(int i = 0; i < racers.length; i++){
			racers[i] = new Horse(i, horseNames[i]);
		}

		Simulation sim = generateSimulation(simulationCount);
		Simulator simltr = new Simulator(sim, logger);
		
		if(shouldDump){
			logger.dumpArray(sim.getWinnerIds());
		}

		result = simltr.run();
		logger.log("<RESULT>: ", "You should bet on " + racers[result.getId()].getName() +
				 " he has " + result.getWinningChance() * 100 + "%" + " chance to win.\n");
		//YOLO
		logger.log("<INFO>: ", "Would you like to get a prediction based on simulation history?(y/n):\n");
		input = sc.next();

		if(input.equalsIgnoreCase("y")){
			HistoryReader hr = new HistoryReader(racers);
			Simulation simFile = hr.restoreSim();
			Simulator simulateFromFile = new Simulator(simFile, logger);
			fileResult = simulateFromFile.run();
			
			logger.dumpArray(simFile.getWinnerIds());
			logger.log("<RESULT>: ", "You should bet on " + racers[fileResult.getId()].getName() +
				 " he has " + fileResult.getWinningChance() * 100 + "%" + " chance to win.\n");
		}
		
	}	
	
	public static Simulation generateSimulation(int rounds){
		Simulation sim = new Simulation(racers, rounds);
		sim.simulateRace();
		return sim;
	}

}
