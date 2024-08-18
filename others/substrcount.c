//count the substring matches
#include<stdio.h>
void main(){
    printf("Enter a string ");
    char str[50];
    char substr[50];
    scanf("%s",str);
    printf("Enter a substring ");
    scanf("%s",substr);
    int count=0;
    int found=0;
    for(int i=0;str[i]!='\0';i++){
        int flag=1;
        for(int j=0;substr[j]!='\0';j++){
            if(str[i+j]!=substr[j]){
                flag=0;
                break;
            }
        }
        if(flag==1){
            count++;
            found=1;
        }
    }
    if(found==0)
    printf("\nString not found ");
    printf("\nCount=%d",count);


    return;

}