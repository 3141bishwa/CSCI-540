import java.util.NoSuchElementException;

public interface StackOperations {
	
	public void push(int item);
	
	public int pop() throws NoSuchElementException;
	
	public int peek();
	
	public boolean isEmpty();

}
