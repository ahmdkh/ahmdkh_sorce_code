<?

	$dots='../';
	include($dots.'classes/config.php');
	///////////////////////////////////////////////////////
	 if ($_POST['submitForm'])
	{
		if (dbNumRows('work_chance', '`work_name` like "'.mysql_real_escape_string($_POST['name_work']).'" and
		`Company-type` like "'.mysql_real_escape_string("gv").'"
		'))
		{
			errorMessage('اسم العمل الذي أدخلته موجود مسبقاً');
		}
		else
		if (strlen($_POST['Organization_Name'])<1)
		{
			errorMessage('حقل اسم المؤسسه فارغ يجب تعبئه جميع الحقول');
		}
		else
		if (strlen($_POST['Ministry_name'])<1)
		{
			errorMessage('حقل اسم الوزاره فارغ يجب تعبئه جميع الحقول');
		}
		else
		if (strlen($_POST['name_work'])<1)
		{
			errorMessage(' حقل اسم العمل فارغ يجب تعبه جميع الحقول');
		}
		else
		
		if (strlen($_POST['num-hour-work'])<1)
		{
			errorMessage('حقل عدد  ساعات العمل قارغ يجب تعبئه جميع الحقول');
		}
		else
		
		if (!myReg::isInteger($_POST['num-hour-work']))
		{
			errorMessage('الرجاء ادخال ارقام حصرافي غدد ساعات العمل');
		}
		else
		if (strlen($_POST['Type_Disability'])<1)
		{
			errorMessage('يجب إختيار نوع الإعاقه');
		}
		
		else
		
		if (strlen($_POST['study-type'])<1)
		{
			errorMessage('حقل نوع المؤهل فارغ يجبب تعبئه جميع الحقول');
		}
		
		else
		if (strlen($_POST['salary'])<1)
		{
			errorMessage('حقل الراتب قارغ يجب تعبئه جميع الحقول');
		}
		else
		
		if (!myReg::isInteger($_POST['salary']))
		{
			errorMessage('الرجاء ادخال ارقام حصرافي غدد في الراتب');
		}
		
		else
		if (strlen($_POST['num-chance'])<1)
		{
			errorMessage('حقل عدد الفرص قارغ يجب تعبئه جميع الحقول');
		}
		else
		
		if (!myReg::isInteger($_POST['num-chance']))
		{
			errorMessage('الرجاء ادخال ارقام حصرافي غدد في عدد الفرص');
		}
		else
		if (strlen($_POST['num-chance'])<1)
		{
			errorMessage('حقل عدد الفرص قارغ يجب تعبئه جميع الحقول');
		}
		else
		if (strlen($_POST['address'])<1)
		{
			errorMessage('حقل عناون العمل قارغ يجب تعبئه جميع الحقول');
		}
		else
		if (strlen($_POST['age'])<1)
		{
			errorMessage('حقل العمر قارغ يجب تعبئه جميع الحقول');
		}
		else
		
		
	{
        $koko='ahmadk'.implode(',', $_POST['Type_Disability']);
        dbInsert('work_chance', array('Organization_name','Ministry_name','work_name','Work_chance_count','Work_hours','Name_qualified','Type_Disability','address', 'Salary','Age','Company-type'), 
		array(
        mysql_real_escape_string($_POST['Organization_Name']),
        mysql_real_escape_string($_POST['Ministry_name']),
        mysql_real_escape_string($_POST['name_work']),		
		mysql_real_escape_string($_POST['num-chance']),
		mysql_real_escape_string($_POST['num-hour-work']), 
		mysql_real_escape_string($_POST['study-type']), 
		mysql_real_escape_string($koko), 
		mysql_real_escape_string($_POST['address']),
		mysql_real_escape_string($_POST['salary']),
		mysql_real_escape_string($_POST['age']),
		mysql_real_escape_string("gv")
		)
		);
		successMessage('تم تسجيل فرصه عمل  لمؤسستك العامه ضمن موقعنا بنجاح');
		//redirect('signIn.php');
	}
	
	}
	//////////////////////////////////

	
	
	$content = '<form action="'.$_SERVER['PHP_SELF'].'" method="POST">';
	$topTitle = 'تسجيل فرصه عمل';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			اسم المؤسسة
		</div>
		<div class="cell">
			<input type="text" name="Organization_Name"  class="niceInput" value="'.$_POST['Organization_Name'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			اسم الوزاره
		</div>
		<div class="cell">
			<input type="text" name="Ministry_name"  class="niceInput" value="'.$_POST['Ministry_name'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			اسم العمل
		</div>
		<div class="cell">
			<input type="text" name="name_work"  class="niceInput" value="'.$_POST['name_work'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			عددساعات العمل
		</div>
		<div class="cell">
			<input type="text" name="num-hour-work"  class="niceInput" value="'.$_POST['num-hour-work'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			نوع الإعاقات الغير مناسبه
			
		</div>
		
		<div class="cell">
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
			نوع المؤهل
		</div>
		<div class="cell">
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
			الراتب
		</div>
		<div class="cell">
			<input type="text" name="salary"  class="niceInput" value="'.$_POST['salary'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			عدد الشواغر
		</div>
		<div class="cell">
			<input type="text" name="num-chance" class="niceInput"  value="'.$_POST['num-chance'].'" />
		</div>
		<div class="clear">
		</div>
	</div>
	';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			عنوان العمل
		</div>
		<div class="cell">
			<input type="text" name="address"  class="niceInput" value="'.$_POST['address'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			العمر
		</div>
		<div class="cell">
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
		<div class="cell">
			<input type="submit" name="submitForm" class="submitInput" value="التسجيل فرصة العمل" />
		</div>
		<div class="clear">
		</div>
	</div>
	';
	$content.= '</form>';



	view();
?>