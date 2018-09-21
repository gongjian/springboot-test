package org.james.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.util.StopWatch;

public class ForkJoinExample extends RecursiveTask<Integer> {

  private static final long serialVersionUID = 1L;

  private final int threshold = 5;
  private int first;
  private int last;

  public ForkJoinExample(int first, int last) {
    this.first = first;
    this.last = last;
  }

  @Override
  protected Integer compute() {
    int result = 0;

    if (last - first <= threshold) {
      for (int i = first; i <= last; i++) {
        result += i;
      }
    } else {
      int mid = first + (last - first) / 2;
      ForkJoinExample leftTask = new ForkJoinExample(first, mid);
      ForkJoinExample rightTask = new ForkJoinExample(mid + 1, last);

      leftTask.fork();
      rightTask.fork();

      result = leftTask.join() + rightTask.join();

    }

    return result;
  }

  public static void main(String... args) throws InterruptedException, ExecutionException {
    StopWatch sw = new StopWatch();

    sw.start();

    ForkJoinExample example = new ForkJoinExample(0, 100000000);
    ForkJoinPool pool = new ForkJoinPool();
    Future<Integer> result = pool.submit(example);
    System.out.println(result.get());

    sw.stop();
    System.out.println(sw.getLastTaskTimeMillis());

    sw.start();
    
    int ret = 0;
    for (int i = 0; i <= 100000000; i++) {
      ret += i;
    }
    System.out.println(ret);
    
    sw.stop();
    System.out.println(sw.getLastTaskTimeMillis());
    
    sw.start();
    Integer sum = Stream.iterate(0, x -> x+1).limit(100000000).collect(Collectors.summingInt(Integer::intValue));
    System.out.println(sum);
    
    sw.stop();
    System.out.println(sw.getLastTaskTimeMillis());
  }

}
