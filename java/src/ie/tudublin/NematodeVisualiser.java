package ie.tudublin;

import java.lang.reflect.Array;
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
		drawArrow(600, 400, 40, 0);
		drawArrow(200, 400, 40, 180);

		strokeWeight(0);
		background(0);
		drawNematodes();

	}

	void drawArrow(int cx, int cy, int len, float angle) {
		strokeWeight(50);
		pushMatrix();
		translate(cx, cy);
		rotate(radians(angle));
		line(0, 0, len, 0);
		line(len, 0, len - 8, -8);
		line(len, 0, len - 8, 8);
		popMatrix();
	}

}
