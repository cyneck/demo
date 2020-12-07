package com.example.demo.algorithms;

import io.swagger.models.auth.In;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>Description: </p>
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2020/12/7 20:53
 **/
public class reverseOrder {
    // 评测题目:

    public static void main(String[] args) {
        int[] a = {1, 6, 12, 6, 7, 6};
        reverse2(a);
        reverse(a);

    }

    public static void reverse(int[] a) {
        Map<Integer, Integer> b = new HashMap<Integer, Integer>();
        Map<Integer, Integer> reb = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < a.length; i++) {
            b.put(a[i], i);
            reb.put(i, a[i]);
        }

        List<Integer> bValSort = b.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int[] res = new int[bValSort.size()];
        for (int i = 0; i < bValSort.size(); i++) {
            res[i] = reb.get(bValSort.get(i));
            System.out.println(res[i]);
        }

    }

    public static void reverse2(int[] a) {
        Set<Integer> dir = new HashSet<>();
        List<Integer> b = new ArrayList<>();
        for (int i = a.length - 1; i >= 0; i--) {
            if (!dir.contains(a[i])) {
                b.add(a[i]);
                dir.add(a[i]);
                System.out.println(a[i]);
            }
        }


    }
}
