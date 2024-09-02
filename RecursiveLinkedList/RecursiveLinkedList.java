import BasicIO.*;

class Node{
    int item;
    Node next;

    public Node(int i,Node n){
        item=i;
        next=n;
    }

}

public class RecursiveLinkedList {

    public RecursiveLinkedList() {
        ASCIIDataFile dataFile = new ASCIIDataFile();
        Node original = load(dataFile);
        dataFile.close();
        Node clone;

        System.out.print("List: ");
        print(original);
        System.out.println("\nLength: " + length(original));
        System.out.print("Reverse: ");
        printReverse(original);
        System.out.println("\nSum: " + sum(original));
        System.out.println("Contains (3): " + contains(original, 3));
        System.out.println("Contains (7): " + contains(original, 7));
        clone = copy(original);
        System.out.print("List (copy): ");
        print(clone);
        System.out.println("\nLength (copy): " + length(clone));
        System.out.println("Equals copy: " + equals(original, clone));
        clone = increment(original, 2);
        System.out.print("List (increment) by 2: ");
        print(clone);
        System.out.println("\nLength (increment) by 2: " + length(clone));
        System.out.println("Equals copy (increment) by 2: " + equals(original, clone));
        clone = append(original, clone);
        System.out.print("List (append): ");
        print(clone);
        System.out.println("\nLength (append): " + length(clone));
        clone = reverse(original);
        System.out.print("List (reverse): ");
        print(clone);
        System.out.println("\nLength (reverse): " + length(clone));
    }

    private Node load(ASCIIDataFile file) {
        Node n=null;
        int val = file.readInt();
        if(val!=0){
            n = new Node(val,load(file));
        }
        return n;

    }

    private void print(Node p) {
        if(p!=null){
            System.out.print(p.item+" ");
            print(p.next);
        }
    }

    private void printReverse(Node p) {
        Node n = p.next;
        if(n!=null){
            printReverse(n);

        }
        System.out.print(p.item+" ");
    }

    private int length(Node p) {
        if(p!=null){
            return 1+length(p.next);
        }else{
            return 0;
        }
    }

    private int sum(Node p) {
      if(p!=null){
          return p.item+sum(p.next);
      }else{
          return 0;
      }
    }

    private boolean contains(Node p, int value) {
        if(p!=null){
            if(p.item==value){
                return true;
            }
            return contains(p.next,value);
        }else{
            return false;
        }
    }

    private Node increment(Node p, int amount) {
        if(p!=null){
            return new Node(p.item+amount,increment(p.next,amount));
        }else{
            return null;
        }
    }

    private Node copy(Node p) {
        if(p!=null){
            return new Node(p.item,copy(p.next));
        }else{
            return null;
        }
    }

    private boolean equals(Node p, Node other) {

        if(p!=null&&other!=null){
            if(p.item==other.item){
                return equals(p.next,other.next);
            }
            else{
                return false;
            }
        }
        return (p!=null&other!=null);
    }

    private Node append(Node first, Node second) {
        if(first!=null){
            return new Node(first.item,append(first.next,second));
        }
        if(second!=null){
            return new Node(second.item,append(first,second.next));
        }
        return null;
    }

    private Node reverse(Node p) {
        if(p==null){
            return null;
        }else{
            return append(reverse(p.next),new Node(p.item,null));
        }
    }

    public static void main(String[] args) {
        RecursiveLinkedList llo = new RecursiveLinkedList();
    }
}