package gui.page;

public class SpendPage {
	//This month expense
	public String monthSpend;
	//Today expense
	public String todaySpend;
	//Average daily expense
	public String avgSpendPerDay;
	//Available budget in this month
	public String monthAvailable;
	//Average daily available budget
	public String dayAvgAvailable;
	//the rest day of this month
	public String monthLeftDay;
	//Percentage of usage
	public int usagePercentage;
	//Is over budget?
	public boolean isOverSpend = false;

	public SpendPage(int monthSpend, int todaySpend, int avgSpendPerDay, int monthAvailable, int dayAvgAvailable,
			int monthLeftDay, int usagePercentage) {
		this.monthSpend = "￥" + monthSpend;
		this.todaySpend = "￥" + todaySpend;
		this.avgSpendPerDay = "￥" + avgSpendPerDay;
		if (monthAvailable < 0)
			isOverSpend = true;

		if (!isOverSpend) {
			this.monthAvailable = "￥" + monthAvailable;
			this.dayAvgAvailable = "￥" + dayAvgAvailable;
		} else {
			this.monthAvailable = "超支" + (0 - monthAvailable);
			this.dayAvgAvailable = "￥0";
		}

		this.monthLeftDay = monthLeftDay + "天";
		this.usagePercentage = usagePercentage;
	}
}
