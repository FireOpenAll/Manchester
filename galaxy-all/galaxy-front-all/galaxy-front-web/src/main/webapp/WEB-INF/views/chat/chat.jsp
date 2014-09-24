<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0015)http://mqtt.io/ -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MQTT聊天室</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport">
		<meta content="IE=edge" http-equiv="X-UA-Compatible">
			<link href="http://mqtt.io/assets/stylesheets/bootstrap.css"
				rel="stylesheet">
				<link href="http://mqtt.io/assets/stylesheets/typography.css"
					rel="stylesheet">
					<link href="http://mqtt.io/assets/stylesheets/ss-standard.css"
						rel="stylesheet">
						<link href="http://mqtt.io/assets/stylesheets/2lemetry.css"
							rel="stylesheet">
							<link href="http://mqtt.io/assets/stylesheets/rainbow.css"
								rel="stylesheet">
								<link href="http://mqtt.io/assets/stylesheets/main.css"
									rel="stylesheet">
									<style type="text/css">
.atlwdg-blanket {
	background: black;
	height: 100%;
	left: 0;
	opacity: .5;
	position: fixed;
	top: 0;
	width: 100%;
	z-index: 1000000;
}

.atlwdg-popup {
	background: white;
	border: 1px solid #666;
	position: fixed;
	top: 50%;
	left: 50%;
	z-index: 10000011;
}

.atlwdg-popup.atlwdg-box-shadow {
	-moz-box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.5);
	-webkit-box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.5);
	box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.5);
	background-color: white;
}

.atlwdg-hidden {
	display: none;
}

.atlwdg-trigger {
	position: fixed;
	background: #013466;
	padding: 5px;
	border: 2px solid white;
	border-top: none;
	font-weight: bold;
	color: white !important;
	display: block;
	white-space: nowrap;
	text-decoration: none !important;
	font-family: arial, FreeSans, Helvetica, sans-serif;
	font-size: 12px;
	box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.5);
	-webkit-box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.5);
	-moz-box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.5);
	border-radius: 0 0 5px 5px;
	-moz-border-radius: 0 0 5px 5px;
}

.atlwdg-trigger.atlwdg-TOP {
	left: 45%;
	top: 0;
}

.atlwdg-trigger.atlwdg-RIGHT {
	left: 100%;
	top: 40%;
	-webkit-transform-origin: top left;
	-webkit-transform: rotate(90deg);
	-moz-transform: rotate(90deg);
	-moz-transform-origin: top left;
	-ms-transform: rotate(90deg);
	-ms-transform-origin: top left;
}

.atlwdg-trigger.atlwdg-SUBTLE {
	right: 0;
	bottom: 0;
	border: 1px solid #ccc;
	border-bottom: none;
	border-right: none;
	background-color: #f5f5f5;
	color: #444 !important;
	font-size: 11px;
	padding: 6px;
	box-shadow: -1px -1px 2px rgba(0, 0, 0, 0.5);
	border-radius: 2px 0 0 0;
}

.atlwdg-loading {
	position: absolute;
	top: 220px;
	left: 295px;
}

@media print {
	.atlwdg-trigger {
		display: none;
	}
}
</style>
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="top-gradient"></div>
		<div class="navbar-header">
			<button class="navbar-toggle collapsed"
				data-target=".navbar-collapse" data-toggle="collapse" type="button">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="http://www.2lemetry.com/">
				<div class="navbar-logo"></div>
			</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="/resources/mqtt/2lemetry MQTT Client.html">MQTT Client</a></li>
			</ul>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="alert alert-warning" id="mainAlert"
					style="display: block;">
					<button class="close" type="button">Ã</button>
					<div class="content">
						This application is intended to work with brokers that are
						compliant with the standard <a
							href="http://git.eclipse.org/c/paho/org.eclipse.paho.mqtt.javascript.git/tree/src/mqttws31.js"
							target="_blank">mqttws31.js file</a> provided by eclipse.org. It
						is not intended to proxy MQTT messages to noncompliant brokers
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="well" id="disconnectSettings">
					<h4 id="connectedTo">
						<span class="info"></span> <a class="btn btn-warning pull-right"
							href="http://mqtt.io/#doDisconnect" id="doDisconnect">Disconnect</a>
					</h4>
				</div>
				<form class="well" id="connectionSettings" role="form">
					<div class="row">
						<div class="col-md-4">
							<div class="page-header">
								<h4>Connection Details</h4>
							</div>
							<div class="row">
								<div class="col-md-8">
									<div class="form-group">
										<label for="hostnameInput">Host Name</label> <input
											class="form-control" data-toggle="tooltip" id="hostnameInput"
											placeholder="Enter host name" title="" value="q.m2m.io"
											data-original-title="Use any MQTT broker that supports web sockets.">
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label for="portInput">Port</label> <input
											class="form-control" id="portInput"
											placeholder="Enter port number" value="8083">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-8">
									<div class="form-group">
										<label for="clientIdInput">Client ID</label> <input
											class="form-control" data-toggle="tooltip" id="clientIdInput"
											placeholder="Enter client ID" title=""
											data-original-title="MQTT client ID. 1-23 characters long.">
									</div>
								</div>
								<div class="col-md-4">
									<div class="btn btn-primary btn-xs" id="generateRandomId">Generate</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="cleanSessionInput">Session</label>
										<div class="checkbox">
											<label data-toggle="tooltip" title=""
												data-original-title="Uncheck to preserve the list of subscriptions and to receive queued QOS 1 and 2 messages.">
												<input checked="checked" id="cleanSessionInput"
												type="checkbox"> Clean Session 
											</label>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="useSslInput">SSL</label>
										<div class="checkbox">
											<label> <input id="useSslInput" type="checkbox">
													Use SSL </label>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="keepAliveInput">Keep Alive</label> <input
											class="form-control" data-toggle="tooltip"
											id="keepAliveInput" placeholder="Enter keep alive time"
											title="" value="30"
											data-original-title="Keep alive in seconds.">
									</div>
								</div>
								<div class="col-md-6"></div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="page-header">
								<h4>Credentials</h4>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label for="usernameInput">Username</label> <input
											class="form-control" id="usernameInput"
											placeholder="Enter username">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label for="passwordInput">Password</label> <input
											class="form-control" id="passwordInput"
											placeholder="Enter password" type="password">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="checkbox">
										<label data-toggle="tooltip" title=""
											data-original-title="q.m2m.io requires passwords to be hashed.">
											<input checked="checked" id="md5Input" type="checkbox">
												Hash password with MD5 
										</label>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="page-header">
								<h4>Last-Will</h4>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label for="lastWillTopicInput">Last-Will Topic</label> <input
											class="form-control" id="lastWillTopicInput"
											placeholder="Enter last-will topic">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label for="lastWillMessageInput">Last-Will Message</label>
										<textarea class="form-control" id="lastWillMessageInput"
											placeholder="Enter last-will message" rows="3"></textarea>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="lastWillQosInput">Last-Will QoS</label> <select
											class="form-control" data-toggle="tooltip"
											id="lastWillQosInput" title=""
											data-original-title="QoS1: at most once, QoS2: at least once, QoS3: exactly once.">
											<option>0</option>
											<option>1</option>
											<option>2</option>
										</select>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="lastWillRetainInput">Last-Will Retain</label>
										<div class="checkbox">
											<label> <input id="lastWillRetainInput"
												type="checkbox"> Retain </label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 text-center">
							<hr>
								<a class="btn btn-success btn-lg"
									href="http://mqtt.io/#doConnect" id="doConnect">Connect</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row" id="mqttActions">
			<div class="col-md-6">
				<div class="row">
					<div class="col-md-12">
						<h3>Subscribe</h3>
						<form class="well" role="form">
							<div class="row">
								<div class="col-md-10">
									<div class="form-group">
										<label for="topicSubInput">Topic</label> <input
											class="form-control" id="topicSubInput"
											placeholder="your-domain/topic-name">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label for="qosSubInput">QoS</label> <select
											class="form-control" data-toggle="tooltip" id="qosSubInput"
											title=""
											data-original-title="QoS1: at most once, QoS2: at least once, QoS3: exactly once.">
											<option>0</option>
											<option>1</option>
											<option>2</option>
										</select>
									</div>
								</div>
							</div>
							<a class="btn btn-primary" href="http://mqtt.io/#doSubscribe"
								id="doSubscribe">Subscribe</a>
							<div class="row" id="subscriptions">
								<div class="col-md-12">
									<hr>
										<h4>Subscriptions</h4>
										<div id="subscriptionsList"></div>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-12">
						<h3>Publish</h3>
						<form class="well" role="form">
							<div class="row">
								<div class="col-md-10">
									<div class="form-group">
										<label for="topicPubInput">Topic</label> <input
											class="form-control" id="topicPubInput"
											placeholder="your-domain/topic-name">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label for="qosPubInput">QoS</label> <select
											class="form-control" data-toggle="tooltip" id="qosPubInput"
											title=""
											data-original-title="QoS1: at most once, QoS2: at least once, QoS3: exactly once.">
											<option>0</option>
											<option>1</option>
											<option>2</option>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label for="messagePubInput">Payload Message</label>
										<textarea class="form-control" id="messagePubInput"
											placeholder="Enter your payload" rows="3"></textarea>
									</div>
								</div>
							</div>
							<a class="btn btn-primary" href="http://mqtt.io/#doPublish"
								id="doPublish">Publish</a> <input id="retainPubInput"
								type="checkbox"> Retain 
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<h3>Messages</h3>
				<div id="messages"></div>
			</div>
		</div>
	</div>
	<div class="footer">
		<p class="navbar-text navbar-left">Â© Copyright 2014 2lemetry,
			LLC. All Rights Reserved.</p>
	</div>
	<script src="/resources/mqtt/jquery-1.9.1.min.js"></script>
	<script src="/resources/mqtt/bootstrap.min.js"></script>
	<script src="/resources/mqtt/mqttws31.js"></script>
	<script src="/resources/mqtt/md5.js"></script>
	<script src="/resources/mqtt/enc-base64.js"></script>
	<script src="/resources/mqtt/jvent.js"></script>
	<script src="/resources/mqtt/validator.js"></script>
	<script src="/resources/mqtt/highlight.min.js"></script>
	<script src="/resources/mqtt/Helpers.js"></script>
	<script src="/resources/mqtt/Settings.js"></script>
	<script src="/resources/mqtt/WebSocketClient.js"></script>
	<script src="/resources/mqtt/AppViewController.js"></script>
	<script src="/resources/mqtt/AlertViewController.js"></script>
	<script src="/resources/mqtt/AppView.js"></script>
	<script src="/resources/mqtt/SubscriptionsManager.js"></script>
	<script src="/resources/mqtt/Publisher.js"></script>
	<script src="/resources/mqtt/CookieStorageManager.js"></script>
	<script src="/resources/mqtt/app.js"></script>
	<script
		src="/resources/mqtt/com.atlassian.jira.collector.plugin.jira-issue-collector-plugin-issuecollector.js"
		type="text/javascript"></script>


	<a href="http://mqtt.io/#" id="atlwdg-trigger"
		class="atlwdg-trigger atlwdg-SUBTLE">Provide Feedback</a>
	<div id="atlwdg-blanket" class="atlwdg-blanket" style="display: none;"></div>
	<div id="atlwdg-container"
		class="atlwdg-popup atlwdg-box-shadow atlwdg-hidden"></div>
</body>
</html>