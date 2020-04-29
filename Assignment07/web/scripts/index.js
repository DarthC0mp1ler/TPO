function callback(response) {
	$("#date").html(response.date);
}

function ajax_post() {
	$.post(
        "/Assignment07/date",
		{atr: "date"},
        callback,
        "json");
}

setInterval(ajax_post, 1000);