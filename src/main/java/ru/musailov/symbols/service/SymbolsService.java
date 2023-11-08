package ru.musailov.symbols.service;

import org.springframework.stereotype.Service;
import ru.musailov.symbols.models.Answer;
import ru.musailov.symbols.models.Request;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SymbolsService {


    // Считаем количество вхождений в строку
    private static long countOccurrences(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

    // Получаем ответ от сервера
    public Answer getAnswer(Request request) {
        if (request.getString().length() == 0) {
            return new Answer("");
        }
        Set<Character> characters = request.getString().chars().mapToObj(e -> (char)e).collect(Collectors.toSet());
        Map<Character, Long> map = new HashMap<>();
        characters.forEach(e -> {
            map.put(e, countOccurrences(request.getString(), e));
        });


        StringBuffer stringBuffer = getResult(map);
        return new Answer(stringBuffer.toString());
    }


    // Создаем массив из пар ключ-значение, сортируем его по значениям по убыванию
    private StringBuffer getResult(Map<Character, Long> map) {
        List<Map.Entry<Character, Long>> entryList = new ArrayList<>(map.entrySet());

        Comparator<Map.Entry<Character, Long>> frequencyComparator = (e1, e2) -> e2.getValue().compareTo(e1.getValue());

        entryList.sort(frequencyComparator);

        StringBuffer stringBuffer = new StringBuffer();

        entryList.forEach(entry -> {
            stringBuffer.append("'" + entry.getKey() + "': " + entry.getValue() + ", ");
        });

        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer;
    }
}
