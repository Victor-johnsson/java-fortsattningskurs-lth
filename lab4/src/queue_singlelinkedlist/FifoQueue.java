package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {
		QueueNode<E> newNode = new QueueNode<>(e);
		if(last == null){
			newNode.next = newNode;

		}else {
			newNode.next = last.next;
			last.next = newNode;
		}
		last = newNode;

		return true;
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {
		if(last == null) return 0;
		else if(last.next == last) return 1;
		else{
			QueueNode<E> current = last;
			int count = 1;
			while (current.next != last){
				count++;
				current = current.next;
			}
			return count;
		}
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if(last == null) return null;
		else return last.next.element;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll()  {
		if(last == null) return null;
		else if(last.next == last){
			E data = last.element;
			last = null;
			return data;
		}else {
			E data = last.next.element;
			last.next = last.next.next;
			return data;
		}
	}
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}
	private class QueueIterator implements Iterator<E>{
		private QueueNode<E> current;
		private QueueIterator(){

			current = last;


		}
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if(hasNext()){
				E data = current.next.element;


				current = current.next != last ? current.next : null;


				return data;

			}
			throw new NoSuchElementException();

		}


	}
	public void append(FifoQueue<E> queue){

		if(this.equals(queue)) {
			throw new IllegalArgumentException();
		}
		if(this.isEmpty() && queue.isEmpty()){
			throw new IllegalArgumentException();
		}

		if(queue.isEmpty() && !this.isEmpty()){
			//Do Nothing!
			return;
		}

		if(this.isEmpty() && !queue.isEmpty()){
			last = queue.last;
			queue.last = null;
			return;
		}

		if(!this.isEmpty() && !queue.isEmpty()){
			QueueNode<E> a = last.next;
			QueueNode<E> d = queue.last.next;
			last.next = d;
			queue.last.next =a;
			last = queue.last;
			queue.last = null;
			return;
		}


	}

}
