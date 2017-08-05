<?php 

require_once 'core.inc.php';
require_once './includes/config.php';
//echo "1";

if ($_POST['submit']) {
				$ft_submitted = (int) $_POST['ft'];
		        $text = mysqli_real_escape_string($con,$_POST['comments']);
		        $query="UPDATE requests SET solution='$text' WHERE id ='$ft_submitted'";
		        //$query="INSERT INTO report_list (type) VALUES ('$text')";
		        mysqli_query($con,$query) or die ('Error updating database' . mysqli_error());
				//echo "2";
		        $query1 = "SELECT mobile from user where id in(select user_id from requests where id = $ft_submitted)";

		        //mysqli_query($con,$query) or die ('Error updating database' . mysqli_error());
		        $mobile = "+91";
		        if($query_run = mysqli_query($con,$query1)){
				
					$num_rows = mysqli_num_rows($query_run);

					if($num_rows ==0){
						echo "Ïnvalid username/password combination!";
					}else if($num_rows == 1){
					// $user_id = mysql_result($query_run, 0, 'id');
						while($row = mysqli_fetch_assoc($query_run)) {
						   $mobile.= $row['mobile'];
						}
						//echo $mobile;
					}
				} else {
					//echo "Nooooo";
				}	

				////   message sending code
				// require './vendor/autoload.php';
				require_once 'vendor/autoload.php';
				//use \Twilio\Rest\Client; 
 
				$sid = 'generate your sid Twilio'; 
				$token = 'genetrate your token usinf Twilio'; 
				// $client = new Client($account_sid, $auth_token);
				$client = new Twilio\Rest\Client($sid, $token);
 
				 
				// $messages = $client->accounts("AC6350acf9811560460afb80b2ebf3ce3d") 
				//   ->messages->create($mobile, array( 
				//         'From' => "+12567438399",  
				//         'Body' => $text,      
				//   ));

				try{
					$message = $client->messages->create(
					  '+919999388424', // Text this number
					  array(
					    'from' => '+12567438399', // From a valid Twilio number
					    'body' => $text
					  )
					);
				} catch (Exception $e) {
		            //echo $e->getMessage();
		        }
				//print $message->sid;
		      	echo "YES";
		 		#header('Location: home.php');
		}

?>
