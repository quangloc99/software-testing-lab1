package Task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {
    static class TestCase {
        List<Integer> input = new ArrayList<>();
        int[] freq;
        int[] accumulatedFreq;
        List<Integer> output = new ArrayList<>();

        TestCase setInput(int... input) {
            for (int i: input) this.input.add(i);
            return this;
        }

        TestCase setFreq(int... freq) {
            this.freq = freq;
            return this;
        }

        TestCase setAccumulatedFreq(int... accumulatedFreq) {
            this.accumulatedFreq = accumulatedFreq;
            return this;
        }

        TestCase setOutput(int... output) {
            for (int i: output) this.output.add(i);
            return this;
        }

        @Override
        public String toString() {
            return this.input.toString();
        }
    }

    public static TestCase[] data() {
        return new TestCase[] {
                new TestCase()
                .setInput(1, 2, 3)
                .setFreq(0, 1, 1, 1)
                .setAccumulatedFreq(0, 1, 2, 3)
                .setOutput(1, 2, 3),

                new TestCase()
                .setInput(0)
                .setFreq(1)
                .setAccumulatedFreq(1)
                .setOutput(0),

                new TestCase()
                .setInput(10, 5)
                .setFreq(0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1)
                .setAccumulatedFreq(0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2)
                .setOutput(5, 10),

                new TestCase()
                .setInput(1, 2, 1, 3, 1, 2, 1, 3)
                .setFreq(0, 4, 2, 2)
                .setAccumulatedFreq(0, 4, 6, 8)
                .setOutput(1, 1, 1, 1, 2, 2, 3, 3),

                new TestCase()
                .setInput(0, 1, 9, 2, 8, 3, 7, 4, 6, 5)
                .setFreq(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
                .setAccumulatedFreq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .setOutput(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),

                new TestCase()
                .setInput(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3)  // pi
                .setFreq(0, 2, 1, 3, 1, 3, 1, 1, 1, 3)
                .setAccumulatedFreq(0, 2, 3, 6, 7, 10, 11, 12, 13, 16)
                .setOutput(1, 1, 2, 3, 3, 3, 4, 5, 5, 5, 6, 7, 8, 9, 9, 9),

                new TestCase()
                .setInput(1, 6, 1, 8, 0, 3, 3, 9, 8, 8, 7, 5)  // golden ratio
                .setFreq(1, 2, 0, 2, 0, 1, 1, 1, 3, 1)
                .setAccumulatedFreq(1, 3, 3, 5, 5, 6, 7, 8, 11, 12)
                .setOutput(0, 1, 1, 3, 3, 5, 6, 7, 8, 8, 8, 9),

                new TestCase()
                .setInput(2, 7, 1, 8, 2, 8, 1, 8, 2, 8, 4, 6)    // e
                .setFreq(0, 2, 3, 0, 1, 0, 1, 1, 4)
                .setAccumulatedFreq(0, 2, 5, 5, 6, 6, 7, 8, 12)
                .setOutput(1, 1, 2, 2, 2, 4, 6, 7, 8, 8, 8, 8),

                new TestCase()
                .setInput(1, 7, 7, 0, 1, 3)
                .setFreq(1, 2, 0, 1, 0, 0, 0, 2)
                .setAccumulatedFreq(1, 3, 3, 4, 4, 4, 4, 6)
                .setOutput(0, 1, 1, 3, 7, 7),

                new TestCase()
                .setInput(100, 42)
                .setFreq(
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 1, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        1)
                    .setAccumulatedFreq(
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                        2)
                    .setOutput(42, 100)
        };
    }
}
