package main.java;

public class ControllerConsole {


    NumberToWordsConverter converter = new NumberToWordsConverter();
    ConsoleViewer consoleViewer = new ConsoleViewer();

    ControllerConsole(NumberToWordsConverter converter, ConsoleViewer consoleViewer){
        this.consoleViewer = consoleViewer;
        this.converter = converter;
    }

    public void start(){
        converter.toWords(5);
    }
}
