import java.util.*;
public class Lab8 {
    public static TextFileInput myFile;
    public static StringTokenizer myTokens;
    public static int[][] array;
    public static String line;
        public static void main(String[] args) {
        myFile = new TextFileInput("twodimension8.txt");
        line= myFile.readLine();// reads the first line to get the amount of rows and columns 
        myTokens= new StringTokenizer(line,"," );
        int r = Integer.parseInt(myTokens.nextToken());
        int c= Integer.parseInt(myTokens.nextToken());

        array =new int[r][c];
        line = myFile.readLine();

        for (int i=0; i<r; i++){
            myTokens= new StringTokenizer(line,"," );
            for (int j=0; j<c; j++){
                array[i][j]= Integer.parseInt(myTokens.nextToken());
            }
            line = myFile.readLine();
        }
        for (int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    
    } //main
} 
    
    
    