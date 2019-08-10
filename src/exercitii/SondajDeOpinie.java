package exercitii;

import java.util.*;

public class SondajDeOpinie {

    //cerinta1 CARE SUNT PARTIDELE DESPRE CARE AU AVUT O EVOLUTIE CONTINUA?
    //CERINTA2 CARE A BCASTIGAT CEL MAI MULT ELECTORAT?
// INPUT
    //INT P-NR. PARTIDE SI S-NR. SONDAJE
    //STRING Np-DENUMIRE PARTID, INT S PROCENTE OBTINUTE LA CELE S SONDAJE
//OUTPUT
    //NUME PARTIDE SAU NU EXISTA
    //NUMELE PARTIDULUI CASTIGATOR

/*
            5 10
            ABC 50 44 43 40 35 32 30 28 22 20
            DEF 0 0 0 0 0 10 20 30 30 28
            GHI 20 20 20 20 20 20 20 20 22 19
           JKL 20 19 18 17 16 15 15 15 15 13
           MNO 10 17 19 23 29 23 15 7 13 20
 */

    private int P, S;
    private String Np;
    private HashMap<String, Integer[]> partideMap = new HashMap<>();


    public static void main(String[] args) {

        SondajDeOpinie sdo = new SondajDeOpinie();
//        sdo.citesteInput();
        sdo.populateMap();
        System.out.println(sdo.verificareTrend());
        System.out.println(sdo.maxElectorat());

    }

    public void citesteInput() {
        Scanner scanner = new Scanner(System.in);
        String primaLinie = scanner.nextLine(); // "5 10"

        String[] primaLinieLista = primaLinie.split(" ");
        P = Integer.valueOf(primaLinieLista[0]);
        S = Integer.valueOf(primaLinieLista[1]);

        if (P < 5) {
            P = 5;
        }

        if (P > 20) {
            P = 20;
        }
        if(S<2){
            S=2;
        }
        if(S>20)
            S=20;

        String partide;
        String partid;

        for (int i = 1; i <= P; i++) {
            Integer[] sondaje = new Integer[S];
            partide = scanner.nextLine();
            partid = partide.split(" ")[0];
            for (int j = 1; j <= S; j++) {
                sondaje[j - 1] = Integer.valueOf(partide.split(" ")[j]);
            }
            partideMap.put(partid, sondaje);
        }

    }

    public String verificareTrend() {

        String rezultat = "";

        for (Map.Entry<String, Integer[]> entry : partideMap.entrySet()) {
            int i=0;
            boolean isTrending = true;

            while(i<S-1){
                if(entry.getValue()[i]>entry.getValue()[i+1]) {
                    isTrending = false;
                    break;
                }
                i++;
            }

            if (isTrending) {
                if(rezultat.isEmpty()) {
                    rezultat = entry.getKey();
                } else {
                    rezultat = rezultat + " " + entry.getKey();
                }
            }
        }

        if (rezultat.isEmpty())
            rezultat="Nu exista";

        return rezultat;
    }

    public void populateMap() {
//        partideMap.put("ABC", new Integer[]{50, 44, 43, 40, 35, 32, 30, 28, 22, 20});
//        partideMap.put("DEF", new Integer[]{0, 0, 0, 0, 0, 10, 20, 30, 30, 28});
//        partideMap.put("GHI", new Integer[]{20, 20, 20, 20, 20, 20, 20, 20, 22, 19});
//        partideMap.put("JKL", new Integer[]{20, 19, 18, 17, 16, 15, 15, 15, 15, 13});
//        partideMap.put("MNO", new Integer[]{10, 17, 19, 23, 29, 23, 15, 7, 13, 20});
//
//        P = 5;
//        S = 10;

        P = 20; S = 3;

        partideMap.put("ABC", new Integer[]{12,20,30});
        partideMap.put("DEF", new Integer[]{10,10,20});
        partideMap.put("GHI", new Integer[]{50,20,20});
        partideMap.put("JKL", new Integer[]{10,20,10});
        partideMap.put("MNO", new Integer[]{18,30,20});

    }

    public String maxElectorat(){

        String partid= "";
        int maxElectorat = 0;

        for(Map.Entry<String,Integer[]> entry: partideMap.entrySet()){
            int electorat= entry.getValue()[S-1]-entry.getValue()[0];
            if(electorat>maxElectorat) {
                maxElectorat = electorat;
                partid=entry.getKey();
            }
        }
        return partid + " " + maxElectorat + "%";

    }


}
