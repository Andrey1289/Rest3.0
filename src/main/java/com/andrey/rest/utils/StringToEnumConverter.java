package com.andrey.rest.utils;

import com.andrey.rest.entity.TypeAttraction;
import org.springframework.core.convert.converter.Converter;


public class StringToEnumConverter implements Converter<String, TypeAttraction> {

    private TypeAttraction typeAttraction;

    public StringToEnumConverter(String string) {
        this.typeAttraction = convert(string);
    }

    @Override
    public TypeAttraction convert(String source) {
        try {
            return TypeAttraction.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
    public TypeAttraction getTypeAttraction() {
        return typeAttraction;
    }
}