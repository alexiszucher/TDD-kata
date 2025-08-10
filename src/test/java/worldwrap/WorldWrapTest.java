package worldwrap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WorldWrapTest {
    @Test
    void givenColumnNumberMoreThanCompletePhrase_shouldShowOneLine() {
        String phrase = "A good family";
        Assertions.assertEquals(phrase, WorldWrap.wrap(phrase, 10000));
    }

    @Test
    void givenColumnNumberIsHalfOfCompletePhrase_shouldShowTwoLines() {
        String phrase = "A good family";
        Assertions.assertEquals("A good\nfamily", WorldWrap.wrap(phrase, 6));
    }

    @Test
    void shouldShowFourLinesAndDontLineBreakInTheMiddleOfTheWords() {
        String phrase = "I've worked a lot on this kata to improve myself.";
        Assertions.assertEquals("I've\nworked\na lot\non\nthis\nkata\nto\nimprove\nmyself.", WorldWrap.wrap(phrase, 5));
    }
}