package objectivOpg;

import java.awt.event.KeyEvent;
import java.io.Console;
import java.util.Scanner;

public abstract class MainThread
{
	public static boolean doorUnlock = false; // false = l�st  true = l�st op
	public static int doorSpeed = 2; // hvor hurtigt d�ren �bner sig p� sec
	
	public static void main(String[] args)
	{
		while(true) // starter et loop som bliver ved med at k�re 
		{
			if (doorUnlock == false) // hvis doorUnlock == false skal denne del af koden k�re
			{
				System.out.println("d�ren er l�st \nfor at l�se op brug kort eller skriv kode \ntryk 1) for at bruge kort \ntryk 2) for at bruge kode \ntryk 3) for at �ndre hvor hurtigt d�ren skal �bne");
				
				
				
				Scanner scanner1 = new Scanner(System.in); // laver en sacnner som tager imod input
				int userChoice1 = scanner1.nextInt(); // gemmer det input i userChoice1
				
				if(userChoice1 == 1) // hvis userChoice1 == 1 skal denne del af koden k�re
				{
					System.out.println("scan kortet");
					
					Scanner scanner2 = new Scanner(System.in);// laver en sacnner som tager imod input
					int userChoice2 = scanner2.nextInt();// gemmer det input i userChoice2
					
					if(userChoice2 == Sikkerhed.getAccesCard())//hvis userChoice2 = CardID(1337) skal d�ren l�se op
					{
						doorUnlock = true;//d�ren er l�st op
					}
				}
				
				else if(userChoice1 == 2)// hvis userChoice1 == 2 skal denne del af koden k�re
				{
					System.out.println("skriv kode");
					
					Scanner scanner3 = new Scanner(System.in);// laver en sacnner som tager imod input
					int userChoice3 = scanner3.nextInt();// gemmer det input i userChoice3
					
					if(userChoice3 == Sikkerhed.getAccesCode())// hvis userChoice3 = AccesCode(1234) skal d�ren l�se op
					{
						doorUnlock = true;// d�ren er l�st op
					}
				}
				
				else if (userChoice1 == 3)// hvis userChoice1 == 3 skal denne del af koden k�re
				{
					System.out.println("du kan v�lge 2 muligeheder \ntryk 1) v�lg deafault p� 2 sec \ntryk 2) v�lg en brugerdefineret for selv at skrive tiden"); 
					
					Scanner scanner4 = new Scanner(System.in);// laver en sacnner som tager imod input
					int userChoice4 = scanner4.nextInt();// gemmer det input i userChoice4
					
					if(userChoice4 == 1)// hvis userChoice4 == 1 skal denne del af koden k�re
					{
						DoorOpenSpeed a = new DoorOpenSpeedDefault();
						a.doorOpenSpeed();
						
						System.out.println("d�ren �bner og lukker nu p� " + doorSpeed + " sec \n");
					}
					
					else if(userChoice4 == 2)// hvis userChoice4 == 2 skal denne del af koden k�re
					{
						DoorOpenSpeed b = new DoorOpenSpeedCustom();
						b.doorOpenSpeed();
						
						System.out.println("d�ren �bner og lukker nu p� " + doorSpeed + " sec \n");
					}
				}
			}
			
			else if (doorUnlock == true)
			{
				System.out.println("d�ren er l�st op \nfor at aktivere sensoren og �bne d�ren pres 0  \n\nfor at l�se brug kort eller skriv kode \ntryk 1) for at bruge kort \ntryk 2) for at bruge kode \ntryk 3) for at �ndre hvor hurtigt d�ren skal �bne");
				
				Scanner scanner1 = new Scanner(System.in);// laver en sacnner som tager imod input
				int userChoice1 = scanner1.nextInt();// gemmer det input i userChoice1
				
				if(userChoice1 == 1)// hvis userChoice1 == 1 skal denne del af koden k�re
				{
					System.out.println("scan kortet");
					
					Scanner scanner2 = new Scanner(System.in);// laver en sacnner som tager imod input
					int userChoice2 = scanner2.nextInt();// gemmer det input i userChoice2
					
					if(userChoice2 == Sikkerhed.getAccesCard())// hvis userChoice2 == CardID(1337) skal d�ren l�se
					{
						doorUnlock = false;// d�ren er l�st
					}
				}
				
				else if(userChoice1 == 2)// hvis userChoice1 == 2 skal denne del af koden k�re
				{
					System.out.println("skriv kode");
					
					Scanner scanner3 = new Scanner(System.in);// laver en sacnner som tager imod input
					int userChoice3 = scanner3.nextInt();// gemmer det input i userChoice3
					
					if(userChoice3 == Sikkerhed.getAccesCode())// hvis userChoice3 == AccesCode(1234) skal d�ren l�se
					{
						doorUnlock = false;//d�ren er l�st
					}
				}
				else if (userChoice1 == 3)// hvis userChoice1 == 3 skal denne del af koden k�re
				{
					System.out.println("du kan v�lge 2 muligeheder \ntryk 1) v�lg deafault p� 2 sec \ntryk 2) v�lg en brugerdefineret for selv at skrive tiden"); 
					
					Scanner scanner4 = new Scanner(System.in);// laver en sacnner som tager imod input
					int userChoice4 = scanner4.nextInt();// gemmer det input i userChoice4
					
					if(userChoice4 == 1)// hvis userChoice4 == 1 skal denne del af koden k�re
					{
						DoorOpenSpeed a = new DoorOpenSpeedDefault();//DoorOpenSpeed referance og object
						a.doorOpenSpeed();// k�ren methoden fra klassen DoorOpenSpeedDefault
						
						System.out.println("d�ren �bner og lukker nu p� " + doorSpeed + " sec \n");
					}
					
					else if(userChoice4 == 2)// hvis userChoice4 == 2 skal denne del af koden k�re
					{
						DoorOpenSpeed b = new DoorOpenSpeedCustom();//DoorOpenSpeed referance og object
						b.doorOpenSpeed();// k�ren methoden fra klassen DoorOpenSpeedCustom
						
						System.out.println("d�ren �bner og lukker nu p� " + doorSpeed + " sec \n");
					}
					
				}
				
				else if(userChoice1 == 0)// hvis userChoice1 == 0 skal denne del af koden k�re
				{
					openDoor open = new Open();
					openDoor close = new Close();
					open.Door();
					System.out.println("p� " + doorSpeed + " sec \n");
					System.out.println("for at deaktivere sensoren og lukke d�ren pres 0 igen");
					
					Scanner scanner5 = new Scanner(System.in);// laver en sacnner som tager imod input
					int userChoice5 = scanner5.nextInt();// gemmer det input i userChoice5
					
					if(userChoice5 == 0)// hvis userChoice1 == 0 igen, skal denne del af koden k�re
					{
						close.Door();
						System.out.println("p� " + doorSpeed + " sec \n");
					}					
				}
			}
		}
	}
}