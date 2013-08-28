package com.jabaddon.back2basics.datastructures;

import org.junit.Test;

/**
 * @author Rafael Antonio Guti&eacute;rrez Turullols
 */
public class BinaryTest {

    @Test
    public void testToBinaryString() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("[" + i + " => " + Integer.toBinaryString(i) + "]");
        }
    }

    @Test
    public void testShiftLeft() {
        for (int i = 1; i < 1000; ++i) {
            System.out.println("[" + i + " => " + Integer.toBinaryString(i) + "]");
            i <<= 1;
        }
    }

    @Test
    public void testShift() {
        System.out.println("[" + 0b1 + "]");
        System.out.println("[" + (0b1 << 1) + "]");
        System.out.println("[" + (0b1 << 2) + "]");
        System.out.println("[" + (0b1 >> 1) + "]");
    }
}
