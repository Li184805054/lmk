public class Liti13{
    public static void main(String[] args){
     Ticket1 ticket=new Ticket1();
    new Thread(ticket,"�߳�һ").start();
    new Thread(ticket,"�̶߳�").start();
    new Thread(ticket,"�߳���").start();
    new Thread(ticket,"�߳���").start();
}
}
class Ticket1 implements Runnable{
     private int tickets=10;
     Object lock=new Object();
     public void run(){
     while (true){
    saleTicket();
   if(tickets<=0){
   break;
}
}
}
  private synchronized void saleTicket(){
   if(tickets>0){
   try{
    Thread.sleep(10);
}catch (InterruptedException e){
     e.printStackTrace();
}
    System.out.println(Thread.currentThread().getName()+"---������Ʊ"+tickets--);
}
}
}