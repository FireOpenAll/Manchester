<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Copyright Trevor D Miller 2013 -->

<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="/resources/css/style.css" />
		<script src="/resources/js/jquery-1.10.2.min.js"></script>
		<script>
			// Turn off jQuery Mobile transitions for faster use
			$(document).bind("mobileinit", function() {   
					$.mobile.defaultPageTransition = 'none';
			});
			// Allow swiping to open menu panels
			$( document ).on( "pageinit", ".ui-page", function() {
			  var $page = $(this);
			  $page.on( "swipeleft swiperight", function( e ) {
			    if ( $page.jqmData( "panel" ) !== "open" ) {
			      if ( e.type === "swipeleft"  ) {
			        $page.find( ".right-panel" ).panel( "open" );
			      } else if ( e.type === "swiperight" ) {
			        $page.find( ".left-panel" ).panel( "open" );
			      }
			    }
			  });
			});
		</script>
		<script src="/resources/js/functions-ck.js"></script>
		<script src="/resources/js/jquery.mobile-1.3.2.min.js"></script>
		<script src="/resources/js/quotes.js"></script>
		<script type="text/javascript" src="phonegap.js"> </script>
		<script type="text/javascript" src="cordova.js"></script>
		<script src="/resources/js/plugins/SocialSharing.js"></script>
	</head>
	<body>

		<!-- Home Page -->
		<div data-role="page" id="home" data-theme="a">
			<div data-role="panel" data-display="overlay" id="menu-panel" class="right-panel" data-position="right">
				<a href="#filters" class="btn-primary" data-role="button" id="FiltersButton" data-icon="tag" >Filter by character</a>
				<a href="#search" class="btn-primary" data-role="button" id="SearchButton" data-icon="search" >Search quotes</a>
				<a href="#" data-role="button" class="btn-primary rate-btn" data-icon="star-empty" >Rate app</a>
				<a href="mailto:feedback@modernfamilyquotes.net?subject=Modern%20Family%20Quotes%20App%20Feedback" class="btn-primary" data-role="button" data-icon="envelope-alt" >Give feedback</a>
				<a href="mailto:submit@modernfamilyquotes.net?subject=A%20Quote%20For%20The%20Modern%20Family%20Quotes%20App" class="btn-primary" data-role="button" data-icon="envelope-alt" >Submit a quote</a>
				<a href="#menu-panel" data-role="button" class="close" data-icon="remove">Close menu</a>
			</div>
			<div data-role="header"  class="custom-header" data-tap-toggle="false" data-id="header" >
				<a href="#menu-panel" class="menu"><span class="ui-icon-reorder"></span></a>
				<div class="logo">Modern Family <span class="logo-highlight">Q</span>uotes</div>
			</div>
			<div data-role="content">
				<div class="quote">
					<p>
						<span class="quote-icon ui-icon-quote-left"></span>
						<span class="currentQuote"></span>
						<span class="quote-icon ui-icon-quote-right"></span>
					</p>
					<p class="meta-data">
						- <span class="currentAuthor"></span><br>
						<span class="currentEpisode"></span><br>
						<span class="filters-container">
							<a href="#filters" data-role="button" class="filters-btn" data-inline="true"><span class="ui-icon-tag"></span> Filter: <span class="filter"></span></span></a>
						</span>
					</p>
					<div class="clear"></div>
				</div>
				<div class="custom-footer">
					<a href="#" class="btn-primary footer-btn" data-role="button" id="RandomButton" data-icon="random">New random quote</a>
					<a href="#" class="btn-primary footer-btn" data-role="button" id="share-btn" data-icon="share-alt">Share this quote</a>
				</div>
			</div>
		</div>

		<!-- Filters Page -->
		<div data-role="page" id="filters" data-theme="a">
			<div data-role="panel" data-display="overlay" id="menu-panel" class="right-panel" data-position="right">
				<a href="#home" class="btn-primary" data-role="button" data-icon="quote-left" >Quotes</a>
				<a href="#search" class="btn-primary" data-role="button" id="SearchButton" data-icon="search" >Search quotes</a>
				<a href="#" data-role="button" class="btn-primary rate-btn" data-icon="star-empty" >Rate app</a>
				<a href="mailto:feedback@modernfamilyquotes.net?subject=Modern%20Family%20Quotes%20App%20Feedback" class="btn-primary" data-role="button" data-icon="envelope-alt" >Give feedback</a>
				<a href="mailto:submit@modernfamilyquotes.net?subject=A%20Quote%20For%20The%20Modern%20Family%20Quotes%20App" class="btn-primary" data-role="button" data-icon="envelope-alt" >Submit a quote</a>
				<a href="#menu-panel" data-role="button" class="close" data-icon="remove">Close menu</a>
			</div>
			<div data-role="header" class="custom-header" data-tap-toggle="false" data-id="header" >
				<a href="#menu-panel" class="menu"><span class="ui-icon-reorder"></span></a>
				<div class="logo">Modern Family <span class="logo-highlight">Q</span>uotes</div>
			</div>
			<div data-role="content">
				<h1>Filter by character</h1>
				<form>
					<fieldset class="filters" data-role="controlgroup">
				        <input Search type="radio" name="radio" id="allRadioButton" value="on" checked="checked">
				        <label id="all" for="allRadioButton">No filter - see all quotes</label>
				        <input Search type="radio" name="radio" id="alexRadioButton" value="off">
				        <label id="alex" for="alexRadioButton">Alex</label>
				        <input Search type="radio" name="radio" id="cameronRadioButton" value="off">
				        <label id="cameron" for="cameronRadioButton">Cameron</label>
				        <input Search type="radio" name="radio" id="claireRadioButton" value="off">
				        <label id="claire" for="claireRadioButton">Claire</label>
				        <input Search type="radio" name="radio" id="gloriaRadioButton" value="off">
				        <label id="gloria" for="gloriaRadioButton">Gloria</label>
				        <input Search type="radio" name="radio" id="haleyRadioButton" value="off">
				        <label id="haley" for="haleyRadioButton">Haley</label>
				        <input Search type="radio" name="radio" id="jayRadioButton" value="off">
				        <label id="jay" for="jayRadioButton">Jay</label>
				        <input Search type="radio" name="radio" id="lukeRadioButton" value="off">
				        <label id="luke" for="lukeRadioButton">Luke</label>
				        <input Search type="radio" name="radio" id="mannyRadioButton" value="off">
				        <label id="manny" for="mannyRadioButton">Manny</label>
				        <input Search type="radio" name="radio" id="mitchellRadioButton" value="off">
				        <label id="mitchell" for="mitchellRadioButton">Mitchell</label>
				        <input Search type="radio" name="radio" id="philRadioButton" value="off">
				        <label id="phil" for="philRadioButton">Phil</label>
				    </fieldset>
				</form>
			</div>
		</div>

		<!-- Search Page -->
		<div data-role="page" id="search" data-theme="a">
			<div data-role="panel" data-display="overlay" id="menu-panel" class="right-panel" data-position="right">
				<a href="#home" class="btn-primary" data-role="button" data-icon="quote-left" >Quotes</a>
				<a href="#filters" class="btn-primary" data-role="button" id="FiltersButton" data-icon="tag" >Filter by character</a>
				<a href="#" data-role="button" class="btn-primary rate-btn" data-icon="star-empty" >Rate app</a>
				<a href="mailto:feedback@modernfamilyquotes.net?subject=Modern%20Family%20Quotes%20App%20Feedback" class="btn-primary" data-role="button" data-icon="envelope-alt" >Give feedback</a>
				<a href="mailto:submit@modernfamilyquotes.net?subject=A%20Quote%20For%20The%20Modern%20Family%20Quotes%20App" class="btn-primary" data-role="button" data-icon="envelope-alt" >Submit a quote</a>
				<a href="#menu-panel" data-role="button" class="close" data-icon="remove">Close menu</a>
			</div>
			<div data-role="header"  class="custom-header" data-tap-toggle="false" data-id="header" >
				<a href="#menu-panel" class="menu"><span class="ui-icon-reorder"></span></a>
				<div class="logo">Modern Family <span class="logo-highlight">Q</span>uotes</div>
			</div>
			<div data-role="content">
				<h1>Search quotes</h1>
				<ul data-role="listview" id="searchList" data-filter-placeholder="Your search here..." data-inset="true" data-filter="true">
					<!-- populates on page load -->
				</ul>
			</div>
		</div>

		<!-- Rate Dialog -->
		<div data-role="dialog" id="rate-dialog" data-theme="a">
		    <div data-role="content">
		    	<h1>What do you think?</h1>
		        <p>Do you like this app? If so, please take ten seconds to rate it. If not, please send some feedback so that the app can get better. Your opinion is very important!</p>
		        <a href="#" data-role="button" class="btn-primary rate-btn" data-icon="star-empty" >Rate app</a>
		        <a href="mailto:feedback@modernfamilyquotes.net?subject=Modern%20Family%20Quotes%20App%20Feedback" class="btn-primary return-home" data-role="button" data-icon="envelope-alt">Submit feedback</a>
		        <a href="#" data-role="button" data-rel="back" data-icon="remove">Make this box go away.</a>
		    </div>
		    <div data-role="footer"></div>
		</div>

	</body>
</html>
