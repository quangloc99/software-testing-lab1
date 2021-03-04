package ru.ifmo.se.s267880.softwareTesting.lab1.Task2;

import java.util.Collections;
import java.util.List;

public class CountingSort {
    public static int[] countFrequency(List<Integer> list) {
        int limit = Collections.max(list);
        int[] freq = new int[limit + 1];
        for (int i: list) {
            freq[i] ++;
        }
        return freq;
    }

    public static void accumulate(int[] freq) {
        for (int i = 1; i < freq.length; ++i) {
            freq[i] += freq[i - 1];
        }
    }

    public static int[] reorder(List<Integer> list, int[] accumulatedFreq) {
        int[] res = new int[list.size()];
        for (int i: list) {
            res[--accumulatedFreq[i]] = i;
        }
        return res;
    }

    public static void countingSort(List<Integer> list) {
        int[] freq = countFrequency(list);
        accumulate(freq);
        int[] ans = reorder(list, freq);
        for (int i = 0; i < list.size(); ++i) {
            list.set(i, ans[i]);
        }
    }
}
