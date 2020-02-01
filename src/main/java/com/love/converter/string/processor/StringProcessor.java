package com.love.converter.string.processor;

import com.love.converter.string.StringOpsHandler;
import com.love.converter.string.processor.model.Action;
import com.love.converter.string.processor.model.ActionSignal;
import com.love.converter.string.processor.model.MapperType;
import com.love.converter.string.processor.model.MappingRequest;
import javafx.util.Pair;

import java.util.List;

public class StringProcessor {

    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor();
        String result = processor.process("q?www.google.com&amp;sdfsf##q?www.xyz.com&amp;asdfge", "list<split:##\nlist<remove:q?\nlist<split_get_head:&amp;\nstring<merge:##");
        System.out.println(result);
    }

    public String process(String source, String sourceQuery){
        List<String> queries = StringOpsHandler.getSplittedList(sourceQuery, "\n");

        MapperType mapperType = MapperType.STRING;
        MappingRequest mappingRequest = new MappingRequest();
        for(String query: queries){
            Pair<String,String> mapperActionDataPair = StringOpsHandler.getTwoStringSplittedList(query, "<");
            String actions = mapperActionDataPair.getValue();
            List<String> actionDataList = StringOpsHandler.getSplittedList(actions, "::");

            mappingRequest.setInputMapperType(mapperType);
            mapperType = MapperType.valueOf(mapperActionDataPair.getKey().toUpperCase().trim());
            mappingRequest.setOutputMapperType(mapperType);
            mappingRequest.setData(source);

            for(String actionData: actionDataList){
                addActions(mappingRequest, actionData);
            }

            Mapper mapper = Mapper.getMapper(mappingRequest);
            mapper.map(mappingRequest);
        }

        String response = mappingRequest.getData();
        return response;
    }

    private void addActions(MappingRequest mappingRequest, String actionData) {
        Pair<String, String> actionNameDataPair = StringOpsHandler.getTwoStringSplittedList(actionData, ":");
        String action = actionNameDataPair.getKey();
        String actionValue = actionNameDataPair.getValue();
        mappingRequest.getActionSignals().add(new ActionSignal(Action.valueOf(action.toUpperCase()), actionValue));
    }

}
