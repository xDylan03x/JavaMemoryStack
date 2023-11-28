package com.javamemorystack.javamemorystack;

import java.util.LinkedList;

public class FunctionCall {

    private String name;
    private LinkedList<String> objectStack;

    public FunctionCall(String name) {
        this.name = name;
        this.objectStack = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void push(String s) {
        objectStack.push(s);
    }

    public String pop() {
        return objectStack.pop();
    }

    public String peek() {
        return objectStack.peek();
    }

    public void clearObjectStack() {
        objectStack.clear();
    }

    public String getItemAtIndex(int i) {
        return objectStack.get(i);
    }

    public int getSize() {
        return objectStack.size();
    }

    @Override
    public String toString() {
        String s = "Objects: \n";
        for (int i = 0; i < objectStack.size(); i++) {
            s += String.format("%s, ", objectStack.get(i));
        }
        return s;
    }
}
