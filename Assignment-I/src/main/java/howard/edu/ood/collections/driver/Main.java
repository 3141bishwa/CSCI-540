package howard.edu.ood.collections.driver;

import java.util.NoSuchElementException;

import howard.edu.ood.collections.ArrayQueue;
import howard.edu.ood.collections.ArrayStack;

/**
 * Main Class to check the implementation of the Stack and Queue Collections.
 * 
 * Implements methods like areEqual() and newStack() to ensure correct
 * implementation.
 *
 */
public class Main {
	/**
	 * Checks if two ArrayStack are the same in terms of their values.
	 * 
	 * @param	stackA	The first ArrayStack
	 * @param	stackB	The second ArrayStack
	 * @return	boolean value to 
	 */
	public static boolean areEqual(ArrayStack stackA, ArrayStack stackB) {

		boolean result = true;

		if (stackA.getLength() != stackB.getLength()) {
			return false;
		}

		// Popping up arrays changes the data inside the ArrayStack objects.
		// Separate stacks are created for each stack to keep track of the
		// numbers
		// popped by them so that they can be added on before returning the
		// boolean value.
		ArrayStack stackForA = new ArrayStack();
		ArrayStack stackForB = new ArrayStack();

		int length = stackA.getLength();
		for (int i = 0; i < length; i++) {

			int a_elem = stackA.pop();
			int b_elem = stackB.pop();

			stackForA.push(a_elem);
			stackForB.push(b_elem);
			if (a_elem != b_elem) {
				result = false;
				break;
			}
		}

		int pushLength = stackForA.getLength();
		for (int i = 0; i < pushLength; i++) {
			stackA.push(stackForA.pop());
			stackB.push(stackForB.pop());
		}

		return result;
	}

	/**
	 * 	Creates a duplicate of a Stack.
	 * 
	 * @param	oldStack	The stack to be copied
	 * @return	A new stack equal to the older one
	 */
	public static ArrayStack duplicateStack(ArrayStack oldStack) {

		ArrayStack newStack = new ArrayStack();
		ArrayStack temp = new ArrayStack();

		int stackLength = oldStack.getLength();
		for (int i = 0; i < stackLength; i++) {
			temp.push(oldStack.pop());
		}

		for (int i = 0; i < stackLength; i++) {
			int poppedElement = temp.pop();
			oldStack.push(poppedElement);
			newStack.push(poppedElement);
		}

		return newStack;
	}

	/**
	 * Main function to check implementations of the above functions 
	 * and the ArrayStack and ArrayQueue Classes.
	 */
	public static void main(String[] args) {
		checkCreationofStack();
		checkCreationofQueue();
		checkIsEqualAndDuplicateStack();
	}

	/**
	 * Creates an ArrayStack object and performs public functions on it.
	 */
	public static void checkCreationofStack() {
		
		ArrayStack myStack = new ArrayStack();
		for (int i = 0; i < 12; i++) {
			myStack.push(i);
			System.out.printf("Adding %d to the stack. Now, it looks like:", i);
			System.out.println(myStack.toString());
		}

		for (int i = 0; i < 12; i++) {
			try {
				int a = myStack.pop();
				System.out.printf("Removed %d from the stack. Now, it looks like:", a);
				System.out.println(myStack.toString());
			} catch (NoSuchElementException e) {
				System.out.println("The stack is already Empty.\n");
			}
		}
		
		System.out.println(myStack.toString());
		
		try {
			int a = myStack.pop();
		} catch (NoSuchElementException e) {
			System.out.println("The stack is already Empty.\n");
		}
	}
	
	/**
	 * Creates an ArrayQueue object and performs public functions on it.
	 */
	public static void checkCreationofQueue() {
		ArrayQueue queue = new ArrayQueue();

		for (int i = 1; i < 10; i++) {
			queue.enqueue(i);
			System.out.println("");
			System.out.printf("Queuing %d to the queue. Now, it looks like:\n", i);
			System.out.println(queue.toString());
		}

		for (int i = 1; i < 5; i++) {
			int dequed = queue.dequeue();
			System.out.println("");
			System.out.printf("Dequeued %d from the queue. Now, it looks like:\n", dequed);
			System.out.println(queue.toString());
		}

		for (int i = 6; i < 20; i++) {
			queue.enqueue(i);
			System.out.println("");
			System.out.printf("Queuing %d to the queue. Now, it looks like:\n", i);
			System.out.println(queue.toString());
		}
		
		
	}
	
	/**
	 * Checks the implementation of the checkIsEqual() and DuplicateStack()
	 * by duplicating a stack and checking if the two are equal.
	 */
	public static void checkIsEqualAndDuplicateStack() {
		ArrayStack stack = new ArrayStack();
		stack.push(2);
		stack.push(2);
		stack.push(6);
		
		System.out.printf("The created Stack is: \n%s\n", stack.toString());
		
		ArrayStack duplicate = duplicateStack(stack);
		System.out.printf("The duplicated Stack is: \n%s\n", duplicate.toString());
		
		System.out.printf("The output of duplicateStack() is %b",
				areEqual(stack, duplicate));
		
	}

}
