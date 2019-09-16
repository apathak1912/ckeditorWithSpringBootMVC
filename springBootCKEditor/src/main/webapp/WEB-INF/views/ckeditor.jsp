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

<title>Spring Boot</title>
</head>
    <body>
    	<a href="./alldescription" class="dis-block txt3 hov1 p-r-30 p-t-10 p-b-10 p-l-30">
							Alldescription
							<i class="fa fa-long-arrow-right m-l-5"></i>
		</a>
    	<div class = "div1">
    	<form action="/ckeditordata" method="post" onsubmit="getCkEditordata()">
    		< <div>
    		<label for="test">Description</label>
			<span><input name="Description" id="Description" type="text" /></span>
    		</div> 
    		<hr>
    		<div>
		            <textarea name="editor1" id="editor1" rows="10" cols="80">
		                This is my textarea to be replaced with CKEditor.
		            </textarea>
		            <script>
		                // Replace the <textarea id="editor1"> with a CKEditor
		                // instance, using default configuration.
		                CKEDITOR.replace( 'editor1' );
		            </script>
		            <input type="submit" value="Submit">
        		
    		  </div>
    		</form>
    		</div>
    
    </body>
</html>