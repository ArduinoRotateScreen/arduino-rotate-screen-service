package com.arnaugarcia.ArduinoRotateScreenClient.mapper;

import java.util.List;

import static java.util.stream.Collectors.toList;

public interface EntityMapper<E, D> {
    D toDTO(E entity);

    default List<D> toDTO(List<E> entityList) {
        return entityList.stream()
                .map(this::toDTO)
                .collect(toList());
    }
}

