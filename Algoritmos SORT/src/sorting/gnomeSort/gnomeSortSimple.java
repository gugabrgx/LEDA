package sorting.gnomeSort;

import sorting.AbstractSorting;

import java.util.Arrays;

public class gnomeSortSimple <T extends Comparable<T>> extends AbstractSorting<T> {

    public void sort(T[] array, int leftIndex, int rightIndex) {
        long time = System.nanoTime();
        if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length && array.length > 0) {

            int pivot = leftIndex;
            int size = rightIndex-leftIndex;

            while (pivot < size) {
                if (array[pivot].compareTo(array[pivot + 1]) > 0) {
                    swap(array, pivot, pivot + 1);
                    if (pivot > 0) {
                        pivot -= 2;
                    }
                }
                pivot++;
            }
        }
        time = System.nanoTime() - time;
        System.out.println("Nano: " + time);
        System.out.println("Mili: " + (time/1000000.0));
    }

    private static void swap(Object[] array, int i, int j) {
        if (array == null)
            throw new IllegalArgumentException();

        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        gnomeSortSimple gns = new gnomeSortSimple<Integer>();
//        Integer[] array = new Integer[5000];
//        for (int j = 0; j < array.length; j++) {
//            array[j] = ((int) (Math.random() * 10000));
//        }
//		Integer[] array = {3,4,1,1};
//		Integer[] array = {-1577,1000,1200,-1700,1001};
        Integer[] array = {-1577,1000,-1700,101,1238, 2374,43534,1231,6,414};
        gns.sort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

}
