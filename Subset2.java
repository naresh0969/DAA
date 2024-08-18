//sum of subsets of a given number


class Check{
	int set[];
	int val;
	boolean dp[][];
	Check(int set[],int val){
		this.set=set;
		this.val=val;
		dp=new boolean[set.length+1][set.val+1];
		for(int i=0;i<=set.length;i++){
			dp[i][0]=true;
		}
		for(int i=1;i<=set.length;i++){
			dp[0][i]=false;
		}

	}
	boolean find(int n,int val){
		if(dp[n][val]) return dp[n][val];
		if(val==0) return true;
		if(n==0) return false;
		if(set[n-1]<=val){
			dp[n][val]=(find(n-1,val-set[n-1])|| find(n-1,val));
		}
		else{
			dp[n][val]=find(n-1,val);
		}
		return dp[n][val];
	}
	
}
public class Subset2{
	public static void main(String args[]){
		int set[]={1,4,3,8,5};
		int val=12;
		Check obj=new Check(set,val);
		System.out.println( obj.find(5,val));
		
	}
}