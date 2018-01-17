<?

	$dots='../';
	include($dots.'classes/config.php');
	///////////////////////////////////
      if ($_POST['submitForm'])
	{
		if (dbNumRows('organization_donor', 'Organization_Name like "'.$_POST['name_office'].'"'))
		{
			errorMessage('اسم الجهة الذي أدخلته موجود مسبقا');
		}
		else
		if (strlen($_POST['name_office'])<1)
		{
			errorMessage(' حقل اسم الحهة فارغ يجب تعبه جميع الحقول');
		}
		else
		if (strlen($_POST['address_input'])<1)
		{
			errorMessage('حقل اسم العنوان  فارغ يجب تعبه جميع الحقول');
		}
		else
		if (!myReg::isInteger(($_POST['name_Commercial_record'])))
		{
			errorMessage('الرجاء ادخال ارقام حصرافي رقم السجل التجاري');
		}
		else
		if (strlen($_POST['name_Commercial_record'])<1)
		{
			errorMessage('حقل رقم السجل التجاري فارغ يجب تعبه جميع الحقول');
		}
		
		else
		
		if (!myReg::isInteger(($_POST['Phone_input'])))
		{
			errorMessage('الرجاء ادخال ارقام حصرافي رقم الهاتف');
		}
		else
		
		if (!myReg::isInteger(($_POST['name_Industrial_record'])))
		{
			errorMessage('الرجاء ادخال ارقام حصرافي رقم السجل الصناعي');
		}
		else
		if (strlen($_POST['name_Industrial_record'])<1)
		{
			errorMessage('حقل رقم السجل الصناعي فارغ يجب تعبه جميع الحقول');
		}
		else
		
		if ($_POST['password_input'] != $_POST['repassword_input'])
		{
			errorMessage('كلمة المرور وتأكيدها غير متطابقين');
		}
		else
		if (strlen($_POST['password_input'])<6)
		{
			errorMessage('يجب أن تكون كلمة المرور 6 محارف على الأقل');
		}
		else
		if (!myReg::isMail($_POST['mail_input']))
		{
			errorMessage('الإيميل يجب أن يكون بالصيغة الصحيحة');
		}
		
	else
		
		{
			dbInsert('organization_donor', array('Organization_Name','Street_name', 'phone','Governorate_name','Record_number_commercial','Record_number_industry', 'email', 'password'), array($_POST['name_office'], $_POST['address_input'], $_POST['Phone_input'], $_POST['name_Province'], $_POST['name_Commercial_record'], $_POST['name_Industrial_record'], $_POST['mail_input'],md5($_POST['password_input'])));
			successMessage('تم تسجيل شركتك الخاصه ضمن مو قعنا بنجاح');
			//redirect('signIn.php');
		}
	
	}
	//////////////////////////////////

	
	$content = '<form action="'.$_SERVER['PHP_SELF'].'" method="POST">';
	//$topTitle = 'تسجيل فرصه عمل';
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
			المحافظه
		</div>
		<div class="cell">
		<select  name="name_Province" class="niceInput" value="'.$_POST['name_Province'].'" >
							<option>حمص</option>
							<option>ادلب</option>
							<option>حماه</option>
							<option>دمشق</option>
							<option>درعا</option>
							<option>دير الزور</option>
							<option>حلب</option>
							<option>ريف دمشق</option>
							<option>الاذقيه</option>
							<option>الحسكه</option>
							<option>القنيطره</option>
							<option>السويداء</option>
							<option>طرطوس</option>
							<option>الرقه</option>
							
						</select>
			
		</div>
			<div class="clear">
			</div>
	</div>';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			العنوان
		</div>
		<div class="cell">
			<input type="text" name="address_input"  class="niceInput" value="'.$_POST['address_input'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			رقم السجل التجاري
		</div>
		<div class="cell">
			<input type="text" name="name_Commercial_record"  class="niceInput" value="'.$_POST['name_Commercial_record'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			رقم السجل الصناعي
		</div>
		<div class="cell">
			<input type="text" name="name_Industrial_record"  class="niceInput" value="'.$_POST['name_Industrial_record'].'" />
		</div>
			<div class="clear">
			</div>
	</div>';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			الإيميل
		</div>
		<div class="cell">
			<input type="text" name="mail_input" class="niceInput"  value="'.$_POST['mail_input'].'" />
		</div>
		<div class="clear">
		</div>
	</div>
	';
	$content.= '
	<div class="row">
		<div class="cell inputCaption">
			رقم الهاتف
		</div>
		<div class="cell">
			<input type="text" name="Phone_input"  class="niceInput" value="'.$_POST['Phone_input'].'" />
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
			إعادة كلمة المرور
		</div>
		<div class="cell">
			<input type="password" name="repassword_input" class="niceInput" />
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