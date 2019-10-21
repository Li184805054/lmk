public class Example02{
     public static void main(String[] args){
     Mythread mythread=new Mythread();
     Thread thread=new Thread(mythread);
     thread.start();
  for(int i=1; i<=100; i++){
  System.out.println("main");
}
}
}
class Mythread implements Runnable{
   public void run(){
      for(int i=1; i<=50; i++){
     System.out.println("new");
}
}
}

      