// substring match by checking alternative character in increasing order.
#include<stdio.h>
void main(){
    printf("Enter a string ");
    char str[50];
    char substr[50];
    scanf("%s",str);
    printf("Enter a substring ");
    scanf("%s",substr);
    for(int i=0;str[i]!='\0';i++){
        int skip=0;
        int flag=1;
        int incre=0;
        
        for(int j=0;substr[j]!='\0';j++){
            if(str[i+j+skip]!=substr[j]){ 
                flag=0;
                break;
            }
            else{
                skip+=incre+1;
                incre++;
            }
        }
        if(flag==1){
            printf("%s is found at index %d",substr,i);
            return;
 
        }
    }
    printf("\nString not found ");
    return;

}