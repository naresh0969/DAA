//sum of subsets of a given number

import java.util.*;

class Check{
	int set[];
	int val;
	Check(int set[],int val){
		this.set=set;
		this.val=val;
	}
	boolean find(int n,int val){
		if(val==0) return true;
		if(n==0) return false;
		if(set[n-1]<=val){
			return (find(n-1,val-set[n-1])|| find(n-1,val));
		}
		else{
			return find(n-1,val);
		}
	}
	
}
public class Subset1{
	public static void main(String args[]){
		int set[]={1,4,3,8,5};
		int val=12;
		Check obj=new Check(set,val);
		System.out.println( obj.find(5,val));
		
	}
}