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

    private static class SimplePig {
        public static String pigIt(String phrase) {
            return phrase;
        }
    }
}
