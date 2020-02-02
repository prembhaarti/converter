package com.love.converter.string.processor.mapper;

import com.love.converter.string.StringOpsHandler;
import com.love.converter.string.processor.model.Action;
import com.love.converter.string.processor.model.ActionSignal;
import com.love.converter.string.processor.model.MappingRequest;

import java.util.List;

public class ListToStringMapper extends Mapper {

    private static final String NEW_LINE = "new_line";

    @Override
    public void map(MappingRequest mappingRequest) {
        List<String> dataList = mappingRequest.getDataList();
        List<ActionSignal> actionSignals = mappingRequest.getActionSignals();

        for (ActionSignal actionSignal : actionSignals) {
            Action action = actionSignal.getAction();
            String actionData = actionSignal.getActionData();

            switch (action) {
                case MERGE:
                    if(NEW_LINE.equalsIgnoreCase(actionData)){
                        actionData = actionData.replace(NEW_LINE, "\n");
                    }
                    mappingRequest.setData(StringOpsHandler.getJoinedString(dataList, actionData));
                    break;
            }
        }

    }
}
