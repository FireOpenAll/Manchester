var SubscriptionsManager = function() {
    var that = this;
    this.susbcriptions = [];
    this.pausedSusbcriptions = [];
    this.notAllowed = [];
    this.listeners = MqttClientApp.listeners;

    this.listeners.addListener("unsubscribe", function(topic) {
        if (that.remove(topic)) {
            MqttClientApp.client.unsubscribe(topic);
        }
    });

    this.listeners.addListener('backgroundMessageArrived', function(message) {
        var messageString = message.payloadString;

        if (messageString.indexOf("is not allowed to subscribe")) {
            var topic = messageString.split("to ").pop().split("\"")[0];

            if ( that.notAllowed.indexOf(topic) == -1) {
                that.notAllowed.push(topic);
            }
        }
    });

    this.listeners.addListener('pauseSubscription', function(topic) {
        that.pause(topic);
    });

    this.listeners.addListener('playSubscription', function(topic) {
        that.play(topic);
    });
};

SubscriptionsManager.prototype.add = function(topic, qos, callback) {
    var that = this;

    MqttClientApp.client.subscribe(topic, qos);

    if (this.susbcriptions.indexOf(topic) > -1) {
        callback(false);
    } else {
        if (MqttClientApp.credentials.public) {
            if (topic.split("/")[0] == "public") {
                that.susbcriptions.push(topic);

                callback(true);
            } else {
                callback(false);
            }
        } else {
            setTimeout(function() {
                if (that.notAllowed.indexOf(topic) == -1) {
                    that.susbcriptions.push(topic);

                    callback(true);
                } else {
                    callback(false);
                }
            }, 300);
        }
    }
};

SubscriptionsManager.prototype.remove = function(topic) {
    var index = this.susbcriptions.indexOf(topic);

    if (index > -1) {
        this.susbcriptions.splice(index, 1);

        index = this.pausedSusbcriptions.indexOf(topic);

        if (index > -1) {
            this.pausedSusbcriptions.splice(index, 1);
        }

        return true;
    } else {
        return false;
    }
};

SubscriptionsManager.prototype.empty = function() {
    this.susbcriptions = [];
    this.pausedSusbcriptions = [];
    this.notAllowed = [];
};

SubscriptionsManager.prototype.pause = function(topic) {
    if (this.pausedSusbcriptions.indexOf(topic) > -1) {
        return false;
    } else {
        this.pausedSusbcriptions.push(topic);

        return true;
    }
};

SubscriptionsManager.prototype.play = function(topic) {
    var index = this.pausedSusbcriptions.indexOf(topic);

    if (index > -1) {
        this.pausedSusbcriptions.splice(index, 1);

        return true;
    } else {
        return false;
    }
};

SubscriptionsManager.prototype.paused = function(topic) {
    var that = this;
    var thatReturn = false;

    !$(this.pausedSusbcriptions).each(function (index, subscription) {
        var splitTopic = subscription.split("/");

        if (splitTopic.indexOf("#") > -1) {
            splitTopic.pop();
            var pausedTopic = splitTopic.join("/");

            if (topic.indexOf(pausedTopic) > -1) {
                thatReturn = true;
                return false;
            }
        } else {
            if (that.pausedSusbcriptions.indexOf(topic) > -1) {
                thatReturn = true;
                return false;
            }
        }
    });

    return thatReturn;
};