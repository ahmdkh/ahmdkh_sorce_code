<?
	$dots='';
	include($dots.'classes/config.php');
	
if ($_GET['signOut']==1)
	{
		unset($_SESSION['user']['id']);
		unset($_SESSION['user']['name']);
		successMessage('تم تسجيل خروجك بنجاح');
		redirect('index.php');
	}

else	
if (!($_SESSION['user']['id']))
{
$content.='<div id="sidebar">
		  <div class="item"><a href="user/SingIn.php"><img src="images/picture.jpg" /></a></div>
		  <div class="item"><a href="user/SingUp.php"><img src="images/picture1.jpg"  /></a></div>
		  <div id="text" >
		  
		  
		  </div>
		  
		  </div>';
}

$topTitle ='الصفحه الرئيسية';
//$myRegVar =  new myReg();

//$content.="
//<a href='classes/workp.php' target='_Blank'>تسجيل جهة عامه</a></br>
//<a href='classes/works.php' target='_Blank'> تسجيل جهة خاصه</a></br>
//<a href='classes/Organization-sign-in.php' target='_Blank'>تسجيل الدخول</a></br>
//<a href='classes/SignUp-Chance-Work-s.php' target='_Blank'>الدخول فرصه عمل لشركه خاصه</a></br>
//<a href='classes/SignUp-Chance-Work-p.php' target='_Blank'>تسجيل فرصه عمل المؤسسه عامه</a></br>
//";
	view();
?>