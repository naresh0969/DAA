 class nq{
	int pos[];
	int queens;
	nq(int queens){
		this.queens=queens;
		pos=new int[queens];
	}
	void queen(int r, int q){
		if(r==q){
			for(int i=0;i<q;i++){
				System.out.print(pos[i]+" ");
			}
			System.out.println();
			return;
			
		
		}
		for(int c=0;c<q;c++){
			if(isSafe(r,c)){
				pos[r]=c;
				queen(r+1,q);
			}
		
		}
	
	}
	boolean isSafe(int r,int c){
		for(int i=0;i<r;i++){
			if(pos[i]==c) return false;
			if(Math.abs(r-i)==Math.abs(c-pos[i]) )return false;
		}
		return true;
	}
}
class Nqueen{
	public static void main(String args[]){
		int queens=4;
		nq obj=new nq(queens);
		obj.queen(0,queens);
	
	}
}