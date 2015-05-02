<?php
	function add_item($item_id, $name, $img, $type, $desc, $origin, $owner, $loc, $owner_id){
		include 'vars.php';
		header("Content-Type:application/json");
		define('SALT', '@@*!@flyr_zomfg!impaskip-mail_(HACKATHONCCNY)!@#**');
		$db = mysql_connect($mysql_host, $mysql_user, $mysql_password);
		if(!$db){
			die('There was an error: '. mysql_error());
			return "Server has gone away :(";
		}else{
			$db_selected = mysql_select_db("$mysql_database") or die('error');
			$add = "INSERT INTO events (item_name, item_img, item_type, item_desc, item_origin, item_owner, item_loc, owner_id) values ('$name', '$img', '$type', '$desc','$origin', '$owner', '$loc', '$owner_id')";
			$res = mysql_query($sql);
			mysql_close($db);
			return "Your item was posted!";
		}
	}
	function getitem(){
		include 'vars.php';
		header("Content-Type:application/json");
		$db = mysql_connect($mysql_host, $mysql_user, $mysql_password);
		$data = "No Items";
		$stack = array();
		if(!$db){
			die('There was an error: '. mysql_error());
			return "Server has gone away :(";
		}else{
			$db_selected = mysql_select_db("$mysql_database") or die('error');
			$add = "SELECT * FROM events WHERE 1";
			$res = mysql_query($add);
			mysql_close($db);
			while(($resp = mysql_fetch_assoc($res)) != null){
				$id = $resp['item_id'];
				$name = $resp['item_name'];
				$img= $resp['item_img'];
				$type = $resp['item_type'];
				$desc = $resp['item_desc'];
				$origin = $resp['item_origin'];
				$owner = $resp['item_owner'];
				$loc = $resp['item_loc'];
				$owner_id = $resp['owner_id'];
				$data = array (
				"itemid" => $id,
				"name" => $name,
				"img" => $img,
				"type" => $type,
				"desc" => $desc,
				"origin" => $origin,
				"owner" => $owner,
				"loc" => $loc,
				"ownerid" => $owner_id
			);
			array_push($stack,$data);
			}
			}
			return json_encode($stack);
		
	
	}
	function get_item($from){
		include 'vars.php';
		header("Content-Type:application/json");
		$db = mysql_connect($mysql_host, $mysql_user, $mysql_password);
		$data = "No Items";
		$stack = array();
		if(!$db){
			die('There was an error: '. mysql_error());
			return "Server has gone away :(";
		}else{
			$db_selected = mysql_select_db("$mysql_database") or die('error');
			$add = "SELECT * FROM events WHERE owner_id='$from'";
			$res = mysql_query($add);
			mysql_close($db);
			while(($resp = mysql_fetch_assoc($res)) != null){
				$id = $resp['item_id'];
				$name = $resp['item_name'];
				$img= $resp['item_img'];
				$type = $resp['item_type'];
				$desc = $resp['item_desc'];
				$origin = $resp['item_origin'];
				$owner = $resp['item_owner'];
				$loc = $resp['item_loc'];
				$owner_id = $resp['owner_id'];
				$data = array (
				"itemid" => $id,
				"name" => $name,
				"img" => $img,
				"type" => $type,
				"desc" => $desc,
				"origin" => $origin,
				"owner" => $owner,
				"loc" => $loc,
				"ownerid" => $owner_id
			);
			array_push($stack,$data);
			}
			}
			return json_encode($stack);
		
	
	}
	function search_item($item){
	include 'vars.php';
		header("Content-Type:application/json");
		$db = mysql_connect($mysql_host, $mysql_user, $mysql_password);
		$data = "No Items";
		$stack = array();
		if(!$db){
			die('There was an error: '. mysql_error());
			return "Server has gone away :(";
		}else{
			$db_selected = mysql_select_db("$mysql_database") or die('error');
			$add = "SELECT * FROM events WHERE item_name LIKE '%$item%'";
			$res = mysql_query($add);
			mysql_close($db);
			while(($resp = mysql_fetch_assoc($res)) != null){
				$id = $resp['item_id'];
				$name = $resp['item_name'];
				$img= $resp['item_img'];
				$type = $resp['item_type'];
				$desc = $resp['item_desc'];
				$origin = $resp['item_origin'];
				$owner = $resp['item_owner'];
				$loc = $resp['item_loc'];
				$owner_id = $resp['owner_id'];
				$data = array (
				"itemid" => $id,
				"name" => $name,
				"img" => $img,
				"type" => $type,
				"desc" => $desc,
				"origin" => $origin,
				"owner" => $owner,
				"loc" => $loc,
				"ownerid" => $owner_id
			);
			array_push($stack,$data);
			}
			}
			return json_encode($stack);
		
	
	}
	
	?>