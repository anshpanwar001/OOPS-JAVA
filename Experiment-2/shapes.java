
class square{
    
    int side;
    
    square(int s){
        this.side = s;
    }
    
    void area(){
        System.out.print("Area of Square : ");
        System.out.println(side*side);
    }
};

class rectangle{
    
    int length;
    int breadth;
    
    rectangle(int l , int b){
        this.length = l;
        this.breadth = b;
    }
    
    void area(int l , int b){
        System.out.print("Area of rectangle : ");
        System.out.print(l*b);
    }
    
};

public class shapes {

	public static void main(String[] args) {
		square s = new square(10);
		s.area();
		rectangle r = new rectangle(10,20);
		r.area(10,20);
	}

};
