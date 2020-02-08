package com.love.converter.string.processor.mapper;

import com.love.converter.string.StringOpsHandler;
import com.love.converter.string.processor.model.Action;
import com.love.converter.string.processor.model.ActionSignal;
import com.love.converter.string.processor.model.MappingRequest;
import javafx.util.Pair;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ListToListMapper extends Mapper {

    @Override
    public void map(MappingRequest mappingRequest) {
        List<String> dataList = mappingRequest.getDataList();
        List<ActionSignal> actionSignals = mappingRequest.getActionSignals();

        for (ActionSignal actionSignal : actionSignals) {
            Action action = actionSignal.getAction();
            String actionData = actionSignal.getActionData();

            switch (action) {
                case STARTS_WITH:
                    mappingRequest.setDataList(dataList.stream().filter(data -> data.startsWith(actionData)).collect(Collectors.toList()));
                    break;

                case NOT_STARTS_WITH:
                    mappingRequest.setDataList(dataList.stream().filter(data -> !data.startsWith(actionData)).collect(Collectors.toList()));
                    break;

                case ENDS_WITH:
                    mappingRequest.setDataList(dataList.stream().filter(data -> data.endsWith(actionData)).collect(Collectors.toList()));
                    break;

                case NOT_ENDS_WITH:
                    mappingRequest.setDataList(dataList.stream().filter(data -> !data.endsWith(actionData)).collect(Collectors.toList()));
                    break;

                case CONTAINS:
                    mappingRequest.setDataList(dataList.stream().filter(data -> data.contains(actionData)).collect(Collectors.toList()));
                    break;

                case NOT_CONTAINS:
                    mappingRequest.setDataList(dataList.stream().filter(data -> !data.contains(actionData)).collect(Collectors.toList()));
                    break;

                case LOWERCASE:
                    mappingRequest.setDataList(dataList.stream().map(data -> data.toLowerCase()).collect(Collectors.toList()));
                    break;

                case UPPERCASE:
                    mappingRequest.setDataList(dataList.stream().map(data -> data.toUpperCase()).collect(Collectors.toList()));
                    break;

                case SENTENCECASE:
                    mappingRequest.setDataList(dataList.stream().map(data -> StringOpsHandler.getTitleCase(data)).collect(Collectors.toList()));
                    break;

                case REMOVE:
                    mappingRequest.setDataList(dataList.stream()
                            .map(data -> data.replace(actionData, StringUtils.EMPTY))
                            .collect(Collectors.toList()));
                    break;

                case REPLACE:
                    String actionDataCopy = actionData;
                    if(actionData.contains(SPACE)){
                        actionDataCopy = actionDataCopy.replace(SPACE, " ");
                    }
                    Pair<String, String> keyValuePair = StringOpsHandler.getTwoStringSplittedList(actionDataCopy, "#");
                    mappingRequest.setDataList(dataList.stream()
                            .map(data -> data.replace(keyValuePair.getKey(), keyValuePair.getValue()))
                            .collect(Collectors.toList()));
                    break;

                case SPLIT_GET_HEAD:
                    mappingRequest.setDataList(dataList.stream()
                            .map(data -> StringOpsHandler.splitAndGetFirst(data, actionData))
                            .collect(Collectors.toList()));
                    break;

                case SPLIT_GET_TAIL:
                    mappingRequest.setDataList(dataList.stream()
                            .map(data -> StringOpsHandler.splitAndGetSecond(data, actionData))
                            .collect(Collectors.toList()));
                    break;


            }
        }

    }
}
