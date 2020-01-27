package com.love.converter.string;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringOpsHandler {
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


    public static String getJoinedString(List<String> list, String joinerString){
        StringJoiner joiner = new StringJoiner(joinerString);
        for(String data: list){
            joiner.add(data);
        }
        return joiner.toString();
    }

    public static String getJoinedStringFromSet(Set<String> list, String joinerString){
        StringJoiner joiner = new StringJoiner(joinerString);
        for(String data: list){
            joiner.add(data);
        }
        return joiner.toString();
    }

}
