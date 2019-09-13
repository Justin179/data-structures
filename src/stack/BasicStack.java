package stack;

public class BasicStack<X> {

	private X[] data;
	private int stackPointer; // 當前指標
	
	
	public BasicStack() {
		data = (X[]) new Object[1000]; // 初始容量 1000個item
		stackPointer = 0; // 初始指標0
	}
	
	// 向上疉一個
	public void push(X newItem) {
		data[stackPointer++] = newItem; // 塞到位置0，然後指標加1
	}
	
	// 敲掉最後一個
	public X pop() {
		// 當前指標0時，沒有東西可以敲
		if(stackPointer==0)
			throw new IllegalStateException("No items on the stack!");
		
		return data[--stackPointer]; // 敲掉最後一個，然後指標減1
	}
	
	// 整個掃過，有找到就回true
	public boolean contains(X item) {
		boolean found = false;
		for(int i = 0; i<stackPointer; i++) {
			if(data[i].equals(item)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	// 由上而下一個一個打掉，有找到就回該物件
	public X access(X item) {
		while(stackPointer>0) {
			X currItem = pop();
			if(item.equals(currItem)) 
				return currItem;
			
		}
		
		throw new IllegalArgumentException("can't find the item on the stack: " + item);
	}
	
	public int size() {
		return stackPointer;
	}
}











