import java.util.*;   // importing classes from util package
class SortedArrayList<E> extends ArrayList<E> {    // Inheriting Our class from ArrayList
	
	public void addItem(E object) {    // Method for insertion of new element that will be used for next task
        add(object);					// This is inserting the element in the list
        Comparable<E> comparable = (Comparable<E>) object;    // Comparable object is used to compare new element with existing
        for (int a = size()-1; a > 0 && comparable.compareTo(get(a-1)) < 0; a--) // for loop is used for retrieving each element from list and compare with newly inserted element
            Collections.swap(this, a, a-1);					// Collections class is used to swap the high and low value for getting ascending order
	}
	
	public static void main(String []args){    // Main method for testing above code
		System.out.println("\n********* Task 1 Done*********\n");			// just printing message
		SortedArrayList<Integer> checkList = new SortedArrayList<Integer>();   // creating object of our newly created class
		checkList.addItem(27);
		System.out.println(checkList);
		checkList.addItem(25);					// Adding new elements in the list
		System.out.println(checkList);			// Printing list to check either it is storing the elements in ascending order or not
		checkList.addItem(1);
		System.out.println(checkList);
		checkList.addItem(55);                               
		System.out.println(checkList);
		checkList.addItem(-21);
		System.out.println(checkList);
		checkList.addItem(45);
		System.out.println(checkList);
		checkList.addItem(72);
		System.out.println(checkList);
		checkList.addItem(91);
		System.out.println(checkList);
	}
}