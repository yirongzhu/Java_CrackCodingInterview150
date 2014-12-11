package chapter1;

public class EX1_7 {

//Write an algorithm such that if an element in an MxN matrix is 0, its entire row and 
//column is set to 0
//time: O(m*n), space: O(max{m,n})
	
	public static void replace0 (int[][] matrix, int m, int n) {
		boolean[] row = new boolean [m];
		boolean[] col = new boolean [n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}	
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (row[i] || col[j])
					matrix[i][j] = 0;
			}
		}
	}
	
	public static void main (String[] args) {
		int[][] matrix = {{1,0,1,0},{1,2,1,2},{1,1,2,1},{1,1,1,0}};
		replace0 (matrix, 4, 4);
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
