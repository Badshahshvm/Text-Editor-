package NotepadApp.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.now;


public class NotePad implements ActionListener {
    JFrame jf,ff;
    JTextArea ja;
    JScrollPane js;
    JMenuBar jmb;
    JMenu jm1,jm2,jm22,jm3;
    JMenuItem m1,m2,m3,m4,m5,m6,m7,m8,m11,
            m12,m13,m14,m15,m16,m17,m18,m19,m20,m21,m22,m23,m24 ,//for second menu(edit)
            m25,m26,m28,m29,m30;//for third menu(View)
    File file;
    String title="Untitled-Notepad";
    JFileChooser jfc;
    JComboBox ff1,cs,cb;
    JButton fb;
    JCheckBoxMenuItem m27;
    public NotePad()
    {
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//for attractive look...of game..//this is added for the purpose of looks attractive according to our windows...
        }
        catch(Exception e)

        {
            System.out.println(e);
        }
        jf=new JFrame(title);
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icon=Toolkit.getDefaultToolkit().getImage("src/notepad_png.jpg");
        jf.setIconImage(icon);
        jmb=new JMenuBar();
        jf.setJMenuBar(jmb);
        jm1=new JMenu("File");
        jmb.add(jm1);

        m1=new JMenuItem("New tab");
        m1.addActionListener(this);
        jm1.add(m1);
          m1.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
        m2=new JMenuItem("New window");
        m2.addActionListener(this);
        jm1.add(m2);
          m2.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
        m3=new JMenuItem("Open");
        m3.addActionListener(this);
        jm1.add(m3);
        m3.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
        m4=new JMenuItem("Save");
        m4.addActionListener(this);
        jm1.add(m4);
        m4.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
        m5=new JMenuItem("Save as");
        m5.addActionListener(this);
        jm1.add(m5);
        m6=new JMenuItem("Save all");
        m6.addActionListener(this);

        jm1.add(m6);
        jm1.addSeparator();
        m7=new JMenuItem("Page setup");
        m7.addActionListener(this);
        jm1.add(m7);
        m8=new JMenuItem("Print");
        m8.addActionListener(this);
        jm1.addSeparator();
        jm1.add(m8);
        m8.setAccelerator(KeyStroke.getKeyStroke('P', InputEvent.CTRL_DOWN_MASK));
        m11=new JMenuItem("Exit");
        m11.addActionListener(this);
        jm1.add(m11);
        jm2=new JMenu("Edit");
        jmb.add(jm2);
         jm22=new JMenu("Format" );
         jmb.add(jm22);
         jm3=new JMenu("View");
         jmb.add(jm3);
        m12=new JMenuItem("Undo");
        m12.addActionListener(this);

        jm2.add(m12);
        m12.setAccelerator(KeyStroke.getKeyStroke('U', InputEvent.CTRL_DOWN_MASK));
        jm2.addSeparator();
        m13=new JMenuItem("Cut");
        m13.addActionListener(this);
        jm2.add(m13);
        m13.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.CTRL_DOWN_MASK));
        m14=new JMenuItem("Copy");
        m14.addActionListener(this);
        jm2.add(m14);
        m14.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_DOWN_MASK));
        m15=new JMenuItem("Paste");
        m15.addActionListener(this);
        jm2.add(m15);
        m15.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_DOWN_MASK));
        m16=new JMenuItem("Delete");
        m16.addActionListener(this);
        jm2.addSeparator();
        jm2.add(m16);
        m17=new JMenuItem("Find");
        m17.addActionListener(this);
        jm2.add(m17);
        m17.setAccelerator(KeyStroke.getKeyStroke('F', InputEvent.CTRL_DOWN_MASK));
        m18=new JMenuItem("Find next");
        m18.addActionListener(this);
        jm2.add(m18);
        
        m19=new JMenuItem("Find previous");
        m19.addActionListener(this);
        jm2.add(m19);
        m20=new JMenuItem("Replace");
        m20.addActionListener(this);
        jm2.add(m20);
        m20.setAccelerator(KeyStroke.getKeyStroke('H', InputEvent.CTRL_DOWN_MASK));
        m21=new JMenuItem("Go to");
        m21.addActionListener(this);
        jm2.addSeparator();
        jm2.add(m21);
        m22=new JMenuItem("Select all");
        m22.addActionListener(this);
        jm2.add(m22);
        m23=new JMenuItem("Time/Date");
        m23.addActionListener(this);
        jm2.addSeparator();
        jm2.add(m23);
        m24=new JMenuItem("Font...");

        m24.addActionListener(this);
        jm22.add(m24);
        jm22.addSeparator();


        m25=new JMenuItem("Zoom");
        m25.addActionListener(this);
        jm3.add(m25);
        m26=new JMenuItem("Status bar");
        m26.addActionListener(this);
        jm3.add(m26);
        m27=new JCheckBoxMenuItem("Word wrap");
        m27.addActionListener(this);
        jm3.add(m27);
        m28=new JMenuItem("Font-color");
        m28.addActionListener(this);
        jm22.add(m28);
        m29=new JMenuItem("Textarea color");
        m29.addActionListener(this);
        jm22.add(m29);
        ja=new JTextArea();
        js=new JScrollPane(ja);
        js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jf.add(js);



        jf.setVisible(true);
    }
     public void actionPerformed(ActionEvent e)
     {
         jfc=new JFileChooser();
if(e.getSource()==m1)
             {
  newNotepad();
          }
if(e.getSource()==m11)
{
    System.exit(0);
}
if(e.getSource()==m4)
{
save();
}
if(e.getSource()==m5)
{
    saveAs();
}
if(e.getSource()==m3)
{
    open();
}
if(e.getSource()==m7)
{
    pageSetup();
}
if(e.getSource()==m8)
{
    print();
}
if(e.getSource()==m20)
{

}
if(e.getSource()==m13)
{
    ja.cut();
}
if(e.getSource()==m14)
{
    ja.copy();
}
if(e.getSource()==m15)
{
    ja.paste();
}
if(e.getSource()==m23)
{
    setDateTime();
}
if(e.getSource()==m24)                  //font
{
                 openFont();
}
if(e.getSource()==fb)
{
    setFont();
}
if(e.getSource()==m28)              //font-color
{
                 setFontColor();
}
if(e.getSource()==m29)                  //textArea color
{
              setTextColor();
}
if(e.getSource()==m27)
{
    boolean b=m27.getState();
    ja.setLineWrap(b);
}
     }
     void open()
     {

          try
          {
              int i=jfc.showOpenDialog(jf);
              if(i==0)
              {
                  ja.setText(" ");
                  FileInputStream fis=new FileInputStream(jfc.getSelectedFile());
                 int j;
                  while((j=fis.read()) !=-1)
                  {
                      ja.append(String.valueOf((char)j));
                  }
                  fis.close();
                  setTitle(jfc.getSelectedFile().getName());
              }
          }
          catch(Exception e)
          {
              System.out.println(e);
          }
     }
    public void save()
     {

         if(jf.getTitle().equals(title))
         {
             saveAs();
         }
         else {

           try
           {
               String t=ja.getText();
               byte[] b=t.getBytes();


               FileOutputStream fs=new FileOutputStream(file);
               fs.write(b);
           }
           catch(Exception e)
           {
               System.out.println(e);
           }
         }
     }
     public void newNotepad()
     {
         String s=ja.getText();
         if(!s.equals(" "))
         {
             int i=JOptionPane.showConfirmDialog(jf,"Do you want to save thi file");
             if(i==0)
             {
                 saveAs();
                 if(jf.getTitle().equals(title))
                 {
                     setTitle(title);
                     ja.setText(" ");
                 }
                 setTitle(title);
                 ja.setText(" ");
             }
             else if(i==1)
             {
                 ja.setText(" ");
             }
         }
     }

     public void saveAs()
     {
          jfc=new JFileChooser();
         int i=jfc.showSaveDialog(jf);// open the box where u want to save document
         if(i==0)
         {
             try
             {
                 String t=ja.getText();
                 byte[] b=t.getBytes();
                 file=jfc.getSelectedFile(); // set the file..
                 System.out.println(file);//print the path o document.. where do we save
                 System.out.println(file.getName());//print the name of save file
                 FileOutputStream fs=new FileOutputStream(file);
                 fs.write(b);
                 setTitle(file.getName()); // show the title of notepad in the upper side of menubar
             }
             catch(Exception e)
             {
                 System.out.println(e);
             }
         }
         else {
             JOptionPane.showMessageDialog(jf, "You didn't save the file..","file not Saved", JOptionPane.WARNING_MESSAGE);
         }
     }
public void pageSetup()
{
    PrinterJob pj = PrinterJob.getPrinterJob();
    PageFormat pf = pj.pageDialog(pj.defaultPage());
}
public void print()
{
    PrinterJob pj = PrinterJob.getPrinterJob();

    if (pj.printDialog())
    {
        try {pj.print();
        }
        catch (PrinterException exc)
        {
            System.out.println(exc);
        }
    }
}
public void replace()
{
    
}
public void setDateTime()
{
  LocalDateTime ldt=LocalDateTime.now();
   String dateTime=ldt.format(DateTimeFormatter.ISO_DATE_TIME)   ;
   ja.append(dateTime);


}
public void openFont()
{
                  ff=new JFrame("Font");
                    ff.setSize(650,300);
                    ff.setLayout(null);


                    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                    String []fontFamilies = ge.getAvailableFontFamilyNames();
                     ff1=new JComboBox(fontFamilies);
                    ff1.setBounds(30,50,200,40);
                    ff.add(ff1);
                    String[] fontStyle={"Plain", "Bold","Italic"};
                   cb=new JComboBox(fontStyle);
                   cb.setBounds(250,50,100,40);
                   ff.add(cb);
                   Integer[] fs={10, 12, 14, 16, 20, 24, 28, 32, 40, 50};
                    cs=new JComboBox(fs);
                   cs.setBounds(450,50,80,40);
                   ff.add(cs);
                   fb=new JButton("Ok");
                   fb.setBounds(250,150,80,50);
                   ff.add(fb);
                   fb.addActionListener(this);
                   ff.setVisible(true);
}
public void setFont()
{
                   String s=(String)ff1.getSelectedItem();
                   String fontS=(String)cb.getSelectedItem();
                   Integer fs=  (Integer)cs.getSelectedItem();

                   int fsi=0;
                   if(fs.equals("Plain"))
                   {
                                fsi=Font.PLAIN;
                                
                   }
                   else if(fs.equals("Bold"))
                   {
                       fsi=Font.BOLD;
                   }
                   else if(fs.equals("Italic")) {
                       fsi=Font.ITALIC;
                   }
                   Font f=new Font(s,fsi,fs);
                   ja.setFont(f);
                   ff.setVisible(false);
}
public void setFontColor()
{
    Color c=JColorChooser.showDialog(jf,"select the color", Color.red);
    ja.setForeground(c);
}
public void setTextColor() {
    Color x = JColorChooser.showDialog(jf, "select the color", Color.white);
    ja.setBackground(x);
}
public void wordWrap()
{

}
     public void setTitle(String title)
     {
         jf.setTitle(title);
     }

}
