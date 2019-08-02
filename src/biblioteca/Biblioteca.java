package biblioteca;

import java.awt.print.Book;
import java.util.*;

public class Biblioteca {

    private Scanner inputScanner = new Scanner(System.in);
    private List<Shelve> shelves = new LinkedList<>();
    private List<Book> books = new LinkedList<>();
    private int D;
    private int k;
    private int n, p;
    private String separator = " ";

    // restrictions
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

        } else {

            biblioteca.readInput();
            biblioteca.sortBooks();
            biblioteca.returnResult();
        }

    }

    private void loadTestData() {

        D = 200; k = 5;

        List<String> inputs = new ArrayList<>();
        inputs.add("2 130");
        inputs.add("4 120");
        inputs.add("2 80");
        inputs.add("3 60");
        inputs.add("7 50");

        for (String s : inputs) {

            int total = Integer.valueOf(s.split(separator)[0]);
            int pages = Integer.valueOf(s.split(separator)[1]);

            for (int i = 0; i < total; i++) {
                books.add(new Book(pages));
            }
        }

    }

    private void readInput() {

        String firstInput = inputScanner.nextLine();
        String input;

        D = Integer.valueOf(firstInput.split(separator)[0]); //total page capacity on shelf
        k = Integer.valueOf(firstInput.split(separator)[1]); //different book sizes

        if ( D < MIN_D || D > MAX_D ) {
            return;
        }

        if(k > 0) {
            for (int i = 0; i < k; i++) {
                input = inputScanner.nextLine();
                n = Integer.valueOf(input.split(separator)[0]);
                p = Integer.valueOf(input.split(separator)[1]);

                if ( p < MIN_P || p > MAX_P || n < MIN_N || n > MAX_N || p > D) {
                    continue;
                }

                for (int b = 0; b < n; b++) {
                    books.add(new Book(p));
                }
            }
        }

    }

    private void sortBooks() {

        if (books == null) {
            return;
        }

        Shelve currentShelve;

        while ( !books.isEmpty() ) {

            // create first shelve
            if (shelves.isEmpty()) {
                shelves.add(new Shelve(D));
            }

            currentShelve = shelves.get(shelves.size()-1);
            List<Book> booksToBeRemoved = new LinkedList<>();

            for (Book book : books) {

                if (book.pages_p <= currentShelve.capacityLeft) {
                    currentShelve.books.add(book);
                    currentShelve.capacityLeft -= book.pages_p;
                    booksToBeRemoved.add(book);
                }
            }

            books.removeAll(booksToBeRemoved);
            shelves.add(new Shelve(D));
        }

    }

    private void returnResult() {

        StringBuilder sb = new StringBuilder();

        for (Shelve shelve : shelves ) {

            //empty the sb
            sb.delete(0, sb.capacity());

            //add all books from one shelve to sb to be outputted
            for ( int i = 0; i < shelve.books.size(); i++ ) {
                sb.append(shelve.books.get(i).pages_p);

                //append a space only if is not last book on the shelve
                if(i < shelve.books.size() - 1) {
                    sb.append(" ");
                }
            }

            // output books pages on shelve
            System.out.println(sb.toString());
        }
    }

    class Book {
        private int pages_p;

        private Book(int p) {
            pages_p = p;
        }
    }

    //class to store output organised shelves
    class Shelve {
        private int capacityLeft;
        private List<Book> books = new LinkedList<>();

        private Shelve(int capacity) {
            this.capacityLeft = capacity;
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
