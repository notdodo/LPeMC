package Test;

import Generics.Node;
import Grammar.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultEditorKit;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;

public class TestGUI extends JFrame {

    private static JTextArea jTypeCheckArea, jCodeGenArea, jOutputTextArea;
    private JTextArea jInputTextArea;
    private static String pathInputFile_, fileNameOutput_;
    private JButton jStartByFileButton, jSaveFileInputedButton,
            jStartFromTextAreaButton, jDeleteAllButton;
    private JMenuItem jStartByFileItemMenu, jStartByTextAreaItemMenu;
    private Container contentPane;
    private static JTree jTree;
    private static DefaultMutableTreeNode root;
    private static DefaultTreeModel treeModel;
    private JScrollPane jInputTextAreaScrollPane;

    public static void main(String[] args) throws Exception {
        JFrame frame = new TestGUI();
        frame.setVisible(true);
    }

    @Override
    protected void frameInit() {
        super.frameInit();
        setSize(1200, 750);
        setLocation(30, 20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("AST View");
        contentPane = getContentPane();
        insetConfigMenuBar();
        insertTree();
        insertPanel();
        insertConfigButtons();
    }

    public void insertTree() {
        //Creo l'albero
        jTree = new JTree();
        jTree.setRootVisible(true);
        jTree.setEditable(false);
        //Creo il modello dell'albero
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("AST Root");
        jTree.setModel(new DefaultTreeModel(rootNode));
        treeModel = (DefaultTreeModel) jTree.getModel();
        root = (DefaultMutableTreeNode) treeModel.getRoot();
    }

    public void insertPanel() {
        //Creo i textArea
        jTypeCheckArea = new JTextArea();
        jCodeGenArea = new JTextArea();
//        jCodeGenArea.setEditable(false);
        jOutputTextArea = new JTextArea();
        jOutputTextArea.setEditable(false);
        jInputTextArea = new JTextArea();

        JScrollPane jTreeScrollPane = new JScrollPane(jTree);
        jTreeScrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("AST tree"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        JScrollPane jTypeCheckAreaScrollPane = new JScrollPane(jTypeCheckArea);
        jTypeCheckAreaScrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Type Check"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        JScrollPane jCodeGenAreaScrollPane = new JScrollPane(jCodeGenArea);
        jCodeGenAreaScrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Code Gen"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        JScrollPane jOutputTextAreaScrollPane = new JScrollPane(jOutputTextArea);
        jOutputTextAreaScrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Output"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        jInputTextAreaScrollPane = new JScrollPane(jInputTextArea);
        jInputTextAreaScrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Input Text"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        JSplitPane jSplitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jSplitPane2.setOneTouchExpandable(true);
        jSplitPane2.setDividerLocation(getHeight() / 4);
        jSplitPane2.setTopComponent(jTypeCheckAreaScrollPane);
        jSplitPane2.setBottomComponent(jCodeGenAreaScrollPane);

        JSplitPane jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jSplitPane1.setOneTouchExpandable(true);
        jSplitPane1.setDividerLocation(getWidth() / 4);
        jSplitPane1.setTopComponent(jTreeScrollPane);
        jSplitPane1.setRightComponent(jSplitPane2);

        JSplitPane jSplitPane3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        jSplitPane3.setOneTouchExpandable(true);
        jSplitPane3.setDividerLocation(getHeight() / 2);
        jSplitPane3.setTopComponent(jSplitPane1);
        jSplitPane3.setBottomComponent(jOutputTextAreaScrollPane);
        jSplitPane3.setBottomComponent(jInputTextAreaScrollPane);

        JSplitPane jSplitPane4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jSplitPane4.setOneTouchExpandable(true);
        jSplitPane4.setDividerLocation((getWidth() / 2) + 200);
        jSplitPane4.setTopComponent(jSplitPane3);
        jSplitPane4.setBottomComponent(jOutputTextAreaScrollPane);

//        jSplitPane1.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createTitledBorder("jSplitPane1"),
//                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
//        jSplitPane2.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createTitledBorder("jSplitPane2"),
//                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
//        jSplitPane3.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createTitledBorder("jSplitPane3"),
//                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
//        jSplitPane4.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createTitledBorder("jSplitPane4"),
//                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        Dimension minimumSize = new Dimension(100, 50);
        jTypeCheckAreaScrollPane.setMinimumSize(minimumSize);
        jTreeScrollPane.setMinimumSize(minimumSize);
        jCodeGenAreaScrollPane.setMinimumSize(minimumSize);
        jOutputTextAreaScrollPane.setMinimumSize(minimumSize);
        jInputTextAreaScrollPane.setMinimumSize(minimumSize);

        jInputTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                jDeleteAllButton.setEnabled(true);
                jStartFromTextAreaButton.setEnabled(true);
                jStartByFileButton.setEnabled(false);
                jStartByTextAreaItemMenu.setEnabled(true);
            }
        });

        // Add the split pane to this panel.
        contentPane.add(jSplitPane4, BorderLayout.CENTER);
    }

    public void insetConfigMenuBar() {
        JMenuItem jOpenFileItemMenu = new JMenuItem("Open input file...");
        jOpenFileItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                deleteAll(true);
                openFile();
//                startByOpenFile();
            }
        }
        );

        jStartByFileItemMenu = new JMenuItem("Start from the input file");
        jStartByFileItemMenu.setEnabled(false);
        jStartByFileItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                startByOpenFile();
                jStartByFileButton.setEnabled(false);
                jStartByFileItemMenu.setEnabled(false);
            }
        }
        );

        jStartByTextAreaItemMenu = new JMenuItem("Start from the input text");
        jStartByTextAreaItemMenu.setEnabled(false);
        jStartByTextAreaItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                startByTextArea();
                jStartByFileButton.setEnabled(false);
                jStartByFileItemMenu.setEnabled(false);
                jStartFromTextAreaButton.setEnabled(false);
                jStartByTextAreaItemMenu.setEnabled(false);
            }
        }
        );

        JMenuItem jQuitItemMenu = new JMenuItem("Quit");
        jQuitItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        }
        );

        JMenuItem jEditMunuItem = null;
        JMenu jEditMenu = new JMenu("Edit");
        jEditMenu.setMnemonic(KeyEvent.VK_E);

        jEditMunuItem = new JMenuItem(new DefaultEditorKit.CutAction());
        jEditMunuItem.setText("Cut");
        jEditMunuItem.setMnemonic(KeyEvent.VK_X);
        jEditMunuItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        jEditMenu.add(jEditMunuItem);

        jEditMunuItem = new JMenuItem(new DefaultEditorKit.CopyAction());
        jEditMunuItem.setText("Copy");
        jEditMunuItem.setMnemonic(KeyEvent.VK_C);
        jEditMunuItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        jEditMenu.add(jEditMunuItem);

        jEditMunuItem = new JMenuItem(new DefaultEditorKit.PasteAction());
        jEditMunuItem.setText("Paste");
        jEditMunuItem.setMnemonic(KeyEvent.VK_V);
        jEditMunuItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        jEditMenu.add(jEditMunuItem);

        JMenu jOptionsMenu = new JMenu("Options");
        jOptionsMenu.add(jOpenFileItemMenu);
        jOptionsMenu.addSeparator();
        jOptionsMenu.add(jStartByFileItemMenu);
        jOptionsMenu.add(jStartByTextAreaItemMenu);
        jOptionsMenu.addSeparator();
        jOptionsMenu.add(jQuitItemMenu);

        jOptionsMenu.setMnemonic(KeyEvent.VK_O);
        jOpenFileItemMenu.setMnemonic(KeyEvent.VK_F);
        jStartByFileItemMenu.setMnemonic(KeyEvent.VK_S);
        jStartByTextAreaItemMenu.setMnemonic(KeyEvent.VK_SPACE);
        jQuitItemMenu.setMnemonic(KeyEvent.VK_Q);

        JMenuBar jMainMenuBar = new JMenuBar();
        jMainMenuBar.add(jOptionsMenu);
        jMainMenuBar.add(jEditMenu);
        setJMenuBar(jMainMenuBar);
    }

    public void insertConfigButtons() {
        JButton jQuitButton = new JButton("Quit");
        jQuitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        }
        );

        JButton jOpenFileButton = new JButton("Open input file");
        jOpenFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                deleteAll(true);
                openFile();
                //  startByOpenFile();
            }
        }
        );

        jStartByFileButton = new JButton("Start from the input file");
        jStartByFileButton.setEnabled(false);
        jStartByFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                startByOpenFile();
                jStartByFileButton.setEnabled(false);
                jStartByFileItemMenu.setEnabled(false);
                jStartFromTextAreaButton.setEnabled(false);
                jStartByTextAreaItemMenu.setEnabled(false);
            }
        }
        );

        jStartFromTextAreaButton = new JButton("Start from the input text");
        jStartFromTextAreaButton.setEnabled(false);
        jStartFromTextAreaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                startByTextArea();
                jStartByFileButton.setEnabled(false);
                jStartByFileItemMenu.setEnabled(false);
                jStartFromTextAreaButton.setEnabled(false);
                jStartByTextAreaItemMenu.setEnabled(false);
            }
        }
        );

        jDeleteAllButton = new JButton("Delete all");
        jDeleteAllButton.setEnabled(false);
        jDeleteAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                deleteAll(true);
            }
        }
        );

        jSaveFileInputedButton = new JButton("Save as file");
        jSaveFileInputedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Specify a file to save");
                fileChooser.setFileFilter(new FileNameExtensionFilter("Save output file: \"*.TXT\"", "txt"));
                fileChooser.setFileFilter(new FileNameExtensionFilter("Save output file: \"*.MF\"", "mf"));
                int userSelection = fileChooser.showSaveDialog(fileChooser);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                }
            }
        }
        );

        JButton jProvaButton = new JButton("InputCodGen");
        jProvaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    String asm_ = jCodeGenArea.getText();
                    File f = new File("");
                    FileWriter fstream;
                    fstream = new FileWriter(f.getCanonicalPath() + "/src/Test/PersonalOutputFile.asm");

                    try (BufferedWriter out = new BufferedWriter(fstream)) {
                        out.write(asm_);
                        out.close();
                    }
                    VMLexer lex = new VMLexer(new ANTLRFileStream(f.getCanonicalPath() + "/src/Test/PersonalOutputFile.asm"));
                    CommonTokenStream tokensVM = new CommonTokenStream(lex);
                    VMParser parserVM = new VMParser(tokensVM);
                    ExecuteVM vm = new ExecuteVM(parserVM.createCode());
                    vm.cpu();
                } catch (IOException ex) {
                    Logger.getLogger(TestGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(TestGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        JButton jProvaButton2 = new JButton("button2");
        jProvaButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (root.getChildCount() != 0) {
                    DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("gerChildCount");
                    root.insert(newNode, root.getChildCount());
                    treeModel.reload();
                }
            }
        }
        );

        JButton jProvaButton3 = new JButton("button3");
        jProvaButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt
            ) {
                DefaultMutableTreeNode selectedNode = ((DefaultMutableTreeNode) root.getLastLeaf());
                TreePath treePath = new TreePath(selectedNode.getPath());
                jTree.setSelectionPath(treePath);
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("getLastLeaf()");
                treeModel.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
                //      treeModel.reload();
            }
        }
        );

        JPanel jPanelFull = new JPanel();
        jPanelFull.add(jStartByFileButton);
        jPanelFull.add(jOpenFileButton);
        jPanelFull.add(jStartFromTextAreaButton);
        jPanelFull.add(jSaveFileInputedButton);
        jPanelFull.add(jDeleteAllButton);
        jPanelFull.add(jQuitButton);
        jPanelFull.add(jProvaButton);
        jPanelFull.add(jProvaButton2);
        jPanelFull.add(jProvaButton3);
        contentPane.add(jPanelFull, BorderLayout.AFTER_LAST_LINE);
    }

    public static void addNode(String nodeName_) {
        DefaultMutableTreeNode selectedNode = ((DefaultMutableTreeNode) root.getLastLeaf());
        TreePath treePath = new TreePath(selectedNode.getPath());
        jTree.setSelectionPath(treePath);
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(nodeName_);
//        treeModel.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
        treeModel.insertNodeInto(newNode, (MutableTreeNode) root.getRoot(), selectedNode.getChildCount());

//        root.add(new DefaultMutableTreeNode(nomeNodo));
//        treeModel.reload();
    }

    public static void appendCodeGenTextArea(String codeGenString_) {
        jCodeGenArea.append("\n" + codeGenString_);
    }

    public static void appendTypeCheckTextArea(String typeCheckString_) {
        jTypeCheckArea.append("\n" + typeCheckString_);
    }

    public static void appendOutputTextArea(String outputString_) {
        jOutputTextArea.append("\n" + outputString_);
        jOutputTextArea.setForeground(Color.BLACK);
        Font font = new Font("DejaVu Sans Mono", Font.BOLD, 10);
        jOutputTextArea.setFont(font);
    }

    private void openFile() {
        JFileChooser jFileChooser = new JFileChooser();
        File f = new File("");
        jFileChooser.setCurrentDirectory(new File(f.getAbsolutePath()));
        jFileChooser.setFileFilter(new FileNameExtensionFilter("Open input file: "
                + "\"*.TXT\", \"*.MF\"", "txt", "mf"));
        int returnVal = jFileChooser.showOpenDialog(jFileChooser);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            jStartByFileButton.setEnabled(true);
            jStartByFileItemMenu.setEnabled(true);
            jStartFromTextAreaButton.setEnabled(false);
            pathInputFile_ = jFileChooser.getSelectedFile().toString();
            fileNameOutput_ = jFileChooser.getSelectedFile().getName();
            jInputTextAreaScrollPane.setBorder(
                    BorderFactory.createTitledBorder("Input Text - Path file: \""
                            + pathInputFile_ + "\""));
            File name = new File(pathInputFile_);
            try {
                StringBuffer buffer;
                try (BufferedReader input = new BufferedReader(new FileReader(name))) {
                    buffer = new StringBuffer();
                    String text_;
                    while ((text_ = input.readLine()) != null) {
                        buffer.append(text_).append("\n");
                    }
                }
                System.out.println(buffer.toString());
                jDeleteAllButton.setEnabled(true);
                jInputTextArea.append(buffer.toString());
            } catch (IOException ioException) {
                Logger.getLogger(TestGUI.class.getName()).log(Level.SEVERE, null, ioException);
            }
        }
    }

    public void startByTextArea() {
        deleteAll(false);
        try {
            ANTLRStringStream input_ = new ANTLRStringStream(jInputTextArea.getText());
            MiniFunLexer lexer = new MiniFunLexer(input_);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MiniFunParser parser = new MiniFunParser(tokens);
            Node ast = parser.prog();

            System.out.println(ast.toPrint());
            appendOutputTextArea(ast.toPrint());

            System.out.println(ast.typeCheck());
            appendTypeCheckTextArea(ast.typeCheck());

            String asm_ = ast.codeGen();
            appendCodeGenTextArea(asm_);
            File f = new File("");
            FileWriter fstream = new FileWriter(f.getCanonicalPath()
                    + "/src/Test/PersonalOutputFile.asm");
            try (BufferedWriter out = new BufferedWriter(fstream)) {
                out.write(asm_);
                out.close();
            }

            VMLexer lex = new VMLexer(new ANTLRFileStream(f.getCanonicalPath()
                    + "/src/Test/PersonalOutputFile.asm"));
            CommonTokenStream tokensVM = new CommonTokenStream(lex);
            VMParser parserVM = new VMParser(tokensVM);
            ExecuteVM vm = new ExecuteVM(parserVM.createCode());
            vm.cpu();
        } catch (Exception ex) {
            Logger.getLogger(TestGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startByOpenFile() {
        deleteAll(false);
        try {
            ANTLRFileStream input = new ANTLRFileStream(pathInputFile_);
            MiniFunLexer lexer = new MiniFunLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MiniFunParser parser = new MiniFunParser(tokens);
            Node ast = parser.prog();

            System.out.println(ast.toPrint());
            appendOutputTextArea(ast.toPrint());

            System.out.println(ast.typeCheck());
            appendTypeCheckTextArea(ast.typeCheck());
//            if (ast.toPrint().contains("</ProgNode>")) {
////                jOutputTextArea.append("<html><font color='red'>This</font> is a "
////                        + "<font color='red'>test</font>!</html>");
//            }
            String asm_ = ast.codeGen();
            appendCodeGenTextArea(asm_);
            FileWriter fstream = new FileWriter(fileNameOutput_ + ".asm");
            try (BufferedWriter out = new BufferedWriter(fstream)) {
                out.write(asm_);
                out.close();
            }
            VMLexer lex = new VMLexer(new ANTLRFileStream(fileNameOutput_ + ".asm"));
            CommonTokenStream tokensVM = new CommonTokenStream(lex);
            VMParser parserVM = new VMParser(tokensVM);
            ExecuteVM vm = new ExecuteVM(parserVM.createCode());
            vm.cpu();
        } catch (Exception ex) {
            Logger.getLogger(TestGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteAll(boolean saveInputInfo) {
        if (saveInputInfo) {
            jInputTextArea.setText("");
            jInputTextAreaScrollPane.setBorder(
                    BorderFactory.createTitledBorder("Input Text"));
        }
        jOutputTextArea.setText("");
        jTypeCheckArea.setText("");
        jCodeGenArea.setText("");

        if (root.getChildCount() != 0) {
            root.removeAllChildren();
            treeModel.reload();
        }

        if (jOutputTextArea.getText().isEmpty()) {
            jDeleteAllButton.setEnabled(false);
            jStartByFileButton.setEnabled(false);
            jStartByFileItemMenu.setEnabled(false);
            jStartFromTextAreaButton.setEnabled(false);
            jStartByTextAreaItemMenu.setEnabled(false);
        } else {
            jDeleteAllButton.setEnabled(true);
        }
    }
}
