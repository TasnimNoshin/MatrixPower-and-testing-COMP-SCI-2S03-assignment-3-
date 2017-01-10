package cs2s03;


public class Matrix3x3rc {
      private Row3 mat;
      
      private class Row3{
    	  private Column3 row1;
    	  private Column3 row2;
    	  private Column3 row3;
    	  
    	  private Row3(long[] mat) {
    		  row1 = new Column3(mat[0],mat[1],mat[2]);
    		  row2 = new Column3(mat[3],mat[4],mat[5]);
    		  row3 = new Column3(mat[6],mat[7],mat[8]);
    	  }
      }
      
      private class Column3{
    	  long column1;
    	  long column2;
    	  long column3;
    	  
    	  private Column3(long x, long y , long z){
    		  column1 = x;
    		  column2 = y;
    		  column3 = z;
    	  }
      }
      
      private Matrix3x3rc(){
    	  }
      
      public Matrix3x3rc(long[] mat) throws WrongLength{
    	  
    	  if (mat.length != 9) throw new WrongLength(9,mat.length,"Matrix3x3rc");
    	  
    			this.mat= new Row3(mat);
    	  }
    	  
 
  	private long[] copyArray (long[] copy) {
  	
  		long[] copymat = copy ;
  		return copymat;
  	}
  	
  	public long[] toArray () {
  		long [] arr = {mat.row1.column1, mat.row1.column2, mat.row1.column3, 
  				       mat.row2.column1, mat.row2.column2, mat.row2.column3, 
  				       mat.row3.column1, mat.row3.column2, mat.row3.column3};
  		return arr;
  	}
  	
  	public Matrix3x3rc matrixpower(int i)throws WrongPower,WrongLength{
  		long [] arr = {mat.row1.column1, mat.row1.column2, mat.row1.column3, 
			           mat.row2.column1, mat.row2.column2, mat.row2.column3, 
			           mat.row3.column1, mat.row3.column2, mat.row3.column3};
  		long[] temp= copyArray(arr);
  		 if (i<0) throw new WrongPower(i, "Matrix3x3rc");
  		if (arr.length != 9) throw new WrongLength(9,arr.length,"Matrix3x3rc");
  		Matrix3x3rc result = new Matrix3x3rc();
  		long[] answer = new long[9];
  	  	if (i==0){
  	  		answer = identitymatrix();
  	  		result = new Matrix3x3rc(answer);
  	  		}
  	  	else if (i==1){
  	  		result = new Matrix3x3rc(arr);
  	  		}
  	  	if (i>1){
  	  		for(int power=2; power<=i;power++){
  	  			answer =  matrixmultiplication(temp);
  	  			temp = answer;
  	  			}
  	  		result= new Matrix3x3rc(answer);
  	  	}
  	  	
  	  	return result;
  	}
  	
  	private long[] identitymatrix(){
  		long[] identity = new long[9];
  		int rowNum = 3;
  		int diag = rowNum+1;
  		for(int i=0; i<9 ; i++){
  			if(i%diag==0){identity[i]=1;}
  			else{identity[i]=0;}
  		}
  		return identity;
  	}
  	
  	private long[] matrixmultiplication(long[] temp) {
  		
  		long[]  answer = new long[9];
  		int size = 3;
  		long[] arr = {mat.row1.column1, mat.row1.column2, mat.row1.column3, 
			          mat.row2.column1, mat.row2.column2, mat.row2.column3, 
			          mat.row3.column1, mat.row3.column2, mat.row3.column3};
  				 for (int nrows = 0; nrows < size; nrows++) {
  			            for (int ncols = 0; ncols < size; ncols++) {
  			                for (int k = 0; k < size; k++) {
  			                    answer[(nrows * size) + ncols] += arr[(nrows * size) + k] * temp[(k * size) + ncols];
  			                }
  			            }
  			        }
  		return answer;
  	}
      
      }
      
      
