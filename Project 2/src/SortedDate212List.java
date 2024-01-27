/**
 * The SortedDate212List class extends the Date212List and represents a sorted list of Date212 elements.
 * The elements are added in an ascending order based on their date values.
 */
public class SortedDate212List extends Date212List{
	/**
     * Constructs a SortedDate212List by calling the constructor of the superclass to initialize the list.
     */
	public SortedDate212List() {
		// Calls constructor in the super class to initialize the list
		super();
	}
	
	/**
     * Adds a Date212 element to the sorted list maintaining ascending order by date values.
     * If the list is empty, the date is appended as the first element.
     * If the date is larger or equal to the last date, it's added to the end.
     * Otherwise, the method finds the correct position and inserts the new date.
     *
     * @param d The Date212 object to be added to the sorted list
     */
	public void add(Date212 d) {
		Date212Node date = new Date212Node(d);
		if (length == 0) {
			// If the list is empty, add date as the first element
			append(d);
		} else if (Integer.parseInt(d.getDate212()) >= Integer.parseInt(last.data.getDate212())) {
			// If the date is larger or equal to the last date, add to the end
			append(d);
		} else {
			// Find the correct position and insert the new date
			Date212Node current = first;
			Date212Node point = first.next;
			while (point != null && Integer.parseInt(d.getDate212()) > Integer.parseInt(point.data.getDate212())) {
				current = point;
				point = point.next;
			}
			// Insert new date node between current and point
			current.next = date;
			date.next = point;
			length++;
		}
	}
}