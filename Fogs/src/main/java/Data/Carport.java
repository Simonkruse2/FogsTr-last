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
    
    
}
