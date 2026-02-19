import java.time.Instant;
import java.time.Duration;

public class uke7opgp2 {
    public static void main(String[] args) {
        // Add your test code here
    }

    public static void insertionSort(Integer[] a) {
    for (int i = 1; i < a.length; i++) {
        Integer temp = a[i];
        int j = i - 1;

        while (j >= 0 && temp.compareTo(a[j]) < 0) {
            a[j + 1] = a[j];
            j--;
        }
        a[j + 1] = temp;
    }
}

//Plukksortering 
public static void selectionSort(Integer[] a) {
    for (int i = 0; i < a.length - 1; i++) {
        int minIndex = i;

        for (int j = i + 1; j < a.length; j++) {
            if (a[j].compareTo(a[minIndex]) < 0) {
                minIndex = j;
            }
        }

        Integer temp = a[i];
        a[i] = a[minIndex];
        a[minIndex] = temp;
    }
}

//Kvikksortering
public static void quickSort(Integer[] a, int left, int right) {
    if (left >= right) return; 

    int i = left, j = right;
    Integer pivot = a[(left - right) / 2];
    while (i <= j) {
        while (a[i].compareTo(pivot) < 0) i++;
        while (a[j].compareTo(pivot) > 0) j--;

        if (i <= j) {
            Integer temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }
    quickSort(a, left, j);
    quickSort(a, i, right);
}

//Flettesortering
public static void mergeSort(Integer[] a) {
    if (a.length < 2) return;
    int mid = a.length / 2;
    Integer[] left = new Integer[mid];
    Integer[] right = new Integer[a.length - mid];

    System.arraycopy(a, 0, left, 0, mid);
    System.arraycopy(a, mid, right, 0, a.length - mid);

    mergeSort(left);
    mergeSort(right);

    merge(a, left, right);
}

private static void merge(Integer[] a, Integer[] left, Integer[] right) {
    int i = 0, j = 0, k = 0;

    while (i < left.length && j < right.length) {
        if (left[i] <= right[j]) {
            a[k++] = left[i++];
        } else {
            a[k++] = right[j++];
        }
    }

    while (i < left.length) a[k++] = left[i++];
    while (j < right.length) a[k++] = right[j++];
}

public static long measureTime(Integer[] a, String method) {
    Instant start = Instant.now();

    switch (method) {
        case "insertion":
            insertionSort(a);
            break;
        case "selection":
            selectionSort(a);
            break;
        case "quick":
            quickSort(a, 0, a.length - 1);
            break;
        case "merge":
            mergeSort(a);
            break;
        default:
            throw new IllegalArgumentException("Ugyldig sorteringsmetode: " + method);
    }

    Instant end = Instant.now();
    return Duration.between(start, end).toMillis();
    }
}