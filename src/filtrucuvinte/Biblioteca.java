package filtrucuvinte;

public class Biblioteca {

    public static void main(String[] args) {

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
