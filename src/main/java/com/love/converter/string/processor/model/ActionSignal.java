package com.love.converter.string.processor.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActionSignal {
    private Action action;
    private String actionData;
}
