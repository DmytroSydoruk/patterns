interface MacbookInterface {
    void perform();
}

class MacbookIntel implements MacbookInterface {
    @Override
    public void perform() {
        System.out.println("Old task");
    }
}

class MacbookSilicone implements MacbookInterface {
    @Override
    public void perform() {

    }
}

class Adapter extends MacbookSilicone {
    private final MacbookInterface oldObj;

    public Adapter(MacbookInterface obj) {
        this.oldObj = obj;
    }

    @Override
    public void perform() {
        oldObj.perform();
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        MacbookInterface obj = new MacbookIntel();
        Adapter adapter = new Adapter(obj);
        adapter.perform();
    }
}
