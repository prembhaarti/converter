package com.love.converter.string.processor.model;

import lombok.Data;

import java.util.List;

@Data
public class MappingResponse {
    private Class clazz;
    private String data;
    private List<String> dataList;
}
