package main;

public class Planet extends SpaceObject{

    public Planet(String name, double R, double Theta, double Phi, double velocityR, double velocityTheta, double velocityPhi) {
        super(name, R, Theta, Phi);
    }

    public Planet(String name, double R, double Theta, double Phi) {
        super(name, R, Theta, Phi);
    }
    @Override public void updatePosition(double deltaT)
    {
        super.setR(super.getR() + super.getrVelocity()*deltaT);
        super.setTheta(super.getTheta() + super.getThetaVelocity()*deltaT);
        super.setPhi(super.getPhi() + super.getPhiVelocity()*deltaT);
    }

}
