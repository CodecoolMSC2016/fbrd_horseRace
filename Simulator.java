public class Simulator{
	private Simulation simulation;
	private Logger logger;


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
	
	public Result run(){
		
		return result;
	}
}