public class Student {

    //instance variables
        private String name;
        private int choice1;
        private int choice2;
        private int choice3;
        private int choice4;
        private int choice5;
        
    //constructor	
        public Student (String attName, int choiceOne, int choiceTwo, int choiceThree, int choiceFour, int choiceFive)
        {
            name = attName;
            choice1 = choiceOne;
            choice2 = choiceTwo;
            choice3 = choiceThree;
            choice4 = choiceFour;
            choice5 = choiceFive;
        }
        
    //getters and setters
        
        //get name
        public String getName() {
            return name;
        }
    
        public String getPick() {
            return "Choice 1: " + choice1 + ", " + "Choice 2: " + choice2 + ", " + "Choice 3: " + choice3 + ", " + "Choice 4: " + choice4 + ", " + "Choice 5: " + choice5 + ", ";
        }
    }