package org.training.speedrun.stage5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class WordValidatorTest {

    private final WordValidator sut = new WordValidator();

    @Test
    void long_words_are_valid_if_they_have_4_vowels() {
        assertThat(sut.isValidCharacter("azertyuiopqsdfg")).isTrue();
    }

    @Test
    void long_words_are_valid_if_they_have_at_least_3_special_letters() {
        assertThat(sut.isValidCharacter("rz-zty+op+sdfg")).isTrue();
    }

    @Test
    void short_words_are_valid_if_they_have_at_least_5_letters_in_upper_case() {
        assertThat(sut.isValidCharacter("PlKZMZ")).isTrue();
    }

    @Test
    void short_words_are_valid_if_they_have_3_vowels() {
        assertThat(sut.isValidCharacter("aeio")).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pazof", "AOJGKFLDLFMG", "", "oplm", "lkoirp"})
    void other_words_are_invalid(String word) {
        assertThat(sut.isValidCharacter(word)).isFalse();
    }
}
