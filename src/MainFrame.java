import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class MainFrame extends JFrame {

   public static int[][] currentBoard = new int[9][9];
   public static int[][] currentPreSolve = new int[9][9];
   private static final int[][] currentPreToSolve = new int[9][9];
   public static TextField checker;


    private static TextField text00;
    private static TextField text10;
    private static TextField text20;
    private static TextField text01;
    private static TextField text11;
    private static TextField text21;
    private static TextField text02;
    private static TextField text12;
    private static TextField text22;
    private static TextField text03;
    private static TextField text04;
    private static TextField text05;
    private static TextField text13;
    private static TextField text14;
    private static TextField text15;
    private static TextField text23;
    private static TextField text24;
    private static TextField text25;
    private static TextField text06;
    private static TextField text07;
    private static TextField text08;
    private static TextField text16;
    private static TextField text17;
    private static TextField text18;
    private static TextField text26;
    private static TextField text27;
    private static TextField text28;
    private static TextField text30;
    private static TextField text40;
    private static TextField text50;
    private static TextField text31;
    private static TextField text41;
    private static TextField text51;
    private static TextField text32;
    private static TextField text42;
    private static TextField text52;
    private static TextField text33;
    private static TextField text43;
    private static TextField text53;
    private static TextField text34;
    private static TextField text44;
    private static TextField text54;
    private static TextField text35;
    private static TextField text45;
    private static TextField text55;
    private static TextField text36;
    private static TextField text46;
    private static TextField text56;
    private static TextField text37;
    private static TextField text47;
    private static TextField text57;
    private static TextField text38;
    private static TextField text48;
    private static TextField text58;
    private static TextField text60;
    private static TextField text70;
    private static TextField text80;
    private static TextField text61;
    private static TextField text71;
    private static TextField text81;
    private static TextField text62;
    private static TextField text72;
    private static TextField text82;
    private static TextField text63;
    private static TextField text73;
    private static TextField text83;
    private static TextField text64;
    private static TextField text74;
    private static TextField text84;
    private static TextField text65;
    private static TextField text75;
    private static TextField text85;
    private static TextField text66;
    private static TextField text76;
    private static TextField text86;
    private static TextField text67;
    private static TextField text77;
    private static TextField text87;
    private static TextField text68;
    private static TextField text78;
    private static TextField text88;

    public static void main(String[] args) {

     JPanel Outline = new JPanel();  //JPanel  Black Outline
     Outline.setBackground(Color.black);
     Outline.setBounds(0, 0, 470, 500);

     JFrame frame = new JFrame();          //JFrame stuff
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setLayout(new BorderLayout());
     frame.setSize(670, 505);
     frame.setMaximumSize(new Dimension(300, 300));
     frame.setTitle("Sudoku");

     JPanel greePanel = new JPanel();  // Jpanel on Left
     greePanel.setLayout(null);
     greePanel.setBackground(Color.white);
     greePanel.setBounds(470, 0, 200, 500);

     TextField topper = new TextField(50);           //Header
     topper.setBounds(10,10,150,30);
     greePanel.add(topper);
     topper.setText(" Current Board");
     topper.setEditable(false);
     topper.setFont(new Font("Serif",Font.BOLD,20));

     JButton currentEasy = new JButton();                    //Reset to Current
     currentEasy.setBounds(10, 45, 150, 20);
     currentEasy.setText("Reset to Current Board");
     currentEasy.setFont(new Font("Dialog",Font.BOLD,10));
     currentEasy.addActionListener(e -> {
      SudokuSolver.printBoard(currentPreToSolve);
      setUpOG();
     });
     greePanel.add(currentEasy);

     JButton solve = new JButton();                       //Very Slow Solve
     solve.setBounds(10, 70, 150, 20);
     solve.setText("Very Slow Solve");
     solve.addActionListener(e -> setUp(75));
     greePanel.add(solve);

     JButton solvee = new JButton();                       //Slow Solve
     solvee.setBounds(10, 95, 150, 20);
     solvee.setText("Slow Solve");
     solvee.addActionListener(e -> setUp(1));
     greePanel.add(solvee);

     JButton quickSolve = new JButton();                     // Instant Solve
     quickSolve.setBounds(10, 120, 150, 20);
     quickSolve.setText("Instant Solve");
     quickSolve.addActionListener(e -> {
      SudokuSolver.solveBoardFast(currentBoard);
      MainFrame.setUpCurrent();
     });
     greePanel.add(quickSolve);

     JButton check = new JButton();
     check.setBounds(10, 145, 150, 20);
     check.setText("Check Current Board");
     check.setFont(new Font("Dialog",Font.BOLD,10));
     check.addActionListener(e -> {
      TextField[][] textFormat = grid();
      int cap = 0;
      int broken = 0;
      Set<String> set = new HashSet<>();
      broken:
      for (int i = 0; i < 9; i++) {
       for (int j = 0; j < 9; j++) {
        try {
         char cur = textFormat[i][j].getText().charAt(0);
         if (!set.add("row" + i + cur) || !set.add("col" + j + cur) || !set.add("grid" + cur + i / 3 + j / 3)) {
          cap++;
         }
        } catch (Exception eeee) {
         checker.setText("Not Solved. Error");
         broken = 1;
         break broken;
        }
       }
      }
      if (cap == 0 && broken == 0) {
       checker.setText("Solved!!!!!");
      } else {
       checker.setText("Not Solved :(");
      }
     });
     greePanel.add(check);

     checker = new TextField(150);
     checker.setEditable(false);
     checker.setBounds(10,170,150,20);
    greePanel.add(checker);

     TextField middle = new TextField(50);           //Second Header
     middle.setBounds(10,245,150,24);
     greePanel.add(middle);
     middle.setText("New Random Board");
     middle.setEditable(false);
     middle.setFont(new Font("Serif",Font.BOLD,16));

     JButton easy = new JButton();
     easy.setBounds(10, 270, 150, 20);
     easy.setText("Easy Board");
     easy.addActionListener(e -> setUpEasyy(50));
     greePanel.add(easy);

     JButton medium = new JButton();
     medium.setBounds(10, 295, 150, 20);
     medium.setText("Medium Board");
     medium.addActionListener(e -> setUpEasyy(54));
     greePanel.add(medium);

     JButton hard = new JButton();
     hard.setBounds(10, 320, 150, 20);
     hard.setText("Hard Board");
     hard.addActionListener(e -> setUpEasyy(58));
     greePanel.add(hard);

     JButton button = new JButton();
     button.setBounds(10, 345, 150, 20);
     button.setText("Empty Board");
     button.addActionListener(e -> emptyTheBoard());
     greePanel.add(button);

     //This should be how I can get to see all the cells

     JPanel panelll = new JPanel();
     panelll.setOpaque(false);
     panelll.setLayout(new GridLayout(3, 3, 3, 3));
     panelll.setBounds(5, 5, 150, 150);
     text00 = new TextField(10);
     panelll.add(text00);
     text10 = new TextField(10);
     panelll.add(text10);
     text20 = new TextField(10);
     panelll.add(text20);
     text01 = new TextField(10);
     panelll.add(text01);
     text11 = new TextField(10);
     panelll.add(text11);
     text21 = new TextField(10);
     panelll.add(text21);
     text02 = new TextField(10);
     panelll.add(text02);
     text12 = new TextField(10);
     panelll.add(text12);
     text22 = new TextField(10);
     panelll.add(text22);
     frame.add(panelll);

     JPanel panellll = new JPanel();
     panellll.setOpaque(false);
     panellll.setLayout(new GridLayout(3, 3, 3, 3));
     panellll.setBounds(5, 160, 150, 150);
     text03 = new TextField(10);
     panellll.add(text03);
     text13 = new TextField(10);
     panellll.add(text13);
     text23 = new TextField(10);
     panellll.add(text23);
     text04 = new TextField(10);
     panellll.add(text04);
     text14 = new TextField(10);
     panellll.add(text14);
     text24 = new TextField(10);
     panellll.add(text24);
     text05 = new TextField(10);
     panellll.add(text05);
     text15 = new TextField(10);
     panellll.add(text15);
     text25 = new TextField(10);
     panellll.add(text25);
     frame.add(panellll);

     JPanel panelllll = new JPanel();
     panelllll.setOpaque(false);
     panelllll.setLayout(new GridLayout(3, 3, 3, 3));
     panelllll.setBounds(5, 315, 150, 150);
     text06 = new TextField(10);
     panelllll.add(text06);
     text16 = new TextField(10);
     panelllll.add(text16);
     text26 = new TextField(10);
     panelllll.add(text26);
     text07 = new TextField(10);
     panelllll.add(text07);
     text17 = new TextField(10);
     panelllll.add(text17);
     text27 = new TextField(10);
     panelllll.add(text27);
     text08 = new TextField(10);
     panelllll.add(text08);
     text18 = new TextField(10);
     panelllll.add(text18);
     text28 = new TextField(10);
     panelllll.add(text28);
     frame.add(panelllll);

     JPanel panellllll = new JPanel();
     panellllll.setOpaque(false);
     panellllll.setLayout(new GridLayout(3, 3, 3, 3));
     panellllll.setBounds(160, 5, 150, 150);
     text30 = new TextField(10);
     panellllll.add(text30);
     text40 = new TextField(10);
     panellllll.add(text40);
     text50 = new TextField(10);
     panellllll.add(text50);
     text31 = new TextField(10);
     panellllll.add(text31);
     text41 = new TextField(10);
     panellllll.add(text41);
     text51 = new TextField(10);
     panellllll.add(text51);
     text32 = new TextField(10);
     panellllll.add(text32);
     text42 = new TextField(10);
     panellllll.add(text42);
     text52 = new TextField(10);
     panellllll.add(text52);
     frame.add(panellllll);

     JPanel panelllllll = new JPanel();
     panelllllll.setOpaque(false);
     panelllllll.setLayout(new GridLayout(3, 3, 3, 3));
     panelllllll.setBounds(160, 160, 150, 150);
     text33 = new TextField(10);
     panelllllll.add(text33);
     text43 = new TextField(10);
     panelllllll.add(text43);
     text53 = new TextField(10);
     panelllllll.add(text53);
     text34 = new TextField(10);
     panelllllll.add(text34);
     text44 = new TextField(10);
     panelllllll.add(text44);
     text54 = new TextField(10);
     panelllllll.add(text54);
     text35 = new TextField(10);
     panelllllll.add(text35);
     text45 = new TextField(10);
     panelllllll.add(text45);
     text55 = new TextField(10);
     panelllllll.add(text55);
     frame.add(panelllllll);

     JPanel panellllllll = new JPanel();
     panellllllll.setOpaque(false);
     panellllllll.setLayout(new GridLayout(3, 3, 3, 3));
     panellllllll.setBounds(160, 315, 150, 150);
     text36 = new TextField(10);
     panellllllll.add(text36);
     text46 = new TextField(10);
     panellllllll.add(text46);
     text56 = new TextField(10);
     panellllllll.add(text56);
     text37 = new TextField(10);
     panellllllll.add(text37);
     text47 = new TextField(10);
     panellllllll.add(text47);
     text57 = new TextField(10);
     panellllllll.add(text57);
     text38 = new TextField(10);
     panellllllll.add(text38);
     text48 = new TextField(10);
     panellllllll.add(text48);
     text58 = new TextField(10);
     panellllllll.add(text58);
     frame.add(panellllllll);

     JPanel panelllllllll = new JPanel();
     panelllllllll.setOpaque(false);
     panelllllllll.setLayout(new GridLayout(3, 3, 3, 3));
     panelllllllll.setBounds(315, 5, 150, 150);
     text60 = new TextField(10);
     panelllllllll.add(text60);
     text70 = new TextField(10);
     panelllllllll.add(text70);
     text80 = new TextField(10);
     panelllllllll.add(text80);
     text61 = new TextField(10);
     panelllllllll.add(text61);
     text71 = new TextField(10);
     panelllllllll.add(text71);
     text81 = new TextField(10);
     panelllllllll.add(text81);
     text62 = new TextField(10);
     panelllllllll.add(text62);
     text72 = new TextField(10);
     panelllllllll.add(text72);
     text82 = new TextField(10);
     panelllllllll.add(text82);
     frame.add(panelllllllll);

     JPanel panellllllllll = new JPanel();
     panellllllllll.setOpaque(false);
     panellllllllll.setLayout(new GridLayout(3, 3, 3, 3));
     panellllllllll.setBounds(315, 160, 150, 150);
     text63 = new TextField(10);
     panellllllllll.add(text63);
     text73 = new TextField(10);
     panellllllllll.add(text73);
     text83 = new TextField(10);
     panellllllllll.add(text83);
     text64 = new TextField(10);
     panellllllllll.add(text64);
     text74 = new TextField(10);
     panellllllllll.add(text74);
     text84 = new TextField(10);
     panellllllllll.add(text84);
     text65 = new TextField(10);
     panellllllllll.add(text65);
     text75 = new TextField(10);
     panellllllllll.add(text75);
     text85 = new TextField(10);
     panellllllllll.add(text85);
     frame.add(panellllllllll);

     JPanel panel9 = new JPanel();
     panel9.setOpaque(false);
     panel9.setLayout(new GridLayout(3, 3, 3, 3));
     panel9.setBounds(315, 315, 150, 150);
     text66 = new TextField(10);
     text76 = new TextField(10);
     text86 = new TextField(10);
     text67 = new TextField(10);
     text77 = new TextField(10);
     text87 = new TextField(10);
     text68 = new TextField(10);
     text78 = new TextField(10);
     text88 = new TextField(10);

     TextField[] ninthSquare = {text66,text76,text86,text67,text77,text87,text68,text78,text88};
     for (TextField x: ninthSquare) {
    //  x = new TextField(10);
      panel9.add(x);
    }
    frame.add(panel9);


     TextField[][] textFormat = grid();
     for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        textFormat[i][j].setFont(new Font("Serif",Font.BOLD,45));
        textFormat[i][j].setPreferredSize(new Dimension(10,10));
      }
     }


     for (int i = 0; i < 3; i++) {  // Easily change colors of 3x3s
      for (int j = 0; j < 3; j++) {
       JPanel panell = new JPanel();
       panell.setBackground(Color.lightGray);
       panell.setBounds(5 + i * 155, 5 + 155 * j, 150, 150);
       frame.add(panell);
      }
     }

     frame.add(greePanel);
     frame.add(Outline);
     frame.setVisible(true);

     setUpEasyy(50); // Sets up initial board

    }


 public static void setUpCurrent() {
  TextField[][] myTextFields = grid();
  for (int i = 0; i < 9; i++) {
   for (int j = 0; j < 9; j++) {
    if (currentBoard[i][j] > 0) {
     myTextFields[i][j].setText(Integer.toString(currentBoard[i][j]));
     myTextFields[i][j].setEditable(false);
    } else {
     myTextFields[i][j].setText("");
     myTextFields[i][j].setEditable(true);
    }
   }
  }
 }

 public static void setUpCurrentSlow() {
  TextField[][] myTextFields = grid();
  for (int i = 0; i < 9; i++) {
   for (int j = 0; j < 9; j++) {
    if (currentPreToSolve[i][j] > 0) {
     myTextFields[i][j].setText(Integer.toString(currentPreToSolve[i][j]));
     myTextFields[i][j].setEditable(false);
    } else {
     myTextFields[i][j].setText("");
     myTextFields[i][j].setEditable(true);
    }
   }
  }
 }

 public static void setUpOG() {
  TextField[][] myTextFields = grid();
  SudokuSolver.printBoard(currentPreSolve);
  for (int i = 0; i < 9; i++) {
   for (int j = 0; j < 9; j++) {
    if (currentPreSolve[i][j] > 0) {
     myTextFields[i][j].setText(Integer.toString(currentPreSolve[i][j]));
     myTextFields[i][j].setEditable(false);
    } else {
     myTextFields[i][j].setText("");
     myTextFields[i][j].setEditable(true);
    }
   }
  }
 }

 public static void setUpEasyy(int k) {
     checker.setText("");
  SudokuMaker.easyTest(k);
  TextField[][] myTextFields = grid();
  int[][] tester = SudokuMaker.mat;
  for (int i = 0; i < 9; i++) {
   for (int j = 0; j < 9; j++) {
    if (tester[i][j] > 0) {
     myTextFields[i][j].setText(Integer.toString(tester[i][j]));
     myTextFields[i][j].setEditable(false);
    } else {
     myTextFields[i][j].setText("");
     myTextFields[i][j].setEditable(true);
    }

   }

  }
  currentBoard = tester;
  preSolveToTester();
 }

 public static void preSolveToTester() {
     int[][] testee = SudokuMaker.mat;
     for (int i = 0;  i < 9; i++) {
      System.arraycopy(testee[i], 0, currentPreSolve[i], 0, 9);
     }
 }


 public static void emptyTheBoard()  {
     checker.setText("");
      System.out.println("Emptying!");
      System.out.println(text00);
      TextField[][] myTextFields = grid();
      for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
              myTextFields[i][j].setText("");
           myTextFields[i][j].setEditable(true);
          }
      }
   }

   public static void setUp(int a) {
    for (int i = 0;  i < 9; i++) {
     System.arraycopy(currentPreSolve[i], 0, currentPreToSolve[i], 0, 9);
    }
    SudokuSolver.solveBoard(currentPreToSolve,a);

   }

   public static TextField[][] grid() {

    return new TextField[][]{
            {text00,text10,text20,text30,text40,text50,text60,text70,text80},
            {text01,text11,text21,text31,text41,text51,text61,text71,text81},
            {text02,text12,text22,text32,text42,text52,text62,text72,text82},
            {text03,text13,text23,text33,text43,text53,text63,text73,text83},
            {text04,text14,text24,text34,text44,text54,text64,text74,text84},
            {text05,text15,text25,text35,text45,text55,text65,text75,text85},
            {text06,text16,text26,text36,text46,text56,text66,text76,text86},
            {text07,text17,text27,text37,text47,text57,text67,text77,text87},
            {text08,text18,text28,text38,text48,text58,text68,text78,text88},
    };
   }

}
