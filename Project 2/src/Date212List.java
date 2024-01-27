/**
 * The Date212List class represents an abstract list structure for Date212Node elements.
 * This class offers methods to manipulate and retrieve elements within the list.
 */
public abstract class Date212List {
  protected Date212Node first;
  protected Date212Node last;
  protected int length;

  /**
   * Constructs a Date212List object.
   */
  public Date212List() {
    first = new Date212Node(null);
    last = first;
    length = 0;
  }

  /**
   * Appends a new Date212Node with the given Date212 object to the end of the list.
   *
   * @param d The Date212 object to be appended to the list
   */
  public void append(Date212 d) {
    Date212Node newNode = new Date212Node(d);
    last.next = newNode;
    last = newNode;
    newNode.next = null;
    length++;
  }
    
  /**
   * Retrieves the length of the Date212List.
   *
   * @return The number of elements in the list
   */
  public int getLength(){
    return length;
  }
}