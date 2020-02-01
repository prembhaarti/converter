package com.love.converter.string.processor.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MappingRequest {
    private MapperType inputMapperType;
    private MapperType outputMapperType;
    private List<ActionSignal> actionSignals = new ArrayList<>();
    private List<String> dataList = new ArrayList<>();
    private String data;
}
