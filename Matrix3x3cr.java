package cs2s03;

public class Matrix3x3cr {
      private Column3 mat;
      
      private class Column3{
    	  private Row3 column1;
    	  private Row3 column2;
    	  private Row3 column3;
    	  
    	  private Column3(long[] mat){
    		  column1 = new Row3(mat[0],mat[3],mat[6]);
    		  column2 = new Row3(mat[1],mat[4],mat[7]);
    		  column3 = new Row3(mat[2],mat[5],mat[8]);
    	  }
      }
      
      private class Row3{
    	  long row1;
    	  long row2;
    	  long row3;
    	  
    	  private Row3(long x, long y , long z){
    		  row1 = x;
    		  row2 = y;
    		  row3 = z;
    	  }
      }
      
      private Matrix3x3cr(){
    	  }
      
      public Matrix3x3cr(long[] mat) throws WrongLength{
    		if (mat.length != 9) throw new WrongLength(9,mat.length,"Matrix3x3cr");
    			this.mat= new Column3(mat);
    	  }
    	  
 
      private long[] copyArray (long[] copy) {
  		
  		long[] copymat = copy;
  		return copymat;
  	}
  	
  	public long[] toArray () {
  		long [] arr = {mat.column1.row1, mat.column2.row1, mat.column3.row1, 
  				       mat.column1.row2, mat.column2.row2, mat.column3.row2, 
  				       mat.column1.row3, mat.column2.row3, mat.column3.row3};
  		return arr;
  	}
  	
  	public Matrix3x3cr matrixpower(int i) throws WrongPower, WrongLength{
  		long [] arr = {mat.column1.row1, mat.column2.row1, mat.column3.row1, 
			       mat.column1.row2, mat.column2.row2, mat.column3.row2, 
			       mat.column1.row3, mat.column2.row3, mat.column3.row3};
		if (i<0) throw new WrongPower(i, "MatrixArrayFlat");
  		if (arr.length != 9) throw new WrongLength(9,arr.length,"MatrixArrayFlat");
		Matrix3x3cr result = new Matrix3x3cr();
		long[] answer = new long[9];
		long[] temp= copyArray(arr);
	  	if (i==0){
	  		answer = identitymatrix();
	  		result = new Matrix3x3cr(answer);
	  		}
	  	else if (i==1){
	  		result = new Matrix3x3cr(arr);
	  		}
	  	if (i>1){
	  		for(int power=2; power<=i;power++){
	  			answer = matrixmultiplication(temp);
	  			temp=answer;
	  			}
	  		result =  new Matrix3x3cr(answer);
	  	}
	  	
	  	return result;
	}
  	
  	private long[] identitymatrix() {
  		long[] identity = new long[9];
  		int rowNum = 3;
  		int diag = rowNum+1;
  		for(int i=0; i<9 ; i++){
  			if(i%diag==0){identity[i]=1;}
  			else{identity[i]=0;}
  		}
  		return identity;
  	}
  	
  	private long[] matrixmultiplication(long[] temp){
  		long[]  answer = new long[9];
  		int size = 3;
  		long[] arr = {mat.column1.row1, mat.column2.row1, mat.column3.row1, 
			          mat.column1.row2, mat.column2.row2, mat.column3.row2, 
			          mat.column1.row3, mat.column2.row3, mat.column3.row3};
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
      
      
