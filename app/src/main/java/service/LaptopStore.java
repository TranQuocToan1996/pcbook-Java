package service;

import pcbookJava.Laptop;

public interface LaptopStore {
    void Save(Laptop laptop) throws Exception; // Should define entity for save
    Laptop Find(String id) throws Exception;
}
