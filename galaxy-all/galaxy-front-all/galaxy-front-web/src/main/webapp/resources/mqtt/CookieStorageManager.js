var CookieStorageManager = function() {
    var that = this;
    this.listeners = MqttClientApp.listeners;
    this.enabled = (typeof(Storage) !== "undefined");
    this.cookieTtl = 30; // in days

    this.listeners.addListener('connect', function(host, port, clientId, username, password,
        keepAlive, useSsl, cleanSession, lastWillTopic, lastWillMessage, lastWillQos, lastWillRetain) {
        if (that.enabled) {
            that.setCookie("host", host);
            that.setCookie("port", port);
            that.setCookie("clientId", clientId);
            that.setCookie("username", username);
            that.setCookie("keepAlive", keepAlive);
            that.setCookie("useSsl", useSsl);
            that.setCookie("cleanSession", cleanSession);
            that.setCookie("md5", $("#md5Input").prop("checked"));
        }
    });
};

CookieStorageManager.prototype.loadCredentials = function() {
    if (this.enabled) {
        if (this.getCookie("host")) {
            $("#hostnameInput").val(this.getCookie("host"));
        }

        if (this.getCookie("port")) {
            $("#portInput").val(this.getCookie("port"));
        }

        if (this.getCookie("clientId")) {
            $("#clientIdInput").val(this.getCookie("clientId"));
        }

        if (this.getCookie("username")) {
            $("#usernameInput").val(this.getCookie("username"));
        }

        if (this.getCookie("keepAlive")) {
            $("#keepAliveInput").val(this.getCookie("keepAlive"));
        }

        if (this.getCookie("useSsl")) {
            $("#useSslInput").prop('checked', JSON.parse(this.getCookie("useSsl")));
        }

        if (this.getCookie("cleanSession")) {
            $("#cleanSessionInput").prop('checked', JSON.parse(this.getCookie("cleanSession")));
        }

        if (this.getCookie("md5")) {
            $("#md5Input").prop('checked', JSON.parse(this.getCookie("md5")));
        }
    }
};

CookieStorageManager.prototype.setCookie = function(cookieName, cookieValue) {
    var d = new Date();
    d.setTime(d.getTime() + (this.cookieTtl * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toGMTString();
    document.cookie = cookieName + "=" + cookieValue + "; " + expires;
};

CookieStorageManager.prototype.getCookie = function(cookieName) {
    var name = cookieName + "=";
    var ca = document.cookie.split(';');

    for(var i = 0; i < ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
    }

    return "";
};