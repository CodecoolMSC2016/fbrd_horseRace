public class Simulator{
	private Simulation simulation;
	private Logger logger;
	private int[] counterList = new int[8];


	public Simulator(Simulation simulation, Logger logger){
		this.simulation = simulation;
		this.logger = logger;
		
	}
	
	public Simulation getSimulation(){
		return simulation;
	}
	
	public void setSimulation(Simulation simulation){
		this.simulation = simulation;
	}
	
	public Logger getLogger(){
		return logger;
	}
	
	public void setLogger(Logger logger){
		this.logger = logger;
	}
	
	public int findBestId(){		
		for(int id : simulation.getWinnerIds()){
			counterList[id] += 1;
		}
		
		int bestId = 0;
		
		for(int i = 0; i < counterList.length; i++){
			if(counterList[bestId] < counterList[i]){
				bestId = i;
			}
		}
		
		return bestId;
	}
	
	public double countWinningChance(){
		
		int maxi = 0;
		for(int i = 0; i < counterList.length; i++){
			if(counterList[maxi] < counterList[i]){
				maxi = i;
			}
		}
		int numOfWinOfTheBest = counterList[maxi];
		
		return numOfWinOfTheBest / counterList.length;
	}
	
	public Result run(){	
		System.out.println(countWinningChance());
		Result result = new Result(findBestId(), countWinningChance());
		return result;
	}
}