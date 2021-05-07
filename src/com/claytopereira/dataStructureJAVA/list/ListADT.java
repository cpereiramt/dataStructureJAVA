package com.claytopereira.dataStructureJAVA.list;

public interface ListADT<E> {
	/** Remove all contents from the list, so it is once again empty. Client is responsible for reclaiming storage 
	 * used by the list elements 
	  */
	public void clear();
	
	/** Insert an element at the current location, The client must ensure that the list's capacity is not exceed .
	 * @param item The element to be inserted .
	*/
	
	public void insert(E item);
	
	/** Append an element at the end of the list, The client must ensure that the list's capacity is not exceed.
	 * @param item The element to be appended .
	 * 
	 */
	public void append(E item);
	
	/** Remove and return the current element. 
	 * @return The element that was removed .
	 */
	public E remove();
	
	/** Set the current position to the start of the list
	*/
	public void moveToStart();
	
	/** Set the current position to the end of the list
	 */	
    public void moveToEnd();
    
    /** Move the current position one step left. No change
     *  if already at beginning 
     */
    
    public void prev();
    
    /** Move the current position one step right. No change 
     * if already at end
     */
	 public void next();
	 
	 /** @return The number of elements in the list 
	  */
	 public int length();
	 
	 /** @return The position of the current element
	  */
	 public int currPos();
	 
	 /** Set current position
	  * @params pos The position to make current.
	  */
	 public void moveToPos(int pos);
	 
	 /** @return The current element
	  */
	 public E getValue();
	 
	 /** @return True if k is in list L, false otherwise */
	 public static boolean find(ListADT<Integer> L, int k) {
	 for (L.moveToStart(); L.currPos()<L.length(); L.next())
	 if (k == L.getValue()) return true; // Found k
	 return false; // k not found
	 }
}
