interface Animal{
    void shout();
}
public class Example08{
       public static void main(String[] args){
       animalShout(new Animal(){
       public void shout(){
          System.out.println("��������");
    }
       });
       animalShout(new Animal(){
       public void shout(){
          System.out.println("��������");
    }
       });
}
  public static void animalShout(Animal an){
       an.shout();
       }
}