// substring match by checking 2 alternative character.
#include<stdio.h>
void main(){
    printf("Enter a string ");
    char str[50];
    char substr[50];
    scanf("%s",str);
    printf("Enter a substring ");
    scanf("%s",substr);

    int found=0;
    for(int i=0;str[i]!='\0';i++){
        int skip=0;
        int flag=1;
        for(int j=0;substr[j]!='\0';j++){
            if(str[i+j+skip]!=substr[j]){
                flag=0;
                break;
            }
            else
                skip+=2;
        }
        if(flag==1){
            printf("%s is found",substr);
            found=1;
            return;
 
        }
    }
    printf("\nString not found ");
    return;

}