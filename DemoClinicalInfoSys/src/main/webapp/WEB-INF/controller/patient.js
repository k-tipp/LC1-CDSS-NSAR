$(document).ready(function() {
	$("#sendCdssRequest").click(function() {
		var frm = $("#cdssRequest");
		var test = frm.serialize();
		alert(test);
	    frm.submit(function (ev) {
	        $.ajax({
	            type: frm.attr('method'),
	            url: frm.attr('action'),
	            enctype: frm.attr('enctype'),
	            data: frm.serialize(),
	            success: function (data) {
	                alert('ok');
	            }
	        });

	        ev.preventDefault();
	    });
	});

});