public class Example03{
     public static void main(String[] args){
     Teacher te=new Teacher();
     new Thread(te,"老师1").start();
     new Thread(te,"老师2").start();
     new Thread(te,"老师3").start();
}
}
class Teacher implements Runnable{
     private int notes=80;
     public void run(){
       while(true){
          if(notes>0){
          Thread th=Thread.currentThread();
          String th_name=th.getName();
        System.out.println(th_name+"正在分发第 "+notes--+" 份笔记");
}
}
}
}
  