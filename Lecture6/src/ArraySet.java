import java.util.Arrays;

public class ArraySet {
	private ElementType[] theElements;
	private int numElements;

	/*//////
	 * ArraySet(int n)
	 * Create and initially empty set with initial capacity for n objects
	 */
	public ArraySet(int n) {
		numElements = 0;
		theElements = new ElementType[n];
	}

	/*
	 * ArraySet(long[] numbers, int n)
	 * Add the n objects array numbers to target set
	 */
	public ArraySet(ElementType[] numbers, int n) {
		numElements = n;
		theElements = new ElementType[n*2];
		for (int i=0; i<n; i++) {
			theElements[i] = numbers[i];
		}
	}

	/*
	 * isEmpty()
	 * Returns true if the target set has no elements
	 */
	public boolean isEmpty() {
		return numElements == 0; // Dummy return
	}

	/*
	 * cardinality()
	 * Return a number representing the cardinality of the target set
	 */
	public int cardinality() {
		return numElements; // dummy return
	}

	/*
	 * max()
	 * Returns a long representing the maximum element in the set
	 */
	public ElementType max() {
		if (!this.isEmpty()) {
			ElementType result = theElements[0];
			for (int i=1; i<numElements; i++) {
				if (theElements[i].greaterThan(result)) {
					result = theElements[i];
				}
			}
			return result;
		}
		else {
			throw new RuntimeException("Attempted to find max of empty array");
		}
	}

	/*
	 * min()
	 * Returns a long representing the minimum element in the set
	 */
	public ElementType min() {
		if (!this.isEmpty()) {
		    ElementType result = theElements[0];
			for (int i=1; i<numElements; i++) {
				if (result.greaterThan(theElements[i])) {
					result = theElements[i];
				}
			}
			return result;
		}
		else {
			throw new RuntimeException("Attempted to find min of empty array");
		}
	}

	/*
	 * sum()
	 * Returns a long representing the sum of all elements of the set
	 */
	public long sum() {
		long result = 0;
		for (int i=0; i<numElements; i++) {
			result += theElements[i].valueOf();
		}
		return result;
	}

	/*
	 * mult()
	 * Returns a long representing the product of all the elements in the set
	 */
	public long product() {
		long result = 1;
		for (int i=0; i<numElements; i++) {
			result *= theElements[i].valueOf();
		}
		return result;
	}

	public boolean isMember(ElementType key) {
		for (int i=0; i<numElements; i++) {
			if (theElements[i].equals(key)) {
				return true;
			}
		}
		return false;
	}

	public void addMember(ElementType key) {
		if (!isMember(key)) {
			if (theElements.length <= numElements) {
				theElements = Arrays.copyOf(theElements, numElements * 2);
			}
			theElements[numElements] = key;
			numElements++;
		}
	}

	public void deleteMember(ElementType key) {
		if (isMember(key)) {
			for (int i=0; i<numElements; i++) {
				if (theElements[i].equals(key)) {
					theElements[i] = theElements[numElements-1];
					numElements--;
					return;
				}
			}
		}
	}

	public ArraySet union(ArraySet s) {
		int resultSize = 2 * Math.max(this.cardinality()+s.cardinality(),10);
		ArraySet result = new ArraySet(resultSize);
		for(int i=0; i<this.cardinality(); i++) {
			result.addMember(this.theElements[i]);
		}
		for(int i=0; i<s.cardinality(); i++) {
			result.addMember(s.theElements[i]);
		}
		return result;
	}

	public ArraySet intersection(ArraySet s) {
		int resultSize = 2 * Math.max(this.cardinality(), s.cardinality());
		ArraySet result = new ArraySet(resultSize);
		for(int i=0; i<this.cardinality(); i++) {
			if (s.isMember(this.theElements[i])) {
				result.addMember(this.theElements[i]);
			}
		}
		return result;
	}

	public boolean isSubset(ArraySet s) {

		for(int i=0; i<this.cardinality(); i++) {
			if (!s.isMember(this.theElements[i])) {
				return false;
			}
		}
		return true;
	}
	
	public boolean equals(ArraySet s) {
		return ((this.isSubset(s))&&(s.isSubset(this)));
	}
}
