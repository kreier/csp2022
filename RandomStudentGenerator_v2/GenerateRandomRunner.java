/*
 * Reg Hahne
 * Generating pairs of random numbers
 * 7/29/2018
 * 6/10/2019
 * 1/6/2020
 */

import java.util.Scanner;

public class GenerateRandomRunner 
{
	public static void main(String[] args) 
	{
		NumGenerator myNumGenerator;
		int numParticipants, teamSize;
		Scanner inData = new Scanner(System.in);
		
		System.out.print("Please enter the total number of participants --> ");
		numParticipants = inData.nextInt();
		System.out.print("Please enter the number of participants per group --> ");
		teamSize = inData.nextInt();
		myNumGenerator = new NumGenerator(numParticipants, teamSize);
		System.out.print(myNumGenerator);
		inData.close();
	}
}
