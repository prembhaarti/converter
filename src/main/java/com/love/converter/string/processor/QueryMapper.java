package com.love.converter.string.processor;

import com.love.converter.string.processor.model.MappingRequest;

public class QueryMapper {

    public void map(MappingRequest mappingRequest){
        Mapper mapper = Mapper.getMapper(mappingRequest);
        mapper.map(mappingRequest);
    }
}
