public class StopWatch {

	private double startTime = 0;
	private double stopTime = 0;
	private boolean running = false;

	public void start() {
		this.startTime = System.nanoTime();
		this.running = true;
	}

	public void stop() {
		this.stopTime = System.nanoTime();
		this.running = false;
	}

	public double getTime() {
		double elapsed;
		if (running) {
			elapsed = (System.nanoTime() - startTime);
		} else {
			elapsed = (stopTime - startTime);
		}
		return (elapsed / 1000000);
	}
}