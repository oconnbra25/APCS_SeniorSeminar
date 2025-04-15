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
		int[] sessionsID = new int[19]; //to hold as a temp to know which tally goes where

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

		for (int r = 0; r < 20; r++) //printing out all the tallies
		{
			System.out.println("Session" + r + ": " + sessionsChoices[r]);
		}

		for (int z = 1; z < 20; z++) //insertion sort
		{
			int x = z - 1;
			int tempo = sessionsChoices[z];
			while (x >= 0 && tempo < sessionsChoices[x]) //keeps shifting until tempo is in its place
			{
				sessionsChoices[x + 1] = sessionsChoices[x];
				sessionsID[x + 1] = sessionsID[x];
				x--;
			}
			sessionsChoices[x + 1] = tempo;
			sessionsID[x + 1] = tempo;
		}

		for (int r = 0; r < 20; r++) //printing out all the tallies
		{
			System.out.println("Session" + sessionsID[r] + ": " + sessionsChoices[r]);
		}
    }
}