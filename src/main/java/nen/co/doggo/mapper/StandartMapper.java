package nen.co.doggo.mapper;

public interface StandartMapper<T, U, K> {

    U toEntity(T t);

    U updateEntityFromRequest(T t, U u);

    K toResponse(U u);
}
