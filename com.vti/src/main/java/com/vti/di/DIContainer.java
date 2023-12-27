package com.vti.di;

import org.modelmapper.ModelMapper;

public class DIContainer {

    public ModelMapper provideModelMapper() {
        return new ModelMapper();
    }
}
