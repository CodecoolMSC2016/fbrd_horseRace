import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
public class Simulation {
	
	public void simulateRace(Horse[] horses) {
		int id;
		id = ThreadLocalRandom.current().nextInt(0, 7 + 1);
		horses[id].increaseWins(1);
		generateData(id, horses[id].getName(), horses[id].getWins());
	}
	
	
	public void generateData(int id, String name, int wins) {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("simulatedRuns.csv"), "utf-8"))) {
			writer.write(id + ";" + name + ";" + wins + "\n");
			
		}
		catch (IOException e){
		e.printStackTrace();
		}
	}
	
	
}