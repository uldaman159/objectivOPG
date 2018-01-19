package objectivOpg;

import java.awt.event.KeyEvent;
import java.io.Console;
import java.util.Scanner;

public abstract class MainThread
{
	public static boolean doorUnlock = false; // false = låst  true = låst op
	public static int doorSpeed = 2; // hvor hurtigt døren åbner sig på sec
	
	public static void main(String[] args)
	{
		while(true) // starter et loop som bliver ved med at køre 
		{
			if (doorUnlock == false) // hvis doorUnlock == false skal denne del af koden køre
			{
				System.out.println("døren er låst \nfor at låse op brug kort eller skriv kode \ntryk 1) for at bruge kort \ntryk 2) for at bruge kode \ntryk 3) for at ændre hvor hurtigt døren skal åbne");
				
				
				
				Scanner scanner1 = new Scanner(System.in); // laver en sacnner som tager imod input
				int userChoice1 = scanner1.nextInt(); // gemmer det input i userChoice1
				
				if(userChoice1 == 1) // hvis userChoice1 == 1 skal denne del af koden køre
				{
					System.out.println("scan kortet");
					
					Scanner scanner2 = new Scanner(System.in);// laver en sacnner som tager imod input
					int userChoice2 = scanner2.nextInt();// gemmer det input i userChoice2
					
					if(userChoice2 == Sikkerhed.getAccesCard())//hvis userChoice2 = CardID(1337) skal døren låse op
					{
						doorUnlock = true;//døren er låst op
					}
				}
				
				else if(userChoice1 == 2)// hvis userChoice1 == 2 skal denne del af koden køre
				{
					System.out.println("skriv kode");
					
					Scanner scanner3 = new Scanner(System.in);// laver en sacnner som tager imod input
					int userChoice3 = scanner3.nextInt();// gemmer det input i userChoice3
					
					if(userChoice3 == Sikkerhed.getAccesCode())// hvis userChoice3 = AccesCode(1234) skal døren låse op
					{
						doorUnlock = true;// døren er låst op
					}
				}
				
				else if (userChoice1 == 3)// hvis userChoice1 == 3 skal denne del af koden køre
				{
					System.out.println("du kan vælge 2 muligeheder \ntryk 1) vælg deafault på 2 sec \ntryk 2) vælg en brugerdefineret for selv at skrive tiden"); 
					
					Scanner scanner4 = new Scanner(System.in);// laver en sacnner som tager imod input
					int userChoice4 = scanner4.nextInt();// gemmer det input i userChoice4
					
					if(userChoice4 == 1)// hvis userChoice4 == 1 skal denne del af koden køre
					{
						DoorOpenSpeed a = new DoorOpenSpeedDefault();
						a.doorOpenSpeed();
						
						System.out.println("døren åbner og lukker nu på " + doorSpeed + " sec \n");
					}
					
					else if(userChoice4 == 2)// hvis userChoice4 == 2 skal denne del af koden køre
					{
						DoorOpenSpeed b = new DoorOpenSpeedCustom();
						b.doorOpenSpeed();
						
						System.out.println("døren åbner og lukker nu på " + doorSpeed + " sec \n");
					}
				}
			}
			
			else if (doorUnlock == true)
			{
				System.out.println("døren er låst op \nfor at aktivere sensoren og åbne døren pres 0  \n\nfor at låse brug kort eller skriv kode \ntryk 1) for at bruge kort \ntryk 2) for at bruge kode \ntryk 3) for at ændre hvor hurtigt døren skal åbne");
				
				Scanner scanner1 = new Scanner(System.in);// laver en sacnner som tager imod input
				int userChoice1 = scanner1.nextInt();// gemmer det input i userChoice1
				
				if(userChoice1 == 1)// hvis userChoice1 == 1 skal denne del af koden køre
				{
					System.out.println("scan kortet");
					
					Scanner scanner2 = new Scanner(System.in);// laver en sacnner som tager imod input
					int userChoice2 = scanner2.nextInt();// gemmer det input i userChoice2
					
					if(userChoice2 == Sikkerhed.getAccesCard())// hvis userChoice2 == CardID(1337) skal døren låse
					{
						doorUnlock = false;// døren er låst
					}
				}
				
				else if(userChoice1 == 2)// hvis userChoice1 == 2 skal denne del af koden køre
				{
					System.out.println("skriv kode");
					
					Scanner scanner3 = new Scanner(System.in);// laver en sacnner som tager imod input
					int userChoice3 = scanner3.nextInt();// gemmer det input i userChoice3
					
					if(userChoice3 == Sikkerhed.getAccesCode())// hvis userChoice3 == AccesCode(1234) skal døren låse
					{
						doorUnlock = false;//døren er låst
					}
				}
				else if (userChoice1 == 3)// hvis userChoice1 == 3 skal denne del af koden køre
				{
					System.out.println("du kan vælge 2 muligeheder \ntryk 1) vælg deafault på 2 sec \ntryk 2) vælg en brugerdefineret for selv at skrive tiden"); 
					
					Scanner scanner4 = new Scanner(System.in);// laver en sacnner som tager imod input
					int userChoice4 = scanner4.nextInt();// gemmer det input i userChoice4
					
					if(userChoice4 == 1)// hvis userChoice4 == 1 skal denne del af koden køre
					{
						DoorOpenSpeed a = new DoorOpenSpeedDefault();//DoorOpenSpeed referance og object
						a.doorOpenSpeed();// køren methoden fra klassen DoorOpenSpeedDefault
						
						System.out.println("døren åbner og lukker nu på " + doorSpeed + " sec \n");
					}
					
					else if(userChoice4 == 2)// hvis userChoice4 == 2 skal denne del af koden køre
					{
						DoorOpenSpeed b = new DoorOpenSpeedCustom();//DoorOpenSpeed referance og object
						b.doorOpenSpeed();// køren methoden fra klassen DoorOpenSpeedCustom
						
						System.out.println("døren åbner og lukker nu på " + doorSpeed + " sec \n");
					}
					
				}
				
				else if(userChoice1 == 0)// hvis userChoice1 == 0 skal denne del af koden køre
				{
					openDoor open = new Open();
					openDoor close = new Close();
					open.Door();
					System.out.println("på " + doorSpeed + " sec \n");
					System.out.println("for at deaktivere sensoren og lukke døren pres 0 igen");
					
					Scanner scanner5 = new Scanner(System.in);// laver en sacnner som tager imod input
					int userChoice5 = scanner5.nextInt();// gemmer det input i userChoice5
					
					if(userChoice5 == 0)// hvis userChoice1 == 0 igen, skal denne del af koden køre
					{
						close.Door();
						System.out.println("på " + doorSpeed + " sec \n");
					}					
				}
			}
		}
	}
}