/* Vector.h */
#ifndef vector_h
#define vector_h
typedef struct Vector
{
	int size;
	int capacity;
	int *data;
}Vector;

Vector* new_Vector(int capacity);

int size(Vector *ptr);

int capacity(Vector *ptr);

int is_empty(Vector *ptr);

int at(Vector *ptr, int index);

void push(Vector *ptr, int item);

void insert(Vector *ptr, int index, int item);

void prepend(Vector *ptr, int item);

// Remove from end and return value
int pop(Vector *ptr);

// Delete item at index, shifting all trailing elements
int delete(Vector *ptr, int index);

// Looks for value and remove index holding it
void Remove(Vector *ptr, int item);

// Look for value and return the first index with that value
int find(Vector *ptr, int item);

// Resize the vector with new capacity
void resize(Vector *ptr, int new_capacity);

void print_Vector(Vector *ptr);

#endif /* Vector.h */