

public class L4Ex1 {

	public static void main(String[] args) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		     for(int i=0; i <=1000; i++)
		    	 System.out.println("Marlon");
		stopWatch.stop();
		     System.out.println("Tempo em nanosegundos:" + stopWatch.getTime());

	}

}
