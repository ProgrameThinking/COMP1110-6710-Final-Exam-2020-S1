package comp1110.exam;

import java.util.Arrays;

/**
 * COMP1110/6710 Exam, Question 4
 * <p>
 * This class represents a queue, in which elements are added and removed in a
 * first in, first out (FIFO) order. Duplicate elements are permitted.
 * When a queue is first created, it contains no elements.
 * The queue can grow to fit new elements as required.
 * Attempting to access an element of an empty queue throws an EmptyQueueException,
 * and does not result in any modification to the queue.
 * The Queue is implemented using an array data structure (a regular Java array),
 * and does not use any of the Java Collection classes.
 */
public class Q4ArrayQueue<T> {
    /**
     * An exception that is thrown when trying to dequeue or peek at an
     * empty queue. Do not modify this class.
     */
    public static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException() { }
    }

    private Object[] elements;
    private int front;
    private int back;
    private int size;
    
    public Q4ArrayQueue() {
        elements = new Object[1000];
        front = 0;
        back = 0;
        size = 0;
    }
    
    /**
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        // FIXME complete this method
    	return size == 0;
    }

    /**
     * Add the given value to the back of the queue.
     *
     * @param value the value to add to the queue
     */
    public void enqueue(T value) {
        // FIXME complete this method
    	if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[back] = value;
        back = (back + 1) % elements.length;
        size++;
    }

    /**
     * Remove the value from the front of the queue and return it.
     *
     * @return the value that was taken off of the queue
     * @throws EmptyQueueException if the queue is currently empty
     */
    public T dequeue() throws EmptyQueueException {
        // FIXME complete this method
    	if (isEmpty()) {
            throw new EmptyQueueException();
        }
        T value = (T) elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return value;
    }

    /**
     * Get the value that is currently at the front of the queue,
     * but do not remove it from the queue.
     *
     * @return the value at the front of the queue
     * @throws EmptyQueueException if the queue is currently empty
     */
    public T first() throws EmptyQueueException {
        // FIXME complete this method
    	 if (isEmpty()) {
             throw new EmptyQueueException();
         }
         return (T) elements[front];
    }

    /**
     * Check whether a given value is contained in this queue.
     * Specifically, returns true if value is not null and
     * an element e is contained in the queue such that e.equals(value).
     *
     * @param value the value to search for
     * @return true if the value is contained in this queue
     */
    public boolean contains(T value) {
        // FIXME complete this method
    	for (int i = 0; i < size; i++) {
            int index = (front + i) % elements.length;
            if (elements[index] != null && elements[index].equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Create a String representation of this queue.
     * Elements on the queue are listed in order from front to back,
     * separated by commas (without spaces).
     * If the queue is empty, an empty string is returned.
     * For example, a queue containing the elements (from front to back)
     * "a", "b", and "c" would be represented as "a,b,c".
     *
     * @return a String representation of this queue
     */
    public String toString() {
        // FIXME complete this method
    	StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            int index = (front + i) % elements.length;
            if (i > 0) {
                result.append(",");
            }
            result.append(elements[index]);
        }
        return result.toString();
    }
}
