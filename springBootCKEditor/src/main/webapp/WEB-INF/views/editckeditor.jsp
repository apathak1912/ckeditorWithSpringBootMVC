<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>A Simple Page with CKEditor</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/ckeditor.css">
<script type="text/javascript" src="/resources/js/app.js"></script>
<!-- Make sure the path to CKEditor is correct. -->
<script src="/resources/js/ckeditor/ckeditor.js"></script>
<script>

</script>

<title>Spring Boot</title>
</head>
    <body>
    	<a href="/alldescription" class="dis-block txt3 hov1 p-r-30 p-t-10 p-b-10 p-l-30">
							Alldescription
							<hr>
							<i class="fa fa-long-arrow-right m-l-5"></i>
		</a>
    	<div class = "div1">
    	<form action="/ckeditordata" method="post" onsubmit="getCkEditordata()">
    		 <div>
    		<label for="test">Description</label>
			<span><input name="Description" id="Description" type="text" /></span>
    		</div> 
    		<hr>
    		<div>
		            <textarea name="edit" id="edit" rows="10" cols="80">
		                ${econtenet}
		            </textarea>
		             <script>
		                // Replace the <textarea id="editor1"> with a CKEditor
		                // instance, using default configuration.
		                CKEDITOR.replace( 'edit');
		                
		            </script> 
		            <input type="submit" value="Submit"><input type="button" value="Edit" onclick="disableView()">
        		
    		  </div>
    		</form>
    		</div>
    
    </body>
</html>