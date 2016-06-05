$(document).ready(function() {
	$("#submitCdssReq").click(function() {
		var frm = $("#cdssRequest");
	    frm.submit(function (ev) {
	        $.ajax({
	            type: frm.attr('method'),
	            //url: frm.attr('action'),
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