package GraphicsTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.Iterator;
import GraphicsTest.ShapeItem;

public class Drawing extends Canvas {
    public static void main(String[] args) {
    	
    	// ref
    	//ShapeItem shapeitem = new ShapeItem(new Rectangle2D.Double(110, 1, 100, 100),
        //       DEFAULT_COLOR);
    	
        JFrame frame = new JFrame("My Drawing");
        Drawing canvas = new Drawing();
        canvas.setSize(900, 900);
        int size = 3;
        int totalSize = size * size * 6;
        ArrayList<ArrayList<ArrayList<ShapeItem>>> cube = new ArrayList<ArrayList<ArrayList<ShapeItem>>>(6);

        canvas.initCube(cube);
        canvas.printCube(cube);
        //canvas.moveRight(cube,0,0);
        canvas.printCube(cube);
        frame.add(canvas);
        Color bg = new Color(255, 255, 255);
        canvas.setBackground(bg);
        frame.pack();
        frame.setVisible(true);
    }
    //paint runs automatically
    public void paint(Graphics2D g) {
        //g.fillOval(100, 100, 200, 200);
        Rectangle2D rect = new Rectangle2D.Double(350,700,200,200);
        ArrayList<ArrayList<ArrayList<ShapeItem>>> cube = new ArrayList<ArrayList<ArrayList<ShapeItem>>>(6);


        initCube(cube);
        //drawCube(g, cube);

        mickey(g, rect);
    }
    
    public void initCube(ArrayList<ArrayList<ArrayList<ShapeItem>>> cube) {
    	Random rand = new Random(0);
    	ArrayList<Integer> colors = new ArrayList<Integer>(6);
    	for(int i=0; i<6; i++) {
    		colors.add(0);
    	}
    	
        for(int i=0; i<6; i++) {
        	ArrayList<ArrayList<ShapeItem>> side = new ArrayList<ArrayList<ShapeItem>>(3);
        	for(int j=0; j<3; j++) {
    			ArrayList<ShapeItem> row = new ArrayList<ShapeItem>(3);
        		for(int k=0; k<3; k++) {
        			int x = rand.nextInt(6);
            		Color color;
            		while(colors.get(x) >= 9) {
            			x = rand.nextInt(6);
            		}
            		if( x == 0) {
            			color = Color.RED; 
            		}else if( x == 1) {
            			color = Color.BLUE; 
            		}else if( x == 2) {
            			color = Color.GREEN; 
            		}else if( x == 3) {
            			color = Color.YELLOW; 
            		}else if( x == 4) {
            			color = Color.WHITE; 
            		}else {
            			color = Color.GRAY; 
            		}
            		colors.set(x,colors.get(x)+1);
            		row.add(new ShapeItem(color));
        		}
        		side.add(row);
        	}
        	cube.add(side);
        }
    }
    
    
    

    
    public void printCube(ArrayList<ArrayList<ArrayList<ShapeItem>>> cube) {
    	for(int i=0; i<cube.size(); i++) {
	        System.out.printf("Side %d\n",i);

    		for(int j=0; j<cube.get(i).size(); j++) {
    			for(int k=0; k<3; k++) {
        			System.out.format("%2d %s ", k, cube.get(i).get(j).get(k).getColor());
    			}
    			System.out.println();
    		}
	    }
    	System.out.println("");
    }
    
    /*
    public void moveRight(ArrayList<ArrayList<ArrayList<ShapeItem>>> cube, int side, int row) {
    	ArrayList<ArrayList<ShapeItem>> tiles = cube.get(3);
    	// need a temporary place holder to shift rows in cube
    	ArrayList<ShapeItem> tempRow = tiles.get(row);
    	//********************************************************************************************fix
    	for(int i=3; i>=1; i--) {
    		cube.get(i).set(row, cube.get(i-1).get(row));
    	}
        cube.get(0).set(row, tempRow); 
        if(row == 0) {
        	rotateLeft(cube,4);
        }else if(row==3) {
        	rotateRight(cube,5);
        }
    }
    */
    /*
    //*************************************************************************************************fix
    public void rotateRight(ArrayList<ArrayList<ArrayList<ShapeItem>>> cube, int side) {
    	ArrayList<ArrayList<ShapeItem>> tiles = cube.get(side);
    	ArrayList<ArrayList<ShapeItem>> transposedSide = transpose(tiles);
    	cube.set(side, transposedSide);
    	for(int i=0; i<tiles.size();i++) {
    		reverse(tiles.get(i));
    	}
    }
    */
    /*
    //************************************************************************************************fix
    public void rotateLeft(ArrayList<ArrayList<ArrayList<ShapeItem>>> cube, int side) {
    	ArrayList<ArrayList<ShapeItem>> tiles = cube.get(side);
    	for(int i=0; i<tiles.size();i++) {
    		reverse(tiles.get(i));
    	}
    	ArrayList<ArrayList<Color>> transposedSide = transpose(tiles);
    	cube.set(side, transposedSide);

    }
    */
    /*
    public void reverse(ArrayList<ShapeItem> row) {
    	Color temp = row.get(0).getColor();
    	row.get(0).setColor(row.get(2).getColor());
    	row.get(2).setColor(temp);
    	/*
    	row.set(0, row.get(2));
    	row.set(2, temp);
    	*/ /*hereee
    }
    */
    /*
    public void flip(ArrayList<ArrayList<ShapeItem>> tiles) {
    	ArrayList<ShapeItem> temp = tiles.get(0);
    	//********************************************************************flip only colors
    	tiles.set(0, tiles.get(2));
    	tiles.set(2, temp);	
    }
    */
    /*
    public void moveLeft(ArrayList<ArrayList<ArrayList<ShapeItem>>> cube, int side, int row) {
    	ArrayList<ArrayList<ShapeItem>> tiles = cube.get(0);
    	// need a temporary place holder to shift rows in cube
    	ArrayList<ShapeItem> tempRow = tiles.get(row);
    	//****************************************************************************only colors
    	for(int i=0; i<3; i++) {
    		cube.get(i).set(row, cube.get(i+1).get(row));
    	}
        cube.get(3).set(row, tempRow);        
    }
	*/
    /*
    public ArrayList<ArrayList<ShapeItem>> transpose(ArrayList<ArrayList<ShapeItem>> side){
    	ArrayList<ArrayList<ShapeItem>> result = new ArrayList<ArrayList<ShapeItem>>();
    	//******************************************************************************transpose only colors
    	for(int i=0; i<side.size(); i++) {
    		ArrayList<Color> row = new ArrayList<Color>(3);
    		for(int j=0; j<side.get(i).size(); j++) {
    			row.add(side.get(j).get(i));
    		}
    		result.add(row);
    	}
    	return result;
    }
	*/
	public void boxOval(Graphics2D g, Rectangle2D bb) {
		g.fill(bb);
		g.fillOval((int)bb.getX(),(int)bb.getY(),(int)bb.getWidth(),(int)bb.getHeight());
		
		/*
		g.drawRect(bb.x, bb.y, bb.width, bb.height);
	    g.fillOval(bb.x, bb.y, bb.width, bb.height);
	    */
	}
	//********************************************************************************************fix
	/*
    public void drawCube( Graphics2D g, ArrayList<ArrayList<ArrayList<ShapeItem>>> cube) {
    	int size = 60;

    	int x = 0;
    	int y = size*4;
    	for(int i=0; i<3; i++) {
    		for(int j = 0; j<12; j++) {
            	if( j % 3 == 0 && j != 0) {
            		x+=size;
            	}

            	Color zeColour = cube.get(i+j/3).get(i).get(j%3);

            	g.setColor(zeColour);
            	g.fillRect(x, y, size, size);
            	g.setColor(Color.BLACK);
            	g.drawRect(x, y, size, size);
            	x+=size;
    		}
    		y+=size;
    		x=0;
    	}
    	x = size*4+size*2;
    	y = size;
    	for(int i=0; i<3; i++) {
    		for(int j = 0; j<3; j++) {
    	    	int [] xCoords = {x, x+size, x+size*2, x+size};
    	    	int [] yCoords = {y+size, y+size,y,y};
            	g.setColor(cube.get(4).get(i).get(j%3));
    	    	g.fillPolygon(xCoords, yCoords, 4);
    	    	g.setColor(Color.BLACK);
    	    	g.drawPolygon(xCoords, yCoords, 4);
            	x+=size;
    		}
    		y+=size;
    		x-=size*4;
    	}
    	/*
    	x = size*4;
    	y = size;
    	for(int i=0; i<3; i++) {
    		for(int j = 0; j<3; j++) {
            	g.setColor(cube.get(4).get(i).get(j%3));
            	g.fillRect(x, y, size, size);
            	g.setColor(Color.BLACK);
            	g.drawRect(x, y, size, size);

            	x+=size;

    		}
    		y+=size;
    		x=size*4;
    	}
    	*/
	/* hereeeeeee
    	x = size*4;
    	y = size*7;
    	for(int i=0; i<3; i++) {
    		for(int j = 0; j<3; j++) {
    			int [] xCoords = {x, x+size, x+size*2, x+size};
    	    	int [] yCoords = {y, y,y+size,y+size};
            	g.setColor(cube.get(4).get(i).get(j%3));
    	    	g.fillPolygon(xCoords, yCoords, 4);
    	    	g.setColor(Color.BLACK);
    	    	g.drawPolygon(xCoords, yCoords, 4);
            	x+=size;

    		}
    		y+=size;
    		x-=size*2;
    	}
    	
    	hereeeee*/ 
    	
    	/*
    	x = size*4;
    	y = size*8;
    	for(int i=0; i<3; i++) {
    		for(int j = 0; j<3; j++) {
    			
            	g.setColor(cube.get(5).get(i).get(j%3));
            	g.fillRect(x, y, size, size);
            	g.setColor(Color.BLACK);
            	g.drawRect(x, y, size, size);

            	x+=size;

    		}
    		y+=size;
    		x=size*4;
    	}
    	*/

    //}  hereee

    
	
	public void mickey(Graphics2D g, Rectangle2D bb) {
		//boxOval(g,bb);
	    //Rectangle smaller = new Rectangle(bb.x+bb.width/8, bb.y+bb.height/4, bb.width-(bb.width/8)*2, bb.height-(bb.height/8)*2);
	    Rectangle2D smaller = new Rectangle2D(bb.getX()+bb.getWidth()/8, bb.getY()+bb.getHeight()/4, bb.getWidth()-(bb.getWidth()/8)*2, bb.getHeight()-(bb.getHeight()/8)*2);

	    boxOval(g, smaller);
	
	    double dx = smaller.getWidth() / 2;
	    double dy = smaller.getHeight() / 2;
	    Rectangle2D half = new Rectangle2D.Double(smaller.getX(), smaller.getY(), dx, dy);

	    //half.translate(-dx / 2, -dy / 2);
	    boxOval(g, half);

	    //half.translate(dx * 2, 0);
	    boxOval(g, half);

	}
}