package com.usman.csudh.csc311.adt.impl;
import com.usman.csudh.csc311.adt.List;
import com.usman.csudh.csc311.adt.ListInvalidIndexException;
import com.usman.csudh.csc311.adt.Queue;
import com.usman.csudh.csc311.adt.QueueEmptyException;

/**
 * A linked list implementation of a queue. This implementation uses forward linking nodes
 * to provide the queue functionality.
 */
public class LinkedQueue<T> implements Queue<T>{
	
	private Node<T> head;
	private Node<T> tail;
	
	
	public LinkedQueue() {
		head = null;
		tail = null;
	}
	
	
	@Override
	public void add(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			//Node tail = findTail();
			tail.next = newNode;
			tail = newNode;
		}

	}

	@Override
	public T remove() throws QueueEmptyException {
		if (head == null) {
			throwQueueEmptyException();
		}
		
		T item = head.data;	
		head=head.next;
		
		if(head == null) {
			tail = null;
		}
		return item;
		
	}

	@Override
	public T peek() throws QueueEmptyException {
		
		if (head == null) {
			throwQueueEmptyException();
		}
        return head.data;
	}

	@Override
	public int size() {
		
		Node<T> current = head;
		int count = 0;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head==null;
	}

	@Override
	public void clear() {
		head=null;
		tail = null;
		
	}
	
	// Returns the tail of the list
	//private Node findTail() {
		//if (head == null) {
		//	return null;
		//}

		//Node current = head;
		//while (current.next != null) {
			//current = current.next;
		//}
		//return current;
	//}
	
	private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

	
	private void throwQueueEmptyException() throws QueueEmptyException {
		throw new QueueEmptyException("Queue is empty");
	}
	

}
