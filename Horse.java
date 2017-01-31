public class Horse{
	
	private int id;
	private String name;
	private int wins;	

	public Horse(int id, String name){
		this.id = id;
		this.name = name;
		wins = 0;
	}

	public String getName(){
		return name;
	}
	
	public int getId(){
		return id;
	}

	public int getWins(){
		return wins;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setId(int id){
		this.id = id;
	}
	
	public void setWins(int wins){
		this.wins = wins;
	}

	public void increaseWins(int increaseBy){
		this.wins += increaseBy;
	}

}
