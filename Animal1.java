public interface Animal1{
       public void name();
}
public class Rabbit implements Animal1{
       public void name(){
              System.out.println("This is a Rabbit.");
       }
}
public class Monkey implements Animal1{
       public void name(){
              System.out.println("This is a Monkey.");
       }
}
public interface Animal1Factory{
      public Animal produceAnimal1();
} 

public class RabbitFactory implements Animal1Factory{
     public Animal1 produceAnimal1(){
         return new Rabbit();
      }
}
public class MonkeyFactory implements Animal1Factory{
     public Animal1 produceAnimal1(){
         return new Monkey();
      }
}

     
        