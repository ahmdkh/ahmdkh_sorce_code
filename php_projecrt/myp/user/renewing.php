<?
     $dots='../';
	
	include_once($dots.'classes/config.php');
       
	   if ($_POST['submitForm'])
	   {
if (!dbNumRows('person_disibility', '`Person_ID` like "'.mysql_real_escape_string($_POST['Person_ID']).'"   

 and `Id_card_disability` like "'.mysql_real_escape_string($_POST['Id_card_disability']).'"  '))
      
{
      errorMessage('المعلومات المدخلة خاطئة');
       
		redirect($dots.'index.php');
      


	  
	  
}
 
 else
 {
 
  //$resul=dbQuery('select * from `person_disibility` where   `Id_card_disability` like "'.mysql_real_escape_string($_POST['Id_card_disability']).'"  ')
 
 
 

   
   $result=dbQuery('SELECT Card_End_Date FROM `person_disibility`  where  `Id_card_disability` like "'.mysql_real_escape_string($_POST['Id_card_disability']).'" ');
   
     $arr = mysql_fetch_array($result);
    $en=date('Y-m-d');
	
	if(strtotime($arr[Card_End_Date])>strtotime($en))
   {
   errorMessage('لم تنتهي فترة الصلاحية');
   redirect($dots.'index.php');
   
   
   }
 
 else
 
 {
  $end=(date("Y")+5).date("m").date("d");
 
 dbUpdate('person_disibility',array('Card_End_Date'),array($end),'Id_card_disability='.$_POST['Id_card_disability']);
  
  successMessage('تم تجديد البطاقة ' );
		redirect($dots.'index.php');
 
 
 }
 
 
 }
 


}







	$content = '<form action="'.$_SERVER['PHP_SELF'].'" method="POST">';
	$topTitle = 'تجديد بطاقة المعاق';
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
			<input type="submit" name="submitForm" class="submitInput" value="تجديد بطاقة المعاق" />
		</div>
		<div class="clear">
		</div>
	</div>';
	$content.= '</form>';
	
view();
	?>

	