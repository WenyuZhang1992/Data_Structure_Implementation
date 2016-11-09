C=gcc
OBJ=Vector.o test.o

vector : Vector.o test.o
	$(C) -o vector $(OBJ)
test.o : test.c Vector.c Vector.h
	$(C) -c test.c
Vector.o : Vector.h Vector.c
	$(C) -c Vector.c

clean:
	rm -f $(OBJ)