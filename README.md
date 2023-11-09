# Java Threading Scalability

> In this experiment, I wanted to demonstrate how Java threading solutions scale when a task is not parallelizable. In particular, I tested 3 threading solutions against a serial execution: 
> 1. `ExplicitLock`
> 2. `synchronized`
> 3. `AtomicInteger`

The average execution time of each solution (outliers removed) is shown below:

![Average Execution Time](results.png)


