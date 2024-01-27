/**
 * The UnsortedDate212List class extends the Date212List and represents an unsorted list of Date212 elements.
 * Elements are added to the end of the list without maintaining any specific order.
 */
public class UnsortedDate212List extends Date212List {
	/**
     * Constructs an UnsortedDate212List by calling the constructor of the superclass to initialize the list.
     */
	public UnsortedDate212List() {
		super();
	}
	
	/**
     * Adds a Date212 element to the unsorted list, placing it at the end of the list without maintaining any specific order.
     *
     * @param d The Date212 object to be added to the unsorted list
     */
	public void add(Date212 d){
		append(d); // Adds the Date212 object to the end of the list
	}	
}

