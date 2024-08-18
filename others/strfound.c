//check weither given substring is present or not in a string.
#include<stdio.h>
void main(){
    printf("Enter a string ");
    char str[50];
    char substr[50];
    scanf("%s",str);
    printf("Enter a substring ");
    
    scanf("%s",substr);
    for(int i=0;str[i]!='\0';i++){
        int flag=1;
        for(int j=0;substr[j]!='\0';j++){
            if(str[i+j]!=substr[j]){
                flag=0;
                break;
            }
        }
        if(flag==1){
            printf("String is present at %d",i);
            return;
        }
    }
    printf("String not found ");
    return;

}