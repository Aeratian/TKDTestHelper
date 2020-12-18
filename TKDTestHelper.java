import java.awt.Font;
import java.io.*;
import java.util.*;

public class TKDTestHelper {

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
    public static void main(String args[])
    {
        TKDTestHelper t = new TKDTestHelper();
        t.setUpCanvas();
        t.addQuestions();
        t.drawTitleScreen();
        t.toggleAndStart();
    }
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
        StdDraw.text(0, 320-49*i, "Purple");
        i++;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, 320-49*i, "Orange");
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
                        StdDraw.clear();
                        drawTitleScreen();
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
                        StdDraw.clear();
                        drawTitleScreen();
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
                        StdDraw.clear();
                        drawTitleScreen();
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
                        StdDraw.clear();
                        drawTitleScreen();
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
                        StdDraw.clear();
                        drawTitleScreen();
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
                        StdDraw.clear();
                        drawTitleScreen();
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
                        StdDraw.clear();
                        drawTitleScreen();
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
                        StdDraw.clear();
                        drawTitleScreen();
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
                        StdDraw.clear();
                        drawTitleScreen();
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
                        StdDraw.clear();
                        drawTitleScreen();
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
                        StdDraw.clear();
                        drawTitleScreen();
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
                        StdDraw.clear();
                        drawTitleScreen();
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
                        StdDraw.clear();
                        drawTitleScreen();
                        StdDraw.pause(250);
                    }
                }
                i++;
                if(x>=-500&&x<=500&&y>=300-49*i&&y<=340-49*i)
                {
                    blackm();
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
    public void blackm()
    {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.clear();
    }
    public void exit()
    {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0, 0, "Thanks for using the program!");
        StdDraw.show();
    }
}
