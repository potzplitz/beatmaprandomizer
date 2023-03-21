package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import api.MapInfo;
import api.UserInfo;
import api.UserMaps;
import arrays.Gamemode;
import arrays.Genres;
import arrays.Languages;
import javafx.application.Application;
import randomizer.IDRandomizer;
import web.MapBanner;
import web.MapperPFP;



	@SuppressWarnings("serial")
	class Frame extends JFrame{
	
		
		// Gui constructor
		
	Frame(String title) {
	    super(title);
	    
	    setSize(500, 500);
	    setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
	    setResizable(false);
	    setLayout(null);

	  }
	
}
	
	
	public class Gui {	
		
		@SuppressWarnings("unused")
		private static MapInfo mapInfo;
		
		public String id;
		
		
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws IOException {
		
		
		
		mapInfo = new MapInfo();
		
		
		
		JLabel mapname = new JLabel();
		mapname.setBounds(40, 23, 480, 30);
		
		
		Frame gui = new Frame("Beatmap Randomizer");
		gui.setVisible(true);
		
		JLabel mapcard = new JLabel();
		
		JLabel mapperpfp = new JLabel();
		mapperpfp.setBounds(230, 30, 50, 50);
		
		JTextField output = new JTextField();
	    output.setBounds(145, 197, 200, 30);
	    
	    JPanel info = new JPanel();
	    info.setBounds(0, 300, 500, 200);
	    info.setLayout(null);
	    info.setBackground(Color.LIGHT_GRAY);
	    
	    JLabel mapperinfolabel = new JLabel("Mapper Information");
	    mapperinfolabel.setBounds(230, 290, 200, 30);
	    
	    JLabel title = new JLabel();
	    title.setBounds(10, 290, 100, 30);
	    title.setText("Map Information");
	    
	    JLabel genrelabel = new JLabel("Genre: ");
	    genrelabel.setBounds(10, 31, 250, 30);
	    
	    JLabel languagelabel = new JLabel("Language: ");
	    languagelabel.setBounds(10, 50, 250, 30);
	    
	    JLabel playlabel = new JLabel("Plays: ");
	    playlabel.setBounds(10, 70, 250, 30);
	    
	    JLabel likelabel = new JLabel("Likes: ");
	    likelabel.setBounds(10, 90, 250, 30);
	    
	    JLabel mapperlabel = new JLabel();
	    mapperlabel.setBounds(285, 30, 200, 30);
	    
	    JLabel ranklabel = new JLabel();
	    ranklabel.setBounds(285, 50, 200, 30);
	    
	    JProgressBar rating = new JProgressBar(0, 10);
	    rating.setBounds(10, 140, 200, 10);
	    
	    JLabel ratinglabel = new JLabel("Rating");
	    ratinglabel.setBounds(10, 116, 200, 30);
	    
	    JLabel ratinglabeling = new JLabel("1                                                           10");
	    ratinglabeling.setBounds(10, 140, 200, 30);
	    
	    JLabel gm = new JLabel("Gamemode: ");
	    gm.setBounds(10, 11, 200, 30);
	    
	    Button browser = new Button("browser");
	    browser.setBounds(343, 197, 50, 15);
	    
	    Button direct = new Button("direct");
	    direct.setBounds(343, 212, 50, 15);
	    
	   
	    
	    MapInfo run = new MapInfo();
	    
	    Desktop desktop = Desktop.getDesktop();
	  
		Button randomize = new Button("randomize");
	    randomize.setBounds(187, 240, 100, 30);
	    randomize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				randomize.setLabel("loading...");
				
				IDRandomizer randomizer = new IDRandomizer();
				
				randomizer.Random();
				
				
				UserInfo user = new UserInfo();
				UserMaps maps = new UserMaps();
				
				
				
				
				
				try {run.getApi();} catch (IOException e5) {e5.printStackTrace();  } 
				randomize.setLabel("loading...");
				randomize.setLabel("error");
				try {user.PlayerInfo();} catch (IOException e5) {e5.printStackTrace();}
				
				
				
				randomize.setLabel("loading...");
				randomize.setLabel("error");
				try {run.BeatmapInfo();} catch (IllegalStateException | IOException e4) {e4.printStackTrace();}
				randomize.setLabel("loading...");
		
				String mapid = run.getMapID();

				MapBanner banner = new MapBanner();
				try {	banner.addImage();} catch (IOException e3) {e3.printStackTrace();}
				
				mapcard.setIcon(banner.getBannerImage());
						
						output.setText("https://osu.ppy.sh/beatmapsets/" + mapid);
						
						try {	mapname.setText(run.getName());} catch (IllegalStateException | IOException e1) {e1.printStackTrace();}		
						
						MapperPFP pfp = new MapperPFP();
						try {pfp.addPFP();} catch (IOException e2) {e2.printStackTrace();}
						
						
						
						Genres genres = new Genres();
						genres.addList();
						
						Languages languages = new Languages();
						languages.addLanguages();
						
						Gamemode mode = new Gamemode();
						mode.addList();
						
						mapperpfp.setIcon(pfp.getMapperPFP());
						
						
						
						
						 
						
						
						try { genrelabel.setText("Genre:               " + genres.genres.get(Integer.parseInt(run.getGenre()))); } catch (NumberFormatException | IllegalStateException | IOException e1) { e1.printStackTrace(); }
						try { languagelabel.setText("Language:        " + languages.languages.get(Integer.parseInt(run.getLanguage()))); } catch (NumberFormatException | IllegalStateException | IOException e1) { e1.printStackTrace(); }
						try { playlabel.setText("Plays:                " + run.getPlays()); } catch (NumberFormatException | IllegalStateException | IOException e1) { e1.printStackTrace(); }
						try { likelabel.setText("Likes:                " + run.getLikes()); } catch (NumberFormatException | IllegalStateException | IOException e1) { e1.printStackTrace(); }
						try { rating.setValue(Math.round(Float.parseFloat(run.getRating()))); } catch (NumberFormatException | IllegalStateException | IOException e1) { e1.printStackTrace(); }
						try { gm.setText("Gamemode:     " + mode.getGameMode().get(Integer.parseInt(run.getGameMode()))); } catch (NumberFormatException | IllegalStateException e1) { e1.printStackTrace(); } catch (IOException e1) { e1.printStackTrace();}
							
						
						try { mapperlabel.setText(run.getMapper());	} catch (IllegalStateException | IOException e1) {e1.printStackTrace();}
						try { ranklabel.setText("#" + user.getPlayerRank());	} catch (IllegalStateException | IOException e1) {e1.printStackTrace();}
						
						
						
						
								
						
						randomize.setLabel("Randomize");
						
						gui.repaint();
						mapname.repaint();
					
					
					
						gui.repaint();
						
					
						
			}
	    	
	    	
	    });
	    
	    browser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Desktop.getDesktop().browse(new URI("https://osu.ppy.sh/beatmapsets/" + run.getMapID()));
				} catch (IOException | URISyntaxException e1) {
					
					e1.printStackTrace();
				}
			}
			
		});
	    
	    direct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Desktop.getDesktop().browse(new URI("osu://b/4045797/" + run.getMapID()));
				} catch (IOException | URISyntaxException e1) {
					
					e1.printStackTrace();
				}
			}
			
		});
	    
	    
	    mapperpfp.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {desktop.browse(URI.create("https://osu.ppy.sh/users/" + run.getMapperID()));} catch (IOException e1) {e1.printStackTrace();}		
			}
			@Override
			public void mousePressed(MouseEvent e) {		
			}
			@Override
			public void mouseReleased(MouseEvent e) {		
			}
			@Override
			public void mouseEntered(MouseEvent e) {	
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
	    
	    
	    mapcard.setBounds(40, 50, 400, 140);
		mapcard.setVisible(true);
		mapname.setVisible(true);
		title.setVisible(true);
		info.setVisible(true);
		genrelabel.setVisible(true);
		languagelabel.setVisible(true);
		playlabel.setVisible(true);
		likelabel.setVisible(true);
		mapperpfp.setVisible(true);
		mapperinfolabel.setVisible(true);
		mapperlabel.setVisible(true);
		ranklabel.setVisible(true);
		rating.setVisible(true);
		ratinglabel.setVisible(true);
		ratinglabeling.setVisible(true);
		browser.setVisible(true);
		direct.setVisible(true); 
		gm.setVisible(true);
		
		gui.add(output);
		gui.add(mapcard);
		gui.add(mapname);
		gui.add(browser);
		gui.add(direct);
		gui.add(title);
		gui.add(mapperinfolabel);
		info.add(genrelabel);
		info.add(languagelabel);
		info.add(playlabel);
		info.add(likelabel);
		info.add(mapperpfp);
		info.add(mapperlabel);
		info.add(ranklabel);
		info.add(rating);
		info.add(ratinglabel);
		info.add(ratinglabeling);
		info.add(gm);
		
		gui.add(info);
		
		
	    
	    randomize.setVisible(true);
	    gui.add(randomize);
	    info.repaint();
	   
	    gui.repaint();
		
		}

	
	}


