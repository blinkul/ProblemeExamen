package filtrucuvinte;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FiltruCuvinte {

    // TODO: Add the number of secvente nepermise

    private static List<String> listaCuvinteNepermise;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Introduceti pe noua linie textul pentru a fi procesat:");
        String text = input.nextLine();


        System.out.println("\nIntroduceti pe noua linie cuvinetele nepermise separate de un spatiu.");
        String cuvinteNepermise = input.nextLine();

        listaCuvinteNepermise = parseCuvinteNepermise(cuvinteNepermise);

        System.out.println("\nTextul cenzurat este afisat mai jos:");
        System.out.println(censorText(text, listaCuvinteNepermise));
    }

    private static List<String> parseCuvinteNepermise(String listOfCuvinteNepermise) {
        List<String> cuvinteNepermise = Arrays.asList(listOfCuvinteNepermise.split(" "));
        return cuvinteNepermise;
    }

    private static String censorText(String text, List<String> listaCuvinteNepermise) {

        String censoredText = text;

        for( String badWord : listaCuvinteNepermise ) {
            censoredText = censoredText.replaceAll("(?i)" + badWord, getCensorWithLength(badWord.length(), '*'));
        }

        return censoredText;
    }

    private static String getCensorWithLength(int length, char c) {
      StringBuilder censor = new StringBuilder();
      for ( int i = 0; i < length; i++ ) {
          censor.append(c);
      }
      return censor.toString();
    };

}
