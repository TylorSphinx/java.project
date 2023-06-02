package Soku;

public class SeatorderedCase {
    private int seatResource;     //共享缓冲区
    private boolean empty=true;    //是否为空的信号量

    public void setEmpty(){
        empty=true;
    }

    public synchronized void push(int pubResource){
        while (!empty){                       //当缓冲区满的时候等待
            try {                             //阻塞自己
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        seatResource = pubResource;        //将生成的座位号放到缓冲区中
        empty = false;
        notify();            //唤醒其他等待的线程
    }

    public synchronized int pop(){       //从缓冲区中定座位
        while (empty){
            try {
                wait();                  //当缓冲区为空的时候等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int popResource = seatResource;
        seatResource = 0;
        empty = true;                  //设置缓冲区为空的状态
        notify();
        return popResource;            //返回所定的座位号
    }

    //生成空座位线程（生产者）
    static class SeatProcedure extends Thread{
        private SeatorderedCase so;
        public SeatProcedure(SeatorderedCase so){
            this.so = so;
        }

        @Override
        public void run() {
            for (int i = 0; i <= 30 ; i++) {    //连续向缓冲区中生成空座位号
                int pubResource = i;
                so.push(pubResource);
                System.out.println("第"+pubResource+"号座位为空");
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //预订座位线程（消费者）
    static class SeatConsumer extends Thread{
        private SeatorderedCase so;
        public SeatConsumer(SeatorderedCase so){
            this.so = so;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 50 ; i++) {       //生成50个学生，50个学生连续从缓冲区中取出座位号
                synchronized (so){
                    int sh = so.pop();
                    if (sh != 0){
                        System.out.println("学生"+ i +"占了第" + sh +"号座位");
                    } else {
                        System.out.println("没有空座位，请等待");
                    }
                }
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //释放座位线程
    static class SeatRelease extends Thread{
        private SeatorderedCase so;
        public SeatRelease(SeatorderedCase so){
            this.so = so;
        }

        @Override
        public void run() {
            try {
                sleep(20000);
                this.so.setEmpty();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 1; i <= 30; i++) {         //从第一个开始，连续释放已预订的座位
                int pubResource = i;
                so.push(pubResource);
                System.out.println("第"+pubResource+"号座位取消预订");
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SeatorderedCase so = new SeatorderedCase();

        SeatProcedure sp = new SeatProcedure(so);
        sp.start();

        SeatConsumer sc = new SeatConsumer(so);
        sc.start();

        SeatRelease sr = new SeatRelease(so);
        sr.start();
    }

}
