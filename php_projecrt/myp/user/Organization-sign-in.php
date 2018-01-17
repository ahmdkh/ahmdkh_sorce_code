<?

	$dots='../';
	include($dots.'classes/config.php');
	///////////////////////////////////
	if ($_SESSION['user']['id'])
	{
		errorMessage('أنت حالياً مسجل دخول في الموقع');
		redirect($dots.'index.php');
	}
	else
      if ($_POST['submitForm'])
	{

		if (!dbNumRows('organization_donor', '`Organization_Name` like "'.mysql_real_escape_string($_POST['name_office']).'" and `password` like "'.md5($_POST['password_input']).'"'))
		{
			errorMessage('اسم الجهة او كلمه المرور خاطئة');
			//redirect($dots.'index.php');
		}
		else
		if (strlen($_POST['name_office'])<1)
		{
			errorMessage('حقل اسم الجهة قارغ يجب تعبئه جميع الحقول');
		}
		
		else
		{
			$result = dbQuery('select * from `organization_donor` where `Organization_Name` like "'.mysql_real_escape_string($_POST['name_office']).'" and `password` like "'.md5($_POST['password_input']).'"');
			$arr = mysql_fetch_array($result);
			$_SESSION['user']['name'] = $arr['Organization_Name'];
			$_SESSION['user']['id'] = $arr['Organization _id'];
			$_SESSION['user']['privilege'] = 0;
			//$_SESSION['user']['privilege'] = $arr['privilege'];
			successMessage('تم تسجيل دخولك بنجاح في الموقع');
			redirect($dots.'index.php');
		}
	
	}
	//////////////////////////////////

	
	$content = '<form action="'.$_SERVER['PHP_SELF'].'" method="POST">';
	$topTitle = 'تسجيل دخول مؤسسة';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			اسم الجهة
		</div>
		<div class="cell">
			<input type="text" name="name_office"  class="niceInput" value="'.$_POST['name_office'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			كلمة المرور
		</div>
		<div class="cell">
			<input type="password" name="password_input" class="niceInput" />
		</div>
		<div class="clear">
		</div>
	</div>
	';
	
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			&nbsp;
		</div>
		<div class="cell">
			<input type="submit" name="submitForm" class="submitInput" value="التسجيل في الموقع" />
		</div>
		<div class="clear">
		</div>
	</div>
	';
	$content.= '</form>';
	
	


////////////////////////////////////////////////////////////////////////////////////////////
	view();
?>