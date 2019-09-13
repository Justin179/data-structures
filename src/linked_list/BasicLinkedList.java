package linked_list;

public class BasicLinkedList<X> {
	private Node first;
	private Node last;
	private int nodeCount;
	
	
	public BasicLinkedList() {
		first = null;
		last = null;
		nodeCount = 0;
	}
	
	public void add(X item) {
		// 第一次加東西進去
		if(first==null) {
			first = new Node(item);
			last = first;
		} else {
			// 若原本已經有東西，抓最後一個繼續往後掛
			Node newLastNode = new Node(item);
			last.setNextNode(newLastNode);
			last = newLastNode;
		}
		nodeCount++;
	}

	public void insert(X item, int position) {
		if(position>size())
			throw new IllegalStateException("the linkedlist is smaller than the position you put in");
		
		Node currentNode = first;
		for(int i = 1; i<position && currentNode!=null; i++) {
			// 不斷的next, next, 先找到currentNode
			currentNode = currentNode.nextNode;
		}
		
		// currentNode 左
		Node newNode = new Node(item); // 要插入的 
		Node nextNode = currentNode.nextNode; // 右
		currentNode.setNextNode(newNode); // 插入
		newNode.setNextNode(nextNode);
		nodeCount++;
	}
	
	public X removeAt(int position) {
		
		return null;
	}
	
	public X remove() { 
		if(first==null)
			throw new IllegalStateException("the linked list is empty");
		
		X nodeItem = first.getNodeItem();
		first = first.getNextNode();
		nodeCount--;
		
		return nodeItem;
	}
	
	public int size() {
		return nodeCount;
	}
	
	private class Node{
		private Node nextNode;
		private X nodeItem;
		
		public Node(X item) {
			this.nextNode = null;
			this.nodeItem = item;
		}
		
		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
		
		public Node getNextNode() {
			return nextNode;
		}
		
		public X getNodeItem() {
			return nodeItem;
		}
		
	}
	
}
