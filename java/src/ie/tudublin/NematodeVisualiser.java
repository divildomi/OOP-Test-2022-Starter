package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet {

	ArrayList<Nematode> nematode = new ArrayList<Nematode>();

	int index = 0;

	public void keyPressed() {
		if (keyCode == LEFT) {
			index -= 1;
			if (index == -1) {
				index = 12;
			}
		}

		if (keyCode == RIGHT) {
			index += 1;
			if (index == 13) {
				index = 0;
			}
		}
	}

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		loadNematodes();
		printNematodes();
		colorMode(HSB);
		background(0);
		smooth();

	}

	public void printNematodes() {
		for (Nematode n : nematode) {
			System.out.println(n);
		}
	}

	public void loadNematodes() {
		Table table = loadTable("nematodes.csv", "header");
		for (TableRow r : table.rows()) {
			Nematode n = new Nematode(r);
			nematode.add(n);
		}
	}

	public void drawNematodes() {
		nematode.get(index).render(this);
	}

	public void draw() {
		background(0);
		drawNematodes();
	}
}
