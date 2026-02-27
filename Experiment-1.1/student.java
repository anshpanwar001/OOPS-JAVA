
public class student {

	int uid;
	String name;
	String course;
	int marks;
	
	student(int u , String n , String c , int m){
		this.uid = u;
		this.name = n;
		this.course = c;
		this.marks = m;
	}
	
	void display() {
		System.out.println(uid);
		System.out.println(name);
		System.out.println(course);
		System.out.println(marks);
		
	}

	public static void main(String[] args) {
		
		student s1 = new student(101,"Ansh","CSE",80);
		s1.display();
		
	}

}
