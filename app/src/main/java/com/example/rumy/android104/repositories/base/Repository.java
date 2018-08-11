package com.example.rumy.android104.repositories.base;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;

public interface Repository<T> {
    void getAll(Consumer<List<T>> action);
    void add(T item, Consumer<T> action);
    void del(T item, Consumer<T> action);
}
