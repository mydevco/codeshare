package com.mydevco.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureExample {

	public Future<Void> calculateAsync4() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello"); 
		CompletableFuture<Void> future = completableFuture
		.thenAccept(s -> System.out.println("Computation returned: " + s + " World using supplyAsync() .. thenAccept()..thenRun"));
		future = completableFuture.thenRun(() -> System.out.println("Computation Finished!"));
		return future;
	}
	
	public Future<Void> calculateAsync7() throws InterruptedException {
		CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> "Hello")
				  .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World using supplyAsync().. thenAcceptBoth()"),
						    (s1, s2) -> System.out.println(s1 + s2));
		return completableFuture;
	}
	
	public Future<String> calculateAsync3() throws InterruptedException {
		CompletableFuture<String> completableFuture = new CompletableFuture<String>();
        completableFuture.complete("Hello World using complete()");
	    return completableFuture;
	}
	
	public Future<String> calculateAsync2() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello")
			    .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World using supplyAsync() .. thenCompose() .. supplyAsync()"));
	 
	    return completableFuture;
	}
	
	public Future<String> calculateAsync6() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello")
			    .thenCombine(CompletableFuture.supplyAsync(() -> " World using supplyAsync() .. thenCobine()"), (s1, s2) -> s1 + s2);
	 
	    return completableFuture;
	}
	
	public Future<String> calculateAsync5() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
		completableFuture = completableFuture.thenApply(s -> s + " World using supplyAsync and thenApply");
	 
	    return completableFuture;
	}
	
	public Future<String> calculateAsync1() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Hello World using completedFuture()");
	    return completableFuture;
	}
	
	public String checkCompletableFutureString(Future<String> completableFuture)
			throws InterruptedException, ExecutionException {
		return completableFuture.get();
	}

	public void checkCompletableFutureVoid(Future<Void> completableFuture)
			throws InterruptedException, ExecutionException {
		completableFuture.get();
	}
	
	public void checkCompletableFutureParallel()
			throws InterruptedException, ExecutionException {
		CompletableFuture<String> future1  
		  = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future2  
		  = CompletableFuture.supplyAsync(() -> "Parallel");
		CompletableFuture<String> future3  
		  = CompletableFuture.supplyAsync(() -> "World");
		 
		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

		combinedFuture.get();
		 
		assert future1.isDone();
		assert future2.isDone();
		assert future3.isDone();
		
		String combined = Stream.of(future1, future2, future3)
				  .map(CompletableFuture::join)
				  .collect(Collectors.joining(" "));
		
		assert "Hello Parallel World".equals(combined);
	}

	public static void main(String[] args) {
		CompletableFutureExample completableFutureExample = new CompletableFutureExample();
		try {
			
			Future<String> completableFuture = completableFutureExample.calculateAsync2();
			String result = completableFutureExample.checkCompletableFutureString(completableFuture);
			System.out.println(result);
			
			completableFuture = completableFutureExample.calculateAsync1();
			result = completableFutureExample.checkCompletableFutureString(completableFuture);
			System.out.println(result);
			
			completableFuture = completableFutureExample.calculateAsync3();
			result = completableFutureExample.checkCompletableFutureString(completableFuture);
			System.out.println(result);
			
			completableFuture = completableFutureExample.calculateAsync5();
			result = completableFutureExample.checkCompletableFutureString(completableFuture);
			System.out.println(result);
			
			completableFuture = completableFutureExample.calculateAsync6();
			result = completableFutureExample.checkCompletableFutureString(completableFuture);
			System.out.println(result);
			
			Future<Void> completableFutureVoid = completableFutureExample.calculateAsync4();
			completableFutureExample.checkCompletableFutureVoid(completableFutureVoid);
			
			completableFutureVoid = completableFutureExample.calculateAsync7();
			completableFutureExample.checkCompletableFutureVoid(completableFutureVoid);
			
			completableFutureExample.checkCompletableFutureParallel();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
