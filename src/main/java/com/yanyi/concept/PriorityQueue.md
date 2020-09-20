## 优先级队列
当应该基于优先级处理对象时，将使用PriorityQueue。众所周知，[队列](https://www.geeksforgeeks.org/queue-interface-java/)遵循先进先出算法，但是有时需要根据优先级来处理队列的元素，这就是PriorityQueue起作用的时候。PriorityQueue基于优先级堆。优先级队列的元素根据自然顺序进行排序，也可以根据队列构造时使用的比较器进行排序，具体取决于所使用的构造函数。 

![队列队列优先级Java队列](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20200903183026/Queue-Deque-PriorityQueue-In-Java.png)

在以下优先级队列中，具有最大ASCII值的元素将具有最高优先级。

![PriorityQueue的工作](https://media.geeksforgeeks.org/wp-content/cdn-uploads/Priority-Queue-min-1024x512.png)

公共类PriorityQueue <E>扩展AbstractQueue <E>实现Serializable

其中E是此队列中保留的元素的类型

该类实现**Serializable**，**Iterable <E>**，**Collection <E>**，[Queue ](https://www.geeksforgeeks.org/queue-interface-java/)接口。

**关于“优先级队列”的**几个**要点**如下： 

-   PriorityQueue不允许为null。
-   我们无法创建不可比对象的PriorityQueue
-   PriorityQueue是未绑定的队列。
-   就指定的顺序而言，此队列的头是最小的元素。如果多个元素的价值最小，那么头就是这些元素之一-领带被任意打破。
-   由于PriorityQueue不是线程安全的，因此Java提供了[PriorityBlockingQueue](https://www.geeksforgeeks.org/priorityblockingqueue-class-in-java/#:~:text=PriorityBlockingQueue is an unbounded blocking,and supplies blocking retrieval operations.&text=PriorityBlockingQueue class and its iterator,the Collection and Iterator interfaces.)类，该类实现了[BlockingQueue](https://www.geeksforgeeks.org/blockingqueue-interface-in-java/#:~:text=Methods in Blocking Queue Interface&text=Removes all available elements from,them to the given collection.&text=Removes at most the given,them to the given collection.)接口以在Java多线程环境中使用。
-   队列检索操作会轮询，删除，查看和访问元素，以访问队列开头的元素。
-   它为添加和轮询方法提供O（log（n））时间。
-   它继承了**AbstractQueue**，**AbstractCollection**，**Collection**和**Object**类的方法。

**构造函数：**

**1. PriorityQueue（）：**创建一个具有默认初始容量（11）的PriorityQueue，该默认容量根据其自然顺序对其元素进行排序。

```
PriorityQueue <E> pq =new PriorityQueue <E>（）;
```

**2. PriorityQueue（Collection <E> c）：**创建一个PriorityQueue，其中包含指定集合中的元素。

```
PriorityQueue <E> pq =new PriorityQueue <E>（Collection <E> c）;
```

**3. PriorityQueue（int initialCapacity）**：创建一个具有指定初始容量的PriorityQueue，该容量根据其自然顺序对元素进行排序。

```
PriorityQueue <E> pq =new PriorityQueue <E>（int initialCapacity）;
```

**4. PriorityQueue（int initialCapacity，Comparator <E>比较器）：**创建一个具有指定初始容量的PriorityQueue，该容量根据指定的比较器对其元素进行排序。

```
PriorityQueue <E> pq = PriorityQueue（int initialCapacity，Comparator <E>comparator）;
```

**5. PriorityQueue（PriorityQueue <E> c）**：创建一个PriorityQueue，其中包含指定优先级队列中的元素。

```
PriorityQueue <E> pq =new PriorityQueue（PriorityQueue <E> c）;
```

**6. PriorityQueue（SortedSet <E> c）**：创建一个PriorityQueue，其中包含指定排序集合中的元素。

```
PriorityQueue <E> pq =new PriorityQueue <E>（SortedSet <E> c）;
```

**例：**

以下示例说明了优先级队列的以下基本操作。

-   [boolean add（E element）：](https://www.geeksforgeeks.org/priorityqueue-add-method-in-java/)此方法将指定的元素插入此优先级队列。
-   [public peek（）：](https://www.geeksforgeeks.org/queue-peek-method-in-java/)此方法检索但不删除此队列的头部，如果此队列为空，则返回null。
-   [public poll（）：](https://www.geeksforgeeks.org/queue-poll-method-in-java/)此方法检索并删除此队列的头部，如果此队列为空，则返回null。