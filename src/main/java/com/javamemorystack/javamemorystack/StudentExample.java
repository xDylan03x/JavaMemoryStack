/*
Class example adopted from https://java.meritcampus.com/core-java-topics/java-multiple-methods-in-one-class-example-program
*/

package com.javamemorystack.javamemorystack;

class StudentExample {
    public static void main(MemoryStackManager memoryStackManager) {
        FunctionCall fc = new FunctionCall("main");
        Student srini = new Student(memoryStackManager);
        memoryStackManager.push(fc);
        fc.push("srini - Student");
        srini.name = "Srinivas";
        srini.english = 87;
        srini.telugu = 84;
        srini.hindi = 76;
        srini.maths = 100;
        srini.science = 92;
        srini.social = 88;

        MainApplication.updateExampleProgramOutput("-------------------------------------------------");
        MainApplication.updateExampleProgramOutput("Detailed Marks");
        MainApplication.updateExampleProgramOutput("-------------------------------------------------");
        srini.printMarksDetails();
        MainApplication.updateExampleProgramOutput("-------------------------------------------------");
        MainApplication.updateExampleProgramOutput("-------------------------------------------------");
        MainApplication.updateExampleProgramOutput("Summary Marks");
        MainApplication.updateExampleProgramOutput("-------------------------------------------------");
        srini.printMarksSummary();
        MainApplication.updateExampleProgramOutput("-------------------------------------------------");
        MainApplication.updateExampleButtons();
    }
}

class Student {
    String name;
    // Marks in various subjects
    int english;
    int telugu;
    int hindi;
    int maths;
    int science;
    int social;
    MemoryStackManager memoryStackManager;

    public Student(MemoryStackManager memoryStackManager) {
        this.memoryStackManager = memoryStackManager;
    }

    int getLanguagesTotal() {
        FunctionCall fc = new FunctionCall("getLanguagesTotal");
        memoryStackManager.push(fc);
        return english + telugu + hindi;
    }

    int getNonLanguagesTotal() {
        FunctionCall fc = new FunctionCall("getNonLanguagesTotal");
        memoryStackManager.push(fc);
        return maths + science + social;
    }

    int getAllSubjectsTotal() {
        FunctionCall fc = new FunctionCall("getAllSubjectsTotal");
        memoryStackManager.push(fc);
        return getLanguagesTotal() + getNonLanguagesTotal();
    }

    double getPCMPercentage() {
        FunctionCall fc = new FunctionCall("getPCMPercentage");
        memoryStackManager.push(fc);
        return 100.0 * (maths + science) / 200.0;
    }

    void printMarksSummary() {
        FunctionCall fc = new FunctionCall("printMarksSummary");
        memoryStackManager.push(fc);
        MainApplication.updateExampleProgramOutput("Languages: " + getLanguagesTotal());
        MainApplication.updateExampleProgramOutput("Non languages: " + getNonLanguagesTotal());
        MainApplication.updateExampleProgramOutput("PCM Percentage: " + getPCMPercentage());
        MainApplication.updateExampleProgramOutput("Total: " + getAllSubjectsTotal());
    }

    void printMarksDetails() {
        FunctionCall fc = new FunctionCall("printMarksDetails");
        memoryStackManager.push(fc);
        MainApplication.updateExampleProgramOutput("English : " + english);
        MainApplication.updateExampleProgramOutput("Telugu : " + telugu);
        MainApplication.updateExampleProgramOutput("Hindi : " + hindi);
        MainApplication.updateExampleProgramOutput("Maths : " + maths);
        MainApplication.updateExampleProgramOutput("Science : " + science);
        MainApplication.updateExampleProgramOutput("Social : " + social);
    }
}