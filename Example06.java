interface Animal{
    int ID=1;
    void run();
    void breathe();
}
class Dog implements Animal{
     public void breathe(){
          System.out.println("���ں���");
    }
     public void run(){
          System.out.println("������");
    }
}

public class Example06{
       public static void main(String[] args){
           Dog dog = new Dog();
           dog.breathe();
           dog.run();
       }
}