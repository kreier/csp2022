/*
16
 * Reg Hahne
 * Generating pairs of random numbers
 */

import java.util.ArrayList;
import java.util.List;

public class NumGenerator
{
	private List<Integer> randomizedList;
	private int classSize, groupSize; 
	
	public NumGenerator(int c, int g)
	{
		classSize = c;
		groupSize = g;
		randomizedList = new ArrayList<Integer>();
		randomizeAndPlace();
	}
	
	//Randomize a number and place in position
	private void randomizeAndPlace()
	{
		int numGenerated, position;
		
		//Place first randomized number in position 0
		randomizedList.add(1 + (int)(Math.random() * classSize));
		//Run through current ArrayList to make sure number does not exist and add to ArrayList
		for(int pos = 1; pos < classSize; pos++)
		{
			//Check to make sure randomized number does not already exist
			numGenerated = 1 + (int)(Math.random() * classSize);
			position = 0;
			while(position < randomizedList.size())
			{
				if(randomizedList.get(position) == numGenerated)
				{
					numGenerated = 1 + (int)(Math.random() * classSize);
					while(randomizedList.get(position) == numGenerated)
						numGenerated = 1 + (int)(Math.random() * classSize);
					position = 0;
				}
				else
					position++;
			}
			//Place number in pos in randomizedList
			randomizedList.add(numGenerated);
		}
	}
		
	public String toString()
	{
		String str = new String();
		if(classSize % groupSize == 0)
		{
			if(groupSize == 2)
			{
				for(int pos = 0; pos < randomizedList.size(); pos += groupSize)
				{
					str += randomizedList.get(pos) + " <--> " + randomizedList.get(pos + 1) +"\n";
				}
			}
			else if(groupSize == 3)
			{
				for(int pos = 0; pos < randomizedList.size(); pos += groupSize)
				{
					str += randomizedList.get(pos) + " <-- " + randomizedList.get(pos + 1) + " --> " + randomizedList.get(pos + 2) + "\n";
				}
			}
		}
		else if(classSize % groupSize == 1)
		{
			if(groupSize == 2)
			{
				for(int pos = 0; pos < randomizedList.size() - 1; pos += groupSize)
				{
					str += randomizedList.get(pos) + " <--> " + randomizedList.get(pos + 1) +"\n";
				}
				str += randomizedList.get(randomizedList.size() - 1);
			}
			else if(groupSize == 3)
			{
				for(int pos = 0; pos < randomizedList.size() - 1; pos += groupSize)
				{
					str += randomizedList.get(pos) + " <-- " + randomizedList.get(pos + 1) + " --> " 
							+ randomizedList.get(pos + 2) + "\n";
					if(pos == randomizedList.size() - 4)
						break;
				}
				str += randomizedList.get(randomizedList.size() - 1);
			}
		}
		else if(classSize % groupSize == 2)
		{
			if(groupSize == 3)
			{
				for(int pos = 0; pos < randomizedList.size(); pos += groupSize)
				{
					str += randomizedList.get(pos) + " <-- " + randomizedList.get(pos + 1) + " --> " 
							+ randomizedList.get(pos + 2) + "\n";
					if(pos == randomizedList.size() - 5)
						break;
				}
				str += randomizedList.get(randomizedList.size() - 2) + " <--> " + randomizedList.get(randomizedList.size() - 1) +"\n";;
			}
		}
		return str;
	}
}
