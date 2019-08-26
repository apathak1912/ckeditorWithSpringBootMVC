function validate() {
	var name = document.getElementById("name").value;
	if (name == '') {
		alert('Please enter a valid name.');
		return false;
	} else {
		return true;
	}
}

function validateForm() {
	  var x = document.forms["myForm"]["email"].value;
	  var atpos = x.indexOf("@");
	  var dotpos = x.lastIndexOf(".");
	  if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
	    alert("Not a valid e-mail address");
	    return false;
	  }
	}

function getCkEditordata(){
	var ckdata = CKEDITOR.instances.editor1.getData();
	//document.getElementById("editor1").innerHTML =ckdata; 
}