package design;

import java.util.*;

import com.google.common.collect.MinMaxPriorityQueue;

public class StreamMerge<E> {
	public void merge(List<Stream<E>> streams, Comparator<Stream<E>> comparator) {
		MinMaxPriorityQueue<Stream<E>> pq = MinMaxPriorityQueue.orderedBy(comparator).create();
		for (Stream<E> stream : streams)
			pq.add(stream);
		while (!pq.isEmpty()) {
			Stream<E> stream = pq.pollFirst();
			System.out.print(stream.next());
			if (stream.hashNext())
				pq.add(stream);
		}
	}
}
