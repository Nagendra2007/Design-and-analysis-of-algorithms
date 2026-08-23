class Queue {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node front;
    Node rear;

    void enqueue(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    int dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int data = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return data;
    }

    int peek() {
        if (front == null) {
            return -1;
        }

        return front.data;
    }

    boolean isEmpty() {
        return front == null;
    }

    void display() {
        Node temp = front;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Front: " + queue.peek());
    }
}
