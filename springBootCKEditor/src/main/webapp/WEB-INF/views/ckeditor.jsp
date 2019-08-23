<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>A Simple Page with CKEditor</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>
<!-- Make sure the path to CKEditor is correct. -->
<script src="/resources/js/ckeditor/ckeditor.js"></script>

<title>Spring Boot</title>
</head>
    <body>
    	<div class = "div1">
    		<div>
    		</div>
    		<hr>
    		<div>
    			<form action="/ckeditordata" method="post" onsubmit="getCkEditordata()">
		            <textarea name="editor1" id="editor1" rows="10" cols="80">
		                This is my textarea to be replaced with CKEditor.
		            </textarea>
		            <script>
		                // Replace the <textarea id="editor1"> with a CKEditor
		                // instance, using default configuration.
		                CKEDITOR.replace( 'editor1' );
		            </script>
		            <input type="submit" value="Submit">
        		</form>
    		</div>
    		<hr>
    		<div>
    		</div>
        </div>
    </body>
</html>