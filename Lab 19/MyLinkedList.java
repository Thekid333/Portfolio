import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Random;
public class  MyLinkedList<E>{
    public class Node {
        E data;
        Node next;
        public Node(E data) {
            this.data = data;
        }
        @Override
        public String toString(){
            return data.toString();
        }
    }
    
    Node head;
	Node tail;
    int size;

    public MyLinkedList(){
        size = 0;
        head = null;
        tail = null;
	}

    public void add(E item){
        Node node = new Node(item);
        if(head == null){
            head = node;
            tail = node;
            size++;
        }
        else {
        tail.next = node;
        tail = node;
        size++;
    }

    }

    
    public Node getNode(int index){
        Node temp = head;
    	for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
	}
    public class MyIterator implements ListIterator<E> {
        int nextI;
        int size;
        public MyIterator(Node head, int size) {
            nextI = -1;
            this.size = size;
        }

       
        public boolean hasNext() {
            if(nextI + 1 < size){return true;}
        	return false;
		}

        
        public E next() {
            if(hasNext()){
            E temp = getNode(nextI + 1).data;  
                nextI++;
            return temp;
            }
            else if(hasNext() == false) throw new NoSuchElementException();
            return null;
		}

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException();
        }

        @Override
        public E previous() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int nextIndex() {
            return nextI;
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }
    public MyIterator listIterator(){
        return new MyIterator(head, size);
    }
    public String toString(){
        String ret = "";
        Node cur = head;
        while(cur != null){
            ret += cur + " ";
            cur = cur.next;
        }
        return ret;
    }
    public static void main(String[] args){ 
		Random r = new Random(2020);
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for(int i = 0; i < 10; i++){
            int num = r.nextInt(1000);
            list.add(num);
        }
		System.out.println("Testing add():");
        System.out.println(list);
		System.out.println("size:\texpected: 10 -> actual: " + list.size);	
		if(list.size != 10) //exit if add/size doesn't work
			return;

		System.out.println("\nTesting getNode():");
		MyLinkedList<Integer> list2 = new MyLinkedList<>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		System.out.println("item at index 0:\texpected: 1 -> actual: " + list2.getNode(0).data);
		System.out.println("item at index 1:\texpected: 2 -> actual: " + list2.getNode(1).data);
		System.out.println("item at index 2:\texpected: 3 -> actual: " + list2.getNode(2).data);
        
		//Iterator Test Code
        System.out.println("\nTesting Iterator: ");
		ListIterator<Integer> iter = list.listIterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("size: " + list.size);
        System.out.println("next Index: " + iter.nextIndex());
        try{
            iter.next();
        }catch(NoSuchElementException e){
            System.err.println("You threw the correct error!");
		}catch(Exception e){
			System.err.println("You throw the wrong type of Error. Make sure it is a NoSuchElementException.");
		}
    }
}
