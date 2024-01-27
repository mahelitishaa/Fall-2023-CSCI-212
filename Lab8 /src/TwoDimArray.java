import java.util.StringTokenizer;


	public static int[][] myArray = {{1,2,3},{4,5,6},{7,8,9}};
	
	public static void main(String[] args) {
		printArray(myArray);
		printArrayEven(myArray);
	}
	private static void printArray (int[][] theArray) {
		for (int i=0; i<theArray.length; i++) {
			for (int j=0; j<theArray[i].length;j++)
				display(theArray[i][j]);
			System.out.println();
		}
	}
	private static void display (int num){
		System.out.print(num+" ");
	}
	private static void printArrayEven(int[][] theArray){
		for (int i=0; i<theArray.length; i++) {
			for (int j=0; j<theArray[i].length;j++){
				if (theArray[i][j]%2==0){
					display(theArray[i][j]);
				}
				else{
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}
	private static int [][] fillArray(String myFile){
		TextFileInput input= new TextFileInput(twodimension.txt);
		String line = input.readLine();
		StringTokenizer tokens = new StringTokenizer(line, ",");
		int rows = Integer.parseInt(tokens.nextToken());
		int cols = Integer.parseInt(tokens.nextToken ());
		int[][] matrix= new int [rows][cols];
		for (int r=0; r<rows; r++){
			line=input.readLine();
			tokens= new StringTokenizer(line, ",");
			for (int c=0; c<cols;c++){
				matrix[r][c]= Integer.parseInt(tokens.nextToken());
			}
		}
		input.close();
		return matrix;
	}

