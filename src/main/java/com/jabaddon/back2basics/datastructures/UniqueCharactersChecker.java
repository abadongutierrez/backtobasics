package com.jabaddon.back2basics.datastructures;

import java.util.Arrays;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you
 * can not use additional data structures?
 *
 * @author Rafael Antonio Guti&eacute;rrez Turullols
 */
public class UniqueCharactersChecker {
    private String string;

    public UniqueCharactersChecker(String string) {
        this.string = new String(string);
    }

    public boolean test() {
        char[] array = string.toCharArray();
        Arrays.sort(array);
        print(array);
        char lastChar = ' ';
        for (int i = 0; i < array.length; ++i) {
            if (i == 0) {
                lastChar = array[i];
                continue;
            }
            else if (lastChar == array[i]) return false;
            lastChar = array[i];
        }
        return true;
    }

    private void print(char[] array) {
        System.out.print("[");
        for (char c : array) {
            System.out.print(c);
        }
        System.out.println("]");
    }
}
