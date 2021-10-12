package hacs;

import java.util.*;

public class ListIterator implements Iterator<Object> {
	private ArrayList<Object> theList;
	private int currentNumber = -1;

	public ListIterator() {
	}

	public ListIterator(ArrayList<Object> list) {
		this.theList = list;
	}

	public boolean hasNext() {
		if (currentNumber >= theList.size() - 1)
			return false;
		else
			return true;
	}

	public Object next() {
		if (hasNext() == true) {
			currentNumber++;
			return theList.get(currentNumber);
		} else {
			return null;
		}
	}

	public void remove() {
		int size = theList.size();
		theList.remove(size-1);
	}
}