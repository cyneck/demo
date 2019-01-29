<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebScoket广播室</title>
    <script src="/sockjs.js"></script>
    <script src="/stomp.js"></script>
    <script src="/jquery.js"></script>
</head>
<body onload="disconnect()">
<button id="connect" onclick="connect()">连接</button>
<button id="disconnect" onclick="disconnect()" disabled="disabled">断开连接</button>
<br/>
<div id="inputDiv">
    输入消息：<input type="text" id="name"/><br/>
    <button id="sendName" onclick="sendName()">发送</button>
    <br/>
    <p id="response"></p>
</div>
<script>
    var stompClient = null;

    userId1 = 123;
    userId2 = 234;

    //设置连接状态控制显示隐藏
    function setConnected(connected) {
        $("#connect").attr("disabled", connected);
        $("#disconnect").attr("disabled", !connected);
        if (!connected) {
            $("#inputDiv").hide();
        } else {
            $("#inputDiv").show();
        }
        $("#reponse").html("");
    }

    //连接
    function connect() {
        //连接/websocket端点
        var socket = new SockJS("/websocket");
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            setConnected(true);
            console.log("connected : " + frame);
            // 根据不同的用户自行进行路由判断
            //subscribe订阅 ,123的用户的消息的订阅路径 /message
            stompClient.subscribe('/user/' + userId1 + "/message", function (response) {
                showResponse(userId1 + "发送到" + userId2 + ":" + response.body);
            });

            stompClient.subscribe('/topic/getResponse', function (response) {
                showResponse("topic插播广告消息：" + response.body);
            });
        })
    }

    //断开连接
    function disconnect() {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        setConnected(false);
        console.log("disconnected!");
    }

    //发送名称到后台
    function sendName() {
        var name = $("#name").val();
        stompClient.send("/app/toUser", {}, JSON.stringify({'message': name, 'userid': userId1, "toUserId": userId2}));
    }

    //显示socket返回消息内容
    function showResponse(message) {
        $("#response").html($("#response").html() + message + "<br>");
    }
</script>
</body>
</html>
