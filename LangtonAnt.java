import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class LangtonAnt extends JFrame
{
	private BufferedImage image;
	private JPanel panel;
	private int antCoordX, antCoordY, antDirection;
	
	public LangtonAnt(String title)
	{
		super(title);
		panel = new JPanel();
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
		antDirection = 1;
		panel.setBackground(Color.lightGray);
		this.setBounds(0,0,800,600);
		antCoordX = this.getWidth()/2;
		antCoordY = this.getHeight()/2;
		
		this.add(panel);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.update(this.getGraphics());
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(image, 0, 0, null);
	}
	
	public void go()
	{	
		while(true)
		{
			assert (antDirection < 5) && (antDirection > 0);
			if(((antCoordX < this.getWidth()) && (antCoordX >= 0)) && ((antCoordY < this.getHeight()) && (antCoordY >= 0)))
			{
				step();
				update(this.getGraphics());
			}
			else
			{
				break;
			}
		}
	}
	
	
	public void step()
	{
		if(antDirection == 1)
		{
			if(image.getRGB(antCoordX, antCoordY) == Color.white.getRGB())
			{
				image.setRGB(antCoordX, antCoordY, Color.black.getRGB());
				antDirection = 2;
				antCoordX += 1;
			}
			else if(image.getRGB(antCoordX, antCoordY) == Color.black.getRGB())
			{
				image.setRGB(antCoordX, antCoordY, Color.white.getRGB());
				antDirection = 4;
				antCoordX -= 1;
			}
		}
		if(antDirection == 3)
		{
			if(image.getRGB(antCoordX, antCoordY) == Color.white.getRGB())
			{
				image.setRGB(antCoordX, antCoordY, Color.black.getRGB());
				antDirection = 4;
				antCoordX -= 1;
			}
			else if(image.getRGB(antCoordX, antCoordY) == Color.black.getRGB())
			{
				image.setRGB(antCoordX, antCoordY, Color.white.getRGB());
				antDirection = 2;
				antCoordX += 1;
			}
		}
		else if(antDirection == 2)
		{
			if(image.getRGB(antCoordX, antCoordY) == Color.white.getRGB()) 
			{
				image.setRGB(antCoordX, antCoordY, Color.black.getRGB());
				antDirection = 3;
				antCoordY += 1;
			}
			else if(image.getRGB(antCoordX, antCoordY) == Color.black.getRGB())
			{
				image.setRGB(antCoordX, antCoordY, Color.white.getRGB());
				antDirection = 1;
				antCoordY -= 1;
			}
		}
		else if(antDirection == 4)
		{
			if(image.getRGB(antCoordX, antCoordY) == Color.white.getRGB()) 
			{
				image.setRGB(antCoordX, antCoordY, Color.black.getRGB());
				antDirection = 1;
				antCoordY -= 1;
			}
			else if(image.getRGB(antCoordX, antCoordY) == Color.black.getRGB())
			{
				image.setRGB(antCoordX, antCoordY, Color.white.getRGB());
				antDirection = 3;
				antCoordY += 1;
			}
		}
	}
	
	public static void main(String[] args)
	{
		LangtonAnt ant= new LangtonAnt("Langton's Ant");
		ant.go();
	}
}