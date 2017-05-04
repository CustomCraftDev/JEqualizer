import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JToolBar;

import org.omg.PortableServer.ServantRetentionPolicyOperations;

import javax.swing.JButton;
import java.awt.BorderLayout;


@SuppressWarnings("serial")
public class Frame extends JFrame implements Runnable {
	private Canvas canvas;
	private Graphics graphics;
	
	public Frame() {
		setTitle("Equalizer");
		setSize(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("button 1");
		toolBar.add(btnNewButton);
		
		canvas = new Canvas();
		add(canvas);
	
		setVisible(true);
		this.setLocationRelativeTo(null);
		
		canvas.createBufferStrategy(3);
		new Thread(this).start();
	}
	
	public void run(){
		int i = 0;
		while(true){
	        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
	        graphics = bufferStrategy.getDrawGraphics();
	        graphics.clearRect(0, 20, getWidth(), getHeight());

	        graphics.setColor(Color.BLACK);
	        graphics.drawString("Updates: " + i++, getHeight()/2, getWidth()/2);

	        bufferStrategy.show();
	        graphics.dispose();
		}
	}

	
	
}
