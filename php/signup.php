<?php
	function signup($user, $pass, $email, $age){
		include 'vars.php';
		header("Content-Type:application/json");
		define('SALT', '@@*!@flyr_zomfg!impaskip-mail_(HACKATHONCCNY)!@#**');
		$db = mysql_connect($mysql_host, $mysql_user, $mysql_password);
		$secret = md5($pass.SALT);
		if(!$db){
			die('There was an error: '. mysql_error());
			return "Server has gone away :(";
		}else{
			$db_selected = mysql_select_db("$mysql_database") or die('error');
			$sql = "SELECT * FROM users where name = '$user'";
			$res = mysql_query($sql);
			if(isset($user) == false){
				mysql_close($db);
				return "0";
			}
			else if($res && mysql_num_rows($res)>0){
				mysql_close($db);
				return "2";
			} 
			else {
				if(isset($user)){
					$add = "INSERT INTO users (name, email, password, age, cash) values ('$user', '$email', '$secret', '$age','{}')";
					$execute = mysql_query($add);
					mysql_close($db);
					return "1";
				}
				mysql_close($db);
			}
		}
	}
?>