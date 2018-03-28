package com.nexusy.java.v8;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author lanhuidong
 * @since 2016-10-26
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;

    public static final long THRESHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }

        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        leftTask.fork();

        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        long rightResult = rightTask.compute();
        long leftResult = leftTask.join();

        return rightResult + leftResult;
    }

    private Long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 10_000_000).toArray();
        ForkJoinSumCalculator calculator = new ForkJoinSumCalculator(numbers);
        long sum = new ForkJoinPool().invoke(calculator);
        System.out.println(sum);
        System.out.println(LongStream.rangeClosed(1, 10_000_000).sum());
    }
}
