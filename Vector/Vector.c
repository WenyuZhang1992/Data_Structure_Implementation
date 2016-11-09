#include <stdio.h>
#include <stdlib.h>

#include "Vector.h"

Vector* new_Vector(int capacity)
{
	Vector *ptr = malloc(sizeof(Vector));

	ptr->capacity = capacity;
	ptr->size = 0;
	ptr->data = (int *)malloc(sizeof(int)*capacity);

	return ptr;
}

int size(Vector *ptr){
	return ptr->size;
}

int capacity(Vector *ptr){
	return ptr->capacity;
}

int is_empty(Vector *ptr){
	if (ptr->size == 0)
		return 1;
	return 0;
}

int at(Vector *ptr, int index){
	if (index >= ptr->size){
		printf("Error: Index out of bound!\n");
		exit(-1);
	}
	return *(ptr->data+index);
}

void push(Vector *ptr, int item){
	if (ptr->size + 1 > ptr->capacity){
		resize(ptr, 2*ptr->capacity);
	}
	*(ptr->data+ptr->size) = item;
	ptr->size++;
}

void insert(Vector *ptr, int index, int item){
	if (index > ptr->size){
		printf("Error: Index out of bound!\n");
		exit(-1);
	}
	if (ptr->size + 1 > ptr->capacity){
		resize(ptr, 2*ptr->capacity);
	}
	for (int i=ptr->size; i>index; i--){
		*(ptr->data+i) = *(ptr->data+i-1);
	}
	*(ptr->data+index) = item;
	ptr->size++;
}

void prepend(Vector *ptr, int item){
	insert(ptr, 0, item);
}

int pop(Vector *ptr)
{
	if (is_empty(ptr)){
		printf("Error: Can not pop from empty vector.\n");
		exit(-1);
	}
	int temp = *(ptr->data+ptr->size-1);
	ptr->size--;
	return temp;
}

int delete(Vector *ptr, int index)
{
	if(index >= ptr->size){
		printf("Error: Index out of bound!\n");
		exit(-1);
	}
	int temp = *(ptr->data+index);
	for (int i=index; i<ptr->size-1; i++){
		*(ptr->data+i) = *(ptr->data+i+1);
	}
	ptr->size--;
	return temp;
}

void Remove(Vector *ptr, int item){
	int i=0;
	do{
		for (i=0; i<ptr->size; i++){
			if (*(ptr->data+i) == item){
				delete(ptr, i);
				break;
			}
		}
	}while(i < ptr->size-1);
}

int find(Vector *ptr, int item)
{
	int count = 0;
	for (int i=0; i<ptr->size; i++){
		if (*(ptr->data+i) == item){
			return i;
		}
	}
	if (count == 0)
		return -1;
}

void resize(Vector *ptr, int new_capacity)
{
	ptr->capacity = new_capacity;
	int *new_data = (int*)malloc(new_capacity*sizeof(int));
	for (int i=0; i<ptr->size; i++){
		*(new_data+i) = *(ptr->data+i);
	}
	ptr->data = new_data;
}

void print_Vector(Vector *ptr)
{
	printf("[ ");
	for (int i=0; i<ptr->size; i++){
		printf("%d ", *(ptr->data+i));
	}
	printf("]\n");
}