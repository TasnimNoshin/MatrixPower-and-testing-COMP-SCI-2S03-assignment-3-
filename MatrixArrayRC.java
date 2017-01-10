package cs2s03;

public class MatrixArrayRC {

		private long[][] mat;
		private int size;
		
		public MatrixArrayRC(){
			
		}
		
		public MatrixArrayRC(long[] mat) throws WrongLength{
			if (mat.length != 9) throw new WrongLength(9,mat.length,"MatrixArrayRC");
			this.mat = new long[size][size];
			int len = 0;
			for(int row=0; row<size;row++){
				for(int col=0; col<size; col++){
					this.mat[row][col] = mat[len];
					len++;
				}
			}
		}
		
		public MatrixArrayRC(int n, long[] mat) throws WrongLength{
			if (mat.length != (n*n)) throw new WrongLength((n*n),mat.length,"MatrixArrayRC");
			this.size = n;
			this.mat = new long[size][size];
			int len = 0;
			for(int row=0; row<size;row++){
				for(int col=0; col<size; col++){
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
			for(int row=0; row<size;row++){
				for(int col=0; col<size; col++){
					arr[len] = this.mat[row][col];
					len++;
				}
			}
			return arr;
		}
		
		public MatrixArrayRC matrixpower(int i) throws WrongLength,WrongPower{
			MatrixArrayRC result = new MatrixArrayRC();
			if (i<0) throw new WrongPower(i, "MatrixArrayRC");
	  		if (mat.length != (size*size)) throw new WrongLength((size*size),mat.length,"MatrixArrayRC");
			
	  		long[] answer = new long[size];
			long [] arr = new long[size*size];
			int len = 0;
			for(int row=0; row<size;row++){
				for(int col=0; col<size; col++){
					arr[len] = this.mat[row][col];
					len++;
				}
			}
			
			long[] temp= copyArray(arr);
		  	if (i==0){
		  		answer = identitymatrix();
		  		result = new MatrixArrayRC(size,answer);
		  		}
		  	else if (i==1){
		  		result = new MatrixArrayRC(size,arr);
		  		}
		  	if (i>1){
		  		for(int power=2; power<=i;power++){
		  			answer = matrixmultiplication(temp);
		  			temp=answer;
		  			}
		  		result =  new MatrixArrayRC(size,answer);
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
			for(int row=0; row<size;row++){
				for(int col=0; col<size; col++){
					arr[len] = this.mat[row][col];
					len++;
				}
			}
			long[] answer = new long[size*size];
			for (int ncols = 0; ncols < size; ncols++) {
	            for (int nrows = 0; nrows < size; nrows++) {
	                for (int k = 0; k < size; k++) {
	                    answer[(nrows * size) + ncols] += arr[(nrows * size) + k] * temp[(k * size) + ncols];
	                }
	            }
	        }
			return answer;
		}
	}


