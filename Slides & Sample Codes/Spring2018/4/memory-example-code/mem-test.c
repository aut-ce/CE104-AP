#include<stdio.h>
#include<stdlib.h>

int main()
{
   int i = 7;
   printf("&i = 0x%08x , i = %d\n", &i, i);

   int* p = malloc(sizeof(int));
   *p = 14;
   printf("&p = 0x%08x , p = 0x%08x , *p = %d\n", &p, p, *p);

   printf("sizeof(int) = %lu bytes , sizeof(void*) = %lu bytes\n", sizeof(int), sizeof(void*));

   return 0;
}
