public class Example01{
    public static void main(String[] args){
  Mythread1 st1= new Mythread1();
  Mythread2 st2= new Mythread2();
  st1.start();
  st2.start();
}
}
class Mythread1 extends Thread{
   public void run(){
     System.out.println("线程一");
}
}
class Mythread2 extends Thread{
   public void run(){
     System.out.println("线程二");
}
}

 