package queue;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2022/6/30 21:13
 * @description：父类抽象队列
 */
public abstract class ParentQueue<E> {
    final int maxSize;//最大容量
    int front;//头
    int rear;//尾
    final E[] arr;//用于存放数据，模拟队列


    public ParentQueue(int caps) {
        arr = (E[]) new Object[caps];
        front = 0;
        rear = 0;
        maxSize = caps;
    }

    public abstract boolean isEmpty();

    public abstract boolean isFull();

    public abstract void add(E item);

    public abstract E get();
}
