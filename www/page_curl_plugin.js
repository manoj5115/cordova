var successCallback = function() { console.log("Callback received") };
var errorCallback = function(message) { alert("Oops! " + message); };
var callPlugin = function(){
     //var cordova = require('cordova');
     //cordova.exec = cordova.exec || require('cordova/exec');
     data = [{"title":"page1", "content":"Page 1 content!"},
     {"title":"page2", "content":"Page 2 content"},
     {"title":"page3", "content":"Page 3 content"},
     {"title":"page4", "content":"Page 4 content"},
     {"title":"page5", "content":"Page 5 content"}];
            cordova.exec(
                successCallback, // success callback function
                errorCallback, // error callback function
                'PageCurlPlugin', // mapped to our native Java class called "Echo"
                'showPageCurlEffect', // with this action name
                data
            );
    };
