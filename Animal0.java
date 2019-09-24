public interface Animal{
       public void name();
}
public class Rabbit implements Animal{
       public void name(){
              System.out.println("This is a Rabbit.");
       }
}
public class Monkey implements Animal{
       public void name(){
              System.out.println("This is a Monkey.");
       }
}
class AnimalFactory{
     public static Animal produceAnimal(String brand){
         if(brand.equals("Rabbit"))
         return new Rabbit();

         if(brand.equals("Monkey"))
         return new Monkey();

         return null;
        }
} 
        