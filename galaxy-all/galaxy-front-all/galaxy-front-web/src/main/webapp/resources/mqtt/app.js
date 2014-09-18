var MqttClientApp = {};
MqttClientApp.listeners = new Jvent();
MqttClientApp.credentials = { public: false };
MqttClientApp.sessionStorageManager = new CookieStorageManager();
MqttClientApp.appViewController = new AppViewController();
MqttClientApp.alertViewController = new AlertViewController();
MqttClientApp.subscriptionManager = new SubscriptionsManager();
MqttClientApp.publisher = new Publisher();

MqttClientApp.listeners.emit('showAlert', "This application is intended to work with brokers that are compliant with the standard <a href=\"http://git.eclipse.org/c/paho/org.eclipse.paho.mqtt.javascript.git/tree/src/mqttws31.js\" target=\"_blank\">mqttws31.js file</a> provided by eclipse.org. It is not intended to proxy MQTT messages to noncompliant brokers");