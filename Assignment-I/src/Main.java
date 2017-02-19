import java.util.NoSuchElementException;

public class Main {
	
	public static void main(String[] args) {
		ArrayStack myStack = new ArrayStack();
		
		for(int i = 0 ; i < 12; i++) {
			myStack.push(i);
			System.out.println(myStack.toString());
			System.out.println(myStack.peek());
			
		}
		
		for(int i = 0 ; i < 12; i++) {
			try {
				int a = myStack.pop();
			} catch (NoSuchElementException e) {
				System.out.println("The stack is already Empty");
			}
			
			System.out.println(myStack.toString());

		}
		
		System.out.println("All removed");
		try {
			int a = myStack.pop();
		} catch (NoSuchElementException e) {
			System.out.println("The stack is already Empty");
		}
	}

}
