package searching;

import java.util.List;

public class MinMaxFind<T extends Comparable<T>> {

    public class MinMax {
        T min;
        T max;

        MinMax(T min, T max) {
            this.min =min;
            this.max = max;
        }

        @Override
        public String toString() {
            return "Min = " + min + "Max = " + max;
        }

    }

    private MinMax createMinMax(T a, T b) {
        return a.compareTo(b)>0? new MinMax(b, a) : new MinMax(a,b);
    }

    private T min(T a, T b) {
        return a.compareTo(b) > 0 ? b : a;
    }

    private T max(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    public MinMax findMinMax(List<T> arr) {

        if (arr.size() == 1) return createMinMax(arr.get(0), arr.get(0));

        MinMax gMax = createMinMax(arr.get(0), arr.get(1));

        for (int i = 2; i + 1 < arr.size(); i+=2) {

            MinMax lMax = createMinMax(arr.get(i), arr.get(i+1));
            gMax = new MinMax(min(lMax.min, gMax.min), max(lMax.max, gMax.max));
        
        }

        if (arr.size() % 2 != 0) {
            gMax = new MinMax(min(gMax.min, arr.get(arr.size()-1)), max(gMax.max, arr.get(arr.size()-1)));
        }

        return gMax;

    }

}