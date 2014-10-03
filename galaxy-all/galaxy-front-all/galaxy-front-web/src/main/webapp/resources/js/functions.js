/* Copyright Trevor D Miller 2013 */

/*		GLOBAL VARS		**************************************************************************************/
	// Assign current list to include all filters on startup
	var randomQuoteIndex;
	var currentQuote;
	var currentAuthor;
	var currentShareQuote;
	var selectedCategory;

/*		ON LOAD		**************************************************************************************/
$( document ).on( "pageinit", "#home", function() {

	// If there is not an internet connection show an alert
	if (!navigator.onLine){
		setTimeout(showNoInternetAlert, 100);
	};

	// Combine all into the allFilters variable
	var allFilters = jQuery.merge( jQuery.merge( [], alex ), cameron);
		allFilters = jQuery.merge( allFilters, claire);
		allFilters = jQuery.merge( allFilters, gloria);
		allFilters = jQuery.merge( allFilters, haley);
		allFilters = jQuery.merge( allFilters, jay);
		allFilters = jQuery.merge( allFilters, luke);
		allFilters = jQuery.merge( allFilters, manny);
		allFilters = jQuery.merge( allFilters, mitchell);
		allFilters = jQuery.merge( allFilters, phil);

	// Set default selected category to all
	selectedCategory = allFilters;

	// Hide filter
	$('.filters-container').hide();

	// Load the first random quote
	loadRandomQuote(true, selectedCategory);

	// Load search list
	loadSearchList();

	// When a button is tapped, call the right function 
	$('#RandomButton').click(function(){
		loadRandomQuote(false, selectedCategory);
	});
	$('#share-btn').click(function(){
		shareQuote();
	});
	$('.return-home').click(function(){
		$.mobile.changePage("#home");
	});
	$('.rate-btn').click(function(){
		rate();
	});

	// When new filters are selected, call function and change selected category, then return to home page
	$('#allRadioButton').click(function(){
		selectedCategory = allFilters;
		$('.filter').html("Showing all");
		$('.filters-container').hide();
		loadRandomQuote(true, selectedCategory);
		$.mobile.changePage("#home");
	});
	$('#alexRadioButton').click(function(){
		selectedCategory = alex;
		$('.filter').html("Alex");
		$('.filters-container').show();
		loadRandomQuote(true, selectedCategory);
		$.mobile.changePage("#home");
	});
	$('#cameronRadioButton').click(function(){
		selectedCategory = cameron;
		$('.filter').html("Cameron");
		$('.filters-container').show();
		loadRandomQuote(true, selectedCategory);
		$.mobile.changePage("#home");
	});
	$('#claireRadioButton').click(function(){
		selectedCategory = claire;
		$('.filter').html("Claire");
		$('.filters-container').show();
		loadRandomQuote(true, selectedCategory);
		$.mobile.changePage("#home");
	});
	$('#gloriaRadioButton').click(function(){
		selectedCategory = gloria;
		$('.filter').html("Gloria");
		$('.filters-container').show();
		loadRandomQuote(true, selectedCategory);
		$.mobile.changePage("#home");
	});
	$('#haleyRadioButton').click(function(){
		selectedCategory = haley;
		$('.filter').html("Haley");
		$('.filters-container').show();
		loadRandomQuote(true, selectedCategory);
		$.mobile.changePage("#home");
	});
	$('#jayRadioButton').click(function(){
		selectedCategory = jay;
		$('.filter').html("Jay");
		$('.filters-container').show();
		loadRandomQuote(true, selectedCategory);
		$.mobile.changePage("#home");
	});
	$('#lukeRadioButton').click(function(){
		selectedCategory = luke;
		$('.filter').html("Luke");
		$('.filters-container').show();
		loadRandomQuote(true, selectedCategory);
		$.mobile.changePage("#home");
	});
	$('#mannyRadioButton').click(function(){
		selectedCategory = manny;
		$('.filter').html("Manny");
		$('.filters-container').show();
		loadRandomQuote(true, selectedCategory);
		$.mobile.changePage("#home");
	});
	$('#mitchellRadioButton').click(function(){
		selectedCategory = mitchell;
		$('.filter').html("Mitchell");
		$('.filters-container').show();
		loadRandomQuote(true, selectedCategory);
		$.mobile.changePage("#home");
	});
	$('#philRadioButton').click(function(){
		selectedCategory = phil;
		$('.filter').html("Phil");
		$('.filters-container').show();
		loadRandomQuote(true, selectedCategory);
		$.mobile.changePage("#home");
	});

	// When a search item is selected, grab index of selected item and change the current quote to match - then return to the home page
	$('.searchItem').click(function(){
		var index = $( ".searchItem" ).index(this);
		currentQuote = allFilters[index].Quote;
		currentAuthor = allFilters[index].Author;
		currentCategory = allFilters[index].Category;
		currentEpisode = allFilters[index].Episode;
		$('.currentQuote').html(currentQuote);
		$('.currentAuthor').html(currentAuthor);
		$('.currentCategory').html(currentCategory);
		$('.currentEpisode').html(currentEpisode);
		$.mobile.changePage("#home");
	});

	// If local storage has not been set up, set it up
	// If it has been set up, increment the count
	if(localStorage.runCount == null)
	{
		localStorage.runCount = 0;
	}
	else{
		localStorage.runCount ++;
		// Once app has been run 5 times show the feedback / rate / review form
		if(localStorage.runCount == 4){
			setTimeout(showRateDialog, 1000);
		}
	}
});


/*		FUNCTIONS		**************************************************************************************/

// Load search list
function loadSearchList(){    
	var i = 0;
	$('#searchList').append('<li data-role="list-divider"><span class="ui-icon-tag"> </span>Alex</li>');
	while(i < alex.length){
		$('#searchList').append('<li><a class="searchItem" href="#">' + '"' + alex[i].Quote  + '"' + '</a></li>');
		i++;
	}
	i = 0;
	$('#searchList').append('<li data-role="list-divider"><span class="ui-icon-tag"> </span>Cameron</li>');
	while(i < cameron.length){
		$('#searchList').append('<li><a class="searchItem" href="#">' + '"' + cameron[i].Quote  + '"' + '</a></li>');
		i++;
	}
	i = 0;
	$('#searchList').append('<li data-role="list-divider"><span class="ui-icon-tag"> </span>Claire</li>');
	while(i < claire.length){
		$('#searchList').append('<li><a class="searchItem" href="#">' + '"' + claire[i].Quote  + '"' + '</a></li>');
		i++;
	}
	i = 0;
	$('#searchList').append('<li data-role="list-divider"><span class="ui-icon-tag"> </span>Gloria</li>');
	while(i < gloria.length){
		$('#searchList').append('<li><a class="searchItem" href="#">' + '"' + gloria[i].Quote  + '"' + '</a></li>');
		i++;
	}
	i = 0;
	$('#searchList').append('<li data-role="list-divider"><span class="ui-icon-tag"> </span>Haley</li>');
		while(i < haley.length){
		$('#searchList').append('<li><a class="searchItem" href="#">' + '"' + haley[i].Quote  + '"' + '</a></li>');
		i++;
	}
	i = 0;
	$('#searchList').append('<li data-role="list-divider"><span class="ui-icon-tag"> </span>Jay</li>');
		while(i < jay.length){
		$('#searchList').append('<li><a class="searchItem" href="#">' + '"' + jay[i].Quote  + '"' + '</a></li>');
		i++;
	}
	i = 0;
	$('#searchList').append('<li data-role="list-divider"><span class="ui-icon-tag"> </span>Luke</li>');
		while(i < luke.length){
		$('#searchList').append('<li><a class="searchItem" href="#">' + '"' + luke[i].Quote  + '"' + '</a></li>');
		i++;
	}
	i = 0;
	$('#searchList').append('<li data-role="list-divider"><span class="ui-icon-tag"> </span>Manny</li>');
		while(i < manny.length){
		$('#searchList').append('<li><a class="searchItem" href="#">' + '"' + manny[i].Quote  + '"' + '</a></li>');
		i++;
	}
	i = 0;
	$('#searchList').append('<li data-role="list-divider"><span class="ui-icon-tag"> </span>Mitchell</li>');
		while(i < mitchell.length){
		$('#searchList').append('<li><a class="searchItem" href="#">' + '"' + mitchell[i].Quote  + '"' + '</a></li>');
		i++;
	}
	i = 0;
	$('#searchList').append('<li data-role="list-divider"><span class="ui-icon-tag"> </span>Phil</li>');
		while(i < phil.length){
		$('#searchList').append('<li><a class="searchItem" href="#">' + '"' + phil[i].Quote  + '"' + '</a></li>');
		i++;
	}
	i = 0;
	$('#searchlist').listview("refresh");
}

// Load new random quote. If it is the first run - on startup - don't animate
function loadRandomQuote(isFirstRun, selectedCategory){
    if(isFirstRun == true)
    {
    	randomQuoteIndex = Math.floor(Math.random()*selectedCategory.length);
		currentQuote = selectedCategory[randomQuoteIndex].Quote;
		currentAuthor = selectedCategory[randomQuoteIndex].Author;
		currentCategory = selectedCategory[randomQuoteIndex].Category;
		currentEpisode = selectedCategory[randomQuoteIndex].Episode;
		$('.currentQuote').html(currentQuote);
		$('.currentAuthor').html(currentAuthor);
		$('.currentCategory').html(currentCategory);
		$('.currentEpisode').html(currentEpisode);
    }
    else if(isFirstRun == false){
    	randomQuoteIndex = Math.floor(Math.random()*selectedCategory.length);
		currentQuote = selectedCategory[randomQuoteIndex].Quote;
		currentAuthor = selectedCategory[randomQuoteIndex].Author;
		currentCategory = selectedCategory[randomQuoteIndex].Category;
		currentEpisode = selectedCategory[randomQuoteIndex].Episode;
		$('.quote').fadeOut(200,function(){
			$('.currentQuote').html(currentQuote);
			$('.currentAuthor').html(currentAuthor);
			$('.currentCategory').html(currentCategory);
			$('.currentEpisode').html(currentEpisode);
			$('.quote').fadeIn(200);
		})
	}
}

// Native sharing
function shareQuote(){
	currentShareQuote = '"' + currentQuote + '" - ' + currentAuthor;
	window.plugins.socialsharing.share(currentShareQuote, 'A quote from Modern Family', null, 'http://modernfamilyquotes.net');
}

// No internet dialog
function showNoInternetAlert(){
	alert("Sorry, but you need an internet connection to use this app!");
}

// Rate dialog
function showRateDialog(){
	$.mobile.changePage('#rate-dialog', {transition: 'pop', role: 'dialog'});
}

// Rate link in new browser window
function rate(){
	var ref = window.open(encodeURI('http://modernfamilyquotes.net/forward.html'), '_system', 'location=yes');
}