public class Liti07{
     public static void main(String[] args){
     Thread minpriority=new Thread(new Minpriority(),"优先级较低的线程");
     Thread maxpriority=new Thread(new Maxpriority(),"优先级较高的线程");
     minpriority.setPriority(Thread.MIN_PRIORITY);
     maxpriority.setPriority(10);
     maxpriority.start();
     minpriority.start();
}
}
class Maxpriority implements Runnable{
    public void run(){
   for(int i=0;i<10;i++){
  System.out.println(Thread.currentThread().getName()+"正在输入："+i);
}
}
}
class Minpriority implements Runnable{
    public void run(){
   for(int i=0;i<10;i++){
  System.out.println(Thread.currentThread().getName()+"正在输入："+i);
}
}
}
