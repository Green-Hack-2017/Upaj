<?php
	require_once 'core.inc.php';
	require_once './includes/config.php';

	if(loggedin())
	{

		// $lis = $_POST['items'];
	 //  $liarray = explode("::", $lis);
	 //  foreach ($liarray as $colony) {
	 //    # code...
	 //    $sqlnew="INSERT INTO `Cities_Colonies`(`city`,`colony`) ".
	 //  "VALUES ".
	 //  "('Aurangabad','$colony')";
	 //  	$newentry=mysqli_query($con,$sqlnew);	
		// if(!$newentry)
		// {				
		// 	echo "0";
		// 	die('Failed: ' . mysql_error());
		// }else{
		// 	echo "1";
		// }
	
	 //  }

		if (isset($_POST['done'])) {
		$f0_submitted = (int) $_POST['f0'];
		$query_update = "UPDATE requests SET is_done='1' WHERE id ='$f0_submitted'";
		$result_update=mysqli_query($con,$query_update);
		echo "YES";
		#header('Location: home.php');
		}

		if (isset($_POST['spam'])) {
		$fs_submitted = (int) $_POST['fs'];
		$query_update1 = "UPDATE requests SET is_spam='1' WHERE id ='$fs_submitted'";
		$result_update1=mysqli_query($con,$query_update1);
		echo "YES";
		#header('Location: home.php');
		}

		if ($_POST['submit']) {
				$ft_submitted = (int) $_POST['ft'];
		        $text = mysqli_real_escape_string($con,$_POST['comments']);
		        $query="UPDATE requests SET solution='$text' WHERE id ='$ft_submitted'";
		        //$query="INSERT INTO report_list (type) VALUES ('$text')";
		        mysqli_query($con,$query) or die ('Error updating database' . mysqli_error());
		        echo "YES";
		 		#header('Location: home.php');
		}

		if (isset($_POST['undos'])) {
		$fus_submitted = (int) $_POST['fus'];
		$query_update = "UPDATE requests SET is_spam='0' WHERE id ='$fus_submitted'";
		$result_update=mysqli_query($con,$query_update);
		#header('Location: spam.php');
		}

		if (isset($_POST['undod'])) {
		$fud_submitted = (int) $_POST['fud'];
		$query_update = "UPDATE requests SET is_done='0' WHERE id ='$fud_submitted'";
		$result_update=mysqli_query($con,$query_update);
		#header('Location: spam.php');
		}

		if (isset($_POST['remove'])) {
		$fr_submitted = (int) $_POST['fr'];
		$img = $fr_submitted.'.jpg';
		unlink('images/'.$img);
		$query_del1 = "DELETE FROM  requests WHERE id ='$fr_submitted'";
		$result_del1=mysqli_query($con,$query_del1);
		
		//echo 'entry with id = '.$fs_submitted.'removed from database';
		#header('Location: spam.php');
		}
		mysqli_close();
	}

		//  select in given radius
		// first create a view using this query than fetch only ids 
		// SELECT
		//   id, (
		//     6371 * acos (
		//       cos ( radians(26.5115) )
		//       * cos( radians( latitude ) )
		//       * cos( radians( longitude ) - radians(80.2334) )
		//       + sin ( radians(26.5115) )
		//       * sin( radians( latitude ) )
		//     )
		//   ) AS distance
		// FROM report_list
		// HAVING distance < 5
		// ORDER BY distance
		// LIMIT 0 , 20;
		?>