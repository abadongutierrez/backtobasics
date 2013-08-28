package com.jabaddon.back2basics.datastructures;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Rafael Antonio Guti&eacute;rrez Turullols
 */
public class UniqueCharactersCheckerTest {
    @Test
    public void testUniqueCharacters() {
        assertThat(new UniqueCharactersChecker("a").test(), is(true));
        assertThat(new UniqueCharactersChecker("ab").test(), is(true));
        assertThat(new UniqueCharactersChecker("abc").test(), is(true));
        assertThat(new UniqueCharactersChecker("abcd").test(), is(true));
        assertThat(new UniqueCharactersChecker("1").test(), is(true));
        assertThat(new UniqueCharactersChecker("123").test(), is(true));
    }

    @Test
    public void testNoUniqueCharacters() {
        assertThat(new UniqueCharactersChecker("aa").test(), is(false));
        assertThat(new UniqueCharactersChecker("aba").test(), is(false));
        assertThat(new UniqueCharactersChecker("abcc").test(), is(false));
        assertThat(new UniqueCharactersChecker("abcdccc").test(), is(false));
        assertThat(new UniqueCharactersChecker("1231145").test(), is(false));
        assertThat(new UniqueCharactersChecker("1231").test(), is(false));
    }
}
