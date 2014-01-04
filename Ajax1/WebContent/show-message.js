function getRequestObject() {
	if (window.XMLHttpRequest) {
		return (new XMLHttpRequest());
	} else if (window.ActiveXObject) {
		return (new ActiveXObject("Microsoft.XMLHTTP"));
	} else {
		return (null);
	}
}

function sendRequest() {
	var request = getRequestObject();
	request.onreadystatechange = function() {
		handleResponse(request);
	};
	request.open("GET", "message-data.html", true);
	request.send(null);
}
function handleResponse(request) {
	if (request.readyState == 4) {
		alert(request.responseText);
	}
}