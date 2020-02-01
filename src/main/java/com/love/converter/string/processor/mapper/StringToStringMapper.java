package com.love.converter.string.processor.mapper;

import com.love.converter.string.processor.Mapper;
import com.love.converter.string.processor.model.Action;
import com.love.converter.string.processor.model.ActionSignal;
import com.love.converter.string.processor.model.MappingRequest;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class StringToStringMapper extends Mapper {

    @Override
    public void map(MappingRequest mappingRequest) {
        String data = mappingRequest.getData();
        List<ActionSignal> actionSignals = mappingRequest.getActionSignals();

        for (ActionSignal actionSignal : actionSignals) {
            Action action = actionSignal.getAction();
            String actionData = actionSignal.getActionData();

            switch (action) {
                case REMOVE:
                    mappingRequest.setData(data.replace(actionData, StringUtils.EMPTY));
                    break;

            }
        }
    }
}
