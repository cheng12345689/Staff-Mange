package bwc04.view;

import bwc04.tools.border.Borders;
import bwc04.tools.color.Colour;
import bwc04.tools.font.Fonts;
import bwc04.tools.image.Images;
import bwc04.tools.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AdminView extends JFrame {

    /**
     * 文字
     */
    private String titleText = "工资管理系统";
    private String subTitleText = "工资等级";
    private String homeText = "工资等级";
    private String bookText = "员工管理";
    private String borrowText = "工资变动";
    private String returnText = "汇总查询";


    /**
     * 标签
     */
    private JLabel titleLabel = new JLabel();
    private JLabel subTitleLabel = new JLabel();
    private JLabel homeIconLabel = new JLabel();
    private JLabel homeTextLabel = new JLabel();
    private JLabel bookIconLabel = new JLabel();
    private JLabel bookTextLabel = new JLabel();
    private JLabel borrowIconLabel = new JLabel();
    private JLabel borrowTextLabel = new JLabel();
    private JLabel returnIconLabel = new JLabel();
    private JLabel returnTextLabel = new JLabel();

    /**
     * 按钮
     */
    private JButton hideButton = new JButton();
    private JButton closeButton = new JButton();
    private JButton homeButton = new JButton();
    private JButton bookButton = new JButton();
    private JButton borrowButton = new JButton();
    private JButton returnButton = new JButton();

    /**
     * 面板
     */
    private JPanel navPanel = new JPanel();
    private JPanel topPanel = new JPanel();
    private JPanel viewPanel = new JPanel();

    private HomeView homeView = new HomeView();

    private BookView bookView = new BookView();

    private BorrowView borrowView = new BorrowView();
    private ReturnView returnView = new ReturnView();
    /**
     * 布局
     */
    CardLayout cardLayout;

    /**
     * 管理员窗体
     */
    public AdminView() {

        // 副标题
        subTitleLabel.setText(subTitleText);
        subTitleLabel.setBounds(8, 0, 240, 32);
        subTitleLabel.setFont(Fonts.subTitle);

        // 最小化按钮
        hideButton.setIcon(Images.hideButtonIcon);
        hideButton.setRolloverIcon(Images.hideButtonHoverIcon);
        hideButton.setBounds(906, 6, 20, 20);
        hideButton.setOpaque(false);
        hideButton.setContentAreaFilled(false);
        hideButton.setFocusPainted(false);
        hideButton.setBorder(null);
        hideButton.addActionListener(e -> setState(Frame.ICONIFIED));

        // 关闭按钮
        closeButton.setIcon(Images.closeButtonIcon);
        closeButton.setRolloverIcon(Images.closeButtonHoverIcon);
        closeButton.setBounds(934, 6, 20, 20);
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setFocusPainted(false);
        closeButton.setBorder(null);
        closeButton.addActionListener(e -> System.exit(0));

        // 顶部栏
        topPanel.setLayout(null);
        topPanel.setBounds(240, 0,960, 32);
        topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(Borders.topPanelBorder);
        topPanel.add(subTitleLabel);
        topPanel.add(hideButton);
        topPanel.add(closeButton);

        // 标题
        titleLabel.setText(titleText);
        titleLabel.setBounds(0, 24, 240, 30);
        titleLabel.setFont(Fonts.title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //工资等级
        homeButton.setLayout(null); // 组件大小可以任意设置
        homeButton.setBounds(0,80,240,48); //设置该组件在其容器中的坐标和大小。
        homeButton.setForeground(Colour.C3C8CE7);  //设置组件的前景（文本和图标）颜色为指定颜色对象。
        homeButton.setFont(Fonts.menuButton); // 设置文本字体大小
        homeButton.setBackground(Color.WHITE); //设置组件的背景颜色为指定颜色对象。
        homeButton.setFocusPainted(false);
        homeButton.setBorder(null);   //设置按钮边框为空，即没有边框。
        homeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //设置鼠标光标进入按钮区域时的形态。
        homeButton.addFocusListener(addFocus(homeButton)); //给按钮添加焦点监听器，当按钮获得焦点时将执行相应的操作。
        homeIconLabel.setIcon(Images.homeFocusIcon); //设置图标标签的图像图标。
        homeIconLabel.setBounds(16,0, 48, 48); //设置图标标签的位置和大小。
        homeTextLabel.setText(homeText); //设置文本标签的文本内容。
        homeTextLabel.setFont(Fonts.menuButton);
        homeTextLabel.setForeground(Colour.C3C8CE7); //设置文本标签的前景颜色。
        homeTextLabel.setBounds(72, 0, 160, 48); //设置文本标签的位置和大小。
        homeButton.add(homeIconLabel);
        homeButton.add(homeTextLabel);

//// 图书管理按钮

        //员工管理按钮
        bookButton.setLayout(null);
        bookButton.setBounds(0, 136, 240, 48);
        bookButton.setForeground(Color.WHITE);
        bookButton.setFont(Fonts.menuButton);
        bookButton.setBackground(Colour.C3C8CE7);
        bookButton.setFocusPainted(false);
        bookButton.setBorder(null);
        bookButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bookButton.addFocusListener(addFocus(bookButton));
        bookIconLabel.setIcon(Images.bookIcon);
        bookIconLabel.setBounds(16,0, 48, 48);
        bookTextLabel.setText(bookText);
        bookTextLabel.setFont(Fonts.menuButton);
        bookTextLabel.setForeground(Color.WHITE);
        bookTextLabel.setBounds(72, 0, 160, 48);
        bookButton.add(bookIconLabel);
        bookButton.add(bookTextLabel);




        //工资变动按钮
        borrowButton.setLayout(null);
        borrowButton.setBounds(0, 192, 240, 48);
        borrowButton.setForeground(Color.WHITE);
        borrowButton.setFont(Fonts.menuButton);
        borrowButton.setBackground(Colour.C3C8CE7);
        borrowButton.setFocusPainted(false);
        borrowButton.setBorder(null);
        borrowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        borrowButton.addFocusListener(addFocus(borrowButton));
        borrowIconLabel.setIcon(Images.borrowIcon);
        borrowIconLabel.setBounds(16,0, 48, 48);
        borrowTextLabel.setText(borrowText);
        borrowTextLabel.setFont(Fonts.menuButton);
        borrowTextLabel.setForeground(Color.WHITE);
        borrowTextLabel.setBounds(72, 0, 160, 48);
        borrowButton.add(borrowIconLabel);
        borrowButton.add(borrowTextLabel);




        //汇总查询按钮
        returnButton.setLayout(null);
        returnButton.setBounds(0, 248, 240, 48);
        returnButton.setForeground(Color.WHITE);
        returnButton.setFont(Fonts.menuButton);
        returnButton.setBackground(Colour.C3C8CE7);
        returnButton.setFocusPainted(false);
        returnButton.setBorder(null);
        returnButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        returnButton.addFocusListener(addFocus(returnButton));
        returnIconLabel.setIcon(Images.returnIcon);
        returnIconLabel.setBounds(16,0, 48, 48);
        returnTextLabel.setText(returnText);
        returnTextLabel.setFont(Fonts.menuButton);
        returnTextLabel.setForeground(Color.WHITE);
        returnTextLabel.setBounds(72, 0, 160, 48);
        returnButton.add(returnIconLabel);
        returnButton.add(returnTextLabel);


        // 导航面板
        navPanel.setLayout(null);
        navPanel.setBounds(0, 0, 240, 800);
        navPanel.setBackground(Colour.C3C8CE7);
        navPanel.add(titleLabel);
        navPanel.add(homeButton);
        navPanel.add(bookButton);
        navPanel.add(borrowButton);
        navPanel.add(returnButton);


        // 视图面板
        viewPanel.setBounds(240, 32, 960, 768);
        viewPanel.setBackground(Color.PINK);
        viewPanel.setLayout(new CardLayout());
        viewPanel.add(homeView, homeText);
        viewPanel.add(bookView, bookText);
        viewPanel.add(borrowView, borrowText);
        viewPanel.add(returnView, returnText);


        // 视图设置
        cardLayout = (CardLayout) (viewPanel.getLayout());

        // 添加组件
        add(navPanel);
        add(topPanel);
        add(viewPanel);

        // 窗体设置
        setTitle("工资管理系统-管理员");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setLayout(null);
        setFocusable(true);
        setVisible(true);
        setLocationRelativeTo(null);
        setIconImage(Images.systemImage);
        View.setMoveFrame(this);

        // 添加任务栏图标
        try {
            Menu.setIcon(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 菜单按钮事件
     * @param button 菜单按钮
     * @return FocusListener
     */
    public FocusListener addFocus(JButton button) {
        return new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                button.setBackground(Color.WHITE);
                JLabel icon = (JLabel) button.getComponent(0);
                JLabel label = (JLabel) button.getComponent(1);
                String labelText = label.getText();
                label.setForeground(Colour.C3C8CE7);

                // 切换按钮样式
                switch (labelText) {
                    case "工资等级":
                        icon.setIcon(Images.homeFocusIcon);
                        //homeView.init();
                        break;
                    case "员工管理":
                        icon.setIcon(Images.bookFocusIcon);
                        break;
                    case "工资变动":
                        icon.setIcon(Images.borrowFocusIcon);
                        break;
                    case "汇总查询":
                        icon.setIcon(Images.returnFocusIcon);
                        break;
                    default:
                        break;
                }

                // 设置副标题
                subTitleLabel.setText(labelText);

                // 判断第一次点击的是否是主页按钮
                if (!labelText.equals(homeText)) {
                    //homeView.setVisible(false);
                    homeIconLabel.setIcon(Images.homeIcon);
                    homeButton.setBackground(Colour.C3C8CE7);
                    homeTextLabel.setForeground(Color.WHITE);
                }

                // 切换面板
                    cardLayout.show(viewPanel, labelText);
            }

            @Override
            public void focusLost(FocusEvent e) {
                button.setBackground(Colour.C3C8CE7);
                JLabel icon = (JLabel) button.getComponent(0);
                JLabel label = (JLabel) button.getComponent(1);
                String labelText = label.getText();
                label.setForeground(Color.WHITE);

                // 切换按钮样式
                switch (labelText) {
                    case "工资等级":
                        icon.setIcon(Images.homeIcon);
                        break;
                    case "员工管理":
                        icon.setIcon(Images.bookIcon);
                        break;
                    case "工资变动":
                        icon.setIcon(Images.borrowIcon);
                        break;
                    case "汇总查询":
                        icon.setIcon(Images.returnIcon);
                        break;
                    default:
                        break;
                }
            }
        };
    }
}

