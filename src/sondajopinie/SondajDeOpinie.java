package sondajopinie;

import java.util.*;

public class SondajDeOpinie {

    private int P; // nr de partide
    private int S; // nr de sondaje

    private String partidMare;
    private int electorat;

    private Map<String, List<Integer>> partide = new HashMap<>(); // key = nume; value = list of sondaje
    private List<String> growingElectorates = new ArrayList<>();

    public static void main(String[] args) {

        boolean isDebug = true;

        SondajDeOpinie sondaj = new SondajDeOpinie();

        sondaj.readData(isDebug);
        sondaj.checkTrend();
        sondaj.checkVoters();

        sondaj.showResults();

    }

    private void readData(boolean isDebug) {

        if(isDebug) {
            // caz 1
//            P = 5;
//            S = 10;
//
//            List<Integer> partid1 = Arrays.asList(50, 44, 43, 40, 35, 32, 30, 28, 22, 20);
//            List<Integer> partid2 = Arrays.asList(0, 0, 0, 0, 0, 10, 20, 30, 30, 28);
//            List<Integer> partid3 = Arrays.asList(20, 20, 20, 20, 20, 20, 20, 20, 22, 19);
//            List<Integer> partid4 = Arrays.asList(20, 19, 18, 17, 16, 15, 15, 15, 15, 13);
//            List<Integer> partid5 = Arrays.asList(10, 17, 19, 23, 29, 23, 15, 7, 13, 20);

            // caz 2
            P = 5;
            S = 3;

            List<Integer> partid1 = Arrays.asList(12, 20, 30);
            List<Integer> partid2 = Arrays.asList(10, 10, 20);
            List<Integer> partid3 = Arrays.asList(50, 20, 20);
            List<Integer> partid4 = Arrays.asList(10, 20, 10);
            List<Integer> partid5 = Arrays.asList(18, 30, 20);

            partide.put("ABC", partid1);
            partide.put("DEF", partid2);
            partide.put("GHI", partid3);
            partide.put("JKL", partid4);
            partide.put("MNO", partid5);

        } else {
            //read input from keyboard
        }

    }

    private void checkTrend() {

        //go throug each party
        for (Map.Entry<String, List<Integer>> entry : partide.entrySet()) {

            //check trend
            int previousSondaj = 0;
            int sondaj;

            for (int i = 0; i < entry.getValue().size(); i++) {
                sondaj = entry.getValue().get(i);

                //daca un sondaj este mai mic decat anteriourul atunci treci la urmatorul partid
                if(sondaj < previousSondaj) {
                    break;
                }
                previousSondaj = sondaj;

                // daca este ultima valoare ai a ajuns pana aici partidul este in crestere
                if(i == entry.getValue().size() - 1) {
                    growingElectorates.add(entry.getKey());
                }
            }
        }

    }

    private void checkVoters() {

        String biggestParty = "";
        int biggestDiff = 0;
        int currentDiff;

        for (Map.Entry<String, List<Integer>> entry : partide.entrySet()) {
            currentDiff = entry.getValue().get(S - 1) - entry.getValue().get(0);
            if(currentDiff > biggestDiff) {
                biggestDiff = currentDiff;
                biggestParty = entry.getKey();
            }
        }

        partidMare = biggestParty;
        electorat = biggestDiff;

    }

    private void showResults() {

        if (growingElectorates.isEmpty()) {
            System.out.println("Nu exista");
        } else {
            StringBuilder growingParties = new StringBuilder();
            for (int i = 0; i < growingElectorates.size(); i++) {
                growingParties.append(growingElectorates.get(i));
                if (i < growingElectorates.size() - 1) {
                    growingParties.append(" ");
                }
            }
            System.out.println(growingParties.toString());
        }
        System.out.println(partidMare + " " + electorat + "%");

    }

}

/*
Cerinta
1. Care partide au avut trend continuu ascendent
2. Care este partidul care a castigat cel mai mult electorat

INPUT:
prima linie: P si S
P = nr partide politice
S = nr sondaje

urmatoarele P linii:
N = partid
S = numere intregi, procente obtinute la cele S sondaje

OutPut
pe prima linie numele partidelor cu trend ascendent
pe a doua linie numele partidului care a castigat cel mai mult

Restrictii
S [2; 20]
P [5; 20]
procente [0; 100]

 */
