public class SimplePig {
    public static String pigIt(String phrase) {
        String[] words = getWordsOf(phrase);
        return pig(words);
    }

    private static String[] getWordsOf(String phrase) {
        return phrase.split(" ");
    }

    private static String pig(String[] words) {
        String piggedPhrase = "";
        for (String word : words){
            if (hasSpecialCharactersOrNumbers(word)) piggedPhrase += word + " ";
            else piggedPhrase += pigWord(word) + " ";
        }
        return piggedPhrase.trim();
    }

    private static boolean hasSpecialCharactersOrNumbers(String phrase) {
        return phrase.matches("([a-zA-Z]*[\\W||\\d][a-zA-Z]*)*");
    }

    private static String pigWord(String phrase) {
        char firstLetter = phrase.charAt(0);
        return phrase.substring(1) + firstLetter + "ay";
    }
}
