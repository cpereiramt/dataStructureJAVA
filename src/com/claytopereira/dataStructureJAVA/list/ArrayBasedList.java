package com.claytopereira.dataStructureJAVA.list;

/** - Implementing List as Array 
 *  - Must be allocated at some fixed size
 *  - the size of the array must be known when the list is created
 * */
public class ArrayBasedList<E> implements ListADT<E> {
   private static final int defaultSize = 10; // Default Size
   private int maxSize; // Maximum size of list
   private int listSize; // Current # of list items
   private int curr;  // Position of current element
   private E[] listArray; // Array holding list elements
	
	
   /** Constructors */
   /** Create a list with the default capacity 
    * */
   
     ArrayBasedList() {
    	 this(defaultSize);
     } 


     /** Create a new list object.
     @param size Max # of elements list can contain. */
     @SuppressWarnings("unchecked") // Generic array allocation
	ArrayBasedList(int size) {
    	 maxSize = size;
    	 listSize = curr = 0;
    	 listArray = (E[]) new Object[size]; //Create listArray
     }



	@Override
	public void clear() { // Reinitialize the list
		// TODO Auto-generated method stub
		listSize = curr = 0; // Simply reinitialize values		
	}

	@Override
	/** Insert a item at current position
	*/	
	public void insert(E item) {
		// TODO Auto-generated method stub
		assert listSize < maxSize : "List capacity exceeded"; 
		for (int i=listSize; i>curr; i--) // Shift elements up
			listArray[i] = listArray[i-1]; // to make room
		listArray[curr] = item;
		listSize++; // Increment list size
		
	}
	@Override
	/** Append item to list*/
	public void append(E item) {
		// TODO Auto-generated method stub
		assert listSize < maxSize : "List capacity exceeded";
		listArray[listSize++] = item;
	}

	@Override
	/** Remove and return the current element */
	public E remove() {
		// TODO Auto-generated method stub
		if(curr<0 || (curr>=listSize)) // No current element
			return null;
		E item = listArray[curr]; // Copy the element
		for (int i=curr; i<listSize-1; i++) // shift them down
			listArray[i] = listArray[i+1];
	    listSize--; // Decrement size
	    return item;
	}

	@Override
	public void moveToStart() {
		// TODO Auto-generated method stub
		curr = 0; // Set to front
	}

	@Override
	public void moveToEnd() {
		// TODO Auto-generated method stub
		curr = listSize; // Set at end
	}

	@Override
	public void prev() {
		// TODO Auto-generated method stub
		if(curr != 0) curr--; // Back up
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		if(curr < listSize) curr++; 
	}

	@Override
	/** @return Lists size */
	public int length() {
		// TODO Auto-generated method stub
		return listSize;
	}

	@Override
	/** @return current position */
	public int currPos() {
		// TODO Auto-generated method stub
		return curr;
	}

	@Override
	/** Set current list position to "pos"*/
	public void moveToPos(int pos) {
		// TODO Auto-generated method stub
		assert (pos>=0) && (pos<=listSize) : "Position out of range";
		curr = pos;
	}

	@Override
	/** @return Current element */
	public E getValue() {
		// TODO Auto-generated method stub
		assert (curr>=0) && (curr<listSize) :
			"No current element";
		return listArray[curr];
	}

}
