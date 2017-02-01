public class Result{
	private int id;
	private double winningChance;

	public Result(int id, double winningChance){
		this.id = id;
		this.winningChance = winningChance;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public double getWinningChance(){
		return winningChance;
	}
	
	public void setWinningChance(double winningChance){
		this.winningChance = winningChance;
	}
	
}