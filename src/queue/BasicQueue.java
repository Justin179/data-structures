package queue;

public class BasicQueue<X> {

	private X[] data;
	private int front; // 隊伍的第一人
	private int end; // 隊伍的最後一人
	
	public BasicQueue() {
		this(1000);
	}
	public BasicQueue(int size) {
		front = -1;
		end = -1;
		data = (X[]) new Object[size];
	}
	
	public int size() {
		if(front == -1 && end == -1)
			return 0;
		else 
			return end-front+1;
		
	}
	
	public void enQueue(X item) {
		// check if the queue is full
		if ((end + 1) % data.length == front) {
			throw new IllegalStateException("The Queue is full");
		} else if (size() == 0) {
			// first time to add
			front++;
			end++;
			data[end] = item;
		} else {
			// not first time to add
			end++;
			data[end] = item;
		}
		
	}
	
	public X deQueue() {
		X item = null;
		
		if(size()==0) {
			throw new IllegalStateException("Can't dequeue because the queue is empty");
			
		} else if (front == end) {
			// last item on the queue
			item = data[front];
			data[front] = null;
			front = -1;
			end = -1;
		} else {
			// 去掉隊伍第一人
			item = data[front];
			data[front] = null;
			front++; // 增加 the front pointer
		}
		
		return item;
	}
	
	public boolean contains(X item) {
		boolean found = false;
		
		if(size()==0)
			return found;
		
		for(int i = front; i<end; i++) {
			if(data[i].equals(item)) {
				found = true;
				break;
			}
		}
		
		return found;
	}
	
	public X access(int position) {
		if(size()==0 || position>size())
			throw new IllegalArgumentException("no items in the queue or the position is greater than the size");
		
		int trueIndex = 0;
		for(int i = front; i<end; i++) {
			if(trueIndex == position) { 
				return data[i];
			}
			trueIndex++;
		}
		
		return null;
	}
	
}






