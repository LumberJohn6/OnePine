/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\client\ClientBountyData.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.client;

public class ClientBountyData {
    private static long bounty;

    private ClientBountyData() {
    }

    public static void set(long value) {
        bounty = Math.max(0L, value);
    }

    public static long get() {
        return bounty;
    }
}

