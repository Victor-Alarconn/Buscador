/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizador;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author programacion01
 */
public class TablaColor extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setHorizontalAlignment(SwingConstants.CENTER);

        if (table.getValueAt(row, 12).toString().equals("1")) {
            setBackground(Color.decode("#8DFF33"));

        } else {
            setBackground(Color.WHITE);
        }
        if (isSelected) {
            setBackground(Color.decode("#D9EBF4"));
        }
        if (value instanceof String) {
            String v = (String) value;
            if (column == 14) {
                if (((String) value).toLowerCase().equals("critica")&& table.getValueAt(row, 12).toString().equals("0")) {
                    cell.setBackground(Color.RED);
                } else {
                    if (((String) value).toLowerCase().equals("alta")&& table.getValueAt(row, 12).toString().equals("0")) {
                        cell.setBackground(Color.ORANGE);
                    } else {
                        if (((String) value).toLowerCase().equals("media")&& table.getValueAt(row, 12).toString().equals("0")) {
                            cell.setBackground(Color.YELLOW);
                        } else {
                            if (((String) value).toLowerCase().equals("baja") && table.getValueAt(row, 12).toString().equals("0")) {
                                cell.setBackground(Color.decode("#3b83bd"));
                            } 
                        }
                    }
                }
            } else {
                cell.setForeground(Color.BLACK);
            }
        }
        return cell;
    }
}
