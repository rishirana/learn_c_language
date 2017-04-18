#include<stdio.h>
int main(){
	int number = 0;
	printf("Enter an integer:");
	scanf("%d",&number);
	if (number>10)
	{
		printf("you entered %d which is greater than 10\n",number );
	}

	if (number<10)
	{
		printf("you entered %d which is less than 10\n",number );
	} 

	return 0;
}



#include<stdio.h>
int main(){

   /*local variable definition*/
	int i;
	/*do loop execution */
	do {
         printf("Value of a : %d\n",a);
         a=a+1;
         }while(a<20);
	 
	return 0;
	}
}


while(a)
{
	 while(b)
	 {
	 	if(b==10)
	 	{
	 		break;
	 	}
	 }
	 // break will bring us here.
}
//

#include<stdio.h>
int main()
{
	int a = 10;
	while(a<20)
	{
		if (a==15)
		{
			// skip the iteration
			a = a+1;
			continue;
		}
		printf("value of a : %d\n", a );
		a++;
	}
	return 0;
}

//int is datatype , a is array name , 10
 is size of array
   int a[10];
   ...
   float f[13];
   char name[15];
   double d[23];


int a[10] = {2,3,4,5,6,7,8,9,10,11};

//initialize to 1,2,0,0,0,...
int a[10] = {1,2};

//all element 0
int a[10] = { 0 };

char name[15] = "rishi";


#include<stdio.h>

int main(){

	 int a[10] = {2,3,4,5,6,7,8,9,10,11};
	 int i = 0;
	 int lengthofArray = sizeof(a)/sizeof(int);
	 
}