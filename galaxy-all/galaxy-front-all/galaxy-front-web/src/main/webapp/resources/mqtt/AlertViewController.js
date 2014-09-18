var AlertViewController = function() {
    var that = this;

    this.listeners = MqttClientApp.listeners;
    this.mainAlert = $("#mainAlert");

    this.mainAlert.find(".close").click(function(e) {
        e.preventDefault();

        $(this).parent().fadeOut();
    });

    this.listeners.addListener("showAlert", function(text) {
        that.mainAlert.find(".content").html(text).parent().fadeIn();
    });

    this.listeners.addListener("failed", function(webSocketClient, message) {
        that.mainAlert.find(".content").html("Error: " + message).parent().fadeIn();
    });

    this.listeners.addListener("connectionLost", function(webSocketClient, responseObject) {
        if (responseObject.errorCode !== 0) {
            that.mainAlert.find(".content").html("Error: " +
                responseObject.errorMessage).parent().fadeIn();
        }
    });
};

AlertViewController.prototype.hide = function() {
    this.mainAlert.fadeOut();
};