interface Animal{
    int ID=1;
    void run();
    void breathe();
}
class Dog implements Animal{
     public void breathe(){
          System.out.println("¹·ÔÚºôÎü");
    }
     public void run(){
          System.out.println("¹·ÔÚÅÜ");
    }
}

public class Example06{
       public static void main(String[] args){
           Dog dog = new Dog();
           dog.breathe();
           dog.run();
       }
}