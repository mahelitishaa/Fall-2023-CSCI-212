/**
 * The Date212Node class represents a node in a linked list structure containing Date212 data.
 */
public class Date212Node {
    protected Date212 data; // The Date212 object stored in the node 
    protected Date212Node next; // Reference to the next Date212Node in the list

    /**
     * Constructs a Date212Node with the provided Date212 object.
     *
     * @param d The Date212 object to be stored in the node
     */
    public Date212Node(Date212 d) {
        this.data = d;
        this.next = null;
    }
}
