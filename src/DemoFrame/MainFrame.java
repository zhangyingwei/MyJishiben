/*
 * MainFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package DemoFrame;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DemoDate.SystemDate;
import DemoDto.MyDto;
import DemoTxt.MyFile;

/**
 * 
 * @author __USER__
 */
public class MainFrame extends javax.swing.JFrame {

	private ArrayList<String> arrayList;
	private MyFile myFile;
	private MyDto myDto;

	public MainFrame(MyDto myDto) {
		this.myDto = myDto;
		this.myFile = new MyFile(myDto);
		initComponents();
		this.setLocationRelativeTo(null);
		filltable();
		jMenuItem_aboutaction();
		jMenuItem_selectaction();
	}
	private void jMenuItem_selectaction(){
		this.jMenuItem_select.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FindFrame(myFile).setVisible(true);
			}
		});
	}
	
	private void jMenuItem_aboutaction(){
		this.jMenuItem_about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "开发人员:*****","关于",JOptionPane.PLAIN_MESSAGE);
			}
		});
	}

	// 填充table(还有问题没有解决，非常大的问题)
	public void filltable() {

		try {
			this.myFile.myread();
			this.arrayList = this.myDto.getArrayList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		DefaultTableModel dModel = (DefaultTableModel) this.jTable.getModel();
		Iterator<String> it = this.arrayList.iterator();
		while (it.hasNext()) {
			Vector<String> vector = new Vector<String>();
				try {
					vector.add(it.next());
					vector.add(it.next());
					vector.add(it.next());
				} catch (Exception e) {
			}
			dModel.addRow(vector);
		}
	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTable = new javax.swing.JTable();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu_edit = new javax.swing.JMenu();
		jMenuItem_add = new javax.swing.JMenuItem();
		jMenuItem_select = new javax.swing.JMenuItem();
		jMenu_help = new javax.swing.JMenu();
		jMenuItem_about = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u8bb0\u4e8b\u672c");

		jTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "标题", "内容", "时间" }) {
			boolean[] canEdit = new boolean[] { false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(jTable);

		jMenu_edit.setText("\u7f16\u8f91");

		jMenuItem_add.setText("\u6dfb\u52a0");
		jMenuItem_add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem_addActionPerformed(evt);
			}
		});
		jMenu_edit.add(jMenuItem_add);

		jMenuItem_select.setText("\u67e5\u627e");
		jMenu_edit.add(jMenuItem_select);

		jMenuBar1.add(jMenu_edit);

		jMenu_help.setText("\u5e2e\u52a9");

		jMenuItem_about.setText("\u5173\u4e8e");
		jMenu_help.add(jMenuItem_about);

		jMenuBar1.add(jMenu_help);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(
						jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE,
						643, Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(
						jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE,
						468, Short.MAX_VALUE).addContainerGap()));

		pack();
	}
	private void jMenuItem_addActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
		new addFrame(myDto).setVisible(true);
	}

	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem_about;
	private javax.swing.JMenuItem jMenuItem_add;
	private javax.swing.JMenuItem jMenuItem_select;
	private javax.swing.JMenu jMenu_edit;
	private javax.swing.JMenu jMenu_help;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable;
}