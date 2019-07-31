package main.java;

public class ControllerStringBuffer {
    ConverterStringBuffer converter;
    ConsoleViewer consoleViewer;
    SimpleBenchmark benchmark = new SimpleBenchmark();
    Record record = new Record();

    ControllerStringBuffer(ConverterStringBuffer converter, ConsoleViewer consoleViewer){
        this.consoleViewer = consoleViewer;
        this.converter = converter;
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