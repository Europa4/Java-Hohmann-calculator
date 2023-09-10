package main;
public class SpaceObject {
    private double r = 0;
    private double theta = 0;
    private double phi = 1.5707963267948966;//pi/2

    public String Name;

    static final private double G = 6.7E-11; //Newton's gravitational constant

    public SpaceObject(String name, double R, double Theta, double Phi)
    {
        this.Name = name;
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
        if( phi < 0 || phi >  Math.PI)
        {
            System.out.println("Phi needs to be in the range (0, pi). Value not set for " + Name + ".");
            return;
        }
        this.phi = phi;
    }

    //Square of the distance between this object and another
    public double distanceSquaredTo(SpaceObject otherObject){
        double thisCosTheta = Math.cos(this.getTheta());
        double thisSinTheta = Math.sin(this.getTheta());
        double thisCosPhi = Math.cos(this.getPhi());
        double thisSinPhi = Math.sin(this.getPhi());
        double otherCosTheta = Math.cos(otherObject.getTheta());
        double otherSinTheta = Math.sin(otherObject.getTheta());
        double otherCosPhi = Math.cos(otherObject.getPhi());
        double otherSinPhi = Math.sin(otherObject.getPhi());
        return getR()*getR() + otherObject.getR()*otherObject.getR() - 2*getR()*otherObject.getR()*(
                thisCosTheta*thisSinPhi*otherCosTheta*otherSinPhi + thisSinTheta*thisSinPhi*otherSinTheta*otherSinPhi
                + thisCosPhi*otherCosPhi); //This is basically the 3D cosine rule for the square distance
    }

    public java.lang.Double forceBetweenThisAnd(SpaceObject otherObject){
        double rSquared = distanceSquaredTo(otherObject);
        if(rSquared < 1E-6)
            {
                System.out.println("Attempted to calculate force between " + Name + " and " + otherObject.Name + ", but they were too close.");
                return null;
            }
        return -1.*G*getMass()*otherObject.getMass()/rSquared;
    }

}
