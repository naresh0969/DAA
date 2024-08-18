#!/bin/bash

echo "Select a question number to generate DAA code:"
echo "1. Closest pair(Brute force)"
echo "2. Convex Hull"
echo "3. equal partation"
echo "4. Hamilton Cycle"
echo "5. Diagonal path matrix"
echo "6. Closest pair(Divide and conquer)"
echo "7. mcm"
echo "8. mcm memo"
echo "9. Stair count(DP)"
echo "10. mcm tabulation"
echo "11. kanpsack memo"
echo "12. Coin exchange"
echo "13. merge sort"
echo "14. quick sort"
echo "15.coin exchange(min-no-ways)"
echo "16.String matching"
echo "17.knapsack(Backtracking)"
echo "18.n queen"
echo "19.optimal Binary search tree(rec)"
echo "20.Binary Search(Divide and conquer)"
echo "21.String repeat(backtracing)"
echo "22.way to sum array"
echo "23. obst(dp)"
echo "24. obst(tabl)"


read -p "Enter the question number: " question_number

case $question_number in
    1) question="Closest pair(Brute force)";;
    2) question="Convex Hull ";;
    3) question="equal partation";;
    4) question="Hamilton Cycle";;
    5) question="Diagonal path matrix";;
    6) question="Closest pair(Divide and conquer)";;
    7) question="mcm";;
    8) question="mcm memo";;
    9) question="Stair count(DP)";;
    10) question="mcm tabulation";;
    11) question="knapsack memo";;
    12) question="Coin exchange";;
    13) question="merge sort";;
    14) question="quick sort";;
    15)question="coin exchange(min-no-ways)";;
    16)question="string matching";;
    17) question="knapsack(Backtracking)";;
    18)question="n queen";;
    19)question="optimal Binary search tree";;
    20)question="Binary Search(Divide and conquer)";;
    21)question="String repeat(backtracing)";;
    22)question="ways to sum array";;
    23)question="obst(dp)";;
    24)question="obst(tabl)";;

    *) echo "Invalid question number."
       exit 1;;
esac

file_name="${question// /_}.c"

echo "Creating $file_name with the answer to $question..."

# C code for the selected question
c_code=""
case $question_number in
    1)
        c_code=$(cat <<EOM
//closest pair(Brute force)
#include <stdio.h>
#include <math.h>
#include<limits.h>

struct Point {
    int x, y;
};

int main() {
    int n;
    printf("Enter the number of points: ");
    scanf("%d",&n);

    if (n <= 1) {
        printf( "At least two points are needed for comparison.");
        return 0;
    }

    struct Point p[n];
    double minDistance = INT_MAX;

    for (int i = 0; i < n; i++) {
         printf ("Enter the points (x, y):");
        scanf("%d %d",&p[i].x,&p[i].y);
    }

    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            int dx = p[i].x - p[j].x;
            int dy = p[i].y - p[j].y;
            double distance = sqrt(pow(dx,2) + pow(dy,2));
            if (distance < minDistance) {
                minDistance = distance;
                
            }
        }
    }

    printf("The minimum distance between two points is: %.2f", minDistance);

    return 0;
}
//far
#include <stdio.h>
#include <math.h>
#include<limits.h>

struct Point {
    int x, y;
};

int main() {
    int n,avg=0;
    printf("Enter the number of points: ");
    scanf("%d",&n);

    if (n <= 1) {
        printf( "At least two points are needed for comparison.");
        return 0;
    }

    struct Point p[10];
    int max=INT_MIN;

    for (int i = 0; i < n; i++) {
        printf ("Enter the points (x, y):");
        scanf("%d %d",&p[i].x,&p[i].y);
    }

    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            int dx = p[i].x - p[j].x;
            int dy = p[i].y - p[j].y;
            int distance = sqrt(pow(dx,2) + pow(dy,2));
               if(max<distance){
                    max=distance;
               }
            }
        }

    printf("The far distance between all village is: %d", max);

    return 0;
}

EOM
)
        ;;
    2)
        c_code=$(cat <<EOM
//convexhull
import java.util.Scanner;

class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ConvexHull {
    static int orientation(Point p, Point q, Point r) {
        int val =  (p.x - q.x) * (r.y - q.y) - (p.y - q.y) * (r.x - q.x) ;  //mathematically using cross product formula
        if (val == 0)
            return 0;
        return (val > 0) ? 1 : 2;
    }

    static void convexHull(Point points[], int n) {
        if (n < 3)
            return;
        int[] hullIndices = new int[n];
        int hullCount = 0;
        int leftmost = 0;
        for (int i = 0; i < n; i++) {  //to find the point with least x-coordinate
            if (points[i].x < points[leftmost].x)
                leftmost = i;
        }
        int p = leftmost, q;
        do {
            hullIndices[hullCount++] = p;
            q = (p + 1) % n;
            for (int i = 0; i < n; i++) { //here why i from 0 unlike from very next point from q? ans becoz inner loop must go through all points for any line segement considered as convex
                if(i == p || i==q){  //last edited & no matter with this line
                    continue;
                }
                if (orientation(points[p], points[i], points[q]) == 2)//here loop go through all points and every point is checked with convex
                    q = i;
            }
            p = q;
        } while (p != leftmost);
        System.out.println("Convex Hull:");
        for (int i = 0; i < hullCount; i++) {
            System.out.println("(" + points[hullIndices[i]].x + ", " + points[hullIndices[i]].y + ")");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        System.out.println("Enter the coordinates of each point (x, y):");
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point(x, y);
        }
        convexHull(points, n);
        scanner.close();
    }
}



EOM
)
        ;;
    3)
        c_code=$(cat <<EOM
//equal partation using recurssion
import java.util.*;

class Equal {
    static int v = 0; 
    int a;
    int b[];

    Equal(int n, Scanner p) {
        this.a = n;
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = p.nextInt();
            v = v + b[i];
        }
    }

    boolean partition(int n, int w) {
        if (w == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (b[n - 1] <= w) {
            return partition(n - 1, w - b[n - 1]) || partition(n - 1, w);
        } else {
            return partition(n - 1, w);
        }
    }
}

public class EqualRecur {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Equal e = new Equal(n, s);
        if (Equal.v % 2 == 0) {
            int x = Equal.v / 2;
            System.out.println(e.partition(n, x));
        } else {
            System.out.println("false");
        }
    }
}

EOM
)
        ;;
    4)
        c_code=$(cat <<EOM
//Hamilton cycle
import java.util.Scanner;

class Track{
    int n;  
    int a[];
    int edge[][];
    Track(int n, Scanner sc){
        this.n = n;
        this.a = new int[n];
        this.edge = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                System.out.print("edge between "+i+" and "+j+" :");
                edge[i][j] = edge[j][i] = sc.nextInt();
            }
        }
        a[0] = 0;
        hamilton(1, n);
    }
    void hamilton(int pos, int n){
        if(pos == n){
            for(int i=0; i<n; i++){
                System.out.print(a[i]+" ");
            }
            System.out.println();
        }
        for(int i=1; i<n; i++){
            if(isSafe(pos, i)){
                a[pos] = i;
                hamilton(pos+1, n);
            }
        }
    }
    boolean isSafe(int pos, int node){
        for(int i=0; i<pos; i++){
            if(a[i] == node){
                return false;
            }
        }
        if(edge[a[pos-1]][node] != 1){
            return false;
        }
        if(pos == n-1 && edge[node][a[0]] != 1){
            return false;
        }
        return true;
    }
}
public class HamiltonCycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=6;
        new Track(n, sc);

        sc.close();
    }
}


EOM
)  
    ;;
    5)
        c_code=$(cat <<EOM
//diagonal path matrix
import java.util.*;

class matrix {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int l=1;
        int [][] a=new int[n][n];
        for(int k=0;k<n;k++){
            for(int i=0;i<n-k;i++){
                int j=i+k;
                a[i][j]=l++;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]);
            }
            System.out.println("");
        }
    }
}

EOM
)
        ;;
    6)
        c_code=$(cat <<EOM
//Closest pair(Divide and conquer)
#include <stdio.h>
#include <math.h>
#include <limits.h>
#include <stdlib.h> // Required for qsort

struct point {
    int x, y;
};

// Function to compare two points based on their x-coordinate
int compareX(const void* a, const void* b) {
    struct point *p1 = (struct point *)a;
    struct point *p2 = (struct point *)b;
    return (p1->x - p2->x);
}

// Function to compare two points based on their y-coordinate
int compareY(const void* a, const void* b) {
    struct point *p1 = (struct point *)a;
    struct point *p2 = (struct point *)b;
    return (p1->y - p2->y);
}

// Function to swap two points
void swap(struct point *a, struct point *b) {
    struct point temp = *a;
    *a = *b;
    *b = temp;
}

// Quicksort function to sort points based on x-coordinate
void Quicksort(struct point p[], int start, int end) {
    if (start < end) {
        int pivot = p[start].x;
        int i = start + 1;
        int j = end;

        while (i <j) {
            while (i <= end && p[i].x < pivot)
                i++;
            while (j > start && p[j].x > pivot)
                j--;

            if (i < j) {
                swap(&p[i], &p[j]);
            }
        }

        swap(&p[start], &p[j]);

        Quicksort(p, start, j - 1);
        Quicksort(p, j + 1, end);
    }
}

// Function to find the distance between two points
double distance(struct point p1, struct point p2) {
    int dx = p1.x - p2.x;
    int dy = p1.y - p2.y;
    return sqrt(dx * dx + dy * dy);
}

// Function to find the minimum of two distances
double min(double x, double y) {
    return (x < y) ? x : y;
}

// Brute force function to find the closest pair distance
double bruteforce(struct point p[], int start, int end) {
    double minDistance = INT_MAX;
    for (int i = start; i < end; ++i) {
        for (int j = i + 1; j <= end; ++j) {
            double dist = distance(p[i], p[j]);
            if (dist < minDistance) {
                minDistance = dist;
            }
        }
    }
    return minDistance;
}

// Function to find the closest pair distance recursively
double closetpair(struct point p[], int start, int end) {
    if (end - start <= 3) {
        return bruteforce(p, start, end);
    }

    int mid = (start + end) / 2;
    double dl = closetpair(p, start, mid);
    double dr = closetpair(p, mid + 1, end);

    double d = min(dl, dr);

    struct point strip[end - start + 1];
    int j = 0;
    for (int i = start; i <= end; i++) {
        if (abs(p[i].x - p[mid].x) < d) {
            strip[j] = p[i];
            j++;
        }
    }

    qsort(strip, j, sizeof(struct point), compareY);

    double minStrip = INT_MAX;
    for (int i = 0; i < j; i++) {
        for (int k = i + 1; k < j && (strip[k].y - strip[i].y) < minStrip; k++) {
            double dist = distance(strip[i], strip[k]);
            if (dist < minStrip) {
                minStrip = dist;
            }
        }
    }

    return min(d, minStrip);
}

int main() {
    int n;
    printf("Enter the number of points: ");
    scanf("%d", &n);

    if (n <= 1) {
        printf("At least two points are required for comparison.\n");
        return 0;
    }

    struct point p[n];
    printf("Enter the coordinates of each point:\n");
    for (int i = 0; i < n; i++) {
        printf("Point %d: ", i + 1);
        scanf("%d %d", &p[i].x, &p[i].y);
    }

    Quicksort(p, 0, n - 1);
    double minDistance = closetpair(p, 0, n - 1);

    printf("The smallest distance between two points is: %.2f\n", minDistance);

    return 0;     
}

EOM
)
        ;;
    7)
        c_code=$(cat <<EOM
//matrix sum multiplication using recurssion
import java.util.*;

class short1{
    int n;
    int [] a;
    int val;
    short1(int n){
        this.n=n;
        a=new int[n+1];
        Scanner s=new Scanner(System.in);
        for(int i=0;i<=n;i++){
            a[i]=s.nextInt();
        }
    }
    int find(int i,int j){
        if(i==j)
            return 0;
        int min=1000;
        for(int k=i;k<j;k++){
            val=find(i,k)+find(k+1,j)+a[i-1]*a[k]*a[j];
            if(val<min)
                min=val;
        }
        return min;
    }
}

class mcm {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        short1 s=new short1(n);
        System.out.println(s.find(1,n));
    }
}




EOM
)
        ;;
    8)
        c_code=$(cat <<EOM
//mcm using memorization
import java.util.*;

class short2{
    int n;
    int [] a;
    int [][] dp;
    int val;
    short2(int n){
        this.n=n;
        a=new int[n+1];
        dp=new int[n+1][n+1];
        Scanner s=new Scanner(System.in);
        for(int i=0;i<=n;i++){
            a[i]=s.nextInt();
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
    }
    int find1(int i,int j){
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(i==j)
            return dp[i][j]=0;
        int min=1000;
        for(int k=i;k<j;k++){
            val=find1(i,k)+find1(k+1,j)+a[i-1]*a[k]*a[j];
            if(val<min)
                min=val;
        }
        return dp[i][j]=min;
    }
}

class mcm_mem{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        short2 s=new short2(n);
        System.out.println(s.find1(1,n));
    }
}


EOM
)
        ;;
    9)
        c_code=$(cat <<EOM
// Stair count(DP)
#include<stdio.h>
#include<limits.h>

int step_recursion(int);
int step_memorization(int);
int step_iteration(int);
int step[10],arr[10];

int step_recursion(int n){
    if(n==0 || n==1){
        return 1;
    }
    else{
        return step_recursion(n-1)+step_recursion(n-2);
    }
}

int step_memorization(int n){
    if(step[n]!=-1)
        return step[n];
    if(n==0 || n==1){
        return step[n]=1;
    }
    else{
        return step[n]=step_memorization(n-1)+step_memorization(n-2);
    }
}

int step_iteration(int n){
		for(int i=0;i<=n;i++){
		
		if(i==0 || i==1){
		   arr[i]=1;
		}
		else{
		  	arr[i]=arr[i-1]+arr[i-2];
		}
	}
	return arr[n];
}

int main(){
    int n;
    printf("Enter no.of steps:");
    scanf("%d",&n);

    for(int i=0;i<=n;i++){
        step[i]=-1;
    }
    
    for(int i=0;i<=n;i++){
        arr[i]=-1;
    }
    printf("Total ways through recursion = %d\n",step_recursion(n));
    printf("Total ways through memorization = %d\n",step_memorization(n));
    printf("Total ways through iteration = %d\n",step_iteration(n));

}

//tabulation
#include <stdio.h>

// Function to count the number of ways to reach the nth step
int countWays(int n) {
    // Base cases
    if (n == 0 || n == 1) {
        return 1;
    }

    // Array to store the number of ways to reach each step
    int ways[n + 1];

    // Initialize base cases
    ways[0] = 1;
    ways[1] = 1;

    // Fill the array in a bottom-up manner
    for (int i = 2; i <= n; i++) {
        ways[i] = ways[i - 1] + ways[i - 2];
    }

    // Return the number of ways to reach the nth step
    return ways[n];
}

int main() {
    int n;

    printf("Enter the number of steps: ");
    scanf("%d", &n);

    if (n < 0) {
        printf("Please enter a non-negative integer.\n");
        return 1;
    }

    printf("Number of ways to reach the %dth step: %d\n", n, countWays(n));

    return 0;
}
EOM
)
        ;;
    10)
        c_code=$(cat <<EOM
//mcm tabulation
import java.util.*;
class max_table{
    int a[];
    int dp[][];
    max_table(int n){
        a=new int[n];
        dp=new int[n][n];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
    }
    int mcm(int n){
        for(int l=0;l<n;l++){
            for(int i=1;i<n-l;i++){
                int j=i+l;
                if(i==j){
                    dp[i][j]=0;
                    continue;
                }
                int min=10000;
                for(int k=i;k<j;k++){
                    int val=dp[i][k]+dp[k+1][j]+a[i-1]*a[k]*a[j];
                    if(val<min)
                        min=val;
                }
                dp[i][j]=min;
            }
        }
        return dp[1][n-1];
    }
    
}



class mcm_table {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        max_table m=new max_table(n);
        System.out.println(m.mcm(n));
    }
}

EOM
)
        ;;

    11)
        c_code=$(cat <<EOM
//knapsac memorization
import java.util.Scanner;

class hello{
    int val[];
    int wig[];
    int a[][];
     public hello(int n,int w){
        val=new int[n];
        wig=new int[n];
        a=new int[n+1][w+1];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
            wig[i]=sc.nextInt();
        }
        for(int i=0;i<n+1;i++){
            for (int j=0;j<w+1;j++){
                a[i][j]=-1;
            }
        }
    }
    int fill(int n,int w){
        if(a[n][w]!=-1){
            return a[n][w];
        }
        if(w==0||n==0){
            a[n][w]=0;
        }
        else if(wig[n-1]<=w){
            a[n][w]=Math.max((val[n-1]+fill(n-1,w-wig[n-1])),fill(n-1,w));
        }
        else{
            return a[n][w]=fill(n-1,w);
        }
        return a[n][w];
    }
    
}

class memorization {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int w=s.nextInt();
        hello h=new hello(n,w);
        System.out.println(h.fill(n, w));
        
    }
}
//knapsac recursion
import java.util.Scanner;

class hello{
    int val[];
    int wig[];
     public hello(int n){
        val=new int[n];
        wig=new int[n];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
            wig[i]=sc.nextInt();
        }
    }
    int fill(int n,int w){
        if(w==0||n==0){
            return 0;
        }
        else if(wig[n-1]<=w){
            return Math.max((val[n-1]+fill(n-1,w-wig[n-1])),fill(n-1,w));
        }
        else{
            return fill(n-1,w);
        }
    }
    
}

class recursion {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int w=s.nextInt();
        hello h=new hello(n);
        System.out.println(h.fill(n, w));
        
    }
}





EOM
)
        ;;
    12)
        c_code=$(cat <<EOM
//Coin exchange
//coinchange problem by recursive approach
#include<stdio.h>
int coinchange(int coins[],int n,int total)
{
if(total==0)
{
return 1;
}
else if(n==0)
{
return 0;
}
else if(coins[n-1]<=total)
{
return coinchange(coins,n,total-coins[n-1])+coinchange(coins,n-1,total);
}
else
{
return coinchange(coins,n-1,total);
}
}
int main()
{
int n,total;
printf("enter the no of coins:");
scanf("%d",&n);
int coins[n];
printf("enter total money:");
scanf("%d",&total);
printf("enter the types of coins:");
for(int i=0;i<n;i++)
{
scanf("%d",&coins[i]);
}
int count=coinchange(coins,n,total);
printf("answer:%d\n",count);
return 0;
}

//coinchange problem by memorization approach
#include<stdio.h>
int a[50][50];
int coinchange(int coins[],int n,int total)
{
if(a[n][total]!=-1)
{
return a[n][total];
}
else if(total==0)
{
return a[n][total]=1;
}
else if(n==0)
{
return a[n][total]=0;
}
else if(coins[n-1]<=total)
{
return a[n][total]=coinchange(coins,n,total-coins[n-1])+coinchange(coins,n-1,total);
}
else
{
return a[n][total]=coinchange(coins,n-1,total);
}
}
int main()
{
int n,total;
printf("enter the no of coins:");
scanf("%d",&n);
int coins[n];
printf("enter total money:");
scanf("%d",&total);
printf("enter the types of coins:");
for(int i=0;i<n;i++)
{
scanf("%d",&coins[i]);
}
for(int i=0;i<50;i++)
{
for(int j=0;j<50;j++)
{
a[i][j]=-1;
}
}
int count=coinchange(coins,n,total);
printf("answer:%d\n",count);
return 0;
}
//coinchange problem by tabular approach
#include<stdio.h>

int coinchange(int coins[],int n,int  total)
{
int a[n+1][total+1];
for(int i=0;i<=n;i++)
{
for(int j=0;j<=total;j++)
{
if(j==0)
{
a[i][j]=1;
continue;
}
if(i==0)
{
a[i][j]=0;
continue;
}
if(coins[i-1]<=j)
{
a[i][j]=a[i][j-coins[i-1]]+a[i-1][j];
}
else
{
a[i][j]=a[i-1][j];
}
}
}
return a[n][total];
}
int main()
{
int n,total;
printf("enter the total no of coins:");
scanf("%d",&n);
int coins[n];
printf("enter the total weight :");
scanf("%d",&total);
printf("enter the coins:");
for(int i=0;i<n;i++)
{
scanf("%d",&coins[i]);
}
int count=coinchange(coins,n,total);
printf("answer:%d",count);
}


EOM
)
        ;;
    13)
        c_code=$(cat <<EOM
//merge sort
#include <stdio.h>
void mergesort(int arr[],int lb, int ub);
void merge(int arr[],int lb,int mid,int ub);

int main(){
    int n;
    printf("enter the size of the array");
    scanf("%d",&n);

    int arr[n];
    printf("enter the data");
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    int lb=0,ub=n-1;
    mergesort(arr,lb,ub);
    printf("after sorting");

    for(int i=0;i<n;i++){
        printf("%d",arr[i]);
    }
    return 0;
}

    void mergesort(int arr[],int lb,int ub){
        
        if(lb<ub){
            int mid=(lb+ub)/2;
            mergesort(arr,lb,mid);
            mergesort(arr,mid+1,ub);
            merge(arr,lb,mid,ub);
        }
    }

    void merge(int arr[],int lb,int mid,int ub){

      int b[100],i=lb,j=mid+1,k=lb;
      while(i<=mid && j<=ub){
        if(arr[i]<=arr[j]){
            b[k]=arr[i];
            i++;
        }
        else{
            b[k]=arr[j];
            j++;
        }
        k++;
      }
    if(i>mid){
        while(j<=ub){
            b[k]=arr[j];
            j++,k++;
        }
    }
    else{
        while(i<=mid){
            b[k]=arr[i];
            k++,i++;
        }
    }
    
    for(int k=lb;k<=ub;k++){
        arr[k]=b[k];
    }
    }

EOM
)
        ;;
    14)
        c_code=$(cat <<EOM
//quick sort
  #include <stdio.h>
void quicksort( int a[],int lb,int ub);
int partition(int a[],int lb, int ub);
int main(){
    int n,lb,ub;
    printf("\n Enter the size of an array:");
    scanf("%d",&n);
    int a[n];
    printf("\n Enter %d array elements:",n);
    for (int  i = 0; i < n; i++)
    {
        scanf("%d",&a[i]);
    }
    printf("\n The sorted array is ..");
     lb=0,ub=n-1;
    quicksort(a,lb,ub);
    for (int j= 0; j< n; j++)
    {
        printf("%d ",a[j]);
    }
    

}
int partition(int a[],int lb,int ub){
    int start,end,pivot;
    int swap;
    pivot=a[lb];
    start=lb;
    end=ub;
    while (start<end)
    {
        while (a[start]<=pivot)
        {
            start++;
        }
        while (a[end]>pivot)
        {
            end--;
        }
        if (start<end)
        {
            swap=a[start];
            a[start]=a[end];
            a[end]=swap;
        }
    }
    swap=a[lb];
    a[lb]=a[end];
    a[end]=swap;
    return end;
}
void quicksort(int a[],int lb,int ub){
    int loc;
    if (lb<ub)
    {
        loc=partition(a,lb,ub);
        quicksort(a,lb,loc-1);
        quicksort(a,loc+1,ub);
    }
    
}    
EOM
)
        ;;

15)
    c_code=$(cat <<EOM
//coin exchange(min-no-ways)
//minimum number of coins required for coin change problem by recursive approach
#include<stdio.h>
#include<limits.h>
int min(int a,int b)
{
return (a<b) ? a : b;
}
int coinchangemin(int coins[],int n,int total)
{
if(total==0)
{
return 0;
}
else if(n==0)
{
return INT_MAX-1000;
}
else if(coins[n-1]<=total)
{
return min(1+coinchangemin(coins,n,total-coins[n-1]),coinchangemin(coins,n-1,total));
}
else
{
return coinchangemin(coins,n-1,total);
}
}
int main()
{
int n,total;
printf("enter the no of coins:");
scanf("%d",&n);
int coins[n];
printf("enter total money:");
scanf("%d",&total);
printf("enter the types of coins:");
for(int i=0;i<n;i++)
{
scanf("%d",&coins[i]);
}
int count=coinchangemin(coins,n,total);
printf("Answer:%d",count);
return 0;
}
//minimum number of coins required for coin change problem by memorization approach
#include<stdio.h>
#include<limits.h>
int a[50][50];
int min(int a,int b)
{
return (a<b) ? a : b;
}
int coinchangemin(int coins[],int n,int total)
{
    if(a[n][total]!=-1)
    {
        return a[n][total];
    }
if(total==0)
{
return a[n][total]=0;
}
else if(n==0)
{
return a[n][total]=INT_MAX-1000;
}
else if(coins[n-1]<=total)
{
return a[n][total]=min(1+coinchangemin(coins,n,total-coins[n-1]),coinchangemin(coins,n-1,total));
}
else
{
return a[n][total]=coinchangemin(coins,n-1,total);
}
}
int main()
{int n,total;
printf("enter the no of coins:");
scanf("%d",&n);
int coins[n];
printf("enter total money:");
scanf("%d",&total);
printf("enter the types of coins:");
for(int i=0;i<n;i++)
{
scanf("%d",&coins[i]);
}
for(int i=0;i<50;i++)
{
for(int j=0;j<50;j++)
{
a[i][j]=-1;
}
}
int count=coinchangemin(coins,n,total);
printf("Answer:%d",count);
return 0;
}
//minimum coin change problem by tabular approach
#include<stdio.h>
#include<limits.h>
int min(int a,int b)
{
return(a<b) ? a : b;
}
int coinchangemin(int coins[],int n,int total)
{
int a[n+1][total+1];
for(int i=0;i<=n;i++)
{
for(int j=0;j<=total;j++)
{
if(j==0)
{
a[i][j]=0;
continue;
}
if(i==0)
{
a[i][j]=INT_MAX-1000;
continue;
}
if(coins[i-1]<=j)
{
a[i][j]=min(1+a[i][j-coins[i-1]],a[i-1][j]);
}
else
{
a[i][j]=a[i-1][j];
}
}
}
return a[n][total];
}
int main()
{
int n,total;
printf("enter the no of coins:");
scanf("%d",&n);
int coins[n];
printf("enter total money:");
scanf("%d",&total);
printf("enter the types of coins:");
for(int i=0;i<n;i++)
{
scanf("%d",&coins[i]);
}
int count=coinchangemin(coins,n,total);
printf("Answer:%d",count);
return 0;
}


EOM
)
    ;;


 16)
        c_code=$(cat <<EOM
//string matching 
import java.util.Scanner;

class StringMatcher {
    char[] a;
    char[] b;

    StringMatcher(int n, int m) {
        Scanner sc = new Scanner(System.in);
        a = new char[n];
        b = new char[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLine().charAt(0);
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextLine().charAt(0);
        }
    }

    int match(int n, int m) {
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (a[i + j] != b[j]) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }
}

class practice1 {
    public static void main(String[] args) {
        Scanner si = new Scanner(System.in);
        int n;
        int m;
        n = si.nextInt();
        m = si.nextInt();
        si.nextLine();
        StringMatcher s = new StringMatcher(n, m);
        int result = s.match(n, m);
        if (result == -1) {
            System.out.println("No match found.");
        } else {
            System.out.println("First match found at index: " + result);
        }
    }
}


EOM
)  
    ;;


17)
        c_code=$(cat <<EOM

//0/1 knapsack(Backtracking)
#include <iostream>
#include <limits.h>
#include <vector>
using namespace std;

int knapsackBacktrack(int ind, int mwt, const vector<int>& wt, const vector<int>& val) {
    if (ind == 0) {
        if (wt[0] <= mwt) {
            return val[0];
        } else {
            return 0;
        }
    }


    int notTake = knapsackBacktrack(ind - 1, mwt, wt, val);
    
    int take = INT_MIN;
    if (wt[ind] <= mwt) {
        take = val[ind] + knapsackBacktrack(ind - 1, mwt - wt[ind], wt, val);
    }

    return max(take, notTake);
}

int knapsack(const vector<int>& weight, const vector<int>& value, int mwt, int n) {
    return knapsackBacktrack(n - 1, mwt, weight, value);
}

int main() {
    int mwt;
    cout << "Enter the weight of Bag: ";
    cin >> mwt;

    int n;
    cout << "Enter the number of items: ";
    cin >> n;

    vector<int> value(n);
    for (int i = 0; i < n; i++) {
        cout << "Enter the value of item " << i + 1 << ": ";
        cin >> value[i];
    }

    vector<int> weight(n);
    for (int i = 0; i < n; i++) {
        cout << "Enter the weight of item " << i + 1 << ": ";
        cin >> weight[i];
    }

    int ans = knapsack(weight, value, mwt, n);
    cout << "Maximum value that can be obtained: " << ans << endl;

    return 0;
}

EOM
)
    ;;

18)
        c_code=$(cat <<EOM
//n queen
import java.util.*;
class queens{
    int a[];
    int b[];
    queens(int n,Scanner s){
        a=new int [n];
        b=new int[n];
        // for(int i=0;i<n;i++){
        //     a[i]=s.nextInt();
        // }
    }
    void place(int n,int k){
        if(k>n){
            for(int i=0;i<n;i++){
                System.out.print(b[i]);
            }
            System.out.println();
        }
        for(int i=1;i<=n;i++){
            if(issafe(k,i)){
                b[k-1]=i;
                place(n,k+1);
            }
        }
    }

    boolean issafe(int k,int i){
        for(int j=1;j<k;j++){
            if(b[j-1]==i){
                return false;
            }
            if(Math.abs(k-j)==Math.abs(i-b[j-1])){
                return false;
            }
        }
        return true;
    }
}


class queen {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        queens q=new queens(n,s);
        q.place(n,1);
    }
}


EOM
) 
    ;;

19)
        c_code=$(cat <<EOM
//optimal Binary search tree
//recursion
#include <iostream>
#include <vector>
#include <limits.h>
#include <algorithm>
using namespace std;
int fsum(vector<int> freq,int i,int j){
    int sum=0;
    for(int k=i;k<=j;k++){
        sum+=freq[k];
    }
    return sum;
}
int obst(int i,int j,vector<int> key,vector<int> freq){
    if(i>j){
        return 0;
    }
    if(i==j){
        return freq[i];
    }
    int min=INT_MAX;
    for(int k=i;k<=j;k++){
        int val=obst(i,k-1,key,freq)+obst(k+1,j,key,freq)+fsum(freq,i,j);
        if(val<min){
            min=val;
        }
    }
    return min;
}

int main() {
    int n;
    cout << "Enter the number of nodes in the BST: ";
    cin >> n;

    vector<int> key(n);
    for (int i = 0; i <n; i++) {
        cout << "Enter key " << i+1 << ": ";
        cin >> key[i];
    }

    vector<int> freq(n);
    for (int i = 0; i <n; i++) {
        cout << "Enter frequency for key " << i+1 << ": ";
        cin >> freq[i];
    }
    int i=0;
    int j=n-1;
    cout<<i<<j<<endl;
    
    int ans=obst(i,j,key,freq);
    cout<<"the minimum cost of Binary search tree is: "<<ans;


    return 0;
}
//obst(memorization)
#include <iostream>
#include <vector>
#include <limits.h>
#include <algorithm>
using namespace std;

int fsum(vector<int>& freq, int i, int j) {
    int sum = 0;
    for (int k = i; k <= j; k++) {
        sum += freq[k];
    }
    return sum;
}

int obst(int i, int j, vector<int>& key, vector<int>& freq, vector<vector<int>>& dp) {
    if (i > j) {
        return 0;
    }
    if (i == j) {
        return freq[i];
    }
    if (dp[i][j] != -1) {
        return dp[i][j];
    }

    int min = INT_MAX;
    for (int k = i; k <= j; k++) {
        int val = obst(i, k - 1, key, freq, dp) + obst(k + 1, j, key, freq, dp) + fsum(freq, i, j);
        if (val < min) {
            min = val;
        }
    }
    return dp[i][j] = min;
}

int main() {
    int n;
    cout << "Enter the number of nodes in the BST: ";
    cin >> n;

    vector<int> key(n);
    for (int i = 0; i < n; i++) {
        cout << "Enter key " << i + 1 << ": ";
        cin >> key[i];
    }

    vector<int> freq(n);
    for (int i = 0; i < n; i++) {
        cout << "Enter frequency for key " << i + 1 << ": ";
        cin >> freq[i];
    }

    vector<vector<int>> dp(n, vector<int>(n, -1));

    int ans = obst(0, n - 1, key, freq, dp);
    cout << "The minimum cost of the Binary Search Tree is: " << ans << endl;

    return 0;
}
//obst(Tabulation)
#include <iostream>
#include <vector>
#include <limits.h>
using namespace std;

int fsum(const vector<int>& freq, int i, int j) {
    int sum = 0;
    for (int k = i; k <= j; k++) {
        sum += freq[k];
    }
    return sum;
}

int obst(vector<int>& key, vector<int>& freq) {
    int n = key.size();
    vector<vector<int>> dp(n, vector<int>(n, 0));

    for (int i = 0; i < n; i++) {
        dp[i][i] = freq[i];
    }

    for (int length = 2; length <= n; length++) {
        for (int i = 0; i <= n - length; i++) {
            int j = i + length - 1;
            dp[i][j] = INT_MAX;

            int sum = fsum(freq, i, j);

            for (int k = i; k <= j; k++) {
                int cost = sum + ((k > i) ? dp[i][k - 1] : 0) + ((k < j) ? dp[k + 1][j] : 0);
                dp[i][j] = min(dp[i][j], cost);
            }
        }
    }

    return dp[0][n - 1];
}

int main() {
    int n;
    cout << "Enter the number of nodes in the BST: ";
    cin >> n;

    vector<int> key(n);
    for (int i = 0; i < n; i++) {
        cout << "Enter key " << i + 1 << ": ";
        cin >> key[i];
    }

    vector<int> freq(n);
    for (int i = 0; i < n; i++) {
        cout << "Enter frequency for key " << i + 1 << ": ";
        cin >> freq[i];
    }

    int ans = obst(key, freq);
    cout << "The minimum cost of the Binary Search Tree is: " << ans << endl;

    return 0;
}


EOM
)
    ;;

20)
    c_code=$(cat <<EOM
//Binary Search(Divide and conquer)
#include <iostream>
#include <vector>
using namespace std;

int binarySearch(const vector<int>& arr, int left, int right, int target) {
    if (left > right) {
        return -1;
    }

    int mid = left + (right - left) / 2;

    if (arr[mid] == target) {
        return mid; 
    } else if (arr[mid] < target) {
        return binarySearch(arr, mid + 1, right, target);
    } else {
        return binarySearch(arr, left, mid - 1, target);
    }
}

int main() {
    int n;
    cout << "Enter the number of elements in the array: ";
    cin >> n;

    vector<int> arr(n);
    cout << "Enter the elements of the array (sorted): ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int target;
    cout << "Enter the target value: ";
    cin >> target;

    int result = binarySearch(arr, 0, n - 1, target);
    if (result != -1) {
        cout << "Target found at index: " << result << endl;
    } else {
        cout << "Target not found in the array." << endl;
    }

    return 0;
}

EOM
)
    ;;

21)
    c_code=$(cat <<EOM
import java.util.*;
class full{
    char a[];
    char b[];
    full(int n){
        Scanner sc=new Scanner(System.in);
        a=new char[n];
        b=new char[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextLine().charAt(0);
        }
    }
    void fullfill(int n,int k){
        if(n==k){
            for(int i=0;i<n;i++){
                System.out.print(b[i]);
            }
            System.out.println();
            return;
        }
        for(int i=0;i<n;i++){
            if(issafe(k,i)){
                b[k]=a[i];
                fullfill(n, k+1);
            }
        }
    }
    boolean issafe(int k,int i){
        for(int j=0;j<k;j++){
            if(b[j]==a[i]){
                return false;
            }
        }
        return true;
    }
}

class string_repeat {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        full f=new full(n);
        f.fullfill(n, 0);
    }
}


EOM
)
    ;;

22)
    c_code=$(cat <<EOM
//no. of ways to get sum of given number
import java.util.*;
class subset{
    int a[];
    int b[][];
    subset(int n,int w){
        Scanner s=new Scanner(System.in);
        a=new int[n];
        b=new int[n+1][w+1];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        for(int i=0;i<n+1;i++){
            for (int j=0;j<w+1;j++){
                b[i][j]=-1;
            }
        }
    }
    int sum(int n,int w){
        if(b[n][w]!=-1){
            return b[n][w];
        }
        if(w==0){
            return b[n][w]=1;
        }
        if(n==0){
            return b[n][w]=0;
        }
        else if(a[n-1]<=w){
            return b[n][w]=(sum(n-1,w-a[n-1])+sum(n-1,w));
        }
        else{
            return b[n][w]=sum(n-1,w);
        }
    }
}



public class sub_mem_ways {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int w=sc.nextInt();
        subset s=new subset(n,w);
        System.out.println(s.sum(n,w));
    }
}
EOM
)
    ;;

23)
    c_code=$(cat <<EOM
class BTClassdp{
    int keys[];
    int freq[];
    int n;
    int dp[][];
    BTClassdp(int n, int keys[], int freq[]){
        this.n = n;
        this.keys = keys;
        this.freq = freq;
        dp = new int [n+2][n+2];  //as we are getting i>j case so at last when k = n(here 3) k+1 = 4(n+1)
        for(int i=0; i<=n+1; i++){
            for(int j=0; j<=n+1; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(obst(1, n));
    }
    int obst(int i, int j){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i>j){
            return dp[i][j] = 0;
        }
        if(i == j){
            return dp[i][j] = freq[i];
        }
        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j; k++){
            int val = obst(i, k-1) + obst(k+1, j) + sum(i, j);
            if(val < min){
                min = val;
            }
        }
        return dp[i][j] = min;
    }
    int sum(int m, int n){
        int sum = 0;
        for(int i=m; i<=n; i++){
            sum += freq[i];
        }
        return sum;
    }
}
public class OBSTdp {
    public static void main(String[] args) {
        int n = 3;
        int keys[] = {0, 10, 20, 30};
        int freq[] = {0, 5, 8, 12};
        new BTClassdp(n, keys, freq);
    }
}


EOM
)
    ;;

24)
    c_code=$(cat <<EOM

class ObstTable{
    int n;
    int keys[];
    int freq[];
    int a[][];
    ObstTable(int n, int keys[], int freq[]){
        this.n = n;
        this.keys = keys;
        this.freq = freq;
        a = new int[n+2][n+2];
        System.out.println(fill(1, n));
    }
    int fill(int i, int j){
        for(int l=0; l<j; l++){
            for(int row=i; row<=j-l; row++){
                int col = l+row;
                int min = Integer.MAX_VALUE;
                if(row > col){
                    a[row][col] = 0;
                    continue;
                }
                if(row == col){
                    a[row][col] = freq[row];
                    continue;
                }
                for(int k=row; k<=col; k++){
                    int val = a[row][k-1] + a[k+1][col] + sum(row, col);
                    if(val < min){
                        min = val;
                    }
                }
                a[row][col] = min;
            }
        }
        return a[1][n];
    }
    int sum(int m, int n){
        int sum = 0;
        for(int i=m; i<=n; i++){
            sum += freq[i];
        }
        return sum;
    }
}
public class OBSTTable {
    public static void main(String[] args) {
        int n = 3;
        int keys[] = {0, 10, 12, 20};
        int freq[] = {0, 34, 8, 50};
        new ObstTable(n, keys, freq);
    }
}

EOM
)
    ;;


        
esac

# Write C code to file
echo "$c_code" > "$file_name"

echo "File $file_name created."