/* Maheli Tisha 
 * CSCI 212 121E
 */
import javax.swing.*;
public class  Project0 {
    public static void main(String[] args) {
        // Run infinitely unless break condition satisfied
        while(true){
        String input= JOptionPane.showInputDialog(null,"Please enter a sentence.");
        // Need this so the program will break regardless of upper or lowercase in "stop"
        if (input.equalsIgnoreCase("Stop")){ 
            JOptionPane.showMessageDialog(null, "You are now exiting the program!");
            break;
        }
        //Declare the variables for the counters 
        int uppercaseE=0;
        int lowercaseE=0;
        //Loop through each letter in the input 
        for (int i=0; i<input.length();i++){ 
            //Need to hold the letter of the current i of the loop iteration
            char currentChar= input.charAt(i);
            if(currentChar=='E'){
                uppercaseE++;
            }
            else if(currentChar=='e'){
                lowercaseE++;
            }
        }
        JOptionPane.showMessageDialog(null, "Number of lower case e's: " + lowercaseE +"\nNumber of upper case e's: "+ uppercaseE);
       }
    }
}
