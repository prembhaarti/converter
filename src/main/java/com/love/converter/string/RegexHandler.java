package com.love.converter.string;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHandler {

    public static void main(String[] args) {
        RegexHandler regexHandler = new RegexHandler();
        List<String> list = regexHandler.fetchRegexPatternData("{\"<<<x|b|z>>>\"},{\"xyz\":\"hola\"},{\"<<<a|b|c>>>\"},", "(<<<\\S[^,]+>>>)");
        for(String data: list){
            System.out.println(data);
        }
//        System.out.println(list);
    }

    public List<String> fetchRegexPatternData(String baseData, String regex) {
        List<String> allMatches = new ArrayList<>();
        Matcher m = Pattern.compile(regex)
                .matcher(baseData);
        while (m.find()) {
            allMatches.add(m.group());
        }
        return allMatches;
    }
}
