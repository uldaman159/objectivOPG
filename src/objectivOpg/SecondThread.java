package objectivOpg;

import java.time.Clock;
import java.time.LocalDate;

public class SecondThread 
{
	// fik ikke dette til at virke
	public static Clock clock;
	
	public static Clock systemDefaultZone() 
	{
		System.out.println(clock);
		return null;
		
	}
}
