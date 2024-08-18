//sum of subsets of a given number


class Check{
	int set[];
	int val;
	boolean dp[][];
	Check(int set[],int val){
		this.set=set;
		this.val=val;
		dp=new boolean[set.length+1][val+1];
		for(int i=0;i<=set.length;i++){
			dp[i][0]=true;
		}
		for(int i=1;i<=set.length;i++){
			dp[0][i]=false;
		}

	}
	boolean find(int size,int val){
		for(int i=1;i<=size;i++){
			for(int j=1;j<=val;j++){
				if(set[i-1]<=j)
					dp[i][j]=(dp[i-1][j-set[i-1]]||dp[i-1][j]);
				else
					dp[i][j]=dp[i-1][j];
			}
		}
		return dp[size][val];
	}
	
}
public class Subset3{
	public static void main(String args[]){
		int set[]={1,4,3,8,5};
		int val=42;
		Check obj=new Check(set,val);
		System.out.println( obj.find(5,val));
		
	}
}