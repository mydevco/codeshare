package com.mydevco.javabp.language;

public class VarDimArray {

	public static void main(String[] args) {
		int[][] varDim = new int[3][];
		
		varDim[0] = new int[]{1,2,3,4};
		
		varDim[1] = new int[]{5,6,7,8,9,10};
		
		varDim[2] = new int[]{11,12};
		
		for(int x = 0; x < varDim.length; x++) {
			for(int y =0; y < varDim[x].length; y++) {
				System.out.println(varDim[x][y]);
			}
		}
		
		System.out.println("-----------------------------------------------");
		varDim[0] = new int[]{1,2,3,4, 5,6};
		
		varDim[1] = new int[]{7,8,9};
		
		varDim[2] = new int[]{10,11,12};
		
		for(int x = 0; x < varDim.length; x++) {
			for(int y =0; y < varDim[x].length; y++) {
				System.out.println(varDim[x][y]);
			}
		}
		
	}

}
