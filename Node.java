public class Node {
    private Record record; //Store Record
    private Node nextNode;

    public Node(Record record){
        this.record = record;   //Setting Record
        this.nextNode = null;   //Setting Next Node
    }
    public Node getNext() {
        return nextNode;
    }
    public void setNext(Node next){
        this.nextNode = next;
    }
    public Record getRecord() {
        return record;
    }
}