/**
 * TKDTestHelper.java
 * A class that displays questions and their answers for the written test for USTASV.
 * Questions are sorted by belt level and multiple belts can be chosen at once.
 * The program ends when the exit button is clicked.
 * 
 * @author Ian Youn
 * @version 1.0
 * @since 12/17/2020
 */


import java.awt.Font;
import java.io.*;
import java.util.*;

public class TKDTestHelper {

    /** ArrayLists for storing the questions of each belt. */
    public ArrayList<Question> questions = new ArrayList<Question>();
    public ArrayList<Question> wquestions = new ArrayList<Question>();
    public ArrayList<Question> yquestions = new ArrayList<Question>();
    public ArrayList<Question> pquestions = new ArrayList<Question>();
    public ArrayList<Question> oquestions = new ArrayList<Question>();
    public ArrayList<Question> gjquestions = new ArrayList<Question>();
    public ArrayList<Question> gsquestions = new ArrayList<Question>();
    public ArrayList<Question> bjquestions = new ArrayList<Question>();
    public ArrayList<Question> bsquestions = new ArrayList<Question>();
    public ArrayList<Question> brjquestions = new ArrayList<Question>();
    public ArrayList<Question> brsquestions = new ArrayList<Question>();
    public ArrayList<Question> rjquestions = new ArrayList<Question>();
    public ArrayList<Question> rsquestions = new ArrayList<Question>();
    public ArrayList<Question> bquestions = new ArrayList<Question>();
    
    /** booleans representing which belts are chosen.  */
    public boolean whiteb = false;
    public boolean yellowb = false;
    public boolean purpleb = false;
    public boolean orangeb = false;
    public boolean greenjb = false;
    public boolean greensb = false;
    public boolean bluejb = false;
    public boolean bluesb = false;
    public boolean brownjb = false;
    public boolean brownsb = false;
    public boolean redjb = false;
    public boolean redsb = false;
    public boolean blackb = false;

    /**
     * Creates a TKDTestHelper Object and calls the respective methods.
     * @param args      The array of arguements in the console
     */
    public static void main(String args[])
    {
        TKDTestHelper t = new TKDTestHelper();
        t.setUpCanvas();
        t.addQuestions();
        t.drawTitleScreen();
        t.toggleAndStart();
    }

    /**
     * Sets up the canvas for the application.
     */
    public void setUpCanvas()
    {
        final int WIDTH = 1300;
		final int HEIGHT = 700;
		StdDraw.setCanvasSize(WIDTH, HEIGHT);
		StdDraw.setXscale(-650, 650);
        StdDraw.setYscale(-350, 350);
        
        StdDraw.clear(StdDraw.WHITE);
		Font font = new Font("Arial", Font.BOLD, 20);
		StdDraw.setFont(font);
        StdDraw.enableDoubleBuffering();
    }

    /**
     * Adds questions from the Questions.txt file to the respective ArrayLists.
     */
    public void addQuestions()
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("Questions.txt"));
            for(int i=0; i<64; i++)
            {
                try
                {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    Question q = new Question(st.nextToken("[|\\]"), st.nextToken("[|\\]"), st.nextToken("[|\\]"));
                    questions.add(q);
                    switch(q.getBelt())
                    {
                        case "White": wquestions.add(q); break;
                        case "Yellow": yquestions.add(q); break;
                        case "Purple": pquestions.add(q); break;
                        case "Orange": oquestions.add(q); break;
                        case "GreenJ": gjquestions.add(q); break;
                        case "GreenS": gsquestions.add(q); break;
                        case "BlueJ": bjquestions.add(q); break;
                        case "BlueS": bsquestions.add(q); break;
                        case "BrownJ": brjquestions.add(q); break;
                        case "BrownS": brsquestions.add(q); break;
                        case "RedJ": rjquestions.add(q); break;
                        case "RedS": rsquestions.add(q); break;
                        case "Black": bquestions.add(q); break;
                    }
                }
                catch(IOException abc)
                {

                }
            }
        }
        catch(FileNotFoundException fnf)
        {

        }
    }

    /**
     * Draws the title screen of the application.
     */
    public void drawTitleScreen()
    {
        StdDraw.clear();
        for(int i = 0; i < 14; i++)
        {
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, 320-49*i, 500, 20);
        }
        int i=0;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, 320-49*i, "White");
        i++;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, 320-49*i, "Yellow");
        i++;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, 320-49*i, "Orange");
        i++;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, 320-49*i, "Purple");
        i++;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, 320-49*i, "Junior Green");
        i++;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, 320-49*i, "Senior Green");
        i++;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, 320-49*i, "Junior Blue");
        i++;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, 320-49*i, "Senior Blue");
        i++;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, 320-49*i, "Junior Brown");
        i++;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, 320-49*i, "Senior Brown");
        i++;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, 320-49*i, "Junior Red");
        i++;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, 320-49*i, "Senior Red");
        i++;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, 320-49*i, "Black");
        i++;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, 320-49*i, "Black Practice");
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.filledRectangle(590, 320-49*i, 50, 25);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(590, 320-49*i, "Start");
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledRectangle(-590, 320-49*i, 50, 25);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(-590, 320-49*i, "Exit");
        StdDraw.show();
    }

    /**
     * Toggles each boolean and starts the question game for each belt selected.
     */
    public void toggleAndStart()
    {
        while(true)
        {
            double x = StdDraw.mouseX();
            double y = StdDraw.mouseY();
            if(StdDraw.isMousePressed())
            {
                int i = 0;
                if(x>=-500&&x<=500&&y>=300-49*i&&y<=340-49*i)
                {
                    whiteb = !whiteb;
                    if(whiteb)
                    {
                        StdDraw.setPenColor(StdDraw.ORANGE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                    if(!whiteb)
                    {
                       
                        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                }
                i++;
                if(x>=-500&&x<=500&&y>=300-49*i&&y<=340-49*i)
                {
                    yellowb = !yellowb;
                    if(yellowb)
                    {
                        StdDraw.setPenColor(StdDraw.ORANGE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                    if(!yellowb)
                    {
                        
                        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                }
                i++;
                if(x>=-500&&x<=500&&y>=300-49*i&&y<=340-49*i)
                {
                    orangeb = !orangeb;
                    if(orangeb)
                    {
                        StdDraw.setPenColor(StdDraw.ORANGE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                    if(!orangeb)
                    {
                       
                        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                }
                i++;
                if(x>=-500&&x<=500&&y>=300-49*i&&y<=340-49*i)
                {
                    purpleb = !purpleb;
                    if(purpleb)
                    {
                        StdDraw.setPenColor(StdDraw.ORANGE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                    if(!purpleb)
                    {
                        
                        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                }
                i++;
                if(x>=-500&&x<=500&&y>=300-49*i&&y<=340-49*i)
                {
                    greenjb = !greenjb;
                    if(greenjb)
                    {
                        StdDraw.setPenColor(StdDraw.ORANGE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                    if(!greenjb)
                    {
                        
                        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                }
                i++;
                if(x>=-500&&x<=500&&y>=300-49*i&&y<=340-49*i)
                {
                    greensb = !greensb;
                    if(greensb)
                    {
                        StdDraw.setPenColor(StdDraw.ORANGE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                    if(!greensb)
                    {
                        
                        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                }
                i++;
                if(x>=-500&&x<=500&&y>=300-49*i&&y<=340-49*i)
                {
                    bluejb = !bluejb;
                    if(bluejb)
                    {
                        StdDraw.setPenColor(StdDraw.ORANGE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                    if(!bluejb)
                    {
                        
                        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                }
                i++;
                if(x>=-500&&x<=500&&y>=300-49*i&&y<=340-49*i)
                {
                    bluesb = !bluesb;
                    if(bluesb)
                    {
                        StdDraw.setPenColor(StdDraw.ORANGE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                    if(!bluesb)
                    {
                        
                        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                }
                i++;
                if(x>=-500&&x<=500&&y>=300-49*i&&y<=340-49*i)
                {
                    brownjb = !brownjb;
                    if(brownjb)
                    {
                        StdDraw.setPenColor(StdDraw.ORANGE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                    if(!brownjb)
                    {
                        
                        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                }
                i++;
                if(x>=-500&&x<=500&&y>=300-49*i&&y<=340-49*i)
                {
                    brownsb = !brownsb;
                    if(brownsb)
                    {
                        StdDraw.setPenColor(StdDraw.ORANGE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                    if(!brownsb)
                    {
                        
                        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                }
                i++;
                if(x>=-500&&x<=500&&y>=300-49*i&&y<=340-49*i)
                {
                    redjb = !redjb;
                    if(redjb)
                    {
                        StdDraw.setPenColor(StdDraw.ORANGE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                    if(!redjb)
                    {
                       
                        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                }
                i++;
                if(x>=-500&&x<=500&&y>=300-49*i&&y<=340-49*i)
                {
                    redsb = !redsb;
                    if(redsb)
                    {
                        StdDraw.setPenColor(StdDraw.ORANGE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                    if(!redsb)
                    {
                        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                }
                i++;
                if(x>=-500&&x<=500&&y>=300-49*i&&y<=340-49*i)
                {
                    blackb = !blackb;
                    if(blackb)
                    {
                        StdDraw.setPenColor(StdDraw.ORANGE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                    if(!blackb)
                    {
                        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                        StdDraw.filledRectangle(475, 320-49*i, 15, 15);
                        StdDraw.show();
                        StdDraw.pause(250);
                    }
                }
                i++;
                if(x>=-500&&x<=500&&y>=300-49*i&&y<=340-49*i)
                {
                    blackm();
                    drawTitleScreen();
                    toggleAndStart();
                    break;
                }
                if(x<=-540&&x>=-640&&y>=295-49*i&&y<=345-49*i)
                {
                    exit();
                    break;
                }
                if(x>=540&&x<=640&&y>=295-49*i&&y<=345-49*i)
                {
                    if(whiteb)
                    {
                        white();
                    }
                    if(yellowb)
                    {
                        yellow();
                    }
                    if(purpleb)
                    {
                        purple();
                    }
                    if(orangeb)
                    {
                        orange();
                    }
                    if(greenjb)
                    {
                        greenj();
                    }
                    if(greensb)
                    {
                        greens();
                    }
                    if(bluejb)
                    {
                        bluej();
                    }
                    if(bluesb)
                    {
                        blues();
                    }
                    if(brownjb)
                    {
                        brownj();
                    }
                    if(brownsb)
                    {
                        browns();
                    }
                    if(redjb)
                    {
                        redj();
                    }
                    if(redsb)
                    {
                        reds();
                    }
                    if(blackb)
                    {
                        black();
                    }
                    drawTitleScreen();
                    toggleAndStart();
                    break;
                }
            }
        }
    }

    /**
     * Plays the question game for white belt.
     */
    public void white()
    {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.clear();
        for(int i=0; i<wquestions.size(); i++)
        {
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            String str = wquestions.get(i).getQuestion();
            StringTokenizer st = new StringTokenizer(str);
            int j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "See Answer");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            str = wquestions.get(i).getAnswer();
            st = new StringTokenizer(str);
            j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "Next Question");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
        }
    }

    /**
     * Plays the question game for yellow belt.
     */
    public void yellow()
    {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.clear();
        for(int i=0; i<yquestions.size(); i++)
        {
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            String str = yquestions.get(i).getQuestion();
            StringTokenizer st = new StringTokenizer(str);
            int j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "See Answer");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            str = yquestions.get(i).getAnswer();
            st = new StringTokenizer(str);
            j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "Next Question");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
        }
    }

    /**
     * Plays the question game for purple belt.
     */
    public void purple()
    {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.clear();
        for(int i=0; i<pquestions.size(); i++)
        {
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            String str = pquestions.get(i).getQuestion();
            StringTokenizer st = new StringTokenizer(str);
            int j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "See Answer");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            str = pquestions.get(i).getAnswer();
            st = new StringTokenizer(str);
            j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "Next Question");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
        }
    }
    /**
     * Plays the question game for orange belt.
     */
    public void orange()
    {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.clear();
        for(int i=0; i<oquestions.size(); i++)
        {
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            String str = oquestions.get(i).getQuestion();
            StringTokenizer st = new StringTokenizer(str);
            int j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "See Answer");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            str = oquestions.get(i).getAnswer();
            st = new StringTokenizer(str);
            j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "Next Question");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
        }
    }

    /**
     * Plays the question game for junior green belt.
     */
    public void greenj()
    {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.clear();
        for(int i=0; i<gjquestions.size(); i++)
        {
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            String str = gjquestions.get(i).getQuestion();
            StringTokenizer st = new StringTokenizer(str);
            int j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "See Answer");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            str = gjquestions.get(i).getAnswer();
            st = new StringTokenizer(str);
            j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "Next Question");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
        }
    }

    /**
     * Plays the question game for senior green belt.
     */
    public void greens()
    {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.clear();
        for(int i=0; i<gsquestions.size(); i++)
        {
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            String str = gsquestions.get(i).getQuestion();
            StringTokenizer st = new StringTokenizer(str);
            int j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "See Answer");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            str = gsquestions.get(i).getAnswer();
            st = new StringTokenizer(str);
            j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "Next Question");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
        }
    }

    /**
     * Plays the question game for junior blue belt.
     */
    public void bluej()
    {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.clear();
        for(int i=0; i<bjquestions.size(); i++)
        {
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            String str = bjquestions.get(i).getQuestion();
            StringTokenizer st = new StringTokenizer(str);
            int j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "See Answer");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            str = bjquestions.get(i).getAnswer();
            st = new StringTokenizer(str);
            j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "Next Question");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
        }
    }

    /**
     * Plays the question game for senior blue belt.
     */
    public void blues()
    {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.clear();
        for(int i=0; i<bsquestions.size(); i++)
        {
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            String str = bsquestions.get(i).getQuestion();
            StringTokenizer st = new StringTokenizer(str);
            int j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "See Answer");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            str = bsquestions.get(i).getAnswer();
            st = new StringTokenizer(str);
            j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "Next Question");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
        }
    }

    /**
     * Plays the question game for junior brown belt.
     */
    public void brownj()
    {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.clear();
        for(int i=0; i<brjquestions.size(); i++)
        {
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            String str = brjquestions.get(i).getQuestion();
            StringTokenizer st = new StringTokenizer(str);
            int j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "See Answer");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            str = brjquestions.get(i).getAnswer();
            st = new StringTokenizer(str);
            j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "Next Question");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
        }
    }

    /**
     * Plays the question game for senior brown belt.
     */
    public void browns()
    {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.clear();
        for(int i=0; i<brsquestions.size(); i++)
        {
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            String str = brsquestions.get(i).getQuestion();
            StringTokenizer st = new StringTokenizer(str);
            int j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "See Answer");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            str = brsquestions.get(i).getAnswer();
            st = new StringTokenizer(str);
            j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "Next Question");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
        }
    }

    /**
     * Plays the question game for junior red belt.
     */
    public void redj()
    {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.clear();
        for(int i=0; i<rjquestions.size(); i++)
        {
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            String str = rjquestions.get(i).getQuestion();
            StringTokenizer st = new StringTokenizer(str);
            int j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "See Answer");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            str = rjquestions.get(i).getAnswer();
            st = new StringTokenizer(str);
            j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "Next Question");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
        }
    }

    /**
     * Plays the question game for senior red belt.
     */
    public void reds()
    {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.clear();
        for(int i=0; i<rsquestions.size(); i++)
        {
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            String str = rsquestions.get(i).getQuestion();
            StringTokenizer st = new StringTokenizer(str);
            int j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "See Answer");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            str = rsquestions.get(i).getAnswer();
            st = new StringTokenizer(str);
            j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "Next Question");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
        }
    }

    /**
     * Plays the question game for black belt.
     */
    public void black()
    {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.clear();
        for(int i=0; i<bquestions.size(); i++)
        {
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            String str = bquestions.get(i).getQuestion();
            StringTokenizer st = new StringTokenizer(str);
            int j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "See Answer");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            str = bquestions.get(i).getAnswer();
            st = new StringTokenizer(str);
            j = 0;
            while(st.hasMoreTokens())
            {
                StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
                j++;
            }
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0, -250, 340, 50);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0, -250, "Next Question");
            StdDraw.show();
            while(true)
            {
                if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
                {
                    StdDraw.pause(250);
                    break;
                }
            }
        }
    }

    /**
     * Plays a special question game for black belt testers.
     * Randonmly selects one question from each belt and uses
     * the collection to play the question game.
     */
    public void blackm()
    {
        Question q = wquestions.get((int)(Math.random()*wquestions.size()));
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        Font font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        String str = q.getQuestion();
        StringTokenizer st = new StringTokenizer(str);
        int j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "See Answer");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        str = q.getAnswer();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "Next Question");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        q = yquestions.get((int)(Math.random()*yquestions.size()));
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        str = q.getQuestion();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "See Answer");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        str = q.getAnswer();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "Next Question");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        q = oquestions.get((int)(Math.random()*oquestions.size()));
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        str = q.getQuestion();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "See Answer");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        str = q.getAnswer();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "Next Question");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        q = pquestions.get((int)(Math.random()*pquestions.size()));
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        str = q.getQuestion();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "See Answer");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        str = q.getAnswer();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "Next Question");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        q = gjquestions.get((int)(Math.random()*gjquestions.size()));
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        str = q.getQuestion();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "See Answer");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        str = q.getAnswer();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "Next Question");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        q = gsquestions.get((int)(Math.random()*gsquestions.size()));
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        str = q.getQuestion();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "See Answer");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        str = q.getAnswer();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "Next Question");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        q = bjquestions.get((int)(Math.random()*bjquestions.size()));
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        str = q.getQuestion();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "See Answer");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        str = q.getAnswer();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "Next Question");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        q = bsquestions.get((int)(Math.random()*bsquestions.size()));
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        str = q.getQuestion();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "See Answer");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        str = q.getAnswer();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "Next Question");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        q = brjquestions.get((int)(Math.random()*brjquestions.size()));
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        str = q.getQuestion();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "See Answer");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        str = q.getAnswer();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "Next Question");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        q = brsquestions.get((int)(Math.random()*brsquestions.size()));
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        str = q.getQuestion();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "See Answer");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        str = q.getAnswer();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "Next Question");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        q = rjquestions.get((int)(Math.random()*rjquestions.size()));
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        str = q.getQuestion();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "See Answer");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        str = q.getAnswer();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "Next Question");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        q = rsquestions.get((int)(Math.random()*rsquestions.size()));
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        str = q.getQuestion();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "See Answer");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        str = q.getAnswer();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "Next Question");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        q = bquestions.get((int)(Math.random()*bquestions.size()));
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        str = q.getQuestion();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[|\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "See Answer");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        str = q.getAnswer();
        st = new StringTokenizer(str);
        j = 0;
        while(st.hasMoreTokens())
        {
            StdDraw.text(0, 300-50*j, st.nextToken("[.\\]"));
            j++;
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, -250, 340, 50);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -250, "Next Question");
        StdDraw.show();
        while(true)
        {
            if(StdDraw.isMousePressed()&&StdDraw.mouseX()>=-340&&StdDraw.mouseX()<=340&&StdDraw.mouseY()>=-300&&StdDraw.mouseY()<=-200)
            {
                StdDraw.pause(250);
                break;
            }
        }
        StdDraw.clear();
        StdDraw.show();
    }

    /**
     * Exits the application and draws a thank you message.
     */
    public void exit()
    {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0, 0, "Thanks for using the program!");
        StdDraw.show();
    }
}
