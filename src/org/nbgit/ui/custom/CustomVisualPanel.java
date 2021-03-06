/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2008 Jonas Fonseca <fonseca@diku.dk>
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file.
 *
 * This particular file is subject to the "Classpath" exception as provided
 * by Sun in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Contributor(s):
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 */
package org.nbgit.ui.custom;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import org.netbeans.modules.versioning.util.AccessibleJFileChooser;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle;

public final class CustomVisualPanel extends JPanel {

    private final CustomActionBuilder builder;
    private final CustomWizardPanel panel;
    DocumentListener documentListener = new DocumentListener() {

        public void insertUpdate(DocumentEvent evt) {
            refreshText();
        }

        public void removeUpdate(DocumentEvent arg0) {
            refreshText();
        }

        public void changedUpdate(DocumentEvent arg0) {
            refreshText();
        }

    };

    /** Creates new form CustomVisualPanel */
    public CustomVisualPanel(CustomWizardPanel panel, CustomActionBuilder builder) {
        this.panel = panel;
        this.builder = builder;
        initComponents();
        nameText.setText(builder.getName());
        nameText.getDocument().addDocumentListener(documentListener);
        pathText.setText(builder.getPath());
        pathText.getDocument().addDocumentListener(documentListener);
        argsText.setText(builder.getArgs());
        argsText.getDocument().addDocumentListener(documentListener);
        showOutput.setSelected(builder.isShowOutput());
        showDirty.setSelected(builder.isShowDirty());
        repoSpecific.setSelected(builder.isRepoSpecific());
        workDirRoot.setSelected(builder.isWorkDirRoot());
        if (builder.getContext().getRootFiles().isEmpty()) {
            repoSpecific.setEnabled(false);
        }
    }

    @Override
    public String getName() {
        return NbBundle.getMessage(CustomVisualPanel.class, "CustomWizardStepName");
    }

    private void refreshText() {
        boolean valid = builder.isValid();

        builder.setPath(pathText.getText());
        builder.setArgs(argsText.getText());
        builder.setName(nameText.getText());

        if (valid != builder.isValid()) {
            panel.fireChangeEvent();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        pathLabel = new javax.swing.JLabel();
        pathText = new javax.swing.JTextField();
        pathBrowseButton = new javax.swing.JButton();
        argsLabel = new javax.swing.JLabel();
        argsText = new javax.swing.JTextField();
        argsHelpLabel = new javax.swing.JLabel();
        argsHelpLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        showDirty = new javax.swing.JCheckBox();
        repoSpecific = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        workDirRoot = new javax.swing.JCheckBox();
        showOutput = new javax.swing.JCheckBox();

        org.openide.awt.Mnemonics.setLocalizedText(nameLabel, org.openide.util.NbBundle.getMessage(CustomVisualPanel.class, "CustomVisualPanel.nameLabel.text")); // NOI18N

        nameText.setText(org.openide.util.NbBundle.getMessage(CustomVisualPanel.class, "CustomVisualPanel.nameText.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(pathLabel, org.openide.util.NbBundle.getMessage(CustomVisualPanel.class, "CustomVisualPanel.pathLabel.text")); // NOI18N

        pathText.setText(org.openide.util.NbBundle.getMessage(CustomVisualPanel.class, "CustomVisualPanel.pathText.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(pathBrowseButton, org.openide.util.NbBundle.getMessage(CustomVisualPanel.class, "CustomVisualPanel.pathBrowseButton.text")); // NOI18N
        pathBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathBrowseButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(argsLabel, org.openide.util.NbBundle.getMessage(CustomVisualPanel.class, "CustomVisualPanel.argsLabel.text")); // NOI18N

        argsText.setText(org.openide.util.NbBundle.getMessage(CustomVisualPanel.class, "CustomVisualPanel.argsText.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(argsHelpLabel, org.openide.util.NbBundle.getMessage(CustomVisualPanel.class, "CustomVisualPanel.argsHelpLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(argsHelpLabel2, org.openide.util.NbBundle.getMessage(CustomVisualPanel.class, "CustomVisualPanel.argsHelpLabel2.text")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(CustomVisualPanel.class, "CustomVisualPanel.jPanel1.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(showDirty, org.openide.util.NbBundle.getMessage(CustomVisualPanel.class, "CustomVisualPanel.showDirty.text")); // NOI18N
        showDirty.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CustomVisualPanel.this.itemStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(repoSpecific, org.openide.util.NbBundle.getMessage(CustomVisualPanel.class, "CustomVisualPanel.repoSpecific.text")); // NOI18N
        repoSpecific.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CustomVisualPanel.this.itemStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(showDirty)
                    .add(repoSpecific))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(showDirty)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(repoSpecific)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(CustomVisualPanel.class, "CustomVisualPanel.jPanel2.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(workDirRoot, org.openide.util.NbBundle.getMessage(CustomVisualPanel.class, "CustomVisualPanel.workDirRoot.text")); // NOI18N
        workDirRoot.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CustomVisualPanel.this.itemStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(showOutput, org.openide.util.NbBundle.getMessage(CustomVisualPanel.class, "CustomVisualPanel.showOutput.text")); // NOI18N
        showOutput.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CustomVisualPanel.this.itemStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(workDirRoot)
                    .add(showOutput))
                .addContainerGap(219, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(workDirRoot)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(showOutput)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(nameLabel)
                        .add(47, 47, 47)
                        .add(nameText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(argsLabel)
                            .add(pathLabel))
                        .add(15, 15, 15)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(argsHelpLabel2)
                            .add(argsHelpLabel)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(pathText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(pathBrowseButton))
                            .add(argsText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nameLabel)
                    .add(nameText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(pathLabel)
                    .add(pathBrowseButton)
                    .add(pathText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(argsLabel)
                    .add(argsText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(argsHelpLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(argsHelpLabel2)
                .add(18, 18, 18)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void pathBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathBrowseButtonActionPerformed
    String path = pathText.getText();
    File file = FileUtil.normalizeFile(new File(path));
    JFileChooser fileChooser = new AccessibleJFileChooser(NbBundle.getMessage(CustomVisualPanel.class, "CustomActionPath"), file); // NOI18N
    fileChooser.setDialogTitle(NbBundle.getMessage(CustomVisualPanel.class, "CustomActionPathTitle")); // NOI18N
    fileChooser.setMultiSelectionEnabled(false);
    FileFilter[] old = fileChooser.getChoosableFileFilters();
    for (int i = 0; i < old.length; i++) {
        FileFilter fileFilter = old[i];
        fileChooser.removeChoosableFileFilter(fileFilter);
    }
    fileChooser.showDialog(this, NbBundle.getMessage(CustomVisualPanel.class, "OK_Button")); // NOI18N
    file = fileChooser.getSelectedFile();
    if (file != null) {
        pathText.setText(file.getAbsolutePath());
    }
}//GEN-LAST:event_pathBrowseButtonActionPerformed

private void itemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_itemStateChanged
    if (evt.getSource() == showOutput) {
        builder.setShowOutput(showOutput.isSelected());
    } else if (evt.getSource() == showDirty) {
        builder.setShowDirty(showDirty.isSelected());
    } else if (evt.getSource() == repoSpecific) {
        builder.setRepoSpecific(repoSpecific.isSelected());
    } else if (evt.getSource() == workDirRoot) {
        builder.setWorkDirRoot(workDirRoot.isSelected());
    }
    panel.fireChangeEvent();
}//GEN-LAST:event_itemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel argsHelpLabel;
    private javax.swing.JLabel argsHelpLabel2;
    private javax.swing.JLabel argsLabel;
    private javax.swing.JTextField argsText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JButton pathBrowseButton;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JTextField pathText;
    private javax.swing.JCheckBox repoSpecific;
    private javax.swing.JCheckBox showDirty;
    private javax.swing.JCheckBox showOutput;
    private javax.swing.JCheckBox workDirRoot;
    // End of variables declaration//GEN-END:variables
}
