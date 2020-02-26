/*
 * Created by: Romy I. Chu III
 * Created on: 26-Feb-2020
 * Created for: ICS4U
 * Day #14 (Planet Enumeration)
 * This program ... Uses enumerations to save the position and name of the planets.
*/

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JList;

public class PlanetEnumeration extends JFrame {

	private JPanel contentPane;
	public static boolean clickDown = false; 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanetEnumeration frame = new PlanetEnumeration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	@SuppressWarnings("deprecation")
	public PlanetEnumeration() {
		setTitle("Planet Enumeration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 298, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String data[] = {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune","Pluto"};
		JList list = new JList(data);
		list.setBounds(10, 31, 262, 170);
		contentPane.add(list);	
		
		ListSelectionListener listener = new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				//This if else statement prevents the program from sending an output twice.
				//This happens because mouse click up and down are considered 2 different actions.
				if (!clickDown) {
					int getPlanet = list.getSelectedIndex();
					PlanetEnum planet;
					if(getPlanet == 0) {
						planet = new PlanetEnum (Planets.MERCURY);
						planet.displayPlanet();
					}else if(getPlanet == 1) {
						planet = new PlanetEnum (Planets.VENUS);
						planet.displayPlanet();
					}else if(getPlanet == 2) {
						planet = new PlanetEnum (Planets.EARTH);
						planet.displayPlanet();
					}else if(getPlanet == 3) {
						planet = new PlanetEnum (Planets.MARS);
						planet.displayPlanet();
					}else if(getPlanet == 4) {
						planet = new PlanetEnum (Planets.JUPITER);
						planet.displayPlanet();
					}else if(getPlanet == 5) {
						planet = new PlanetEnum (Planets.SATURN);
						planet.displayPlanet();
					}else if(getPlanet == 6) {
						planet = new PlanetEnum (Planets.URANUS);
						planet.displayPlanet();
					}else if(getPlanet == 7) {
						planet = new PlanetEnum (Planets.NEPTUNE);
						planet.displayPlanet();
					}else if(getPlanet == 8) {
						planet = new PlanetEnum (Planets.PLUTO);
						planet.displayPlanet();
					}
					clickDown = true;
				} else {
					clickDown = false;
				}
			}
		};
		
		
		JLabel lblClickOnThe = new JLabel("Click on the planet that you want to go to :");
		lblClickOnThe.setBounds(10, 11, 262, 14);
		contentPane.add(lblClickOnThe);
			
		list.addListSelectionListener(listener);
		
	}
	
	//create the enumeration
	public enum Planets {
		MERCURY,
		VENUS,
		EARTH,
		MARS,
		JUPITER,
		SATURN,
		URANUS,
		NEPTUNE,
		PLUTO
	}
	
	//This creates a class for the enum (enumeration class?)
	public class PlanetEnum {
		//Creates the enum object.
		Planets planet;
		
		//Retrieves the planets when this class is created. 
		public PlanetEnum (Planets planet){
			this.planet = planet;
		}
		
		public void displayPlanet() {
			//This switch-case will change the output message depending on the selected planet.
			switch(planet) {
			case MERCURY:
				JOptionPane.showMessageDialog(null, "You would like to go to Mercury, planet " + "#" + (planet.ordinal() + 1));
				break;
			case VENUS:
				JOptionPane.showMessageDialog(null, "You would like to go to Venus, planet " + "#" + (planet.ordinal() + 1));
				break;
			case EARTH:
				JOptionPane.showMessageDialog(null, "You would like to stay on Earth");
				break;
			case MARS:
				JOptionPane.showMessageDialog(null, "You would like to go to Mars, planet " + "#" + (planet.ordinal() + 1));
				break;
			case JUPITER:
				JOptionPane.showMessageDialog(null, "You would like to go to Jupiter, planet " + "#" + (planet.ordinal() + 1));
				break;
			case SATURN:
				JOptionPane.showMessageDialog(null, "You would like to go to Saturn, planet " + "#" + (planet.ordinal() + 1));
				break;
			case URANUS:
				JOptionPane.showMessageDialog(null, "You would like to go to Uranus, planet " + "#" + (planet.ordinal() + 1));
				break;
			case NEPTUNE:
				JOptionPane.showMessageDialog(null, "You would like to go to Neptune, planet " + "#" + (planet.ordinal() + 1));
				break;
			case PLUTO:
				JOptionPane.showMessageDialog(null, "You would like to go to Neptune, planet " +  "#" + (planet.ordinal() + 1));
			}
		}
	}
}

