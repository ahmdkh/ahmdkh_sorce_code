<?
	// Here We Put The Function That Views The Total Design
	function view()
	{
		global $dots, $content, $topTitle;
	?>
		<html>
			<head>
				<title>Some Title</title>
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
				<!--<link href='styles/ui.css' rel='stylesheet' type='text/css' />
					<link href='".$dots."styles/style.css' rel='stylesheet' type='text/css' />-->
					<?
					echo "<link href='".$dots."styles/style.css' rel='stylesheet' type='text/css' />";
					?>
				
			</head>
			<body>
     <div id="top">
      	<div id="name"><a href="#">E.S.S.D</a></div>
       <!-- <div id="split"></div>-->
     	<div style="border-top:6px solid #7abb37; background-color:blue; ">
        <div id="slogan">النظام الإلكتروني لخدمات المعوقين</div>
        <div id="contact_us"><a href="#">خريطة الموقع</a></div>
        </div>
    </div>

       <div id="logo">
      <div id="logo_text">
      يتيح الموقع العديد من الخدمات للأشخاص المعاقين
	</div>
   
    <div id="menu">
        <a href="<?echo $dots?>index.php"><b>الصفحة الرئيسية</b></a>|
        <a href="<?echo $dots?>about.php"><b>حول الموقع</b></a>|
        
		<?
		if ($_SESSION['user']['id'])
		{?>
		<a href="<?echo $dots?>user/services.php"><b>الخدمات المتاحة</b></a>|
		<a href="#"><b><?echo $_SESSION['user']['name'];?></b></a>|
		<a href='<?echo $dots?>index.php?signOut=1'>تسجيل خروج</a>|
		<?}
		?>
        <a href="#"><b>احصائيات</b></a>|
        <a href="#"><b>الاتصال بنا</b></a>
    </div>
	
	<div id="contin">
                       
						<? echo printMessages()?>
						<div class='block'>
							<div class='blockTitle'>
								<?echo $topTitle?>
								
							</div>
							<div class='blockBody'>
								<?
									echo $content;
								?>
							</div>
						</div>
					
					


	</div>
		  
         <div id="footer">
             <div id="left_footer">Email: anas. shehade @ yahoo. com</div>
			 <div id="left_footer">ahmadkhw22 @ yahoo. com</div>
			 <div id="left_footer">osamasw22 @ yahoo. com</div>
            
	     </div>
    </div>
	
			</body>
			
		</html>
	<?

	}

?>