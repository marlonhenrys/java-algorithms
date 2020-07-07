package ex3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
class AreaDeDesenho extends JComponent {
	BufferedImage img;
	Random r = new Random();
	List<Bolinha> bolinhas = new ArrayList<Bolinha>();
	int x1, x2, y1, y2;

	public AreaDeDesenho() {
		img = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
		Graphics2D ig2 = img.createGraphics();
		ig2.setBackground(Color.WHITE);
		ig2.clearRect(0, 0, img.getWidth(), img.getHeight());

		this.setSize(200, 200);
		this.setPreferredSize(new Dimension(200, 200));

		this.setBackground(Color.WHITE);
		this.setOpaque(true);

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				Graphics g = img.getGraphics();
				g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
				g.fillOval(x - 5, y - 5, 10, 10);
				bolinhas.add(new Bolinha(x, y));
				g.dispose();
				repaint();
			}

		});

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				for (Bolinha bolinha : bolinhas) {
					if ((e.getX() >= bolinha.getX() - 5 && e.getX() <= bolinha.getX() + 5)
							&& (e.getY() >= bolinha.getY() - 5 && e.getY() <= bolinha.getY() + 5)) {
						x1 = bolinha.getX();
						y1 = bolinha.getY();
					}
				}
			}

		});

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				for (Bolinha bolinha : bolinhas) {
					if ((e.getX() >= bolinha.getX() - 5 && e.getX() <= bolinha.getX() + 5)
							&& (e.getY() >= bolinha.getY() - 5 && e.getY() <= bolinha.getY() + 5)) {
						x2 = bolinha.getX();
						y2 = bolinha.getY();

						if (x1 != x2 && y1 != y2) {
							Graphics g = img.getGraphics();
							g.setColor(Color.BLACK);
							g.drawLine(x1, y1, x2, y2);
							g.dispose();
							repaint();
						}
					}
				}
			}
		});

	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}

@SuppressWarnings("serial")
public class AplicacaoCanvas extends JFrame {
	private JButton close = new JButton("Close");
	private AreaDeDesenho ades = new AreaDeDesenho();

	public AplicacaoCanvas() {
		super("Caixa de desenho");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());
		this.getContentPane().add(close, BorderLayout.SOUTH);
		this.getContentPane().add(ades, BorderLayout.CENTER);

		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		pack();
	}

	public static void main(String args[]) {
		new AplicacaoCanvas().setVisible(true);
	}
}

class Bolinha {
	int x, y;

	public Bolinha(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}