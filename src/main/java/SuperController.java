package main.java;

public class SuperController {
    ConsoleViewer consoleViewer;
    ConverterStringBuilder converterStringBuilder;
    ControllerStringBuilder controllerStringBuilder;
    ConverterString converterString;
    ControllerString controllerString;
    ConverterStringBuffer converterStringBuffer;
    ControllerStringBuffer controllerStringBuffer;
    int first;
    int last;

    public SuperController(){
        first = 2000000000;
        last = 2000019000;

        consoleViewer = new ConsoleViewer();
        converterStringBuilder = new ConverterStringBuilder(first, last);
        controllerStringBuilder = new ControllerStringBuilder(converterStringBuilder, consoleViewer);
        converterString = new ConverterString(first, last);
        controllerString = new ControllerString(converterString, consoleViewer);
        converterStringBuffer = new ConverterStringBuffer(first, last);
        controllerStringBuffer = new ControllerStringBuffer(converterStringBuffer, consoleViewer);
    }

    public void start(){
        controllerStringBuilder.start(first, last);
        controllerStringBuffer.start(first, last);
        controllerString.start(first, last);

        consoleViewer.view("\n" + (last - first + 1) + " чисел от " +  first + " до " + last + "\n");
        consoleViewer.view("StringBuilder: поочередно один за другим:  "
                +  String.valueOf(controllerStringBuilder.record.getOneByOneTime()));
        consoleViewer.view("StringBuilder: сборка одного слова:        "
                +  String.valueOf(controllerStringBuilder.record.getComplexTime()));
        consoleViewer.view("");

        consoleViewer.view("StringBuffer:  поочередно один за другим:  "
                +  String.valueOf(controllerStringBuffer.record.getOneByOneTime()));
        consoleViewer.view("StringBuffer:  сборка одного слова:        "
                +  String.valueOf(controllerStringBuffer.record.getComplexTime()));
        consoleViewer.view("");

        consoleViewer.view("String:        поочередно один за другим:  "
                +  String.valueOf(controllerString.record.getOneByOneTime()));
        consoleViewer.view("String:        сборка одного слова:        "
                +  String.valueOf(controllerString.record.getComplexTime()));

    }
}
