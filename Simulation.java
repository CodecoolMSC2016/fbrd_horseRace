import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Simulation {

	private String filePath;
	private Horse[] horses;
	private int rounds;
	private int[] winnerIds;
	
	public Simulation(Horse[] horses, int rounds){
		this.horses = horses;
		this.rounds = rounds;
		filePath = "simulatedRuns.csv";
		winnerIds = new int[rounds];
	}	
	
	public void simulateRace() {
		int id;
		for(int i = 0; i < rounds; i++){
			id = ThreadLocalRandom.current().nextInt(0, 7 + 1);
			winnerIds[i] = id;
			try{
				generateData(id, horses[id].getName());
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public void generateData(int id, String name) throws IOException{
		FileWriter fw = new FileWriter(filePath, true);
		fw.append(id + ";" + name + "\n");
		fw.flush();
		fw.close();
	}

	public int[] load(){
		return winnerIds;
	}
	
	public int[] getWinnerIds(){
		return winnerIds;
	}
	
}
