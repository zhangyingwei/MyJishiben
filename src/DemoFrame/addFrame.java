/*
 * addFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package DemoFrame;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import DemoDate.SystemDate;
import DemoDto.MyDto;
import DemoTxt.MyFile;
public class addFrame extends javax.swing.JFrame {

	private SystemDate systemDate;
	private MyFile myFile;
	private MyDto myDto;
	public addFrame(MyDto myDto) {
		this.systemDate = new SystemDate();
		this.myDto = myDto;
		this.myFile = new MyFile(myDto);
		initComponents();
		this.setLocationRelativeTo(null);

	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jTextField_name = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea = new javax.swing.JTextArea();
		jButton_reset = new javax.swing.JButton();
		jButton_ok = new javax.swing.JButton();
		jButton_esc = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("\u6dfb\u52a0");

		jLabel1.setText("\u6807\u9898\uff1a");

		jLabel2.setText("\u5185\u5bb9\uff1a");

		jTextArea.setColumns(20);
		jTextArea.setRows(5);
		jScrollPane1.setViewportView(jTextArea);

		jButton_reset.setText("\u91cd\u7f6e");
		jButton_reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_resetActionPerformed(evt);
			}
		});

		jButton_ok.setText("\u786e\u5b9a");
		jButton_ok.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_okActionPerformed(evt);
			}
		});

		jButton_esc.setText("\u53d6\u6d88");
		jButton_esc.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_escActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jButton_ok)
																		.addGap(
																				48,
																				48,
																				48)
																		.addComponent(
																				jButton_esc))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																layout
																		.createSequentialGroup()
																		.addGap(
																				60,
																				60,
																				60)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel1)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField_name,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												324,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												jButton_reset))
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel2)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jScrollPane1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												429,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))))
										.addContainerGap(68, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(35, 35, 35)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(
																jTextField_name,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton_reset))
										.addGap(35, 35, 35)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel2)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																233,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(36, 36, 36)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jButton_ok)
														.addComponent(
																jButton_esc))
										.addContainerGap(51, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton_escActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
		new MainFrame(myDto).setVisible(true);
	}

	private void jButton_okActionPerformed(java.awt.event.ActionEvent evt) {
			if (!this.jTextField_name.getText().equals("")) {
				try {
					this.myFile.mywrite(this.jTextField_name.getText().trim());
					this.myFile.mywrite(this.jTextArea.getText().trim().replaceAll("\n", ""));
					this.myFile.mywrite(this.systemDate.getdate());
					this.myDto.setDate(this.systemDate.getdate());
				} catch (Exception e) {
				}
				int i = JOptionPane.showConfirmDialog(null, "添加成功，再来一条？");
				switch (i) {
				case 0:
					this.reset();
					break;
				case 1:
					this.dispose();
					new MainFrame(myDto).setVisible(true);
				}
			} else {
				JOptionPane.showMessageDialog(null, "输入错误！");
			}
	}

	private void jButton_resetActionPerformed(java.awt.event.ActionEvent evt) {
		this.reset();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
		new MainFrame(myDto).setVisible(true);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null, "添加成功");
		this.dispose();
		new MainFrame(myDto).setVisible(true);
	}

	private void reset() {
		this.jTextArea.setText("");
		this.jTextField_name.setText("");
	}

	private javax.swing.JButton jButton_esc;
	private javax.swing.JButton jButton_ok;
	private javax.swing.JButton jButton_reset;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea;
	private javax.swing.JTextField jTextField_name;

}