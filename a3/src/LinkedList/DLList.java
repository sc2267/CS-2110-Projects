package LinkedList;

/* Time spent on a3:  5 hours and 15 minutes.
 *
 * When you change the above, please do it carefully. Change hh to
 * the hours and mm to the minutes and leave everything else as is.
 * If the minutes are 0, change mm to 0. This will help us in
 * extracting times and giving you the average and max.
 * 
 * Name: Swastik Chaki 
 * Netid: sc2267
 * What I thought about this assignment:
 *Overall, I thought it was okay but there were some difficulties 
 *
 */

/** An instance is a doubly linked list. */
public class DLList<E>  {
    private Node first; // first node of linked list (null if size is 0)
    private Node last;  // last node of linked list (null if size is 0)
    private int size;   // Number of values in the linked list.

    /** Constructor: an empty linked list. */
    public DLList() {
    }

    /** Return the number of values in this list.
     *  This function takes constant time. */
    public int size() {
        return size;
    }

    /** Return the first node of the list (null if the list is empty). */
    public Node first() {
        return first;
    }

    /** Return the last node of the list (null if the list is empty). */
    public Node last() {
        return last;
    }

    /** Return the value of node n of this list.
     * Precondition: n is a node of this list; it may not be null. */
    public E value(Node n) {
        assert n != null;
        return n.val;
    }

    /** Return a representation of this list: its values, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * Takes time proportional to the length of this list.<br>
     * E.g. for the list containing 4 7 8 in that order, the result it "[4, 7, 8]".
     * E.g. for the list containing two empty strings, the result is "[, ]" */
    public String toString() {
        String res= "[";
        Node n= first;
        // inv: res contains values of nodes before node n (all of them if n = null),
        //      with ", " after each (except for the last value)
        while (n != null) {
            res= res + n.val;
            n= n.next;
            if (n != null) {
                res= res + ", ";
            }
        }

        return res + "]";
    }

    /** Return a representation of this list: its values in reverse, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * Note that gnirtSot is the reverse of toString.
     * Takes time proportional to the length of this list.
     * E.g. for the list containing 4 7 8 in that order, the result is "[8, 7, 4]".
     * E.g. for the list containing two empty strings, the result is "[, ]". */
    public String gnirtSot() { // Note: 
        //TODO 1. Look at toString to see how that was written.
        //        Use the same scheme. Extreme case to watch out for:
        //        E is String and values are the empty string.
        //        You can't test this fully until #2, prepend, is written.
    	      String res= "[";          // Create empty String 
          Node n= last;             // Start from end of list 
            while (n != null) {
               res= res + n.val;    // Adds each successive value to string 
               n= n.prev;
               if (n != null) {
                  res= res + ", ";   
              }
          }

          return res + "]";         // Returns string 
      }
    	 
    

    /** Add value v in a new node at the front of the list.
     * This operation takes constant time. */
    public void prepend(E v) {
        //TODO 2. After writing this method, test this method and
        //        method gnirtSot thoroughly before starting on the next
        //        method. These two must be correct in order to be
        //        able to write and test all the others.
    	    
    	    
    	    if (size==0) {                          // If value is first element is list 
	    	    	Node n= new Node(null,v,null);      // Creates new Node object 
	        first= n;                          // Sets first element to n 
	        size= size + 1;                   // Increases size 
	        last=n;                          // Sets last element to n 
    	    }
    	    else { 
	    	   	Node n= new Node(null,v,first);   // Creates new node object 
	    	   	size= size + 1;                  // Increases size 
	        first.prev= n;                   // Sets element before first to n 
	        first=n;                         // Sets first element to n 
    	    } 
       }

    /** add value v in a new node at the end of the list.
     *  This operation takes constant time. */
    public void append(E v) {
        //TODO 3. This is the third method to write and test
    	     if (size==0)  {                            // Checks if size is 0 
             Node p= new Node(null,v,null);         // Creates new node object 
             first=p;                              // Sets first and last element to p 
             last=p; 
             size=size+1;                         // Increases size 
    	     } 
    	     else { 
    	    	     Node p = new Node(last,v,null);      // Creates new node object 
    	    	     size=size + 1;                       // Increases 
    	    	     last.next=p;                        // Sets last.next= Node
    	    	     last= p;        
    	    	     
    	     }
    }


    /** Return node number k. 
     *  Precondition: 0 <= k < size of the list.
     *  If k is 0, return first node; if k = 1, return second node, ... */
    public Node getNode(int k) {
        //TODO 4. This method should take time proportional to min(k, size-k).
        // For example, if k <= size/2, search from the beginning of the
        // list, otherwise search from the end of the list.
        assert k>=0 && k< size ;              
        
        if (k<= (size/2)) {                   // Loop for first half 
        	  int a=0;             
        	  Node n= first; 
        	  if(a==k) {                          // Loops till node k is found 
     		   return n; 
        	  } 
        	  while (a<k) { 
        		  a++; 
        		  n=n.next; 
        		  if(a==k) { 
        		     return n; 
        	  }
        	  }
        } 
        else  {                               // Loop for second half 
        	  int b= size-1; 
        	  Node p= last; 
        	  if(b==k) { 
        		   return p; 
        	  } 
        	  while (b>(size-k)) {            // Loop till node k is found 
        		  b--; 
        		  p=p.prev; 
        		  if (b==k) { 
        			  return p; 
        		  }
        	  }
        	    
        }
        return null;
    }
    
    /** Remove node n from this list.
     * This operation must take constant time.
     * Precondition: n must be a node of this list; it may not be null. */
    public void delete(Node n) {
        //TODO 5. Make sure this method takes constant time. 
    	     assert n!= null; 
    	     if (n==first) {                  // Loop for if n is first element 
    	    	  first = n.next;         
    	      n.next.prev = null;            // Sets n to null 
    	      n = null;
    	      size = size - 1;               // Decreases size 
    	     }
    	     else if (n==last) {          // Loop for if n is last element 
    	   			last = n.prev;
    	   			n.prev.next = null;
    	   			n = null;
    	   			size = size - 1;
    	   		} else {                      // Loop for if n is in the middle 
    	   			n.next.prev = n.prev;
    	   			n.prev.next = n.next;
    	   			n = null;
    	   			size = size-1;             // Decreases size 
    	   		}
    	   }
    			
    

    /** Insert value v in a new node after node n.
     * This operation takes constant time.
     * Precondition: n must be a node of this list; it may not be null. */
    public void insertAfter(E v, Node n) {
        //TODO 6. Make sure this method takes constant time. 
    		assert n!=null;
   		if (n==last) {                            // Loop for if n is last element 
   			Node k = new Node(n, v, null);
   			n.next = k;
   			size = size + 1;                     // Increases size 
   			last = k;
   		} else {                                 // Loop for anything else 
   			Node k = new Node(n, v, n.next);
   			n.next = k;
   			k.next.prev = k;
   			size = size + 1;                     // Increases  size 
   		}
    }

 

    /*********************/

    /** An instance is a node of this list. */
    public class Node {
        private Node prev; // Previous node on list (null if this is first node)
        private E val;     // The value of this element
        private Node next; // Next node on list. (null if this is last node)

        /** Constructor: an instance with previous node p (can be null),
         * value v, and next node n (can be null). */
        Node(Node p, E v, Node n) {
            prev= p;
            val= v;
            next= n;
        }

        /** Return the node previous to this one (null if this is the
         * first node of the list). */
        public Node prev() {
            return prev;
        }

        /** Return the value of this node. */
        public E value() {
            return val;
        }

        /** Return the next node in this list (null if this is the
         * last node of this list). */
        public Node next() {
            return next;
        }
    }

}
