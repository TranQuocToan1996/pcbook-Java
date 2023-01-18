package service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import pcbookJava.Laptop;

public class InMemoryLaptopStore implements LaptopStore {
    private ConcurrentMap<String, Laptop> data;

    public InMemoryLaptopStore() {
        data = new ConcurrentHashMap<>(0);

    }


    @Override
    public void Save(Laptop laptop) throws Exception {
        if (data.containsKey(laptop.getId())) {
            throw new AlreadyExistExeption("already exist");
        }

        var other = laptop.toBuilder().build();
        data.put(other.getId(), other);
        
    }

    @Override
    public Laptop Find(String id) throws Exception {
        if (!data.containsKey(id)) {
            return null;
        }

        var laptop = data.get(id).toBuilder().build();
        return laptop;
    }
    
}
