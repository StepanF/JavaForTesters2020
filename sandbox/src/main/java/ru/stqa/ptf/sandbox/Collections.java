package ru.stqa.ptf.sandbox;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {
    String [] lang= {"C#","Java","C++","Basic"};
// пример создания списка
    List<String> languages = new ArrayList<String>();//создание списка, List - интерфейс , ArrayList  - тип реализации
    languages.add("Java");
    languages.add("C#");

//пример преобразования массива в список
    List<String> languages2 = Arrays.asList("C#","Java","C++","Basic");

    for (String l : languages2){ // перебор по массиву можно и по списку
      System.out.println("Язык "+ l);
    }
  }
}
