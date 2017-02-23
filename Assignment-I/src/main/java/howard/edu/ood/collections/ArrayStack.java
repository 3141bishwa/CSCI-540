package howard.edu.ood.collections;

import java.util.NoSuchElementException;

/**
 * @author Bishwa Silwal
 * 
 *         Implementation of the data structure Stack using arrays
 *
 */
public class ArrayStack implements StackOperations {

	/**
	 * The array used to store the elements of the Stack.
	 */
	private int[] array;

	/**
	 * The count of elements in the stack
	 */
	public int count;

	/**
	 * Default constructor for the ArrayStack Class.
	 * 
	 * On initialization, the array is of length two and gets resized as
	 * required later.
	 */
	public ArrayStack() {
		array = new int[2];
		count = -1;
	}

	/**
	 * Pushes an integer into the stack. If the size of the internal array gets
	 * full, resizes the array to double of its original length.
	 * 
	 * @param item
	 *            the integer to be added into the stack
	 * @return Nothing
	 */
	@Override
	public void push(int item) {
		count += 1;

		if (array.length == count) {
			int[] newArray = new int[array.length * 2];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}

		array[count] = item;
	}

	/**
	 * Removes the last added element from the Stack and returns it.
	 * 
	 * @exception NoSuchElementException
	 * @return the last element from the Stack
	 */
	@Override
	public int pop() throws NoSuchElementException {

		if (isEmpty()) {
			throw new NoSuchElementException("No elements in the stack. Try adding one first!!");

		} else {
			int temp = array[count];

			array[count] = 0;
			count -= 1;

			return temp;
		}
	}

	/**
	 * Returns the last added element from the Stack. Unlike pop(), the element
	 * is not removed from the Stack.
	 * 
	 * @exception NoSuchElementException
	 * @return the last added element from the Stack.
	 */
	@Override
	public int peek() throws NoSuchElementException {

		if (isEmpty()) {
			throw new NoSuchElementException("No elements in the stack. Try adding one first!!");

		} else {
			return array[count];
		}
	}

	/**
	 * Checks whether the Stack is empty or not.
	 * 
	 * @return whether the Stack is empty or not.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count == -1;
	}

	/**
	 * Returns the number of elements in the Stack
	 * 
	 * @return length of the stack
	 */
	public int getLength() {
		return count + 1;
	}

	/**
	 * Returns a string representing the stack in the following format: Top [ a,
	 * b, c ] Bottom Where a is the most recently added element to the Stack.
	 * 
	 * @return A String representation of the stack
	 */
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("Top [ ");

		int i = count;
		while (i >= 0) {
			builder.append(array[i]).append(" ");
			i--;
		}

		builder.append("] Bottom");
		return builder.toString();
	}
}
