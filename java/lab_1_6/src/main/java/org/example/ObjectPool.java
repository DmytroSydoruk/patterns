package org.example;
import java.util.ArrayList;
import java.util.List;

class Reusable {
    @Override
    public String toString() {
        return "Obj";
    }
}

class ReusablePool {
    private List<Reusable> reusables;

    public ReusablePool(int size) {
        reusables = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            reusables.add(new Reusable());
        }
    }

    public Reusable acquire() {
        if (reusables.isEmpty()) {
            return null; 
        }
        return reusables.remove(reusables.size() - 1);
    }

    public void release(Reusable reusable) {
        reusables.add(reusable);
    }

    public List<Reusable> getReusables() {
        return reusables;
    }
}

public class ObjectPool {
    public static void main(String[] args) {
        ReusablePool reusablePool = new ReusablePool(10);
        System.out.println(reusablePool.getReusables());
        Reusable reusable = reusablePool.acquire();
        System.out.println(reusablePool.getReusables());
        reusablePool.release(reusable);
        System.out.println(reusablePool.getReusables());
    }
}
