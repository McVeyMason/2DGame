package com.mason.platformer.graphics;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.mason.platformer.game.Game;
import com.mason.platformer.game.input.InputHandler;

/**
 * Main class; Creates canvas and runs main loop. Extends {@link java.awt.Canvas}
 * 
 * @author Mason
 *
 */
public class Display extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private static InputHandler input;
	private Thread thread;
	private Game game;
	/**
	 * Image projected on the canvas.
	 */
	private BufferedImage img;
	/**
	 * Individual pixels of the image.
	 */
	private int[] pixels;
	private Screen screen;

	/**
	 * If the main loop should be running.
	 */
	private static boolean running = false;
	private static final String TITLE = "2D";

	/**
	 * Width of the canvas.
	 */
	public static final int WIDTH = 1280;
	/**
	 * Height of the canvas
	 */
	public static final int HEIGHT = 720;

	/**
	 * Initializes input listeners, pixels, and images.
	 */
	public Display() {
		input = new InputHandler();
		game = new Game();
		screen = new Screen(WIDTH, HEIGHT);
		img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();

		addKeyListener(input);
		addMouseListener(input);
		addFocusListener(input);
		addMouseMotionListener(input);
	}

	/**
	 * Startup function.
	 */
	public static void main(@SuppressWarnings("javadoc") String[] args) {
		// frame.setContentPane(window);

		JFrame frame = new JFrame();
		Display window = new Display();
		frame.add(window);
		frame.setTitle(TITLE);
		frame.setLocationRelativeTo(null);
		window.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		frame.pack();
		window.start();
	}

	/**
	 * Starts the thread and starts main game loop.
	 */
	private void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * Stops thread and main game loop.
	 */
	private void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * Main game loop. Renders game and detects input.
	 */
	@Override
	public void run() {
		@SuppressWarnings("unused")
		int frames = 0;
		double unprocessedSeconds = 0;
		long previousTime = System.nanoTime();
		double secondsPerTick = 1 / 60.0;
		int tickCount = 0;
		boolean ticked = false;
		System.out.println("Starting main loop...");
		while (running) {
			long currentTime = System.nanoTime();
			long passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unprocessedSeconds = passedTime / 1000000000.0;
			while (unprocessedSeconds > secondsPerTick) {
				tick();
				unprocessedSeconds -= secondsPerTick;
				ticked = true;
				tickCount++;
				if (tickCount % 60 == 0) {
					// System.out.println(frames + "fps");
					previousTime += 1000;
					frames = 0;
				}
			}
			if (ticked) {
				render();
				frames++;
			}
			render();
		}
		stop();
	}

	/**
	 * Renders the image created by the screen class.
	 */
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.render();

		for (int i = 0; i < WIDTH * HEIGHT; i++) {
			pixels[i] = screen.pixels[i];
		}
		Graphics g = bs.getDrawGraphics();
		/*
		 * draws image to canvas
		 */
		g.drawImage(img, 0, 0, WIDTH, HEIGHT, null);
		g.dispose();
		bs.show();
	}

	/**
	 * Listens and processes user input.
	 */
	private void tick() {
		game.tick(input.key);
		Screen.player.runPhysics();
	}
}
