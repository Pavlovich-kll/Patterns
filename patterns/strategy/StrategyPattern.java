package patterns.strategy;

import java.util.Arrays;

public class StrategyPattern {
    public static void main(String[] args) {
        StrategyClient strategyClient = new StrategyClient();
        strategyClient.setStrategy(new BubbleSort());
        strategyClient.executeStrategy(new int[]{45, 44, 43, 3, 2, 1, 0});
        strategyClient.setStrategy(new SelectSort());
        strategyClient.executeStrategy(new int[]{45, 44, 43, 3, 2, 1, 0});
    }

}

interface Sortable {
    void sort(int[] arr);
}

class StrategyClient {
    private Sortable sortable;

    public void setStrategy(Sortable sortable) {
        this.sortable = sortable;
    }

    public void executeStrategy(int[] arr) {
        sortable.sort(arr);
    }
}

class BubbleSort implements Sortable {

    @Override
    public void sort(int[] arr) {
        System.out.println("До сортровки пузырьком " + Arrays.toString(arr));

        for (int j = arr.length - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int save = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = save;
                }
            }
        }
        System.out.println("После сортировки пузырьком " + Arrays.toString(arr));
    }
}

class SelectSort implements Sortable {

    @Override
    public void sort(int[] arr) {
        System.out.println("До сортровки выборкой " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int min = arr[i];
                    arr[i] = arr[j];
                    arr[j] = min;

                }
            }
        }
        System.out.println("После сортровки выборкой " + Arrays.toString(arr));
    }
}