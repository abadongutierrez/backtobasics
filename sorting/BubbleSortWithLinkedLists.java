public class BubbleSortWithLinkedLists {
    public static LinkedList<Integer> createList() {
        LinkedList<Integer> ll = new LinkedList<Integer>();

        ll.add(1);
        ll.add(3);
        ll.add(8);
        ll.add(2);
        ll.add(5);
        ll.add(7);
        ll.add(4);
        ll.add(6);
        ll.add(9);
        
        return ll;    
    }

    public static void main(String[] args) {

        LinkedList<Integer> ll = createList();
        ll.print();
        System.out.println("");
        ll.bubbleSort();
        System.out.println("\nsorted");
        ll.print();

        System.out.println("\n-----------------------");
        ll = createList();
        ll.print();
        System.out.println("");
        ll.optimizedBubbleSort();
        System.out.println("\noptimized sorted");
        ll.print();
        System.out.println("\n.");
    }
}