package com.personal.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest {

    public static <E> void retainAll(Set<E> a, Set<E> b) {
        
        Set<E> result = new HashSet<E>(a);
        
        result.retainAll(b);
        
        System.out.println(result.toString());
    }
    public static void main(String[] args) {
        
        Set<String> a = new HashSet<String>();
        a.add("a");
        a.add("b");
        a.add("c");
        Set<String> b = new HashSet<String>();
        b.add("d");
        b.add("b");
        b.add("c");
        System.out.println(Collections.max(b));
        String[] barr = b.toArray(new String[b.size()]);
        List<String> blist = Arrays.asList(barr);
        Collections.sort(blist);
        System.out.println(blist);
//        Collections.reverse(blist);
//        System.out.println(blist);
        Collections.sort(blist, Collections.reverseOrder());
        System.out.println(blist);
        SetTest.retainAll(a, b);
    }
}
