
import java.io.*;
import java.util.*;

public class Television {
	
	public void changeChannel(Channel c)
	{
		switch (c)
		{
			case ABC:
				System.out.println("You are now watching ABC");
				break;
			case NATGEO:
				System.out.println("You are now watching National Geographic");
				break;
			case DISNEYJR:
				System.out.println("You are now watching Disney Junior");
				break;
			case FREEFORM:
				System.out.println("You are now watching Freeform");
				break;
			case ESPN:
				System.out.println("You are now watching ESPN");
				break;

		}
	}
	
	//Tester
	public static void main(String[]args)
	{
		Television tv = new Television();
		tv.changeChannel(Channel.ABC);
		
		Scanner s = new Scanner(System.in);
		System.out.println("Choose a channel to switch to: 10 (ABC), 11 (National Geographic), 12 (Disney Junior), 13 (Freeform), 14 (ESPN)");
		int input = s.nextInt();
		
		switch (input)
		{
			case 10:
				tv.changeChannel(Channel.ABC);
				break;
			case 11:
				tv.changeChannel(Channel.NATGEO);
				break;
			case 12:
				tv.changeChannel(Channel.DISNEYJR);
				break;
			case 13:
				tv.changeChannel(Channel.FREEFORM);
				break;
			case 14:
				tv.changeChannel(Channel.ESPN);
				break;

		}
	}
}
