var AppViewController = function() {
    var that = this;

    this.listeners = MqttClientApp.listeners;
    this.appView = new AppView();

    this.listeners.addListener('connected', function(webSocketClient) {
        if (webSocketClient.host.match(Settings.DEFAULT_HOST) &&
            MqttClientApp.credentials.username != "" &&
            MqttClientApp.credentials.password != "") {
            var auth = "Basic " + window.btoa(MqttClientApp.credentials.username + ":" +
                MqttClientApp.credentials.password);

            $.ajax({
                url: "https://api.m2m.io/2/account",
                headers: { 'AUTHORIZATION': auth }}
            ).done(function(data) {
                $("#topicSubInput").val(data.domain + "/#");
                $("#topicPubInput").val(data.domain + "/foo");


                MqttClientApp.credentials.public = false;

                MqttClientApp.backgroundClient = new WebSocketClient(MqttClientApp.credentials.host,
                    MqttClientApp.credentials.port, "WEBSOCKET/" + Helpers.randomString(13));
                MqttClientApp.backgroundClient.connect(MqttClientApp.credentials.username,
                    MqttClientApp.credentials.passwordHashed,
                    MqttClientApp.credentials.keepAlive, MqttClientApp.credentials.useSsl, true, {
                    onSuccess: function() {
                        MqttClientApp.backgroundClient.subscribe(
                            data.domain + "/$SYS/subscribe-errors", 0);
                        MqttClientApp.backgroundClient.subscribe(
                            data.domain + "/$SYS/publish-errors", 0);
                    },
                    onFailure: function(responseObject) {
                        console.log("Background MQTT client failed:");
                        console.log(responseObject);
                    },
                    onMessageArrived: function(message) {
                        that.listeners.emit('backgroundMessageArrived', message);
                    },
                    onConnectionLost: function(responseObject) {
                        console.log("Background MQTT client lost connection:");
                        console.log(responseObject);
                    }
                });
            }).fail(function(e) {
                console.log(e);
            }).always(function() {
                that.connectedState(webSocketClient);
            });
        } else {
            if (webSocketClient.host.match(Settings.DEFAULT_HOST)) {
                MqttClientApp.credentials.public = true;
                $("#topicSubInput").val("public/foobar");
                $("#topicPubInput").val("public/foobar");
            }
            that.connectedState(webSocketClient);
        }
    });

    this.listeners.addListener('connect', function(host, port, clientId, username, password,
        keepAlive, useSsl, cleanSession, lastWillTopic, lastWillMessage, lastWillQos, lastWillRetain) {
        MqttClientApp.client = new WebSocketClient(host, port, clientId);

        MqttClientApp.client.addLastWillMessage(lastWillTopic, lastWillMessage,
            lastWillQos, lastWillRetain);

        MqttClientApp.client.connect(username, password, keepAlive, useSsl, cleanSession, {});
    });

    this.listeners.addListener('disconnect', function() {
        MqttClientApp.client.disconnect();
        if (MqttClientApp.backgroundClient) {
            MqttClientApp.backgroundClient.disconnect();
        }
        MqttClientApp.subscriptionManager.empty();

        that.disconnectedState();
    });

    this.listeners.addListener('subscribe', function(topic, qos) {
        MqttClientApp.subscriptionManager.add(topic, qos, function(subscribed) {
            if (topic != "" && subscribed) {
                $("#subscriptions").show();
                $("#subscriptionsList").prepend(that.appView.subscriptionDiv(validator.escape(topic)));
            } else {
                if (!subscribed) {
                    that.listeners.emit('failed', that, "you can't subscribe to topic \"" + topic + "\"");
                }
            }
        });
    });

    this.listeners.addListener('publish', function(topic, message, qos, retain) {
        MqttClientApp.publisher.publish(topic, message, qos, retain, function(published) {
            if (!topic || !published) {
                that.listeners.emit('failed', that, "you can't publish to topic \"" + topic + "\"");
            }
        });
    });

    this.listeners.addListener('connectionLost', function(webSocketClient, responseObject) {
        that.listeners.emit('disconnected');
    });

    this.listeners.addListener('messageArrived', function(webSocketClient, message) {
        if (!MqttClientApp.subscriptionManager.paused(message.destinationName)) {
            var messageDiv = that.appView.messageDiv(message);
            var messagesDiv = $("#messages");

            if (messagesDiv.find(".message").size() >= Settings.MAX_NUMBER_OF_MESSAGES) {
                messagesDiv.find(".message").last().remove();
            }
            messagesDiv.prepend(messageDiv);
        }
    });

    return this.listeners;
};

AppViewController.prototype.connectedState = function(webSocketClient) {
    $("#connectionSettings").slideUp(function() {
        $("#connectedTo").find(".info").html("Connected to " +
            "<strong>" + webSocketClient.host + ":" +
            webSocketClient.port + "</strong>" +
            " with client ID: " + "<strong>" + webSocketClient.clientId + "</strong>");
        $("#disconnectSettings").slideDown();
        $("#mqttActions").slideDown();
    });
};

AppViewController.prototype.disconnectedState = function() {
    $("#disconnectSettings").slideUp(function() {
        $("#connectedTo").find(".info").html("");
        $("#connectionSettings").slideDown();
        $("#mqttActions").slideUp(function() {
            $("#messages").html("");
            $("#subscriptionsList").html("");
            $("#subscriptions").hide();
        });
    });
};