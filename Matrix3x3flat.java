package cs2s03;

public class Matrix3x3flat {
	private Record9 mat ;
	
	private class Record9{
		long num1;
		long num2;
		long num3;
		long num4;
		long num5;
		long num6;
		long num7;
		long num8;
		long num9;
		
		private Record9 (long[] mat) {
			num1 = mat[0];
			num2 = mat[1];
			num3 = mat[2];
			num4 = mat[3];
			num5 = mat[4];
			num6 = mat[5];
			num7 = mat[6];
			num8 = mat[7];
			num9 = mat[8];
		}
	}
	
	private Matrix3x3flat(){
		}
	
	public Matrix3x3flat(long[] mat) throws WrongLength{
		
  		if (mat.length != 9) throw new WrongLength(9,mat.length,"Matrix3x3flat");
		this.mat= new Record9(mat);
	}
	
	private long[] copyArray (long[] copy) {
  		
  		long[] copymat = copy;
  		return copymat;
  	}
	
	public long[] toArray () {
		long [] arr = {mat.num1, mat.num2, mat.num3,
				       mat.num4, mat.num5, mat.num6, 
				       mat.num7, mat.num8, mat.num9};
		return arr;
	}
	
	public Matrix3x3flat matrixpower(int i) throws WrongPower, WrongLength{
  		long [] arr = {mat.num1, mat.num2, mat.num3,
			           mat.num4, mat.num5, mat.num6, 
			           mat.num7, mat.num8, mat.num9};
		if (i<0) throw new WrongPower(i, "MatrixArrayFlat");
  		if (arr.length != 9) throw new WrongLength(9,arr.length,"MatrixArrayFlat");
  		Matrix3x3flat result = new Matrix3x3flat();
		long[] answer = new long[9];
		long[] temp= copyArray(arr);
	  	if (i==0){
	  		answer = identitymatrix();
	  		result = new Matrix3x3flat(answer);
	  		}
	  	else if (i==1){
	  		result = new Matrix3x3flat(arr);
	  		}
	  	if (i>1){
	  		for(int power=2; power<=i;power++){
	  			answer = matrixmultiplication(temp);
	  			temp=answer;
	  			}
	  		result =  new Matrix3x3flat(answer);
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
	
	private long[] matrixmultiplication(long[] temp){
		
		long[]  answer = new long[9];
		int size = 3;
		long[] arr = {mat.num1, mat.num2, mat.num3,
			          mat.num4, mat.num5, mat.num6, 
			          mat.num7, mat.num8, mat.num9};
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


