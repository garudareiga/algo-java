package design;

/**
 * 
 * @author raychen
 * 
 * Problem:
 */

public interface Stream<E> {
	public E peek();
	public E next();
	public boolean hashNext();
	public void append(E elem);
}
