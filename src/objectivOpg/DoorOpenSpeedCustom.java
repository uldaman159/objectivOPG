package objectivOpg;

import java.util.Scanner;

public class DoorOpenSpeedCustom extends DoorOpenSpeed 
{
	public void doorOpenSpeed()
	{
		System.out.println("skriv hvor hurtigt din dør skal åbne i sec");
		
		Scanner scanner = new Scanner(System.in);// laver en sacnner som tager imod input
		int userChoice = scanner.nextInt();// gemmer det input i userChoice
		
		doorSpeed = userChoice;
	
		
	}	
}