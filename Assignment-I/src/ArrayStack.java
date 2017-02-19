
import java.util.NoSuchElementException;

public class ArrayStack implements StackOperations {
	
	private int[] array = new int[2];
	public int count = -1;

	@Override
	public void push(int item) {
		
		count+= 1;
		
		if (array.length  == count) {
			
			int[] newArray = new int[array.length*2];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}
		
		array[count] = item;
		
	}

	@Override
	public int pop() throws NoSuchElementException {

		if(isEmpty()) {
			throw new NoSuchElementException("No elements in the stack. Try adding one first!!");
			
		} else {
		// TODO Auto-generated method stub
			int temp = array[count];
			
			
			array[count] = 0;
			count -= 1;
			
			return temp;
		}
	}

	@Override
	public int peek() {
		// TODO Auto-generated method stub
		return array[count];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count == -1;
	}
	
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("Top [ ");
		
		int i = count;
		while(i >= 0) {
				builder.append(array[i]).append(" ");
				i--;
			}
		
		builder.append("] Bottom");
		
		
		return builder.toString();
	}
}
