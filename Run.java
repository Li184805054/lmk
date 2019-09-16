class One{
     private static One instance=new One();
     private One(){}
     public static One getInstance(){
     return instance;
   }
     public void jieguo(){
     System.out.println("Hello World!");
   }
}
public class Run{
      public static void main(String[] args){
      One o1=One.getInstance();
      o1.jieguo();
   }
}
