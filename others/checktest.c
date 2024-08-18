#include<stdio.h>
void main(){
    char ms[50];
    char ss[50];
    printf("Enter Main string :");
    scanf("%s",ms);
    printf("Enter Substring :");
    scanf("%s",ss);
    for(int i=0;ms[i]!='\0';i++){
        int flag=1;
        for(int j=0;ss[j]!='\0';j++){
            if(ms[i+j]!=ss[j]){
                flag=0;
                break;
            }
        }
        if(flag==1){
            printf("String found on index %d",i);
            return;
        }
    }
    printf("String not found ");
    return;
}