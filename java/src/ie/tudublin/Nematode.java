package ie.tudublin;

import java.util.Arrays;
import processing.data.TableRow;
import processing.core.PApplet;

public class Nematode {

    private String name;
    private float length;
    private boolean limbs;
    private String gender;
    private boolean eyes;

    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }

    public Nematode(TableRow tr) {
        this(
                tr.getString("name"),
                tr.getFloat("length"),
                tr.getInt("limbs") == 1,
                tr.getString("gender"),
                tr.getInt("eyes") == 1);
    }

    public Nematode(String name, float length, boolean limbs, String gender, boolean eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public boolean isLimbs() {
        return limbs;
    }

    public void setLimbs(boolean limbs) {
        this.limbs = limbs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isEyes() {
        return eyes;
    }

    public void setEyes(boolean eyes) {
        this.eyes = eyes;
    }

    float temp;

    public void render(NematodeVisualiser pa) {

        float y = pa.height / 2;
        float x = pa.width / 2;

        // Displays name of nematode
        pa.text(name, x, y - 100);
        pa.textAlign(pa.CENTER, pa.CENTER);
        pa.textSize(20);

        pa.stroke(255);
        pa.noFill();

        // Makes the body of the worm
        for (int i = 0; i < length; i++) {
            temp = y + (i * 40);
            pa.circle(x, temp, 40);
            // Make limbs
            if (isLimbs()) {
                pa.line(x + 40, temp, x + 20, temp);
                pa.line(x - 40, temp, x - 20, temp);
            }
        }

        // Make tail for male
        if (gender.contains("m")) {
            pa.line(x, temp + 20, x, temp + 40);
            pa.circle(x, temp + 44, 5);
        }

        // Make circle for female
        if (gender.contains("f")) {
            pa.circle(x, temp, 20);
        }

        // Make both circle and tail
        if (gender.contains("h")) {
            pa.line(x, temp + 20, x, temp + 40);
            pa.circle(x, temp + 44, 5);
            pa.circle(x, temp, 20);
        }

        // Make eyes
        if (isEyes()) {
            pa.line(x - 15, y - 15, x - 30, y - 30);
            pa.line(x + 15, y - 15, x + 30, y - 30);
            pa.circle(x - 32, y - 32, 5);
            pa.circle(x + 32, y - 32, 5);
        }

    }
}
