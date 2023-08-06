
public class SpaceObject {
    private double r = 0;
    private double theta = 0;
    private double phi = Math.PI;

    public String Name;

    public SpaceObject(String name, double R, double Theta, double Phi)
    {
        Name = name;
        setR(R);
        setTheta(Theta);
        setPhi(Phi);
    }
    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        if (mass < 0)
        {
            System.out.println("Mass needs to be positive. Value not set for " + Name + ".");
            return;
        }
        this.mass = mass;
    }

    private double mass;
    public double getR() {
        return r;
    }

    public void setR(double r) {
        if (r < 0)
        {
            System.out.println("R needs to be positive. Value not set for " + Name + ".");
            return;
        }
        this.r = r;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        if( theta < 0 || theta >= 2 * Math.PI)
        {
            System.out.println("Theta needs to be in the range (0, 2 pi). Value not set for " + Name + ".");
            return;
        }
        this.theta = theta;
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        if( phi < 0 || phi >=  Math.PI)
        {
            System.out.println("Phi needs to be in the range (0, pi). Value not set for " + Name + ".");
            return;
        }
        this.phi = phi;
    }

}