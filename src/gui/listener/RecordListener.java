package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.SpendPanel;
import service.RecordService;
import util.GUIUtil;

public class RecordListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		RecordPanel p  =RecordPanel.instance;
		if(0==p.cbModel.cs.size()){
			JOptionPane.showMessageDialog(p, "There is not any category，unable to add，please add a category first");
			MainPanel.instance.workingPanel.show(CategoryPanel.instance);
			return;
		}
		
		if(!GUIUtil.checkZero(p.tfSpend,"Amount of Expense"))
			return;
		int spend = Integer.parseInt(p.tfSpend.getText());
		Category c = p.getSelectedCategory();
		String comment = p.tfComment.getText();
		Date d = p.datepick.getDate();
		new RecordService().add(spend, c, comment, d);
		JOptionPane.showMessageDialog(p, "Add successfully");
		
		MainPanel.instance.workingPanel.show(SpendPanel.instance);
		
	}

}
