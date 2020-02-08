package com.love.converter.string;

import javafx.util.Pair;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class StringOpsHandler {

    private static final String WORD_SEPARATOR = " ";

    public static void main(String[] args) {
        String data = "attrib:xyz:href:b";
        System.out.println(StringUtils.substringAfter(data, ":"));
                
    }

    public static List<String> getTrimmedList(List<String> stringList){
        return stringList.stream().map(
                data -> data.trim()
        ).collect(Collectors.toList());
    }

    public static List<String> getSplittedList(String data, String seperator){
        List<String> splittedData = Arrays.asList(data.split(seperator));
        return getTrimmedList(splittedData);
    }

    public static List<String> getSplittedListWithoutSpace(String data, String seperator){
        List<String> splittedData = Arrays.asList(data.split(seperator));
        return splittedData;
    }


    public static String getJoinedString(List<String> list, String joinerString){
        StringJoiner joiner = new StringJoiner(joinerString);
        for(String data: list){
            joiner.add(data);
        }
        return joiner.toString();
    }

    public static String getTitleCase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        return Arrays
                .stream(text.split(WORD_SEPARATOR))
                .map(word -> word.isEmpty()
                        ? word
                        : Character.toTitleCase(word.charAt(0)) + word
                        .substring(1)
                        .toLowerCase())
                .collect(Collectors.joining(WORD_SEPARATOR));
    }


    public static Pair<String,String> getTwoStringSplittedList(String data, String seperator){
        List<String> splittedParts = StringOpsHandler.getSplittedListWithoutSpace(data, seperator);
        String head = splittedParts.get(0);
        List<String> tails = new ArrayList<>();
        String tail = StringUtils.EMPTY;
        if(CollectionUtils.isNotEmpty(splittedParts) && splittedParts.size()>1){
            tails = splittedParts.subList(1, splittedParts.size());
            for(String tailpart: tails){
                tail+=tailpart;
            }
        }
        Pair<String,String> pair = new Pair<>(head, tail);
        return pair;
    }

    public static String splitAndGetFirst(String data, String seperator){
        return StringOpsHandler.getSplittedList(data, seperator).get(0);
    }

    public static String splitAndGetSecond(String data, String seperator){
        return getTwoStringSplittedList(data, seperator).getValue();
    }

    public static String getJoinedStringFromSet(Set<String> list, String joinerString){
        StringJoiner joiner = new StringJoiner(joinerString);
        for(String data: list){
            joiner.add(data);
        }
        return joiner.toString();
    }

}
