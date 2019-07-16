package main.java;


public class SimpleBenchmark {

    long startTime;
    long finishTime;

    void  start(){
        startTime =  System.currentTimeMillis();
    }
    void finish(){
       finishTime =  System.currentTimeMillis();
    };

    long countTimePassed(){
        return finishTime - startTime;
    }
}
