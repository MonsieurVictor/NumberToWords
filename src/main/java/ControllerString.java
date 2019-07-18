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

    public void start(){
        benchmark.start();
        for (int i = 1; i <= 999; i++) {
            consoleViewer.view(converter.toWords(i));
        }
        benchmark.finish();
        record.setOneByOneTime(benchmark.countTimePassed());

        benchmark.start();
        consoleViewer.view(converter.toWords());
        benchmark.finish();
        record.setComplexTime(benchmark.countTimePassed());
    }
}
