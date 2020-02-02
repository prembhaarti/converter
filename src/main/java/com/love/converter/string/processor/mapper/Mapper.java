package com.love.converter.string.processor.mapper;

import com.love.converter.string.processor.model.MapperType;
import com.love.converter.string.processor.model.MappingRequest;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public abstract class Mapper {

    static Map<Pair<MapperType,MapperType>, Mapper> inputOuputMapper = new HashMap<>();

    public static Mapper getMapper(MappingRequest mappingRequest){
        MapperType inputMapperType = mappingRequest.getInputMapperType();
        MapperType outputMapperType = mappingRequest.getOutputMapperType();
        Pair<MapperType,MapperType> inputPair = new Pair<>(inputMapperType, outputMapperType);
        return inputOuputMapper.get(inputPair);
    }

    static {
        Pair<MapperType,MapperType> stringToListMapper = new Pair<>(MapperType.STRING, MapperType.LIST);
        Pair<MapperType,MapperType> stringToStringMapper = new Pair<>(MapperType.STRING, MapperType.STRING);
        Pair<MapperType,MapperType> listToListMapper = new Pair<>(MapperType.LIST, MapperType.LIST);
        Pair<MapperType,MapperType> listToStringMapper = new Pair<>(MapperType.LIST, MapperType.STRING);
        inputOuputMapper.put(stringToListMapper, new StringToListMapper());
        inputOuputMapper.put(listToListMapper, new ListToListMapper());
        inputOuputMapper.put(stringToStringMapper, new StringToStringMapper());
        inputOuputMapper.put(listToStringMapper, new ListToStringMapper());
    }

    public abstract void map(MappingRequest mappingRequest);
}
