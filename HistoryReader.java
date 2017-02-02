import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HistoryReader{

	private ArrayList<Integer> winnerIds;
	private Horse[] horses;
	private String filePath;
	

	public HistoryReader(Horse[] horses){
		this.horses = horses;
		this.winnerIds = new ArrayList<Integer>();
		this.filePath = "simulatedRuns.csv";
	}

	public void loadHistory(){
		
		BufferedReader br = null;
		String line = "";
		String splitCharacter = ";";
		
		try{
			final int IDS = 0;

			br = new BufferedReader(new FileReader(filePath));

			while((line = br.readLine()) != null){
				String[] race = line.split(splitCharacter);

				winnerIds.add(Integer.parseInt(race[IDS]));
			}
		}
		catch(FileNotFoundException e){
			System.err.println("There is no such file: " + filePath + "!");
		}
		catch(IOException e){
			System.err.println("Something Went Wrong Somewhere With Something...");
		}
		finally {
			if(br !=null){
				try{
					br.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}

	private int[] generateWinnerIds(){
		int[] winners = new int[winnerIds.size()];

		for(int i = 0; i < winnerIds.size(); i++){
			winners[i] = winnerIds.get(i);
		}

		return winners;
	}

	public Simulation restoreSim(){
		loadHistory();
		return new Simulation(generateWinnerIds());
	}

	
	
}
