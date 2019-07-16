package main.java;

public class ControllerConsole {

    NumberToWordsConverter converter;
    ConsoleViewer consoleViewer;
    SimpleBenchmark benchmark = new SimpleBenchmark();

    ControllerConsole(NumberToWordsConverter converter, ConsoleViewer consoleViewer){
        this.consoleViewer = consoleViewer;
        this.converter = converter;
    }

    public void start(){
        benchmark.start();
        for (int i = 1; i <= 999; i++) {
            consoleViewer.view(converter.toWords(i));
        }
        benchmark.finish();
        consoleViewer.view(String.valueOf(benchmark.countTimePassed()));



        benchmark.start();
        consoleViewer.view(converter.toWords());
        benchmark.finish();
        consoleViewer.view(String.valueOf(benchmark.countTimePassed()));
    }

}
