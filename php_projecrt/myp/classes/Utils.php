<?
	function appendScriptsPage($scriptName)
	{
		global $siteJavaScripts;
		$siteJavaScripts[] = $scriptName;
	}
	function appendCSSPage($scriptName)
	{
		global $siteCSSScripts;
		$siteCSSScripts[] = $scriptName;
	}
	function dbQuery($sql)
	{
		global $connection;
		
		$result = mysql_query($sql, $connection);
		if (!$result)
		{
			errorMessage($sql);
			errorMessage(mysql_error($connection));
			return false;
		}
		return $result;
	}
	function dbInsert($tableName, $fields, $values)
	{
		global $connection;
		if (!is_array($fields) || !is_array($values))
			die('Fields And Values Should Be Arrays');
		$sql = '';
		
		$sql .= 'insert into `'.$tableName.'` (';
		$temp = array();
		foreach($fields as $field)
		{
			$temp[] = '`'.$field.'`';
		}
		$sql.= implode(', ', $temp);
		$sql .=') VALUES (';
		$temp = array();
		foreach($values as $value)
		{
			$temp[] = '"'.mysql_real_escape_string($value).'"';
		}
		$sql.= implode(', ', $temp);
		$sql.=');';
		successMessage($sql);
		mysql_query($sql, $connection);
		
	}
	function dbNumRows($tableName, $condition)
	{
		global $connection;
		$sql = 'select * from `'.$tableName.'` where '.$condition.'';
		$result = mysql_query($sql, $connection);
		if (!$result)
		{
			errorMessage($sql);
			errorMessage(mysql_error($connection));
			return false;
		}
		return mysql_num_rows($result);
	}
	function redirect($to)
	{
		header('Location:'.$to);
		exit();
	}
	function printMessages()	
	{
		$toReturn = "";
		if (is_array($_SESSION['errorMessages']))
		foreach ($_SESSION['errorMessages'] as $msg)
		{
			$toReturn.='<div class="errorMSG">'.$msg.'</div>';
		}
		unset($_SESSION['errorMessages']);
		
		if (is_array($_SESSION['successMessages']))
		foreach ($_SESSION['successMessages'] as $msg)
		{
			$toReturn.='<div class="successMSG">'.$msg.'</div>';
		}
		unset($_SESSION['successMessages']);
		return $toReturn;
	
	}
	function errorMessage($msg)
	{
		$_SESSION['errorMessages'][] = $msg;
	}
	function successMessage($msg)
	{
		$_SESSION['successMessages'][] = $msg;
	}
	function dbSelectRow($table, $condition='', $extra='')
    {
        global $connection;
		if (!$connection)
			return false;
		$sql = "select * from `$table` ";
        if ($condition) $sql.= "where $condition ";
        $sql .= $extra;
		
		$res = mysql_query($sql,$connection);
        if ($res)
        {
            $arr = mysql_fetch_array($res);
            return $arr;
        }
        else
		{
			errorMessage($sql);
			errorMessage(mysql_error());
			
            return false;
		}
    }
	function dbUpdate($table, $elements, $values, $condition, $print=0)
    {
        global $connection;
		if (!sizeof($elements))
			return false;
		$sql = "update `$table` set ";
        if (is_array($elements))
        {
            $toReturn = array();
            for ($i = 0; ($i<sizeof($elements)) && ($i<sizeof($values));$i++)
            {
            if(($values[$i]!='') && ($values[$i]!="''"))
            {
                $toReturn[]= "`".$elements[$i]."` = '".mysql_real_escape_string($values[$i])."'";
            }
            }
            $sql .= implode($toReturn, ', ');
        }
        
		
        if ($condition) $sql.=" where ".$condition;
        
		$res = mysql_query($sql,$connection);
        if ($res)
            return true;
        else
		{
			
			errorMessage($sql);
			errorMessage(mysql_error());
			
            return false;
		}
    }
	function dbSelectRows($table, $condition='', $extra='')
    {
        global $connection;
		$sql = "select * from `$table` ";
        if ($condition) $sql.= "where $condition ";
        $sql .= $extra;
		
		

		$res = mysql_query($sql,$connection);
        if ($res)
        {
            return $res;
        }
        else
		{
			errorMessage($sql);
			errorMessage(mysql_error());
			
            return false;
        }
    }
	function dbDelete($table, $condition)
    {
        global $connection;
		$sql = "delete from `$table` ";
        $sql.= "where $condition ";
		
		$res = mysql_query($sql,$connection);
        
    }
?>