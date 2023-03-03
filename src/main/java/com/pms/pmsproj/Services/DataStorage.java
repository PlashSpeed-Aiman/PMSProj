package com.pms.pmsproj.Services;

public interface DataStorage<T> {
    public T loadData();
    public void storeData();
}
