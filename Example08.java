interface Animal{
    void shout();
}
public class Example08{
       public static void main(String[] args){
       animalShout(new Animal(){
       public void shout(){
          System.out.println("ß÷ß÷¡­¡­");
    }
       });
       animalShout(new Animal(){
       public void shout(){
          System.out.println("ÍôÍô¡­¡­");
    }
       });
}
  public static void animalShout(Animal an){
       an.shout();
       }
}