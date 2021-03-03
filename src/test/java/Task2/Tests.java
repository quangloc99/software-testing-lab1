package Task2;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.ifmo.se.s267880.softwareTesting.lab1.Task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import Task2.TestData.TestCase;

@RunWith(Parameterized.class)
public class Tests {
    @Parameterized.Parameters(name="{0}")
    public static Iterable<Object[]> data() {
        return Arrays.stream(TestData.data()).map(x -> new Object[]{x}).collect(Collectors.toList());
    }
    TestCase testData;

    public Tests(TestCase testData) {
        this.testData = testData;
    }

    @Test
    public void testFreq() {
        int[] freq = Task2.countFrequency(testData.input);
        assertArrayEquals(testData.freq, freq);
    }

    @Test
    public void testAccumulatedFreq() {
        int[] accumulatedFreq = testData.freq.clone();
        Task2.accumulate(accumulatedFreq);
        assertArrayEquals(testData.accumulatedFreq, accumulatedFreq);
    }

    @Test
    public void testReorder() {
        int[] finalList = Task2.reorder(testData.input, testData.accumulatedFreq.clone());
        assertArrayEquals(testData.output.stream().mapToInt(x -> x).toArray(), finalList);
    }

    @Test
    public void overallTest() {
        List<Integer> input = new ArrayList<Integer>(testData.input);
        Task2.countingSort(input);
        assertEquals(testData.output, input);
    }
}
