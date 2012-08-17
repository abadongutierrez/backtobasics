class LinkedList<T extends Comparable> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void add(T newItem) {
        Node<T> newNode = new Node<T>();
        newNode.item = newItem;
        add(newNode);
    }

    public void add(Node<T> newNode) {
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void print() {
        Node<T> aux = head;
        while (aux != null) {
            System.out.print("[" + aux.item + "]");
            aux = aux.next;
        }
    }

    public int size() {
        return this.size;
    }

    private void swap(Node<T> prev, Node<T> node1, Node<T> node2) {
        if (node1 == head) {
            head = node2;
        }
        if (node2 == tail) {
            tail = node1;
        }
        Node<T> aux = node2.next;
        node2.next = node1;
        node1.next = aux;
        if (prev != null) {
            prev.next = node2;
        }        
    }

    private Node<T> findPrev(Node<T> node) {
        if (node == head) {
            return null;
        }
        else {
            Node<T> prev = head;
            Node<T> curr = head.next;
            while (curr != null) {
                if (curr == node) {
                    return prev;
                }
                prev = curr;
                curr = curr.next;
            }
        }
        return null;
    }

    public void bubbleSort() {        
        boolean swapped = false;
        do {
            swapped = false;
            Node<T> prev = null;
            Node<T> curr = head;
            while (curr != null && curr.next != null) {
                if (curr.item.compareTo(curr.next.item) == 1) {
                    Node<T> aux = curr.next;
                    swap(prev, curr, curr.next);
                    swapped = true;   
                    prev = aux;                 
                }
                else {
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        while (swapped);
    }

    public void optimizedBubbleSort() {
        /*
        boolean swapped = false;
        int count = 0;
        do {
            swapped = false;            
            Node<T> curr = head;
            while (curr != null && curr.next != null) {
                if (curr.item.compareTo(curr.next.item) == 1) {
                    swap(curr, curr.next);
                    swapped = true;                    
                }
                else {
                    curr = curr.next;
                }
            }
            count++;
        }
        while (swapped);   
        */
    }

    private Node<T> moveForwardNTimes(int times) {
        Node<T> curr = head;
        if (times != 0) {
            for (int i = 0; i < times && curr != null; i++) {
                curr = curr.next;
            }
        }
        return curr;
    }
}