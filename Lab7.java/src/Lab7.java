public class Lab7 {
    private static void printArray (int[][] theArray) {//print values in the file when read from main code
		for (int i=0; i<theArray.length; i++) {
			for (int j=0; j<theArray[i].length;j++)
				display(theArray[i][j]);
			System.out.println();
		}
	}
	private static void display (int num){
		System.out.print(num+" ");
	}
    public static void main(String[] args) {// The code that is going to read the file
        TextFileInput in = new TextFileInput("lab7input.txt");//The TextFileInput is the class name of the .txt file(has buffer reader)
        int row =Integer.parseInt(in.readLine());//Turns the string into an integer 
        int col =Integer.parseInt(in.readLine());

        int[][] array =new int [row][col];
        String s= in.readLine();
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                array[i][j] = Integer.parseInt(s);
                s= in.readLine();
            }
        }
        printArray(array);//refer to the method above and this print what you read in the file
    }
}
