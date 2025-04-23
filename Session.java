import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // Import the ArrayList utilities

public class Session {

    private int time;
    private int room;
    private int seshID;

    public Session (int timeSlot, int roomNum, int ID)
    {
        time = timeSlot;
        room = roomNum;
        seshID = ID;
    }

    ArrayList<Student> attendees = new ArrayList<Student>();

    public void addStudent(Student attend)
    {
        attendees.add(attend);
    }

    public int getID() {
        return seshID;
    }
}
