public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet otherPlanet) {
        double dx = otherPlanet.xxPos - this.xxPos;
        double dy = otherPlanet.yyPos - this.yyPos;

        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet otherPlanet) {
        double r = this.calcDistance(otherPlanet);

        return G * this.mass * otherPlanet.mass / r / r;
    }

    public double calcForceExertedByX(Planet otherPlanet) {
        double dx = otherPlanet.xxPos - this.xxPos;
        double r = this.calcDistance(otherPlanet);
        double f = this.calcForceExertedBy(otherPlanet);

        return f * dx / r;
    }

    public double calcForceExertedByY(Planet otherPlanet) {
        double dy = otherPlanet.yyPos - this.yyPos;
        double r = this.calcDistance(otherPlanet);
        double f = this.calcForceExertedBy(otherPlanet);

        return f * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double fX = 0;
        for(Planet p : allPlanets) {
            if (this.equals(p)) continue;
            fX += this.calcForceExertedByX(p);
        }
        return fX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double fY = 0;
        for (Planet p : allPlanets) {
            if (this.equals(p)) continue;
            fY += this.calcForceExertedByY(p);
        }
        return fY;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += dt * aX;
        this.yyVel += dt * aY;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}
