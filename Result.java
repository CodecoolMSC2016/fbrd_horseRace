public class Result{
	private Horse theBest;
	private double winningChance;

	public Result(Horse theBest, double winningChance){
		this.theBest = theBest;
		this.winningChance = winningChance;
	}
	
	public Horse getTheBest(){
		return theBest;
	}
	
	public void setTheBest(Horse theBest){
		this.theBest = theBest;
	}
	
	public double getWinningChance(){
		return winningChance;
	}
	
	public void setWinningChance(double winningChance){
		this.winningChance = winningChance;
	}
	
}