package com.design.pattern.creation.singleton;

/**
 * DoubleCheckedLocking 双重检查锁
 * 实现 线程安全的延迟初始化
 */
public class DoubleCheckSingleton {

    /**
     * Q：加volatile的原因
     * 1.分配内存空间
     * 2.初始化对象
     * 3.将对象指向刚分配的内存空间
     *
     * 编译器因为性能原因，会将第二步和第三步重排序
     * 1.分配内存空间
     * 2.将对象指向刚分配的内存空间
     * 3.初始化对象
     *
     * 指令重排后，可能A线程正在初始化对象（未完成步骤三），
     * B线程访问到的是尚未初始化的对象（判断了对象不为空，直接返回了未初始化的对象）
     *
     * 多线程编程要确保满足intra-thread semantics（多线程语义）
     * 为了保证重排序不改变各线程的程序执行结果
     */
    private static volatile DoubleCheckSingleton sIntance;

    private DoubleCheckSingleton(){}


    /**
     * Q：为什么要加 synchronized ？
     * 不加的话，会导致有多个实例对象
     * 例如线程A和线程B同时访问getInstance，
     * 完全会导致A实例了对象A instance，B实例了对象B instance
     *
     */
    public static DoubleCheckSingleton getInstance() {
        if (sIntance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (sIntance == null) {
                    sIntance = new DoubleCheckSingleton();
                }
            }
        }
        return sIntance;
    }
}
