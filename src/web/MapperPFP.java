package web;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import api.MapInfo;

public class MapperPFP {
	
	public ImageIcon pfp = new ImageIcon();
	
	
	public void addPFP() throws IOException {
		
		MapInfo info = new MapInfo();
		
		
		String link = "https://a.ppy.sh/" + info.getMapperID() + "?.jpeg";
		URL url = new URL(link);
		pfp.setImage(ImageIO.read(url));
		
		Image scaler = pfp.getImage();
		Image newscaler = scaler.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		
		pfp = new ImageIcon(newscaler);
		
	
		
	}
	
	public ImageIcon getMapperPFP(){
		
		return pfp;
		
	}

}
