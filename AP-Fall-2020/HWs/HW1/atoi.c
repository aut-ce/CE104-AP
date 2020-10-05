#include<stdio.h>
#include<stdlib.h>
#include <string.h>

int main()
{
    int val;
    char str[20];

    fgets(str, sizeof(str), stdin);   
    val = atoi(str);
    printf("String value = %s, Int value = %d\n", str, val);
}
