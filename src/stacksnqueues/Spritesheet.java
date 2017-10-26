package stacksnqueues;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Spritesheet {
	public Map<String, Image[]> anims;
	private BufferedImage sheet;
	private int xSize;
	private int ySize;
	private int xGutter;
	private int yGutter;
	public Spritesheet (String fileName, int xs, int ys, int xg, int yg) {
		try {
			sheet = ImageIO.read(getClass().getResource(fileName));
			xSize = xs;
			ySize = ys;
			anims = new HashMap<String, Image[]>();
			xGutter = xg;
			yGutter =  yg;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void prepAnim(String name, int xStart, int yStart, int num) {
		Image[] frames = new Image[num];
		for(int i = 0; i < frames.length; i++) {
			frames[i] = sheet.getSubimage(
					calcXStart(xStart, i),
					calcYStart(yStart),
					xSize,
					ySize);
		}
		anims.put(name, frames);
	}
	private int calcXStart (int xStart, int i) {
		return xGutter + (xStart + i) * (xSize + xGutter);
	}
	private int calcYStart (int yStart) {
		return yGutter + yStart * (ySize + yGutter);
	}
	public Image[] getAnim(String name) {
		return anims.get(name);
	}
}
