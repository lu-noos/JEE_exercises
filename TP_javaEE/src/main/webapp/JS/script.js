let collapsible = document.getElementsByClassName("collapsible");
let content = document.getElementsByClassName("contentnone");

collapsible.addEventListener("click", function() {
	if (content.className == "contentnone") {
		content.className = "contentshow";
	} else {
		content.className = "contentnone";
	}
});
