/**
 * 
 */
$(document).ready(function() {
	var rate = $("#avgrating").val();
	for (i = 1; i <= rate; i++) {
	    $("#ratedstar-"+i).attr("class","rated-star");
	}
});