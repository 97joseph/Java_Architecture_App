package hacs;

import java.util.Iterator;


public class SolutionIterator implements Iterator<Solution> {
	SolutionList solutionlist;

	/// CurrentSolutionNumber: point to the location before the first element
	int currentSolutionNumber = -1;

	public SolutionIterator() {
	}

	public SolutionIterator(SolutionList thesolutionlist) {
		solutionlist = thesolutionlist;
		MoveToHead();
	}

	public void MoveToHead() {
		/// CurrentSolutionNumber: point to the location before the first element
		currentSolutionNumber = -1;
	}

	public boolean hasNext() {
		int size = solutionlist.size();
		if (currentSolutionNumber >= size - 1)
			return false;
		else
			return true;
//    throw new java.lang.UnsupportedOperationException("Method hasNext() not yet implemented.");
	}

	public Solution next() {
		if (hasNext() == true) {
			currentSolutionNumber++;
			return solutionlist.get(currentSolutionNumber);
		} else {
			return null;
		}
		// throw new java.lang.UnsupportedOperationException("Method next() not yet
		// implemented.");
	}

	/// get the next Solution that fits the Username;
	public Solution next(String UserName) {
		Solution theSolution;
		theSolution = (Solution) next();
		while (theSolution != null) {
			if (UserName.compareTo(theSolution.getTheAuthor()) == 0) {
				return theSolution;
			}
			theSolution = (Solution) next();
		}
		return null;
	}

	public void remove() {
		int size = solutionlist.size();
		solutionlist.remove(size-1);
	}

}