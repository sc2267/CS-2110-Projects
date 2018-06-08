package student;

/** NetId(s): sc2267 . Time spent: 4 hours, 45 minutes.

*
* Please be careful in replacing nnnn by netids and hh by hours and
* mm by minutes. Any mistakes cause us to have to fix this manually
* before extracting times, in order to give you the max and median and mean.
* Thanks
* 
* Name(s): Swastik Chaki 
* What I thought about this assignment:
* I thought some parts were difficult but I was able to push through and finish it off.  
*
*/
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import graph.Edge;
import graph.Node;

/** This class contains the shortest-path algorithm and other methods. */
public class Paths {

    /** Return the shortest path from start to end ---or the empty list
     * if a path does not exist.
     * Note: The empty list is NOT "null"; it is a list with 0 elements. */
    public static List<Node> minPath(Node start, Node end) {
        /* TODO Read Piazza note Assignment A7 for ALL details. */
    	Heap<Node> Heap1 = new Heap<Node>(true);
       	HashMap<Node, SF> Hashmap1 = new HashMap<Node, SF>();
       	
        Heap1.add(start, 0);
       	Hashmap1.put(start,  new SF(null,0));
       
       	
       	
       	while (Heap1.size() > 0) {
       		
       	Node Node1 = Heap1.poll();
       	if (Node1.equals(end)) { 
       		return makePath(Node1, Hashmap1);
       	}
       	else if  (Node1.getExitsSize() == 0) { 
       		return new LinkedList<Node>();
       	} 
       	else { 
       		
       		for (Edge Edge1 : Node1.getExits()) {
       			
       			int x = Hashmap1.get(Node1).distance;
       			Node w = Edge1.getOther(Node1);
       			if (!Hashmap1.containsKey(w)) {
       				
       				
       				x = Edge1.length + Hashmap1.get(Node1).distance;
       				Heap1.add(w, x);
       				Hashmap1.put(w, new SF(Node1, x));
       	    		
       			}
       			else if (Hashmap1.get(w).distance > x + Edge1.length) {
       				
       				
       				    Heap1.updatePriority(w, x + Edge1.length);
       					Hashmap1.replace(w, new SF(Node1, x + Edge1.length));
       					
       				}
       			}
       		}
       		
       	}
        
       	
        
        
        

        // no path from start to end ---there should be no need to
        // change this if you followed instructions and put all your code
        // above this.
        return new LinkedList<Node>();
    }


    /** Return the path from the start node to node end.
     *  Precondition: data contains all the necessary information about
     *  the path. */
    public static List<Node> makePath(Node end, HashMap<Node, SF> data) {
        List<Node> path= new LinkedList<Node>();
        Node p= end;
        // invariant: All the nodes from p's successor to the end are in
        //            path, in reverse order.
        while (p != null) {
            path.add(0, p);
            p= data.get(p).backPtr;
        }
        return path;
    }

    /** Return the sum of the weights of the edges on path p. */
    public static int pathWeight(List<Node> p) {
        if (p.size() == 0) return 0;
        synchronized(p) {
            Iterator<Node> iter= p.iterator();
            Node v= iter.next();  // First node on path
            int sum= 0;
            // invariant: s = sum of weights of edges from start to v
            while (iter.hasNext()) {
                Node q= iter.next();
                sum= sum + v.getEdge(q).length;
                v= q;
            }
            return sum;
        }
    }

    /** An instance contains information about a node: the previous node
     *  on a shortest path from the start node to this node and the distance
     *  of this node from the start node. */
    private static class SF {
        private Node backPtr; // backpointer on path from start node to this one
        private int distance; // distance from start node to this one

        /** Constructor: an instance with backpointer p and
         * distance d from the start node.*/
        private SF(Node p, int d) {
            distance= d;     // Distance from start node to this one.
            backPtr= p;  // Backpointer on the path (null if start node)
        }

        /** return a representation of this instance. */
        public String toString() {
            return "dist " + distance + ", bckptr " + backPtr;
        }
    }
}
