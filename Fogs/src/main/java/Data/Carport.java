package Data;

/**
 *
 * @author Jacob, Renz, Vincent og Simon.
 */
public class Carport {

    private boolean roof; // Whether the carport has a roof or not - tag
    private boolean shed; // Whether the carport has a shed or not - skur
    private int lengthOuter; // In cm
    private int widthOuter; // In cm
    private int shedlength;
    private int shedwidth;

    /**
     * /**
     * below is a constructor for building a carport. the constructor only
     * contains 4 parameter.
     *
     * @param roof
     * @param shed
     * @param lengthOuter
     * @param widthOuter
     */
    public Carport(boolean roof, boolean shed, int lengthOuter, int widthOuter) {
        this.roof = roof;
        this.shed = shed;
        this.lengthOuter = lengthOuter;
        this.widthOuter = widthOuter;
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

    public int getShedlength() {
        return shedlength;
    }

    public void setShedlength(int shedlength) {
        this.shedlength = shedlength;
    }

    public int getShedwidth() {
        return shedwidth;
    }

    public void setShedwidth(int shedwidth) {
        this.shedwidth = shedwidth;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.roof ? 1 : 0);
        hash = 41 * hash + (this.shed ? 1 : 0);
        hash = 41 * hash + this.lengthOuter;
        hash = 41 * hash + this.widthOuter;
        hash = 41 * hash + this.shedlength;
        hash = 41 * hash + this.shedwidth;
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
        if (this.widthOuter != other.widthOuter) {
            return false;
        }
        if (this.shedlength != other.shedlength) {
            return false;
        }
        if (this.shedwidth != other.shedwidth) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carport{" + "roof=" + roof + ", shed=" + shed + ", lengthOuter=" + lengthOuter + ", widthOuter=" + widthOuter + ", shedlength=" + shedlength + ", shedwidth=" + shedwidth + '}';
    }

}
