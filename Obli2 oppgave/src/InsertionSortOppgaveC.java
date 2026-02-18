import java.time.Instant;
import java.time.Duration;
import java.util.Random;

public class InsertionSortOppgaveC {

    public static void InsertionSortToOgSentinel(Integer[] a) {

        int n = a.length;

        if (n < 2) return; 

        for (int i = n -1; i > 0; i--) {
            if (a[i] < a[i - 1]) {
                Integer temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
            }
        }

        int i = 1; 
        int minste = 0, storste = 0;

        for (; i < n -1; i += 2) {

            int x = a[i];
            int y = a[i + 1];

            if (x <= y) {
                minste = x;
                storste = y;
            } else {
                minste = y;
                storste = x;
            }

            int j = i-1; 

            while (storste < a[j]) {
                a[j + 2] = a[j];
                j--;
            }
            a[j + 2] = storste;

            while (minste < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = minste;  
        }

    if (i < n) {
        int temp = a[i];
        int j = i - 1;

        while (temp < a[j]) {
            a[j + 1] = a[j];
            j--;
        }
        a[j + 1] = temp;
    }
}


    public static void main(String[] args) {
        int n = 80000;
        Integer[] a = new Integer[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(80000);
        }

        Instant start = Instant.now();
        InsertionSortToOgSentinel(a);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Tid brukt i millisekunder: " + timeElapsed.toMillis());
        System.out.println("Tid brukt i sekunder: " + timeElapsed.toSeconds());
    }
}
