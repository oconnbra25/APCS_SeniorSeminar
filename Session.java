import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // Import the ArrayList utilities

public class Session {

    private int seshID;
    private int time;
    private int room;

    public Session (int sessionID, int timeSlot, int roomNum)
    {
        seshID = sessionID;
        time = timeSlot;
        room = roomNum;
    }

    ArrayList<Student> attendees = new ArrayList<Student>();
}
