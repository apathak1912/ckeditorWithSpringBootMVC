function validate() {
	var name = document.getElementById("name").value;
	if (name == '') {
		alert('Please enter a valid name.');
		return false;
	} else {
		return true;
	}
}

function getCkEditordata(){
	var ckdata = CKEDITOR.instances.editor1.getData();
	//document.getElementById("editor1").innerHTML =ckdata; 
}