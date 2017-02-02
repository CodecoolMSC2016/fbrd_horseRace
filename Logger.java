import java.util.Date;

public class Logger{
		
	private Date date;	
	

	public Logger(){
		date = new Date();
	}


	public void log(String type, String message){
		System.out.printf("%s: %s %s", date.toString(), type, message);
	}
	
	public void dumpArray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.println("Round: " + (i+1) + "; WinnerID: " + array[i]);
		}
	}
}
