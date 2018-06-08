package LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DDListTest {


          @Test
            public void testConstructor() {
                   DLList<Integer> b= new DLList<Integer>(); 
                   assertEquals("[]", b.toString()); 
                   assertEquals("[]", b.gnirtSot()); 
                   assertEquals(0, b.size());
             }
	      
          @Test
		     public void testprepend() { 
		        DLList<Integer> newList= new DLList<Integer>(); 
		        DLList<String>  StringList= new DLList<String>(); 
		        DLList<String>  StringList2= new DLList<String>(); 
				newList.prepend(65);
			    newList.prepend(86);
			    newList.prepend(543);
			    newList.prepend(687);
			    StringList.prepend(""); 
			    StringList.prepend(""); 
			    StringList.prepend("");
			    StringList2.prepend("Lebron");
			    StringList2.prepend("Kawhi");
			    StringList2.prepend("Durant");
			    	assertEquals("[687, 543, 86, 65]",newList.toString()); 
			    assertEquals("[65, 86, 543, 687]",newList.gnirtSot()); 
			    assertEquals(4,newList.size()); 
			    assertEquals("[, , ]", StringList.toString()); 
			    assertEquals("[, , ]", StringList.gnirtSot()); 
			    assertEquals(3,StringList.size()); 
			    assertEquals("[Lebron, Kawhi, Durant]",StringList2.gnirtSot()); 
			    assertEquals("[Durant, Kawhi, Lebron]",StringList2.toString()); 
			    assertEquals(3,StringList2.size()); 
          } 
          
          @Test
		     public void testappend() { 
        	        DLList<Integer> list1= new DLList<Integer>(); 
		        DLList<String>  list2= new DLList<String>(); 
		        list1.append(7);
			    list1.append(27);
			    list1.append(47);
			    list2.append("Lebron");
			    list2.append("Kawhi");
			    list2.append("Durant");
			    list2.append("Harden");
			    assertEquals("[7, 27, 47]",list1.toString()); 
			    assertEquals("[47, 27, 7]",list1.gnirtSot()); 
			    assertEquals(3,list1.size()); 
			    assertEquals("[Lebron, Kawhi, Durant, Harden]", list2.toString()); 
			    assertEquals("[Harden, Durant, Kawhi, Lebron]",list2.gnirtSot()); 
			    assertEquals(4,list2.size()); 
			 }
          
          @Test
		     public void testgetNode() { 
        	          DLList<Integer> James = new DLList<Integer>(); 
        	          DLList<String> Durant = new DLList<String>(); 
                  James.prepend(4);
                  James.prepend(87);
                  James.prepend(56);
                  James.prepend(54);
                  Durant.prepend("Lebron"); 
                  Durant.prepend("Booker");
                  DLList<Integer>.Node node= James.first().next().next();
                  DLList<Integer>.Node node1= James.first();
                  DLList<String>.Node node2= Durant.first().next(); 
                  assertEquals(node, James.getNode(2)); 
                  assertEquals(node1, James.getNode(0)); 
                  assertEquals(node2, Durant.getNode(1)); 
                  assertThrows(AssertionError.class, ()->{Durant.getNode(10);});
                  assertThrows(AssertionError.class, ()->{James.getNode(-2);});
              } 
          @Test
             public void testdelete() { 
        	          DLList<Integer> Lebron = new DLList<Integer>(); 
        	          DLList<String> Jordan = new DLList<String>(); 
        	          Lebron.prepend(23); 
        	          Lebron.prepend(6);
        	          Lebron.prepend(32);
        	          Lebron.prepend(54);
        	          Jordan.prepend("Michael");
        	          Jordan.prepend("Gary");
        	          Jordan.prepend("Payton");
        	          Jordan.prepend("Hakeem");
        	          Lebron.delete(Lebron.getNode(2));
        	          assertEquals("[54, 32, 23]",Lebron.toString()); 
        	          Lebron.delete(Lebron.getNode(2));
        	          assertEquals("[54, 32]", Lebron.toString()); 
        	          Jordan.delete(Jordan.getNode(1)); 
        	          assertEquals("[Hakeem, Gary, Michael]",Jordan.toString()); 
        	          Jordan.delete(Jordan.getNode(2));
        	          assertEquals("[Hakeem, Gary]", Jordan.toString());        
        	          assertThrows(AssertionError.class, ()->{Jordan.delete(null);});
        	          assertThrows(AssertionError.class, ()->{Lebron.delete(null);});
          }   
          
          @Test
              public void testinsertAfter() { 
        	         DLList<Integer> Larry = new DLList<Integer>(); 
	             DLList<String> Bird = new DLList<String>(); 
	             Larry.append(3);
	             Larry.append(9);
	             Bird.append("Charles");
	             Bird.append("Barkley");
	             Bird.append("Kobe");
	             Bird.insertAfter("Bryant", Bird.getNode(2));
	             Larry.insertAfter(12, Larry.getNode(1)); 
	             assertEquals("[3, 9, 12]", Larry.toString()); 
	             Larry.insertAfter(14, Larry.getNode(1)); 
	             assertEquals("[3, 9, 14, 12]", Larry.toString()); 
	             assertEquals("[Charles, Barkley, Kobe, Bryant]", Bird.toString()); 
	             assertThrows(AssertionError.class, ()->{Bird.insertAfter("OL", Bird.getNode(45));});
	             assertThrows(AssertionError.class, ()->{Larry.insertAfter(45, Larry.getNode(45));});
	         } 
        	          
          }
          
			    
	


