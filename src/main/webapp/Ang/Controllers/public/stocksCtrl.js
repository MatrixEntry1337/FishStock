angular.module('stocks')
.controller('pubStocksCtrl', function(stocksFtry, $scope, $log, allData){
	
	/* refactor ---- resolve so that this is taken care of before the page launches */
	// get back everything()
	// stocksFtry.getAllData();
	
	// get the data containing all companies and their stock data from factory
	$scope.data = allData;

	// currently selected stock
	$scope.selectStock = function(stock){
		$scope.selectedStock = stock;
		$scope.selectedStock.index = $scope.companies.find(function(){
            $scope.selectedStock.sym
        });
		setQuote(stock);
		setHistory(stock);
	};

	/************************************* Chart Creation ************************************/
	function setQuote(stock){
		$scope.quoteLabels = ["Open", "PreviousClose", "Day High", "Day Low", "Year High", "Year Low"];
		$scope.quoteData = genQuoteData($scope.selectedStock.quote);
		$scope.quoteOptions = {
				elements:{
					line:{ borderColor: '#c95693', borderWidth: 2, fill: false}
				}
		}
	};
	
	function setHistory(stock){
		$scope.historyLabels = genHistoryMonths($scope.selectedStock.history);
		$scope.historyData = genHistoryData($scope.selectedStock.history);
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

	function genQuoteData(quote){
		var gen = [];
		
		gen.push(quote.open);
		gen.push(quote.previousClose);
		gen.push(quote.dayHigh);
		gen.push(quote.dayLow);
		gen.push(quote.yearHigh);
		gen.push(quote.yearLow);
	
		return gen;
	};
	
	function genHistoryMonths(history){
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
	
	function genHistoryData(history){
		var gen = [];
		var open = [];
		var close = [];
		var high = [];
		var low = [];
		
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
	};

	var monthNames = ["January", "February", "March", "April", "May", "June",
		  "July", "August", "September", "October", "November", "December"
		];


});