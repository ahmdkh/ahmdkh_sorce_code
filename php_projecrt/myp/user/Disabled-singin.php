<?
     $dots='../';
	
	include_once($dots.'classes/config.php');
	
	  if ($_SESSION['user']['id'])
	 { 
	 
		errorMessage('أنت حالياً مسجل دخول في الموقع');
		redirect($dots.'index.php');
      

	  }
if ($_POST['submitForm'])
	{
//		$x = dbQuery('select * from user where usersname like '.mysql_real_escape_string($_POST['username_input']).' and password like '.md5($_POST['password_input']))
		
	if (!dbNumRows('person_disibility', '`Person_ID` like "'.mysql_real_escape_string($_POST['Person_ID']).'"  and  `Id_card_disability` like "'.mysql_real_escape_string($_POST['Id_card_disability']).'" '))
		{
			errorMessage('الرقم الذي ادخلته خاطئ');
			redirect('singin.php');
		}
		else
		{
			$result = dbQuery('select * from `person_disibility` where `Person_ID` like "'.mysql_real_escape_string($_POST['Person_ID']).'" and  `Id_card_disability` like "'.mysql_real_escape_string($_POST['Id_card_disability']).'"  ');
			$arr = mysql_fetch_array($result);
			$_SESSION['user']['name'] = $arr['Applicants_First_Name'].$arr['Applicants_Last_Name'];
			$_SESSION['user']['id'] = $arr['Id_card_disability'];
			$_SESSION['user']['privilege'] = 1;
			successMessage('تم تسجيل دخولك بنجاح في الموقع');
		
			redirect($dots.'index.php');
		}
	}
	  
	
	$content = '<form action="'.$_SERVER['PHP_SELF'].'" method="POST">';
	$topTitle = 'تسجيل الدخول';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			رقم بطاقة المعاق
		</div>
		<div class="cell">
			<input type="text" name="Id_card_disability"  class="niceInput" value="'.$_POST['Id_card_disability'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
		رقم البطاقة الشخصية
		</div>
		<div class="cell">
			<input type="text" name="Person_ID"  class="niceInput" value="'.$_POST['Person_ID'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			&nbsp;
		</div>
		<div class="cell">
			<input type="submit" name="submitForm" class="submitInput" value="تسجيل الدخول" />
		</div>
		<div class="clear">
		</div>
	</div>
	';
	$content.= '</form>';

	view();
?>  
	  
	  
	  
	  
	  
	  
	  


	