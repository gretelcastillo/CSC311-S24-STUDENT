package com.usman.csudh.csc311.adt.impl;
import com.usman.csudh.csc311.adt.List;
import com.usman.csudh.csc311.adt.ListInvalidIndexException;
import com.usman.csudh.csc311.adt.Stack;
import com.usman.csudh.csc311.adt.StackEmptyException;

/**
 * A linked list implementation of a stack. The implementation uses forward linking nodes 
 * to provide the stack functionality.
 */

public class LinkedStack<T> implements Stack<T> {

	//Head node, staring point of stack
	private Node<T> head; 
	private Node<T> tail;
	
	/**
	 * Constructor to initialize the stack
     *
	 */
	 
	public LinkedStack() {
		head = null;
		tail = null;
	}
	

	/**
	 * Method to push a new item onto the stack. The new item becomes the head of the list i.e. the last item
	 * pushed to the stack becomes the first item to come out
	 * 
	 * @param item the item to push onto the stack
     *
	 * 
	 */
	
	@Override
	public void push(T item) {
		Node<T> newNode = new Node<>(item);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		
	}

	
	/**
	 * Method to pop the top item from the stack. The head node is returned and removed from the stack. The
	 * next node becomes the new head
	 * 
	 * @return the top item from the stack
	 * @throws StackEmptyException
	 */
	
	@Override
	public T pop() throws StackEmptyException {
		
		if (head == null) {
			throwStackEmptyException();
		}
		
		T item = head.data;
		head = head.next;
		
		// If head becomes null, set tail to null as well
		
		if(head == null)
		{
			tail = null;
		}
		return item;
		
	}

	/**
	 * Method to return the top item from the stack without removing it. THe head node is returned.
	 * 
	 * @return the top item from the stack
	 * @throws StackEmptyException
	 */
	@Override
	public T peek() throws StackEmptyException {

		if (head == null) {
			throwStackEmptyException();
		}

		return head.data;
	}

	/**
	 * Method to return the number of items in the stack. The method iterates through the list and counts the number nodes
	 * 
	 * @return the number of items in the stack
	 */
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

	/**
	 * Method to check if the stack is empty. The method checks if the head node is
	 * null
	 * 
	 * @return true if the stack is empty, false otherwise
	 */
	
	@Override
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Method to remove all items from the stack. The head node is set to null
	 */
	@Override
	public void clear() {
		head = null;
		tail = null;
	}
	
	public static class Node<T>
	{
		T data;
		Node<T> next;
		
		Node(T data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	
	private void throwStackEmptyException() throws StackEmptyException {
		throw new StackEmptyException("Stack is empty");
	}

}
