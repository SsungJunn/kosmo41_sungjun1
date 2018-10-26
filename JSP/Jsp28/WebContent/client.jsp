<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
   String id = (String)session.getAttribute("id");
   String name = (String)session.getAttribute("name");
   String RNum = (String)session.getAttribute("RNum");

   if(id == null){
%>
   <jsp:forward page="login.jsp" />
<%
   } else {
      session.setAttribute("uid", id);
   }
%>
   <div>
   	  방번호 : [${RNum}]번
      사용자 아이디 : <%= id %>
      
      <div>방 사용자 리스트</div>
   <div>
      <textarea id="AllList" rows="5" cols="30" name="contents" readonly></textarea>
     <!--  <input type = "button" value = "초대"> -->
   </div>   
   
   </div>
   <div>
      <input type ="text" id="messageinput" name="get"/>
   </div>
   <div>
      <button type ="button" onclick="openSocket();">Open</button>
      <button type ="button" onclick="send();">Send</button>
      <button type ="button" onclick="closeSocket();">Close</button>
      <input type="button" value="게시판보기" onclick="javascript:window.location='list.do'">
   </div>
   <form action="logoutOk.do" method="post">
		<input type="submit" value="로그아웃">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="정보수정" onclick="javascript:window.location='modify.jsp'">
		<input type="button" value="방리스트" onclick="javascript:window.location='room.do'">
	</form>
   <!--  Server responses get written here -->
   <div id="messages"></div>
   
   <!-- Script to utilise the WebSocket -->
   <script type ="text/javascript">
      var webSocket;
      var messages = document.getElementById("messages");
         function openSocket(){
         //Ensures only one connection is open at a time
         if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED){
            writeResponse("WebSocket is already opened.");
            return;
         }
         
         //Create a new instance of the websocket
         //webSocket = new WebSocket("ws://localhost/ *ProjectName* /echo");
         webSocket = new WebSocket("ws://localhost:8081/Jsp28/websocketendpoint2");
         
         /**
         * Binds functions to the listeners for the websocket
         */
         webSocket.onopen = function(event){
            //For reasons I can't determine, onopen gets calles twice
            //and the first time event.data is undefined
            //Leave a comment if you know the answer
            openAlram();
            
            if(event.data === undefined)
               return;
            
            writeResponse(event.data); 
            /* peopleList(event.data); */
           	
         };
         
         webSocket.onmessage = function(event){  
        
            writeResponse(event.data);
         };
         
         webSocket.onclose = function(event){
            writeResponse("Connection closed");
         };
      }
      
      /**
      * Sends the value of the text input to the server
      */
      function send(){
    	 var id = "<%= id %>";
         var text = document.getElementById("messageinput").value;
         webSocket.send(<%= RNum %> + " " + id + " | " + text);
      }
      
      function openAlram(){
    	  var id = "<%= id %>";
    	  webSocket.send(<%= RNum %> + " " + id + " | " + "님이 입장하셨습니다.");
      }
      
      function closeSocket(){
         webSocket.close();
      }
      
      
				function writeResponse(text) {
					var othertext = text.split(":");

					if (othertext[0] == "/roomlist") {
						RoomList.innerHTML += othertext[1] + "\n";
					} else if (othertext[0] == "/Alllist") {
						AllListcheck(othertext[1]);
					} else {

						messages.innerHTML += "<br>" + text;
					}

				}

				/* function writeResponse(text) {
 
				} */

				function AllListcheck(othertext) {
					document.getElementById("AllList").innerHTML = "";
					AllList.innerHTML += othertext;
				}
			</script>
</body>
</html>