package design;

public interface Filter<T> {
    boolean accepts(T t);
}
