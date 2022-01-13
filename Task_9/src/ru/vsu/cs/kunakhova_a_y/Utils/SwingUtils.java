package ru.vsu.cs.kunakhova_a_y.Utils;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


/**
 * Набор функций для работы с оконными приложениями с использованием Swing
 *
 * @author Дмитрий Соломатин (кафедра ПиИТ ФКН ВГУ)
 */
public class SwingUtils {

    /**
     * Установка темы отображения (LookAndFeel) для элементов управления
     *
     * @param name Название темы
     */
    public static void setLookAndFeelByName(String name) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (name.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    for (Window window : Window.getWindows()) {
                        Dimension size = window.getSize();
                        SwingUtilities.updateComponentTreeUI(window);
                        window.pack();
                        window.setSize(size);
                    }
                    break;
                }
            }
        } catch (Exception ex) {
            Class inner = new Object() {
            }.getClass();
            Logger.getGlobal().logp(Level.SEVERE, inner.getEnclosingClass().getName(), inner.getEnclosingMethod().getName(), null, ex);
        }
    }

    /**
     * Заполнение меню JMenu элементами для выбора тем отображения (LookAndFeel)
     *
     * @param menu Меню для добавления пунктов меню
     */
    public static void initLookAndFeelMenu(JMenu menu) {
        ActionListener actionListener = (ActionEvent e) -> {
            JMenuItem menuItem = (JMenuItem) e.getSource();
            SwingUtils.setLookAndFeelByName(menuItem.getText());
        };
        ButtonGroup group = new ButtonGroup();
        LookAndFeel currentLookAndFeel = UIManager.getLookAndFeel();
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                continue;
            }
            JRadioButtonMenuItem menuItem = new JRadioButtonMenuItem();
            menuItem.setText(info.getName());
            menuItem.setSelected(info.getName().equals(currentLookAndFeel.getName()));
            menuItem.addActionListener(actionListener);
            group.add(menuItem);
            menu.add(menuItem);
        }
    }

    public static void showMyErrorMessageBox(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
