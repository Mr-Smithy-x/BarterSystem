<?php
$mysql_host = "localhost";
$mysql_database = "barter";
$mysql_user = "root";
$mysql_password = "windows7";
$account_table = "Users";
mysql_connect($mysql_host, $mysql_user, $mysql_password);
mysql_select_db("$mysql_database") or die('error');
?>