// //closest pair(Brute force)
// #include <stdio.h>
// #include <math.h>
// #include<limits.h>

// struct Point {
//     int x, y;
// };

// int main() {
//     int n;
//     printf("Enter the number of points: ");
//     scanf("%d",&n);

//     if (n <= 1) {
//         printf( "At least two points are needed for comparison.");
//         return 0;
//     }

//     struct Point p[n];
//     double minDistance = INT_MAX;

//     for (int i = 0; i < n; i++) {
//          printf ("Enter the points (x, y):");
//         scanf("%d %d",&p[i].x,&p[i].y);
//     }

//     for (int i = 0; i < n - 1; i++) {
//         for (int j = i + 1; j < n; j++) {
//             int dx = p[i].x - p[j].x;
//             int dy = p[i].y - p[j].y;
//             double distance = sqrt(pow(dx,2) + pow(dy,2));
//             if (distance < minDistance) {
//                 minDistance = distance;
                
//             }
//         }
//     }

//     printf("The minimum distance between two points is: %.2f", minDistance);

//     return 0;
// }
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
