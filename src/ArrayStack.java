import java.util.Arrays;

import java.util.EmptyStackException;

// Custom exception for empty collections
public class ArrayStack<T>{
    //  default capacity of the stack
    private static final int DEFAULT_CAPACITY = 3;
    private int top;
    private T[] stack;

    // Constructor
    public ArrayStack(int size) {
        top = 0;
        stack = (T[]) new Object[size];
    }
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    // zise
    int size() {
        return top;
    }

    //  check if the stack is empty
    boolean isEmpty() {
        return top == 0;
    }

    // Method to add an element to the stack
    void push(T element) {
        // If the stack is full, expand the capacity
        //if (size() == stack.length)
        if (isFull())
            expandCapacity();

        stack[top] = element;
        top++;
    }

    //  expand capacity
    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    //peek
    T peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty!");
            return null;
        }
        return stack[top - 1];
    }

    // Method to remove and return the top element of the stack
    T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        top--;
        T removedElement = stack[top];
        stack[top] = null;
        return removedElement;
    }

    // Override the toString method to provide a string representation of the stack
    @Override
    public String toString() {
        return "ArrayStack{" +
                "top=" + top +
                ", stack=" + Arrays.toString(stack) +
                '}'; // Return a string containing the top index and the elements of the stack
    }

    //sfull
    boolean isFull(){
        return top == stack.length;
        //return size() == stack.length;
    }

    //getlength
    int getLength(){
        return stack.length;
    }

    //display
    void display(){
        if(isEmpty())
            System.out.println("the stack is empty!");
        else{
            for(int i = top-1 ; i >= 0; i--)
                System.out.println(stack[i]);
        }
    }

    // Main method
    public static void main(String[] args) {
        ArrayStack<String> s1 = new ArrayStack<String>(4);
        s1.push("Ali");
        s1.push("aisha");
        s1.push("ayan");
        s1.push("mohamed");
        s1.push("cigal");
        // Remove the top element and display it
//        System.out.println("Removed: " + s1.pop());
        System.out.println("size: " + s1.size());

        System.out.println("isempty: " + s1.isEmpty());

        System.out.println("top element : " + s1.peek());
        System.out.println("stack elements : " );
        s1.display();
        System.out.println("stack capacity : " + s1.getLength());
        System.out.println("sifull : " + s1.isFull());








        // Assignment
        ArrayStack<String> list1 = new ArrayStack<>();
        list1.push("Ali");
        list1.push("aisha");
        list1.push("mohamed");
        list1.push("mohamed");

        ArrayStack<String> list2 = new ArrayStack<>();
        list2.push("Ali");
        list2.push("ayan");
        list2.push("cigal");

        ArrayStack<String> list3 = new ArrayStack<>();

        s1.merge(list1, list2, list3);

        System.out.println("Merged unique elements in list3:");
        list3.display();


    }



    private boolean contains(T element) {
        for (int i = 0; i < top; i++) {
            if (stack[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    //    METHOD MERGE
    public void merge(ArrayStack<T> list1, ArrayStack<T> list2, ArrayStack<T> list3 ){
        for (int i = 0; i < list1.size(); i++) {
            if (!list3.contains(list1.stack[i])) {
                list3.push(list1.stack[i]);
            }
        }

        // Add unique elements from list2 to list3
        for (int i = 0; i < list2.size(); i++) {
            if (!list3.contains(list2.stack[i])) {
                list3.push(list2.stack[i]);
            }
        }

    }

}


/// ID : C1220275
// Name : AISHA MOHAMUD SHAMOW
