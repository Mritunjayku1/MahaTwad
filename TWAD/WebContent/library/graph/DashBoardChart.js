/**
 * Created by Mahalingam
 */

// ############## ----------- Start Bar Chart-----------################
/*
 * Function to plot Bar chart. if the Data source contains multiple data it will
 * plot comparison chart. otherwise plot single bar chart @param AppDetails
 */

var activeAppchart;
function fnPlotBarChart(dataSource, XaxisTitle, YaxisTitle, mapTitle, divID) {

	var chartData;
	activeAppchart = new cfx.Chart();
	activeAppchart.getAllSeries().getBorder()
			.setEffect(cfx.BorderEffect.Raised);
	activeAppchart.getAnimations().getLoad().setEnabled(true);
	activeAppchart.getLegendBox().setVisible(false);
	activeAppchart.getAllSeries().setGallery(cfx.Gallery.Bar);
	activeAppchart.getAxisX().getTitle().setText(XaxisTitle);
	activeAppchart.getAxisY().getTitle().setText(YaxisTitle);
	activeAppchart.getAxisY2().getGrids().setInterlaced(true);
	activeAppchart.getDataGrid().setVisible(true);
	activeAppchart.getSeries().getItem(2).setAxisY(activeAppchart.getAxisY2());
	activeAppchart.setDataSource(dataSource);
	chartData = new cfx.TitleDockable();
	chartData.setText(mapTitle);
	activeAppchart.getTitles().add(chartData);
	activeAppchart.create(document.getElementById(divID));
}

/**
 * @param dataPoints
 * @param items
 */
var flag = false;
function fnPlotDrillDownChart1(dataPoints, graphData, divID_1, divID_2,
		mapTitle) {

	var ChartSummary;
	var ChartDetails;
	var myDoughnut;
	var summaryTitle;
	var summarySubtitle;
	var detailsTitle;
	var detailsSubtitle;

	ChartSummary = new cfx.Chart();
	ChartDetails = new cfx.Chart();
	ChartSummary.setDataSource(dataPoints.Apps);
	ChartDetails.setDataSource(graphData);
	ChartSummary.setGallery(cfx.Gallery.Doughnut);
	ChartSummary.getAxisX().getDataFormat().setFormat(cfx.AxisFormat.Number);
	ChartSummary.getAllSeries().getPointLabels().setVisible(true);
	ChartSummary.getAllSeries().getPointLabels().setFormat("%v");

	myDoughnut = (ChartSummary.getGalleryAttributes());
	myDoughnut.setShadows(true);
	myDoughnut.setShowLines(true);

	ChartDetails.setGallery(cfx.Gallery.Curve);
	ChartDetails.getAxisX().getDataFormat().setFormat(cfx.AxisFormat.Number);
	ChartDetails.getAllSeries().getPointLabels().setVisible(true);
	ChartDetails.getAllSeries().getPointLabels().setFormat("%v");
	ChartDetails.getAllSeries().getPointLabels().setAlignment(
			cfx.StringAlignment.Far);

	initializeChart(false);
	ChartSummary.create(document.getElementById(divID_1));
	ChartDetails.create(document.getElementById(divID_2));

	summaryTitle = new cfx.TitleDockable();
	summaryTitle.setText(mapTitle);
	summaryTitle.setFont("18px monospace");

	summarySubtitle = new cfx.TitleDockable();
	summarySubtitle.setText(getDateInterval());
	summarySubtitle.setFont("14px monospace");

	ChartSummary.getTitles().add(summaryTitle);
	ChartSummary.getTitles().add(summarySubtitle);

	detailsTitle = new cfx.TitleDockable();
	detailsTitle.setText(mapTitle);
	detailsTitle.setFont("18px monospace");

	detailsSubtitle = new cfx.TitleDockable();
	detailsSubtitle.setText(getDateInterval());
	detailsSubtitle.setFont("14px monospace");

	ChartDetails.getTitles().add(detailsTitle);
	ChartDetails.getTitles().add(detailsSubtitle);
}

function initializeChart(flag) {

	var i = 0;
	flag ? i = 0 : i = 5;
	while (i < 5) {
		ChartDetails.getSeries().getItem(i).setVisible(false);
		ChartSummary.getData().setItem(0, i, cfx.Chart.Hidden);
		ChartSummary.getData().getLabels().setItem(i, "");
		i++;
	}
}

function hideChart() {
	ChartSummary.setMessageText("NoData", "Please click on a App to compare");
	ChartSummary.getData().setSeries(0);
	ChartSummary.getData().setPoints(0);
	ChartDetails.setMessageText("NoData", "Please click on a App to compare");
	ChartDetails.getData().setSeries(0);
}

function showChart(pointId) {
	ChartSummary.setDataSource(dataPoints.Apps);
	ChartDetails.setDataSource(items);
	initializeChart(true);
	ChartSummary.getData().setItem(0, pointId - 1,
			dataPoints.Apps[pointId - 1].Value);
	ChartSummary.getData().getLabels().setItem(pointId - 1,
			dataPoints.Apps[pointId - 1].Name);
}

function checkState() {
	var state = false;

	if (!Checkbox1.checked && !Checkbox2.checked && !Checkbox3.checked
			&& !Checkbox4.checked && !Checkbox5.checked) {
		return state;
	} else {
		return !state;
	}
}

function doHide(pointId, state) {

	if (state) {
		if (flag) {
			flag = false;
			showChart(pointId);
		} else {
			ChartSummary.getData().setItem(0, pointId - 1,
					dataPoints.Apps[pointId - 1].Value);
			ChartSummary.getData().getLabels().setItem(pointId - 1,
					dataPoints.Apps[pointId - 1].Name);
		}
	} else {
		if (!checkState()) {
			flag = true;
			hideChart();
		} else {
			ChartSummary.getData().setItem(0, pointId - 1, cfx.Chart.Hidden);
			ChartSummary.getData().getLabels().setItem(pointId - 1, "");
		}
	}

	ChartDetails.getSeries().getItem(pointId - 1).getVisible() ? ChartDetails
			.getSeries().getItem(pointId - 1).setVisible(false) : ChartDetails
			.getSeries().getItem(pointId - 1).setVisible(true);

}

function onFilter(pointId, checkBoxId) {
	checkBoxId.checked ? doHide(pointId, true) : doHide(pointId, false);
}
function getDateInterval() {

	var mydate = new Date();
	var startDate = mydate.getDate() + "-" + mydate.getMonth() + "-"
			+ mydate.getFullYear();

	var mydate1 = new Date();
	mydate1.setDate(mydate1.getDate() + 7);
	var endDate = mydate1.getDate() + "-" + mydate1.getMonth() + "-"
			+ mydate1.getFullYear();
	return startDate + " To " + endDate;
}

function fnPlotLineChart(graphData, divID, mapTitle) {

	var ChartDetails;
	var detailsTitle;
	var detailsSubtitle;

	ChartDetails = new cfx.Chart();

	ChartDetails.setDataSource(graphData);

	ChartDetails.setGallery(cfx.Gallery.Curve);
	ChartDetails.getAxisX().getDataFormat().setFormat(cfx.AxisFormat.Number);
	ChartDetails.getAllSeries().getPointLabels().setVisible(true);
	ChartDetails.getAllSeries().getPointLabels().setFormat("%v");
	ChartDetails.getAllSeries().getPointLabels().setAlignment(
			cfx.StringAlignment.Far);

	initializeChart(false);

	ChartDetails.create(document.getElementById(divID));

	detailsTitle = new cfx.TitleDockable();
	detailsTitle.setText(mapTitle);
	detailsTitle.setFont("18px monospace");

	detailsSubtitle = new cfx.TitleDockable();

	detailsSubtitle.setFont("14px monospace");

	ChartDetails.getTitles().add(detailsTitle);
	ChartDetails.getTitles().add(detailsSubtitle);
}
function fnPlotPieChart(dataPoints, divID, mapTitle) {

	var ChartSummary;

	var summaryTitle;
	var summarySubtitle;

	ChartSummary = new cfx.Chart();

	ChartSummary.setDataSource(dataPoints);

	ChartSummary.setGallery(cfx.Gallery.Pie);
	var myPie;
	myPie = (ChartSummary.getGalleryAttributes());

	myPie.setExplodingMode(cfx.ExplodingMode.All);
	myPie.setSliceSeparation(4);

	ChartSummary.getAxisX().getDataFormat().setFormat(cfx.AxisFormat.Number);
	ChartSummary.getAllSeries().getPointLabels().setVisible(true);
	ChartSummary.getAllSeries().getPointLabels().setFormat("%v");

	initializeChart(false);
	ChartSummary.create(document.getElementById(divID));

	summaryTitle = new cfx.TitleDockable();
	summaryTitle.setText(mapTitle);
	summaryTitle.setFont("28px monospace");

	summarySubtitle = new cfx.TitleDockable();
	summarySubtitle.setText("");
	summarySubtitle.setFont("28px monospace");

	ChartSummary.getTitles().add(summaryTitle);
	ChartSummary.getTitles().add(summarySubtitle);

}
