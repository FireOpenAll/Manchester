var Publisher = function() {
    var that = this;
    this.notAllowed = [];
    this.listeners = MqttClientApp.listeners;

    this.listeners.addListener('backgroundMessageArrived', function(message) {
        var messageString = message.payloadString;

        if (messageString.indexOf("is not allowed to publish") != -1) {
            var topic = messageString.split("on ").pop().split("\"")[0];

            if ( that.notAllowed.indexOf(topic) == -1) {
                that.notAllowed.push(topic);
            }
        }
    });
};

Publisher.prototype.publish = function(topic, message, qos, retain, callback) {
    var that = this;

    MqttClientApp.client.publish(topic, message, qos, retain);

    if (MqttClientApp.credentials.public) {
        if (topic.split("/")[0] == "public") {
            callback(true);
        } else {
            callback(false);
        }
    } else {
        setTimeout(function() {
            if (that.notAllowed.indexOf(topic) == -1) {
                callback(true);
            } else {
                callback(false);
            }
        }, 300);
    }
};