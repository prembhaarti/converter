package com.love.converter.string.processor.mapper;

import com.love.converter.string.StringOpsHandler;
import com.love.converter.string.processor.Mapper;
import com.love.converter.string.processor.model.Action;
import com.love.converter.string.processor.model.ActionSignal;
import com.love.converter.string.processor.model.MappingRequest;

import java.util.List;

public class StringToListMapper extends Mapper {

    @Override
    public void map(MappingRequest mappingRequest) {
        String data = mappingRequest.getData();
        List<ActionSignal> actionSignals = mappingRequest.getActionSignals();

        for(ActionSignal actionSignal: actionSignals){
            Action action = actionSignal.getAction();
            String actionData = actionSignal.getActionData();

            switch (action){
                case SPLIT:
                    splitToList(mappingRequest, data, actionData);
                    break;
            }
        }
    }

    private void splitToList(MappingRequest mappingRequest, String data, String actionData) {
        List<String> splittedList = StringOpsHandler.getSplittedList(data, actionData);
        mappingRequest.setDataList(splittedList);
    }
}
