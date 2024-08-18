//check given reversed substring is present or not in the main string.
#include<stdio.h>
#include<string.h>
char* rev(char str[]){
    int size=strlen(str);
    static char res[50];
    int j=0;
    for(int i=size-1;i>=0;i--){
        res[j++]=str[i];
    }
    res[j]='\0';
    return res;
}
void main(){
    char ms[50];
    char ss[50];
    printf("Enter main string :");
    scanf("%s",ms);
    printf("Enter Substring :");
    scanf("%s",ss);
    char* res=rev(ss);
    
    for(int i=0;i<ms[i]!='\0';i++){
        int flag=1;
        for(int j=0;res[j]!='\0';j++){
            if(ms[i+j]!=res[j]){
                flag=0;break;
            }
        }
        if(flag==1){
            printf("String is present on index %d",i+strlen(ss)-1);
            return;
        }
    }
    printf("String is not found ");
    return;

}