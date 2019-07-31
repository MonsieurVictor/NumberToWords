package main.java;

public class ControllerString {

    ConverterString converter;
    ConsoleViewer consoleViewer;
    SimpleBenchmark benchmark = new SimpleBenchmark();
    Record record = new Record();

    ControllerString(ConverterString converterString, ConsoleViewer consoleViewer){
        this.consoleViewer = consoleViewer;
        this.converter = converterString;
    }

    public void start(int first, int last){
        benchmark.start();
        for (int i = first; i >= 1 && i <= last; i++) {
            consoleViewer.view(converter.toWords(i));
        }
        benchmark.finish();

        record.setOneByOneTime(benchmark.getTimePassed());
        benchmark.start();
        consoleViewer.view(converter.toWords());
        benchmark.finish();
        record.setComplexTime(benchmark.getTimePassed());
    }
}