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
        if (column == 14) {

            if (value instanceof String) {
                if (table.getValueAt(row, 14).toString().toLowerCase().equals("critica") && table.getValueAt(row, 12).toString().equals("0")) {
                    String Valor = (String) value;
                    cell.setBackground(Color.red);
                } else {
                    if (table.getValueAt(row, 14).toString().toLowerCase().equals("alta") && table.getValueAt(row, 12).toString().equals("0")) {
                        String Valor = (String) value;
                        cell.setBackground(Color.ORANGE);
                    } else {
                        if (table.getValueAt(row, 14).toString().toLowerCase().equals("media") && table.getValueAt(row, 12).toString().equals("0")) {
                            String Valor = (String) value;
                            cell.setBackground(Color.YELLOW);
                        } else {
                            if (table.getValueAt(row, 14).toString().toLowerCase().equals("baja") && table.getValueAt(row, 12).toString().equals("0")) {
                                String Valor = (String) value;
                                cell.setBackground(Color.decode("#3b83bd"));
                            } else {

                            }
                        }
                    }
                }
            }

        }

        return cell;
    }
}
