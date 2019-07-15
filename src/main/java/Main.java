package main.java;

public class Main {
    public static void main(String[] args) {
        NumberToWordsConverter converter = new NumberToWordsConverter();
        ConsoleViewer consoleViewer = new ConsoleViewer();
        ControllerConsole controller = new ControllerConsole(converter, consoleViewer);
        controller.start();
    }
}
