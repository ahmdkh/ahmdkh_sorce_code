<?session_start();
	
	$dbUserName = 'root';
	$dbPassword='root';
	$dbName = 'essd';
	
	
	$connection = mysql_connect('localhost', $dbUserName, $dbPassword);
	mysql_select_db($dbName, $connection);
	
	
	
	include_once('Utils.php');
	include_once('master_page.php');
	include_once('myRegularExpressions.php');
?>