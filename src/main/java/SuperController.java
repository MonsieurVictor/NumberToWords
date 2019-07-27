package main.java;

public class SuperController {

    public void start(){
        ConsoleViewer consoleViewer = new ConsoleViewer();

        ConverterStringBuilder converterStringBuilder = new ConverterStringBuilder();
        ControllerStringBuilder controllerStringBuilder = new ControllerStringBuilder(converterStringBuilder, consoleViewer);
        controllerStringBuilder.start();

//        ConverterString converterString = new ConverterString();
//        ControllerString controllerString = new ControllerString(converterString, consoleViewer);
//        controllerString.start();
//
//        ConverterStringBuffer converterStringBuffer = new ConverterStringBuffer();
//        ControllerStringBuffer controllerStringBuffer = new ControllerStringBuffer(converterStringBuffer, consoleViewer);
//        controllerStringBuffer.start();

        consoleViewer.view("StringBuilder: Время для вывода в консоль 999 чисел  от 1 до 999 поочередно: "
                +  String.valueOf(controllerStringBuilder.record.getOneByOneTime()));
        consoleViewer.view("StringBuilder: Время для сборки 1 слова из 999 чисел от 1 до 999 и последующего вывода в консоль: "
                +  String.valueOf(controllerStringBuilder.record.getComplexTime()));
        consoleViewer.view("");
//
//        consoleViewer.view("StringBuffer: Время для вывода в консоль 999 чисел  от 1 до 999 поочередно: "
//                +  String.valueOf(controllerStringBuffer.record.getOneByOneTime()));
//        consoleViewer.view("StringBuffer: Время для сборки 1 слова из 999 чисел от 1 до 999 и последующего вывода в консоль: "
//                +  String.valueOf(controllerStringBuffer.record.getComplexTime()));
//        consoleViewer.view("");
//
//
//
//        consoleViewer.view("String: Время для вывода в консоль 999 чисел от 1 до 999 поочередно: "
//                +  String.valueOf(controllerString.record.getOneByOneTime()));
//        consoleViewer.view("String: Время для сборки 1 слова из 999 чисел от 1 до 999 и последующего вывода в консоль: "
//                +  String.valueOf(controllerString.record.getComplexTime()));
//        consoleViewer.view("");

    }
}
