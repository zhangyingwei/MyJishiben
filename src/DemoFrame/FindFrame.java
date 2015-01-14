/*
 * FindFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package DemoFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import DemoTxt.MyFile;

/**
 *
 * @author  __USER__
 */
public class FindFrame extends javax.swing.JFrame {
	private MyFile myFile;
	public FindFrame(MyFile myFile) {
		this.myFile = myFile;
		initComponents();
		this.setLocationRelativeTo(null);
	}
	private void initComponents() {
		jLabel_name = new javax.swing.JLabel();
		jTextField_name = new javax.swing.JTextField();
		jButton_ok = new javax.swing.JButton();
		jButton_esc = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("\u67e5\u627e");
		setResizable(false);

		jLabel_name.setText("\u6807\u9898\uff1a");

		jButton_ok.setText("\u786e\u5b9a");
		jButton_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!jTextField_name.getText().equals("")) {
					try {
						jTextArea.setText(myFile.myfind(jTextField_name.getText()).toString());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, " ‰»Î¥ÌŒÛ");
				}
			}
		});
		jButton_esc.setText("\u53d6\u6d88");
		jButton_esc.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_escActionPerformed(evt);
			}
		});

		jTextArea.setColumns(20);
		jTextArea.setEditable(false);
		jTextArea.setRows(5);
		jScrollPane1.setViewportView(jTextArea);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout.createSequentialGroup().addGap(21, 21,
										21).addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										433,
										javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(25, Short.MAX_VALUE))
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(33, 33, 33)
										.addComponent(jLabel_name)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jTextField_name,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												166,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												47, Short.MAX_VALUE)
										.addComponent(jButton_ok).addGap(18,
												18, 18).addComponent(
												jButton_esc).addGap(53, 53, 53)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(32, 32, 32)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabel_name)
														.addComponent(
																jButton_esc)
														.addComponent(
																jButton_ok)
														.addComponent(
																jTextField_name,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(33, 33, 33)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												266,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(25, Short.MAX_VALUE)));

		pack();
	}

	private void jButton_escActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	private javax.swing.JButton jButton_esc;
	private javax.swing.JButton jButton_ok;
	private javax.swing.JLabel jLabel_name;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea;
	private javax.swing.JTextField jTextField_name;
}