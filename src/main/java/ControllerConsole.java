package main.java;

public class ControllerConsole {


    NumberToWordsConverter converter = new NumberToWordsConverter();
    ConsoleViewer consoleViewer = new ConsoleViewer();

    ControllerConsole(NumberToWordsConverter converter, ConsoleViewer consoleViewer){
        this.consoleViewer = consoleViewer;
        this.converter = converter;
    }

    public void start(){
        for (int i = 21; i <= 22; i++) {
            consoleViewer.view(converter.toWords(i));
        }
//        consoleViewer.view(converter.toWords(22));
    }

}
