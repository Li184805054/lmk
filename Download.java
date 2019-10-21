public class Download{
     public static void main(String[] args){
     Tool tool=new Tool();
     new Thread(tool,"download1").start();
     new Thread(tool,"download2").start();
     new Thread(tool,"download3").start();
}
}
class Tool implements Runnable{
     private int a=3;
     public void run(){
       while(true){
          if(a>0){
          Thread th=Thread.currentThread();
          String th_name=th.getName();
        System.out.println(th_name+":"+a--+".");
}
}
}
}