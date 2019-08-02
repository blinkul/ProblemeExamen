package filtrucuvinte;

import java.util.*;

public class Biblioteca {

    private Scanner inputScanner = new Scanner(System.in);
    private List<Batch> books = new ArrayList<>();
    private Map<Integer, List<Integer>> shelves = new HashMap<>();
    private int D;
    private int k;
    private int n, p;
    private String separator = " ";

    // restictions
    private final int MIN_D = 50;
    private final int MAX_D = 10000;
    private final int MIN_P = 1;
    private final int MAX_P = 1000;
    private final int MIN_N = 1;
    private final int MAX_N = 100;

    public static void main(String[] args) {

        boolean debug = true;
        Biblioteca biblioteca = new Biblioteca();

        if(debug) {

            biblioteca.loadTestData();
            biblioteca.sortBooks();
            biblioteca.returnResult();

//            biblioteca.showList();

        } else {

            biblioteca.readInput();
            biblioteca.sortBooks();
            biblioteca.returnResult();

//            biblioteca.showList();

        }

    }

    private void loadTestData() {

        D = 200; k = 5;
        books.add(new Batch(2,130)); // D k
        books.add(new Batch(4, 120)); // n p
        books.add(new Batch(2, 80));
        books.add(new Batch(3, 60));
        books.add(new Batch(7, 50));

    }

    private void readInput() {

        String firstInput = inputScanner.nextLine();
        String input;

        D = Integer.valueOf(firstInput.split(separator)[0]);
        k = Integer.valueOf(firstInput.split(separator)[1]);

        if ( D < MIN_D || D > MAX_D ) {
            return;
        }

        if(k > 0) {
            for (int i = 0; i < k; i++) {
                input = inputScanner.nextLine();
                n = Integer.valueOf(input.split(separator)[0]);
                p = Integer.valueOf(input.split(separator)[1]);

                if ( p < MIN_P || p > MAX_P || n < MIN_N || n > MAX_N || p < D) {
                    continue;
                }

                books.add(new Batch(n, p));
            }
        }

    }

    private void sortBooks() {

        for (Batch batch : books) {

            for ( List<Integer> shelve : shelves.values() ) {

                // poate shelve trebuie sa fie obiect

            }

        }

    }

    private void returnResult() {}

    private void showList() {
        for ( Batch entry : books ) {
            System.out.println(entry.number_n + " " + entry.pages_p);
        }
    }

    //class to store rows
    class Batch {

        private int number_n;
        private int pages_p;

        public Batch(int n, int p) {
            number_n = n;
            pages_p = p;
        }

    }

    // minimizarea rafturilor necesare
    // bibliotexa stie ca are un numar suficient de rafturi pentru toate cartile
    // pe fiecare raft incap carti insumand in total numarul de pagini D
    // se stie cate carti cu un anumit numar de pagini exista

    // aranjare:
    // 1. raft dupa raft
    // 2. raftul curent se completeaza cu cea mai groasa carte disponibila
    // 3. se trece pe urmatorul raft numai daca pe cel curent nu mai incap alte carti disponibile
    // 4. se asigura ca s-au plasat toate cartile pe rafturi

    // input:
    // prima linie:
    //      D si k numere intregi; separata prin space;
    //      D = dimensiunea rafturilor (nr total pagini)
    //      k = numarul de dimensiuni diferite pentru carti
    // urmatoarele k linii:
    //      cate doua numere intregi n si p
    //      n = numarul de carti
    //      p = grosime (pagini)
    // cele k linii ce contin informatii despre carti sunt date in ordinea inversa a grosimii p

    // output:
    // m linii = rafturi pe care au fost puse cel putin o carte in ordinea completarii lor
    // fiecare m linie = o serie de numere intregi, separate prin spatiu, reprezentand dimensiunea cartilor, in ordinea plasarii pe raft

    //restictii:
    // 1. D [50; 10_000]
    // 2. p [1; 1_000]
    // 3. n [1; 100]
    // 4. p < D
    // 5. rafturile nu este obligatoriu sa fie la capacitate maxima D

    // input:
    // 200 5
    // 2 130
    // 4 120
    // 2 80
    // 3 60
    // 7 50

    // output
    // 130 60
    // 130 60
    // 120 80
    // 120 80
    // 120 60
    // 120 50
    // 50 50 50 50
    // 50 50

}
