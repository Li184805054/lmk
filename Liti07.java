public class Liti07{
     public static void main(String[] args){
     Thread minpriority=new Thread(new Minpriority(),"���ȼ��ϵ͵��߳�");
     Thread maxpriority=new Thread(new Maxpriority(),"���ȼ��ϸߵ��߳�");
     minpriority.setPriority(Thread.MIN_PRIORITY);
     maxpriority.setPriority(10);
     maxpriority.start();
     minpriority.start();
}
}
class Maxpriority implements Runnable{
    public void run(){
   for(int i=0;i<10;i++){
  System.out.println(Thread.currentThread().getName()+"�������룺"+i);
}
}
}
class Minpriority implements Runnable{
    public void run(){
   for(int i=0;i<10;i++){
  System.out.println(Thread.currentThread().getName()+"�������룺"+i);
}
}
}
