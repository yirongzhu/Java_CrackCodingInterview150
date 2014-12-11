package chapter1;

public class EX1_6 {

//Given an image represented by an NxN matrix, where each pixel in the image is 4 
//bytes, write a method to rotate the image by 90 degrees Can you do this in place?
//rotate: time: O(n^2), space: in-place
//bugrotate: time: O(n^2), space: in-place
	
	public static void rotate (int[][] matrix) {
		int m = 0, n = matrix.length - 1;
		while (m < n) {
			for (int j = m, i = n; j < n && i > 0; j++, i--) {
				int a = matrix[m][j];
				int b = matrix[j][n];
				int c = matrix[n][i];
				matrix[m][j] = matrix[i][m];
				matrix[j][n] = a;
				matrix[n][i] = b;
				matrix[i][m] = c;
			}
			m++;
			n--;
		}
	}
	
	public static void bugrotate (int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int s = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = s;
			}
		}
		
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				int s = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = matrix[j][i];
				matrix[j][i] = s;
			}
		}
	}
	
	public static void main (String[] args){
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		bugrotate(matrix);
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
