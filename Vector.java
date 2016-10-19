/* Vector.java*/
// Implementation of vector, aka mutable array with automatic resizing
// Provide basic methods related to the vector

class Vector{

	public int size; // Number of items in the vector
	public int capacity;  // Capacity of the vector
	public int[] a; // Array

	public Vector(){
		size = 0;
		capacity = 16;
		a = new int[16];
	}

	// Return number of items
	public int size(){
		return size;
	}

	// Return the capacity of the vector
	public int capacity(){
		return capacity;
	}

	// Check if the vector is empty
	public boolean is_empty(){
		if (size == 0){
			return true;
		}
		return false;
	}

	// Return items at given index
	public int at(int index){
		if (index >= size){
			System.out.println("Error: Index out of bound");
			return -9999;
		}
		return a[index];
	}

	// Push item at the end of the vector
	public void push(int item){
		if (size + 1 > capacity){
			resize(2*capacity);
		}
		a[size] = item;
		size++;
	}

	// Insert an item at index
	public void insert(int index, int item){
		if (index >= size && index != 0){
			System.out.println("Error: Index out of bound!\n");
			return;
		}
		if (size + 1 > capacity){
			resize(capacity*2);
		}
		for (int i=size; i > index; i--){
			a[i] = a[i-1];
		}
		a[index] = item;
		size++;
	}

	// Insert item at index 0
	public void prepend(int item){
		insert(0, item);
	}

	// Remove item from the end
	public int pop(){
		if (size == 0){
			System.out.println("Error: can't pop from empty vector.");
			return -9999;
		}
		int output = a[size-1];
		size--;
		if (size == capacity/4){
			resize(capacity/4);
		}
		return output;
	}

	// Delete item at index
	public void delete(int index){
		if (size == 0 || index >= size){
			System.out.println("Error!");
			return;
		}
		for (int i = index; i < size; i++){
			a[i] = a[i+1];
		}
		size--;
		if (size == capacity/4){
			resize(capacity/4);
		}
	}

	// Look for value and remove index holding it
	public void remove(int item){
		int check = find(item);
		while(check != -1){
			delete(check);
			check = find(item);
		}
	}

	// Look for value and return first index with that value
	public int find(int item){
		int index = -1;
		for (int i=0; i < size; i++){
			if (a[i] == item){
				index = i;
				break;
			}
		}
		return index;
	}

	// Resize the vector with the new capacity
	public void resize(int new_capacity){
		int[] b = new int[new_capacity];
		for (int i=0; i < size; i++){
			b[i] = a[i];
		}
		a = b;
		capacity = new_capacity;
	}

	public void printData(){
		System.out.print("[ ");
		for (int i=0; i<size; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("]");
	}

	// For test only
	public static void main(String[] args){

		// Construct a vector instance
		Vector v = new Vector();

		// Test is_empty(), size(), capacity, push()
		System.out.print("The result of v.is_empty() is true: ");
		System.out.println(v.is_empty());
		v.push(1);
		v.push(2);
		v.push(3);
		v.push(3);
		v.printData();
		System.out.print("The result of v.is_empty() is false: ");
		System.out.println(v.is_empty());
		System.out.print("The size of the vector is 4: ");
		System.out.println(v.size());
		System.out.print("The capacity of the vector is 16: ");
		System.out.println(v.capacity());

		System.out.print("The item at index 0 is 1: ");
		System.out.println(v.at(0));
		System.out.print("The item at index 2 is 3: ");
		System.out.println(v.at(2));

		System.out.print("After insertion, the vector is [ 1 2 4 3 3 ]: ");
		v.insert(2, 4);
		v.printData();

		System.out.println("The size of the vector now is 5: " + v.size());
		System.out.print("After insertion, the vector is [ 1 2 4 3 5 3 ]: ");
		v.insert(4, 5);
		v.printData();

		System.out.print("After prepending, the vector is [ 6 1 2 4 3 5 3 ]: ");
		v.prepend(6);
		v.printData();

		System.out.print("After popping, the vector is [ 6 1 2 4 3 5 ]: ");
		v.pop();
		v.printData();

		System.out.print("After deleting item at index 2, the vector is [ 6 1 4 3 5 ]: ");
		v.delete(2);
		v.printData();

		System.out.print("After removing item 6, the vector is [ 1 4 3 5 ]: ");
		v.remove(6);
		v.printData();
		System.out.println("The capacity of the vector now is 4: " + v.capacity());

		System.out.println("The index of item 4 is 1: " + v.find(4));

	}

}