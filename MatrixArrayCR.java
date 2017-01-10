package cs2s03;

public class MatrixArrayCR {

		private long[][] mat;
		private int size;
		
		public MatrixArrayCR(){
			
		}
		
		public MatrixArrayCR(long[] mat)throws WrongLength{
			if (mat.length != 9) throw new WrongLength(9,mat.length,"MatrixArrayCR");
			this.mat = new long[size][size];
			int len = 0;
			for(int col=0; col<size;col++){
				for(int row=0; row<size; row++){
					this.mat[row][col] = mat[len];
					len++;
				}
			}
		}
		
		public MatrixArrayCR(int n, long[] mat)throws WrongLength{
			if (mat.length != (n*n)) throw new WrongLength((n*n),mat.length,"MatrixArrayCR");
			this.size = n;
			this.mat = new long[size][size];
			
			int len = 0;
			for(int col=0; col<size;col++){  
				
				for(int row=0; row<size; row++){
					this.mat[row][col] = mat[len];  
					len += 1 ;
				}
			}
		}
		
		private long[] copyArray (long[] copy) {
			
			long[] copymat = copy;
			return copymat;
		}
		
		public long[] toArray () {
			long [] arr = new long[size*size];
			int len = 0;
			for(int col=0; col<size;col++){
				for(int row=0; row<size; row++){
					arr[len] = this.mat[row][col];
					len++;
				}
			}
			return arr;
		}
		
		public MatrixArrayCR matrixpower(int i) throws WrongLength,WrongPower{
			MatrixArrayCR result = new MatrixArrayCR();
			
			if (i<0) throw new WrongPower(i, "MatrixArrayCR");
	  		if (mat.length != (size*size)) throw new WrongLength((size*size),mat.length,"MatrixArrayCR");
			long[] answer = new long[size];
			long [] arr = new long[size*size];
			int len = 0;
			for(int col=0; col<size;col++){
				for(int row=0; row<size; row++){
					arr[len] = this.mat[row][col];
					len++;
				}
			}
			
			if (i<0) throw new WrongPower(i, "MatrixArrayFlat");
	  		if (arr.length != (size*size)) throw new WrongLength((size*size),arr.length,"MatrixArrayFlat");
			long[] temp= copyArray(arr);
		  	if (i==0){
		  		answer = identitymatrix();
		  		result = new MatrixArrayCR(size,answer);
		  		}
		  	else if (i==1){
		  		result = new MatrixArrayCR(size,arr);
		  		}
		  	if (i>1){
		  		for(int power=2; power<=i;power++){
		  			answer = matrixmultiplication(temp);
		  			temp=answer;
		  			}
		  		result =  new MatrixArrayCR(size,answer);
		  	}
		  	return result;
		}
		
		private long[] identitymatrix(){
			long[] identity = new long[size*size];
			int rowNum = size;
			int diag = rowNum+1;
			for(int i=0; i<size*size ; i++){
				if(i%diag==0){identity[i]=1;}
				else{identity[i]=0;}
			}
			return identity;
		}
		
		private long[] matrixmultiplication(long[] temp){
			long [] arr = new long[size*size];
			int len = 0;
			for(int col=0; col<size;col++){
				for(int row=0; row<size; row++){
					arr[len] = this.mat[row][col];
					len++;
				}
			}
			long[] answer = new long[size*size];
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


