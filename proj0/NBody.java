public class NBody {
	/* from here the code follow the need of the instruction*/
	public static String imgBackGround="./images/starfield.jpg";
	public static int readNum(String file_path){
		In in = new In(file_path);
		int num = (int)in.readDouble();
		return num;
	}
	public static  double readRadius(String file_path){
		In in =new In(file_path);
		double temp= in.readDouble();
		double radius=in.readDouble();
		return radius;
	}
	public  static Planet[] readPlanets(String file_path){
		In in = new In(file_path);
		int num=(int) in.readDouble();
		double radius=in.readDouble();
		Planet [] planetList=new Planet[num];
		for(int i=0; i<num; i++){
			double xxPos=in.readDouble();
			double yyPos=in.readDouble();
			double xxVel=in.readDouble();
			double yyVel=in.readDouble();
			double mass=in.readDouble();
			String imgFileName=in.readString();
			planetList[i]=new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
			System.out.println(imgFileName);
		}
		return planetList;
	}
	
	public static void printResult(Planet[] pList, double radius){
		StdOut.printf("%d\n", pList.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < pList.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
   			pList[i].xxPos, pList[i].yyPos, pList[i].xxVel, pList[i].yyVel, pList[i].mass, pList[i].imgFileName);	
		}		

	}
	public static void main(String[] args){
		double T=Double.valueOf(args[0]);
		double dt=Double.valueOf(args[1]);
		String planetDataPath="./data/planets.txt";
		int num= readNum(planetDataPath);
		double radius=readRadius(planetDataPath);
		StdDraw.setScale(-radius,radius);
		Planet[] planetList = readPlanets(planetDataPath);
		double[] xForce= new double[num];
		double[] yForce=new double[num];
		for(double t=0;t<T;t=t+dt){
			int i=0;
			for(Planet p: planetList){
				xForce[i]=p.calcNetForceExertedByX(planetList);
				yForce[i]=p.calcNetForceExertedByY(planetList);
				i++;
			}
			i=0;
			for(Planet p: planetList){
				p.update(dt,xForce[i],yForce[i]);
				i++;
			}
			StdDraw.clear();
			StdDraw.picture(0, 0, imgBackGround);
			for(Planet p: planetList){
				p.draw();
			}
			StdDraw.show(10);
		}
		printResult(planetList,radius);



	}

}
