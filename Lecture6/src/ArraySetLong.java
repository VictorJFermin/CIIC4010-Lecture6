import java.util.Arrays;

public class ArraySetLong {
	private long[] theElements;
	private int numElements;

	/*
	 * ArraySetLong(int n)
	 * Create and initially empty set with initial capacity for n objects
	 */
	public ArraySetLong(int n) {
		numElements = 0;
		theElements = new long[n];
	}

	/*
	 * ArraySetLong(long[] numbers, int n)
	 * Add the n objects array numbers to target set
	 */
	public ArraySetLong(long[] numbers, int n) {
		numElements = n;
		theElements = new long[n*2];
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
	public long max() {
		if (!this.isEmpty()) {
			long result = theElements[0];
			for (int i=1; i<numElements; i++) {
				if (theElements[i] > result) {
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
	public long min() {
		if (!this.isEmpty()) {
			long result = theElements[0];
			for (int i=1; i<numElements; i++) {
				if (theElements[i] < result) {
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
			result += theElements[i];
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
			result *= theElements[i];
		}
		return result;
	}

	public boolean isMember(long key) {
		for (int i=0; i<numElements; i++) {
			if (theElements[i] == key) {
				return true;
			}
		}
		return false;
	}

	public void addMember(long key) {
		if (!isMember(key)) {
			if (theElements.length <= numElements) {
				theElements = Arrays.copyOf(theElements, numElements * 2);
			}
			theElements[numElements] = key;
			numElements++;
		}
	}

	public void deleteMember(long key) {
		if (isMember(key)) {
			for (int i=0; i<numElements; i++) {
				if (theElements[i] == key) {
					theElements[i] = theElements[numElements-1];
					numElements--;
					return;
				}
			}
		}
	}

	public ArraySetLong union(ArraySetLong s) {
		int resultSize = 2 * Math.max(this.cardinality()+s.cardinality(),10);
		ArraySetLong result = new ArraySetLong(resultSize);
		for(int i=0; i<this.cardinality(); i++) {
			result.addMember(this.theElements[i]);
		}
		for(int i=0; i<s.cardinality(); i++) {
			result.addMember(s.theElements[i]);
		}
		return result;
	}

	public ArraySetLong intersection(ArraySetLong s) {
		int resultSize = 2 * Math.max(this.cardinality(), s.cardinality());
		ArraySetLong result = new ArraySetLong(resultSize);
		for(int i=0; i<this.cardinality(); i++) {
			if (s.isMember(this.theElements[i])) {
				result.addMember(this.theElements[i]);
			}
		}
		return result;
	}

	public boolean isSubset(ArraySetLong s) {

		for(int i=0; i<this.cardinality(); i++) {
			if (!s.isMember(this.theElements[i])) {
				return false;
			}
		}
		return true;
	}
	
	public boolean equals(ArraySetLong s) {
		return ((this.isSubset(s))&&(s.isSubset(this)));
	}
}
