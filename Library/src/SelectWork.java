import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectWork extends JFrame {
    JButton technology = new JButton("技术人员");
    JButton administrative = new JButton("行政人员");
    JButton saleMan = new JButton("销售人员");
    public SelectWork(){
        JFrame jf = new JFrame("选择工种");
        jf.setSize(400,350);
        jf.setLocation(800,400);
        JPanel panel = new HomePanel();
        technology.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        jf.add(panel,BorderLayout.CENTER);
        panel.add(technology, BorderLayout.CENTER);
        panel.add(administrative,BorderLayout.CENTER);
        panel.add(saleMan,BorderLayout.CENTER);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SelectWork();
    }
}
class HomePanel extends JPanel {
    ImageIcon icon;
    Image img;
    public HomePanel() {
        //  /img/HomeImg.jpg 是存放在你正在编写的项目的bin文件夹下的img文件夹下的一个图片
        icon=new ImageIcon(getClass().getResource("/bwc04/images/6.png"));
        img=icon.getImage();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
    }

}

