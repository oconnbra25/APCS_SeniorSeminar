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

        for (int x = 0; x < 75; x++)
        {
            System.out.println(students.get(0).getName());
            System.out.println(students.get(0).getPick());
        }
    }
}