public class Taxis{
     public static void main(String[] args){
     Taxi car=new Taxi();
     new Thread(car,"���⳵1").start();
     new Thread(car,"���⳵2").start();
     new Thread(car,"���⳵3").start();
     new Thread(car,"���⳵4").start();
     new Thread(car,"���⳵5").start();
}
}
class Taxi implements Runnable{
     private int passengers=100;
     public void run(){
       while(true){
          if(passengers>0){
          Thread th=Thread.currentThread();
          String th_name=th.getName();
        System.out.println(th_name+"���ڽ��͵� "+passengers--+" λ�˿�.");
}
}
}
}
  