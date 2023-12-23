package com.ronsoft.books.nio.regex;

import java.nio.CharBuffer;

/**
 * Demonstrate behavior of java.lang.CharSequence as implemented
 * by String, StringBuffer and CharBuffer.
 * <p>
 * Created: April, 2002
 *
 * @author Ron Hitchens (ron@ronsoft.com)
 * @version $Id: CharSeq.java,v 1.1 2002/05/07 02:21:08 ron Exp $
 */
public class CharSeq {
    public static void main(String[] argv) {
        StringBuffer stringBuffer = new StringBuffer("Hello World");
        CharBuffer charBuffer = CharBuffer.allocate(20);
        CharSequence charSequence = "Hello World";

        // derived directly from a String
        printCharSequence(charSequence);// length=11, content='Hello World'

        // derived from a StringBuffer
        charSequence = stringBuffer;
        printCharSequence(charSequence);// length=11, content='Hello World'

        // change StringBuffer
        stringBuffer.setLength(0);
        stringBuffer.append("Goodbye cruel world");
        // same "immutable" CharSequence yields different result
        printCharSequence(charSequence);// length=19, content='Goodbye cruel world'

        // derive CharSequence from CharBuffer.
        charSequence = charBuffer;
        charBuffer.put("xxxxxxxxxxxxxxxxxxxx");
        charBuffer.clear();

        charBuffer.put("Hello World");
        charBuffer.flip();
        printCharSequence(charSequence);// length=11, content='Hello World'

        charBuffer.mark();
        charBuffer.put("Seeya");
        charBuffer.reset();
        printCharSequence(charSequence);// length=11, content='Seeya World'

        charBuffer.clear();
        printCharSequence(charSequence);// length=20, content='Seeya Worldxxxxxxxxx'
        // changing underlying CharBuffer is reflected in the
        // read-only CharSequnce interface.
    }

    private static void printCharSequence(CharSequence cs) {
        System.out.println("length=" + cs.length() + ", content='" + cs.toString() + "'");
    }
}