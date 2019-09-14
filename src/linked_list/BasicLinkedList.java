package linked_list;

import java.nio.channels.IllegalSelectorException;

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
		if(first==null)
			throw new IllegalStateException("the linkedlist is empty");
		
		Node currentNode = first;
		Node prevNode = first;
		
		// start at first 找到要刪掉的那個
		for(int i = 1; i<position && currentNode!=null; i++) {
			// 每次往前推一格
			prevNode = currentNode;
			currentNode = currentNode.nextNode;
		}
		
		// 此時已經找到currentNode (要刪掉的那個)
		X nodeItem = currentNode.getNodeItem(); 
		// 其左接至其右
		prevNode.setNextNode(currentNode.getNextNode());
		nodeCount--;
		return nodeItem;
	}
	
	public X remove() { 
		if(first==null)
			throw new IllegalStateException("the linked list is empty");
		
		X nodeItem = first.getNodeItem();
		first = first.getNextNode();
		nodeCount--;
		
		return nodeItem;
	}
	
	public X get(int position) {
		if(first==null)
			throw new IllegalStateException("the linkedlist is empty");
		
		Node currentNode = first;
		// loop through all from one
		for(int i = 1; i<size() && currentNode!=null; i++) {
			if(i==position)
				return currentNode.getNodeItem();
			// currentNode往前推
			currentNode = currentNode.getNextNode();
		}
		
		// return null if nothing found
		return null;
	}
	
	public int find(X item) {
		if(first==null)
			throw new IllegalStateException("the linkedlist is empty");
		
		Node currentNode = first;
		for(int i = 1; i<size()&&currentNode!=null; i++) {
			if(currentNode.getNodeItem().equals(item))
				return i;
			// Node往前推
			currentNode = currentNode.getNextNode();
		}
		
		return -1;
	}
	
	// pretty print
	public String toString() {
		StringBuffer contents = new StringBuffer();
		Node curNode = first;
		
		while(curNode!=null) {
			contents.append(curNode.getNodeItem());
			// 每次Node往前推一格
			curNode = curNode.getNextNode();
			// 還沒到盡頭，還有下一個
			if(curNode!=null)
				contents.append(",");
		}
		
		return contents.toString();
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
