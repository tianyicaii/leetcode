package lintcode;


interface Toy {
    void talk();
}

class Dog implements Toy {
    public void talk() { System.out.println("Wow"); }
}

class Cat implements Toy {
    public void talk() { System.out.println("Meow"); }
}

class ToyFactory {
    public Toy getToy(String type) {
        if (type.equalsIgnoreCase("cat")) return new Cat();
        else if (type.equalsIgnoreCase("dog")) return new Dog();
        else return null;
    }
}

public class I0496ToyFactory {
    
}
