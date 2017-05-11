public class NBody {
	/* from here the code follow the need of the instruction*/
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
		for(Planet p: planetList){
			p.xxPos=in.readDouble();
			p.yyPos=in.readDouble();
			p.xxVel=in.readDouble();
			p.yyVel=in.readDouble();
			p.mass=in.readDouble();
			p.imgFileName=in.readString();
			System.out.println(imgFileName);
		}
		return planetList;
	}

}
