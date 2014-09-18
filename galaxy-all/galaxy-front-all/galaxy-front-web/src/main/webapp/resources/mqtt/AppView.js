var AppView = function() {
    $('[data-toggle=tooltip]').tooltip({
        placement: "top",
        trigger: "hover"
    });

    $("#connectionSettings").keypress(function(event) {
        if (event.which == 13) {
            event.preventDefault();

            $("#doConnect").click();
        }
    });

    $("#doConnect").click(function(e) {
        e.preventDefault();

        MqttClientApp.alertViewController.hide();

        if ($("#clientIdInput").val() == "") {
            $("#clientIdInput").focus();
            MqttClientApp.listeners.emit('failed', this, "client ID can't be empty.");
        } else {
            MqttClientApp.credentials.host = host = $("#hostnameInput").val();
            MqttClientApp.credentials.port = port = $("#portInput").val();
            MqttClientApp.credentials.clientId = clientId = $("#clientIdInput").val();
            MqttClientApp.credentials.password = password = $("#passwordInput").val();
            MqttClientApp.credentials.passwordHashed = passwordHashed = Helpers.md5String(password,
                $("#md5Input").prop("checked"));
            MqttClientApp.credentials.username = username = $("#usernameInput").val();
            MqttClientApp.credentials.keepAlive = keepAlive = $("#keepAliveInput").val();
            MqttClientApp.credentials.useSsl = useSsl = $("#useSslInput").prop("checked");
            MqttClientApp.credentials.lastWillTopic = lastWillTopic = $("#lastWillTopicInput").val();
            MqttClientApp.credentials.lastWillMessage = lastWillMessage = $("#lastWillMessageInput").val();
            MqttClientApp.credentials.lastWillRetain = lastWillRetain = $("#lastWillRetainInput").prop("checked");
            MqttClientApp.credentials.lastWillQos = lastWillQos = $("#lastWillQosInput").val();
            MqttClientApp.credentials.cleanSession = cleanSession = $("#cleanSessionInput").prop("checked");

            MqttClientApp.listeners.emit('connect', host, port, clientId, username, passwordHashed,
                keepAlive, useSsl, cleanSession, lastWillTopic, lastWillMessage, lastWillQos, lastWillRetain);
        }
    });

    $("#generateRandomId").click(function(e) {
        e.preventDefault();

        $("#clientIdInput").val(Helpers.randomString(21))
    });

    $("#doDisconnect").click(function(e) {
        e.preventDefault();

        MqttClientApp.alertViewController.hide();

        MqttClientApp.listeners.emit('disconnect');
    });

    $("#doSubscribe").click(function(e) {
        e.preventDefault();

        MqttClientApp.alertViewController.hide();

        var topic = $("#topicSubInput").val();
        var qos = $("#qosSubInput").val();

        MqttClientApp.listeners.emit('subscribe', topic, qos);
    });

    $("#doPublish").click(function(e) {
        e.preventDefault();

        MqttClientApp.alertViewController.hide();

        var topic = $("#topicPubInput").val();
        var qos = $("#qosPubInput").val();
        var retain = $("#retainPubInput").prop("checked");
        var message = $("#messagePubInput").val();

        MqttClientApp.listeners.emit('publish', topic, message, qos, retain);
    });

    MqttClientApp.sessionStorageManager.loadCredentials();
};

AppView.prototype.messageDiv = function(message) {
    var element = $("<div class=\"well message\">" + '<div class="subscription row"><div class="col-md-9"><span class="label label-primary">' +
        validator.escape(message.destinationName) + '</span></div>' +
        '<div class="col-md-3"><span class="label label-default pull-right">QOS: ' + validator.escape(message.qos) +
        '</span></div></div>' + '<pre class="folded"><code class="hljs">' + validator.escape(message.payloadString) +
        '</code></pre><a href="#" class="btn btn-primary btn-xs expand">Expand</a></div>');

    element.find(".expand").click(function(e) {
        e.preventDefault();

        $(this).parent().find(".folded code").first().each(function(i, code) {
            try {
                $(code).html(JSON.stringify(JSON.parse($(code).html()), null, 2));
            } catch(e) {
                console.log(e);
            }
            hljs.highlightBlock(code);
        });

        $(this).parent().find(".folded").attr("class", "unfolded");
    });

    return element;
};

AppView.prototype.subscriptionDiv = function(topic) {
    var element = $(
        '<div class="subscription row"><div class="col-md-9"><span class="label label-primary">' +
        topic + '</span></div>' +
        '<div class="col-md-3"><a class="stop btn btn-primary btn-xs pull-right" data-topic="' +
        topic + '"><i class="glyphicon glyphicon-remove"></i></a>' +
        '<a class="play-pause btn btn-primary btn-xs pull-right" data-state="pause" data-topic="'
        + topic + '"><i class="glyphicon glyphicon-pause"></i></a></div></div>');

    element.find(".stop").click(function(e) {
        e.preventDefault();

        $(this).parent().parent().remove();
        MqttClientApp.appViewController.emit("unsubscribe", $(this).data("topic"));
    });

    element.find(".play-pause").click(function(e) {
        e.preventDefault();

        if ($(this).data("state") == 'pause') {
            MqttClientApp.appViewController.emit("pauseSubscription", $(this).data("topic"));
            $(this).data("state", "play");
            $(this).find("i").attr("class", "glyphicon glyphicon-play");
        } else {
            MqttClientApp.appViewController.emit("playSubscription", $(this).data("topic"));
            $(this).data("state", "pause");
            $(this).find("i").attr("class", "glyphicon glyphicon-pause");
        }

    });

    return element;
};