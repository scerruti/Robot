package org.jointheleague.graphical.robot;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.swing.JOptionPane;

public class RobotImage
{
	private static final int	IMG_WIDTH		= 100;
	private static final int	IMG_HEIGHT		= 100;
	private static final int	PIXEL_LENGTH	= 20; // in bytes

	public static BufferedImage loadDefaultRobi()
	{
		return loadRobi("rob");
	}

	public static BufferedImage loadRobi(String s)
	{
		s += ".robi";
		BufferedImage img = new BufferedImage(IMG_WIDTH, IMG_HEIGHT,
				BufferedImage.TYPE_INT_ARGB);

		try (InputStream is = RobotImage.class.getResourceAsStream(s))
		{
			byte[] buf = new byte[PIXEL_LENGTH * IMG_WIDTH];
			IntBuffer ibuf = ByteBuffer.wrap(buf).asIntBuffer();
			
			int len;
			while ((len = is.read(buf)) != -1)
			{
				for (int i = 0; i < len; i += PIXEL_LENGTH)
				{
					readPixel(img, ibuf, i / 4);
				}

			}

		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,
					"There was an error loading your file.");
			System.out.println("RobotImage: loadRobi\n" + e.getMessage());
			img = loadDefaultRobi();
		}
		return img;
	}

	private static void readPixel(BufferedImage img, IntBuffer ibuf, int pos)
	{
		int x = ibuf.get(pos++);
		int y = ibuf.get(pos++);
		
		// Next 3 ints are the r, g, b components of the color
		int rgb = 0;
		for (int i = 0; i < 3; i++)
		{
			rgb = rgb << 8 | ibuf.get(pos++) & 0xff;
		}
		// The color 0xdcdcdc is chosen to encode transparency
		if (rgb != 0xdcdcdc)
		{
			rgb |= 0xff000000;
		}

		img.setRGB(x, y, rgb);
	}

}
