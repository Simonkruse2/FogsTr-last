/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author simon
 */
public class Carport {
    private boolean roof; // Whether the carport has a roof or not - tag
    private boolean shed; // Whether the carport has a shed or not - skur
    private int lengthOuter; // In cm
    private final int lengthInner = lengthOuter - 130; // 100 cm from the front and 30 cm from the back
    private int widthOuter; // In cm
    private final int widthInner = widthOuter - 70; // 35 cm from the sides of the carport x 2
    private int screws; // Number of screws - skruer
    private int screwBoxes; // Number of screwboxes - kasser med skruer
    private int rafts; // Number of rafts - spær
    private int beams; // Number of beams - bjælke
    private int postSpacing; // Spacing between the posts; - stolpe
    private int tHinges; // t shaped hinges - hængsel
    private int doorFittings; // number of door fittings - beslag 
    private int rooftiles; // number of rooftiles - tagbeklædning
    private int plastmoShort; // Short plastic roof - Plastik tagbeklædning
    private int plastmoLong; // Long plastic Roof - Plastik tagbeklædning
    private int shedlength;
    private int shedwidth;

    public void setShedlength(int shedlength) {
        this.shedlength = shedlength;
    }

    public void setShedwidth(int shedwidth) {
        this.shedwidth = shedwidth;
    }

    public int getShedlength() {
        return shedlength;
    }

    public int getShedwidth() {
        return shedwidth;
    }

    public Carport(boolean roof, boolean shed, int lengthOuter, int widthOuter) {
        this.roof = roof;
        this.shed = shed;
        this.lengthOuter = lengthOuter;
        this.widthOuter = widthOuter;
    }

    public boolean isRoof() {
        return roof;
    }

    public void setRoof(boolean roof) {
        this.roof = roof;
    }

    public boolean isShed() {
        return shed;
    }

    public void setShed(boolean shed) {
        this.shed = shed;
    }

    public int getLengthOuter() {
        return lengthOuter;
    }

    public void setLengthOuter(int lengthOuter) {
        this.lengthOuter = lengthOuter;
    }

    public int getWidthOuter() {
        return widthOuter;
    }

    public void setWidthOuter(int widthOuter) {
        this.widthOuter = widthOuter;
    }

    public int getScrews() {
        return screws;
    }

    public void setScrews(int screws) {
        this.screws = screws;
    }

    public int getScrewBoxes() {
        return screwBoxes;
    }

    public void setScrewBoxes(int screwBoxes) {
        this.screwBoxes = screwBoxes;
    }

    public int getRafts() {
        return rafts;
    }

    public void setRafts(int rafts) {
        this.rafts = rafts;
    }

    public int getBeams() {
        return beams;
    }

    public void setBeams(int beams) {
        this.beams = beams;
    }

    public int getPostSpacing() {
        return postSpacing;
    }

    public void setPostSpacing(int postSpacing) {
        this.postSpacing = postSpacing;
    }

    public int gettHinges() {
        return tHinges;
    }

    public void settHinges(int tHinges) {
        this.tHinges = tHinges;
    }

    public int getDoorFittings() {
        return doorFittings;
    }

    public void setDoorFittings(int doorFittings) {
        this.doorFittings = doorFittings;
    }

    public int getRooftiles() {
        return rooftiles;
    }

    public void setRooftiles(int rooftiles) {
        this.rooftiles = rooftiles;
    }

    public int getPlastmoShort() {
        return plastmoShort;
    }

    public void setPlastmoShort(int plastmoShort) {
        this.plastmoShort = plastmoShort;
    }

    public int getPlastmoLong() {
        return plastmoLong;
    }

    public void setPlastmoLong(int plastmoLong) {
        this.plastmoLong = plastmoLong;
    }

    @Override
 FogUnitTest2
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.roof ? 1 : 0);
        hash = 97 * hash + (this.shed ? 1 : 0);
        hash = 97 * hash + this.lengthOuter;
        hash = 97 * hash + this.lengthInner;
        hash = 97 * hash + this.widthOuter;
        hash = 97 * hash + this.widthInner;
        hash = 97 * hash + this.screws;
        hash = 97 * hash + this.screwBoxes;
        hash = 97 * hash + this.rafts;
        hash = 97 * hash + this.beams;
        hash = 97 * hash + this.postSpacing;
        hash = 97 * hash + this.tHinges;
        hash = 97 * hash + this.doorFittings;
        hash = 97 * hash + this.rooftiles;
        hash = 97 * hash + this.plastmoShort;
        hash = 97 * hash + this.plastmoLong;
        hash = 97 * hash + this.shedlength;
        hash = 97 * hash + this.shedwidth;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carport other = (Carport) obj;
        if (this.roof != other.roof) {
            return false;
        }
        if (this.shed != other.shed) {
            return false;
        }
        if (this.lengthOuter != other.lengthOuter) {
            return false;
        }
        if (this.lengthInner != other.lengthInner) {
            return false;
        }
        if (this.widthOuter != other.widthOuter) {
            return false;
        }
        if (this.widthInner != other.widthInner) {
            return false;
        }
        if (this.screws != other.screws) {
            return false;
        }
        if (this.screwBoxes != other.screwBoxes) {
            return false;
        }
        if (this.rafts != other.rafts) {
            return false;
        }
        if (this.beams != other.beams) {
            return false;
        }
        if (this.postSpacing != other.postSpacing) {
            return false;
        }
        if (this.tHinges != other.tHinges) {
            return false;
        }
        if (this.doorFittings != other.doorFittings) {
            return false;
        }
        if (this.rooftiles != other.rooftiles) {
            return false;
        }
        if (this.plastmoShort != other.plastmoShort) {
            return false;
        }
        if (this.plastmoLong != other.plastmoLong) {
            return false;
        }
        if (this.shedlength != other.shedlength) {
            return false;
        }
        if (this.shedwidth != other.shedwidth) {
            return false;
        }
        return true;
=======
    public String toString() {
        return "Carport{" + "roof=" + roof + ", shed=" + shed + ", lengthOuter=" + lengthOuter + ", lengthInner=" + lengthInner + ", widthOuter=" + widthOuter + ", widthInner=" + widthInner + ", screws=" + screws + ", screwBoxes=" + screwBoxes + ", rafts=" + rafts + ", beams=" + beams + ", postSpacing=" + postSpacing + ", tHinges=" + tHinges + ", doorFittings=" + doorFittings + ", rooftiles=" + rooftiles + ", plastmoShort=" + plastmoShort + ", plastmoLong=" + plastmoLong + ", shedlength=" + shedlength + ", shedwidth=" + shedwidth + '}';
 master
    }
    
    
}
