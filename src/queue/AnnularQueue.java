package queue;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2022/6/30 20:36
 * @description：可以想象成一个圆形。环形队列:主要解决普通队列产生的“假溢出现象”，元素会根据取模的结果下标进行插入。
 * 队列为满的情况：1.头指针和尾指针距离相差一位，需要预留一个空间作为运算条件 2.添加数据时头指针和尾指针想遇 因为头指针移动代表数据被添加
 * 队列为空的情况：1.头指针和尾指针相等 2.获取数据时头指针和尾指针想遇，因为尾指针移动代表数据被获取
 */
public class AnnularQueue<E> {
    public static void main(String[] args) {
        AnnularQueue<Integer> queue = new AnnularQueue<>(3);
        queue.add(1);
        queue.add(2);
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.isEmpty());
    }

    private final int maxSize;//最大容量
    private int front;//头
    private int rear;//尾
    private final E[] arr;//用于存放数据，模拟队列

    public AnnularQueue(int caps) {
        arr = (E[]) new Object[caps];
        front = 0;
        rear = 0;
        maxSize = caps;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        // 如果两个指针之间相差一个那么就是满的,代价就是预留一个空间
        return (rear + 1) % maxSize == front;
    }

    public void add(E item) {
        if (isFull()) {
            throw new RuntimeException("满");
        }
        arr[rear] = item;
        // 取模运算，限制在maxSize的范围内，如果小于maxSize就是本身，大于就是余数
        rear = (rear + 1) % maxSize;
    }

    public E get() {
        if (isEmpty()) {
            throw new RuntimeException("空");
        }
        E item = arr[front];
        arr[front] = null;
        front = (front + 1) % maxSize;
        return item;
    }
}
