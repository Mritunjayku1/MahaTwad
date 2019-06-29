/**
 * Mahalingam
 */
var oTable;
var isTablealled = false;
$(document).ready(
		function() {

			$("#fromDate").datepicker({
				showOn : "button",
				buttonImage : "library/img/calendar.png",
				buttonImageOnly : true,
				buttonText : "Select From date"
			});
			$("#toDate").datepicker({
				showOn : "button",
				buttonImage : "library/img/calendar.png",
				buttonImageOnly : true,
				buttonText : "Select To date"
			});

			$("#agentPerformanceReport tbody tr").on(
					'click',
					function(event) {
						$("#agentPerformanceReport tbody tr").removeClass(
								'row_selected');
						$(this).addClass('row_selected');
						$(this).find('input[type="radio"]').attr('checked',
								true);
					});
			$("#btnSubmit").click(function() {
				$("#agentPerformanceDivision").show();
				$("#agentPerformanceReport").show();
				$('#agentPerformanceReport').dataTable({
					"bSort" : false
				});
			});

			var data = [ {
				"Week" : "Week 1",
				// "Received" : 34,
				"Probing" : 12
			}, {
				"Week" : "Week 2",
				// "Received" : 32,
				"Probing" : 3
			}, {
				"Week" : "Week 3",
				// "Received" : 23,
				"Probing" : 34
			}, {
				"Week" : "Week 4",
				// "Received" : 43,
				"Probing" : 13
			}, {
				"Week" : "Week 5",
				// "Received" : 43,
				"Probing" : 25
			}, {
				"Week" : "Week 6",
				// "Received" : 34,
				"Probing" : 18
			}, {
				"Week" : "Week 7",
				// "Received" : 34,
				"Probing" : 18
			}, {
				"Week" : "Week 8",
				// "Received" : 34,
				"Probing" : 18
			}, {
				"Week" : "Week 9",
				// "Received" : 34,
				"Probing" : 18
			} ];

			$("#tabs").tabs();
			$("#tabs").tabs(
					{
						select : function(event, ui) {
							var tab = $(ui.tab).attr('href');
							if (tab == "#tab2") {
								$("#CallSummaryChart").show();
								fnPlotBarChart(data, "Week", "Avg. Score",
										"Probing", "CallSummaryChart");
							}
							if (tab == '#tab1') {
								$("#CallSummaryChart").html('');
								$("#CallSummaryChart").hide();
							}

						}
					});

		});
