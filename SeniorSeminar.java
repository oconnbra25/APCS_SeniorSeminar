import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // Import the ArrayList utilities

public class SeniorSeminar 
{
	//create array list
	ArrayList<Student> students = new ArrayList<Student>(); //list for the student
	
	public SeniorSeminar () 
	{
		//this try catch is reading the file 
		Scanner scan = new Scanner(System.in); //for keyboard inputs 
		try {
			File myObj = new File("CopyOf_SrSeminar_RawData.csv");
			Scanner myReader = new Scanner(myObj); //for the file inputs
            myReader.nextLine();
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] eachColumn = data.split(",");
				Student stu = new Student(eachColumn[0], Integer.parseInt(eachColumn[1]), Integer.parseInt(eachColumn[2]), Integer.parseInt(eachColumn[3]), Integer.parseInt(eachColumn[4]), Integer.parseInt(eachColumn[5]));
				students.add(stu);
				//System.out.println(data);
		}
		myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}

		int[] sessionsChoices = new int[19]; //to sort the choices tallies
		int[] sessionsID = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}; //to hold as a temp to know which tally goes where

        for (int x = 0; x < 74; x++) //printing out the kids and their choices
        {
            System.out.println(students.get(x).getName());
            System.out.println(students.get(x).getPickString());
        }
		
		for (int x = 0; x < 74; x++) //setting all the tallies
        {
			for (int y = 0; y < 5; y++)
			{
				sessionsChoices[students.get(x).getPickInt()[y]] += 1;
			}
		}

		for (int z = 1; z < 19; z++) //insertion sort
		{
			int x = z - 1;
			int tempo = sessionsChoices[z];
			int tempoID = sessionsID[z];
			while (x >= 0 && tempo < sessionsChoices[x]) //keeps shifting until tempo is in its place
			{
				sessionsChoices[x + 1] = sessionsChoices[x];
				sessionsID[x + 1] = sessionsID[x];
				x--;
			}
			sessionsChoices[x + 1] = tempo;
			sessionsID[x + 1] = tempoID;
		}

		for (int r = 0; r < 19; r++) //printing out all the tallies
		{
			System.out.println("Session" + sessionsID[r] + ": " + sessionsChoices[r]);
		}

		int[][] schedule = new int[5][5]; //arrayList to hold all the students

		int tempPointer = 18;
		for (int g = 0; g < 5; g++) //setting up schedule by ranking of total tallies
		{
			for (int h = 0; h < 5; h++)
			{
				if (sessionsID[tempPointer] == 0)
				{
					tempPointer--;
					schedule[h][g] = sessionsID[tempPointer];
					tempPointer--;
				}
				else if (tempPointer == 0)
				{
					schedule[h][g] = sessionsID[tempPointer];
					tempPointer = 18;
				}
				else
				{
					schedule[h][g] = sessionsID[tempPointer];
					tempPointer--;
				}
				
			}
		}

		ArrayList<Session> sessions = new ArrayList<Session>(); //list for sessions
		for (int g = 0; g < 5; g++) //creating sessions
		{
			for (int h = 0; h < 5; h++)
			{
				if ((g == 3 && h < 2) || (g > 3))
				{
					Session String.valueOf(schedule[h][g] * 20) = new Session(h, g);
				}
				//System.out.println(schedule[h][g]);
			}
		}

		for (int c = 0; c < 74; c++) //adding students to the schedule
		{
			for (int a = 0; a < 5; a++) //iterating through the schedule
			{
				int tempTime = 0; //to hold which row
				for (int s = 0; s < 5; s++) //iterating through the choices
				{
					if (schedule[tempTime][a] == students.get(c).getPickInt()[s])
					{
						
					}
				}
				
				
			}
		}
	}
}