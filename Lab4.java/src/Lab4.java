import javax.swing.*;//The star means taking in everything
//Imports everything and javac will have a harder time
public class Lab4 {
    public static void main(String[] args) {
        String[] wordArray = { "hello", "goodbye", "cat", "dog", "red", "green", "sun", "moon" };
        String isOrIsNot, inputWord;
        while (true){
            inputWord = JOptionPane.showInputDialog(null, "Enter a word in all lower case or STOP to exit the program");
            if(inputWord.equalsIgnoreCase("stop")){//this i
                JOptionPane.showMessageDialog(null, "You are now leaving the program");
                break;
            }
            if (wordIsThere(inputWord, wordArray))//runs fucntion to see if word is in array
            //line above uses the function so you don't need to do == true/false
            isOrIsNot = "is";//since this is only one line, it isn't a block, it doesn't need {}
            else
            isOrIsNot = "is not";
            JOptionPane.showMessageDialog(null, "The word " + inputWord + " " + isOrIsNot + " on the list ");
        }
    }
       

    public static boolean wordIsThere(String findMe, String[] theList) { //parameters are input then word array
        for (String word : theList) { //for loop iterates the word array to the users input
            if (word.equals(findMe)) {
                return true;
            }
        }
        return false;
    }
}
