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

    private static class SimplePig {
        public static String pigIt(String phrase) {
            if (phrase.matches("[\\W||\\d]") || phrase.isEmpty()) return phrase;
            return pigWord(phrase);
        }

        private static String pigWord(String phrase) {
            char firstLetter = phrase.charAt(0);
            return phrase.substring(1) + firstLetter + "ay";
        }
    }
}
