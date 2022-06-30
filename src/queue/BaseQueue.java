package queue;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2022/6/30 21:20
 * @description：FIFO队列，先进先出
 */
public class BaseQueue<E> extends ParentQueue<E> {

    public static void main(String[] args) {
        BaseQueue<Integer> baseQueue = new BaseQueue<>(3);
        baseQueue.add(1);
        baseQueue.add(2);
        baseQueue.add(3);
        System.out.println(baseQueue.get());
        System.out.println(baseQueue.get());
        System.out.println(baseQueue.get());
        // 这里报错了？假溢出现象，取出数据时头指针移动了，被取出的数据下标不能再被访问。
        baseQueue.add(3);
    }

    public BaseQueue(int caps) {
        super(caps);
    }

    @Override
    public boolean isEmpty() {
        return front == maxSize;
    }

    @Override
    public boolean isFull() {
        return rear == maxSize;
    }

    @Override
    public void add(E item) {
        if (isFull()) throw new RuntimeException("满");
        arr[rear++] = item;
    }

    @Override
    public E get() {
        if (isEmpty()) throw new RuntimeException("空了");
        E e = arr[front];
        // gc
        arr[front] = null;
        front++;
        return e;
    }
}
