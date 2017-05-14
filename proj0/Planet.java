public class Planet{
	public double xxPos, yyPos;
	public double xxVel,yyVel;
	public double mass;
	public String imgFileName;
	private static double G=6.67e-11;
	public Planet(double xP, double yP, double xV, double yV,double m,String img){
		this.xxPos=xP;
		this.yyPos=yP;
		this.xxVel=xV;
		this.yyVel=yV;
		this.mass=m;
		this.imgFileName=img;
	}
	public Planet(Planet p){
	    this.xxPos=p.xxPos;
		this.yyPos=p.yyPos;
		this.xxVel=p.xxVel;
		this.yyVel=p.yyVel;
		this.mass=p.mass;
		this.imgFileName=p.imgFileName;
	}
	public boolean equals (Planet p){
		if (this.xxPos==p.xxPos && this.yyPos==p.yyPos)
			return true;
		else
			return false;
	}
	public double calcDistance(Planet p){
		double dist,xDisPow,yDisPow;
		xDisPow=Math.pow(p.xxPos-this.xxPos,2);
		yDisPow=Math.pow(p.yyPos-this.yyPos,2);
		dist=Math.sqrt(xDisPow+yDisPow);
		return dist;
	}
	public double calcForceExertedBy(Planet p){
		double force;
		double dis= this.calcDistance(p);
		force=G*this.mass*p.mass/(dis*dis);
		return force;

	}
	public double calcForceExertedByX(Planet p){
		 double force= calcForceExertedBy(p);
		 double dx=p.xxPos-this.xxPos;
		 double dis=this.calcDistance(p);
		 return force*dx/dis;
	}
		public double calcForceExertedByY(Planet p){
		 double force= calcForceExertedBy(p);
		 double dy=p.yyPos-this.yyPos;
		 double dis=this.calcDistance(p);
		 return force*dy/dis;
	}
		public double calcNetForceExertedByX (Planet[] lp){
			int num = lp.length;
			double netX=0;
			for(int i=0; i<num;i++){
				if (this.equals(lp[i]))
					continue;
				netX+=this.calcForceExertedByX(lp[i]);}
			return netX;

		}
		public double calcNetForceExertedByY (Planet[] lp){
			int num = lp.length;
			double netY=0;
			for(int i=0; i<num;i++){
				if (this.equals(lp[i]))
					continue;
				netY+=this.calcForceExertedByY(lp[i]);}
			return netY;

		}
		public void update(double dt,double fX,double fY){
			this.xxVel=this.xxVel+fX/this.mass*dt;
			this.yyVel=this.yyVel+fY/this.mass*dt;
			this.xxPos=this.xxPos+this.xxVel*dt;
			this.yyPos=this.yyPos+this.yyVel*dt;

		}
		public void draw(){
			String imgPath="./images/"+this.imgFileName;
			StdDraw.picture(this.xxPos,yyPos,imgPath);

		}

}
