package howard.edu.ood.collections;

import java.util.NoSuchElementException;

/**
 * @author Bishwa Silwal
 * 
 *	Implementation of the data structure Queue using arrays
 *
 */
public class ArrayQueue implements QueueOperations {

	/**
	 * The array used to store the elements of the Queue. Initialized to a
	 * length of 2. Elements gets dequeued from the front of the array and newer
	 * elements gets queued at the end. Once the end of the array is reached,
	 * elements are wrapped to the beginning of the array. When the array gets
	 * full, it is resized to a bigger array.
	 * 
	 */
	private int[] array;

	/**
	 * The index of the element to be queued next.
	 */
	private int frontIndex;

	/**
	 * The index of the last added element.
	 */
	private int backIndex;

	/**
	 * Number of elements in the stack
	 */
	private int numElements;

	/**
	 * Constructor for the ArrayQueue.
	 */
	public ArrayQueue() {
		array = new int[2];
		frontIndex = 0;
		backIndex = -1;
		numElements = 0;

	}

	/**
	 * Returns the length of the Queue
	 * 
	 * @return
	 */
	public int getLength() {
		return numElements;
	}

	/**
	 * Removes the item on the front from the queue.
	 * 
	 * @exception NoSuchElementException
	 * @return The item to be dequeued
	 */
	@Override
	public int dequeue() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("No elements in the queue. Try enqueing first!!");
		}

		int temp = array[frontIndex];
		array[frontIndex] = 0;
		numElements -= 1;

		frontIndex++;
		if (frontIndex == array.length) {
			frontIndex = 0;
		}

		// If the number of elements reduces to zero, resets the member
		// variables to default values.
		if (numElements == 0) {
			array = new int[2];
			frontIndex = 0;
			backIndex = -1;
		}
		return temp;
	}

	/**
	 * Adds an element to the queue.
	 * 
	 * @return Nothing
	 * 
	 */
	@Override
	public void enqueue(int element) {
		backIndex += 1;

		// The new item to be added gets added in the array based on where the
		// backIndex
		// and the frontIndex are.
		if (frontIndex < backIndex) {
			if (array.length == backIndex) {
				// Case: 1
				// * * * * *
				// ^ ^
				// fI bI
				// Resizes the array to make room for new element.
				if (frontIndex == 0) {
					int[] newArray = new int[array.length * 2];
					System.arraycopy(array, frontIndex, newArray, 0, array.length - frontIndex);
					array = newArray;
					backIndex = numElements;

					// Case: 2
					// _ * * * *
					// ^ ^
					// fI bI
					// Moves the backIndex count to the start of the array.
				} else {
					backIndex = 0;
				}
			}

		// Case: 3
		// * * * * *
		// ^ ^
		// bI fI
		// Resizes the array to make room for the new element.
		// Also repositions the elements such that the frontIndex points
		// to the front of the new array and backIndex points to the last
		// element
		} else if (backIndex == frontIndex) {
			int[] newArray = new int[array.length * 2];
			System.arraycopy(array, frontIndex, newArray, 0, array.length - frontIndex);
			System.arraycopy(array, 0, newArray, array.length - frontIndex, backIndex);

			frontIndex = 0;
			backIndex = numElements;
			array = newArray;
		}

		array[backIndex] = element;
		numElements += 1;
	}

	/**
	 * Checks if the Queue is empty or not
	 * 
	 * @return boolean value to return whether its empty
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numElements == 0;
	}

	/**
	 * Returns the next item to be dequeued from the Queue Doesn't remove the
	 * element from the array.
	 *
	 * @return the element at the front of the queue
	 */
	@Override
	public int peek() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("No elements in the queue. Try enqueing first!!");
		}

		return array[frontIndex];
	}

	/**
	 * Returns a string representing the queue in the following format:
	 * 
	 * front: x back: y front [ a, b, c ] back
	 * 
	 * Where x and y are the front and back pointers to the queue respectively.
	 * 
	 * 
	 * @return A String representation of the queue
	 */
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append(String.format("front: %s  back: %s\n", frontIndex, backIndex));
		builder.append("front [ ");

		if (frontIndex <= backIndex) {
			for (int i = frontIndex; i <= backIndex; i++) {
				builder.append(array[i]).append(" ");
			}
		} else {
			// Wrapping to the front of the array
			for (int i = frontIndex; i < array.length; i++) {
				builder.append(array[i]).append(" ");
			}

			for (int i = 0; i <= backIndex; i++) {
				builder.append(array[i]).append(" ");
			}

		}

		builder.append("] back");

		return builder.toString();
	}
}
