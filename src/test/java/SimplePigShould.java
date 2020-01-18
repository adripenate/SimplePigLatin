import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimplePigShould {
    @Test
    public void not_pig_when_string_is_empty() {
        assertThat(SimplePig.pigIt("")).isEqualTo("");
    }

    @Test
    public void not_pig_when_string_is_not_a_word() {
        assertThat(SimplePig.pigIt("!")).isEqualTo("!");
    }

    @Test
    public void pig_when_string_is_a_word() {
        assertThat(SimplePig.pigIt("Hello")).isEqualTo("elloHay");
    }

    @Test
    public void not_pig_when_word_has_special_character() {
        assertThat(SimplePig.pigIt("Hello!")).isEqualTo("Hello!");
    }

    @Test
    public void not_pig_when_word_has_number() {
        assertThat(SimplePig.pigIt("Hello5")).isEqualTo("Hello5");
    }

    @Test
    public void pig_multiple_words() {
        assertThat(SimplePig.pigIt("Hello my friend")).isEqualTo("elloHay ymay riendfay");
    }

    @Test
    public void pig_valid_words() {
        assertThat(SimplePig.pigIt("Hello my go3od friend!")).isEqualTo("elloHay ymay go3od friend!");
    }

    private static class SimplePig {
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
}
