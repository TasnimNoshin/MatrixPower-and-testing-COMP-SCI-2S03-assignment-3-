package cs2s03;

public class MatrixArrayFlat {
	private long[] mat;
	private int size;
	
	public MatrixArrayFlat(){
		
	}
	
	public MatrixArrayFlat(long[] mat) throws WrongLength{
		this.mat = mat;
		this.size = 3;
		if (this.mat.length != 9) throw new WrongLength(9,this.mat.length,"MatrixArrayFlat");
	}
	
	public MatrixArrayFlat(int n, long[] mat) throws WrongLength{
		this.size = n;
		this.mat = mat;
		if (this.mat.length != (size*size)) throw new WrongLength((size*size),this.mat.length,"MatrixArrayFlat");
	}
	
	private long[] copyArray (long[] copy) {
		
		long[] copymat = copy;
		return copymat;
	}
	
	public long[] toArray () {
		long [] arr = mat;
		
		return arr;
	}
	
	public MatrixArrayFlat matrixpower(int i) throws WrongLength,WrongPower {
		MatrixArrayFlat result = new MatrixArrayFlat();
		if (i<0) throw new WrongPower(i, "MatrixArrayFlat");
  		if (this.mat.length != (size*size)) throw new WrongLength((size*size),this.mat.length,"MatrixArrayFlat");
		
		long[] answer = new long[size];
		long[] temp= copyArray(this.mat);
	  	if (i==0){
	  		answer = identitymatrix();
	  		result = new MatrixArrayFlat(size,answer);
	  		}
	  	else if (i==1){
	  		result = new MatrixArrayFlat(size,this.mat);
	  		}
	  	if (i>1){
	  		for(int power=2; power<=i;power++){
	  			answer = matrixmultiplication(temp);
	  			temp=answer;
	  			}
	  		result =  new MatrixArrayFlat(size,answer);
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
	
	private long[] matrixmultiplication(long[] temp) {
		
		long[]  answer = new long[size*size];
		long[] arr = this.mat;
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
