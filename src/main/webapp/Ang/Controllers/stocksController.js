angular.module('stocks')
.controller('stocksCtrl', function(stocksFtry, $scope, $log){
	
	var monthNames = ["January", "February", "March", "April", "May", "June",
		  "July", "August", "September", "October", "November", "December"
		];
	
	$scope.getAll = stocksFtry.getAll();
	$scope.data = stocksFtry.data;
	$scope.selectStock = function(stock){
		$scope.selectedStock = stock;
		setInfo(stock);
		setHistory(stock);
	};

	function setInfo(stock){
		
	}
	
	function setHistory(stock){
		$scope.historyLabels = genMonths($scope.selectedStock.history);
		$scope.historyData = genData($scope.selectedStock.history);
		$scope.historySeries = ['Open', 'Close', 'High', 'Low'];
		$scope.historyOnClick = function (points, evt) {
			console.log(points, evt);
		};
		$scope.historyDatasetOverride = [{ yAxisID: 'y-axis-1' }];
		$scope.historyOptions = {
			scales: {
				yAxes: [
					{
			          id: 'y-axis-1',
			          type: 'linear',
			          display: true,
			          position: 'left'
			        }
		        ]
			}
		};
		
		// set chart colors
		$scope.historyColors = [ '#67bf7e', '#00ADF9', 
			'#803690', '#e02626'];
	};
	
	function genMonths(history){
		// get the year
	    var currentYear = new Date().getFullYear();
	    
	    // pull the last two digits of the year
	    currentYear = currentYear.toString().substr(2,2);
	    
	    // calc the last year
	    var lastYear = currentYear - 1;

	    // generate months from history
	    gen = [];
		history.forEach(function(each){
			gen.push(monthNames[new Date(each.date).getMonth()]);
		});
		
		// set years
		gen[0] = gen[0] + " '" + lastYear;
		gen[12] = gen[12] + " '" + currentYear;
		
		return gen;
	};
	
	function genData(history){
		gen = [];
		open = [];
		close = [];
		high = [];
		low = [];
		
		// get data
		history.forEach(function(each){
			open.push(each.open);
			close.push(each.close);
			high.push(each.high);
			low.push(each.low);
		});
		
		// give data to gen
		gen.push(open);
		gen.push(close);
		gen.push(high);
		gen.push(low);
		return gen;
	}
});