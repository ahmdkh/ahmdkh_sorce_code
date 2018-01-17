<?
	$dots='../';
	include($dots.'classes/config.php');
	

if ($_SESSION['user']['id'])
{
if($_SESSION['user']['privilege'] ==1)
          {
		  $content.='<div id="serdis">
		  
		  
	      <div id="sing">
		  <div class="singinitem"><a href="Disabled-signUp.php">إصدار بطاقه معاق</a></div>
		  <div class="singinitem"><a href="renewing.php">تجديد بطاقه معاق</a></div>
		  <div class="singinitem"><a href="search-for-job.php">البحث عن فرصه عمل مناسبة</a></div>
		  </div>
		  </div>';
		  }
		  if($_SESSION['user']['privilege'] ==0)
		  {
		  $content.='<div id="serdis">
		   <div id="sing">
		  <div class="singinitem"><a href="SignUp-Organization-p.php">تسجيل فرصه عمل بالموقع لشركه عامه</a></div>
		  <div class="singinitem"><a href="SignUp-Organization-s.php">تسجيل فرصه عمل بالموقع لشركه خاصه</a></div>
		  
		  </div>
		  
		  
		  </div>';
		  }
}
else
{
redirect($dots.'index.php');
}

	view();
?>