<?php
	require_once 'core.inc.php';
	require_once 'includes/config.php';

	if(loggedin()){
	
	//echo '<a href = "logout.php">Log out</a>';
	header("Location: main.php");
	}
	else{
		include 'loginform.inc.php';
		//echo "string";
	}
	//echo "string";
?>