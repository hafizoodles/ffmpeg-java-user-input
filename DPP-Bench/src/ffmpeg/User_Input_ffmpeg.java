package ffmpeg;



import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class User_Input_ffmpeg {
	public static void main (String [] args) {
		try {
			Scanner in = new Scanner(System.in);
	        System.out.print("Enter the ffmpeg command:- \n");
	        String ffmpeg_command = in.nextLine();
			

			Process process = Runtime.getRuntime().exec(ffmpeg_command); 
			System.out.println("Processing");
			
			StringBuilder output = new StringBuilder(); 
			
			BufferedReader reader = new BufferedReader(new InputStreamReader (process.getInputStream()));
			
			String line;
			
			while((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
			
			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("Successful");
				System.out.println(output);
				System.exit(0);
			} else {
				System.out.println("Something abnormal has haapened ,please check the details:( ");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
}
   
