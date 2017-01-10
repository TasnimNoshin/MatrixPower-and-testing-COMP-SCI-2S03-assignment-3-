package cs2s03;

import static org.junit.Assert.*;
import org.junit.Test;

public class Testing {
	//test cases 
    public static long[] m01 = {0,1,2,3,4,5,6,7,8};
    public static long[] m02 = {0,2,3,0,0,0,0,0,0};//square of this matrix is 0
    public static long[] m03 = {0,3,6,9,12,15,18,21,24};
    public static long[] m04 = {0,2,4,6,8,10,12,14,16};
    public static long[] m05 = {0,5,10,15,20,25,30,35,40};
    public static long[] m06 = {1,4,7,10,13,16,19,22,25};
    public static long[] m07 = {0,0,0,0,0,0,0,0,0};//square of this matrix is 0
    public static long[] m08 = {2,5,8,11,14,17,20,23,26};
    public static long[] m09 = {1,2,3,4,5,6,7,8,9};
    public static long[] m10 = {3,4,5,6,7,8,9,10,11};
    
    //identity matrix
    public static long[] mIdentity = {1,0,0,0,1,0,0,0,1};
    
    //square of the matrices
    public static long[] m01Sqr={15,18,21,42,54,66,69,90,111};
    public static long[] m02Sqr={0,0,0,0,0,0,0,0,0};
    public static long[] m03Sqr={135,162,189,378,486,594,621,810,999};
    public static long[] m04Sqr={60,72,84,168,216,264,276,360,444};
    public static long[] m05Sqr={375,450,525,1050,1350,1650,1725,2250,2775};
    public static long[] m06Sqr={174,210,246,444,561,678,714,912,1110};
    public static long[] m07Sqr={0,0,0,0,0,0,0,0,0};
    public static long[] m08Sqr={219,264,309,516,642,768,813,1020,1227};
    public static long[] m09Sqr={30,36,42,66,81,96,102,126,150};
    public static long[] m10Sqr={78,90,102,132,153,174,186,216,246};
	
    //cube of the matrices
     public static long[] m01Cube={180,234,288,558,720,882,936,1206,1476};
     public static long[] m02Cube={0,0,0,0,0,0,0,0,0};
     public static long[] m03Cube={4860,6318,7776,15066,19440,23814,25272,32562,39852};
     public static long[] m04Cube={1440,1872,2304,4464,5760,7056,7488,9648,11808};
     public static long[] m05Cube={22500,29250,36000,69750,90000,110250,117000,150750,184500};
     public static long[] m06Cube={7531,9729,11706,21760,27988,33589,34910,44841,53772};
     public static long[] m07Cube={0,0,0,0,0,0,0,0,0};
     public static long[] m08Cube={9522,11898,14274,23454,29232,35010,37386,46566,55746};
     public static long[] m09Cube={468,576,684,1062,1305,1548,1656,2034,2412}; 
     public static long[] m10Cube={1692,1962,2232,2880,3339,3798,4068,4716,5364};
    
     @Test (expected = WrongPower.class)
     public void test() throws WrongLength,WrongPower{
    	 long [] [] matrices = { m01, m02, m03, m04, m05,
                                 m06, m07, m08, m09, m10 };
         long [] [] square =   { m01Sqr, m02Sqr, m03Sqr, m04Sqr, m05Sqr,
                                 m06Sqr, m07Sqr, m08Sqr, m09Sqr, m10Sqr };
         long [] [] cube =     { m01Cube, m02Cube, m03Cube, m04Cube, m05Cube,
        		                 m06Cube, m07Cube, m08Cube, m09Cube, m10Cube };
       //testing Matrix3x3flat
 		for (int index = 0; index < 10 ; index++) {
 			Matrix3x3flat mat = new Matrix3x3flat (matrices[index]);
 			mat.matrixpower(-1);
 			assertArrayEquals(mIdentity,(mat.matrixpower(0)).toArray());
 			assertArrayEquals(matrices[index],(mat.matrixpower(1)).toArray());
 			assertArrayEquals(square[index],(mat.matrixpower(2)).toArray());
 			assertArrayEquals(cube[index],(mat.matrixpower(3)).toArray());
 		}
 		
 		//testing Matrix3x3rc
 		for (int index = 0; index < 10 ; index++) {
 			Matrix3x3rc mat = new Matrix3x3rc(matrices[index]);
 			mat.matrixpower(-1);
 			assertArrayEquals(mIdentity,(mat.matrixpower(0)).toArray());
 			assertArrayEquals(matrices[index],(mat.matrixpower(1)).toArray());
 			assertArrayEquals(square[index],(mat.matrixpower(2)).toArray());
 			assertArrayEquals(cube[index],(mat.matrixpower(3)).toArray());;
 		}
 		
 		//testing Matrix3x3cr
 		for (int index = 0; index < 10 ; index++) {

 			Matrix3x3cr mat = new Matrix3x3cr(matrices[index]);
 			mat.matrixpower(-1);
 			assertArrayEquals(mIdentity,(mat.matrixpower(0)).toArray());
 			assertArrayEquals(matrices[index],(mat.matrixpower(1)).toArray());
 			assertArrayEquals(square[index],(mat.matrixpower(2)).toArray());
 			assertArrayEquals(cube[index],(mat.matrixpower(3)).toArray());;
 		}
 		
 		//testing MatrixArrayFlat
 		for (int index = 0; index < 10 ; index++) {
 			MatrixArrayFlat mat = new MatrixArrayFlat(matrices[index]);
 			mat.matrixpower(-1);
 			assertArrayEquals(mIdentity,(mat.matrixpower(0)).toArray());
 			assertArrayEquals(matrices[index],(mat.matrixpower(1)).toArray());
 			assertArrayEquals(square[index],(mat.matrixpower(2)).toArray());
 			assertArrayEquals(cube[index],(mat.matrixpower(3)).toArray());;
 		}
 		
 		//testing MatrixArrayRC
 		for (int index = 0; index < 10 ; index++) {
 			MatrixArrayRC mat = new MatrixArrayRC(matrices[index]);
 			mat.matrixpower(-1);
 			assertArrayEquals(mIdentity,(mat.matrixpower(0)).toArray());
 			assertArrayEquals(matrices[index],(mat.matrixpower(1)).toArray());
 			assertArrayEquals(square[index],(mat.matrixpower(2)).toArray());
 			assertArrayEquals(cube[index],(mat.matrixpower(3)).toArray());;
 		}
 		
 		//testing MatrixArrayCR
 		for (int index = 0; index < 10 ; index++) {
 			MatrixArrayCR mat = new MatrixArrayCR(matrices[index]);
 			mat.matrixpower(-1);
 			assertArrayEquals(mIdentity,(mat.matrixpower(0)).toArray());
 			assertArrayEquals(matrices[index],(mat.matrixpower(1)).toArray());
 			assertArrayEquals(square[index],(mat.matrixpower(2)).toArray());
 			assertArrayEquals(cube[index],(mat.matrixpower(3)).toArray());;
 		}
 		
 		//use Matrix3x3flat to create an array of 3x3 flat matrices
 		Matrix3x3flat [] mat3x3flat = {  new Matrix3x3flat (m01), 
                                         new Matrix3x3flat (m02), 
                                         new Matrix3x3flat (m03), 
                                         new Matrix3x3flat (m04), 
                                         new Matrix3x3flat (m05), 
                                         new Matrix3x3flat (m06), 
                                         new Matrix3x3flat (m07), 
                                         new Matrix3x3flat (m08), 
                                         new Matrix3x3flat (m09), 
                                         new Matrix3x3flat (m10)  };
 		
 		   //use Matrix3x3rc to create an array of 3x3 flat matrices
 		   Matrix3x3rc [] mat3x3rc = {  new Matrix3x3rc (m01), 
                                        new Matrix3x3rc (m02), 
                                        new Matrix3x3rc (m03), 
                                        new Matrix3x3rc (m04), 
                                        new Matrix3x3rc (m05), 
                                        new Matrix3x3rc (m06), 
                                        new Matrix3x3rc (m07), 
                                        new Matrix3x3rc (m08), 
                                        new Matrix3x3rc (m09), 
                                        new Matrix3x3rc (m10)  };
 		
 		   //use Matrix3x3cr to create an array of 3x3 flat matrices
 		   Matrix3x3cr [] mat3x3cr = {  new Matrix3x3cr (m01), 
                                        new Matrix3x3cr (m02), 
                                        new Matrix3x3cr (m03), 
                                        new Matrix3x3cr (m04), 
                                        new Matrix3x3cr (m05), 
                                        new Matrix3x3cr (m06), 
                                        new Matrix3x3cr (m07), 
                                        new Matrix3x3cr (m08), 
                                        new Matrix3x3cr (m09), 
                                        new Matrix3x3cr (m10)  };
 		   
 		//use MatrixArrayFlat to create an array of 3x3 flat matrices
 		  MatrixArrayFlat [] matArrayFlat = {  new MatrixArrayFlat (3,m01), 
                                        	   new MatrixArrayFlat (3,m02), 
                                        	   new MatrixArrayFlat (3,m03), 
                                        	   new MatrixArrayFlat (3,m04), 
                                        	   new MatrixArrayFlat (3,m05), 
                                        	   new MatrixArrayFlat (3,m06), 
                                        	   new MatrixArrayFlat (3,m07), 
                                        	   new MatrixArrayFlat (3,m08), 
                                        	   new MatrixArrayFlat (3,m09), 
                                        	   new MatrixArrayFlat (3,m10)  };
 		  
 		//use MatrixArrayRC to create an array of 3x3 flat matrices
 		 MatrixArrayRC [] matArrayRC = {  new MatrixArrayRC (3,m01), 
                                          new MatrixArrayRC (3,m02), 
                                          new MatrixArrayRC (3,m03), 
                                          new MatrixArrayRC (3,m04), 
                                          new MatrixArrayRC (3,m05), 
                                          new MatrixArrayRC (3,m06), 
                                          new MatrixArrayRC (3,m07), 
                                          new MatrixArrayRC (3,m08), 
                                          new MatrixArrayRC (3,m09), 
                                          new MatrixArrayRC (3,m10)  };
 		 
 		//use MatrixArrayCR to create an array of 3x3 flat matrices
 		MatrixArrayCR [] matArrayCR = {  new MatrixArrayCR (3,m01), 
                                         new MatrixArrayCR (3,m02), 
                                         new MatrixArrayCR (3,m03), 
                                         new MatrixArrayCR (3,m04), 
                                         new MatrixArrayCR (3,m05), 
                                         new MatrixArrayCR (3,m06), 
                                         new MatrixArrayCR (3,m07), 
                                         new MatrixArrayCR (3,m08), 
                                         new MatrixArrayCR (3,m09), 
                                         new MatrixArrayCR (3,m10)  };
 		
 		// Matrix3x3flat against all 
 		for(int index=0; index<10;index++){
 			for(int power=-1;power<=3;power++){
 				assertArrayEquals(mat3x3flat[index].matrixpower(power).toArray(),mat3x3flat[index].matrixpower(power).toArray());
 				assertArrayEquals(mat3x3flat[index].matrixpower(power).toArray(),mat3x3rc[index].matrixpower(power).toArray());
 				assertArrayEquals(mat3x3flat[index].matrixpower(power).toArray(),mat3x3cr[index].matrixpower(power).toArray());
 				assertArrayEquals(mat3x3flat[index].matrixpower(power).toArray(),matArrayFlat[index].matrixpower(power).toArray());
 				assertArrayEquals(mat3x3flat[index].matrixpower(power).toArray(),matArrayRC[index].matrixpower(power).toArray());
 				assertArrayEquals(mat3x3flat[index].matrixpower(power).toArray(),matArrayCR[index].matrixpower(power).toArray());
 			}
 		}
 		
 	// Matrix3x3rc against all 
 	 		for(int index=0; index<10;index++){
 	 			for(int power=-1;power<=3;power++){
 	 				assertArrayEquals(mat3x3rc[index].matrixpower(power).toArray(),mat3x3flat[index].matrixpower(power).toArray());
 	 				assertArrayEquals(mat3x3rc[index].matrixpower(power).toArray(),mat3x3rc[index].matrixpower(power).toArray());
 	 				assertArrayEquals(mat3x3rc[index].matrixpower(power).toArray(),mat3x3cr[index].matrixpower(power).toArray());
 	 				assertArrayEquals(mat3x3rc[index].matrixpower(power).toArray(),matArrayFlat[index].matrixpower(power).toArray());
 	 				assertArrayEquals(mat3x3rc[index].matrixpower(power).toArray(),matArrayRC[index].matrixpower(power).toArray());
 	 				assertArrayEquals(mat3x3rc[index].matrixpower(power).toArray(),matArrayCR[index].matrixpower(power).toArray());
 	 			}
 	 		}
 	
 	 	// Matrix3x3cr against all 
 	 		for(int index=0; index<10;index++){
 	 			for(int power=-1;power<=3;power++){
 	 				assertArrayEquals(mat3x3cr[index].matrixpower(power).toArray(),mat3x3flat[index].matrixpower(power).toArray());
 	 				assertArrayEquals(mat3x3cr[index].matrixpower(power).toArray(),mat3x3rc[index].matrixpower(power).toArray());
 	 				assertArrayEquals(mat3x3cr[index].matrixpower(power).toArray(),mat3x3cr[index].matrixpower(power).toArray());
 	 				assertArrayEquals(mat3x3cr[index].matrixpower(power).toArray(),matArrayFlat[index].matrixpower(power).toArray());
 	 				assertArrayEquals(mat3x3cr[index].matrixpower(power).toArray(),matArrayRC[index].matrixpower(power).toArray());
 	 				assertArrayEquals(mat3x3cr[index].matrixpower(power).toArray(),matArrayCR[index].matrixpower(power).toArray());
 	 			}
 	 		}
 	 		
 	 	// MatrixArrayFlat against all 
 	 		for(int index=0; index<10;index++){
 	 			for(int power=-1;power<=3;power++){
 	 				assertArrayEquals(matArrayFlat[index].matrixpower(power).toArray(),mat3x3flat[index].matrixpower(power).toArray());
 	 				assertArrayEquals(matArrayFlat[index].matrixpower(power).toArray(),mat3x3rc[index].matrixpower(power).toArray());
 	 				assertArrayEquals(matArrayFlat[index].matrixpower(power).toArray(),mat3x3cr[index].matrixpower(power).toArray());
 	 				assertArrayEquals(matArrayFlat[index].matrixpower(power).toArray(),matArrayFlat[index].matrixpower(power).toArray());
 	 				assertArrayEquals(matArrayFlat[index].matrixpower(power).toArray(),matArrayRC[index].matrixpower(power).toArray());
 	 				assertArrayEquals(matArrayFlat[index].matrixpower(power).toArray(),matArrayCR[index].matrixpower(power).toArray());
 	 			}
 	 		}
 	 
 	 	// MatrixArrayRC against all 
 	 		for(int index=0; index<10;index++){
 	 			for(int power=-1;power<=3;power++){
 	 				assertArrayEquals(matArrayRC[index].matrixpower(power).toArray(),mat3x3flat[index].matrixpower(power).toArray());
 	 				assertArrayEquals(matArrayRC[index].matrixpower(power).toArray(),mat3x3rc[index].matrixpower(power).toArray());
 	 				assertArrayEquals(matArrayRC[index].matrixpower(power).toArray(),mat3x3cr[index].matrixpower(power).toArray());
 	 				assertArrayEquals(matArrayRC[index].matrixpower(power).toArray(),matArrayFlat[index].matrixpower(power).toArray());
 	 				assertArrayEquals(matArrayRC[index].matrixpower(power).toArray(),matArrayRC[index].matrixpower(power).toArray());
 	 				assertArrayEquals(matArrayRC[index].matrixpower(power).toArray(),matArrayCR[index].matrixpower(power).toArray());
 	 			}
 	 		}
 	 		
 	 	// MatrixArrayCR against all 
 	 		for(int index=0; index<10;index++){
 	 			for(int power=-1;power<=3;power++){
 	 				assertArrayEquals(matArrayCR[index].matrixpower(power).toArray(),mat3x3flat[index].matrixpower(power).toArray());
 	 				assertArrayEquals(matArrayCR[index].matrixpower(power).toArray(),mat3x3rc[index].matrixpower(power).toArray());
 	 				assertArrayEquals(matArrayCR[index].matrixpower(power).toArray(),mat3x3cr[index].matrixpower(power).toArray());
 	 				assertArrayEquals(matArrayCR[index].matrixpower(power).toArray(),matArrayFlat[index].matrixpower(power).toArray());
 	 				assertArrayEquals(matArrayCR[index].matrixpower(power).toArray(),matArrayRC[index].matrixpower(power).toArray());
 	 				assertArrayEquals(matArrayCR[index].matrixpower(power).toArray(),matArrayCR[index].matrixpower(power).toArray());
 	 			}
 	 		}
	}

}
