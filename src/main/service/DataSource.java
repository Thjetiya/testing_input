package main.service;

public interface DataSource<T> {

    T readData();

    void writeData(T t);
}
