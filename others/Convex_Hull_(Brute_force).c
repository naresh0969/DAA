// Convex Hull (Brute force)
#include <stdio.h>
#include <math.h>
#include <limits.h>

struct Point
{
    int x, y;
};

int main()
{
    int n;
    printf("Enter the number of points: ");
    scanf("%d", &n);

    if (n <= 1)
    {
        printf("At least two points are needed for comparison.");
        return 0;
    }

    struct Point p[10];

    for (int i = 0; i < n; i++)
    {
        printf("Enter the points (x, y):");
        scanf("%d %d", &p[i].x, &p[i].y);
    }
    int a, b, c;
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            a = p[i].y - p[j].y;
            b = p[j].x - p[i].x;
            c = p[j].x * p[i].y - p[i].x * p[j].y;
            int np = 0, nn = 0, val;
            for (int k = 0; k < n; k++)
            {
                val = a * p[k].x + b * p[k].y - c;
                if (val > 0)
                {
                    np++;
                }
                else if (val < 0)
                {
                    nn++;
                }
            }
             if (np == 0 || nn == 0)
            {
                printf("it is convex hall %d %d\n",i,j);
            }
           
        }
    }
}
//convex edge
#include <stdio.h>
#include <math.h>
#include <limits.h>

struct Point
{
    int x, y;
};

int main()
{
    int n;
    int count=0;
    printf("Enter the number of points: ");
    scanf("%d", &n);

    if (n <= 1)
    {
        printf("At least two points are needed for comparison.");
        return 0;
    }

    struct Point p[10];

    for (int i = 0; i < n; i++)
    {
        printf("Enter the points (x, y):");
        scanf("%d %d", &p[i].x, &p[i].y);
    }
    int a,b,c;
    for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            a=p[i].y-p[j].y;
            b=p[j].x-p[i].x;
            c=p[j].x*p[i].y-p[i].x*p[j].y;
        
    int np=0,nn=0,val;
    for(int k=0;k<n;k++){
        val=a*p[k].x+b*p[k].y-c;
        if(val>0){
            np++;
        }
        else if(val<0){
            nn++;
        }
    }
    if(np==0||nn==0){
        count++;
    }
}
}
 printf("convex edges:%d",count);
}
//convex point
#include <stdio.h>

struct Point {
    int x, y;
};

int main() {
    int n;
    printf("Enter the number of points: ");
    scanf("%d", &n);

    if (n <= 1) {
        printf("At least two points are needed for comparison.\n");
        return 0;
    }

    struct Point p[10];

    for (int i = 0; i < n; i++) {
        printf("Enter the points (x, y): ");
        scanf("%d %d", &p[i].x, &p[i].y);
    }

    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            int a = p[i].y - p[j].y;
            int b = p[j].x - p[i].x;
            int c = p[j].x * p[i].y - p[i].x * p[j].y;
        
            int np = 0, nn = 0, nzero = 0;

            for (int k = 0; k < n; k++) {
                int val = a * p[k].x + b * p[k].y - c;
                if (val > 0) {
                    np++;
                } else if (val < 0) {
                    nn++;
                } else {
                    nzero++;
                }
            }
    
            if (np == 0 || nn == 0) {
                printf("Number of points on the edge between (%d, %d) and (%d, %d): %d\n", p[i].x, p[i].y, p[j].x, p[j].y, nzero);
            }
        }
    }
    return 0;
}
