package com.arnaugarcia.ArduinoRotateScreenClient.service.io.mapper;

import java.util.List;

import static java.util.stream.Collectors.toList;

@SpringMapper
public interface EntityMapper<E, D> {
    D toDTO(E entity);

    default List<D> toDTO(List<E> entityList) {
        return entityList.stream()
                .map(this::toDTO)
                .collect(toList());
    }
}

