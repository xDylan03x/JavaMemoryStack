package com.javamemorystack.javamemorystack;

import java.util.LinkedList;

public class MemoryStackManager {
    private LinkedList<FunctionCall> memoryStack;
    private MainApplication mainApplication;

    public MemoryStackManager(MainApplication mainApplication) {
        this.memoryStack = new LinkedList<>();
        this.mainApplication = mainApplication;
    }

    public void push(FunctionCall call) {
        memoryStack.push(call);
        mainApplication.refreshFunctionScrollPane();
    }

    public FunctionCall pop() {
        FunctionCall removed = memoryStack.pop();
        mainApplication.refreshFunctionScrollPane();
        return removed;
    }

    public FunctionCall peek() {
        return memoryStack.peek();
    }

    public FunctionCall removeAtIndex(int i) {
        return memoryStack.remove(i);
    }

    public int search(FunctionCall call) {
        for (int i = 0; i < memoryStack.size(); i++) {
            if (memoryStack.get(i).getName().equals(call.getName())) {
                return i;
            }
        }
        return -1;
    }

    public FunctionCall getItemAtIndex(int i) {
        return memoryStack.get(i);
    }

    public int getSize() {
        return memoryStack.size();
    }

    public void clearMemory() {
        memoryStack.clear();
    }

    @Override
    public String toString() {
        String s = "FunctionCalls: \n";
        for (int i = 0; i < memoryStack.size(); i++) {
            s += String.format("%s, ", memoryStack.get(i).getName());
        }
        return s;
    }
}