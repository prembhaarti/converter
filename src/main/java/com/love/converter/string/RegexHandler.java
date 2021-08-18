package com.love.converter.string;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHandler {

    public static void main(String[] args) {
        RegexHandler regexHandler = new RegexHandler();
        String inputData = "<li class='quotemenu quotemenuselect'><a id='/stock-share-price/housing-development-finance-corpltd/hdfc/500010/' href='/stock-share-price/housing-development-finance-corpltd/hdfc/500010/'>HOUSING DEVELOPMENT FINANCE CORPLTD<br /><span><strong>HDFC</strong>&nbsp;&nbsp;&nbsp;INE001A01036&nbsp;&nbsp;&nbsp;500010</span> <span class='offleft' tabindex='-1' style='position: absolute; display:none; left: -999px;'>5 matches found </span></a></li><li class='quotemenu'><a id='/stock-share-price/hdfc-bank-ltd/hdfcbank/500180/' href='/stock-share-price/hdfc-bank-ltd/hdfcbank/500180/'><strong>HDFC</strong> BANK LTD<br /><span><strong>HDFC</strong>BANK&nbsp;&nbsp;&nbsp;INE040A01034&nbsp;&nbsp;&nbsp;500180</span></li><li class='quotemenu'><a id='/stock-share-price/hdfc-life-insurance-company-ltd/hdfclife/540777/' href='/stock-share-price/hdfc-life-insurance-company-ltd/hdfclife/540777/'><strong>HDFC</strong> LIFE INSURANCE COMPANY LTD<br /><span><strong>HDFC</strong>LIFE&nbsp;&nbsp;&nbsp;INE795G01014&nbsp;&nbsp;&nbsp;540777</span></li><li class='quotemenu'><a id='/stock-share-price/hdfc-asset-management-company-ltd/hdfcamc/541729/' href='/stock-share-price/hdfc-asset-management-company-ltd/hdfcamc/541729/'><strong>HDFC</strong> ASSET MANAGEMENT COMPANY LTD<br /><span><strong>HDFC</strong>AMC&nbsp;&nbsp;&nbsp;INE127D01025&nbsp;&nbsp;&nbsp;541729</span></li><li class='quotemenu'><a id='/stock-share-price/housing-development-finance-corporation-ltd/hdfcw3/961912/' href='/stock-share-price/housing-development-finance-corporation-ltd/hdfcw3/961912/'>HOUSING DEVELOPMENT FINANCE CORPORATION LTD<br /><span><strong>HDFC</strong>W3&nbsp;&nbsp;&nbsp;INE001A13049&nbsp;&nbsp;&nbsp;961912</span></li>";
        String regex = "[/]%s[/][0-9]*[/]";

//        List<String> list = regexHandler.fetchRegexPatternData("{\"<<<x|b|z>>>\"},{\"xyz\":\"hola\"},{\"<<<a|b|c>>>\"},", "(<<<\\S[^,]+>>>)");
        List<String> list = regexHandler.fetchRegexPatternData(inputData, regex);
        for(String data: list){
            System.out.println(data);
        }
//        System.out.println(list);
    }

    public String getFirstRegexPatternData(String baseData, String regex){
        List<String> matchedDataList = fetchRegexPatternData(baseData, regex);
        if(CollectionUtils.isEmpty(matchedDataList)){
            return null;
        }
        return matchedDataList.get(0);
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
