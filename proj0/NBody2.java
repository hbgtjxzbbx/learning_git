public class NBody2 {
	public static void readfiles(String file_path){
		In in =new In(file_path);
		int num= (int)readNum(in);
		System.out.println(num);
		double radius=readRadius(in);
		System.out.println(radius);
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
	}
	public static double readNum(In in){
		double num= in.readDouble();
		return num;
	}
	public static double readRadius(In in){
		double radius=in.readDouble();
		return radius;
	}
	public static void main(String[] args){
		readfiles("/data/planets.txt");
	}

}
