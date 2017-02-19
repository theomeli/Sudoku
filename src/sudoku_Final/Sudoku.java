package sudoku_Final;

import java.awt.Color;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Totoros
 */
public class Sudoku extends javax.swing.JDialog implements GameBoard{
    
    private int[][] labels;
    private HashMap<Integer, JLabel> immutableLabels;
    private SudokuLogic logic;
    private String buttonClicked = "0";

    /**
     * Creates new form Sudoku
     * @param parent
     * @param modal
     * @param logic
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.NoSuchMethodException
     * @throws java.lang.reflect.InvocationTargetException
     */
    public Sudoku(java.awt.Frame parent, boolean modal, SudokuLogic logic) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        super(parent, modal);
        immutableLabels = new HashMap<>();
        this.logic = logic;
        this.labels = new int[10][10];
        for (int i = 1; i < 10; i++) 
            for (int j = 1; j < 10; j++)
                labels[i][j] = logic.board.getCell(i - 1, j - 1);
        
        initComponents();
    }
    
    public Sudoku(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void updateJLabels(int[][] labels, SudokuLogic logic) throws IllegalArgumentException, IllegalAccessException {
        Class<?> obj = this.getClass();

        Class<?> c = (new JLabel()).getClass();

        ArrayList<Field> labelFields = new ArrayList<>();
        Field[] fs = obj.getDeclaredFields();
        for (Field f : fs)
            if (c.isAssignableFrom(f.getType()))
                labelFields.add(f);
            
        for (Field f : labelFields) {
            String fieldName = f.getName();
            int x = Character.getNumericValue(fieldName.charAt(4));
            int y = Character.getNumericValue(fieldName.charAt(5));
            try {
                Object o1 = f.get(this);
                JLabel lab = (JLabel) o1;
                if (labels[y][x] != 0) {
                    lab.setText(Integer.toString(labels[y][x]));
                    lab. setForeground(Color.red);
                    immutableLabels.put(immutableLabels.size() + 1, lab);
                }
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void updateJLabels(String[][] letters, SudokuLogic logic) throws IllegalArgumentException, IllegalAccessException {
        Class<?> obj = this.getClass();

        Class<?> c = (new JLabel()).getClass();

        ArrayList<Field> labelFields = new ArrayList<>();
        Field[] fs = obj.getDeclaredFields();
        for (Field f : fs)
            if (c.isAssignableFrom(f.getType()))
                labelFields.add(f);
            
        for (Field f : labelFields) {
            String fieldName = f.getName();
            int x = Character.getNumericValue(fieldName.charAt(4));
            int y = Character.getNumericValue(fieldName.charAt(5));
            try {
                Object o = f.get(this);
                JLabel lab = (JLabel) o;
                if (!"_".equals(letters[y][x])) {
                    lab.setText(letters[y][x]);
                    lab.setForeground(Color.red);
                    immutableLabels.put(immutableLabels.size() + 1, lab);
                }
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void lettersInButtons() throws IllegalArgumentException, IllegalAccessException {
        Class<?> obj = this.getClass();

        Class<?> b = (new JButton()).getClass();

        ArrayList<Field> labelFields = new ArrayList<>();
        Field[] fs = obj.getDeclaredFields();
        for (Field f : fs)
            if (b.isAssignableFrom(f.getType()))
                labelFields.add(f);
        for (Field f : labelFields) {
            String fieldName = f.getName();
            if (fieldName.startsWith("jButton")) {
                int numb = Character.getNumericValue(fieldName.charAt(7));
                Object o = f.get(this);
                JButton but = (JButton) o;
                but.setText(StartScreen.numbToLetter(numb));
            }
        }
    }
    
    public int[][] getLabels() {
        return this.labels;
    }
    
    @Override
    public void newGame() {
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        board = new javax.swing.JPanel();
        block11 = new javax.swing.JPanel();
        cell11 = new javax.swing.JLabel();
        cell12 = new javax.swing.JLabel();
        cell13 = new javax.swing.JLabel();
        cell21 = new javax.swing.JLabel();
        cell22 = new javax.swing.JLabel();
        cell23 = new javax.swing.JLabel();
        cell31 = new javax.swing.JLabel();
        cell32 = new javax.swing.JLabel();
        cell33 = new javax.swing.JLabel();
        block12 = new javax.swing.JPanel();
        cell14 = new javax.swing.JLabel();
        cell15 = new javax.swing.JLabel();
        cell16 = new javax.swing.JLabel();
        cell24 = new javax.swing.JLabel();
        cell25 = new javax.swing.JLabel();
        cell26 = new javax.swing.JLabel();
        cell34 = new javax.swing.JLabel();
        cell35 = new javax.swing.JLabel();
        cell36 = new javax.swing.JLabel();
        block13 = new javax.swing.JPanel();
        cell17 = new javax.swing.JLabel();
        cell18 = new javax.swing.JLabel();
        cell19 = new javax.swing.JLabel();
        cell27 = new javax.swing.JLabel();
        cell28 = new javax.swing.JLabel();
        cell29 = new javax.swing.JLabel();
        cell37 = new javax.swing.JLabel();
        cell38 = new javax.swing.JLabel();
        cell39 = new javax.swing.JLabel();
        block21 = new javax.swing.JPanel();
        cell41 = new javax.swing.JLabel();
        cell42 = new javax.swing.JLabel();
        cell43 = new javax.swing.JLabel();
        cell51 = new javax.swing.JLabel();
        cell52 = new javax.swing.JLabel();
        cell53 = new javax.swing.JLabel();
        cell61 = new javax.swing.JLabel();
        cell62 = new javax.swing.JLabel();
        cell63 = new javax.swing.JLabel();
        block22 = new javax.swing.JPanel();
        cell44 = new javax.swing.JLabel();
        cell45 = new javax.swing.JLabel();
        cell46 = new javax.swing.JLabel();
        cell54 = new javax.swing.JLabel();
        cell55 = new javax.swing.JLabel();
        cell56 = new javax.swing.JLabel();
        cell64 = new javax.swing.JLabel();
        cell65 = new javax.swing.JLabel();
        cell66 = new javax.swing.JLabel();
        block23 = new javax.swing.JPanel();
        cell47 = new javax.swing.JLabel();
        cell48 = new javax.swing.JLabel();
        cell49 = new javax.swing.JLabel();
        cell57 = new javax.swing.JLabel();
        cell58 = new javax.swing.JLabel();
        cell59 = new javax.swing.JLabel();
        cell67 = new javax.swing.JLabel();
        cell68 = new javax.swing.JLabel();
        cell69 = new javax.swing.JLabel();
        block31 = new javax.swing.JPanel();
        cell71 = new javax.swing.JLabel();
        cell72 = new javax.swing.JLabel();
        cell73 = new javax.swing.JLabel();
        cell81 = new javax.swing.JLabel();
        cell82 = new javax.swing.JLabel();
        cell83 = new javax.swing.JLabel();
        cell91 = new javax.swing.JLabel();
        cell92 = new javax.swing.JLabel();
        cell93 = new javax.swing.JLabel();
        block32 = new javax.swing.JPanel();
        cell74 = new javax.swing.JLabel();
        cell75 = new javax.swing.JLabel();
        cell76 = new javax.swing.JLabel();
        cell84 = new javax.swing.JLabel();
        cell85 = new javax.swing.JLabel();
        cell86 = new javax.swing.JLabel();
        cell94 = new javax.swing.JLabel();
        cell95 = new javax.swing.JLabel();
        cell96 = new javax.swing.JLabel();
        block33 = new javax.swing.JPanel();
        cell77 = new javax.swing.JLabel();
        cell78 = new javax.swing.JLabel();
        cell79 = new javax.swing.JLabel();
        cell87 = new javax.swing.JLabel();
        cell88 = new javax.swing.JLabel();
        cell89 = new javax.swing.JLabel();
        cell97 = new javax.swing.JLabel();
        cell98 = new javax.swing.JLabel();
        cell99 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        help = new javax.swing.JButton();
        statistics = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("sud");
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(795, 470));

        board.setBorder(new javax.swing.border.MatteBorder(null));
        board.setLayout(new java.awt.GridLayout(3, 3, 2, 2));

        block11.setBorder(new javax.swing.border.MatteBorder(null));
        block11.setMinimumSize(new java.awt.Dimension(152, 152));
        block11.setPreferredSize(new java.awt.Dimension(152, 152));
        block11.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        cell11.setBackground(new java.awt.Color(255, 255, 255));
        cell11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell11.setOpaque(true);
        cell11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block11.add(cell11);

        cell12.setBackground(new java.awt.Color(255, 255, 255));
        cell12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell12.setOpaque(true);
        cell12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block11.add(cell12);

        cell13.setBackground(new java.awt.Color(255, 255, 255));
        cell13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell13.setOpaque(true);
        cell13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block11.add(cell13);

        cell21.setBackground(new java.awt.Color(255, 255, 255));
        cell21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell21.setOpaque(true);
        cell21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block11.add(cell21);

        cell22.setBackground(new java.awt.Color(255, 255, 255));
        cell22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell22.setOpaque(true);
        cell22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block11.add(cell22);

        cell23.setBackground(new java.awt.Color(255, 255, 255));
        cell23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell23.setOpaque(true);
        cell23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block11.add(cell23);

        cell31.setBackground(new java.awt.Color(255, 255, 255));
        cell31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell31.setOpaque(true);
        cell31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block11.add(cell31);

        cell32.setBackground(new java.awt.Color(255, 255, 255));
        cell32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell32.setOpaque(true);
        cell32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block11.add(cell32);

        cell33.setBackground(new java.awt.Color(255, 255, 255));
        cell33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell33.setOpaque(true);
        cell33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block11.add(cell33);

        board.add(block11);

        block12.setBorder(new javax.swing.border.MatteBorder(null));
        block12.setMinimumSize(new java.awt.Dimension(10, 152));
        block12.setPreferredSize(new java.awt.Dimension(152, 152));
        block12.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        cell14.setBackground(new java.awt.Color(255, 255, 255));
        cell14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell14.setOpaque(true);
        cell14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block12.add(cell14);

        cell15.setBackground(new java.awt.Color(255, 255, 255));
        cell15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell15.setOpaque(true);
        cell15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block12.add(cell15);

        cell16.setBackground(new java.awt.Color(255, 255, 255));
        cell16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell16.setOpaque(true);
        cell16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block12.add(cell16);

        cell24.setBackground(new java.awt.Color(255, 255, 255));
        cell24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell24.setOpaque(true);
        cell24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block12.add(cell24);

        cell25.setBackground(new java.awt.Color(255, 255, 255));
        cell25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell25.setOpaque(true);
        cell25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block12.add(cell25);

        cell26.setBackground(new java.awt.Color(255, 255, 255));
        cell26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell26.setOpaque(true);
        cell26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block12.add(cell26);

        cell34.setBackground(new java.awt.Color(255, 255, 255));
        cell34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell34.setOpaque(true);
        cell34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block12.add(cell34);

        cell35.setBackground(new java.awt.Color(255, 255, 255));
        cell35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell35.setOpaque(true);
        cell35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block12.add(cell35);

        cell36.setBackground(new java.awt.Color(255, 255, 255));
        cell36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell36.setOpaque(true);
        cell36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block12.add(cell36);

        board.add(block12);

        block13.setBorder(new javax.swing.border.MatteBorder(null));
        block13.setMinimumSize(new java.awt.Dimension(152, 152));
        block13.setPreferredSize(new java.awt.Dimension(152, 152));
        block13.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        cell17.setBackground(new java.awt.Color(255, 255, 255));
        cell17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell17.setOpaque(true);
        cell17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block13.add(cell17);

        cell18.setBackground(new java.awt.Color(255, 255, 255));
        cell18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell18.setOpaque(true);
        cell18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block13.add(cell18);

        cell19.setBackground(new java.awt.Color(255, 255, 255));
        cell19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell19.setOpaque(true);
        cell19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block13.add(cell19);

        cell27.setBackground(new java.awt.Color(255, 255, 255));
        cell27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell27.setOpaque(true);
        cell27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block13.add(cell27);

        cell28.setBackground(new java.awt.Color(255, 255, 255));
        cell28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell28.setOpaque(true);
        cell28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block13.add(cell28);

        cell29.setBackground(new java.awt.Color(255, 255, 255));
        cell29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell29.setOpaque(true);
        cell29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block13.add(cell29);

        cell37.setBackground(new java.awt.Color(255, 255, 255));
        cell37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell37.setOpaque(true);
        cell37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block13.add(cell37);

        cell38.setBackground(new java.awt.Color(255, 255, 255));
        cell38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell38.setOpaque(true);
        cell38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block13.add(cell38);

        cell39.setBackground(new java.awt.Color(255, 255, 255));
        cell39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell39.setOpaque(true);
        cell39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block13.add(cell39);

        board.add(block13);

        block21.setBorder(new javax.swing.border.MatteBorder(null));
        block21.setMinimumSize(new java.awt.Dimension(152, 152));
        block21.setPreferredSize(new java.awt.Dimension(152, 152));
        block21.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        cell41.setBackground(new java.awt.Color(255, 255, 255));
        cell41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell41.setOpaque(true);
        cell41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block21.add(cell41);

        cell42.setBackground(new java.awt.Color(255, 255, 255));
        cell42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell42.setOpaque(true);
        cell42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block21.add(cell42);

        cell43.setBackground(new java.awt.Color(255, 255, 255));
        cell43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell43.setOpaque(true);
        cell43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block21.add(cell43);

        cell51.setBackground(new java.awt.Color(255, 255, 255));
        cell51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell51.setOpaque(true);
        cell51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block21.add(cell51);

        cell52.setBackground(new java.awt.Color(255, 255, 255));
        cell52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell52.setOpaque(true);
        cell52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block21.add(cell52);

        cell53.setBackground(new java.awt.Color(255, 255, 255));
        cell53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell53.setOpaque(true);
        cell53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block21.add(cell53);

        cell61.setBackground(new java.awt.Color(255, 255, 255));
        cell61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell61.setOpaque(true);
        cell61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block21.add(cell61);

        cell62.setBackground(new java.awt.Color(255, 255, 255));
        cell62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell62.setOpaque(true);
        cell62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block21.add(cell62);

        cell63.setBackground(new java.awt.Color(255, 255, 255));
        cell63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell63.setOpaque(true);
        cell63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block21.add(cell63);

        board.add(block21);

        block22.setBorder(new javax.swing.border.MatteBorder(null));
        block22.setMinimumSize(new java.awt.Dimension(152, 152));
        block22.setPreferredSize(new java.awt.Dimension(152, 152));
        block22.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        cell44.setBackground(new java.awt.Color(255, 255, 255));
        cell44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell44.setOpaque(true);
        cell44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block22.add(cell44);

        cell45.setBackground(new java.awt.Color(255, 255, 255));
        cell45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell45.setOpaque(true);
        cell45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block22.add(cell45);

        cell46.setBackground(new java.awt.Color(255, 255, 255));
        cell46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell46.setOpaque(true);
        cell46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block22.add(cell46);

        cell54.setBackground(new java.awt.Color(255, 255, 255));
        cell54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell54.setOpaque(true);
        cell54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block22.add(cell54);

        cell55.setBackground(new java.awt.Color(255, 255, 255));
        cell55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell55.setOpaque(true);
        cell55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block22.add(cell55);

        cell56.setBackground(new java.awt.Color(255, 255, 255));
        cell56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell56.setOpaque(true);
        cell56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block22.add(cell56);

        cell64.setBackground(new java.awt.Color(255, 255, 255));
        cell64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell64.setOpaque(true);
        cell64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block22.add(cell64);

        cell65.setBackground(new java.awt.Color(255, 255, 255));
        cell65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell65.setOpaque(true);
        cell65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block22.add(cell65);

        cell66.setBackground(new java.awt.Color(255, 255, 255));
        cell66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell66.setOpaque(true);
        cell66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block22.add(cell66);

        board.add(block22);

        block23.setBorder(new javax.swing.border.MatteBorder(null));
        block23.setMinimumSize(new java.awt.Dimension(152, 152));
        block23.setPreferredSize(new java.awt.Dimension(152, 152));
        block23.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        cell47.setBackground(new java.awt.Color(255, 255, 255));
        cell47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell47.setOpaque(true);
        cell47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block23.add(cell47);

        cell48.setBackground(new java.awt.Color(255, 255, 255));
        cell48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell48.setOpaque(true);
        cell48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block23.add(cell48);

        cell49.setBackground(new java.awt.Color(255, 255, 255));
        cell49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell49.setOpaque(true);
        cell49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block23.add(cell49);

        cell57.setBackground(new java.awt.Color(255, 255, 255));
        cell57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell57.setOpaque(true);
        cell57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block23.add(cell57);

        cell58.setBackground(new java.awt.Color(255, 255, 255));
        cell58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell58.setOpaque(true);
        cell58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block23.add(cell58);

        cell59.setBackground(new java.awt.Color(255, 255, 255));
        cell59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell59.setOpaque(true);
        cell59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block23.add(cell59);

        cell67.setBackground(new java.awt.Color(255, 255, 255));
        cell67.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell67.setOpaque(true);
        cell67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block23.add(cell67);

        cell68.setBackground(new java.awt.Color(255, 255, 255));
        cell68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell68.setOpaque(true);
        cell68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block23.add(cell68);

        cell69.setBackground(new java.awt.Color(255, 255, 255));
        cell69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell69.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell69.setOpaque(true);
        cell69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block23.add(cell69);

        board.add(block23);

        block31.setBorder(new javax.swing.border.MatteBorder(null));
        block31.setMinimumSize(new java.awt.Dimension(152, 152));
        block31.setPreferredSize(new java.awt.Dimension(152, 152));
        block31.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        cell71.setBackground(new java.awt.Color(255, 255, 255));
        cell71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell71.setOpaque(true);
        cell71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block31.add(cell71);

        cell72.setBackground(new java.awt.Color(255, 255, 255));
        cell72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell72.setOpaque(true);
        cell72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block31.add(cell72);

        cell73.setBackground(new java.awt.Color(255, 255, 255));
        cell73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell73.setOpaque(true);
        cell73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block31.add(cell73);

        cell81.setBackground(new java.awt.Color(255, 255, 255));
        cell81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell81.setOpaque(true);
        cell81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block31.add(cell81);

        cell82.setBackground(new java.awt.Color(255, 255, 255));
        cell82.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell82.setOpaque(true);
        cell82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block31.add(cell82);

        cell83.setBackground(new java.awt.Color(255, 255, 255));
        cell83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell83.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell83.setOpaque(true);
        cell83.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block31.add(cell83);

        cell91.setBackground(new java.awt.Color(255, 255, 255));
        cell91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell91.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell91.setOpaque(true);
        cell91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block31.add(cell91);

        cell92.setBackground(new java.awt.Color(255, 255, 255));
        cell92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell92.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell92.setOpaque(true);
        cell92.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block31.add(cell92);

        cell93.setBackground(new java.awt.Color(255, 255, 255));
        cell93.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell93.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell93.setOpaque(true);
        cell93.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block31.add(cell93);

        board.add(block31);

        block32.setBorder(new javax.swing.border.MatteBorder(null));
        block32.setMinimumSize(new java.awt.Dimension(152, 152));
        block32.setPreferredSize(new java.awt.Dimension(152, 152));
        block32.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        cell74.setBackground(new java.awt.Color(255, 255, 255));
        cell74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell74.setOpaque(true);
        cell74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block32.add(cell74);

        cell75.setBackground(new java.awt.Color(255, 255, 255));
        cell75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell75.setOpaque(true);
        cell75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block32.add(cell75);

        cell76.setBackground(new java.awt.Color(255, 255, 255));
        cell76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell76.setOpaque(true);
        cell76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block32.add(cell76);

        cell84.setBackground(new java.awt.Color(255, 255, 255));
        cell84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell84.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell84.setOpaque(true);
        cell84.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block32.add(cell84);

        cell85.setBackground(new java.awt.Color(255, 255, 255));
        cell85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell85.setOpaque(true);
        cell85.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block32.add(cell85);

        cell86.setBackground(new java.awt.Color(255, 255, 255));
        cell86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell86.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell86.setOpaque(true);
        cell86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block32.add(cell86);

        cell94.setBackground(new java.awt.Color(255, 255, 255));
        cell94.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell94.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell94.setOpaque(true);
        cell94.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block32.add(cell94);

        cell95.setBackground(new java.awt.Color(255, 255, 255));
        cell95.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell95.setOpaque(true);
        cell95.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block32.add(cell95);

        cell96.setBackground(new java.awt.Color(255, 255, 255));
        cell96.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell96.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell96.setOpaque(true);
        cell96.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block32.add(cell96);

        board.add(block32);

        block33.setBorder(new javax.swing.border.MatteBorder(null));
        block33.setMinimumSize(new java.awt.Dimension(152, 152));
        block33.setPreferredSize(new java.awt.Dimension(152, 152));
        block33.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        cell77.setBackground(new java.awt.Color(255, 255, 255));
        cell77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell77.setOpaque(true);
        cell77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block33.add(cell77);

        cell78.setBackground(new java.awt.Color(255, 255, 255));
        cell78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell78.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell78.setOpaque(true);
        cell78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block33.add(cell78);

        cell79.setBackground(new java.awt.Color(255, 255, 255));
        cell79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell79.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell79.setOpaque(true);
        cell79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block33.add(cell79);

        cell87.setBackground(new java.awt.Color(255, 255, 255));
        cell87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell87.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell87.setOpaque(true);
        cell87.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block33.add(cell87);

        cell88.setBackground(new java.awt.Color(255, 255, 255));
        cell88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell88.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell88.setOpaque(true);
        cell88.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block33.add(cell88);

        cell89.setBackground(new java.awt.Color(255, 255, 255));
        cell89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell89.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell89.setOpaque(true);
        cell89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block33.add(cell89);

        cell97.setBackground(new java.awt.Color(255, 255, 255));
        cell97.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell97.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell97.setOpaque(true);
        cell97.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block33.add(cell97);

        cell98.setBackground(new java.awt.Color(255, 255, 255));
        cell98.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell98.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell98.setOpaque(true);
        cell98.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block33.add(cell98);

        cell99.setBackground(new java.awt.Color(255, 255, 255));
        cell99.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cell99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cell99.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cell99.setOpaque(true);
        cell99.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInLabel(evt);
            }
        });
        block33.add(cell99);

        board.add(block33);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("1");
        jButton1.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton1.setRequestFocusEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("2");
        jButton2.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton2.setRequestFocusEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("3");
        jButton3.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton3.setRequestFocusEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("4");
        jButton4.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton4.setRequestFocusEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("5");
        jButton5.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton5.setRequestFocusEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("6");
        jButton6.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton6.setRequestFocusEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("7");
        jButton7.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton7.setRequestFocusEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("8");
        jButton8.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton8.setRequestFocusEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton9.setText("9");
        jButton9.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton9.setRequestFocusEnabled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        help.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        help.setText("Help");
        help.setPreferredSize(new java.awt.Dimension(40, 40));
        help.setRequestFocusEnabled(false);

        statistics.setText("Statistics");
        statistics.setPreferredSize(new java.awt.Dimension(40, 40));

        exit.setText("Exit");
        exit.setPreferredSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(board, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(help, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(statistics, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(board, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(statistics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(help, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clickInLabel(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickInLabel
        // TODO add your handling code here:
        Object cell = evt.getSource();
        if (!"0".equals(buttonClicked) && cell instanceof JLabel && !immutableLabels.containsValue(cell))
            ((JLabel) cell).setText(buttonClicked);
        
    }//GEN-LAST:event_clickInLabel

    private void buttonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClicked
        // TODO add your handling code here:
        Object cell = evt.getSource();
        buttonClicked = ((javax.swing.JButton) cell).getText();
    }//GEN-LAST:event_buttonClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Sudoku dialog = new Sudoku(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel block11;
    private javax.swing.JPanel block12;
    private javax.swing.JPanel block13;
    private javax.swing.JPanel block21;
    private javax.swing.JPanel block22;
    private javax.swing.JPanel block23;
    private javax.swing.JPanel block31;
    private javax.swing.JPanel block32;
    private javax.swing.JPanel block33;
    private javax.swing.JPanel board;
    private javax.swing.JLabel cell11;
    private javax.swing.JLabel cell12;
    private javax.swing.JLabel cell13;
    private javax.swing.JLabel cell14;
    private javax.swing.JLabel cell15;
    private javax.swing.JLabel cell16;
    private javax.swing.JLabel cell17;
    private javax.swing.JLabel cell18;
    private javax.swing.JLabel cell19;
    private javax.swing.JLabel cell21;
    private javax.swing.JLabel cell22;
    private javax.swing.JLabel cell23;
    private javax.swing.JLabel cell24;
    private javax.swing.JLabel cell25;
    private javax.swing.JLabel cell26;
    private javax.swing.JLabel cell27;
    private javax.swing.JLabel cell28;
    private javax.swing.JLabel cell29;
    private javax.swing.JLabel cell31;
    private javax.swing.JLabel cell32;
    private javax.swing.JLabel cell33;
    private javax.swing.JLabel cell34;
    private javax.swing.JLabel cell35;
    private javax.swing.JLabel cell36;
    private javax.swing.JLabel cell37;
    private javax.swing.JLabel cell38;
    private javax.swing.JLabel cell39;
    private javax.swing.JLabel cell41;
    private javax.swing.JLabel cell42;
    private javax.swing.JLabel cell43;
    private javax.swing.JLabel cell44;
    private javax.swing.JLabel cell45;
    private javax.swing.JLabel cell46;
    private javax.swing.JLabel cell47;
    private javax.swing.JLabel cell48;
    private javax.swing.JLabel cell49;
    private javax.swing.JLabel cell51;
    private javax.swing.JLabel cell52;
    private javax.swing.JLabel cell53;
    private javax.swing.JLabel cell54;
    private javax.swing.JLabel cell55;
    private javax.swing.JLabel cell56;
    private javax.swing.JLabel cell57;
    private javax.swing.JLabel cell58;
    private javax.swing.JLabel cell59;
    private javax.swing.JLabel cell61;
    private javax.swing.JLabel cell62;
    private javax.swing.JLabel cell63;
    private javax.swing.JLabel cell64;
    private javax.swing.JLabel cell65;
    private javax.swing.JLabel cell66;
    private javax.swing.JLabel cell67;
    private javax.swing.JLabel cell68;
    private javax.swing.JLabel cell69;
    private javax.swing.JLabel cell71;
    private javax.swing.JLabel cell72;
    private javax.swing.JLabel cell73;
    private javax.swing.JLabel cell74;
    private javax.swing.JLabel cell75;
    private javax.swing.JLabel cell76;
    private javax.swing.JLabel cell77;
    private javax.swing.JLabel cell78;
    private javax.swing.JLabel cell79;
    private javax.swing.JLabel cell81;
    private javax.swing.JLabel cell82;
    private javax.swing.JLabel cell83;
    private javax.swing.JLabel cell84;
    private javax.swing.JLabel cell85;
    private javax.swing.JLabel cell86;
    private javax.swing.JLabel cell87;
    private javax.swing.JLabel cell88;
    private javax.swing.JLabel cell89;
    private javax.swing.JLabel cell91;
    private javax.swing.JLabel cell92;
    private javax.swing.JLabel cell93;
    private javax.swing.JLabel cell94;
    private javax.swing.JLabel cell95;
    private javax.swing.JLabel cell96;
    private javax.swing.JLabel cell97;
    private javax.swing.JLabel cell98;
    private javax.swing.JLabel cell99;
    private javax.swing.JButton exit;
    private javax.swing.JButton help;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton statistics;
    // End of variables declaration//GEN-END:variables
}
