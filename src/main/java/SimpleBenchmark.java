package main.java;


public class SimpleBenchmark {

    long startTime;
    long finishTime;
    long passedTime;

    void  start(){
        startTime =  System.currentTimeMillis();
    }
    void finish(){
       finishTime =  System.currentTimeMillis();
    };

    public String getTimePassed(){
        passedTime = countTimePassed();
        long hours = passedTime / (1_000 * 60 * 60) % 24;
        long minutes = (passedTime /(1_000 * 60)) % 60;
        long seconds = (passedTime / 1_000) % 60;
        passedTime = passedTime % 1_000;
        return (hours + " h " + minutes + " m " + seconds + " s " + passedTime + " ms");
    }

    long countTimePassed(){
        return finishTime - startTime;
    }
}
