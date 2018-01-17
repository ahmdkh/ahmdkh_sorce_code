<?

	$dots='../';
	include($dots.'classes/config.php');
	///////////////////////////////////////////////////////
	
	 if ($_POST['submitForm'])
	{
	$bool=true;
		if (strlen($_POST['Type_Disability'])<1)
		{
			errorMessage('يجب إختيار نوع الإعاقه');
			redirect('search-for-job.php');
		}
		
		else
		
		if (strlen($_POST['study-type'])<1)
		{
			errorMessage('حقل نوع المؤهل فارغ يجبب تعبئه جميع الحقول');
			redirect('search-for-job.php');
		}
		
		else
		if (strlen($_POST['age'])<1)
		{
			errorMessage('حقل العمر قارغ يجب تعبئه جميع الحقول');
			redirect('search-for-job.php');
		}
	   else
		{
		
	
		 //$Type_Disability_S=serialize($Type_Disability);
		 if($_POST['Type_Work']=="gv")
		 {
	     $results = dbQuery('select * from `work_chance` where 
		 
		 `Name_qualified` like "'.mysql_real_escape_string($_POST['study-type']).'"
		 and 
		 `Age` like "'.mysql_real_escape_string($_POST['age']).'"
		 and 
		 `Company-type` like "'.mysql_real_escape_string("gv").'"
		 ');
		 }
		 else
		 {
		 $results = dbQuery('select * from `work_chance` where 
		 
		 `Name_qualified` like "'.mysql_real_escape_string($_POST['study-type']).'"
		 and 
		 `Age` like "'.mysql_real_escape_string($_POST['age']).'"
		 and 
		 `Company-type` like "'.mysql_real_escape_string("private").'"
		 ');
		 }
		 ////////////
		 if($_POST['Type_Work']=="gv")
		 {
		 ///////////////////////
		 
		  $content.= '
	      <div class="row bord">
		  <div class="cell inputCaption names">
			اسم العمل
		  </div>
		  <div class="cell inputCaption names">
			عدد ساعات العمل
		</div>
		
		  <div class="cell inputCaption names">
			عدد فرص العمل
		</div>
		<div class="cell inputCaption names">
			الراتب الشهري
		</div>
		  <div class="cell inputCaption names">
			اسم الوزاره
		 </div>
		 <div class="cell inputCaption names">
			اسم المؤسسه
		 </div>
		 <div class="cell inputCaption names">
			العنوان
		 </div>
		 
	    	
		
		
		
			<div class="clear">
			</div>
	</div>';
		 ///////////////////////
		 
		 while ($result = mysql_fetch_array($results))
	{
		 
		
		 
		 
		    for($i=0;$i<sizeof($Type_Disability);$i++)
		     {
			     
		        
				
				   if(strpos($result['Type_Disability'],$Type_Disability[$i]))
				          {$bool=false;break;}
				
		  
		     }
		  if($bool==true)
		  {
		  $content.= '
	      <div class="row bord">
		  <div class="cell inputCaption">
			'.$result['work_name'].'
		  </div>
		  <div class="cell inputCaption">
			'.$result['Work_hours'].'
		</div>
		
		  <div class="cell inputCaption">
			'.$result['Work_chance_count'].'
		</div>
		<div class="cell inputCaption">
			'.$result['Salary'].'
		</div>
		  <div class="cell inputCaption">
			'.$result['Ministry_name'].'
		 </div>
		 <div class="cell inputCaption">
			'.$result['Organization_name'].'
		 </div>
		 <div class="cell inputCaption">
			'.$result['address'].'
		 </div>
		 <div class="cell inputCaption">
		 <u>ارسل طلب</u>
		
		 </div>
		 
	    	
		
		
		
			<div class="clear">
			</div>
	</div>';
	}
	$bool=true;
	}
	}
	else
	{
	//////////////////////////////////
	
		  $content.= '
	      <div class="row bord">
		  <div class="cell inputCaption names">
			اسم العمل
		  </div>
		  <div class="cell inputCaption names">
			عددساعات العمل
		</div>
		
		  <div class="cell inputCaption names">
			عدد قرص العمل
		</div>
		<div class="cell inputCaption names">
			 الراتب الشهري
		</div>
		  
		 <div class="cell inputCaption names">
			العنوان
		 </div>
		
		
		
			<div class="clear">
			</div>
	</div>';
	//////////////////////////////////
		 while ($result = mysql_fetch_array($results))
	{
		  $dis=unserialize($result['Type_Disability']);
		 
		  
		     for($i=0;$i<sizeof($Type_Disability);$i++)
		     {
		        for($j=0;$j<sizeof($dis);$j++)
				{
				if($Type_Disability[$i]==$dis[$j])
				{$bool=false;break;}
				}
		  
		     }
		  if($bool==true)
		  {
		  $content.= '
	      <div class="row bord">
		  <div class="cell inputCaption">
			'.$result['work_name'].'
		  </div>
		  <div class="cell inputCaption">
			'.$result['Work_hours'].'
		</div>
		
		  <div class="cell inputCaption">
			'.$result['Work_chance_count'].'
		</div>
		<div class="cell inputCaption">
			'.$result['Salary'].'
		</div>
		  
		 <div class="cell inputCaption">
			'.$result['address'].'
		 </div>
		
		
		
			<div class="clear">
			</div>
	</div>';
	}
	$bool=true;
	}
	}
	
	////////////////////
	$topTitle = 'نتائج البحث عن فرصة عمل';
			view();
	////////////////////
		//redirect($dots.'index.php');
		
	}
	
	}
	//////////////////////////////////

	else
	{
	$content = '<form action="'.$_SERVER['PHP_SELF'].'" method="POST">';
	$topTitle = 'البحث عن فرصه عمل';
	
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			نوع الإعاقه المناسبه:
		</div>
		<div class="cell colore">
			<input type="checkbox" name="Type_Disability[]" class="niceInput" value="Deaf" />سمعي<br />
            <input type="checkbox" name="Type_Disability[]" class="niceInput" value="Blind" />بصري<br />
            <input type="checkbox" name="Type_Disability[]" class="niceInput" value="Cerebral" />دماغي<br />
            <input type="checkbox" name="Type_Disability[]" class="niceInput" value="Kinetic" />حركي<br />
            <input type="checkbox" name="Type_Disability[]" class="niceInput" value="Speechless" />بكم<br />

		</div>
			<div class="clear">
			</div>
	</div>';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			نوع القطاع:
		</div>
		<div class="cell colore">
			<input type="radio" name="Type_Work" class="niceInput" checked="checked" value="gv" />وظيفه حكوميه<br />
            <input type="radio" name="Type_Work" class="niceInput" value="sp" />وظيفة خاصه<br />
            

		</div>
			<div class="clear">
			</div>
	</div>';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			نوع المؤهل:
		</div>
		<div class="cell colore">
			<select  name="study-type" class="niceInput" value="'.$_POST['study-type'].'" >
							<option>إبتدائي</option>
							<option>اعدادي</option>
							<option>ثانوي</option>
							<option>معهد</option>
							<option>جامعه</option>
							<option>دراسات عليا</option>
							
							
						</select>
		</div>
			<div class="clear">
			</div>
	</div>';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			العمر المطلوب:
		</div>
		<div class="cell colore">
			<select  name="age" class="niceInput" value="'.$_POST['age'].'" >
							<option>18..20</option>
							<option>20..24</option>
							<option>24..30</option>
							<option>30..35</option>
							<option>35..40</option>
							<option>up40</option>
							
						</select>
		</div>
			<div class="clear">
			</div>
	</div>';
	
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			&nbsp;
		</div>
		<div class="cell colore">
			<input type="submit" name="submitForm" class="submitInput" value="بحث" />
		</div>
		<div class="clear">
		</div>
	</div>
	';
	$content.= '</form>';



	view();
	}
?>