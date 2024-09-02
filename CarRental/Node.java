class Node {
    public Car item; // value stored in the node
    public Node next; // reference to the next node

    Node(Car car, Node node) {
        this.item=car;
        this.next=node;
    }
}
