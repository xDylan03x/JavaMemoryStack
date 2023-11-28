/*
Class example adopted from https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/examples-Java-recursion-recursive-methods
 */

package com.javamemorystack.javamemorystack;


public class FibonacciExample {
    public static void main(MemoryStackManager memoryStackManager) {
        FunctionCall fc = new FunctionCall("main");
        memoryStackManager.push(fc);
        for (long i = 1; i <= 9; i++) {
            FunctionCall fc2 = new FunctionCall("fibonacci");
            fc2.push("number - int");
            memoryStackManager.push(fc2);
            MainApplication.updateExampleProgramOutput(fibonacci(i) + " ");
        }
        MainApplication.updateExampleButtons();
    }


    /* A recursive Fibonnaci sequence in Java program */
    public static long fibonacci(long number) {
        if (number == 1 || number == 2) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
