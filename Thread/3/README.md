# execute的操作

核心代码如下

```java
public void execute(Runnable command) {
    if (command == null)
        throw new NullPointerException();
    /*
     * Proceed in 3 steps:
     *
     * 1. If fewer than corePoolSize threads are running, try to
     * start a new thread with the given command as its first
     * task.  The call to addWorker atomically checks runState and
     * workerCount, and so prevents false alarms that would add
     * threads when it shouldn't, by returning false.
     *
     * 2. If a task can be successfully queued, then we still need
     * to double-check whether we should have added a thread
     * (because existing ones died since last checking) or that
     * the pool shut down since entry into this method. So we
     * recheck state and if necessary roll back the enqueuing if
     * stopped, or start a new thread if there are none.
     *
     * 3. If we cannot queue task, then we try to add a new
     * thread.  If it fails, we know we are shut down or saturated
     * and so reject the task.
     */
  //ctl是一个原子操作
    int c = ctl.get();
    if (workerCountOf(c) < corePoolSize) {
      //添加到队列  
      if (addWorker(command, true))
            return;
        c = ctl.get();
    }
    if (isRunning(c) && workQueue.offer(command)) {
        int recheck = ctl.get();
        if (! isRunning(recheck) && remove(command))
            reject(command);
        else if (workerCountOf(recheck) == 0)
            addWorker(null, false);
    }
    else if (!addWorker(command, false))
        reject(command);
}
```

1. 如果当前运行的线程数小于我门预期的数据，则会创建新的线程来执行新的任务
2. 如果运行的线程个数等于或者大于我门的预期的数量，则会提交的任务存放到阻塞的队列当中
3. 如果阻塞队列已经满的话，则会创建新的线程执行任务
4. 如果线程超过了设置的线程数，则会使用饱和策略进行处理