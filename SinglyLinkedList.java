import java.util.Scanner;
public class SinglyLinkedList{
  public Node head;
  public Node tail;
  public int size;

  public Node createSinglyLinkedList(int data) {
    head = new Node();
    Node node = new Node();
    node.next = null;
    node.value = data;
    head = node;
    tail = node;
    size = 1;
    return head;
  }

  // Insert Method SinglyLinkedList
  public void insertInLinkedList(int nodeValue, int location) {
    Node node = new Node();
    node.value = nodeValue;
    if (head == null) {
      createSinglyLinkedList(nodeValue);
      return;
    } else if (location == 0) {
      node.next = head;
      head = node;
    } else if (location >= size) {
      node.next = null;
      if(tail != null){
      tail.next = node;
      }
      tail = node;
    } else {
      Node tempNode = head;
      int index = 0;
      while (index < location - 1) {
        tempNode = tempNode.next;
        index++;
      }
      Node nextNode = tempNode.next;
      tempNode.next = node;
      node.next = nextNode;
    }
    size++;
  }

  // SinglyLinkedList Traversal
  public void traverseSinglyLinkedList() {
    if (head == null) {
      System.out.println("SLL does not exist!");
    } else {
      Node tempNode = head;
      for (int i = 0; i<size; i++) {
        System.out.print(tempNode.value);
        if (i != size - 1) {
          System.out.print(" -> ");
        }
        tempNode = tempNode.next;
      }
    }
    System.out.println("\n");
  }

  // Search for a node

  boolean searchNode(int nodeValue) {
    if (head != null) {
      Node tempNode = head;
      for (int i=0; i<size; i++) {
        if (tempNode.value == nodeValue) {
          System.out.print("Found the node at location: " +i+"\n");
          return true;
        }
        tempNode = tempNode.next;
      }
    }
    System.out.print("Node not found! ");
    return false;
  }

  //Deleting a node from SinglyLinkedList
  public void deletionOfNode(int location) {
    if (head == null) {
      System.out.println("The SLL does not exist");
      return;
    } else if (location == 0) {
      head = head.next;
      size--;
      if (size == 0) {
        tail = null;
      }
    } else if (location >= size) {
      Node tempNode = head;
      for (int i = 0; i < size - 1; i++) {
        tempNode = tempNode.next;
      }
      if (tempNode == head) {
        tail = head = null;
        size--;
        return;
      }
      tempNode.next = null;
      tail = tempNode;
      size--;
    } else {
      Node tempNode = head;
      for (int i = 0; i <location-1; i++) {
        tempNode = tempNode.next;
      }
      tempNode.next = tempNode.next.next;
      size--;
    }
  }

//  Delete Entire SinglyLinkedList
public void deleteSLL() {
  head = null;
  tail = null;
  System.out.println("The SLL deleted successfully");

}
public int noofnodes(){
    if(head==null){
      return -1;
    }
    else {
      int count=0;
      Node temp =head;
     while(temp.next!=null){
       temp =temp.next;
       count++;
     }
     return  count;
    }

}
public void removeDuplicacySortedList(SinglyLinkedList sll){
    Node temp= sll.head;
  SinglyLinkedList sll1= new SinglyLinkedList();
    int add=0;
    //sll1.head=temp;  -->>it gave different answer why ??
    while(temp!=null) {
      if (temp.next!=null && temp.value == temp.next.value ) {
        //if we change a && b to b && a ,we get here
        // null pointer exception so,we can find a way to avoid null pointer exception -->> vvi
        temp = temp.next;  //continue;-- optional
      } else {
        sll1.insertInLinkedList(temp.value, add++);

      }
      temp=temp.next;
    }
  System.out.println("Linked List: after removing duplicates");
  sll1.traverseSinglyLinkedList();
  }


public void mergelinkedlist(SinglyLinkedList sll,SinglyLinkedList sll2){
    Node temp1=sll.head;
    Node temp2 = sll2.head;
    SinglyLinkedList sll3 =new SinglyLinkedList();
    int i=0;

    while(temp1!=null && temp2!= null){
      if(temp1.value< temp2.value ){
        sll3.insertInLinkedList(temp1.value,i++);
        temp1=temp1.next;
         }

      else if(temp1.value>temp2.value){
        sll3.insertInLinkedList(temp2.value,i++);
        temp2=temp2.next;
      }
      else {
        while (temp1.value != temp2.value) {
          sll3.insertInLinkedList(temp1.value, i++);
        }
      }

    }
    while(temp1!=null){
      sll3.insertInLinkedList(temp1.value,i++);
      temp1=temp1.next;
    }
    while(temp2!=null){
      sll3.insertInLinkedList(temp2.value,i++);
      temp2=temp2.next;
    }
  System.out.println("total number of elements in merged list is "+i+"\n");
    sll3.traverseSinglyLinkedList();
  System.out.println("yes you did it well.");
} // any linked list problem we get if you don't get general idea then think of :-
  //1>cycle detection:-fast and slow pointer method
  //2>reversal of linked list approach
// fast and slow pointer method:--
//  1> cycle detection in list
//  2> find a node in cycle detection in list 
public boolean cycle_detection_list (SinglyLinkedList sll){
       Node fast=sll.head;
       Node slow=sll.head;
       while(fast!=null && fast.next!=null){
         fast=fast.next.next;
         slow=slow.next;
         if(fast==slow){
           //here cycle detection end
           //calculating cycle length:-
           Node temp = slow;
           int length=0;
           do{
             //vvi ->>here we can't apply while loop as temp value and restricting condition are just opposite.
             temp = temp.next;
             //here we can access element also using temp.value
             length++;
           } while(temp!= slow);
           System.out.println("length of cycle in ll is "+length);

           return true;
         }
       }
       return false;
   //    cyclePresentInList(sll); // here we get unreachable statement as
  //  return statement is previous line and the time of ending the execution of function call will come
}
public void cyclePresentInList(SinglyLinkedList sll){
  if(sll.cycle_detection_list(sll)){
    System.out.println("linked list is present");
  }
  else {
    System.out.println("ll is not present");
  }
}
// amazon and microsoft
public int lengthCycle(Node head){
    Node fast =head;
    Node slow=head;
    while(fast!= null && fast.next!=null){
        fast=fast.next.next;
        slow =slow.next;
        if(fast==slow){
          Node temp=slow;
          int length =0;
          do{
            temp=temp.next;
            length++;
          }while(temp!=null);
          return length;
        }

    }
    return 0;
}
//linked list cycle finding starting point of cycle :=
  //step 1:- find length of the cycle
  //step 2:- move s ahead by length of the cycle
  //step 3:- move s and f one by one ,it will meet at start at cycle
public Node detectCycle(Node head) {
  int length = 0;
Node fast = head;
Node slow =head;
while(fast!=null && fast.next != null){
  fast=fast.next.next;
  slow = slow.next;
  if(fast==slow){
    length=lengthCycle(slow);
    break;
  }
}
if(length == 0){
   return  null;
}
 Node f= head;
 Node s= head;
 while(length>0){
   s=s.next;
   length--;
 }
   //keep moving forward and they will meet at starting point of cycle
    while(f!=s){
       f=f.next;
       s=s.next;
 }
    return s;

}

// happy number :-- google interview question:-
// input =19 output :-true
// explanation:-
// 1^2+9^2= 82
// 8^2+2^2=68
// 6^2 +8^2 =100
//1^2+0^2+0^2=1
// it means given number is a happy number:-
//we get TLE error,if it's not a happy number.how?
// for ex:= 12 as input
//1^2+2^2= 5
// 5^2=25
// 2^2 +5^2 =29
//2^2+9^2=85    <<--------
 //8^2+5^2= 89           |
  // 8^2+9^2=145         |
  // 1^2+4^2+5^2=42      |  //repeatedly and cause rtl error
  // 4^2+2^2=20          |
  //2^2+0^2=4            |
  //4^2=16               |
  //1^2+6^2=37           |
  // 3^2+7^2=58          |
  //5^2+8^2=85   <<------
  //so, in list :- [5]->[25]->[29]->[85]->[89]->[145]->-
  //                                  ^                 |
  //              --------------------^                 |
  //              |                                     |
  //              |                                     /
  //              -- [58]<-[37]<-[16]<-[4]<-[20]<-[42]<-


    public static boolean isHappyNumber(int n){
      int slow = n;
      int fast = n;
      do {
          slow= findSquare(slow);
          fast= findSquare(findSquare(fast));
      } while(slow!=fast);
      if(slow ==1){
          System.out.println("given number is happy number");
          return true;
      }
        System.out.println("given number is not a happy number" );
      return false;
    }
public static int findSquare(int num){
    int ans =0;
    while(num>0){
        int b = num%10;
        ans+=b*b;
        num/=10;
    }
    return ans;
}


//middle of the linked list:--
// method 1:-using length and move the pointer by length/2
//method 2:-using slow and fat pointer approach
    public int middleNode(Node head){
      Node slow =head;
      Node fast =head;
        while(fast!=null && fast.next!=null){
          slow=slow.next;
          fast=fast.next.next;
      } ;
       // System.out.println("middle of the linked list is "+slow.value);
      return slow.value;
    }

//sorting in ascending order by merge sort

    public SinglyLinkedList sortedlist(){
      SinglyLinkedList sll =new SinglyLinkedList();

      return sll;
    }
    public void divide(SinglyLinkedList sll,int start,int end){
      if(start>=end){
          return;
      }
      int mid=start+(end-start)/2;
      divide(sll,start,mid);
      divide(sll,mid+1,end);

    }
   public void merge(SinglyLinkedList sll,Node start,Node mid, Node end){
      SinglyLinkedList mergedList = new SinglyLinkedList();
      Node temp1= start;
      Node temp2=mid.next;
      while(temp1<=mid && temp2<end){
          if(temp1.value)
      }

   }




























































































  public static void main(String[] args) {
    SinglyLinkedList sll =new SinglyLinkedList();

    // Create the singly linked list with an initial value
    //sll.createSinglyLinkedList(4);

    // Insert nodes into the linked list
    sll.insertInLinkedList(2, 0);  // Insert 2 at the beginning
    sll.insertInLinkedList(6, 1);  // Insert 6 at index 1
    sll.insertInLinkedList(80, 2);  // Insert 8 at index 2
     sll.insertInLinkedList(80, 3);  // Insert 8 at index 2
    sll.insertInLinkedList(80, 4);  // Insert 8 at index 2
    sll.insertInLinkedList(110, 10); // Insert 10 at an index larger than the size
    sll.insertInLinkedList(115, 10); // Insert 10 at an index larger than the size

    // Traverse and print the linked list
    System.out.println("Linked List:");
    sll.traverseSinglyLinkedList();

    // Search for a node
//    int searchValue = 6;
//    if (sll.searchNode(searchValue)) {
//      System.out.println("Found " + searchValue + " in the linked list.");
//    } else {
//      System.out.println(searchValue + " not found in the linked list.");
//    }
//
//    // Delete a node
//    int deleteIndex = 2;
//    sll.deletionOfNode(deleteIndex);
//    System.out.println("Linked List after deleting node at index " + deleteIndex + ":");
//    sll.traverseSinglyLinkedList();
//
//    // Delete the entire linked list
//    sll.deleteSLL();
//    System.out.println("Linked List after deleting the entire list:");
//    sll.traverseSinglyLinkedList();
    SinglyLinkedList sll2 =new SinglyLinkedList();
    sll2.insertInLinkedList(1, 0);  // Insert 2 at the beginning
    sll2.insertInLinkedList(20, 1);  // Insert 6 at index 1
    sll2.insertInLinkedList(61, 2);  // Insert 8 at index 2
    sll2.insertInLinkedList(100, 10);
    sll2.insertInLinkedList(101,11);
    System.out.println("Linked List:");
    sll2.traverseSinglyLinkedList();
    System.out.println("linked list after merging\n");
    sll.mergelinkedlist(sll,sll2);
    sll.removeDuplicacySortedList(sll);
    sll.cyclePresentInList(sll);
    SinglyLinkedList.isHappyNumber(12);
      System.out.println(sll.middleNode(sll.head));

  }
}
