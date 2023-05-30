
/*

3. Write a Generic method that computes the Second minimum and Second maximum elements 
of an array of type T and returns a pair containing the minimum and maximum value.

 */

class Pair<A, B> {
    final A first;
    final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}

class ArrayMinMax<T extends Comparable<T>> {

    // method to compute second minimum and second maximum elements
    public Pair<T, T> computeMinMax(T[] arr) {
        T min = arr[0];
        T max = arr[0];
        T secMin = null;
        T secMax = null;

        // iterate through the array to find min, max, second min, and second max
        for (T elem : arr) {
            if (elem.compareTo(min) < 0) {
                secMin = min;
                min = elem;
            } else if (secMin == null || elem.compareTo(secMin) < 0) {
                if (!elem.equals(min)) {
                    secMin = elem;
                }
            }

            if (elem.compareTo(max) > 0) {
                secMax = max;
                max = elem;
            } else if (secMax == null || elem.compareTo(secMax) > 0) {
                if (!elem.equals(max)) {
                    secMax = elem;
                }
            }
        }

        return new Pair<>(secMin, secMax);
    }
}

public class q3 {
    public static void main(String[] args) {
        Integer[] intArr = { 3, 7, 1, 4, 2, 6, 5 };
        ArrayMinMax<Integer> intArrayMinMax = new ArrayMinMax<>();
        Pair<Integer, Integer> intPair = intArrayMinMax.computeMinMax(intArr);
        System.out.println("Second minimum and second maximum in the array of integers are: " + intPair.first + " and "
                + intPair.second);

    }
}

/*
 * OUTPUT -
 * Second minimum and second maximum in the array of integers are: 2 and 6
 */