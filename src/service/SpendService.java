package service;

import java.util.List;

import dao.RecordDAO;
import entity.Record;
import gui.page.SpendPage;
import util.DateUtil;

public class SpendService {

	public SpendPage getSpendPage() {
		RecordDAO dao = new RecordDAO();
		// The data of this month
		List<Record> thisMonthRecords = dao.listThisMonth();
		// Today data
		List<Record> toDayRecords = dao.listToday();
		// The number of day in this month
		int thisMonthTotalDay = DateUtil.thisMonthTotalDay();

		int monthSpend = 0;
		int todaySpend = 0;
		int avgSpendPerDay = 0;
		int monthAvailable = 0;
		int dayAvgAvailable = 0;
		int monthLeftDay = 0;
		int usagePercentage = 0;

		// Budget
		int monthBudget = new ConfigService().getIntBudget();

		// Count this month expense
		for (Record record : thisMonthRecords) {
			monthSpend += record.getSpend();
		}

		// Count today expense
		for (Record record : toDayRecords) {
			todaySpend += record.getSpend();
		}
		// Count average daily expense
		avgSpendPerDay = monthSpend / thisMonthTotalDay;
		// Count the available budget in this month
		monthAvailable = monthBudget - monthSpend;

		// Count the rest of day in this month
		monthLeftDay = DateUtil.thisMonthLeftDay();

		// Count the average daily available budget
		dayAvgAvailable = monthAvailable / monthLeftDay;

		// Count the percentage of usage
		usagePercentage = monthSpend * 100 / monthBudget;

		// create SpendPage object

		return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable, monthLeftDay,
				usagePercentage);
	}
}
