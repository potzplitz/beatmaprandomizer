package web;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import api.MapInfo;

public class MapBanner {
	
	public ImageIcon mapbanner = new ImageIcon();
	
	public void addImage() throws IOException {
		
		MapInfo info = new MapInfo();
		String link = "https://assets.ppy.sh/beatmaps/" + info.getMapID() + "/covers/card.jpg";
		URL url = new URL(link);
		mapbanner.setImage(ImageIO.read(url));
	}
	
	public ImageIcon getBannerImage() {
		
		return mapbanner;
		
	}

}
