package main;

public class Planet extends SpaceObject{
    double velocityR;
    double velocityTheta;
    double velocityPhi;

    public Planet(String name, double R, double Theta, double Phi, double velocityR, double velocityTheta, double velocityPhi) {
        super(name, R, Theta, Phi);
        this.velocityR = velocityR;
        this.velocityTheta = velocityTheta;
        this.velocityPhi = velocityPhi;
    }
}
