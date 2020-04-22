function callback(response) {
	$("#sum").text(response.sum);
}

function ajax_post() {
	var comp1 = $("#comp1").val();
	var comp2 = $("#comp2").val();
	$.post(
        "/Assignment06/add",
		{
			component1 : comp1,
			component2 : comp2
		},
        callback,
        "json");
}

function ajax_get() {
	$.get(
		"/Assignment06/add",
		{
			component1:$("#comp1").val(),
			component2:$("#comp2").val()
		},
		callback,
		"json");
}

$("#comp1").focusout(ajax_post);
$("#comp2").focusout(ajax_get);