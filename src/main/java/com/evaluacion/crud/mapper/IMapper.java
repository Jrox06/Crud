package com.evaluacion.crud.mapper;


public interface IMapper <Input, Output>{
    Output map(Input input) throws Exception;
}

