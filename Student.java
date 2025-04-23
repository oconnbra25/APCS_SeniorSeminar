import java.util.ArrayList;

public class Student {

    //instance variables
        final private String name;
        private int choice1;
        private int choice2;
        private int choice3;
        private int choice4;
        private int choice5;
        ArrayList<Session> schedule = new ArrayList<Session>();
        private int[] choices = new int[5];
        
        
    //constructor	
        public Student (String attName, int choiceOne, int choiceTwo, int choiceThree, int choiceFour, int choiceFive)
        {
            name = attName;
            choice1 = choiceOne;
            choice2 = choiceTwo;
            choice3 = choiceThree;
            choice4 = choiceFour;
            choice5 = choiceFive;
            choices[0] = choice1;
            choices[1] = choice2;
            choices[2] = choice3;   //these are here to later return the array list of choices all in one go and also to find which picks have been fixed
            choices[3] = choice4;
            choices[4] = choice5;
        }
        
    //getters and setters
        
        //get name
        public String getName() {
            return name;
        }
    
        public String getPickString() {
            return "Choice 1: " + choice1 + ", " + "Choice 2: " + choice2 + ", " + "Choice 3: " + choice3 + ", " + "Choice 4: " + choice4 + ", " + "Choice 5: " + choice5 + ", ";
        }

        public int[] getPickInt() {
            return choices;
        }

        public void setSession(Session temp) {
            schedule.add(temp);
        }

        public void setPickInt(int place) { //zero is a placeholder to show which sessions a student got that they picked
            choices[place] = 0;
        }
    }