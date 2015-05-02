<?php
	function signin($user,$pass){
	
	session_start();
	include 'vars.php';
	define('SALT', '@@*!@flyr_zomfg!impaskip-mail_(HACKATHONCCNY)!@#**');
	$data = "fail";
	if (isset($user) and isset($pass)){
	$secret = md5($pass.SALT);
	$query = "SELECT * FROM `users` WHERE `name`='$user' AND `password`='$secret'";
	$result = mysql_query($query) or die(mysql_error());
	$count = mysql_num_rows($result);

	$id = "-1";

if ($count == 1){
$query  = "SELECT * FROM `users` WHERE `name` = '$user'";
$result666 = mysql_query($query);
while($row = mysql_fetch_array($result666)) {
    $cash = $row['cash'];
	$id = $row['id'];
}

$data = array (
	"success" => "true",
	"id" => $id,
    "username"  => $user,
    "cash" => $cash,
    "pos"   => $id,
	"msg" => "Logging In"
	);
}else{
$data = array (
	"success" => "false",
	"id" => $id,
    "username"  => $user,
    "cash" => "0",
    "pos"   => "-1",
	"msg" => "Invalid Credentials"
	);
}

}
return $data;

	}


?>
