<?
	$dots='../';
	include_once($dots.'classes/config.php');
	
	
	$town = array(1 =>"دمشق", "حلب","الاذقية",
    "حمص", "ادلب", "دبر الزور","الحسكة",
    "حماة", "ريف دمشق", "طرطوس",
    "درعا", "الرقة");
	
		$Disability = array(1 =>"جهاز سمع", "عكاز","كرسي متحرك",
    "زراعة قوقعة", "عصا بيضاء ", "طرف صناعي","لايوجد");
		
		$Disability1 = array(1 =>" سمعي", "بصري","شلل دماغي",
        "حركي", " بكم" );
			
	if ($_POST['submitForm'])
	{
	
	if(empty($_POST['Applicants_First_Name']))
	   {
	   errorMessage("Enter All the Filed");
	   redirect('signUp.php');
	   }
	 
	 else
	
	if(empty($_POST['Applicants_Last_Name']))
	   {
	 errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
	else
	if(empty($_POST['Applicants_father_Name']))
	   {
	   errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
	else
	 
	if(empty($_POST['Person_ID']))
	   {
	   errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
	else
	If(empty($_POST['Disabled_First_Name']))
	   {
	    errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
	else
	If(empty($_POST['Disabled_First_Name']))
	   {
	   errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
	 else 
    
	If(empty($_POST['Disabled_Last_Name']))
	   {
	    errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
     else	 
	If(empty($_POST['Disabled_Father_Name']))
	   {
	    errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
     else	 
	If(empty($_POST['Passport_ID']))
	   {
	    errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
	 else	 
	If(empty($_POST['Passport_Place']))
	   {
	  errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
	   
	 else	 
	
	If(empty($_POST['Street_name']))
	   {
	 errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
	
	If(empty($_POST['Building_ID']))
	   {
	    errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
	else
	If(empty($_POST['Building_ID']))
	   {
	   errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
	
	else
	If(empty($_POST['Specialty']))
	   {
	   errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
   	else
	If(empty($_POST['Mobile_ID']))
	   {
	  errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
	else
	If(empty($_POST['Doctor_father_Name']))
	   {
	   errorMessage("Enter All the Filed");;
	    redirect('signUp.php');
	   }
	else
	If(empty($_POST['Doctor_First_Name']))
	   {
	   errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
	else
	If(empty($_POST['Doctor_Last_Name']))
	   {
	    errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
	   
	else
	If(empty($_POST['Gender']))
	   {
	   errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
	else
	If(empty($_POST['Student']))
	   {
	    errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
	else
	If(empty($_POST['Work']))
	   {
	   errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
	else
	If(empty($_POST['Student1']))
	   {
	   errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	   }
   $f=1;
	   for($n=1;$n<=6;$n++)
	{
	  if(empty($_POST['$Disability[$n]']))  
      	  
		 $s=1;
	  else 
	  
	  $f=1;
	
	}
	if($f!=1)
	{
	  errorMessage("Enter All the Filed");
	    redirect('signUp.php');
	}
	$phone = preg_replace("/[ )(.-]/","",$_POST['phone_ID']);
	$phone = preg_replace("/[ )(.-]/","",$_POST['Mobile_ID']);
	
	$Applicants_First_Name = trim($_POST['Applicants_First_Name']);
	$Applicants_Last_Name = trim($_POST['Applicants_Last_Name']);
	$Applicants_father_Name = trim($_POST['Applicants_father_Name']);
	$Person_ID = trim($_POST['Person_ID']);
	$Disabled_First_Name=trim($_POST['Disabled_First_Name']);
	$Disabled_Last_Name=trim($_POST['Disabled_Last_Name']);
	$Disabled_father_Name=trim($_POST['Disabled_Father_Name']);
	$Passport_ID=trim($_POST['Passport_ID']);
	$Passport_Place=trim($_POST['Passport_Place']);
	$Street_name=trim($_POST['Street_name']);
	$Doctor_First_Name=trim($_POST['Doctor_First_Name']);
    $Doctor_father_Name=trim($_POST['Doctor_father_Name']);
	$Doctor_Last_Name=trim($_POST['Doctor_Last_Name']);
	$Specialty=trim($_POST['Specialty']);
	$Phone_ID=trim($_POST['Phone_ID']);
    $Mobile_ID=trim($_POST['Mobile_ID']);
	$Email=trim($_POST['Email']);
	
	    //$Applicants_First_Name= mysql_real_escape_string($Applicants_First_Name);
	    //$Applicants_Last_Name= mysql_real_escape_string($Applicants_Last_Name);
        //$Applicants_father_Name= mysql_real_escape_string($Applicants_father_Name);	
	    //$Person_ID = mysql_real_escape_string($Person_ID);
	   // $Disabled_First_Name=mysql_real_escape_string($Disabled_First_Name);
	    //$Disabled_Last_Name=mysql_real_escape_string($Disabled_Last_Name);
	    //$Disabled_father_Name=mysql_real_escape_string(  $Disabled_Father_Name);
	    //$Passport_ID=mysql_real_escape_string( $Passport_ID);
	    //$Passport_Place=mysql_real_escape_string($_POST[ $Passport_Place]);
	    //$Street_name=mysql_real_escape_string($_POST[$Street_name]);
	    //$Doctor_First_Name=mysql_real_escape_string($Doctor_First_Name);
	    //$Doctor_Last_Name=mysql_real_escape_string ($Doctor_Last_Name);
	    //$Doctor_father_Name=mysql_real_escape_string($Doctor_father_Name);
	    //$Specialty==mysql_real_escape_string( $Specialty);
	    //$Email=mysql_real_escape_string($_POST['Email']);
        //$Mobile_ID=mysql_real_escape_string($_POST['Mobile_ID']);
	    //$Phone_ID=mysql_real_escape_string($_POST['Phone_ID']);
	  
	    if (!myReg::isMail($_POST['Email']))
		{
			errorMessage('الإيميل يجب أن يكون بالصيغة الصحيحة');
		      redirect('signUp.php');
		}
      	
	  
	  
	    if (!myReg::isInteger ($_POST['Mobile_ID']))
	      {
		  errorMessage('رقم الموبايل الذي ادخلته خاطئ');
		   redirect('signUp.php');
		  }
	  
	   if (!myReg::isInteger ($_POST['Phone_ID']))
	      {
		  errorMessage('رقم الهاتف الذي ادخلته خاطئ');
		   redirect('signUp.php');
		  }
	  
	   if (!myReg::isInteger ($_POST['Passport_ID']))
	      {
		  errorMessage('رقم جواز السفر خاطئ');
		   redirect('signUp.php');
		  }
	   if (!myReg::isInteger ($_POST['Person_ID']))
	      {
		  errorMessage('الرقم الوطني خاطئ');
		   redirect('signUp.php');
		  }
	
	
	
	
 
   
    $table1=array("Applicants_First_Name"=> $Applicants_First_Name,"Applicants_Last_Name"=>$Applicants_Last_Name,"Applicants_father_Name"=>$Applicants_father_Name
	       ,"Person_ID"=>$Person_ID);
	       
    $table2=array("Disabled_First_Name"=>$Disabled_First_Name,"Disabled_Last_Name"=>$Disabled_Last_Name,"Disabled_Father_Name"=>$Disabled_Father_Name
	       ,"Doctor_First_Name"=>$Doctor_First_Name,"Doctor_Last_Name"=>$Doctor_Last_Name,"Doctor_father_Name"=>$Doctor_father_Name,"Specialty"=>$Specialty); 
                     
           
		  

		   
	  
	  
			$today = date("Y m d");
    
		   $end=date("Y+5 m d");
	
	 
	
      
	        if(dbNumRows('person_disibility','`Disabled_First_Name` like "'.$Disabled_First_Name.'" and `Disabled_Last_Name` like "'.$Disabled_Last_Name.'" and`Disabled_Father_Name` like "'.$Disabled_Father_Name.'" '))
	  
	        {
            
        			errorMessage('المعاق مسجل مسبقا في الموقع');
		             redirect('signUp.php');
			
			} 			
	  
			$date1=$_POST['dateYear'].$_POST['dateMo'].$_POST['dateDay'];
			$date2=$_POST['dateyearpass']. $_POST['dateMOpass']. $_POST['dateDaypass'];
			$date3=$_POST['dateYearcheck'].$_POST['dateMOcheck'].$_POST['dateDaycheck'];
			$date1=(string)$date1;
			$date2=(string)$date2;
			$date3=(string)$date3;
			dbInsert('person_disibility',array('Applicants_First_Name', 'Applicants_father_Name', 'Applicants_Last_Name','Person_ID','Gender'
			,'Passport_ID','Passport_Place','Disabled_First_Name','Disabled_Last_Name','Disabled_Father_Name','Student',
			'Work','Street_name','Building_ID','Phone_ID','Mobile_ID','Email','Doctor_First_Name','Doctor_Last_Name','Doctor_father_Name',
			'Specialty','Need _facility','BirthDate','Passport_Date','Town_name','Checking_Date','id','Card_Release_Date', 'Card_Release_Date')
			, array($Applicants_First_Name, $Applicants_father_Name, $Applicants_Last_Name,$Person_ID,$_POST['Gender'],
	        $Passport_ID,$Passport_Place,$Disabled_First_Name,$Disabled_Last_Name,$Disabled_Father_Name
			,$_POST['Student'],$_POST['Work'],$Street_name,$Building_ID,$Phone_ID,$Mobile_ID,$Email,$Doctor_First_Name,$Doctor_Last_Name
			,$Doctor_Father_Name,$Specialty,$_POST['Student1'],$date1,$date2,$_POST['twon1'],$date3,$_POST['orgnization'],$today,$end
			));
			
			$x=dbQuery('select Id_card_disability from person_disibility where Person_ID='.$_POST['Person_ID']);
			
			$arr=mysql_fetch_array($x);
			
			foreach( $_POST['Disability'] as $keyname => $valuename )
			{
			dbInsert('hinder disabled',array('Id_card_disability','Disability_id'),array($arr['Id_card_disability'],$valuename));
			}
			foreach(  $_POST['Disability1'] as $keyname => $valuename )
			{
			dbInsert('device_disabled',array('Id_card_disability','ID_device'),array($arr['Id_card_disability'],$valuename));
			}
			
			successMessage('تم تسجيلك في الموقع بنجاح');
			redirect('signUp.php');																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																											
	
	      
	  
	  
	  
	  }
	
	
	$content = '<form action="'.$_SERVER['PHP_SELF'].'" method="POST">';
	$topTitle = 'التسجيل في الموقع';
	$content.= '<div>';
	$content.= '<div class="row1">';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			اسم مقدم الطلب
		</div>
		<div class="cell">
			<input type="text" name="Applicants_First_Name"  class="niceInput" value="'.$_POST['Applicants_First_Name'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			كنية مقدم الطلب
		</div>
		<div class="cell">
			<input type="text" name="Applicants_Last_Name"  class="niceInput" value="'.$_POST['Applicants_Last_Name'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			اسم الاب لمقدم الطلب
		</div>
		<div class="cell">
			<input type="text" name="Applicants_father_Name"  class="niceInput" value="'.$_POST['Applicants_father_Name'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			الرقم الوطني 
		</div>
		<div class="cell">
			<input type="text" name="Person_ID" class="niceInput"  value="'.$_POST['Person_ID'].'" />
		</div>
		<div class="clear">
		</div>
	</div>
	';
	
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
	                اسم المعاق 
		</div>
		<div class="cell">
			<input type="text" name="Disabled_First_Name"  class="niceInput" value="'.$_POST['Disabled_First_Name'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	
	
	
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
	              الكنية
		</div>
		<div class="cell">
			<input type="text" name="Disabled_Last_Name"  class="niceInput" value="'.$_POST['Disabled_Last_Name'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	
	
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
	              اسم الاب
		</div>
		<div class="cell">
			<input type="text" name="Disabled_Father_Name"  class="niceInput" value="'.$_POST['Disabled_Father_Name'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
	          الجنس
		</div>
		<div class="cell">
		     <input type="radio" class="niceInput" name="Gender"value="male"/>ذكر
             <input type="radio" class="niceInput" name="Gender"value="fmale"/>انثى
			 </div>
	    <div class="clear">
			
	  </div>
	</div>';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
	              رقم جواز السفر  
		</div>
		<div class="cell">
			<input type="text" name="Passport_ID"  class="niceInput" value="'.$_POST['Passport_ID'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
	              مكان جواز السفر  
		</div>
		<div class="cell">
			<input type="text" name="Passport_Place"  class="niceInput" value="'.$_POST['Passport_Place'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
	         طالب
		</div>
		<div class="cell">
		     <input type="radio" name="Student"value="yes"/>نعم
             <input type="radio" name="Student"Value="no"/>لا
			 </div>
	    <div class="clear">
			
	  </div>
	</div>';
$content.= '
	<div class="row">
		<div class="cell inputCaption">
	         يعمل
		</div>
		<div class="cell">
		     <input type="radio" name="Work"value="yes"/>نعم
             <input type="radio" name="Work"value="no"/>لا
			 </div>
	    <div class="clear">
			
	  </div>
	</div>';
$content.= '
	<div class="row">
		<div class="cell inputCaption">
	             اسم الشارع
		</div>
		<div class="cell">
			<input type="text" name="Street_name"  class="niceInput" value="'.$_POST['Street_name'].'" />
		</div>
			<div class="clear">
			</div>
			</div>';
$content.= '
	<div class="row">
		<div class="cell inputCaption">
	            رقم البناء
		</div>
		<div class="cell">
			<input type="text" name="Building_ID"  class="niceInput" value="'.$_POST['Building_ID'].'" />
		</div>
			<div class="clear">
			</div>
			</div>';
$content.= '
	<div class="row">
		<div class="cell inputCaption">
	            رقم الهاتف
		</div>
		<div class="cell">
			<input type="text" name="Phone_ID"  class="niceInput" value="'.$_POST['Phone_ID'].'" />
		</div>
			<div class="clear">
			</div>
			</div>';
$content.= '
	<div class="row">
		<div class="cell inputCaption">
	           رقم الموبايل
		</div>
		<div class="cell">
			<input type="text" name="Mobile_ID"  class="niceInput" value="'.$_POST['Mobile_ID'].'" />
		</div>
			<div class="clear">
			</div>
			</div>';
$content.= '
	<div class="row">
		<div class="cell inputCaption">
	           الايميل
		</div>
		<div class="cell">
			<input type="text" name="Email"  class="niceInput" value="'.$_POST['Email'].'" />
		</div>
			<div class="clear">
			</div>
			</div>';
			$content.= '</div>';
			$content.= '<div class="row2">';
			$content.= '
	<div class="row">
		<div class="cell inputCaption">
	           اسم الطبيب
		</div>
		<div class="cell">
			<input type="text" name="Doctor_First_Name"  class="niceInput" value="'.$_POST['Doctor_First_Name'].'" />
		</div>
			<div class="clear">
			</div>
			</div>';
			
			
			$content.= '
			<div class="row">
		<div class="cell inputCaption">
		اسم الاب
		</div>
		
		<div class="cell">
			<input type="text" name="Doctor_father_Name"  class="niceInput" value="'.$_POST['Doctor_father_Name'].'" />
		</div>
			<div class="clear">
			</div>
			</div>';
			
			
			$content.= '
			<div class="row">
		<div class="cell inputCaption">
		الكنية
		</div>		
		<div class="cell">
			<input type="text" name="Doctor_Last_Name"  class="niceInput" value="'.$_POST['Doctor_Last_Name'].'" />
		</div>
			<div class="clear">
			</div>
			</div>';
	
			$content.= '
			<div class="row">
		<div class="cell inputCaption">
	                 التخصص
		</div>
		
		<div class="cell">
			<input type="text" name="Specialty"  class="niceInput" value="'.$_POST['Specialty'].'" />
		</div>
			<div class="clear">
			</div>
			</div>';		
	
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
	         بحاجة الى مرفق
		</div>
		<div class="cell">
		     <input type="radio" name="Student1"value="yes"/>نعم
             <input type="radio" name="Student1"Value="no"/>لا
			 </div>
	    <div class="clear">
			
	  </div>
	</div>';
	

	
	

	$content.= '
	<div class="row">
		<div class="cell inputCaption">
		تاريخ الميلاد 
		</div>
		<div class="cell">
			<select  name="dateMO" class="niceInput" >
			
		<option value=1>1</option>
        <option value=2>2</option>
        <option value=3>3</option>
		<option value=4>4</option>
		<option value=5>5</option>
		<option value=6>6</option>
		<option value=7>7</option>
		<option value=8>8</option>
		<option value=9>9</option>
		<option value=10>10</option>
		<option value=1>11</option>
		<option value=12>12</option>
	    </select>
		
		<select name="dateDay" class="niceInput">
		
		
		
	
        <option value=1>1</option>;
        <option value=2>2</option>;
		<option value=3>3</option>;
		<option value=4>4</option>;
        <option value=5>5</option>;
	    <option value=6>6</option>;
	    <option value=7>7</option>;
	    <option value=8>8</option>;
	    <option value=9>9</option>;
	    <option value=10>10</option>;
	    <option value=11>11</option>; 
	    <option value=12>12</option>;
	    <option value=13>13</option>;
	    <option value=14>14</option>;
	    <option value=15>15</option>;
	    <option value=16>16</option>;
	    <option value=17>17</option>;
	    <option value=18>18</option>;
        <option value=19>19</option>;
        <option value=20>20</option>;
        <option value=21>21</option>;
        <option value=22>22</option>;
        <option value=23>23</option>;
        <option value=24>24</option>;
        <option value=26>26</option>;
        <option value=27>27</option>;
        <option value=28>28</option>;
        <option value=29>29</option>;
        <option value=30>30</option>;
        <option value=31>31</option>;
 

	    </select>
		
		<select name="dateYear" class="niceInput">
		
<option value=1930>1930</option>
<option value=1931>1931</option>
<option value=1932>1932</option>
<option value=1933>1933</option>
<option value=1934>1934</option>
<option value=1935>1935</option>
<option value=1936>1936</option>
<option value=1937>1937</option>
<option value=1938>1938</option>
<option value=1939>1939</option>
<option value=1940>1940</option>
<option value=1941>1941</option>
<option value=1942>1942</option>
<option value=1943>1943</option>
<option value=1944>1944</option>
<option value=1945>1945</option>
<option value=1946>1946</option>
<option value=1947>1947</option>
<option value=1948>1948</option>
<option value=1949>1949</option>
<option value=1950>1950</option>
<option value=1951>1951</option>
<option value=1952>1952</option>
<option value=1953>1953</option>
<option value=1954>1954</option>
<option value=1955>1955</option>
<option value=1956>1956</option>
<option value=1957>1957</option>
<option value=1958>1958</option>
<option value=1959>1959</option>
<option value=1960>1960</option>
<option value=1961>1961</option>
<option value=1962>1962</option>
<option value=1963>1963</option>
<option value=1964>1964</option>
<option value=1965>1965</option>
<option value=1966>1966</option>
<option value=1967>1967</option>
<option value=1968>1968</option>
<option value=1969>1969</option>
<option value=1970>1970</option>
<option value=1971>1971</option>
<option value=1972>1972</option>
<option value=1973>1973</option>
<option value=1974>1974</option>
<option value=1975>1975</option>
<option value=1976>1976</option>
<option value=1977>1977</option>
<option value=1978>1978</option>
<option value=1979>1979</option>
<option value=1980>1980</option>
<option value=1981>1981</option>
<option value=1982>1982</option>
<option value=1983>1983</option>
<option value=1984>1984</option>
<option value=1985>1985</option>
<option value=1986>1986</option>
<option value=1987>1987</option>
<option value=1988>1988</option>
<option value=1989>1989</option>
<option value=1990>1990</option>
<option value=1991>1991</option>
<option value=1992>1992</option>
<option value=1993>1993</option>
<option value=1994>1994</option>
<option value=1995>1995</option>
<option value=1996>1996</option>
<option value=1997>1997</option>
<option value=1998>1998</option>
<option value=1999>1999</option>
<option value=2000>2000</option>
<option value=2001>2001</option>
<option value=2002>2002</option>
<option value=2003>2003</option>
<option value=2004>2004</option>
<option value=2005>2005</option>
<option value=2006>2006</option>
<option value=2007>2007</option>
<option value=2008>2008</option>
<option value=2009>2009</option>
<option value=2010>2010</option>
<option value=2011>2011</option>

							
						</select>
		</div>
			<div class="clear">
			</div>
	</div>';
	
	
	



	
	
		
	
	
	
	
	$content.='
	
	<div class="row">
	<div class="cell inputCaption">
	                	     
         تاريخ اصدار الجواز  
		
		</div>
		<div class="cell">
	

		  
		 
		 <select name="dateMOpass">
		 
		<option value=1>1</option>
        <option value=2>2</option>
        <option value=3>3</option>
		<option value=4>4</option>
		<option value=5>5</option>
		<option value=6>6</option>
		<option value=7>7</option>
		<option value=8>8</option>
		<option value=9>9</option>
		<option value=10>10</option>
		<option value=1>11</option>
		<option value=12>12</option>
	    </select>
		
		<select name="dateDaypass">
		
		
		
	
        <option value=1>1</option>;
        <option value=2>2</option>;
		<option value=3>3</option>;
		<option value=4>4</option>;
        <option value=5>5</option>;
	    <option value=6>6</option>;
	    <option value=7>7</option>;
	    <option value=8>8</option>;
	    <option value=9>9</option>;
	    <option value=10>10</option>;
	    <option value=11>11</option>; 
	    <option value=12>12</option>;
	    <option value=13>13</option>;
	    <option value=14>14</option>;
	    <option value=15>15</option>;
	    <option value=16>16</option>;
	    <option value=17>17</option>;
	    <option value=18>18</option>;
        <option value=19>19</option>;
        <option value=20>20</option>;
        <option value=21>21</option>;
        <option value=22>22</option>;
        <option value=23>23</option>;
        <option value=24>24</option>;
        <option value=26>26</option>;
        <option value=27>27</option>;
        <option value=28>28</option>;
        <option value=29>29</option>;
        <option value=30>30</option>;
        <option value=31>31</option>;
 

	    </select>
		
		<select name="dateYearpass">
		
<option value=1930>1930</option>
<option value=1931>1931</option>
<option value=1932>1932</option>
<option value=1933>1933</option>
<option value=1934>1934</option>
<option value=1935>1935</option>
<option value=1936>1936</option>
<option value=1937>1937</option>
<option value=1938>1938</option>
<option value=1939>1939</option>
<option value=1940>1940</option>
<option value=1941>1941</option>
<option value=1942>1942</option>
<option value=1943>1943</option>
<option value=1944>1944</option>
<option value=1945>1945</option>
<option value=1946>1946</option>
<option value=1947>1947</option>
<option value=1948>1948</option>
<option value=1949>1949</option>
<option value=1950>1950</option>
<option value=1951>1951</option>
<option value=1952>1952</option>
<option value=1953>1953</option>
<option value=1954>1954</option>
<option value=1955>1955</option>
<option value=1956>1956</option>
<option value=1957>1957</option>
<option value=1958>1958</option>
<option value=1959>1959</option>
<option value=1960>1960</option>
<option value=1961>1961</option>
<option value=1962>1962</option>
<option value=1963>1963</option>
<option value=1964>1964</option>
<option value=1965>1965</option>
<option value=1966>1966</option>
<option value=1967>1967</option>
<option value=1968>1968</option>
<option value=1969>1969</option>
<option value=1970>1970</option>
<option value=1971>1971</option>
<option value=1972>1972</option>
<option value=1973>1973</option>
<option value=1974>1974</option>
<option value=1975>1975</option>
<option value=1976>1976</option>
<option value=1977>1977</option>
<option value=1978>1978</option>
<option value=1979>1979</option>
<option value=1980>1980</option>
<option value=1981>1981</option>
<option value=1982>1982</option>
<option value=1983>1983</option>
<option value=1984>1984</option>
<option value=1985>1985</option>
<option value=1986>1986</option>
<option value=1987>1987</option>
<option value=1988>1988</option>
<option value=1989>1989</option>
<option value=1990>1990</option>
<option value=1991>1991</option>
<option value=1992>1992</option>
<option value=1993>1993</option>
<option value=1994>1994</option>
<option value=1995>1995</option>
<option value=1996>1996</option>
<option value=1997>1997</option>
<option value=1998>1998</option>
<option value=1999>1999</option>
<option value=2000>2000</option>
<option value=2001>2001</option>
<option value=2002>2002</option>
<option value=2003>2003</option>
<option value=2004>2004</option>
<option value=2005>2005</option>
<option value=2006>2006</option>
<option value=2007>2007</option>
<option value=2008>2008</option>
<option value=2009>2009</option>
<option value=2010>2010</option>
<option value=2011>2011</option>

		
		</select>
	 
	 </div>
			<div class="clear">
			</div>
	</div>';
	 
			$content.='
	
    	<div class="row">
	   <div class="cell inputCaption">
	                	     
          المحافظة  
		
		</div>
		<div class="cell">
	  
	  
		  

     
     	 
				
	
	</select>
		
	<select name="twon1">;
      <option>  دمشق </option>  
        <option> حمص</option>   
	 <option > حلب</option>	
	 <option >  ادلب</option>	
     <option > ريف دمشق</option> 
     <option>القنيطرة</option>		
	 <option> طرطوس</option>
     <option> اللاذقية</option>
	 <option> حماة</option>
     <option> درعا</option>
     <option> السويداء</option>	
	 <option> الرقة</option>
	 <option> دير الزور</option>
	 <option> الحسكة</option>
	</select>
     </div>
			<div class="clear">
			</div>
	 </div>';






	$content.='
	<div class="row">
	<div class="cell inputCaption">
	                	     
      تاريخ الفحص الطبي
		
		</div>
		<div class="cell">

		 
		 <select name="dateMOcheck">
		 
		<option value=1>1</option>
        <option value=2>2</option>
        <option value=3>3</option>
		<option value=4>4</option>
		<option value=5>5</option>
		<option value=6>6</option>
		<option value=7>7</option>
		<option value=8>8</option>
		<option value=9>9</option>
		<option value=10>10</option>
		<option value=1>11</option>
		<option value=12>12</option>
	    </select>
		
		<select name="dateDaycheck">
		
		
		
	
        <option value=1>1</option>;
        <option value=2>2</option>;
		<option value=3>3</option>;
		<option value=4>4</option>;
        <option value=5>5</option>;
	    <option value=6>6</option>;
	    <option value=7>7</option>;
	    <option value=8>8</option>;
	    <option value=9>9</option>;
	    <option value=10>10</option>;
	    <option value=11>11</option>; 
	    <option value=12>12</option>;
	    <option value=13>13</option>;
	    <option value=14>14</option>;
	    <option value=15>15</option>;
	    <option value=16>16</option>;
	    <option value=17>17</option>;
	    <option value=18>18</option>;
        <option value=19>19</option>;
        <option value=20>20</option>;
        <option value=21>21</option>;
        <option value=22>22</option>;
        <option value=23>23</option>;
        <option value=24>24</option>;
        <option value=26>26</option>;
        <option value=27>27</option>;
        <option value=28>28</option>;
        <option value=29>29</option>;
        <option value=30>30</option>;
        <option value=31>31</option>;
 

	    </select>
		
		<select name="dateYearcheck">
		
<option value=1930>1930</option>
<option value=1931>1931</option>
<option value=1932>1932</option>
<option value=1933>1933</option>
<option value=1934>1934</option>
<option value=1935>1935</option>
<option value=1936>1936</option>
<option value=1937>1937</option>
<option value=1938>1938</option>
<option value=1939>1939</option>
<option value=1940>1940</option>
<option value=1941>1941</option>
<option value=1942>1942</option>
<option value=1943>1943</option>
<option value=1944>1944</option>
<option value=1945>1945</option>
<option value=1946>1946</option>
<option value=1947>1947</option>
<option value=1948>1948</option>
<option value=1949>1949</option>
<option value=1950>1950</option>
<option value=1951>1951</option>
<option value=1952>1952</option>
<option value=1953>1953</option>
<option value=1954>1954</option>
<option value=1955>1955</option>
<option value=1956>1956</option>
<option value=1957>1957</option>
<option value=1958>1958</option>
<option value=1959>1959</option>
<option value=1960>1960</option>
<option value=1961>1961</option>
<option value=1962>1962</option>
<option value=1963>1963</option>
<option value=1964>1964</option>
<option value=1965>1965</option>
<option value=1966>1966</option>
<option value=1967>1967</option>
<option value=1968>1968</option>
<option value=1969>1969</option>
<option value=1970>1970</option>
<option value=1971>1971</option>
<option value=1972>1972</option>
<option value=1973>1973</option>
<option value=1974>1974</option>
<option value=1975>1975</option>
<option value=1976>1976</option>
<option value=1977>1977</option>
<option value=1978>1978</option>
<option value=1979>1979</option>
<option value=1980>1980</option>
<option value=1981>1981</option>
<option value=1982>1982</option>
<option value=1983>1983</option>
<option value=1984>1984</option>
<option value=1985>1985</option>
<option value=1986>1986</option>
<option value=1987>1987</option>
<option value=1988>1988</option>
<option value=1989>1989</option>
<option value=1990>1990</option>
<option value=1991>1991</option>
<option value=1992>1992</option>
<option value=1993>1993</option>
<option value=1994>1994</option>
<option value=1995>1995</option>
<option value=1996>1996</option>
<option value=1997>1997</option>
<option value=1998>1998</option>
<option value=1999>1999</option>
<option value=2000>2000</option>
<option value=2001>2001</option>
<option value=2002>2002</option>
<option value=2003>2003</option>
<option value=2004>2004</option>
<option value=2005>2005</option>
<option value=2006>2006</option>
<option value=2007>2007</option>
<option value=2008>2008</option>
<option value=2009>2009</option>
<option value=2010>2010</option>
<option value=2011>2011</option>	
		</select>
		</div>
			<div class="clear">
			</div>
	 </div>';
		
		
		;
	
	
			$content.=' 
			
			<div class="row">
	<div class="cell inputCaption">
	                	     
      نوع الجهاز الداعم للاعاقة
		
		</div>
		<div class="cell">
			
			
			
			
		  
	
		
         <input type="checkbox" name="Disability[]" value="1"> جهاز سمع</input>
         <input type="checkbox" name="Disability[]" value="2"> عكاز</input>
		 <input type="checkbox" name="Disability[]" value="3"> كرسي متحرك</input>	
		 <input type="checkbox" name="Disability[]" value="4">زراعة قوقعة </input>
		 <input type="checkbox" name="Disability[]" value="5"> عصا بيضاء</input>
		 <input type="checkbox" name="Disability[]" value="6"> طرف صناعي</input>
		 <input type="checkbox" name="Disability[]" value="7">لايوجد</input>
	  
      </div>
			<div class="clear">
			</div>
	 </div>';
	    
        
	  

				$content.='
				
				
				
			<div class="row">
	<div class="cell inputCaption">
	                	     
    نوع الاعاقة
		
		</div>
		<div class="cell">
		     

		<input type="checkbox" name="Disability1[]" value="1"> شلل دماغي</input>
         <input type="checkbox" name="Disability1[]" value="2"> بصري</input>
		 <input type="checkbox" name="Disability1[]" value="3"> سمعي</input>	
		 <input type="checkbox" name="Disability1[]" value="4">نطق</input>
		 <input type="checkbox" name="Disability1[]" value="5"> حركي</input>
		 <input type="checkbox" name="Disability1[]" value="6"> طرف صناعي</input>
		
		 </div>
			<div class="clear">
			</div>
	 
	    </div>';
		
		
		$content.='<div class="row">
	<div class="cell inputCaption">
	                	     
      جمعية الاعاقة
		
		</div>
		<div class="cell">
		  
        
		
		<input type="checkbox" name="orgnization[]" value="1">أمال</input>
        <input type="checkbox" name="orgnization[]" value="2">الصم البكم</input>  
		<input type="checkbox" name="orgnization[]" value="3">أمال</input> 
		<input type="checkbox" name="orgnization[]" value="4">أمال</input>
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
			<input type="submit" name="submitForm" class="submitInput" value="التسجيل في الموقع" />
		</div>
		<div class="clear">
		</div>
	</div>
	';
	
			$content.= '</div>';
$content.= '</div>';			
	$content.= '</form>';
	
	
	view();
		
		
		
?>