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
	
	var ckedata =CKEDITOR.instances.editor1.getData().replace(/^\s\n+|\s\n+$/g,'');
	alert(ckedata+"ckedata");
	
	if (document.getElementById("Description").value == ''){
		alert("please Feel the description...");				
		return false;
	} 
		if(ckedata == ''){
			alert("please Enter the data Inside Editor...");
			return false;				
		} else {
			alert("inside else cke");
			return true;
		}
	
}

function updateDate(){
	
	document.getElementById("Description").value = CKEDITOR.instances.editor1.getData();
	
} 