package com.anil.mt;

import java.util.Arrays;

public class RunnableReturn {
    public static void main(String[] args) throws InterruptedException {
        RunnableReturn runnableReturn = new RunnableReturn();
        int[] arr = {1,2,3,4,5};
        System.out.println(runnableReturn.calculateSum(arr));
    }
    public int calculateSum(int[] arr) throws InterruptedException {
        SumRunnable sumRunnable = new SumRunnable(arr);
        Thread thread = new Thread(sumRunnable);
        thread.start();
        thread.join();
        return sumRunnable.getSumResult();
    }
}
class SumRunnable implements Runnable{
    int sumResult;
    int[] arr;

    public int getSumResult() {
        return sumResult;
    }

    public void setSumResult(int sumResult) {
        this.sumResult = sumResult;
    }

    public SumRunnable(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        setSumResult(Arrays.stream(arr).sum());
    }
}
