package com.love.converter.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringOpsHandler {

    public static List<String> getTrimmedList(List<String> stringList){
        return stringList.stream().map(
                data -> data.trim()
        ).collect(Collectors.toList());
    }

    public static List<String> getSplittedList(String data, String seperator){
        List<String> splittedData = Arrays.asList(data.split(seperator));
        return getTrimmedList(splittedData);
    }
}
